package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class ObjectGraphVisualisation extends VisualisableElement {

    private Collection<EObject> objectGraph;

    public ObjectGraphVisualisation(Collection<EObject> pObjectGraph) {
	objectGraph = pObjectGraph;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph);
    }
}
