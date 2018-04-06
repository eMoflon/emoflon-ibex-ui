package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorPattern

/**
 * Quickfixes for node/parameter/pattern names.
 */
class GTNameQuickfixes {

	/**
	 * Converts the name of a node, a parameter or a pattern to lower case. 
	 */
	static def toLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lower case.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorNode) {
					element.name = element.name.toFirstLower
				} else if (element instanceof EditorParameter) {
					element.name = element.name.toFirstLower
				} else if (element instanceof EditorPattern) {
					element.name = element.name.toFirstLower
				}
			]
		)
	}

	/**
	 * Converts the name of a node, a parameter or a pattern to lowerCamelCase.
	 */
	static def toLowerCamelCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lowerCamelCase.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorNode) {
					val node = element as EditorNode
					// Keep leading _ if present before (local node!).
					node.name = (if(node.name.startsWith('_')) '_' else '') + toLowerCamelCase(node.name)
				} else if (element instanceof EditorParameter) {
					element.name = toLowerCamelCase(element.name)
				} else if (element instanceof EditorPattern) {
					element.name = toLowerCamelCase(element.name)
				}
			]
		)
	}

	/**
	 * Converts the string to lowerCamelCase.
	 */
	private static def toLowerCamelCase(String s) {
		var camelCase = ''
		for (part : s.split('_')) {
			if (part.length > 0) {
				camelCase = camelCase + part.substring(0, 1).toUpperCase + part.substring(1).toLowerCase
			}
		}
		return camelCase.toFirstLower
	}
}
