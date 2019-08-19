package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

public interface Graph {

    public Collection<Node> getSrc();

    public Collection<Node> getTrg();

    public Collection<Edge> getCorr();

    public Collection<Edge> getEdges();
}
