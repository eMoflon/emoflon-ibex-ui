package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorReference

/**
 * Quickfixes for references.
 */
class GTReferenceQuickfixes {

	/**
	 * Changes the operator of the reference affected by the issue.
	 */
	static def changeReferenceOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		EditorOperator newOperator) {
		val referenceTypeName = issue.data?.get(0)
		val referenceTargetNodeName = issue.data?.get(1)
		val label = '''Convert reference '«referenceTypeName» -> «referenceTargetNodeName»' to a «operatorName» reference.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorReference) {
					element.operator = newOperator
				}
			]
		)
	}
}
