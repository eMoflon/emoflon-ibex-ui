package org.emoflon.ibex.gt.editor.ui.highlighting

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils

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
				val style = GTHighlightingConfiguration.getStyle(EditorOperator.CREATE)
				highlight(acceptor, element, style)
			}
		}

		if (element instanceof EditorNode) {
			val nodesFromSuperRules = GTEditorPatternUtils.getAllNodesFromSuperPatterns(
				element.eContainer as EditorPattern, [it.name.equals(element.name)])
			val styles = GTHighlightingConfiguration.getStyles(element.operator, !nodesFromSuperRules.isEmpty)

			if (element.operator == EditorOperator.CREATE || element.operator == EditorOperator.DELETE) {
				highlight(acceptor, element, GTPackage.Literals.EDITOR_NODE__OPERATOR, styles)
			}
			highlight(acceptor, element, GTPackage.Literals.EDITOR_NODE__NAME, styles)
			highlight(acceptor, element, GTPackage.Literals.EDITOR_NODE__TYPE, styles)
		}

		if (element instanceof EditorReference) {
			val style = GTHighlightingConfiguration.getStyle(element.operator)
			highlight(acceptor, element, style)
		}
	}

	static def highlight(IHighlightedPositionAcceptor acceptor, EObject element, String... style) {
		val node = NodeModelUtils.getNode(element)
		acceptor.addPosition(node.getOffset(), node.getLength(), style)
	}

	static def void highlight(IHighlightedPositionAcceptor acceptor, EObject element, EStructuralFeature feature,
		String... style) {
		for (node : NodeModelUtils.findNodesForFeature(element, feature)) {
			acceptor.addPosition(node.getOffset(), node.getLength(), style)
		}
	}
}
