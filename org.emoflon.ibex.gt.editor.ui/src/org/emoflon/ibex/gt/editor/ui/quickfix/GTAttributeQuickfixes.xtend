package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment
import org.emoflon.ibex.gt.editor.gT.EditorNode

/**
 * Quickfixes for attributes.
 */
class GTAttributeQuickfixes {

	/**
	 * Changes the relation of the attribute.
	 */
	static def changeAttributeRelation(Issue issue, IssueResolutionAcceptor acceptor, String text,
		EditorRelation newRelation) {
		val attributeName = issue.data.get(0)
		val label = String.format(text, attributeName)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorAttributeConstraint) {
					element.relation = newRelation
				}
			]
		)
	}
	
	/**
	 * Removes an attribute.
	 */
	static def removeAttribute(Issue issue, IssueResolutionAcceptor acceptor, String name) {
		val attributeName = issue.data.get(0)
		val label = '''Remove «name» for attribute '«attributeName»'.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorAttributeConstraint) {
					val pattern = element.eContainer as EditorPattern
					pattern.attributeConstraints.remove(element)
				}
				if(element instanceof EditorAttributeAssignment) {
					val node = element.eContainer as EditorNode
					node.attributes.remove(element)
				}
			]
		)
	}
}
