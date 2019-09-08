package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class RuleNode extends TreeNode {

    private Rule rule;
    private boolean markBold;
    
    private int timesApplied = 0;

    protected RuleNode(Rule pRule) {
	rule = pRule;
    }

    public Rule getRule() {
	return rule;
    }

    public void setBold(boolean pBold) {
	markBold = pBold;
    }

    @Override
    protected String getLabel() {
	setFontStyle(markBold ? SWT.BOLD : SWT.NORMAL);
	return rule.getName() + " (matches: " + getChildren().size() + ", applied matches: "+timesApplied +")";
    }

    @Override
    protected Image getImage() {
	return null;
    }

    @Override
    protected Color getForeground() {
    	if (!hasChildren()) {
    		if(timesApplied > 0) {
    			return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
    		}
    		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
        }
    	else {
    		if(timesApplied > 0) {
    			return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLACK);
    		}
    		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLACK);
        }
    }

    @Override
    protected Color getBackground() {
		if (!hasChildren()) {
			if(timesApplied > 0) {
				return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
			}
			return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW);
	    }
		else {
			if(timesApplied > 0) {
				return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
			}
			return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW);
	    }
    }

	public int getTimesApplied() {
		return timesApplied;
	}

	public void increaseTimesApplied() {
		this.timesApplied++;
	}
}
