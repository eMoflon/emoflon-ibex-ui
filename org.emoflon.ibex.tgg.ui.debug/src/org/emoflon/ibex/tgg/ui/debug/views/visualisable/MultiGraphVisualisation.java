package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.PlantUMLGenerator;

public class MultiGraphVisualisation extends VisualisableElement {

    private Collection<Graph> graphs;
    private IUserOptions userOptions;
    private DataProvider dataProvider;

    public MultiGraphVisualisation(Collection<Graph> pGraphs, IUserOptions pUserOptions, DataProvider pDataProvider) {
	graphs = pGraphs;
	userOptions = pUserOptions;
	dataProvider = pDataProvider;
    }

    @Override
    protected String generateVisualisationString() {
	return PlantUMLGenerator.visualise(graphs, userOptions, dataProvider);
    }
}
