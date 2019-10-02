package org.emoflon.ibex.tgg.ui.debug.views.treeContent;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IToolTipProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode.TreeRootNode;

public class TreeContentManager
		implements ITreeContentProvider, IStyledLabelProvider, IColorProvider, IToolTipProvider {

	private TreeRootNode root = new TreeRootNode();

	public TreeNode getRoot() {
		return root;
	}

	public DelegatingStyledCellLabelProvider getCellLabelProvider() {
		return new DelegatingStyledCellLabelProvider(this);
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

	@Override
	public void dispose() {
		root.dispose();
	}

	/*
	 * ILabelProvider methods
	 */

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getImage(Object pElement) {
		if (pElement instanceof TreeNode)
			return ((TreeNode) pElement).getImage();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public StyledString getStyledText(Object pElement) {
		if (pElement instanceof TreeNode)
			return ((TreeNode) pElement).getCellLabel();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public String getToolTipText(Object pElement) {
		if (pElement instanceof TreeNode)
			return ((TreeNode) pElement).getToolTip();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	/*
	 * IColorProvider methods
	 */

	@Override
	public Color getForeground(Object pElement) {
		if (pElement instanceof TreeNode)
			return ((TreeNode) pElement).getForeground();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public Color getBackground(Object pElement) {
		if (pElement instanceof TreeNode)
			return ((TreeNode) pElement).getBackground();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}
}
