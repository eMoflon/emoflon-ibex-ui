package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;

public class TGGRuleVisualisation extends VisualisableElement {

    private TGGRule rule;
    private IUserOptions userOptions;

    public TGGRuleVisualisation(TGGRule pRule, IUserOptions pUserOptions) {
	if (pRule == null)
	    throw new IllegalArgumentException("Unknown rule");

	rule = pRule;

	userOptions = pUserOptions;
    }

    @Override
    protected String generateVisualisationString() { 
    	String plantUmlString = VictoryPlantUMLGenerator.visualiseTGGRule(rule, userOptions);
    	
//    	try {
//    		File temp = File.createTempFile("plantUml", ".txt");
//    		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
//    	    bw.write(plantUmlString);
//    	    bw.close();
//    	    System.out.println("Done");
//    	}catch(IOException e){
//    		e.printStackTrace();
//    	}
    	return plantUmlString;
    }
}
