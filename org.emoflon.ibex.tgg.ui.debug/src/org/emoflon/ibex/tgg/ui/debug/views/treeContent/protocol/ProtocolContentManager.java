package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;

public class ProtocolContentManager {

    private TreeContentManager manager = new TreeContentManager();

    private List<ProtocolNode> protocolNodes;

    public ProtocolContentManager() {
	protocolNodes = new LinkedList<>();
    }

    public void populate(List<ProtocolStep> pProtocol) {
	// TODO perhaps a more elaborate handling is required here
	// this currently relies on new changes constantly showing up

	for (int i = protocolNodes.size(); i < pProtocol.size(); i++) {
	    ProtocolNode node = new ProtocolNode(i, pProtocol.get(i));
	    protocolNodes.add(node);
	    manager.getRoot().addChild(node);
	}
    }

    public TreeContentManager getTreeContentManager() {
	return manager;
    }

    public ViewerComparator getProtocolNodeComparator() {
	return new ViewerComparator() {
	    @Override
	    public int compare(Viewer pViewer, Object pElement1, Object pElement2) {
		if (!(pElement1 instanceof ProtocolNode && pElement2 instanceof ProtocolNode))
		    throw new IllegalStateException(
			    "Protocol view tree must not contain any elements other than ProtocolNodes");

		return ((ProtocolNode) pElement2).getStep() - ((ProtocolNode) pElement1).getStep();
	    }
	};
    }
}