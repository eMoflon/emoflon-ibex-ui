package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.data.Graph;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class ObjectGraphVisualisation extends VisualisableElement {

    private Graph objectGraph;
    private IUserOptions userOptions;
    private IVictoryDataProvider dataProvider;

    public ObjectGraphVisualisation(Graph pObjectGraph, IUserOptions pUserOptions,
	    IVictoryDataProvider pDataProvider) {
	objectGraph = pObjectGraph;
	userOptions = pUserOptions;
	dataProvider = pDataProvider;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph, userOptions, dataProvider);
    }
}
