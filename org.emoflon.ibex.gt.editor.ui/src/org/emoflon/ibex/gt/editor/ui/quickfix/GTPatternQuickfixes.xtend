package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorPatternType

/**
 * Quickfixes for patterns.
 */
class GTPatternQuickfixes {

	/**
	 * Changes a pattern type.
	 */
	public static def changePatternType(Issue issue, IssueResolutionAcceptor acceptor, EditorPatternType oldType,
		EditorPatternType newType) {
		val patternName = issue.data?.get(0)
		var label = '''Change «oldType.toString» '«patternName»' to a «newType.toString».'''
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

	/**
	 * Remove duplicate conditions.
	 */
	public static def makeConditionsDistinct(Issue issue, IssueResolutionAcceptor acceptor) {
		val name = issue.data?.get(0)
		val label = '''Remove duplicate conditions declarations of «name».'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorPattern) {
					val uniqueConditions = newHashSet()
					uniqueConditions.addAll(element.conditions.clone)
					element.conditions.clear
					element.conditions.addAll(uniqueConditions)
				}
			]
		)
	}

	/**
	 * Remove duplicate super patterns.
	 */
	public static def makeSuperPatternsDistinct(Issue issue, IssueResolutionAcceptor acceptor) {
		val ruleName = issue.data?.get(0)
		val label = '''Remove duplicate super rule declarations of rule «ruleName».'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorPattern) {
					val uniqueSuperPatterns = newHashSet()
					uniqueSuperPatterns.addAll(element.superPatterns.clone)
					element.superPatterns.clear
					element.superPatterns.addAll(uniqueSuperPatterns)
				}
			]
		)
	}

	/**
	 * Makes the pattern abstract.
	 */
	public static def makeAbstract(Issue issue, IssueResolutionAcceptor acceptor) {
		val name = issue.data?.get(1)
		val label = '''Make rule '«name»' abstract.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				val rule = element.eContainer
				if (rule instanceof EditorPattern) {
					rule.abstract = true
				}
			],
			3
		)
	}

	/**
	 * Removes all conditions of the pattern.
	 */
	public static def removeConditions(Issue issue, IssueResolutionAcceptor acceptor) {
		val name = issue.data?.get(0)
		val label = '''Remove all conditions of «name».'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorPattern) {
					element.conditions.clear
				}
			]
		)
	}
}
