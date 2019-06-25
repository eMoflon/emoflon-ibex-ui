package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;

public class ProtocolNode extends TreeNode {

    private int index;
    private ProtocolStep step;

    public ProtocolNode(int pIndex, ProtocolStep pStep) {
	index = pIndex;
	step = pStep;
    }

    public int getStep() {
	return index;
    }

    public Set<EObject> getModelChanges() {
	Set<EObject> changes = new HashSet<EObject>();
	changes.addAll(step.getSrcElements());
	changes.addAll(step.getTrgElements());
	return changes;
    }

    public Set<EObject> getCorrChanges() {
	return step.getCorrElements();
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
