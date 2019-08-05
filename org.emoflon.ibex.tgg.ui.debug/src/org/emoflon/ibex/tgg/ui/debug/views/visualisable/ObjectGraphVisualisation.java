package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class ObjectGraphVisualisation extends VisualisableElement {

    private TGGObjectGraph objectGraph;
    private IUserOptions userOptions;

    public ObjectGraphVisualisation(TGGObjectGraph pObjectGraph, IUserOptions pUserOptions) {
	objectGraph = pObjectGraph;
	userOptions = pUserOptions;
    }

    @Override
    protected String generateVisualisationString() {
	String plantUmlString = VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph, userOptions);
	return plantUmlString;
    }
}
