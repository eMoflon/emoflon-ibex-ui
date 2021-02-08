package org.emoflon.ibex.tgg.ui.debug.breakpoints;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;

public abstract class AbstractBreakpoint implements Breakpoint {
	
	private BreakpointEvaluationTime breakpointEvaluationTime = BreakpointEvaluationTime.FOUND_MATCHES;
	
	private int hitCount = 0;
	
	@Override
	public Match evaluate(DataPackage dataPackage) {
		for(Match m : dataPackage.getMatches()) {
			if(this.evaluate(m)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public synchronized int getHitCount() {
		return hitCount;
	}
	
	protected synchronized void increaseHitCount() {
		hitCount++;
	}
	
	protected synchronized void resetHitCount() {
		hitCount = 0;
	}

	@Override
	public synchronized void setBreakpointEvaluationTime(BreakpointEvaluationTime breakpointEvaluationTime) {
		this.breakpointEvaluationTime = breakpointEvaluationTime;
	}
	
	public synchronized boolean isActive(BreakpointEvaluationTime executionTime) {
		switch(this.getBreakpointEvaluationTime()) {
			case ALWAYS: return true;
			case OFF: return false;
			case FOUND_MATCHES: return executionTime == BreakpointEvaluationTime.FOUND_MATCHES;
			case MATCH_SELECTED: return executionTime == BreakpointEvaluationTime.MATCH_SELECTED;
			default:
				throw new IllegalStateException("Invalid breakpoint evaluation time");
		}
	}

	@Override
	public synchronized BreakpointEvaluationTime getBreakpointEvaluationTime() {
		return this.breakpointEvaluationTime;
	}

}
