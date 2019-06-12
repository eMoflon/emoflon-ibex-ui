package org.emoflon.ibex.tgg.ui.debug.views.treeContent;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode.TreeRootNode;

public class TreeContentManager implements ITreeContentProvider, ILabelProvider {

    private TreeRootNode root = new TreeRootNode();

    public TreeNode getRoot() {
	return root;
    }

    /*
     * ITreeContentProvider methods
     */

    @Override
    public Object[] getElements(Object pInputElement) {
	if (pInputElement instanceof TreeNode)
	    return ((TreeNode) pInputElement).getChildren().toArray();
	else
	    return root.getChildren().toArray();
    }

    @Override
    public Object[] getChildren(Object pParentElement) {
	if (pParentElement instanceof TreeNode)
	    return ((TreeNode) pParentElement).getChildren().toArray();
	else
	    throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
    }

    @Override
    public Object getParent(Object pElement) {
	if (pElement instanceof TreeNode)
	    return ((TreeNode) pElement).getParent();
	else
	    throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
    }

    @Override
    public boolean hasChildren(Object pElement) {
	if (pElement instanceof TreeNode)
	    return ((TreeNode) pElement).hasChildren();
	else
	    throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
    }

    /*
     * ILabelProvider methods
     */

    @Override
    public void addListener(ILabelProviderListener listener) {

	System.out.println("Something tried to register a listener");

    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
	return true;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
	// TODO Auto-generated method stub

    }

    @Override
    public Image getImage(Object pElement) {
	if (pElement instanceof TreeNode)
	    return ((TreeNode) pElement).getImage();
	else
	    throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
    }

    @Override
    public String getText(Object pElement) {
	if (pElement instanceof TreeNode)
	    return ((TreeNode) pElement).getLabel();
	else
	    throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
    }

    @Override
    public void dispose() {
	root.dispose();
    }
}
