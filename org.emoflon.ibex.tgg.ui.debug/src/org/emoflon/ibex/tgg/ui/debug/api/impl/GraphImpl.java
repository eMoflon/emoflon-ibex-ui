package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;
import java.util.Collections;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;

public class GraphImpl implements Graph {
    private Collection<Node> nodes;
    private Collection<Edge> edges;

    GraphImpl(Collection<Node> pNodes, Collection<Edge> pEdges) {
	nodes = Collections.unmodifiableCollection(pNodes);
	edges = Collections.unmodifiableCollection(pEdges);
    }

    public Collection<Node> getNodes() {
	return nodes;
    }

    public Collection<Edge> getEdges() {
	return edges;
    }
}
