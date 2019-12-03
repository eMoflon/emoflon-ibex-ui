package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

import language.DomainType;
import language.TGGRule;
import language.TGGRuleCorr;

public class TGGRuleAdapter implements Rule {

	private static Map<String, TGGRuleAdapter> rulesByName = new HashMap<>();

	public static TGGRuleAdapter getRuleByName(String ruleName) {
		return rulesByName.get(ruleName);
	}

	public static Collection<Rule> getAllRules() {
		return Collections.unmodifiableCollection(rulesByName.values());
	}

	public static TGGRuleAdapter adapt(TGGRule rule, IBeXOperation operationType) {
		if (!rulesByName.containsKey(rule.getName())) {
			TGGRuleAdapter ruleAdapter = new TGGRuleAdapter(rule, operationType);
			rulesByName.put(ruleAdapter.getName(), ruleAdapter);
		}
		return rulesByName.get(rule.getName());
	}

	private TGGRule rule;
	private Graph graph;

	private Collection<TGGRuleNodeAdapter> nodes;
	private Collection<TGGRuleCorrAdapter> corrs;

	private TGGRuleAdapter(TGGRule rule, IBeXOperation operationType) {
		this.rule = rule;
		GraphBuilder graphBuilder = new GraphBuilder();

		nodes = new HashSet<>();
		corrs = new HashSet<>();

		// Add nodes to the graph
		rule.getNodes().stream()//
				.filter(node -> DomainType.SRC.equals(node.getDomainType()))//
				.map(node -> TGGRuleNodeAdapter.adapt(node, Domain.SRC, operationType))//
				.forEach(node -> {
					graphBuilder.addNode(node);
					nodes.add(node);
				});
		rule.getNodes().stream()//
				.filter(node -> DomainType.TRG.equals(node.getDomainType()))//
				.map(node -> TGGRuleNodeAdapter.adapt(node, Domain.TRG, operationType))//
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
				.filter(edge -> DomainType.SRC.equals(edge.getDomainType()))//
				.map(edge -> TGGRuleEdgeAdapter.adapt(edge, Domain.SRC, operationType))//
				.forEach(edge -> graphBuilder.addEdge(edge));
		rule.getEdges().stream()//
				.filter(edge -> DomainType.TRG.equals(edge.getDomainType()))//
				.map(edge -> TGGRuleEdgeAdapter.adapt(edge, Domain.TRG, operationType))//
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
