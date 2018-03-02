package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Import
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.validation.GTValidator

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class GTQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(GTValidator.IMPORT_DUPLICATE)
	@Fix(GTValidator.IMPORT_FILE_DOES_NOT_EXIST)
	def removeDuplicateImport(Issue issue, IssueResolutionAcceptor acceptor) {
		var label = 'Remove import.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Import) {
					val file = element.eContainer as GraphTransformationFile
					file.imports.remove(element)
				}
			]
		)
	}

	@Fix(GTValidator.NAME_EXPECT_LOWER_CASE)
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

	private def convertNodeNameToLowerCase(Node node) {
		node.name = node.name.toFirstLower
	}

	private def convertRuleNameToLowerCase(Rule rule) {
		rule.name = rule.name.toFirstLower
	}

	@Fix(GTValidator.NAME_EXPECT_CAMEL_CASE)
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

	private def convertNodeNameToLowerCamelCase(Node node) {
		// Keep leading _ if present before.
		node.name = (if(node.name.startsWith('_')) '_' else '') + convertToLowerCamelCase(node.name)
	}

	private def convertRuleNameToLowerCamelCase(Rule rule) {
		rule.name = convertToLowerCamelCase(rule.name)
	}

	private def convertToLowerCamelCase(String s) {
		var camelCase = ''
		for (part : s.split('_')) {
			if (part.length > 0) {
				camelCase = camelCase + part.substring(0, 1).toUpperCase + part.substring(1).toLowerCase
			}
		}
		return camelCase.toFirstLower
	}
}
