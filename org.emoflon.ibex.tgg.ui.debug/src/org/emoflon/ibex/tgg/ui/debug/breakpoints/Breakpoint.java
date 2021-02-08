package org.emoflon.ibex.tgg.ui.debug.breakpoints;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;

public interface Breakpoint {

	int getHitCount();
	
	Match evaluate(DataPackage dataPackage);
	
	boolean evaluate(Match match);
	
	void setBreakpointEvaluationTime(BreakpointEvaluationTime breakpointEvaluationTime);
	
	BreakpointEvaluationTime getBreakpointEvaluationTime();
	
	boolean isActive(BreakpointEvaluationTime executionTime);
		
	public enum BreakpointEvaluationTime {
		OFF,
		FOUND_MATCHES,
		MATCH_SELECTED,
		ALWAYS
	}
}
