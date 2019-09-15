package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class RuleNode extends TreeNode {

    private Rule rule;
    
    private int timesApplied = 0;

    protected RuleNode(Rule pRule) {
	rule = pRule;
    }

    public Rule getRule() {
	return rule;
    }

    @Override
    protected String getLabel() {
    	this.setStrikethrough(!hasChildren() && !(timesApplied > 0));
    	
    	if(hasChildren() && !(timesApplied > 0)) {
    		setFontStyle(SWT.BOLD);
    	} else {
    		setFontStyle(SWT.NORMAL);
    	}
		return rule.getName() + " (matches: " + getChildren().size() + ", applied matches: "+timesApplied +")";
    }

    @Override
    protected Image getImage() {
	return null;
    }

    @Override
    protected Color getForeground() {
    	if (hasChildren()) {
    			return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_BLACK);
		}
    	else {
    		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
        }
    }

    @Override
    protected Color getBackground() {
    	if(hasChildren()) {
    		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_WHITE);
    	} else {
    		return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
    	}
    }

	public int getTimesApplied() {
		return timesApplied;
	}

	public void increaseTimesApplied() {
		this.timesApplied++;
	}
}
