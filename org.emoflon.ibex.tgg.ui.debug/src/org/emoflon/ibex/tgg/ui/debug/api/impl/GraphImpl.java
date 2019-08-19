package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;
import java.util.Collections;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;

public class GraphImpl implements Graph {
    private Collection<Node> src;
    private Collection<Node> trg;
    private Collection<Edge> corr;
    private Collection<Edge> edges;

    GraphImpl(Collection<Node> pSrc, Collection<Node> pTrg, Collection<Edge> pCorr, Collection<Edge> pEdges) {
	src = Collections.unmodifiableCollection(pSrc);
	trg = Collections.unmodifiableCollection(pTrg);
	corr = Collections.unmodifiableCollection(pCorr);
	edges = Collections.unmodifiableCollection(pEdges);
    }

    public Collection<Node> getSrc() {
	return src;
    }

    public Collection<Node> getTrg() {
	return trg;
    }

    public Collection<Edge> getCorr() {
	return corr;
    }

    public Collection<Edge> getEdges() {
	return edges;
    }
}
