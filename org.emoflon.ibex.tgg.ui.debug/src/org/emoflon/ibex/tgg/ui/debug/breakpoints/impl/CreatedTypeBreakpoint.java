package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.util.HashMap;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;

public class CreatedTypeBreakpoint extends AbstractBreakpoint {
	
	private HashMap<String, Boolean> cachedRuleResults = new HashMap<String, Boolean>();
	
	private String typeName;
	
	public CreatedTypeBreakpoint(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return "CreatedTypeBreakpoint ("+this.getType()+")";
	}

	@Override
	public synchronized boolean evaluate(Match match) {
		if(cachedRuleResults.containsKey(match.getRule().getName())) {
			boolean cachedResult = cachedRuleResults.get(match.getRule().getName());
			if(cachedResult) {
				this.increaseHitCount();
			}
			return cachedResult;
		}
		
		boolean found = false;
		Graph g = match.getRule().getGraph();
		for(Node n: g.getNodes()) {
			if(typeName.equals(n.getType()) && (n.getAction() == Action.CREATE || n.getAction() == Action.TRANSLATE)) {
				found = true;
				break;
			}
		}
		if(!found) {
			for(Edge e: g.getEdges()) {
				if(typeName.equals(e.getType().name()) && e.getAction() == Action.CREATE) {
					found = true;
					break;
				}
			}
		}
		
		cachedRuleResults.put(match.getRule().getName(), found);
		
		if(found) {
			this.increaseHitCount();
		}
		
		return found;
	}

	public synchronized String getType() {
		return typeName;
	}
	
	public synchronized void setType(String typeName) {
		this.typeName = typeName;
		this.cachedRuleResults.clear();
		this.resetHitCount();
	}
}
