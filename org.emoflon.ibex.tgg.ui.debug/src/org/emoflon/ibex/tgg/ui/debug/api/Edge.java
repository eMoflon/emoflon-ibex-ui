package org.emoflon.ibex.tgg.ui.debug.api;

import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;

public interface Edge {

    public String getLabel();

    public Node getSrcNode();

    public Node getTrgNode();

    public EdgeType getType();

    public Action getAction();
}