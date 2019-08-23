package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;
import java.util.HashSet;

import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphImpl;

public class GraphBuilder {
    private Collection<Node> nodes = new HashSet<>();
    private Collection<Edge> edges = new HashSet<>();

    public GraphBuilder() {
    }

    public GraphBuilder(Graph pGraph) {
	addGraph(pGraph);
    }

    public GraphBuilder addGraph(Graph pGraph) {
	nodes.addAll(pGraph.getNodes());
	edges.addAll(pGraph.getEdges());
	return this;
    }

    public GraphBuilder addNode(Node pNode) {
	nodes.add(pNode);
	return this;
    }

    public GraphBuilder addNodes(Collection<Node> pNodes) {
	nodes.addAll(pNodes);
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
