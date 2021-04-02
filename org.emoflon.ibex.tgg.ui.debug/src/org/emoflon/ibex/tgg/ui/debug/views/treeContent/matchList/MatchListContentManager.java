package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;

public class MatchListContentManager {

	private TreeContentManager manager = new TreeContentManager(0);

	private Map<Rule, RuleNode> ruleNodes;
	private Map<Match, MatchNode> matchNodes;
	private final IUserOptions userOptions;

	public MatchListContentManager(Collection<Rule> rules, IUserOptions userOptions) {
		this.userOptions = userOptions;
		ruleNodes = new HashMap<>();
		rules.forEach((rule) -> {
			RuleNode node = new RuleNode(rule, userOptions);
			ruleNodes.put(rule, node);
			manager.getRoot().addChild(node);
		});

		matchNodes = new HashMap<>();
	}
	
	public MatchNode getMatchNode(Match m) {
		return matchNodes.get(m);
	}

	public void populate(Collection<Match> matches, List<RuleApplication> ruleApplications) {
		
		if(!ruleApplications.isEmpty()) {
			RuleApplication lastRuleApplication = ruleApplications.get(ruleApplications.size()-1);
			for(Entry<Rule, RuleNode> ruleNodeMapping : ruleNodes.entrySet()) {
				if(ruleNodeMapping.getKey().getName().equals(lastRuleApplication.getRuleName())) {
					ruleNodeMapping.getValue().increaseTimesApplied();
				}
			}
		}

		if (matches == null || matches.isEmpty())
			return;

		Iterator<Match> existingMatchesIterator = matchNodes.keySet().iterator();
		while (existingMatchesIterator.hasNext()) {
			Match existingMatch = existingMatchesIterator.next();
			if (!matches.contains(existingMatch)) {
				matchNodes.get(existingMatch).removeFromParent();
				existingMatchesIterator.remove();
			}
		}

		for (Match match : matches) {
			if (!matchNodes.containsKey(match)) {
				MatchNode node = new MatchNode(match, userOptions);
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
