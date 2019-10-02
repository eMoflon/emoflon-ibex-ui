package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

/**
 * A graph that can be visualized by Victory. See also {@link Node} and
 * {@link Edge}.
 */
public interface Graph {
    public Collection<Node> getNodes();

    public Collection<Edge> getEdges();
}
