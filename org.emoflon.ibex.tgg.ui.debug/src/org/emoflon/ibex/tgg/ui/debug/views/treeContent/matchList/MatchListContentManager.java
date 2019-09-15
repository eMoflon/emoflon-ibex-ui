package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;

public class MatchListContentManager {

    private TreeContentManager manager = new TreeContentManager();

    private Map<Rule, RuleNode> ruleNodes;
    private Map<Match, MatchNode> matchNodes;

    public MatchListContentManager(Collection<Rule> pRules) {
	ruleNodes = new HashMap<>();
	pRules.forEach((rule) -> {
	    RuleNode node = new RuleNode(rule);
	    ruleNodes.put(rule, node);
	    manager.getRoot().addChild(node);
	});

	matchNodes = new HashMap<>();
    }

    public void populate(Collection<Match> pMatches) {

	if (pMatches == null || pMatches.isEmpty())
	    return;

	Iterator<Match> existingMatchesIterator = matchNodes.keySet().iterator();
	while (existingMatchesIterator.hasNext()) {
	    Match existingMatch = existingMatchesIterator.next();
	    if (!pMatches.contains(existingMatch)) {
		matchNodes.get(existingMatch).removeFromParent();
		existingMatchesIterator.remove();
	    }
	}

	for (Match match : pMatches) {
	    if (!matchNodes.containsKey(match)) {
		MatchNode node = new MatchNode(match);
		matchNodes.put(match, node);
		RuleNode rule = ruleNodes.get(match.getRule());
		rule.addChild(node);
	    }
	}
    }

    public TreeContentManager getTreeContentManager() {
	return manager;
    }
}
