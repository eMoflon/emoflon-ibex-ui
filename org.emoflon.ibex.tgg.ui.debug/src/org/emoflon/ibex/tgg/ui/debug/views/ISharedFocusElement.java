package org.emoflon.ibex.tgg.ui.debug.views;

public interface ISharedFocusElement {

	public void registerSharedFocus(ISharedFocusElement pSharedFocusElement);

	public void focusRemoved();
}
