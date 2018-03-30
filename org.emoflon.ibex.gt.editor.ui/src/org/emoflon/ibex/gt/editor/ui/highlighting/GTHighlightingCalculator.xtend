package org.emoflon.ibex.gt.editor.ui.highlighting

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Node

/** 
 * Applying syntax highlighting configuration.
 */
class GTHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	override void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
		CancelIndicator cancelIndicator) {
		if (resource === null || resource.contents.length === 0) {
			return
		}
		for (val contents = resource.allContents; contents.hasNext;) {
			hightlightElement(contents.next, acceptor)
		}
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator)
	}

	def hightlightElement(EObject element, IHighlightedPositionAcceptor acceptor) {
		if (element instanceof EditorAttribute) {
			if (element.relation == EditorRelation.ASSIGNMENT) {
				this.highlightNode(acceptor, element, getStyle(EditorOperator.CREATE))
			}
		}

		if (element instanceof Node) {
			var String style = getStyle(element.operator)
			if (element.operator == EditorOperator.CREATE || element.operator == EditorOperator.DELETE) {
				this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__OPERATOR, style)
			}
			this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__NAME, style)
			this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__TYPE, style)
		}

		if (element instanceof EditorReference) {
			var style = getStyle(element.operator)
			this.highlightNode(acceptor, element, style)
		}
	}

	def getStyle(EditorOperator operator) {
		if (operator === EditorOperator.CREATE) {
			return GTHighlightingConfiguration.CREATE
		}
		if (operator === EditorOperator.DELETE) {
			return GTHighlightingConfiguration.DELETE
		}
		return GTHighlightingConfiguration.CONTEXT
	}

	def highlightNode(IHighlightedPositionAcceptor acceptor, EObject element, String style) {
		val node = NodeModelUtils.getNode(element)
		acceptor.addPosition(node.getOffset(), node.getLength(), style)
	}

	def void highlightFeature(IHighlightedPositionAcceptor acceptor, EObject element, EStructuralFeature feature,
		String style) {
		for (node : NodeModelUtils.findNodesForFeature(element, feature)) {
			acceptor.addPosition(node.getOffset(), node.getLength(), style)
		}
	}
}
