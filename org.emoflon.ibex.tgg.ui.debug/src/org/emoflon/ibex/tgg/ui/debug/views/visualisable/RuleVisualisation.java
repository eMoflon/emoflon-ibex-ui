package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.PlantUMLGenerator;

public class RuleVisualisation extends VisualisableElement {

    private Rule rule;
    private IUserOptions userOptions;
    private DataProvider dataProvider;

    public RuleVisualisation(Rule pRule, IUserOptions pUserOptions, DataProvider pDataProvider) {
	rule = pRule;
	userOptions = pUserOptions;
	dataProvider = pDataProvider;
    }

    @Override
    protected String generateVisualisationString() {
	return PlantUMLGenerator.visualise(rule.getGraph(), userOptions, dataProvider);
    }
}
