package org.emoflon.ibex.tgg.ui.debug.views.treeContent.breakpointList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class BreakpointContentManager {
	
	private final TreeContentManager manager = new TreeContentManager(StyledCellLabelProvider.COLORS_ON_SELECTION);
	private final IUserOptions userOptions;
	
	private Map<Breakpoint, BreakpointNode> breakpointNodes;
	
	public BreakpointContentManager(IUserOptions userOptions) {
		this.userOptions = userOptions;
		breakpointNodes = new HashMap<>();
	}
	
	public BreakpointNode getBreakpointNode(Breakpoint m) {
		return breakpointNodes.get(m);
	}
	
	private void getNestedBreakpoints(Breakpoint breakpoint, List<Breakpoint> breakpoints) {
		breakpoints.add(breakpoint);
		if(breakpoint instanceof CombinedBreakpoint) {
			for(Breakpoint b: ((CombinedBreakpoint) breakpoint).getBreakpoints()) {
				getNestedBreakpoints(b, breakpoints);
			}
		}
	}
	
	private void addOrUpdateBreakpoint(Breakpoint breakpoint, TreeNode node) {
		BreakpointNode breakpointNode;
		if (!breakpointNodes.containsKey(breakpoint)) {
			breakpointNode = new BreakpointNode(breakpoint, userOptions);
			breakpointNodes.put(breakpoint, breakpointNode);
			node.addChild(breakpointNode);
			
		} else {
			breakpointNode = breakpointNodes.get(breakpoint);
		}
		if(breakpoint instanceof CombinedBreakpoint) {
			for(Breakpoint b: ((CombinedBreakpoint) breakpoint).getBreakpoints()) {
				this.addOrUpdateBreakpoint(b, breakpointNode);
			}
		}
	}

	public void populate(Collection<Breakpoint> breakpoints) {

		if (breakpoints == null)
			return;
		
		List<Breakpoint> allBreakpoints = new LinkedList<Breakpoint>();
		for(Breakpoint b : breakpoints) {
			getNestedBreakpoints(b, allBreakpoints);
		}

		Iterator<Breakpoint> existingBreakpointsIterator = breakpointNodes.keySet().iterator();
		while (existingBreakpointsIterator.hasNext()) {
			Breakpoint existingBreakpoint = existingBreakpointsIterator.next();
			if (!allBreakpoints.contains(existingBreakpoint)) {
				breakpointNodes.get(existingBreakpoint).removeFromParent();
				existingBreakpointsIterator.remove();
			}
		}

		for (Breakpoint breakpoint : breakpoints) {
			this.addOrUpdateBreakpoint(breakpoint, manager.getRoot());
		}
	}

	public TreeContentManager getTreeContentManager() {
		return manager;
	}

}
