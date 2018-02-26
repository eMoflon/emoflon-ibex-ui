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
	/**
	 * The list of invalid node names.
	 */
	private static val nodeNameBlacklist = #["class", "rule"]

	/**
	 * The list of invalid rule names.
	 */
	private static val ruleNameBlacklist = #["clone", "equals", "finalize", "getClass", "hashCode", "notify",
		"notifyAll", "toString", "wait"]

	// Error names.
	public static val EMPTY_RULE = 'emptyRule'

	public static val DUPLICATE_IMPORT = 'duplicateImport'

	public static val INVALID_IMPORT = 'invalidImport'
	public static val INVALID_NAME_BLACKLISTED = 'invalidNameBlacklisted'
	public static val INVALID_NAME_EXPECT_CAMEL_CASE = 'invalidNameExpectCamelCase'
	public static val INVALID_NAME_EXPECT_LOWER_CASE = 'invalidNameExpectLowerCase'
	public static val INVALID_NAME_EXPECT_UNIQUE = 'invalidNameExpectUnique'
	public static val INVALID_SUPER_RULES = 'invalidSuperRules'
	public static val MISSING_META_MODEL = 'missingMetaModel'

	// Error messages.
	public static val ERROR_MESSAGE_FILE_DOES_NOT_EXIST = 'The file %s does not exist.'
	public static val ERROR_MESSAGE_NO_META_MODEL = 'You must import the Ecore file of the meta-model.'

	public static val ERROR_MESSAGE_IMPORT_MULTIPLE_DECLARATIONS = 'Import %s must not be declared %s.'

	public static val ERROR_MESSAGE_NODE_NAME_CONTAINS_UNDERSCORES = 'Node name %s contains underscores. Use camelCase instead.'
	public static val ERROR_MESSAGE_NODE_NAME_FORBIDDEN = 'Nodes cannot be named %s. Use a different name.'
	public static val ERROR_MESSAGE_NODE_NAME_MULTIPLE_DECLARATIONS = 'Node %s must not be declared %s.'
	public static val ERROR_MESSAGE_NODE_NAME_STARTS_WITH_LOWER_CASE = 'Node %s should start with a lower case character.'

	public static val ERROR_MESSAGE_RULE_DISTINCT_SUPER_RULES = 'Super rules must be distinct.'
	public static val ERROR_MESSAGE_RULE_NAME_CONTAINS_UNDERSCORES = 'Rule name %s contains underscores. Use camelCase instead.'
	public static val ERROR_MESSAGE_RULE_NAME_FORBIDDEN = 'Rules cannot be named %s. Use a different name.'
	public static val ERROR_MESSAGE_RULE_NAME_MULTIPLE_DECLARATIONS = 'Rule %s must not be declared %s.'
	public static val ERROR_MESSAGE_RULE_NAME_STARTS_WITH_LOWER_CASE = 'Rule %s should start with a lower case character.'
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

		// Imports must be unique.
		val rootElement = EcoreUtil2.getRootContainer(importEcore)
		val candidates = EcoreUtil2.getAllContentsOfType(rootElement, Import)
		val importDeclarationCount = candidates.filter[name.equals(importEcore.name)].size
		if (importDeclarationCount !== 1) {
			warning(
				String.format(GTValidator.ERROR_MESSAGE_IMPORT_MULTIPLE_DECLARATIONS, importEcore.name,
					getTimes(importDeclarationCount)),
				GTPackage.Literals.IMPORT__NAME,
				GTValidator.DUPLICATE_IMPORT
			)
		}
	}

	@Check
	def checkNode(Node node) {
		// The node name must not be blacklisted.
		if (nodeNameBlacklist.contains(node.name)) {
			error(
				String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_FORBIDDEN, node.name),
				GTPackage.Literals.NODE__NAME,
				GTValidator.INVALID_NAME_BLACKLISTED
			)
		} else {
			// Note: _ is only allowed as first character.
			// The node name should be lowerCamelCase.
			if (node.name.substring(1).contains('_')) {
				warning(
					String.format(ERROR_MESSAGE_NODE_NAME_CONTAINS_UNDERSCORES, node.name),
					GTPackage.Literals.NODE__NAME,
					GTValidator.INVALID_NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The node name should start with a lower case character.
				val firstCharacter = node.name.charAt(0)
				if (Character.isUpperCase(firstCharacter)) {
					warning(
						String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_STARTS_WITH_LOWER_CASE, node.name),
						GTPackage.Literals.NODE__NAME,
						GTValidator.INVALID_NAME_EXPECT_LOWER_CASE
					)
				}
			}
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
		// The rule name must not be blacklisted.
		if (ruleNameBlacklist.contains(rule.name)) {
			error(
				String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_FORBIDDEN, rule.name),
				GTPackage.Literals.RULE__NAME,
				GTValidator.INVALID_NAME_BLACKLISTED
			)
		} else {
			// The rule name should be lowerCamelCase.
			if (rule.name.contains('_')) {
				warning(
					String.format(ERROR_MESSAGE_RULE_NAME_CONTAINS_UNDERSCORES, rule.name),
					GTPackage.Literals.RULE__NAME,
					GTValidator.INVALID_NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The rule name should start with a lower case character. 
				if (!Character.isLowerCase(rule.name.charAt(0))) {
					warning(
						String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_STARTS_WITH_LOWER_CASE, rule.name),
						GTPackage.Literals.RULE__NAME,
						GTValidator.INVALID_NAME_EXPECT_LOWER_CASE
					)
				}
			}
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
			case 1:
				return 'once'
			case 2:
				return 'twice'
			default:
				return count + ' times'
		}
	}
}
