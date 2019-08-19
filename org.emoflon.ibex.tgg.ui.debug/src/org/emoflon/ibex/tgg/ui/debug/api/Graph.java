package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

public interface Graph {

    public Collection<Node> getNodes();

    public Collection<Edge> getEdges();
}
