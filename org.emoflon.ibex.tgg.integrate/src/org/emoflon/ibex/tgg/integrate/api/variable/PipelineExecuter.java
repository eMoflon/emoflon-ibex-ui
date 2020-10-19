package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.Set;

public interface PipelineExecuter {

	PipelineExecuter src();

	PipelineExecuter trg();

	PipelineExecuter created();

	PipelineExecuter deleted();

	PipelineExecuter types(Set<TypeFilterData> data);
	
	int count();
	
	boolean exists();

}
