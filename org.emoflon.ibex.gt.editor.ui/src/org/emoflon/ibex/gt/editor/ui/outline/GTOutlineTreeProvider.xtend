package org.emoflon.ibex.gt.editor.ui.outline

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.IOutlineNode

import org.emoflon.ibex.gt.editor.gT.EditorPattern

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class GTOutlineTreeProvider extends DefaultOutlineTreeProvider {
	override _createNode(IOutlineNode parentNode, EObject modelElement) {
		if (modelElement instanceof EditorPattern) {
			super._createNode(parentNode, modelElement)
		}
		return
	}

	/**
	 * Customize the displayed text for the pattern.
	 */
	def _text(EditorPattern pattern) {
		var text = pattern.name
		if (pattern.abstract) {
			text += ' (abstract)'
		}
		if (pattern.superPatterns.size > 0) {
			text += ' -> ' + String.join(", ", pattern.superPatterns.map[it.name]);
		}
		return text
	}

	/**
	 * Avoid display as expandable nodes.
	 */
	def boolean _isLeaf(EditorPattern pattern) {
		return true;
	}
}
