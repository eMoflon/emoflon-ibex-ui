package org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class MatchNode extends TreeNode {

    private IMatch match;
    private String matchName;

    protected MatchNode(IMatch pMatch, String pMatchName) {
	match = pMatch;
	matchName = pMatchName;
    }

    public IMatch getMatch() {
	return match;
    }

    @Override
    protected String getLabel() {
	return matchName;
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
