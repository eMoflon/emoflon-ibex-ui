package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;

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

    private RuleAdapter(TGGRule pRule) {
	rule = pRule;
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
