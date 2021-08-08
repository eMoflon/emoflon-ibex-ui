package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;

public class CombinedBreakpoint extends AbstractBreakpoint {
	
	private final List<Breakpoint> breakpoints = new ArrayList<>();
	
	private CombinationType combinationType = CombinationType.AND;
	
	private EvaluationType evaluationType = EvaluationType.COMPLETE;
	
	
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
	
	public enum EvaluationType {
		PER_MATCH,
		COMPLETE
	}
	
	public synchronized CombinationType getCombinationType() {
			return this.combinationType;
	}
	
	public synchronized void setCombinationType(CombinationType combinationType) {
			if(combinationType == CombinationType.OR) {
				this.setEvaluationType(EvaluationType.COMPLETE);
			}
			this.combinationType = combinationType;
			this.resetHitCount();
	}
	
	public synchronized EvaluationType getEvaluationType() {
		return this.evaluationType;
	}
	
	public synchronized void setEvaluationType(EvaluationType evaluationType) {
			if(evaluationType == EvaluationType.PER_MATCH) {
				this.setCombinationType(CombinationType.AND);
			}
			this.evaluationType = evaluationType;
			this.resetHitCount();
	}
	
	public synchronized Collection<Breakpoint> getBreakpoints() {
			return breakpoints.stream().collect(Collectors.toList());
	}
	
	public synchronized void addBreakpoint(Breakpoint b) {
		if(!breakpoints.contains(b)) {
			breakpoints.add(b);
			b.setBreakpointEvaluationTime(BreakpointEvaluationTime.ALWAYS);
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
	
	private Match evaluateOr(DataPackage dataPackage) {
		for(Breakpoint b : this.getBreakpoints()) {
			if(!b.isActive(BreakpointEvaluationTime.FOUND_MATCHES)) {
				continue;
			}
			Match m = b.evaluate(dataPackage);
			if(m != null) {
				return m;
			}
		}
		return null;
	}
	
	private boolean evaluateOr(Match match) {
		for(Breakpoint b : this.getBreakpoints()) {
			if(!b.isActive(BreakpointEvaluationTime.ALWAYS)) {
				continue;
			}
			if(b.evaluate(match)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean evaluateAnd(Match match) {
		for(Breakpoint b : this.getBreakpoints()) {
			if(!b.isActive(BreakpointEvaluationTime.ALWAYS)) {
				continue;
			}
			if(!b.evaluate(match)) {
				return false;
			}
		}
		return true;
	}
	
	private Match evaluateAndCombined(DataPackage dataPackage) {
		Match foundMatch = null;
		for(Breakpoint b : breakpoints) {
			if(!b.isActive(BreakpointEvaluationTime.FOUND_MATCHES)) {
				continue;
			}
			foundMatch = b.evaluate(dataPackage);
			if(foundMatch == null) {
				//one of the breakpoints did not find a match => complete combination will be unsuccessful
				return null;
			}
		}
		
		this.increaseHitCount();
		return foundMatch;
	}
	
	private Match evaluateAndPerMatch(DataPackage dataPackage) {
		for(Match m : dataPackage.getMatches()) {
			if(this.evaluateAnd(m)) {
				return m;
			}
		}
		return null;
	}


	@Override
	public Match evaluate(DataPackage dataPackage) {
		if(this.getCombinationType() == CombinationType.OR) {
			return this.evaluateOr(dataPackage);
		}
		
		if(this.getEvaluationType() == EvaluationType.COMPLETE) {
			return this.evaluateAndCombined(dataPackage);
		} else {
			return this.evaluateAndPerMatch(dataPackage);
		}
	}
	
	@Override
	public synchronized boolean evaluate(Match match) {
		if(this.getCombinationType() == CombinationType.OR) {
			return this.evaluateOr(match);
		} else {
			return this.evaluateAnd(match);
		}
	}
}
