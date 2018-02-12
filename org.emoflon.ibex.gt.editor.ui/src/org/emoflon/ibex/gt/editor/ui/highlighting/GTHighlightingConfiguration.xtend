package org.emoflon.ibex.gt.editor.ui.highlighting

import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle

import org.emoflon.ibex.gt.editor.gT.BindingType

/** 
 * The configuration for syntax highlighting.
 * 
 * @author Patrick Robrecht
 */
class GTHighlightingConfiguration extends DefaultHighlightingConfiguration {
	public static final String CONTEXT = "Context"
	public static final String CREATE = "Create"
	public static final String DELETE = "Delete"

	private static final RGB BLACK = new RGB(0, 0, 0)
	private static final RGB GREEN = new RGB(0, 128, 0)
	private static final RGB RED = new RGB(255, 0, 0)

	override void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		addStyle(acceptor, CREATE, "Create Nodes and References", GREEN, SWT.NORMAL)
		addStyle(acceptor, CONTEXT, "Context Nodes and References", BLACK, SWT.NORMAL)
		addStyle(acceptor, DELETE, "Delete Nodes and References", RED, SWT.NORMAL)
	}

	def static addStyle(IHighlightingConfigurationAcceptor acceptor, String id, String name, RGB color, int style) {
		var TextStyle textStyle = new TextStyle()
		textStyle.setColor(color)
		textStyle.style = style
		acceptor.acceptDefaultHighlighting(id, name, textStyle)
	}

	def static getStyle(BindingType bindingType) {
		switch (bindingType) {
			case BindingType.CONTEXT:	GTHighlightingConfiguration.CONTEXT
			case BindingType.CREATE:	GTHighlightingConfiguration.CREATE
			case BindingType.DELETE: 	GTHighlightingConfiguration.DELETE
		}
	}
}
