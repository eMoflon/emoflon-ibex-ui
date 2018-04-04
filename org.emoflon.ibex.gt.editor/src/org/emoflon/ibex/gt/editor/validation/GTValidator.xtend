package org.emoflon.ibex.gt.editor.validation

import java.util.Collection

import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.validation.Check

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorImport
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.utils.GTEditorAttributeUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorComparator
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorRuleUtils

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class GTValidator extends AbstractGTValidator {
	/**
	 * The list of invalid node names.
	 */
	private static val nodeNameBlacklist = #[
		"class",
		"rule"
	]

	/**
	 * The list of invalid rule names.
	 */
	private static val ruleNameBlacklist = #[
		"clone",
		"equals",
		"finalize",
		"getClass",
		"hashCode",
		"notify",
		"notifyAll",
		"toString",
		"wait"
	]

	private static val CODE_PREFIX = "org.emoflon.ibex.gt.editor."

	// General errors for named elements.
	public static val NAME_BLACKLISTED = CODE_PREFIX + "name.blacklisted"
	public static val NAME_EXPECT_CAMEL_CASE = CODE_PREFIX + "name.expectCamelCase"
	public static val NAME_EXPECT_LOWER_CASE = CODE_PREFIX + "name.expectLowerCase"
	public static val NAME_EXPECT_UNIQUE = CODE_PREFIX + "name.expectUnique"

	// Errors for imports.
	public static val IMPORT_FILE_DOES_NOT_EXIST = CODE_PREFIX + "import.fileDoesNotExist"
	public static val IMPORT_FILE_DOES_NOT_EXIST_MESSAGE = "The file '%s' does not exist."

	public static val IMPORT_NO_ECORE = CODE_PREFIX + "import.noEcore"
	public static val IMPORT_NO_ECORE_MESSAGE = "The file '%s' cannot be imported because it is no Ecore file."

	public static val IMPORT_DUPLICATE = CODE_PREFIX + "import.duplicate"
	public static val IMPORT_DUPLICATE_MESSAGE = "Import '%s' must not be declared %s."

	public static val IMPORT_MISSING_META_MODEL = CODE_PREFIX + "import.missingMetaModel"
	public static val IMPORT_MISSING_META_MODEL_MESSAGE = "You must import the Ecore file of the meta-model here."

	// Errors for rules.
	public static val RULE_EMPTY = CODE_PREFIX + "rule.empty"
	public static val RULE_EMPTY_MESSAGE = "Rule '%s' must not be empty."

	public static val RULE_SUPER_RULES_DUPLICATE = CODE_PREFIX + "rule.superRules.duplicate"
	public static val RULE_SUPER_RULES_DUPLICATE_MESSAGE = "Super rules of rule '%s' must be distinct."

	public static val RULE_REFINEMENT_INVALID_PARAMETER = CODE_PREFIX + "rule.superRules.invalidParameter"
	public static val RULE_REFINEMENT_INVALID_PARAMETER_MESSAGE = "Rule '%s' has conflicting type declarations for parameter '%s': %s."

	public static val RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT = CODE_PREFIX +
		"rule.superRules.invalidAttributeAssignment"
	public static val RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE = "Rule '%s' has conflicting attribute assignments for node '%s'."

	public static val RULE_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Rule name '%s' contains underscores. Use camelCase instead."
	public static val RULE_NAME_FORBIDDEN_MESSAGE = "Rules cannot be named '%s'. Use a different name."
	public static val RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Rule '%s' must not be declared %s."
	public static val RULE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Rule '%s' should start with a lower case character."

	// Errors for parameters.
	public static val PARAMETER_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Parameter name '%s' contains underscores. Use camelCase instead."
	public static val PARAMETER_NAME_FORBIDDEN_MESSAGE = "Parameters cannot be named '%s'. Use a different name."
	public static val PARAMETER_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Parameter '%s' must not be declared %s."
	public static val PARAMETER_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Parameter '%s' should start with a lower case character."

	// Errors for nodes.
	public static val NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Node name '%s' contains underscores. Use camelCase instead."
	public static val NODE_NAME_FORBIDDEN_MESSAGE = "Nodes cannot be named '%s'. Use a different name."
	public static val NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Node '%s' must not be declared %s."
	public static val NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Node '%s' should start with a lower case character."

	public static val NODE_NAME_EQUALS_PARAMETER_NAME = CODE_PREFIX + "node.name.equalsParameterName"
	public static val NODE_NAME_EQUALS_PARAMETER_NAME_MESSAGE = "Node '%s' and parameter '%s' must not be named equal."

	public static val NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE = CODE_PREFIX +
		"node.operator.expectContextDueToDeclarationInSuperRule"
	public static val NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE_MESSAGE = "Node '%s' must be context due to declaration in super rule(s) %s."

	public static val NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE = CODE_PREFIX +
		"node.type.notCompatibleWithDeclarationInSuperRule"
	public static val NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE = "The type of node '%s' is not compatible with '%s' from super rule '%s'."

	public static val CREATE_NODE_TYPE_ABSTRACT = CODE_PREFIX + "node.type.createdNodeAbstractType"
	public static val CREATE_NODE_TYPE_ABSTRACT_MESSAGE = "The type of created node '%s' must not be abstract."

	// Errors for attributes.
	public static val ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE = CODE_PREFIX + "attribute.literalValueWrongType"
	public static val ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE = "The value of attribute '%s' must be of type '%s'."

	public static val ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE = CODE_PREFIX + "attribute.assignmentInDeletedNode"
	public static val ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE_MESSAGE = "The assignment for attribute '%s' is forbidden in deleted node '%s'."

	public static val ATTRIBUTE_CONDITION_IN_CREATED_NODE = CODE_PREFIX + "attribute.conditionInCreatedNode"
	public static val ATTRIBUTE_CONDITION_IN_CREATED_NODE_MESSAGE = "The condition with attribute '%s' is forbidden in created node '%s'."

	public static val ATTRIBUTE_MULTIPLE_ASSIGNMENTS = CODE_PREFIX + "attribute.duplicateAssignment"
	public static val ATTRIBUTE_MULTIPLE_ASSIGNMENTS_MESSAGE = "%s assignments for attribute '%s'. Only one is allowed."

	public static val ATTRIBUTE_DUPLICATE_CONDITION = CODE_PREFIX + "atttribute.duplicateCondition"
	public static val ATTRIBUTE_DUPLICATE_CONDITION_MESSAGE = "Constraint for attribute '%s' in node '%s' declared %s."

	public static val ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE = CODE_PREFIX + "attribute.relation.typeNotComparable"
	public static val ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE_MESSAGE = "Relation '%s' is not supported for attribute '%s'."

	// Errors for references.
	public static val REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT = CODE_PREFIX +
		"reference.operator.ExpectCreatedButIsContext"
	public static val REFERENCE_EXPECT_CREATED_BUT_IS_DELETED = CODE_PREFIX +
		"reference.operator.ExpectCreatedButIsDeleted"
	public static val REFERENCE_EXPECT_CREATED_MESSAGE = "Reference '%s' to '%s' within a created node must be a created reference."

	public static val REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT = CODE_PREFIX +
		"reference.operator.ExpectDeletedButIsContext"
	public static val REFERENCE_EXPECT_DELETED_BUT_IS_CREATED = CODE_PREFIX +
		"reference.operator.ExpectDeletedButIsCreated"
	public static val REFERENCE_EXPECT_DELETED_MESSAGE = "Reference '%s' to '%s' within a deleted node must be a deleted reference."

	public static val REFERENCE_TARGET_EXPECT_CONTEXT = CODE_PREFIX + "reference.target.invalidNodeExpectContext"
	public static val REFERENCE_TARGET_EXPECT_CONTEXT_MESSAGE = "The target of the context reference '%s' must be a context node."

	public static val REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE = CODE_PREFIX +
		"reference.target.invalidNodeExpectContextOrCreate"
	public static val REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE = "The target of the created reference '%s' must be a context or a created node."

	public static val REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE = CODE_PREFIX +
		"reference.target.invalidNodeExpectContextOrDelete"
	public static val REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE_MESSAGE = "The target of the deleted reference '%s must be a context or a deleted node."

	@Check
	def checkFile(EditorGTFile file) {
		// There must be at least one import.
		if (file.imports.size === 0) {
			error(
				IMPORT_MISSING_META_MODEL_MESSAGE,
				GTPackage.Literals.EDITOR_GT_FILE__IMPORTS,
				IMPORT_MISSING_META_MODEL
			)
		}
	}

	@Check
	def checkImport(EditorImport importEcore) {
		val ecoreModel = GTEditorModelUtils.loadEcoreModel(importEcore.name)
		if (ecoreModel.present) {
			// Imports must be of type ecore.
			if (GTEditorModelUtils.getElements(ecoreModel.get, EPackage).size > 0) {
				error(
					String.format(IMPORT_NO_ECORE_MESSAGE, importEcore.name),
					GTPackage.Literals.EDITOR_IMPORT__NAME,
					org.emoflon.ibex.gt.editor.validation.GTValidator.IMPORT_NO_ECORE,
					importEcore.name
				)
			}
		} else {
			// Import files must exist.
			error(
				String.format(IMPORT_FILE_DOES_NOT_EXIST_MESSAGE, importEcore.name),
				GTPackage.Literals.EDITOR_IMPORT__NAME,
				IMPORT_FILE_DOES_NOT_EXIST,
				importEcore.name
			)
		}

		// Imports must be unique.
		val file = importEcore.eContainer as EditorGTFile
		val importDeclarationCount = file.imports.filter[name.equals(importEcore.name)].size
		if (importDeclarationCount !== 1) {
			warning(
				String.format(IMPORT_DUPLICATE_MESSAGE, importEcore.name, getTimes(importDeclarationCount)),
				GTPackage.Literals.EDITOR_IMPORT__NAME,
				IMPORT_DUPLICATE,
				importEcore.name
			)
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

		// Rule names must be unique.
		val file = rule.eContainer as EditorGTFile
		val ruleDeclarationCount = file.rules.filter[name.equals(rule.name)].size
		if (ruleDeclarationCount !== 1) {
			error(
				String.format(RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, rule.name, getTimes(ruleDeclarationCount)),
				GTPackage.Literals.RULE__NAME,
				NAME_EXPECT_UNIQUE
			)
		}

		if (rule.superRules.isEmpty) {
			return;
		}

		// The super rules of the rule must be distinct.
		if (rule.superRules.size !== rule.superRules.stream.distinct.count) {
			error(
				String.format(RULE_SUPER_RULES_DUPLICATE_MESSAGE, rule.name),
				GTPackage.Literals.RULE__SUPER_RULES,
				RULE_SUPER_RULES_DUPLICATE,
				rule.name
			)
		}

		// Parameter names must be equal to definitions in the super type.
		val superRuleParameters = GTEditorRuleUtils.getAllParametersOfRule(rule)
		val parameterNames = superRuleParameters.map[it.name].toSet
		for (parameterName : parameterNames) {
			val allTypesForName = superRuleParameters.filter[it.name == parameterName].map[it.type].toSet
			if (allTypesForName.size > 1) {
				val typeList = concatNames(allTypesForName.map[it.name].toSet)
				error(
					String.format(RULE_REFINEMENT_INVALID_PARAMETER_MESSAGE, rule.name, parameterName, typeList),
					GTPackage.Literals.RULE__SUPER_RULES,
					RULE_REFINEMENT_INVALID_PARAMETER
				)
			}
		}

		// Nodes may not contain conflicting attribute assignments.
		val allNodes = GTEditorRuleUtils.getAllNodesOfRule(rule, [true])
		val nodeNames = allNodes.map[it.name].toSet
		for (nodeName : nodeNames) {
			val nodesForName = allNodes.filter[nodeName == it.name]
			val attributeAssignments = newHashMap()
			var hasConflictingAssignments = false
			for (node : nodesForName.toList) {
				val assignments = node.attributes.filter[it.relation == EditorRelation.ASSIGNMENT]
				for (assignment : assignments.toList) {
					if (attributeAssignments.containsKey(assignment.attribute)) {
						// Check whether the assignment is compatible with assignment in map
						if (!GTEditorComparator.areAttributeConstraintsEqual(assignment,
							attributeAssignments.get(assignment.attribute))) {
							hasConflictingAssignments = true;
						}
					} else {
						attributeAssignments.put(assignment.attribute, assignment)
					}
				}
			}
			if (hasConflictingAssignments) {
				error(
					String.format(RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE, rule.name, nodeName),
					GTPackage.Literals.RULE__SUPER_RULES,
					RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT
				)
			}
		}
	}

	@Check
	def checkParameter(Parameter parameter) {
		// The parameter name must not be blacklisted.
		if (nodeNameBlacklist.contains(parameter.name)) {
			error(
				String.format(PARAMETER_NAME_FORBIDDEN_MESSAGE, parameter.name),
				GTPackage.Literals.PARAMETER__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// The parameter name should be lowerCamelCase.
			if (parameter.name.contains('_')) {
				warning(
					String.format(PARAMETER_NAME_CONTAINS_UNDERSCORES_MESSAGE, parameter.name),
					GTPackage.Literals.PARAMETER__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The parameter name should start with a lower case character.
				if (Character.isUpperCase(parameter.name.charAt(0))) {
					warning(
						String.format(PARAMETER_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, parameter.name),
						GTPackage.Literals.PARAMETER__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}

		// Parameter names within rule must be unique.
		val rule = parameter.eContainer as Rule
		val parameterDeclarationsCount = rule.parameters.filter[parameter.name.equals(it.name)].size
		if (parameterDeclarationsCount !== 1) {
			error(
				String.format(PARAMETER_NAME_MULTIPLE_DECLARATIONS_MESSAGE, parameter.name,
					getTimes(parameterDeclarationsCount)),
				GTPackage.Literals.PARAMETER__NAME,
				NAME_EXPECT_UNIQUE
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
				if (Character.isUpperCase(node.name.charAt(0))) {
					warning(
						String.format(NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, node.name),
						GTPackage.Literals.NODE__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}

		val rule = node.eContainer
		if (rule instanceof Rule) {
			// Node names within rule must be unique.
			val nodeDeclarationsCount = rule.nodes.filter[node.name.equals(it.name)].size
			if (nodeDeclarationsCount !== 1) {
				error(
					String.format(NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, node.name, getTimes(nodeDeclarationsCount)),
					GTPackage.Literals.NODE__NAME,
					NAME_EXPECT_UNIQUE
				)
			}

			// Node name must not be equal to a parameter name.
			if (rule.parameters.exists[node.name.equals(it.name)]) {
				error(
					String.format(NODE_NAME_EQUALS_PARAMETER_NAME_MESSAGE, node.name, node.name),
					GTPackage.Literals.NODE__NAME,
					NODE_NAME_EQUALS_PARAMETER_NAME
				)
			}

			// The type of a created node must not be abstract.
			if (node.operator == EditorOperator.CREATE) {
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

			if (!rule.superRules.isEmpty) {
				val nodeDeclarationsInSuperRules = GTEditorRuleUtils.getAllNodesFromSuperRules(rule, [
					node.name.equals(it.name)
				])

				// If a node is context in super rule, it must be a context node.
				val contextNodesInSuperRule = nodeDeclarationsInSuperRules.filter[it.operator == EditorOperator.CONTEXT]
				if (!contextNodesInSuperRule.isEmpty && node.operator !== EditorOperator.CONTEXT) {
					error(
						String.format(NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE_MESSAGE, node.name,
							concatNames(contextNodesInSuperRule.map[(it.eContainer as Rule).name].toSet)),
						GTPackage.Literals.NODE__OPERATOR,
						NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE,
						node.name
					)
				}

				if (node.type !== null) {
					// The type of a node must be compatible with any type declarations in super rules.
					nodeDeclarationsInSuperRules.forEach [
						if (!(it.type.equals(node.type) || it.type.isSuperTypeOf(node.type))) {
							val superRule = it.eContainer as Rule
							error(
								String.format(NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE,
									node.name, it.type.name, superRule.name),
								GTPackage.Literals.NODE__TYPE,
								NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE
							)
						}
					]
				}
			}
		}
	}

	@Check
	def checkAttribute(EditorAttribute attributeConstraint) {
		val attribute = attributeConstraint.attribute
		val value = attributeConstraint.value

		// The attribute value must be of the correct type.
		if (value instanceof EditorLiteralExpression) {
			val expectedType = attribute.EAttributeType
			if (!GTEditorAttributeUtils.convertLiteralValueToObject(expectedType, value).present) {
				error(
					String.format(ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, attribute.name, expectedType.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE__VALUE,
					ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
					expectedType.name
				)
			}
		}

		val node = attributeConstraint.eContainer as Node
		if (attributeConstraint.relation == EditorRelation.ASSIGNMENT) {
			if (node.operator == EditorOperator.DELETE) {
				// If the node is a deleted node, it may not contain attribute assignments.
				error(
					String.format(ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE_MESSAGE, attribute.name, node.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE__RELATION,
					ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE,
					attribute.name
				)
			} else {
				// There may be at most one assignment per attribute in context and created nodes.
				val attributeAssignmentCount = node.attributes.filter [
					it.attribute == attribute && it.relation == EditorRelation.ASSIGNMENT
				].size
				if (attributeAssignmentCount != 1) {
					error(
						String.format(ATTRIBUTE_MULTIPLE_ASSIGNMENTS_MESSAGE, attributeAssignmentCount, attribute.name),
						GTPackage.Literals.EDITOR_ATTRIBUTE__RELATION,
						ATTRIBUTE_MULTIPLE_ASSIGNMENTS,
						attribute.name,
						node.operator.getName
					)
				}
			}
		} else { // attribute constraint is a condition
			if (!GTEditorAttributeUtils.isComparable(attribute.EAttributeType) &&
				!GTEditorAttributeUtils.isEqualityCheck(attributeConstraint.relation)) {
				// If the attribute type is not comparable, only equivalence relations are allowed.
				error(
					String.format(ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE_MESSAGE, attributeConstraint.relation.toString,
						attribute.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE__RELATION,
					ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE,
					attribute.name
				)
			} else {
				// There should be no duplicate constraints within a node.
				val constraints = node.attributes.filter [
					GTEditorComparator.areAttributeConstraintsEqual(it, attributeConstraint)
				]
				if (constraints.size > 1) {
					warning(
						String.format(ATTRIBUTE_DUPLICATE_CONDITION_MESSAGE, attribute.name, node.name,
							getTimes(constraints.size)),
						GTPackage.Literals.EDITOR_ATTRIBUTE__ATTRIBUTE,
						ATTRIBUTE_DUPLICATE_CONDITION,
						attribute.name
					)
				}
			}
			if (node.operator == EditorOperator.CREATE) {
				// If the node is a created node, it may not contain attribute conditions.
				error(
					String.format(ATTRIBUTE_CONDITION_IN_CREATED_NODE_MESSAGE, attribute.name, node.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE__RELATION,
					ATTRIBUTE_CONDITION_IN_CREATED_NODE,
					attribute.name
				)
			}
		}
	}

	@Check
	def checkReference(EditorReference reference) {
		val node = reference.eContainer as Node

		if (reference.operator == EditorOperator.CONTEXT) {
			// The target of a context reference must be a context node.
			if (reference.target.operator !== EditorOperator.CONTEXT) {
				error(
					String.format(REFERENCE_TARGET_EXPECT_CONTEXT_MESSAGE, reference.type.name),
					GTPackage.Literals.EDITOR_REFERENCE__TARGET,
					REFERENCE_TARGET_EXPECT_CONTEXT,
					reference.target.name
				)
			}

			if (node.operator == EditorOperator.CREATE) {
				// Context references are not allowed in created nodes.
				error(
					String.format(REFERENCE_EXPECT_CREATED_MESSAGE, reference.type.name, reference.target.name),
					GTPackage.Literals.EDITOR_REFERENCE__OPERATOR,
					REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT,
					reference.type.name,
					reference.target.name,
					node.name
				)
			} else if (node.operator == EditorOperator.DELETE) {
				// Context references are not allowed in deleted nodes.
				error(
					String.format(REFERENCE_EXPECT_DELETED_MESSAGE, reference.type.name, reference.target.name),
					GTPackage.Literals.EDITOR_REFERENCE__OPERATOR,
					REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT,
					reference.type.name,
					reference.target.name,
					node.name
				)
			}
		}

		if (reference.operator == EditorOperator.CREATE) {
			// The target of a created reference must be a context or a created node.
			if (reference.target.operator == EditorOperator.DELETE) {
				error(
					String.format(REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE, reference.type.name),
					GTPackage.Literals.EDITOR_REFERENCE__TARGET,
					REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE,
					reference.target.name
				)
			}

			// Created references are not allowed in deleted nodes.
			if (node.operator == EditorOperator.DELETE) {
				error(
					String.format(REFERENCE_EXPECT_DELETED_MESSAGE, reference.type.name, reference.target.name),
					GTPackage.Literals.EDITOR_REFERENCE__OPERATOR,
					REFERENCE_EXPECT_DELETED_BUT_IS_CREATED,
					reference.type.name,
					reference.target.name,
					node.name
				)
			}
		}

		if (reference.operator == EditorOperator.DELETE) {
			// The target of a deleted reference must be a context or a deleted node.
			if (reference.target.operator == EditorOperator.CREATE) {
				error(
					String.format(REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE_MESSAGE, reference.type.name),
					GTPackage.Literals.EDITOR_REFERENCE__TARGET,
					REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE,
					reference.target.name
				)
			}

			// Deleted references are not allowed in created nodes.
			if (node.operator == EditorOperator.CREATE) {
				error(
					String.format(REFERENCE_EXPECT_CREATED_MESSAGE, reference.type.name, reference.target.name),
					GTPackage.Literals.EDITOR_REFERENCE__OPERATOR,
					REFERENCE_EXPECT_CREATED_BUT_IS_DELETED,
					reference.type.name,
					reference.target.name,
					node.name
				)
			}
		}
	}

	/**
	 * Converts an integer into a "... times" String.
	 */
	def static String getTimes(int count) {
		return if(count == 2) 'twice' else count + ' times'
	}

	/**
	 * Converts the set of names to a string.
	 */
	def static String concatNames(Collection<String> names) {
		if (names.size == 1) {
			return "'" + names.get(0) + "'"
		}
		val sortedNames = names.sortWith [ a, b |
			a.compareTo(b)
		]
		var s = ""
		for (name : sortedNames.subList(0, names.size - 1)) {
			s += "'" + name + "'"
		}
		return s + " and '" + sortedNames.last + "'"
	}
}
