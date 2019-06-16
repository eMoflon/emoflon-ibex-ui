package org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeContentManager;

public class ProtocolContentManager {

    private TreeContentManager manager = new TreeContentManager();

    private List<ProtocolNode> protocolNodes;

    public ProtocolContentManager() {
	protocolNodes = new LinkedList<>();
    }

    public void populate(List<Set<EObject>> pProtocol) {
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
}
