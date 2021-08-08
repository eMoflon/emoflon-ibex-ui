package org.emoflon.ibex.tgg.ui.debug.views.treeContent.breakpointList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint.BreakpointEvaluationTime;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions.ToolTipOption;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class BreakpointNode extends TreeNode {
	
	private final Breakpoint breakpoint;
	private final IUserOptions userOptions;
	
	protected BreakpointNode(Breakpoint breakpoint, IUserOptions userOptions) {
		this.breakpoint = breakpoint;
		this.userOptions = userOptions;
	}
	
	public Breakpoint getBreakpoint() {
		return breakpoint;
	}

	@Override
	protected String getLabel() {
		return this.breakpoint.toString();
	}

	@Override
	protected String getToolTip() {
		if (userOptions.getToolTipSetting() == ToolTipOption.NONE) {
			return "";
		}
		String toolTip = "Breakpoint of type " + breakpoint.getClass().getName() + ":\n" 
				+ breakpoint.getHitCount() + " hits \n"
				+ "Evaluation time: ";
		switch(breakpoint.getBreakpointEvaluationTime()) {
		case ALWAYS: toolTip += "Always."; break;
		case OFF: toolTip += "Disabled."; break;
		case FOUND_MATCHES: toolTip += "After pattern matcher has found matches."; break;
		case MATCH_SELECTED: toolTip += "After update policy has automatically selected a match."; break;
		default: toolTip += "Unknown."; break;
		}
		return toolTip;		
	}

	@Override
	protected Image getImage() {
		return null;
	}

	@Override
	protected Color getForeground() {
		if(breakpoint.getBreakpointEvaluationTime() != BreakpointEvaluationTime.OFF && this.getParent() != null && this.getParent() instanceof BreakpointNode) {
			//parent is a combined breakpoint so node will be evaluated when parent gets evaluated
			return ((BreakpointNode) this.getParent()).getForeground();
		}
		
		switch(breakpoint.getBreakpointEvaluationTime()) {
		case ALWAYS : return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		case OFF : return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_GRAY);
		case FOUND_MATCHES : return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
		case MATCH_SELECTED : return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLUE);
		default: return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		}
	}

	@Override
	protected Color getBackground() {
		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
	}

}
