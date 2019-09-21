package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class MatchNode extends TreeNode {

    private Match match;

    protected MatchNode(Match pMatch) {
	match = pMatch;
    }

    public Match getMatch() {
	return match;
    }

    @Override
    protected String getLabel() {
	return match.getName() + (match.isBlocked() ? "[" + match.getBlockingReason() + "]" : "");
    }

    @Override
    protected Image getImage() {
	return null;
    }

    @Override
    protected Color getForeground() {
	if (match.isBlocked())
	    return VictoryUI.getDisplay().getSystemColor(SWT.COLOR_RED);
	else
	    return null;
    }

    @Override
    protected Color getBackground() {
	return null;
    }
}
