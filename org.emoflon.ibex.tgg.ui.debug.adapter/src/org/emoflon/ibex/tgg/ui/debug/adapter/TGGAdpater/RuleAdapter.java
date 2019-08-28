package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

import language.TGGRule;

public class RuleAdapter implements Rule {

    private static Map<String, RuleAdapter> rulesByName = new HashMap<>();

    public static RuleAdapter getRuleByName(String pRuleName) {
	return rulesByName.get(pRuleName);
    }

    public static RuleAdapter create(TGGRule pRule) {
	RuleAdapter rule = new RuleAdapter(pRule);
	rulesByName.put(rule.getName(), rule);
	return rule;
    }

    private TGGRule rule;
    private GraphBuilder graphBuilder;

    private RuleAdapter(TGGRule pRule) {
	rule = pRule;
	graphBuilder = new GraphBuilder();
	/* Adds edges to the graph */
	Collection<Edge> edges = rule.getEdges()//
		.stream()//
		.map(m -> new TGGRuleEdgeAdapter(m)).collect(Collectors.toList());
	graphBuilder.addEdges(edges);
	/* Adds nodes to the graph */
	Collection<Node> nodes = rule.getNodes()//
		.stream()//
		.map(m -> TGGRuleNodeAdapter.adapt(m)).collect(Collectors.toList());
	nodes.stream().forEach((n) -> graphBuilder.addNode(n));

    }

    @Override
    public String getName() {
	return rule.getName();
    }

    @Override
    public Graph getGraph() {
	// TODO build graph
	return null;
    }
}
