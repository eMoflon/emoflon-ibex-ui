package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.TripleGraph;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.PlantUMLGenerator;

public class TripleGraphVisualisation extends VisualisableElement {

	private TripleGraph tripleGraph;
	private IUserOptions userOptions;
	private DataProvider dataProvider;

	public TripleGraphVisualisation(TripleGraph tripleGraph, IUserOptions userOptions,
			DataProvider dataProvider) {
		this.tripleGraph = tripleGraph;
		this.userOptions = userOptions;
		this.dataProvider = dataProvider;
	}

	@Override
	protected String generateVisualisationString() {
		return PlantUMLGenerator.visualise(tripleGraph.getGraph(), userOptions, dataProvider);
	}

}
