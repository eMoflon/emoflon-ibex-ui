package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class RuleApplicationNode extends TreeNode {

    private int index;
    private RuleApplication ruleApplication;

    public RuleApplicationNode(int pIndex, RuleApplication pStep) {
	index = pIndex;
	ruleApplication = pStep;
    }

    public int getStep() {
	return index;
    }

    public RuleApplication getModelChanges() {
	return ruleApplication;
    }

    @Override
    protected String getLabel() {
	return "Protocol step #" + index;
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
