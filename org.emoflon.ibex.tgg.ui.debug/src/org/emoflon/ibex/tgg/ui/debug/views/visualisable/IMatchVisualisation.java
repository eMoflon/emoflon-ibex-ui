package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;

public class IMatchVisualisation extends VisualisableElement {

    private IMatch match;
    private IVictoryDataProvider dataProvider;
    private IUserOptions userOptions;

    public IMatchVisualisation(IMatch pMatch, IVictoryDataProvider pDataProvider, IUserOptions pUserOptions) {
	match = pMatch;
	dataProvider = pDataProvider;
	userOptions = pUserOptions;
    }

    @Override
    protected String generateVisualisationString() {
	TGGRule rule = dataProvider.getRule(match.getRuleName());
	if (rule == null)
	    throw new IllegalArgumentException("Unknown rule");

	return VictoryPlantUMLGenerator.visualiseMatch(match, rule, userOptions, dataProvider);
    }

}
