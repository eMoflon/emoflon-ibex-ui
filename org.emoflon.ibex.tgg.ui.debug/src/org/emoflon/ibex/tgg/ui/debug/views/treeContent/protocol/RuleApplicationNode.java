package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class RuleApplicationNode extends TreeNode {

    private int index;
    private RuleApplication ruleApplication;
    private boolean markBold = false;

    public RuleApplicationNode(int pIndex, RuleApplication pStep) {
	index = pIndex;
	ruleApplication = pStep;
    }

    public int getStep() {
	return index;
    }
    
    public void setBold(boolean pBold) {
    	markBold = pBold;
    }

    public RuleApplication getModelChanges() {
	return ruleApplication;
    }

    @Override
    protected String getLabel() {
    	setFontStyle(markBold ? SWT.BOLD : SWT.NORMAL);
    	return "Rule application #" + index + ": "+ruleApplication.getRuleName();
    }

    @Override
    protected Image getImage() {
	return null;
    }

    @Override
    protected Color getForeground() {
	return null;
    }

    @Override
    protected Color getBackground() {
	return null;
    }
}
