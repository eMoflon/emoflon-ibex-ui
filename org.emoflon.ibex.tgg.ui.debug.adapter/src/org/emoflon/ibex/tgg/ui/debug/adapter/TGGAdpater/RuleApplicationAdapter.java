package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class RuleApplicationAdapter implements RuleApplication {

    private static Map<ProtocolStep, RuleApplicationAdapter> wrappers = new HashMap<>();

    public static RuleApplicationAdapter adapt(ProtocolStep pProtocolStep) {
	if (!wrappers.containsKey(pProtocolStep))
	    wrappers.put(pProtocolStep, new RuleApplicationAdapter(pProtocolStep));
	return wrappers.get(pProtocolStep);
    }

    // ----------

    private int index;
    private Graph graph;

    private RuleApplicationAdapter(ProtocolStep pProtocolStep) {
	index = pProtocolStep.getIndex();
	GraphBuilder builder = new GraphBuilder();
	// TODO build graph
    }

    public RuleApplicationAdapter(int pIndex, Graph pObjectGraph) {
	index = pIndex;
	graph = pObjectGraph;
    }

    public int getIndex() {
	return index;
    }

    public Graph getGraph() {
	return graph;
    }
}
