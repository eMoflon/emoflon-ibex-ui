package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class ProtocolStepAdapter implements RuleApplication {

    private static Map<ProtocolStep, ProtocolStepAdapter> wrappers = new HashMap<>();

    public static ProtocolStepAdapter adapt(ProtocolStep pProtocolStep) {
	if (!wrappers.containsKey(pProtocolStep))
	    wrappers.put(pProtocolStep, new ProtocolStepAdapter(pProtocolStep));
	return wrappers.get(pProtocolStep);
    }

    // ----------

    private ProtocolStep protocolStep;
    private Map<Integer, Graph> graphs = new HashMap<>();

    private ProtocolStepAdapter(ProtocolStep pProtocolStep) {
	protocolStep = pProtocolStep;
    }

    public int getIndex() {
	return protocolStep.getIndex();
    }

    public Graph getGraph(int pNeighbourhoodSize) {
	if (!graphs.containsKey(pNeighbourhoodSize))
	    buildGraph(pNeighbourhoodSize);
	return graphs.get(pNeighbourhoodSize);
    }

    private void buildGraph(int pNeighbourhoodSize) {
	GraphBuilder builder = new GraphBuilder();

	EObjectAdapter.constructGraphDomain(builder, Domain.SRC, VictoryIBeXAdapter
		.getNeighbourhood(protocolStep.getObjectGraph().getSrcElements(), pNeighbourhoodSize));
	EObjectAdapter.constructGraphDomain(builder, Domain.TRG, VictoryIBeXAdapter
		.getNeighbourhood(protocolStep.getObjectGraph().getTrgElements(), pNeighbourhoodSize));
	EObjectAdapter.constructCorrEdges(builder, protocolStep.getObjectGraph().getCorrElements());

	graphs.put(pNeighbourhoodSize, builder.build());
    }
}
