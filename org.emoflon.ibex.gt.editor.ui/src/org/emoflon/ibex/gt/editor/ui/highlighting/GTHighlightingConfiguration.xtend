package org.emoflon.ibex.gt.editor.ui.highlighting

import java.util.HashSet

import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.emoflon.ibex.gt.editor.gT.EditorOperator

/** 
 * The configuration for syntax highlighting.
 */
class GTHighlightingConfiguration extends DefaultHighlightingConfiguration {
	static final String STYLE_PREFIX = "org.emoflon.ibex.gt.editor."
	public static final String CONTEXT = STYLE_PREFIX + "context"
	public static final String CREATE = STYLE_PREFIX + "create"
	public static final String DELETE = STYLE_PREFIX + "delete"
	public static final String REFINED = STYLE_PREFIX + "refined"
	public static final String ATR_CONSTR = STYLE_PREFIX + "attribute_constraint"

//	static final RGB BLACK = new RGB(0, 0, 0)
	static final RGB GREEN = new RGB(0, 128, 0)
	static final RGB RED = new RGB(255, 0, 0)
	static final RGB KEYWORD = new RGB(127, 0, 85)

	override void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		// I disabled the black color on purpose to allow GT files to be easily readable on
		// editors with a dark background color.
//		addStyle(acceptor, CONTEXT, "Context Nodes and References", BLACK, SWT.NORMAL)
		addStyle(acceptor, CREATE, "Created Nodes and References", GREEN, SWT.NORMAL)
		addStyle(acceptor, DELETE, "Deleted Nodes and References", RED, SWT.NORMAL)
		addStyle(acceptor, REFINED, "Refined Nodes", SWT.BOLD)
		addStyle(acceptor, ATR_CONSTR, "Attribute Constraint", KEYWORD, SWT.BOLD)
	}

	static def addStyle(IHighlightingConfigurationAcceptor acceptor, String id, String name, int style) {
		var TextStyle textStyle = new TextStyle()
		textStyle.style = style
		acceptor.acceptDefaultHighlighting(id, name, textStyle)
	}

	static def addStyle(IHighlightingConfigurationAcceptor acceptor, String id, String name, RGB color, int style) {
		var TextStyle textStyle = new TextStyle()
		textStyle.setColor(color)
		textStyle.style = style
		acceptor.acceptDefaultHighlighting(id, name, textStyle)
	}

	static def String[] getStyles(EditorOperator operator, boolean isRefined) {
		val styles = new HashSet
		styles.add(getStyle(operator))
		if (isRefined) {
			styles.add(REFINED)
		}
		return styles
	}

	static def getStyle(EditorOperator operator) {
		if (operator === EditorOperator.CREATE) {
			return CREATE
		}
		if (operator === EditorOperator.DELETE) {
			return DELETE
		}
		return CONTEXT
	}
}
