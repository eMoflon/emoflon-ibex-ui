package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;

public interface IVisualiser {
	public void display(Rule pRule);

	public void display(Match pMatch);

	public void display(Collection<RuleApplication> pRuleApplications);

	public void refresh();
}
