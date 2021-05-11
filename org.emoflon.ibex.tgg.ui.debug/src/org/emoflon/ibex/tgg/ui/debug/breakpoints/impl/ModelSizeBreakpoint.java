package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.util.Optional;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;

public class ModelSizeBreakpoint extends AbstractBreakpoint {
	
	private int limit;
	
	public ModelSizeBreakpoint(int limit) {
		this.limit = limit;
	}
	
	public String toString() {
		return "ModelSizeBreakpoint ("+this.getLimit()+")";
	}

	@Override
	public boolean evaluate(Match match) {
		return false;
	}
	
	@Override
	public synchronized Match evaluate(DataPackage dataPackage) {
		long numberOfNodes = dataPackage.getTripleGraph().getGraph().getNodes().stream().count();
		if(numberOfNodes > limit) {
			Optional<Match> m = dataPackage.getMatches().stream().findFirst();
			if(m.isPresent()) {
				return m.get();
			}
		}
		return null;
	}
	
	public synchronized int getLimit() {
		return this.limit;
	}

	public synchronized void setLimit(int limit) {
		this.limit = limit;
		this.resetHitCount();
	}
	
	@Override
	public synchronized void setBreakpointEvaluationTime(BreakpointEvaluationTime breakpointEvaluationTime) {
		switch(breakpointEvaluationTime) {
		case ALWAYS:
		case FOUND_MATCHES:
			super.setBreakpointEvaluationTime(BreakpointEvaluationTime.FOUND_MATCHES);
			break;
		case MATCH_SELECTED:
		case OFF:
			super.setBreakpointEvaluationTime(BreakpointEvaluationTime.OFF);
			break;
		}
	}

}
