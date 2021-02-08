package org.emoflon.ibex.tgg.ui.debug.breakpoints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	public BreakpointMenu getBreakpointMenu() {
		return breakpointMenu;
	}

	public void setBreakpointMenu(BreakpointMenu breakpointMenu) {
		this.breakpointMenu = breakpointMenu;
		this.breakpointMenu.updateBreakpoints(getTopLevelBreakpoints());
	}

}
