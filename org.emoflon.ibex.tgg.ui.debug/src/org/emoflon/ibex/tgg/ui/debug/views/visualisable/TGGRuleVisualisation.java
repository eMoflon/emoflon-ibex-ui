package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;

public class TGGRuleVisualisation extends VisualisableElement {

    private TGGRule rule;
    private IUserOptions userOptions;

    public TGGRuleVisualisation(TGGRule pRule, IUserOptions pUserOptions) {
	if (pRule == null)
	    throw new IllegalArgumentException("Unknown rule");

	rule = pRule;

	userOptions = pUserOptions;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualiseTGGRule(rule, userOptions);
    }
}
