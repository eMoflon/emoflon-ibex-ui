package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;

public class TGGRuleVisualisation extends VisualisableElement {

    private TGGRule rule;

    public TGGRuleVisualisation(TGGRule pRule) {
	if (pRule == null)
	    throw new IllegalArgumentException("Unknown rule");

	rule = pRule;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualiseTGGRule(rule);
    }
}
