package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;
import java.util.Collections;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;

public class GraphImpl implements Graph {
    private Collection<Collection<Node>> nodes;
    private Collection<Edge> edges;

    GraphImpl(Collection<Collection<Node>> pNodes, Collection<Edge> pEdges) {
	nodes = Collections.unmodifiableCollection(pNodes);
	edges = Collections.unmodifiableCollection(pEdges);
    }

    public Collection<Collection<Node>> getNodes() {
	return nodes;
    }

    public Collection<Edge> getEdges() {
	return edges;
    }
}
