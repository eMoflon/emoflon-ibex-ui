package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorPatternType

/**
 * Quickfixes on patterns.
 */
class GTPatternQuickfixes {

	/**
	 * Accepts a pattern type change.
	 */
	public static def acceptPatternTypeChange(Issue issue, IssueResolutionAcceptor acceptor, EditorPatternType oldType,
		EditorPatternType newType) {
		val patternName = issue.data?.get(0)
		var label = '''Change «oldType.toString» '«patternName»' to a «newType.toString».'''
		println(label)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				val pattern = element as EditorPattern
				if (pattern.type === oldType) {
					pattern.type = newType
				}
			]
		)
	}
}
