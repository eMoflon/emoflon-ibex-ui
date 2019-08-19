package org.emoflon.ibex.tgg.ui.debug.api.impl;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.BindingType;

public class EdgeImpl implements Edge {
    private String label;
    private Node srcNode;
    private Node trgNode;
    private EdgeType type;
    private BindingType bindingType;

    public EdgeImpl(String pLabel, Node pSrcNode, Node pTrgNode) {
	label = pLabel;
	srcNode = pSrcNode;
	trgNode = pTrgNode;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String pLabel) {
	label = pLabel;
    }

    public Node getSrcNode() {
	return srcNode;
    }

    public void setSrcNode(Node pSrcNode) {
	srcNode = pSrcNode;
    }

    public Node getTrgNode() {
	return trgNode;
    }

    public void setTrgNode(Node pTrgNode) {
	trgNode = pTrgNode;
    }

    public EdgeType getType() {
	return type;
    }

    public void setType(EdgeType pType) {
	type = pType;
    }

    public BindingType getBindingType() {
	return bindingType;
    }

    public void setBindingType(BindingType pBindingType) {
	bindingType = pBindingType;
    }

}
