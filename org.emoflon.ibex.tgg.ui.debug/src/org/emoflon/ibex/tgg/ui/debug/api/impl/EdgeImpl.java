package org.emoflon.ibex.tgg.ui.debug.api.impl;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;

/**
 * A basic implementation of the {@link Edge} interface. Can be directly added
 * to a graph using a {@link GraphBuilder}.
 */
public class EdgeImpl implements Edge {
    private String label;
    private Node srcNode;
    private Node trgNode;
    private EdgeType type;
    private Action action;

    EdgeImpl(String pLabel, Node pSrcNode, Node pTrgNode, EdgeType pType, Action pAction) {
	label = pLabel;
	srcNode = pSrcNode;
	trgNode = pTrgNode;
	type = pType;
	action = pAction;
    }

    public String getLabel() {
	return label;
    }

    public Node getSrcNode() {
	return srcNode;
    }

    public Node getTrgNode() {
	return trgNode;
    }

    public EdgeType getType() {
	return type;
    }

    public Action getAction() {
	return action;
    }
}
