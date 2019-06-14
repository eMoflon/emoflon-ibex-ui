package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;

import com.google.common.collect.Maps;

import language.TGGRule;

public class MatchListContentManager {

    private TreeContentManager manager = new TreeContentManager();

    private Map<String, TGGRule> rules;

    private Map<String, RuleNode> ruleNodes;
    private Map<IMatch, MatchNode> matchNodes;

    public MatchListContentManager(Collection<TGGRule> pRules) {
	rules = Maps.uniqueIndex(pRules, rule -> rule.getName());

	ruleNodes = new HashMap<>();
	rules.forEach((name, rule) -> {
	    RuleNode node = new RuleNode(rule);
	    ruleNodes.put(name, node);
	    manager.getRoot().addChild(node);
	});

	matchNodes = new HashMap<>();
    }

    public void populate(Collection<IMatch> pMatches) {

	if (pMatches == null || pMatches.isEmpty()) {
	    // TODO what happens when there are no matches?
	    return;
	}

	for (IMatch existingMatch : matchNodes.keySet())
	    if (!pMatches.contains(existingMatch)) {
		matchNodes.remove(existingMatch).removeFromParent();
	    }

	for (RuleNode rule : ruleNodes.values())
	    rule.setBold(false);

	for (IMatch match : pMatches) {
	    if (!matchNodes.containsKey(match)) {
		MatchNode node = new MatchNode(match, match.getPatternName());
		matchNodes.put(match, node);
		RuleNode rule = ruleNodes.get(match.getRuleName());
		rule.addChild(node);
		rule.setBold(true);
	    }
	}
    }

    public TreeContentManager getTreeContentManager() {
	return manager;
    }
}
