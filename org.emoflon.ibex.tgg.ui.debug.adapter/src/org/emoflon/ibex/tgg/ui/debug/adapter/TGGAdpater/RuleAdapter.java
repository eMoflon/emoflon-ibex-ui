package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.List;

import java.util.stream.Collectors;
import language.TGGRule;
import org.emoflon.ibex.tgg.ui.debug.api.IRule;
import org.emoflon.ibex.tgg.ui.debug.api.IRuleEdge;
import org.emoflon.ibex.tgg.ui.debug.api.IRuleNode;


import language.TGGRuleCorr;

public class RuleAdapter implements IRule {


	private TGGRule rule;
	public RuleAdapter(TGGRule rule) {
		super();
		this.rule = rule;
	}

	@Override
	public List<IRuleNode> getNodes() {

	List<IRuleNode> nodes = rule.getNodes().stream()//
		.filter(rule -> !(rule instanceof TGGRuleCorr))//
		.map(rule -> new RuleNodeAdapter(rule))//
		.collect(Collectors.toList());
	nodes.addAll(rule.getNodes().stream()//
		.filter(rule -> rule instanceof TGGRuleCorr)//
		.map(corr -> new TGGRuleCorrAdapter((TGGRuleCorr) corr))//
		.collect(Collectors.toList()));
	return nodes;
	}

	@Override
	public List<IRuleEdge> getEdges() {

		return rule.getEdges()//
				.stream()//
				.map(m -> new TGGRuleEdgeAdapter(m))
				.collect(Collectors.toList());
	}


}






