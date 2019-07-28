package org.emoflon.ibex.tgg.ui.debug.views.visualisable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    	String plantUmlString =  VictoryPlantUMLGenerator.visualiseObjectGraph(objectGraph, userOptions);
    	
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
