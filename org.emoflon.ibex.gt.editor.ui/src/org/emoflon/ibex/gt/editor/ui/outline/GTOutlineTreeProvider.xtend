package org.emoflon.ibex.gt.editor.ui.outline

import com.google.inject.Inject

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.IImageHelper
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorPatternType
import org.emoflon.ibex.gt.editor.gT.EditorCondition

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class GTOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Inject
	private IImageHelper imageHelper

	override _createNode(IOutlineNode parentNode, EObject modelElement) {
		if (modelElement instanceof EditorPattern || modelElement instanceof EditorCondition) {
			super._createNode(parentNode, modelElement)
		}
		return
	}

	/**
	 * Avoid display patterns as expandable nodes.
	 */
	def _isLeaf(EditorPattern pattern) {
		return true;
	}

	/**
	 * Avoid display conditions as expandable nodes.
	 */
	def _isLeaf(EditorCondition condition) {
		return true;
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
	 * Customize the image for patterns/rules.
	 */
	def _image(EditorPattern pattern) {
		if (pattern.type == EditorPatternType.RULE) {
			return imageHelper.getImage('gt-rule.gif')
		}
		return imageHelper.getImage('gt-pattern.gif')
	}
	
	/**
	 * Customize the image for conditions.
	 */
	def _image(EditorCondition condition) {
		return imageHelper.getImage('gt-condition.gif')
	}
}
