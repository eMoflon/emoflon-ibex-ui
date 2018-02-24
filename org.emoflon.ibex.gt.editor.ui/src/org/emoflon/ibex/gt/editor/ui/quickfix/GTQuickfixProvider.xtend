package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Rule

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class GTQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(GTValidator.INVALID_NAME_EXPECT_LOWER_CASE)
	def convertNameToLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lower case.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Node) {
					convertNodeNameToLowerCase(element as Node)
				} else if (element instanceof Rule) {
					convertRuleNameToLowerCase(element as Rule)
				}
			]
		)
	}

	def convertNodeNameToLowerCase(Node node) {
		node.name = node.name.toFirstLower
	}

	def convertRuleNameToLowerCase(Rule rule) {
		rule.name = rule.name.toFirstLower
	}

	@Fix(GTValidator.INVALID_NAME_EXPECT_CAMEL_CASE)
	def convertNameToLowerCamelCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lowerCamelCase.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Node) {
					convertNodeNameToLowerCamelCase(element as Node)
				} else if (element instanceof Rule) {
					convertRuleNameToLowerCamelCase(element as Rule)
				}
			]
		)
	}

	def convertNodeNameToLowerCamelCase(Node node) {
		// Keep leading _ if present before.
		node.name = (if(node.name.startsWith('_')) '_' else '') + convertToLowerCamelCase(node.name)
	}

	def convertRuleNameToLowerCamelCase(Rule rule) {
		rule.name = convertToLowerCamelCase(rule.name)
	}

	def convertToLowerCamelCase(String s) {
		var camelCase = ''
		for (part : s.split('_')) {
			if (part.length > 0) {
				camelCase = camelCase + part.substring(0, 1).toUpperCase + part.substring(1).toLowerCase
			}
		}
		return camelCase.toFirstLower
	}
}
