package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;

public class RulenameBreakpoint extends AbstractBreakpoint {

	private String ruleName;
	
	public RulenameBreakpoint(String ruleName) {
		this.ruleName = ruleName;
	}
	
	@Override
	public String toString() {
		return "RuleNameBreakpoint ("+this.getRuleName()+")";
	}
	
	@Override
	public synchronized boolean evaluate(Match match) {
		if(ruleName != null && ruleName.equals(match.getRule().getName())) {
			this.increaseHitCount();
			return true;
		}
		return false;
	}

	public synchronized void setRuleName(String ruleName) {
		this.ruleName = ruleName;
		this.resetHitCount();
	}
	
	public synchronized String getRuleName() {
		return ruleName;
	}

}
