package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager.VisualizationLabelOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class ObjectGraphVisualisation extends VisualisableElement {

	private TGGObjectGraph objectGraph;
	private IVictoryDataProvider dataProvider;

	public ObjectGraphVisualisation(TGGObjectGraph pObjectGraph, IVictoryDataProvider pDataProvider) {
		objectGraph = pObjectGraph;
		dataProvider = pDataProvider;
	}

	@Override
	protected String generateVisualisationString() {
		return VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph, VisualizationLabelOptions.NONE, dataProvider);
	}
}
