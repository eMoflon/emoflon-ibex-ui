package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryMatch;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class MatchNode extends TreeNode {

    private VictoryMatch match;

    protected MatchNode(VictoryMatch pMatch) {
	match = pMatch;
    }

    public VictoryMatch getMatch() {
	return match;
    }

    @Override
    protected String getLabel() {
	return match.getName();
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
