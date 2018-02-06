package org.emoflon.ibex.gt.editor.ui.highlighting

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Reference

/** 
 * Applying syntax highlighting configuration.
 * 
 * @author Patrick Robrecht
 */
class GTHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	override void provideHighlightingFor(XtextResource resource,
		IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource === null || resource.contents.length === 0) {
			return
		}
		for (val contents = resource.allContents; contents.hasNext;) {
			hightlightElement(contents.next, acceptor)
		}
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator)
	}

	def hightlightElement(EObject element, IHighlightedPositionAcceptor acceptor) {
		if (element instanceof Node) {
			val style = GTHighlightingConfiguration.getStyle(element.bindingType)
			this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__BINDING_TYPE, style)
			this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__NAME, style)
			this.highlightFeature(acceptor, element, GTPackage.Literals.NODE__TYPE, style)
		}
		if (element instanceof Reference) {
			val style = GTHighlightingConfiguration.getStyle(element.bindingType)
			this.highlightNode(acceptor, element, style)
		}
	}

	def highlightNode(IHighlightedPositionAcceptor acceptor, EObject element, String style) {
		val node = NodeModelUtils.getNode(element)
		acceptor.addPosition(node.getOffset(), node.getLength(), style)
	}

	def void highlightFeature(IHighlightedPositionAcceptor acceptor, EObject element, EStructuralFeature feature, String style) {
		for (node: NodeModelUtils.findNodesForFeature(element, feature)) {
			acceptor.addPosition(node.getOffset(), node.getLength(), style)
        }
	}
}
