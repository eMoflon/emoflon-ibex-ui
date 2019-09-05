package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

import language.DomainType;
import language.TGGRule;
import language.TGGRuleCorr;

public class TGGRuleAdapter implements Rule {

	private static Map<String, TGGRuleAdapter> rulesByName = new HashMap<>();

	public static TGGRuleAdapter getRuleByName(String pRuleName) {
		return rulesByName.get(pRuleName);
	}

	public static Collection<Rule> getAllRules() {
		return Collections.unmodifiableCollection(rulesByName.values());
	}

	public static TGGRuleAdapter adapt(TGGRule pRule) {
		if (!rulesByName.containsKey(pRule.getName())) {
			TGGRuleAdapter rule = new TGGRuleAdapter(pRule);
			rulesByName.put(rule.getName(), rule);
		}
		return rulesByName.get(pRule.getName());
	}

	private TGGRule rule;
	private Graph graph;

	private Collection<TGGRuleNodeAdapter> nodes;
	private Collection<TGGRuleCorrAdapter> corrs;

	private TGGRuleAdapter(TGGRule pRule) {
		rule = pRule;
		GraphBuilder graphBuilder = new GraphBuilder();

		nodes = new HashSet<>();
		corrs = new HashSet<>();

		// Add nodes to the graph
		rule.getNodes().stream()//
				.filter(node -> !DomainType.CORR.equals(node.getDomainType()))//
				.map(node -> TGGRuleNodeAdapter.adapt(node))//
				.forEach(node -> {
					graphBuilder.addNode(node);
					nodes.add(node);
				});

		// Add corr edges to the graph
		rule.getNodes().stream()//
				.filter(node -> DomainType.CORR.equals(node.getDomainType()))//
				.map(node -> TGGRuleCorrAdapter.adapt((TGGRuleCorr) node))//
				.forEach(corr -> {
					graphBuilder.addEdge(corr);
					corrs.add(corr);
				});

		// Add regular edges to the graph
		rule.getEdges().stream()//
				.filter(edge -> !DomainType.CORR.equals(edge.getDomainType()))//
				.map(edge -> TGGRuleEdgeAdapter.adapt(edge))//
				.forEach(edge -> graphBuilder.addEdge(edge));

		graph = graphBuilder.build();
		nodes = Collections.unmodifiableCollection(nodes);
		corrs = Collections.unmodifiableCollection(corrs);
	}

	public TGGRule getWrappedRule() {
		return rule;
	}

	@Override
	public String getName() {
		return rule.getName();
	}

	@Override
	public Graph getGraph() {
		return graph;
	}

	public Collection<TGGRuleNodeAdapter> getNodes() {
		return nodes;
	}

	public Collection<TGGRuleCorrAdapter> getCorrs() {
		return corrs;
	}
}
