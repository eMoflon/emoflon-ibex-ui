package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class ProtocolNode extends TreeNode {

    private int step;
    private Set<EObject> changes;

    public ProtocolNode(int pStep, Set<EObject> pChanges) {
	step = pStep;
	changes = pChanges;
    }

    public int getStep() {
	return step;
    }

    public Set<EObject> getChanges() {
	return changes;
    }

    @Override
    protected String getLabel() {
	return "Protocol step #" + step;
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
