package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;
import java.util.HashSet;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;

public class GraphBuilder {
    private Collection<Node> nodes = new HashSet<>();
    private Collection<Edge> edges = new HashSet<>();

    public GraphBuilder() {
    }

    public GraphBuilder(Graph pGraph) {
	addGraph(pGraph);
    }

    public GraphBuilder addGraph(Graph pGraph) {
	if (pGraph == null)
	    return this;
	nodes.addAll(pGraph.getNodes());
	edges.addAll(pGraph.getEdges());
	return this;
    }

    public GraphBuilder addNode(Node pNodeGroup) {
	nodes.add(pNodeGroup);
	return this;
    }

    public GraphBuilder addEdge(Edge pEdge) {
	edges.add(pEdge);
	return this;
    }

    public GraphBuilder addEdges(Collection<Edge> pEdges) {
	edges.addAll(pEdges);
	return this;
    }

    public GraphImpl build() {
	return new GraphImpl(nodes, edges);
    }
}
