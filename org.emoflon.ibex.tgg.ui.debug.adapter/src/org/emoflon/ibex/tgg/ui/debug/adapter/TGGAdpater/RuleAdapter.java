package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.List;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;

import language.TGGRule;

public class RuleAdapter implements Rule {

    private TGGRule rule;

    public RuleAdapter(TGGRule rule) {
	super();
	this.rule = rule;
    }

    @Override
    public List<Node> getNodes() {
	List<Node> nodes = rule.getNodes()//
		.stream()//
		.map(m -> new NodeAdapter(m)).collect(Collectors.toList());
	return nodes;
    }

    @Override
    public List<Edge> getEdges() {
	return rule.getEdges()//
		.stream()//
		.map(m -> new TGGRuleEdgeAdapter(m)).collect(Collectors.toList());
    }

}
