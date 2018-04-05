package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorRelation

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
				if (element instanceof EditorAttribute) {
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
				if (element instanceof EditorAttribute) {
					val node = element.eContainer as EditorNode
					node.attributes.remove(element)
				}
			]
		)
	}
}
