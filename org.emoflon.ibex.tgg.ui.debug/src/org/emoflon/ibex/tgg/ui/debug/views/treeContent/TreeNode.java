package org.emoflon.ibex.tgg.ui.debug.views.treeContent;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.swt.graphics.Image;

public abstract class TreeNode {
    private TreeNode parent;
    private Collection<TreeNode> children = new HashSet<>();

    public void addChild(TreeNode pNode) {
	if (pNode.parent != null)
	    throw new IllegalStateException("The specified node is already the child of another node");

	children.add(pNode);
	pNode.parent = this;
    }

    public void removeChild(TreeNode pNode) {
	if (children.contains(pNode)) {
	    children.remove(pNode);
	    pNode.parent = null;
	}
    }

    public void clearChildren() {
	for (TreeNode child : children)
	    removeChild(child);
    }

    public void removeFromParent() {
	parent.removeChild(this);
    }

    protected abstract String getLabel();

    protected abstract Image getImage();

    /**
     * Called when this node is disposed. Specifically intended to dispose of any
     * image resources that might have been cached by a subclass.<br>
     * Recursively calls this method on its children. Any subclasses that override
     * this method must take care to call this implementation at some point.
     */
    protected void dispose() {
	for (TreeNode child : children)
	    child.dispose();
    }

    public TreeNode getParent() {
	return parent;
    }

    public Collection<TreeNode> getChildren() {
	return children;
    }

    public boolean hasChildren() {
	return !children.isEmpty();
    }

    public final static class TreeRootNode extends TreeNode {
	@Override
	public String getLabel() {
	    return null;
	}

	@Override
	public Image getImage() {
	    return null;
	}
    }
}
