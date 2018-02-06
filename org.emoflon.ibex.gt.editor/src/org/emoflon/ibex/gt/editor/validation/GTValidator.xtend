package org.emoflon.ibex.gt.editor.validation

import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check

import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Import
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.scoping.GTScopeProvider

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class GTValidator extends AbstractGTValidator {
	// Error names.
	public static val EMPTY_RULE = 'emptyRule'
	public static val INVALID_IMPORT = 'invalidImport'
	public static val INVALID_NAME_EXPECT_LOWER_CASE = 'invalidNameExpectLowerCase'
	public static val INVALID_NAME_EXPECT_UNIQUE = 'invalidNameExpectUnique'
	public static val INVALID_SUPER_RULES = 'invalidSuperRules'
	public static val MISSING_META_MODEL = 'missingMetaModel'

	// Error messages.
	public static val ERROR_MESSAGE_FILE_DOES_NOT_EXIST = 'The file %s does not exist.'
	public static val ERROR_MESSAGE_NO_META_MODEL = 'You must import the Ecore file of the meta-model.'

	public static val ERROR_MESSAGE_NODE_NAME_MULTIPLE_DECLARATIONS = 'Node %s must not be declared %s.'
	public static val ERROR_MESSAGE_NODE_NAME_STARTS_WITH_LOWER_CASE = 'Node name should start with a lower case character.'

	public static val ERROR_MESSAGE_RULE_DISTINCT_SUPER_RULES = 'Super rules must be distinct.'
	public static val ERROR_MESSAGE_RULE_NAME_MULTIPLE_DECLARATIONS = 'Rule %s must not be declared %s.'
	public static val ERROR_MESSAGE_RULE_NAME_STARTS_WITH_LOWER_CASE = 'Rule name should start with a lower case character.'
	public static val ERROR_MESSAGE_RULE_NOT_EMPTY = 'Rule must not be empty.'

	@Check
	def checkFile(GraphTransformationFile file) {
		if (file.imports.size === 0) {
			error(
				GTValidator.ERROR_MESSAGE_NO_META_MODEL,
				GTPackage.Literals.GRAPH_TRANSFORMATION_FILE__IMPORTS,
				GTValidator.MISSING_META_MODEL
			)
		}
	}

	@Check
	def checkImports(Import importEcore) {
		if (!GTScopeProvider.loadEcoreModel(importEcore.name).present) {
			error(
				String.format(GTValidator.ERROR_MESSAGE_FILE_DOES_NOT_EXIST, importEcore.name),
				GTPackage.Literals.IMPORT__NAME,
				GTValidator.INVALID_IMPORT
			)
		}
	}

	@Check
	def checkNode(Node node) {
		if (!Character.isLowerCase(node.name.charAt(0))) {
			warning(
				GTValidator.ERROR_MESSAGE_NODE_NAME_STARTS_WITH_LOWER_CASE,
				GTPackage.Literals.NODE__NAME,
				GTValidator.INVALID_NAME_EXPECT_LOWER_CASE
			)
		}

		// Node names within rule must be unique.
		val nodeContainer = node.eContainer
		if (nodeContainer !== null && nodeContainer instanceof Rule) {
			val rule = nodeContainer as Rule
			val nodeDeclarationsCount = rule.nodes.filter[node.name.equals(it.name)].size
			if (nodeDeclarationsCount !== 1) {
				error(
					String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_MULTIPLE_DECLARATIONS, node.name,
						getTimes(nodeDeclarationsCount)),
					GTPackage.Literals.NODE__NAME,
					GTValidator.INVALID_NAME_EXPECT_UNIQUE
				)
			}
		}
	}

	@Check
	def checkRule(Rule rule) {
		// The rule name should start with a lower case character.
		if (!Character.isLowerCase(rule.name.charAt(0))) {
			warning(
				GTValidator.ERROR_MESSAGE_RULE_NAME_STARTS_WITH_LOWER_CASE,
				GTPackage.Literals.RULE__NAME,
				GTValidator.INVALID_NAME_EXPECT_LOWER_CASE
			)
		}

		// The rule must contain at least one constraint or refine multiple rules.
		if (rule.nodes.size == 0 && rule.superRules.size < 2) {
			error(
				GTValidator.ERROR_MESSAGE_RULE_NOT_EMPTY,
				GTPackage.Literals.RULE__NODES,
				GTValidator.EMPTY_RULE
			)
		}

		// The super rules of the rule must be distinct.
		if (rule.superRules.size !== rule.superRules.stream.distinct.count) {
			error(
				GTValidator.ERROR_MESSAGE_RULE_DISTINCT_SUPER_RULES,
				GTPackage.Literals.RULE__SUPER_RULES,
				GTValidator.INVALID_SUPER_RULES
			)
		}

		// Rule names must be unique.
		val rootElement = EcoreUtil2.getRootContainer(rule)
		val candidates = EcoreUtil2.getAllContentsOfType(rootElement, Rule)
		val ruleDeclarationCount = candidates.filter[name.equals(rule.name)].size
		if (ruleDeclarationCount !== 1) {
			error(
				String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_MULTIPLE_DECLARATIONS, rule.name,
					getTimes(ruleDeclarationCount)),
				GTPackage.Literals.RULE__NAME,
				GTValidator.INVALID_NAME_EXPECT_UNIQUE
			)
		}
	}

	/**
	 * Converts an integer into a "... times" String.
	 */
	def static String getTimes(int count) {
		switch (count) {
			case 1: {
				return 'once'
			}
			case 2: {
				return 'twice'
			}
			default: {
				return count + ' times'
			}
		}
	}
}
