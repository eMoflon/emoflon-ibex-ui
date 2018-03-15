package org.emoflon.ibex.gt.editor.validation

import org.eclipse.xtext.validation.Check

import org.emoflon.ibex.gt.editor.gT.ContextNode
import org.emoflon.ibex.gt.editor.gT.ContextReference
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Import
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.OperatorNode
import org.emoflon.ibex.gt.editor.gT.OperatorReference
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils

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

	private static val CODE_PREFIX = "org.emoflon.ibex.gt.editor."

	// General errors for named elements.
	public static val NAME_BLACKLISTED = CODE_PREFIX + "nameBlacklisted"
	public static val NAME_EXPECT_CAMEL_CASE = CODE_PREFIX + "nameExpectCamelCase"
	public static val NAME_EXPECT_LOWER_CASE = CODE_PREFIX + "nameExpectLowerCase"
	public static val NAME_EXPECT_UNIQUE = CODE_PREFIX + "nameExpectUnique"

	// Errors for imports.
	public static val IMPORT_FILE_DOES_NOT_EXIST = CODE_PREFIX + "importFileDoesNotExist"
	public static val IMPORT_FILE_DOES_NOT_EXIST_MESSAGE = "The file '%s' does not exist."

	public static val IMPORT_DUPLICATE = CODE_PREFIX + "importDuplicate"
	public static val IMPORT_DUPLICATE_MESSAGE = "Import '%s' must not be declared %s."

	public static val IMPORT_MISSING_META_MODEL = CODE_PREFIX + "importMissingMetaModel"
	public static val IMPORT_MISSING_META_MODEL_MESSAGE = "You must import the Ecore file of the meta-model here."

	// Errors for rules.
	public static val RULE_EMPTY = CODE_PREFIX + "ruleEmpty"
	public static val RULE_EMPTY_MESSAGE = "Rule '%s' must not be empty."

	public static val RULE_SUPER_RULES_DUPLICATE = CODE_PREFIX + "ruleSuperRulesDuplicate"
	public static val RULE_SUPER_RULES_DUPLICATE_MESSAGE = "Super rules of rule '%s' must be distinct."

	public static val RULE_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Rule name '%s' contains underscores. Use camelCase instead."
	public static val RULE_NAME_FORBIDDEN_MESSAGE = "Rules cannot be named '%s'. Use a different name."
	public static val RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Rule '%s' must not be declared %s."
	public static val RULE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Rule '%s' should start with a lower case character."

	// Errors for nodes.
	public static val NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Node name '%s' contains underscores. Use camelCase instead."
	public static val NODE_NAME_FORBIDDEN_MESSAGE = "Nodes cannot be named '%s'. Use a different name."
	public static val NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Node '%s' must not be declared %s."
	public static val NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Node '%s' should start with a lower case character."

	public static val CREATE_NODE_TYPE_ABSTRACT = CODE_PREFIX + "createdNodeAbstractType"
	public static val CREATE_NODE_TYPE_ABSTRACT_MESSAGE = "The type of created node '%s' must not be abstract."

	public static val NODE_TARGET_EXPECT_CONTEXT = CODE_PREFIX + "invalidNodeTargetExpectContext"
	public static val NODE_TARGET_EXPECT_CONTEXT_MESSAGE = "The target of the context reference '%s' must be a context node."

	public static val NODE_TARGET_EXPECT_CONTEXT_OR_CREATE = CODE_PREFIX + "invalidNodeTargetExpectContextOrCreate"
	public static val NODE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE = "The target of the created reference '%s' must be a context or a created node."

	public static val NODE_TARGET_EXPECT_CONTEXT_OR_DELETE = CODE_PREFIX + "invalidNodeTargetExpectContextOrDelete"
	public static val NODE_TARGET_EXPECT_CONTEXT_OR_DELETE_MESSAGE = "The target of the deleted reference '%s must be a context or a deleted node."

	// Errors for references.
	public static val REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT = CODE_PREFIX + "referenceExpectCreatedButIsContext"
	public static val REFERENCE_EXPECT_CREATED_BUT_IS_DELETED = CODE_PREFIX + "referenceExpectCreatedButIsDeleted"
	public static val REFERENCE_EXPECT_CREATED_MESSAGE = "Reference '%s' to '%s' within a created node must be a created reference."

	public static val REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT = CODE_PREFIX + "referenceExpectDeletedButIsContext"
	public static val REFERENCE_EXPECT_DELETED_BUT_IS_CREATED = CODE_PREFIX + "referenceExpectDeletedButIsCreated"
	public static val REFERENCE_EXPECT_DELETED_MESSAGE = "Reference '%s' to '%s' within a deleted node must be a deleted reference."

	@Check
	def checkFile(GraphTransformationFile file) {
		if (file.imports.size === 0) {
			error(
				IMPORT_MISSING_META_MODEL_MESSAGE,
				GTPackage.Literals.GRAPH_TRANSFORMATION_FILE__IMPORTS,
				IMPORT_MISSING_META_MODEL
			)
		}
	}

	@Check
	def checkImports(Import importEcore) {
		if (!GTEditorModelUtils.loadEcoreModel(importEcore.name).present) {
			error(
				String.format(IMPORT_FILE_DOES_NOT_EXIST_MESSAGE, importEcore.name),
				GTPackage.Literals.IMPORT__NAME,
				IMPORT_FILE_DOES_NOT_EXIST
			)
		}

		// Imports must be unique.
		val file = importEcore.eContainer as GraphTransformationFile
		val importDeclarationCount = file.imports.filter[name.equals(importEcore.name)].size
		if (importDeclarationCount !== 1) {
			warning(
				String.format(IMPORT_DUPLICATE_MESSAGE, importEcore.name, getTimes(importDeclarationCount)),
				GTPackage.Literals.IMPORT__NAME,
				IMPORT_DUPLICATE
			)
		}
	}

	@Check
	def checkNode(Node node) {
		// The node name must not be blacklisted.
		if (nodeNameBlacklist.contains(node.name)) {
			error(
				String.format(NODE_NAME_FORBIDDEN_MESSAGE, node.name),
				GTPackage.Literals.NODE__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// Note: _ is only allowed as first character.
			// The node name should be lowerCamelCase.
			if (node.name.substring(1).contains('_')) {
				warning(
					String.format(NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE, node.name),
					GTPackage.Literals.NODE__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The node name should start with a lower case character.
				val firstCharacter = node.name.charAt(0)
				if (Character.isUpperCase(firstCharacter)) {
					warning(
						String.format(NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, node.name),
						GTPackage.Literals.NODE__NAME,
						NAME_EXPECT_LOWER_CASE
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
					String.format(NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, node.name, getTimes(nodeDeclarationsCount)),
					GTPackage.Literals.NODE__NAME,
					NAME_EXPECT_UNIQUE
				)
			}
		}
	}

	@Check
	def checkOperatorNode(OperatorNode node) {
		if (node.operator == Operator.CREATE) {
			// If the node is a created node, its references must be created references.
			GTEditorModelUtils.getContextReferences(node).forEach [
				error(
					String.format(REFERENCE_EXPECT_CREATED_MESSAGE, it.type.name, it.target.name),
					GTPackage.Literals.NODE__REFERENCES,
					REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT,
					it.type.name,
					it.target.name,
					node.name
				)
			]
			GTEditorModelUtils.getDeletedReferences(node).forEach [
				error(
					String.format(REFERENCE_EXPECT_CREATED_MESSAGE, it.type.name, it.target.name),
					GTPackage.Literals.NODE__REFERENCES,
					REFERENCE_EXPECT_CREATED_BUT_IS_DELETED,
					it.type.name,
					it.target.name,
					node.name
				)
			]

			// The type of a created node must not be abstract.
			val rule = node.eContainer as Rule
			if (node.type.abstract && (!rule.abstract)) {
				error(
					String.format(CREATE_NODE_TYPE_ABSTRACT_MESSAGE, node.name),
					GTPackage.Literals.NODE__TYPE,
					CREATE_NODE_TYPE_ABSTRACT,
					node.type.name,
					rule.name
				)
			}
		}

		// If the node is a deleted node, its references must be deleted references.
		if (node.operator == Operator.DELETE) {
			GTEditorModelUtils.getContextReferences(node).forEach [
				error(
					String.format(REFERENCE_EXPECT_DELETED_MESSAGE, it.type.name, it.target.name),
					GTPackage.Literals.NODE__REFERENCES,
					REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT,
					it.type.name,
					it.target.name,
					node.name
				)
			]
			GTEditorModelUtils.getCreatedReferences(node).forEach [
				error(
					String.format(REFERENCE_EXPECT_DELETED_MESSAGE, it.type.name, it.target.name),
					GTPackage.Literals.NODE__REFERENCES,
					REFERENCE_EXPECT_DELETED_BUT_IS_CREATED,
					it.type.name,
					it.target.name,
					node.name
				)
			]
		}
	}

	@Check
	def checkContextReference(ContextReference reference) {
		// The target of a context reference must be a context node.
		if (!(reference.target instanceof ContextNode)) {
			error(
				String.format(NODE_TARGET_EXPECT_CONTEXT_MESSAGE, reference.type.name),
				GTPackage.Literals.REFERENCE__TARGET,
				NODE_TARGET_EXPECT_CONTEXT,
				reference.target.name
			)
		}
	}

	@Check
	def checkOperatorReference(OperatorReference reference) {
		if (reference.operator == Operator.CREATE) {
			// The target of a created reference must be a context or a created node.
			if (reference.target instanceof OperatorNode) {
				val target = reference.target as OperatorNode
				if (target.operator == Operator.DELETE) {
					error(
						String.format(NODE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE, reference.type.name),
						GTPackage.Literals.REFERENCE__TARGET,
						NODE_TARGET_EXPECT_CONTEXT_OR_CREATE,
						reference.target.name
					)
				}
			}
		}

		if (reference.operator == Operator.DELETE) {
			// The target of a deleted reference must be a context or a deleted node.
			if (reference.target instanceof OperatorNode) {
				val target = reference.target as OperatorNode
				if (target.operator == Operator.CREATE) {
					error(
						String.format(NODE_TARGET_EXPECT_CONTEXT_OR_DELETE_MESSAGE, reference.type.name),
						GTPackage.Literals.REFERENCE__TARGET,
						NODE_TARGET_EXPECT_CONTEXT_OR_DELETE,
						reference.target.name
					)
				}
			}
		}
	}

	@Check
	def checkRule(Rule rule) {
		// The rule name must not be blacklisted.
		if (ruleNameBlacklist.contains(rule.name)) {
			error(
				String.format(RULE_NAME_FORBIDDEN_MESSAGE, rule.name),
				GTPackage.Literals.RULE__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// The rule name should be lowerCamelCase.
			if (rule.name.contains('_')) {
				warning(
					String.format(RULE_NAME_CONTAINS_UNDERSCORES_MESSAGE, rule.name),
					GTPackage.Literals.RULE__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The rule name should start with a lower case character. 
				if (!Character.isLowerCase(rule.name.charAt(0))) {
					warning(
						String.format(RULE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, rule.name),
						GTPackage.Literals.RULE__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}

		// The rule must contain at least one constraint or refine multiple rules.
		if (rule.nodes.size == 0 && rule.superRules.size < 2) {
			error(
				String.format(RULE_EMPTY_MESSAGE, rule.name),
				GTPackage.Literals.RULE__NODES,
				RULE_EMPTY
			)
		}

		// The super rules of the rule must be distinct.
		if (rule.superRules.size !== rule.superRules.stream.distinct.count) {
			error(
				String.format(RULE_SUPER_RULES_DUPLICATE_MESSAGE, rule.name),
				GTPackage.Literals.RULE__SUPER_RULES,
				RULE_SUPER_RULES_DUPLICATE
			)
		}

		// Rule names must be unique.
		val file = rule.eContainer as GraphTransformationFile
		val ruleDeclarationCount = file.rules.filter[name.equals(rule.name)].size
		if (ruleDeclarationCount !== 1) {
			error(
				String.format(RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, rule.name, getTimes(ruleDeclarationCount)),
				GTPackage.Literals.RULE__NAME,
				NAME_EXPECT_UNIQUE
			)
		}
	}

	/**
	 * Converts an integer into a "... times" String.
	 */
	def static String getTimes(int count) {
		return if(count == 2) 'twice' else count + ' times'
	}
}
