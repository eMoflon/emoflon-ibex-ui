package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.PlantUMLGenerator;

public class RuleApplicationVisualisation extends VisualisableElement {

    private Collection<RuleApplication> ruleApplications;
    private IUserOptions userOptions;
    private DataProvider dataProvider;

    public RuleApplicationVisualisation(Collection<RuleApplication> pRuleApplications, IUserOptions pUserOptions,
	    DataProvider pDataProvider) {
	ruleApplications = pRuleApplications;
	userOptions = pUserOptions;
	dataProvider = pDataProvider;
    }

    @Override
    protected String generateVisualisationString() {
	Graph[] graph = new Graph[1];
	ruleApplications.stream().findAny().ifPresent(ruleApplication -> graph[0] = ruleApplication.getMerger()
		.getMergedGraph(ruleApplications, userOptions.getNeighborhoodSize()));
	return PlantUMLGenerator.visualise(graph[0], userOptions, dataProvider);
    }

}
