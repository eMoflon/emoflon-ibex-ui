package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;

public class CombinedBreakpoint extends AbstractBreakpoint {
	
	private final List<Breakpoint> breakpoints = new ArrayList<>();
	
	private CombinationType combinationType = CombinationType.AND;
	
	
	public CombinedBreakpoint(CombinationType combinationType, Breakpoint... breakpoints) {
		for(Breakpoint b : breakpoints) {
			this.breakpoints.add(b);
		}
		this.combinationType = combinationType;
	}
	
	
	public enum CombinationType {
		AND,
		OR
	}
	
	public synchronized CombinationType getCombinationType() {
			return this.combinationType;
	}
	
	public synchronized void setCombinationType(CombinationType combinationType) {
			this.combinationType = combinationType;
			this.resetHitCount();
	}
	
	public synchronized Collection<Breakpoint> getBreakpoints() {
			return breakpoints.stream().collect(Collectors.toList());
	}
	
	public synchronized void addBreakpoint(Breakpoint b) {
		if(!breakpoints.contains(b)) {
			breakpoints.add(b);
			this.resetHitCount();
		}
	}
	
	public synchronized void removeBreakpoint(Breakpoint b) {
		if(breakpoints.contains(b)) {
			this.breakpoints.remove(b);
			this.resetHitCount();
		}
	}
	
	@Override
	public String toString() {
		return this.getCombinationType().toString() + "-CombinedBreakpoint";
	}

	@Override
	public synchronized boolean evaluate(Match match) {
		for(Breakpoint b : breakpoints) {
			boolean result = b.evaluate(match);
			if(result && combinationType == CombinationType.OR) {
				// OR: found true breakpoint => complete combination will be true
				this.increaseHitCount();
				return true;
			} else if(!result && combinationType == CombinationType.AND) {
				// AND: found false breakpoint => complete combination will be false
				return false;
			}
		}
		
		switch(combinationType) {
		case AND:
			// For AND: did not find any breakpoint with result false => return true
			this.increaseHitCount();
			return true;
		case OR:
		default:
			// For OR: did not find any breakpoint with result true => return false
			return false;
		}
	}
}
