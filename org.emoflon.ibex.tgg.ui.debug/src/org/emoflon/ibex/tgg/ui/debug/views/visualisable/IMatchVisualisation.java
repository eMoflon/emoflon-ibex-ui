package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
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

	Collection<EObject> matchNeighborhood = dataProvider.getMatchNeighbourhood(match, 1);

	String plantUmlString = VictoryPlantUMLGenerator.visualiseMatch(match, rule, matchNeighborhood, userOptions);
	
//	try {
//		File temp = File.createTempFile("plantUml", ".txt");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
//	    bw.write(plantUmlString);
//	    bw.close();
//	    System.out.println("Done");
//	}catch(IOException e){
//		e.printStackTrace();
//	}
	
	return plantUmlString;
    }

}
