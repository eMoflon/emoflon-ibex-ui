package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;

public class NumberOfMatchesBreakpoint extends AbstractBreakpoint {
	
	private final Set<String> rules = new HashSet<String>();
	
	private int limit;
	
	private boolean considerAllRules;
	
	@Override
	public String toString() {
		if(considerAllRules) {
			return "NumberOfMatchesBreakpoint ("+this.getLimit()+")";
		}
		return "NumberOfMatchesBreakpoint ("+this.getLimit()+") ["+String.join(",", rules)+"]";
	}
	
	public NumberOfMatchesBreakpoint(int limit, String... rules) {
		this.limit = limit;
		considerAllRules = rules.length < 1;
		for(String r : rules) {
			this.rules.add(r);
		}
	}
	
	@Override
	public synchronized Match evaluate(DataPackage dataPackage) {
		int counter = 0;
		for(Match m : dataPackage.getMatches()) {
			if(considerAllRules || rules.contains(m.getRule().getName())) {
				counter++;
				if(counter >= limit) {
					this.increaseHitCount();
					return m;
				}
			}
		}
		return null;
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

	@Override
	public boolean evaluate(Match match) {
		return false;
	}
	

	public synchronized int getLimit() {
		return this.limit;
	}

	public synchronized void setLimit(int limit) {
		this.limit = limit;
		this.resetHitCount();
	}
	
	public synchronized void setRules(String... rules) {
		this.rules.clear();
		this.considerAllRules = rules.length < 1;
		for(String r : rules) {
			this.rules.add(r);
		}
		this.resetHitCount();
	}
	
	public synchronized String[] getRules() {
		return this.rules.toArray(new String[this.rules.size()]);
	}

}
