package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class EObjectAdapter implements Node {

    private static Map<EObject, EObjectAdapter> wrappers = new HashMap<>();

    public static EObjectAdapter get(EObject pEObject) {
	return wrappers.get(pEObject);
    }

    public static EObjectAdapter adapt(EObject pEObject, Domain pDomain) {
	if (!wrappers.containsKey(pEObject))
	    wrappers.put(pEObject, new EObjectAdapter(pEObject, pDomain));
	return wrappers.get(pEObject);
    }

    // ----------

    private EObject object;

    private String label;
    private String index;
    private Domain domain;
    private List<String> attributes;

    private EObjectAdapter(EObject pObject, Domain pDomain) {
	object = pObject;

	label = pObject.eContainingFeature() != null ? object.eContainingFeature().getName() : "root";

	if (pObject.eContainer() == null) {
	    Resource resource = pObject.eResource();
	    index = resource.getResourceSet().getResources().indexOf(resource) + "_"
		    + resource.getContents().indexOf(pObject);
	} else {
	    EObject container = pObject.eContainer();
	    index = EObjectAdapter.adapt(container, domain).getIndex() + "_" + container.eContents().indexOf(pObject);
	}

	domain = pDomain;

	attributes = new ArrayList<>();
	for (EAttribute attr : object.eClass().getEAttributes())
	    attributes.add(attr.getEType().getName() + " " + attr.getName() + " = " + object.eGet(attr));
    }

    public String getIndex() {
	return index;
    }

    @Override
    public String getType() {
	return object.eClass().getName();
    }

    @Override
    public String getName() {
	return label + "_" + index + " : " + object.eClass().getName();
    }

    @Override
    public Domain getDomain() {
	return domain;
    }

    @Override
    public Action getAction() {
	return Action.CONTEXT;
    }

    @Override
    public List<String> getAttributes() {
	return attributes;
    }

    public static void constructGraphDomain(GraphBuilder pBuilder, Domain pDomain, Collection<EObject> pDomainObjects) {
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

    public static void constructCorrEdges(GraphBuilder pBuilder, Collection<EObject> pCorrObjects) {
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
}
