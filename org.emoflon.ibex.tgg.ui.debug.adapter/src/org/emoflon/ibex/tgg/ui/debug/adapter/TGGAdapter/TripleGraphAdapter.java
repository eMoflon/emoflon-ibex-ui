package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.TripleGraph;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class TripleGraphAdapter implements TripleGraph {
	
	private static Map<TGGObjectGraph, TripleGraphAdapter> wrappers = new HashMap<>();

	public static TripleGraphAdapter adapt(TGGObjectGraph tripleGraph) {
		if (!wrappers.containsKey(tripleGraph))
			wrappers.put(tripleGraph, new TripleGraphAdapter(tripleGraph));
		return wrappers.get(tripleGraph);
	}

	// ----------
	
	private TGGObjectGraph tripleGraph;
	
	private Graph graph = null;
	
	
	private TripleGraphAdapter(TGGObjectGraph tripleGraph) {
		this.tripleGraph = tripleGraph;
		this.graph = this.buildGraph();
	}


	@Override
	public Graph getGraph() {
		return this.graph;
	}
	
	private Graph buildGraph() {
		GraphBuilder builder = new GraphBuilder();
		EObjectAdapter.constructGraphDomain(builder, Domain.SRC, tripleGraph.getSrcElements());
		EObjectAdapter.constructGraphDomain(builder, Domain.TRG, tripleGraph.getTrgElements());
		EObjectAdapter.constructCorrEdges(builder, tripleGraph.getCorrElements());
		return builder.build();
	}
	
	

}
