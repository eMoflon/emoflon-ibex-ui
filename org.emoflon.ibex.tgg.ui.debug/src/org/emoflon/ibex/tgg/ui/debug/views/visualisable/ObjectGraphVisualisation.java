package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

public class ObjectGraphVisualisation extends VisualisableElement {

    private Collection<EObject> objectGraph;
    private Collection<EObject> corrElements;

    public ObjectGraphVisualisation(Collection<EObject> pObjectGraph, Collection<EObject> pCorrElements) {
	objectGraph = pObjectGraph;
	corrElements = pCorrElements;
    }

    @Override
    protected String generateVisualisationString() {
	return VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph, corrElements);
    }
}
