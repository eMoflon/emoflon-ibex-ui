package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.core.IbexDebugUI;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

import language.TGGRule;

public class RuleNode extends TreeNode {

    private TGGRule rule;

    protected RuleNode(TGGRule pRule) {
	rule = pRule;
    }

    public TGGRule getRule() {
	return rule;
    }

    @Override
    protected String getLabel() {
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
	    return IbexDebugUI.getDisplay().getSystemColor(SWT.COLOR_GRAY);
	else
	    return null;
    }
}
