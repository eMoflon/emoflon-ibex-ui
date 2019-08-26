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
	return rule.getName() + " (" + getChildren().size() + ")";
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
	if (!hasChildren())
	    return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_GRAY);
	else
	    return null;
    }
}
