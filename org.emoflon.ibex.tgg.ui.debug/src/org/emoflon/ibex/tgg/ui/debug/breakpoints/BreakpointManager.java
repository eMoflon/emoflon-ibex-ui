package org.emoflon.ibex.tgg.ui.debug.breakpoints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint.BreakpointEvaluationTime;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.views.BreakpointMenu;

public class BreakpointManager {
	
	private final Set<Breakpoint> breakpoints = new HashSet<Breakpoint>();
	
	private BreakpointMenu breakpointMenu;
	
	public void addTopLevelBreakpoint(Breakpoint breakpoint) {
		this.addBreakpoint(breakpoint, null);
	}
	
	public synchronized void addBreakpoint(Breakpoint breakpoint, Breakpoint parent) {
		if(parent != null && parent instanceof CombinedBreakpoint) {
			((CombinedBreakpoint) parent).addBreakpoint(breakpoint);
		} else {
			this.breakpoints.add(breakpoint);
		}
		
		if(breakpointMenu != null) {
			VictoryUI.getDisplay().syncExec(() -> breakpointMenu.updateBreakpoints(breakpoints));
		}
	}
	
	public void removeTopLevelBreakpoint(Breakpoint breakpoint) {
		this.removeBreakpoint(breakpoint, null);
	}
	
	public synchronized void removeBreakpoint(Breakpoint breakpoint, Breakpoint parent) {
		if(parent != null && parent instanceof CombinedBreakpoint) {
			((CombinedBreakpoint) parent).removeBreakpoint(breakpoint);
		} else {
			this.breakpoints.remove(breakpoint);
		}
		if(breakpointMenu != null) {
			VictoryUI.getDisplay().syncExec(() -> breakpointMenu.updateBreakpoints(breakpoints));
		}
	}
	
	public synchronized Collection<Breakpoint> getTopLevelBreakpoints() {
		return this.breakpoints;
	}
	
	public Match checkBreakpointsBeforeMatchSelection(DataPackage dataPackage) {
		//check if any breakpoint is hit
		for(Breakpoint b : this.getTopLevelBreakpoints()) {
			if(b.isActive(BreakpointEvaluationTime.FOUND_MATCHES)) {
				Match m = b.evaluate(dataPackage);
				if(m != null) {
					return m;
				}
			}
		}
		return null;
	}
	
	public boolean checkBreakpointsAfterMatchSelection(DataPackage dataPackage, Match chosenMatch) {
		//check if any breakpoint is hit
		for(Breakpoint b : this.getTopLevelBreakpoints()) {
			if(b.isActive(BreakpointEvaluationTime.MATCH_SELECTED)) {
				if(b.evaluate(chosenMatch)) {
					return true;
				}
			}
		}
		return false;
	}

	public BreakpointMenu getBreakpointMenu() {
		return breakpointMenu;
	}

	public void setBreakpointMenu(BreakpointMenu breakpointMenu) {
		this.breakpointMenu = breakpointMenu;
		this.breakpointMenu.updateBreakpoints(getTopLevelBreakpoints());
	}

}
