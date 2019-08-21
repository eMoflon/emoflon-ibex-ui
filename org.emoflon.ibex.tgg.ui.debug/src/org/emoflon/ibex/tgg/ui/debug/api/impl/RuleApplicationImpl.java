package org.emoflon.ibex.tgg.ui.debug.api.impl;

import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;

public class RuleApplicationImpl implements RuleApplication {
    private int index;
    private Graph graph;

    public RuleApplicationImpl(int pIndex, Graph pObjectGraph) {
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
