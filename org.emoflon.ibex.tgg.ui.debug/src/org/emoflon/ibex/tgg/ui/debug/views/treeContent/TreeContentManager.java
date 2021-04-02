package org.emoflon.ibex.tgg.ui.debug.views.treeContent;

import java.util.Arrays;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IToolTipProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode.TreeRootNode;

public class TreeContentManager
		extends StyledCellLabelProvider
		implements ITreeContentProvider, IStyledLabelProvider, IColorProvider, IToolTipProvider 
		 {

	private TreeRootNode root = new TreeRootNode();

	public TreeNode getRoot() {
		return root;
	}

	public IBaseLabelProvider getCellLabelProvider() {
		return this;
	}
	
	public TreeContentManager(int style) {
		super(style);
	}

	/*
	 * ITreeContentProvider methods
	 */

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof TreeNode)
			return ((TreeNode) inputElement).getChildren().toArray();
		else
			return root.getChildren().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TreeNode)
			return ((TreeNode) parentElement).getChildren().toArray();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getParent();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).hasChildren();
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
	public Image getImage(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getImage();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getCellLabel();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public String getToolTipText(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getToolTip();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	/*
	 * IColorProvider methods
	 */

	@Override
	public Color getForeground(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getForeground();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}

	@Override
	public Color getBackground(Object element) {
		if (element instanceof TreeNode)
			return ((TreeNode) element).getBackground();
		else
			throw new IllegalStateException("Tree must not contain any elements other than TreeNodes");
	}
	
	@Override
	public void update(ViewerCell cell) {
		//Taken from DelegatingStyledCellLabelProvider
		Object element = cell.getElement();

		StyledString styledString = getStyledText(element);
		String newText= styledString.toString();

		StyleRange[] oldStyleRanges= cell.getStyleRanges();
		StyleRange[] newStyleRanges= isOwnerDrawEnabled() ? styledString.getStyleRanges() : null;

		if (!Arrays.equals(oldStyleRanges, newStyleRanges)) {
			cell.setStyleRanges(newStyleRanges);
			if (cell.getText().equals(newText)) {
				// make sure there will be a refresh from a change
				cell.setText(""); //$NON-NLS-1$
			}
		}

		cell.setText(newText);
		cell.setImage(getImage(element));
//		cell.setFont(getFont(element));
		cell.setForeground(getForeground(element));
		cell.setBackground(getBackground(element));

		// no super call required. changes on item will trigger the refresh.
	}
}
