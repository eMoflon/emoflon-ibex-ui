package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class ProtocolStepAdapter implements RuleApplication {

    private static Map<ProtocolStep, ProtocolStepAdapter> wrappers = new HashMap<>();

    public static ProtocolStepAdapter adapt(ProtocolStep pProtocolStep) {
	if (!wrappers.containsKey(pProtocolStep))
	    wrappers.put(pProtocolStep, new ProtocolStepAdapter(pProtocolStep));
	return wrappers.get(pProtocolStep);
    }

    // ----------

    private int index;
    private Graph graph;

    private ProtocolStepAdapter(ProtocolStep pProtocolStep) {
	index = pProtocolStep.getIndex();
	GraphBuilder builder = new GraphBuilder();

	constructGraphDomain(builder, Domain.SRC, pProtocolStep.getObjectGraph().getSrcElements());
	constructGraphDomain(builder, Domain.TRG, pProtocolStep.getObjectGraph().getTrgElements());
	constructCorrEdges(builder, pProtocolStep.getObjectGraph().getCorrElements());

	graph = builder.build();
    }

    private void constructGraphDomain(GraphBuilder pBuilder, Domain pDomain, Collection<EObject> pDomainObjects) {
	for (EObject object : pDomainObjects) {
	    pBuilder.addNode(EObjectAdapter.adapt(object, pDomain));
	    for (EObject contentObject : object.eContents()) {
		pBuilder.addEdge(contentObject.eContainingFeature().getName(), EObjectAdapter.get(object),
			EObjectAdapter.adapt(contentObject, pDomain), EdgeType.NORMAL, Action.CONTEXT);
	    }
	    for (EObject crossReference : object.eCrossReferences()) {
		pBuilder.addEdge(crossReference.eContainingFeature().getName(), EObjectAdapter.get(object),
			EObjectAdapter.adapt(crossReference, pDomain), EdgeType.NORMAL, Action.CONTEXT);
	    }
	}
    }

    private void constructCorrEdges(GraphBuilder pBuilder, Collection<EObject> pCorrObjects) {
	for (EObject corrObject : pCorrObjects) {
	    pBuilder.addEdge(":" + corrObject.eClass().getName(), //
		    EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("source")),
			    Domain.SRC), //
		    EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("target")),
			    Domain.TRG), //
		    EdgeType.CORR, //
		    Action.CONTEXT);
	}
    }

    public int getIndex() {
	return index;
    }

    public Graph getGraph() {
	return graph;
    }
}
