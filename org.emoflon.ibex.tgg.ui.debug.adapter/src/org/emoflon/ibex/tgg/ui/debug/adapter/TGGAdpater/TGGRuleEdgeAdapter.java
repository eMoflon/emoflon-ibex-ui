package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;

import language.DomainType;
import language.TGGRuleEdge;

import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

public class TGGRuleEdgeAdapter implements Edge {

    private TGGRuleEdge edge;

    public TGGRuleEdgeAdapter(TGGRuleEdge pEdge) {
	edge = pEdge;

    }

    @Override
    public Node getSrcNode() {
	return new NodeAdapter(edge.getSrcNode());
    }

    @Override
    public Node getTrgNode() {
	return new NodeAdapter(edge.getTrgNode());
    }

    @Override
    public String getLabel() {
	return edge.getName();
    }

    @Override
    public EdgeType getType() {

	if (edge.getDomainType() == DomainType.CORR) {
	    return EdgeType.CORR;
	} else if (edge.getDomainType() == DomainType.SRC || edge.getDomainType() == DomainType.TRG) {
	    return EdgeType.NORMAL;
	}
	// TODO: should some condition be checked here?
	else {
	    return EdgeType.MATCH;
	}

    }

    @Override
    public Action getAction() {
	return EnumAdapt.adaptBindingType(edge.getBindingType());
    }
}
