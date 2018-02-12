package org.emoflon.ibex.gt.editor.ui.outline

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.IOutlineNode

import org.emoflon.ibex.gt.editor.gT.Rule

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class GTOutlineTreeProvider extends DefaultOutlineTreeProvider {
	override _createNode(IOutlineNode parentNode, EObject modelElement) {
		if (modelElement instanceof Rule) {
			super._createNode(parentNode, modelElement)
		}
		return
	}

	/**
	 * Customize the displayed text for rules.
	 */
	def _text(Rule rule) {
		var text = rule.name
		if (rule.abstract) {
			text += ' (abstract)'
		}
		if (rule.superRules.size > 0) {
			text += ' -> ' + String.join(", ", rule.superRules.map[it.name]);
		}
		return text
	}

	/**
	 * Avoid display as expandable nodes.
	 */
	def boolean _isLeaf(Rule rule) {
		return true;
	}
}
