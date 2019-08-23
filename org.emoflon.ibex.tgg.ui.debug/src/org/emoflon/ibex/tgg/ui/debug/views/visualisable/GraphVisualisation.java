package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class GraphVisualisation extends VisualisableElement {

    private Graph graph;
    private IUserOptions userOptions;
    private DataProvider dataProvider;

    public GraphVisualisation(Graph pGraph, IUserOptions pUserOptions, DataProvider pDataProvider) {
	graph = pGraph;
	userOptions = pUserOptions;
	dataProvider = pDataProvider;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualise(graph, userOptions, dataProvider);
    }
}
