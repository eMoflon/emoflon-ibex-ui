package org.emoflon.ibex.gt.editor.validation

import java.util.Collection

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition
import org.emoflon.ibex.gt.editor.gT.EditorApplicationConditionType
import org.emoflon.ibex.gt.editor.gT.EditorCondition
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorImport
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorPatternType
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.utils.GTConditionHelper
import org.emoflon.ibex.gt.editor.utils.GTEditorAttributeUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTFlatteningUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils
import org.emoflon.ibex.gt.editor.utils.GTFlattener
import org.emoflon.ibex.gt.editor.gT.StochasticFunction
import org.emoflon.ibex.gt.editor.gT.StochasticDistribution
import org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression
import org.emoflon.ibex.gt.editor.gT.PossibleStochasticRanges
import org.emoflon.ibex.gt.editor.gT.ArithmeticExpression
import org.eclipse.emf.ecore.EcorePackage
import org.emoflon.ibex.gt.editor.gT.OneParameterArithmetics
import org.emoflon.ibex.gt.editor.gT.AllOneParameterOperators
import org.emoflon.ibex.gt.editor.gT.MultExpression
import org.emoflon.ibex.gt.editor.gT.MultOperator
import org.emoflon.ibex.gt.editor.gT.AddExpression
import org.emoflon.ibex.gt.editor.gT.ExpExpression
import org.emoflon.ibex.gt.editor.utils.GTArithmeticsCalculatorUtil
import org.emoflon.ibex.gt.editor.gT.EditorCountExpression
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.ArithmeticCalculationExpression
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint
import org.emoflon.ibex.gt.editor.gT.EditorExpression
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.gt.editor.gT.impl.EditorPatternImpl
import org.emoflon.ibex.gt.editor.gT.MinMaxExpression
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.eclipse.emf.ecore.impl.EEnumImpl
import org.emoflon.ibex.gt.editor.utils.GTDisjointPatternFinder
import org.emoflon.ibex.gt.editor.gT.EditorIteratorReference
import org.emoflon.ibex.gt.editor.gT.EditorReferenceIterator

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class GTValidator extends AbstractGTValidator {
	/**
	 * The list of invalid node names.
	 */
	static val nodeNameBlacklist = #[
		"class",
		"rule",
		"abstract",
		"assert",
		"boolean",
		"break",
		"byte",
		"case",
		"catch",
		"char",
		"class",
		"const",
		"continue",
		"default",
		"do",
		"double",
		"EAttribute",
		"EBoolean",
		"EDataType",
		"EClass",
		"EClassifier",
		"EDouble",
		"EFloat",
		"EInt",
		"else",
		"enum",
		"EPackage",
		"EReference",
		"EString",
		"extends",
		"final",
		"finally",
		"float",
		"for",
		"goto",
		"if",
		"implements",
		"import",
		"instanceof",
		"int",
		"interface",
		"long",
		"native",
		"new",
		"package",
		"private",
		"protected",
		"public",
		"return",
		"short",
		"static",
		"strictfp",
		"super",
		"switch",
		"synchronized",
		"this",
		"throw",
		"throws",
		"transient",
		"try",
		"void",
		"volatile",
		"while"
	]

	/**
	 * The list of invalid pattern names.
	 */
	static val patternNameBlacklist = #[
		"clone",
		"equals",
		"finalize",
		"getClass",
		"hashCode",
		"notify",
		"notifyAll",
		"toString",
		"wait",
		"abstract",
		"assert",
		"boolean",
		"break",
		"byte",
		"case",
		"catch",
		"char",
		"class",
		"const",
		"continue",
		"default",
		"do",
		"double",
		"EAttribute",
		"EBoolean",
		"EDataType",
		"EClass",
		"EClassifier",
		"EDouble",
		"EFloat",
		"EInt",
		"else",
		"enum",
		"EPackage",
		"EReference",
		"EString",
		"extends",
		"final",
		"finally",
		"float",
		"for",
		"goto",
		"if",
		"implements",
		"import",
		"instanceof",
		"int",
		"interface",
		"long",
		"native",
		"new",
		"package",
		"private",
		"protected",
		"public",
		"return",
		"short",
		"static",
		"strictfp",
		"super",
		"switch",
		"synchronized",
		"this",
		"throw",
		"throws",
		"transient",
		"try",
		"void",
		"volatile",
		"while"
	]

	static val CODE_PREFIX = "org.emoflon.ibex.gt.editor."

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

	// Errors for patterns.
	public static val PATTERN_CONDITIONS_DUPLICATE = CODE_PREFIX + "pattern.conditions.duplicate"
	public static val PATTERN_CONDITIONS_DUPLICATE_MESSAGE = "The conditions of %s must be distinct."

	public static val PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT = CODE_PREFIX +
		"pattern.conditions.withoutEffectForAbstractPattern"
	public static val PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT_MESSAGE = "Conditions for abstract %s don't have any effect."

	public static val PATTERN_EMPTY = CODE_PREFIX + "pattern.empty"
	public static val PATTERN_EMPTY_MESSAGE = "The %s must not be empty."

	public static val PATTERN_NAME_CONTAINS_UNDERSCORES_MESSAGE = "Pattern/rule name '%s' contains underscores. Use camelCase instead."
	public static val PATTERN_NAME_FORBIDDEN_MESSAGE = "Patterns/rules cannot be named '%s'. Use a different name."
	public static val PATTERN_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Pattern/rule '%s' must not be declared %s."
	public static val PATTERN_NAME_STARTS_WITH_LOWER_CASE_MESSAGE = "Pattern/rule '%s' should start with a lower case character."

	public static val PATTERN_TYPE_INVALID_PATTERN = CODE_PREFIX + "pattern.type.invalidConstraint"
	public static val PATTERN_TYPE_INVALID_PATTERN_MESSAGE = "The pattern '%s' must contain neither created nor deleted elements, nor attribute value assignments."

	public static val PATTERN_TYPE_INVALID_RULE = CODE_PREFIX + "pattern.type.invalidRule"
	public static val PATTERN_TYPE_INVALID_RULE_MESSAGE = "The rule '%s' must contain at least one created or deleted element."

	public static val PATTERN_SUPER_PATTERNS_DUPLICATE = CODE_PREFIX + "pattern.superPatterns.duplicate"
	public static val PATTERN_SUPER_PATTERNS_DUPLICATE_MESSAGE = "Super patterns '%s' must be distinct."

	public static val PATTERN_SUPER_PATTERNS_INVALID = CODE_PREFIX + "pattern.superPatterns.invalid"
	public static val PATTERN_SUPER_PATTERNS_INVALID_MESSAGE = "Cycle in refinement hierarchy: '%s' and '%s'."

	public static val PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT = CODE_PREFIX +
		"pattern.superPatterns.invalidAttributeAssignment"
	public static val PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE = "%s has conflicting attribute assignments for node '%s'."

	public static val PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE = CODE_PREFIX + "pattern.superPatterns.invalidNodeType"
	public static val PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE_MESSAGE = "%s has conflicting type declarations for node '%s': %s."

	public static val PATTERN_SUPER_PATTERNS_INVALID_PARAMETER = CODE_PREFIX + "pattern.superPatterns.invalidParameter"
	public static val PATTERN_SUPER_PATTERNS_INVALID_PARAMETER_MESSAGE = "%s has conflicting type declarations for parameter '%s': %s."

	public static val PATTERN_OR_CONNECTED_CONDITIONS_NOT_SUPPORTED = "%s uses multiple AND connected conditions. This is not supported for TIE-GT"
	public static val PATTERN_CONDITIONS_UNSUPPORTED = CODE_PREFIX + "pattern.conditions.unsupported"

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
	public static val NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE = "The type of node '%s' is not compatible with '%s' defined in super %s."

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

	// Errors for conditions
	public static val CONDITION_NAME_MULTIPLE_DECLARATIONS_MESSAGE = "Condition '%s' must not be declared %s."

	public static val CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN = CODE_PREFIX + "condition.conflicting"
	public static val CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN_MESSAGE = "Condition '%s' contains a positive and a negative application condition for pattern '%s'."

	public static val CONDITION_PATTERN_INVALID_CONDITIONS = CODE_PREFIX +
		"condition.pattern.invalid.hasMultipleConditions"
	public static val CONDITION_PATTERN_INVALID_CONDITIONS2 = CODE_PREFIX +
		"condition.pattern.invalid.hasArithmeticExpressions"

	public static val CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE = "Condition may not use '%s' because it has multiple conditions."
	public static val CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE2 = "Condition may not use '%s' because it has attribute constraints using count(..) or arithmetic expressions."

	public static val CONDITION_PATTERN_INVALID_PARAMETERS = CODE_PREFIX + "condition.pattern.invalid.hasParameters"
	public static val CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE = "Condition may not use '%s' because it has parameters."

	public static val CONDITION_PATTERN_INVALID_RULE = CODE_PREFIX + "condition.pattern.invalid.isEmptyRule"
	public static val CONDITION_PATTERN_INVALID_RULE_MESSAGE = "Condition may not use '%s' because it is a rule, which contains no context."

	public static val CONDITION_SELF_REFERENCE = CODE_PREFIX + "condition.selfReference"
	public static val CONDITION_SELF_REFERENCE_MESSAGE = "Condition '%s' references itself which is not allowed."

	// stochastic functions error messages
	public static val PROBABILITY_ON_PATTERN_MESSAGE = "Only rules can have a probability"
	public static val PROBABILITY_ON_PATTERN = CODE_PREFIX + "probability.onPattern"

	public static val STATICPROBABILITY_NOT_CORRECT_MESSAGE = "The probability needs to be a value between zero and one"
	public static val STATICPROBABILITY_NOT_CORRECT = CODE_PREFIX + "probability.staticprobabilityNotCorrect"

	public static val PROBABIILITY_NO_RANGE_MESSAGE = "Probabilities can't have a range, only value generators"
	public static val PROBABILITY_NO_RANGE = CODE_PREFIX + "probability.noRange"

	public static val SD_NEGATIVE_MESSAGE = "The standard deviation needs to be positive"
	public static val SD_NEGATIVE = CODE_PREFIX + "probability.sdNegative"

	public static val MEAN_NEGATIVE_MESSAGE = "The mean needs to be positive"
	public static val MEAN_NEGATIVE = CODE_PREFIX + "probability.meanNegative"

	public static val NO_SD_MESSAGE = "The distribution needs a value for the standard deviation"
	public static val NO_SD = CODE_PREFIX + "probability.noSd"

	public static val HAS_SD_MESSAGE = "The distribution only needs one value"
	public static val HAS_SD = CODE_PREFIX + "probability.hasSd"

	public static val NO_MAX_VALUE_MESSAGE = "The distribution needs a maximum value"
	public static val NO_MAX_VALUE = CODE_PREFIX + "probability.noMaxValue"

	public static val INTERVALL_INCORRECT_MESSAGE = "The minimum value of the distribution needs to be smaller than the maximum value"
	public static val INTERVALL_INCORRECT = CODE_PREFIX + "probability.intervallIncorrect"

	public static val VALUE_UNDER_ZERO_MESSAGE = "The minimum value of the distribution needs to be positive"
	public static val VALUE_UNDER_ZERO = CODE_PREFIX + "probability.valueUnderZero"

	public static val VALUE_OVER_ONE_MESSAGE = "The maximum value of the distribution needs to be lower than one"
	public static val VALUE_OVER_ONE = CODE_PREFIX + "probability.valueOverOne"

	public static val NO_ASSIGNMENT_MESSAGE = "Stochastic value generators can only be assigned"
	public static val NO_ASSIGNMENT = CODE_PREFIX + "probability.valueNotAssigned"

	public static val PARAMETER_NO_NUMBER_MESSAGE = "The parameter %s.%s does not have a numeric value"
	public static val PARAMETER_NO_NUMBER = CODE_PREFIX + "probability.parameterNoNumber"

	public static val DIVISION_BY_ZERO_MESSAGE = "division by zero is not possible"
	public static val DIVISION_BY_ZERO = CODE_PREFIX + "arithmetics.divisionByZero"

	public static val EXPRESSION_ZERO_MESSAGE = "the value in the operation needs to be positive"
	public static val EXPRESSION_ZERO = CODE_PREFIX + "arithmetics.expressionZero"

	public static val PARAMETER_NEGATIVE_MESSAGE = "operators can't be directly behind each other"
	public static val PARAMETER_NEGATIVE = CODE_PREFIX + "arithmetics.parameterNegative"

	// Count function
	public static val RECURSIVE_COUNT_INVOCATION_MESSAGE = "Count can't be used recursively."
	public static val RECURSIVE_COUNT_INVOCATION = CODE_PREFIX + "count.recursiveInvocation"

	// Disjoint pattern matching optimization extension
	public static val PATTERN_DISJOINT_MESSAGE = "The pattern '%s' has signature nodes that are disjoint, i.e., some sub-sets of nodes are not connected through edges. This will have a negative impact on performance.\nWe have detected the following disjoint sets of pattern nodes: %s"
	public static val PATTERN_DISJOINT = "pattern.isDisjoint"

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
			val classes = GTEditorModelUtils.getElements(ecoreModel.get, EClass).size
			val datatypes = GTEditorModelUtils.getElements(ecoreModel.get, EDataType).size
			if (classes + datatypes == 0) {
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
	def checkPattern(EditorPattern pattern) {
		checkPatternNameValid(pattern)
		checkPatternNameUnique(pattern)

		if (!pattern.conditions.isEmpty) {
			checkPatternNoConditionsIfAbstract(pattern)
			checkPatternDistinctConditions(pattern)
		}

		if (!pattern.superPatterns.isEmpty) {
			checkPatternDistinctSuperPatterns(pattern)
			checkPatternNoCycleInRefinementHierarchy(pattern)
			checkPatternNoConflictingParameterDeclarations(pattern)
			checkPatternNoConflictingNodes(pattern)
		}
	}

	def checkPatternNameValid(EditorPattern pattern) {
		if (pattern.name === null)
			return ""

		// The pattern name must not be blacklisted.
		if (patternNameBlacklist.contains(pattern.name)) {
			error(
				String.format(PATTERN_NAME_FORBIDDEN_MESSAGE, pattern.name),
				GTPackage.Literals.EDITOR_PATTERN__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// The pattern name should be lowerCamelCase.
			if (pattern.name.contains('_')) {
				warning(
					String.format(PATTERN_NAME_CONTAINS_UNDERSCORES_MESSAGE, pattern.name),
					GTPackage.Literals.EDITOR_PATTERN__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The pattern name should start with a lower case character.
				if (!Character.isLowerCase(pattern.name.charAt(0))) {
					warning(
						String.format(PATTERN_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, pattern.name),
						GTPackage.Literals.EDITOR_PATTERN__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}
	}

	/**
	 * Pattern names must be unique.
	 */
	def checkPatternNameUnique(EditorPattern pattern) {
		val file = pattern.eContainer as EditorGTFile
		val count = file.patterns.filter[name !== null && name.equals(pattern.name)].size
		if (count !== 1) {
			error(
				String.format(PATTERN_NAME_MULTIPLE_DECLARATIONS_MESSAGE, pattern.name, getTimes(count)),
				GTPackage.Literals.EDITOR_PATTERN__NAME,
				NAME_EXPECT_UNIQUE
			)
		}
	}

	/**
	 * Abstract patterns must not have any conditions.
	 */
	def checkPatternNoConditionsIfAbstract(EditorPattern pattern) {
		if (pattern.abstract && !pattern.conditions.isEmpty) {
			val text = pattern.toText
			warning(
				String.format(PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT_MESSAGE, text),
				GTPackage.Literals.EDITOR_PATTERN__CONDITIONS,
				PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT,
				text
			)
		}
	}

	def checkPatternDistinctConditions(EditorPattern pattern) {
		if (pattern.conditions.size !== pattern.conditions.stream.distinct.count) {
			error(
				String.format(PATTERN_CONDITIONS_DUPLICATE_MESSAGE, pattern.toText),
				GTPackage.Literals.EDITOR_PATTERN__CONDITIONS,
				PATTERN_CONDITIONS_DUPLICATE,
				pattern.toText
			)
		}
	}

	/**
	 * The super patterns of the pattern must be distinct.
	 */
	def checkPatternDistinctSuperPatterns(EditorPattern pattern) {
		if (pattern.superPatterns.size !== pattern.superPatterns.stream.distinct.count) {
			error(
				String.format(PATTERN_SUPER_PATTERNS_DUPLICATE_MESSAGE, pattern.name),
				GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
				PATTERN_SUPER_PATTERNS_DUPLICATE,
				pattern.name
			)
		}
	}

	/**
	 * The super patterns must not cause a cycle.
	 */
	def checkPatternNoCycleInRefinementHierarchy(EditorPattern pattern) {
		pattern.superPatterns.forEach [
			if (GTEditorPatternUtils.isRefinementOf(pattern, it) && GTEditorPatternUtils.isRefinementOf(it, pattern)) {
				error(
					String.format(PATTERN_SUPER_PATTERNS_INVALID_MESSAGE, pattern.name, it.name),
					GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
					PATTERN_SUPER_PATTERNS_INVALID,
					pattern.name
				)
			}
		]
	}

	/**
	 * Parameter types must be equal to definitions in the super pattern.
	 */
	def checkPatternNoConflictingParameterDeclarations(EditorPattern pattern) {
		val superParameters = GTEditorPatternUtils.getAllParametersOfPattern(pattern)
		val parameterNames = superParameters.map[it.name].toSet
		for (parameterName : parameterNames) {
			val allTypesForName = superParameters.filter[it.name == parameterName].map[it.type].toSet
			if (allTypesForName.size > 1) {
				val typeList = concatNames(allTypesForName.map[it.name].toSet)
				error(
					String.format(PATTERN_SUPER_PATTERNS_INVALID_PARAMETER_MESSAGE, pattern.toText, parameterName,
						typeList),
					GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
					PATTERN_SUPER_PATTERNS_INVALID_PARAMETER
				)
			}
		}
	}

	/**
	 * Nodes may not contain conflicting type declarations or attribute assignments.
	 */
	def checkPatternNoConflictingNodes(EditorPattern pattern) {
		val allNodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [true])
		for (nodeName : allNodes.map[it.name].toSet) {
			val nodesWithSameName = allNodes.filter[it.name == nodeName].toSet

			// The type of a node must be compatible with type declarations in super patterns.
			val conflicts = GTFlatteningUtils.getConflictingNodeTypes(nodesWithSameName);
			if (!conflicts.isEmpty) {
				error(
					String.format(PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE_MESSAGE, pattern.toText, nodeName,
						concatNames(conflicts.map[it.name].toSet)),
					GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
					PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE
				)
			}

			// A node may not inherit conflicting attribute assignments.
			if (GTFlatteningUtils.hasConflictingAssignment(nodesWithSameName)) {
				error(
					String.format(PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE, pattern.toText,
						nodeName),
					GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
					PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT
				)
			}
		}
	}

	@Check(CheckType.NORMAL) // Only on save/build.
	def checkPatternOnSave(EditorPattern pattern) {
		checkPatternNotEmpty(pattern)
		checkPatternType(pattern)
	}

	/**
	 * The pattern must contain at least one node or refine multiple patterns or have graph conditions.
	 */
	def checkPatternNotEmpty(EditorPattern pattern) {
		if (pattern.nodes.size == 0) {
			val noSuperPatterns = pattern.superPatterns.size == 0
			val oneSuperPatternAndNoConditions = pattern.superPatterns.size == 1 && pattern.conditions.size == 0
			if (noSuperPatterns || oneSuperPatternAndNoConditions) {
				error(
					String.format(PATTERN_EMPTY_MESSAGE, pattern.toText),
					GTPackage.Literals.EDITOR_PATTERN__NODES,
					GTValidator.PATTERN_EMPTY
				)
			}
		}
	}

	/**
	 * Check type: pattern vs. rule
	 */
	def checkPatternType(EditorPattern pattern) {
		val flattenedPattern = new GTFlattener(pattern).flattenedPattern
		val isRule = GTEditorPatternUtils.containsCreatedOrDeletedElements(flattenedPattern) ||
			GTEditorPatternUtils.containsForEachLoop(flattenedPattern)
		if (isRule && pattern.type === EditorPatternType.PATTERN) {
			error(
				String.format(PATTERN_TYPE_INVALID_PATTERN_MESSAGE, pattern.name),
				GTPackage.Literals.EDITOR_PATTERN__TYPE,
				PATTERN_TYPE_INVALID_PATTERN,
				pattern.name
			)
		}
		if (!isRule && pattern.type === EditorPatternType.RULE) {
			error(
				String.format(PATTERN_TYPE_INVALID_RULE_MESSAGE, pattern.name),
				GTPackage.Literals.EDITOR_PATTERN__TYPE,
				PATTERN_TYPE_INVALID_RULE,
				pattern.name
			)
		}
	}

	@Check
	def checkParameter(EditorParameter parameter) {
		// The parameter name must not be blacklisted.
		if (nodeNameBlacklist.contains(parameter.name)) {
			error(
				String.format(PARAMETER_NAME_FORBIDDEN_MESSAGE, parameter.name),
				GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// The parameter name should be lowerCamelCase.
			if (parameter.name.contains('_')) {
				warning(
					String.format(PARAMETER_NAME_CONTAINS_UNDERSCORES_MESSAGE, parameter.name),
					GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The parameter name should start with a lower case character.
				if (Character.isUpperCase(parameter.name.charAt(0))) {
					warning(
						String.format(PARAMETER_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, parameter.name),
						GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}

		// Parameter names within pattern must be unique.
		val pattern = parameter.eContainer as EditorPattern
		val count = pattern.parameters.filter[parameter.name.equals(it.name)].size
		if (count !== 1) {
			error(
				String.format(PARAMETER_NAME_MULTIPLE_DECLARATIONS_MESSAGE, parameter.name, getTimes(count)),
				GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
				NAME_EXPECT_UNIQUE
			)
		}
	}

	@Check
	def checkNode(EditorNode node) {
		// The node name must not be blacklisted.
		if (nodeNameBlacklist.contains(node.name)) {
			error(
				String.format(NODE_NAME_FORBIDDEN_MESSAGE, node.name),
				GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
				NAME_BLACKLISTED
			)
		} else {
			// Note: _ is only allowed as first character.
			// The node name should be lowerCamelCase.
			if (node.name.substring(1).contains('_')) {
				warning(
					String.format(NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE, node.name),
					GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
					NAME_EXPECT_CAMEL_CASE
				)
			} else {
				// The node name should start with a lower case character.
				if (Character.isUpperCase(node.name.charAt(0))) {
					warning(
						String.format(NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, node.name),
						GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
						NAME_EXPECT_LOWER_CASE
					)
				}
			}
		}

		// Local nodes must be context
		if (node.local && (node.operator != EditorOperator.CONTEXT)) {
			error("Local nodes must be context and may not be deleted!", GTPackage.Literals.EDITOR_NODE__OPERATOR,
				"org.emoflon.ibex.gt.editor.node.local.expectContext")
		}

		val pattern = node.eContainer
		if (pattern instanceof EditorPattern) {
			// Node names within pattern must be unique.
			val nodeDeclarationsCount = pattern.nodes.filter[node.name.equals(it.name)].size
			if (nodeDeclarationsCount !== 1) {
				error(
					String.format(NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, node.name, getTimes(nodeDeclarationsCount)),
					GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
					NAME_EXPECT_UNIQUE
				)
			}

			// Node name must not be equal to a parameter name.
			if (pattern.parameters.exists[node.name.equals(it.name)]) {
				error(
					String.format(NODE_NAME_EQUALS_PARAMETER_NAME_MESSAGE, node.name, node.name),
					GTPackage.Literals.EDITOR_PARAMETER_OR_NODE__NAME,
					NODE_NAME_EQUALS_PARAMETER_NAME
				)
			}

			// The type of a created node must not be abstract.
			if (node.operator == EditorOperator.CREATE) {
				if (node.type.abstract && (!pattern.abstract)) {
					error(
						String.format(CREATE_NODE_TYPE_ABSTRACT_MESSAGE, node.name),
						GTPackage.Literals.EDITOR_NODE__TYPE,
						CREATE_NODE_TYPE_ABSTRACT,
						node.type.name,
						pattern.name
					)
				}
			}

			if (!pattern.superPatterns.isEmpty) {
				val nodeDeclarationsInSuperPatterns = GTEditorPatternUtils.getAllNodesFromSuperPatterns(pattern, [
					node.name.equals(it.name)
				])

				// If a node is context in super pattern, it must be a context node.
				val contextNodesInSuperPattern = nodeDeclarationsInSuperPatterns.filter [
					it.operator == EditorOperator.CONTEXT
				]
				if (!contextNodesInSuperPattern.isEmpty && node.operator !== EditorOperator.CONTEXT) {
					error(
						String.format(NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE_MESSAGE, node.name,
							concatNames(contextNodesInSuperPattern.map[(it.eContainer as EditorPattern).name].toSet)),
						GTPackage.Literals.EDITOR_NODE__OPERATOR,
						NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE,
						node.name
					)
				}

				if (node.type !== null) {
					// The type of a node must be compatible with any type declarations in super patterns.
					nodeDeclarationsInSuperPatterns.forEach [
						if (!(it.type.equals(node.type) || it.type.isSuperTypeOf(node.type))) {
							val superPattern = it.eContainer as EditorPattern
							error(
								String.format(NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE,
									node.name, it.type.name, superPattern.toText),
								GTPackage.Literals.EDITOR_NODE__TYPE,
								NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE
							)
						}
					]
				}
			}
		}
	}

	@Check
	def checkLiteralExpression(EditorLiteralExpression literalExpression) {
		if (literalExpression.eContainer instanceof StochasticFunction ||
			literalExpression.eContainer instanceof ArithmeticExpression ||
			literalExpression.eContainer instanceof StochasticFunctionExpression ||
			literalExpression.eContainer instanceof EditorPattern) {
			if (GTEditorAttributeUtils.convertStringToEDataType(literalExpression.value) ==
				EcorePackage.Literals.ESTRING ||
				GTEditorAttributeUtils.convertStringToEDataType(literalExpression.value) ==
					EcorePackage.Literals.EBOOLEAN) {
				error("The literal does not represent a numeric value.",
					GTPackage.Literals.EDITOR_LITERAL_EXPRESSION__VALUE, PARAMETER_NO_NUMBER)
				return
			} else {
				return
			}
		}

	}

	@Check
	def checkAttributeAssignment(EditorAttributeAssignment attributeConstraint) {
		val attribute = attributeConstraint.attribute
		val value = attributeConstraint.value

		// The attribute value must be of the correct type.
		if (value instanceof EditorLiteralExpression) {
			val expectedType = attribute.EAttributeType
			if (GTEditorAttributeUtils.convertStringToEDataType(value.value) != expectedType) {
				error(
					String.format(ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, attribute.name, expectedType.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE_ASSIGNMENT__VALUE,
					ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
					expectedType.name
				)
			}
		}

		val node = attributeConstraint.eContainer as EditorNode

		// check if receiving node is non-local
		if (node.isLocal) {
			error("Attributes of local nodes may not be used in attribute assignments!",
				GTPackage.Literals.EDITOR_ATTRIBUTE_ASSIGNMENT__ATTRIBUTE,
				CODE_PREFIX + "arithmetics.nonLocalAttributes")
		}

		if (node.operator == EditorOperator.DELETE) {
			// If the node is a deleted node, it may not contain attribute assignments.
			error(
				String.format(ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE_MESSAGE, attribute.name, node.name),
				GTPackage.Literals.EDITOR_ATTRIBUTE_ASSIGNMENT__VALUE,
				ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE,
				attribute.name
			)
		} else {
			// There may be at most one assignment per attribute in context and created nodes.
			val attributeAssignmentCount = node.attributes.filter[it.attribute == attribute].size
			if (attributeAssignmentCount != 1) {
				error(
					String.format(ATTRIBUTE_MULTIPLE_ASSIGNMENTS_MESSAGE, attributeAssignmentCount, attribute.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE_ASSIGNMENT__VALUE,
					ATTRIBUTE_MULTIPLE_ASSIGNMENTS,
					attribute.name,
					node.operator.getName
				)
			}
		}
	}

	@Check
	def checkAttributeConstraint(EditorAttributeConstraint attributeConstraint) {
		val lhs = attributeConstraint.lhs
		val rhs = attributeConstraint.rhs
		var lhsNumeric = true
		var rhsNumeric = true

		if (lhs instanceof EditorEnumExpression) {
			lhsNumeric = false
			if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
				attributeConstraint.relation == EditorRelation.UNEQUAL)) {
				error("Relation " + attributeConstraint.relation + " is not supported for boolean or enum data types.",
					GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION, ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
			}
		}

		if (lhs instanceof EditorParameterExpression) {
			if (lhs.parameter.type == EcorePackage.Literals.ESTRING) {
				lhsNumeric = false;
			} else if (lhs.parameter.type == EcorePackage.Literals.EBOOLEAN ||
				lhs.parameter.type instanceof EEnumImpl) {
				lhsNumeric = false;
				if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
					attributeConstraint.relation == EditorRelation.UNEQUAL)) {
					error(
						"Relation " + attributeConstraint.relation +
							" is not supported for boolean or enum data types.",
						GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
						ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
				}
			}
		}

		if (lhs instanceof ArithmeticCalculationExpression) {
			if (lhs.expression instanceof EditorAttributeExpression) {
				val eae = lhs.expression as EditorAttributeExpression
				if (eae.attribute.EType == EcorePackage.Literals.ESTRING) {
					lhsNumeric = false;
				} else if (eae.attribute.EType == EcorePackage.Literals.EBOOLEAN ||
					eae.attribute.EType instanceof EEnumImpl) {
					lhsNumeric = false;
					if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
						attributeConstraint.relation == EditorRelation.UNEQUAL)) {
						error(
							"Relation " + attributeConstraint.relation +
								" is not supported for boolean or enum data types.",
							GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
							ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
					}
				}
			} else if (lhs.expression instanceof EditorLiteralExpression) {
				val ele = lhs.expression as EditorLiteralExpression
				val type = GTEditorAttributeUtils.convertStringToEDataType(ele.value)
				if (type == EcorePackage.Literals.ESTRING) {
					lhsNumeric = false;
				} else if (type == EcorePackage.Literals.EBOOLEAN) {
					lhsNumeric = false;
					if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
						attributeConstraint.relation == EditorRelation.UNEQUAL)) {
						error(
							"Relation " + attributeConstraint.relation +
								" is not supported for boolean or enum data types.",
							GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
							ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
					}
				}
			}
		}

		if (rhs instanceof EditorEnumExpression) {
			rhsNumeric = false
			if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
				attributeConstraint.relation == EditorRelation.UNEQUAL)) {
				error("Relation " + attributeConstraint.relation + " is not supported for boolean or enum data types.",
					GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION, ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
			}
		}

		if (rhs instanceof EditorParameterExpression) {
			if (rhs.parameter.type == EcorePackage.Literals.ESTRING) {
				rhsNumeric = false;
			} else if (rhs.parameter.type == EcorePackage.Literals.EBOOLEAN ||
				rhs.parameter.type instanceof EEnumImpl) {
				rhsNumeric = false;
				if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
					attributeConstraint.relation == EditorRelation.UNEQUAL)) {
					error(
						"Relation " + attributeConstraint.relation +
							" is not supported for boolean or enum data types.",
						GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
						ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
				}
			}
		}

		if (rhs instanceof ArithmeticCalculationExpression) {
			if (rhs.expression instanceof EditorAttributeExpression) {
				val eae = rhs.expression as EditorAttributeExpression
				if (eae.attribute.EType == EcorePackage.Literals.ESTRING) {
					rhsNumeric = false;
				} else if (eae.attribute.EType == EcorePackage.Literals.EBOOLEAN ||
					eae.attribute.EType instanceof EEnumImpl) {
					rhsNumeric = false;
					if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
						attributeConstraint.relation == EditorRelation.UNEQUAL)) {
						error(
							"Relation " + attributeConstraint.relation +
								" is not supported for boolean or enum data types.",
							GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
							ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
					}
				}
			} else if (rhs.expression instanceof EditorLiteralExpression) {
				val ele = rhs.expression as EditorLiteralExpression
				val type = GTEditorAttributeUtils.convertStringToEDataType(ele.value)
				if (type == EcorePackage.Literals.ESTRING) {
					rhsNumeric = false;
				} else if (type == EcorePackage.Literals.EBOOLEAN) {
					rhsNumeric = false;
					if (!(attributeConstraint.relation == EditorRelation.EQUAL ||
						attributeConstraint.relation == EditorRelation.UNEQUAL)) {
						error(
							"Relation " + attributeConstraint.relation +
								" is not supported for boolean or enum data types.",
							GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION,
							ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
					}
				}
			}
		}

		if (lhsNumeric != rhsNumeric) {
			error("Can not compare numeric an non-numeric values.",
				GTPackage.Literals.EDITOR_ATTRIBUTE_CONSTRAINT__RELATION, ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
		}

	}

	@Check
	def checkReference(EditorReference reference) {
		val node = reference.eContainer as EditorNode
		val pattern = node.eContainer as EditorPattern

		val targetNodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [it.name.equals(reference?.target?.name)])
		val targetNodeOperator = GTFlatteningUtils.mergeOperators(targetNodes.map[it.operator])

		if (reference.operator == EditorOperator.CONTEXT) {
			// The target of a context reference must be a context node.
			if (targetNodeOperator.present && targetNodeOperator.get !== EditorOperator.CONTEXT) {
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
			if (targetNodeOperator.present && targetNodeOperator.get == EditorOperator.DELETE) {
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
			if (targetNodeOperator.present && targetNodeOperator.get == EditorOperator.CREATE) {
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

		// References to local nodes may not be deleted or created
		if (reference.operator == EditorOperator.DELETE || reference.operator == EditorOperator.CREATE) {
			if (targetNodes.findFirst[tn|tn.isLocal] !== null) {
				error("References to local nodes must be context and may not be deleted!",
					GTPackage.Literals.EDITOR_REFERENCE__OPERATOR, REFERENCE_TARGET_EXPECT_CONTEXT)
			}
		}
	}

	@Check
	def checkCondition(EditorCondition condition) {
		// Names of conditions must be unique.
		val file = condition.eContainer as EditorGTFile
		val conditionDeclarationsCount = file.conditions.filter[condition.name.equals(it.name)].size
		if (conditionDeclarationsCount !== 1) {
			error(
				String.format(CONDITION_NAME_MULTIPLE_DECLARATIONS_MESSAGE, condition.name,
					getTimes(conditionDeclarationsCount)),
				GTPackage.Literals.EDITOR_CONDITION__NAME,
				NAME_EXPECT_UNIQUE
			)
		}

		// A condition may not reference itself.
		val conditionHelper = new GTConditionHelper(condition);
		if (conditionHelper.hasSelfReference()) {
			error(
				String.format(CONDITION_SELF_REFERENCE_MESSAGE, condition.name),
				GTPackage.Literals.EDITOR_CONDITION__CONDITIONS,
				CONDITION_SELF_REFERENCE
			)
		}

		// An and-clause must not contain a PAC and a NAC for the same pattern.
		val conditions = conditionHelper.getApplicationConditions
		val pacs = conditions.filter[it.type == EditorApplicationConditionType.POSITIVE]
		val nacs = conditions.filter[it.type == EditorApplicationConditionType.NEGATIVE]
		for (pac : pacs) {
			for (nac : nacs) {
				if (pac.pattern === nac.pattern) {
					error(
						String.format(CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN_MESSAGE, condition.name, pac.pattern.name),
						GTPackage.Literals.EDITOR_CONDITION__CONDITIONS,
						CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN
					)
				}
			}
		}
	}

	@Check
	def checkApplicationCondition(EditorApplicationCondition applicationCondition) {
		checkPatternInApplicationCondition(applicationCondition.pattern,
			GTPackage.Literals.EDITOR_APPLICATION_CONDITION__PATTERN)
	}

	/**
	 * Validates that the given pattern has no parameters and is no rule.
	 */
	def checkPatternInApplicationCondition(EditorPattern pattern, EStructuralFeature feature) {
		/* Of course rules can be used as patterns in conditions but they must at least possess one context node.
		 * Previously: Patterns in conditions must not be rules. <- Lazy version
		 */
		if (pattern.type === EditorPatternType.RULE) {
//			error(
//				String.format(CONDITION_PATTERN_INVALID_RULE_MESSAGE, pattern.name),
//				feature,
//				CONDITION_PATTERN_INVALID_RULE
//			)
			if (pattern.nodes.filter [ node |
				node.operator == EditorOperator.CONTEXT || node.operator == EditorOperator.DELETE
			].empty) {
				error(
					String.format(CONDITION_PATTERN_INVALID_RULE_MESSAGE, pattern.name),
					feature,
					CONDITION_PATTERN_INVALID_RULE
				)
			}
		} else {
			// Patterns in conditions must not have any parameters.
			if (pattern.parameters.size > 0) {
				error(
					String.format(CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE, pattern.name),
					feature,
					CONDITION_PATTERN_INVALID_PARAMETERS
				)
			} else {
				// Patterns in conditions must not have more than one condition.
				if (pattern.conditions.size > 1) {
					error(
						String.format(CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE, pattern.name),
						feature,
						CONDITION_PATTERN_INVALID_CONDITIONS
					)
				}
				// Patterns in conditions must not have attibute constraints with complex arithmetic or count expressions
				val flattenedPattern = (new GTFlattener(pattern)).flattenedPattern;
				for (EditorAttributeConstraint eac : flattenedPattern.attributeConstraints) {
					if (checkForComplexArithmetics(eac.lhs) || checkForComplexArithmetics(eac.rhs)) {
						error(
							String.format(CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE2, pattern.name),
							feature,
							CONDITION_PATTERN_INVALID_CONDITIONS2
						)
					}
				}
			}
		}
	}

	def boolean checkForComplexArithmetics(EditorExpression expression) {
		if (expression instanceof EditorEnumExpression || expression instanceof EditorParameterExpression) {
			return false
		} else if (expression instanceof StochasticFunctionExpression) {
			return true
		} else {
			val ace = expression as ArithmeticCalculationExpression
			if (ace.expression instanceof AddExpression || ace.expression instanceof MultExpression ||
				ace.expression instanceof ExpExpression || ace.expression instanceof MinMaxExpression ||
				ace.expression instanceof OneParameterArithmetics || ace.expression instanceof EditorCountExpression) {
				return true
			} else {
				return false
			}
		}
	}

	/**
	 * Returns a String for the pattern containing type and name.
	 */
	def static String toText(EditorPattern pattern) {
		return String.format("%s '%s'", pattern.type, pattern.name)
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
			if (a === null) {
				return -1
			} else {
				a.compareTo(b)
			}
		]
		var s = ""
		for (name : sortedNames.subList(0, names.size - 1)) {
			s += "'" + name + "'"
		}
		return s + " and '" + sortedNames.lastOrNull + "'"
	}

	// stochastic function validation
	/**
	 * checks if the pattern is a rule
	 */
	@Check
	def checkIfProbabilityOnRule(EditorPattern pattern) {
		if (pattern.stochastic && pattern.type != EditorPatternType.RULE) {
			error(
				PROBABILITY_ON_PATTERN_MESSAGE,
				GTPackage.Literals.EDITOR_PATTERN__PROBABILITY,
				pattern.name,
				PROBABILITY_ON_PATTERN
			)
		}
	}

	/**
	 * checks if the stochastic functions are defined properly; only used when the parameters have
	 * static value; else runtime-checking
	 */
	@Check
	def checkStochasticDefinitions(EditorPattern pattern) {
		if (pattern.isStochastic) {
			// checks if the static probability is a number between 0 and 1
			val probability = pattern.probability
			if (probability instanceof ArithmeticExpression) {
				try {
					val value = GTArithmeticsCalculatorUtil::getValue(probability)
					if (value < 0.0 || value > 1.0) {
						warning(STATICPROBABILITY_NOT_CORRECT_MESSAGE, GTPackage.Literals.EDITOR_PATTERN__PROBABILITY,
							STATICPROBABILITY_NOT_CORRECT)
					}
				} catch (IllegalArgumentException e) {
					// the arithmetic expression has an attribute as a parameter			
				}
			}
			// checks that the probability does not have a range
			if (probability instanceof StochasticFunction) {
				if (probability.functionExpression.operatorRange != PossibleStochasticRanges.NEUTRAL) {
					error(PROBABIILITY_NO_RANGE_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION__FUNCTION_EXPRESSION,
						PROBABILITY_NO_RANGE)
				}
			}
		}

	}

	/**
	 * Checks if the probability functions are mathematically defined properly; here the parameter 
	 * is also needed
	 */
	@Check
	def checkProbabilityFunction(StochasticFunction function) {
		// if it is an uniformdistribution and without parameter => the range needs to be between 0 and 1
		if (function.functionExpression.distribution == StochasticDistribution.UNIFORM) {
			try {
				val mean = GTArithmeticsCalculatorUtil::getValue(function.functionExpression.mean)
				if (mean < 0.0) {
					error(VALUE_UNDER_ZERO_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION__FUNCTION_EXPRESSION,
						VALUE_UNDER_ZERO)
				}
			} catch (IllegalArgumentException e) {
			}
			try {
				val sd = GTArithmeticsCalculatorUtil::getValue(function.functionExpression.sd)
				if (sd > 1.0) {
					error(VALUE_OVER_ONE_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION__FUNCTION_EXPRESSION,
						VALUE_OVER_ONE)
				}
			} catch (IllegalArgumentException e) {
			}
		}
	}

	/**
	 * Checks if the probability functions are mathematically defined properly
	 */
	@Check
	def checksStochasticFunction(StochasticFunctionExpression function) {
		// if normaldistribution => has sd and when sd is static => sd must be positive
		val distribution = function.distribution
		if (distribution == StochasticDistribution.NORMAL) {
			if (!function.hasSd) {
				error(NO_SD_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__DISTRIBUTION, NO_SD)
			} else {
				try {
					val sd = GTArithmeticsCalculatorUtil::getValue(function.sd)
					if (distribution == StochasticDistribution.NORMAL) {
						if (sd <= 0.0) {
							error(SD_NEGATIVE_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__SD,
								SD_NEGATIVE)
						}
					}
				} catch (IllegalArgumentException e) {
				}
			}
		}
		if (distribution == StochasticDistribution.UNIFORM) {
			// the minValue needs to be lower than the maxValue
			if (!function.hasSd) {
				error(NO_MAX_VALUE_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__DISTRIBUTION,
					NO_MAX_VALUE)
			} else {
				try {
					val sd = GTArithmeticsCalculatorUtil::getValue(function.sd)
					val mean = GTArithmeticsCalculatorUtil::getValue(function.mean)
					if (sd - mean < 0.0) {
						error(INTERVALL_INCORRECT_MESSAGE,
							GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__DISTRIBUTION, INTERVALL_INCORRECT)
					}
				} catch (IllegalArgumentException e) {
				}
			}
		}
		// the exponential distribution only has one input value; mean needs to be positive
		if (distribution == StochasticDistribution.EXPONENTIAL) {
			if (function.hasSd) {
				error(HAS_SD_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__SD, HAS_SD)
			}
			try {
				val mean = GTArithmeticsCalculatorUtil::getValue(function.mean)
				if (mean <= 0.0) {
					error(MEAN_NEGATIVE_MESSAGE, GTPackage.Literals.STOCHASTIC_FUNCTION_EXPRESSION__MEAN, MEAN_NEGATIVE)
				}
			} catch (IllegalArgumentException e) {
			}
		}
	}

	/**
	 * Checks if the one parameter calculations are defined properly; the results should not
	 * be infinity or NaN
	 */
	@Check
	def checkOneParameterArithmetics(OneParameterArithmetics expression) {
		var operator = expression.operator
		if (operator == AllOneParameterOperators.LOGARITHMUS || operator == AllOneParameterOperators.NAT_LOG ||
			operator == AllOneParameterOperators.ROOT) {
			try {
				val value = GTArithmeticsCalculatorUtil::getValue(expression.expression)
				if (value < 0.0 && operator == AllOneParameterOperators.ROOT) {
					error(EXPRESSION_ZERO_MESSAGE, GTPackage.Literals.ONE_PARAMETER_ARITHMETICS__EXPRESSION,
						EXPRESSION_ZERO)
				}
				if (value <= 0.0 && operator != AllOneParameterOperators.ROOT) {
					error(EXPRESSION_ZERO_MESSAGE, GTPackage.Literals.ONE_PARAMETER_ARITHMETICS__EXPRESSION,
						EXPRESSION_ZERO)
				}
			} catch (IllegalArgumentException e) {
			}
		}
	}

	@Check
	def divisionByZero(MultExpression expression) {
		val operator = expression.multOperator
		if (operator == MultOperator.DIVISION || operator == MultOperator.MODULO) {
			try {
				val value = GTArithmeticsCalculatorUtil::getValue(expression.right)
				if (value == 0.0) {
					error(DIVISION_BY_ZERO_MESSAGE, GTPackage.Literals.MULT_EXPRESSION__RIGHT, DIVISION_BY_ZERO)
				}
			} catch (IllegalArgumentException e) {
			}
		}
	}

	@Check
	def checkExpressionWithNodeAttribute(ArithmeticExpression expression) {
		if (expression instanceof MultExpression || expression instanceof AddExpression ||
			expression instanceof ExpExpression) {

			if (expression instanceof MultExpression) {
				val right = expression.right
				if (right instanceof OneParameterArithmetics) {
					if (right.negative) {
						error(PARAMETER_NEGATIVE_MESSAGE, GTPackage.Literals.MULT_EXPRESSION__RIGHT, PARAMETER_NEGATIVE)
					}
				}
			}
			if (expression instanceof AddExpression) {
				val right = expression.right
				if (right instanceof OneParameterArithmetics) {
					if (right.negative) {
						error(PARAMETER_NEGATIVE_MESSAGE, GTPackage.Literals.ADD_EXPRESSION__RIGHT, PARAMETER_NEGATIVE)
					}
				}
			}
			if (expression instanceof ExpExpression) {
				val right = expression.right
				if (right instanceof OneParameterArithmetics) {
					if (right.negative) {
						error(PARAMETER_NEGATIVE_MESSAGE, GTPackage.Literals.EXP_EXPRESSION__RIGHT, PARAMETER_NEGATIVE)
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	def <T> T getContainer(EObject node, Class<T> clazz) {
		var current = node;
		while (!(current.getClass() == clazz)) {
			if (node.eContainer() === null)
				return null;

			current = current.eContainer();
		}
		return current as T;
	}

	/**
	 * checks if the parameter holds a numeric value
	 */
	@Check
	def checkEditorAttributeExpression(EditorAttributeExpression attribute) {
		val pattern = GTEditorPatternUtils.getContainer(attribute, typeof(EditorPatternImpl));
		val targetNodes = GTEditorPatternUtils.
			getAllNodesOfPattern(pattern, [node|node.name.equals(attribute.node.name)])

		if (attribute.eContainer instanceof StochasticFunction ||
			attribute.eContainer instanceof ArithmeticExpression ||
			attribute.eContainer instanceof StochasticFunctionExpression ||
			attribute.eContainer instanceof EditorPattern) {
			if (!isParseable(attribute)) {
				error(String.format(PARAMETER_NO_NUMBER_MESSAGE, attribute.node.name, attribute.attribute.name),
					GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE, PARAMETER_NO_NUMBER)
			}

			if (targetNodes.findFirst[node|node.isLocal] !== null) {
				error("Attributes of local nodes may not be used in arithmetic expressions!",
					GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__NODE,
					CODE_PREFIX + "arithmetics.nonLocalAttributes")
			}

			return
		}

		if (attribute.eContainer.eContainer instanceof EditorAttributeConstraint) {
			val eac = attribute.eContainer.eContainer as EditorAttributeConstraint
			var other = null as EditorExpression
			if (attribute.eContainer == eac.lhs) {
				other = eac.rhs
			} else {
				other = eac.lhs
			}

			if (other === null)
				return;

			if (other instanceof StochasticFunctionExpression) {
				if (!isParseable(attribute)) {
					error(String.format(PARAMETER_NO_NUMBER_MESSAGE, attribute.node.name, attribute.attribute.name),
						GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE, PARAMETER_NO_NUMBER)
					return
				}
			} else if (other instanceof EditorEnumExpression) {
				val eee = other as EditorEnumExpression
				if (eee.literal.EEnum != attribute.attribute.EType) {
					error("Data type mismatch.", GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE,
						ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE)
					return
				}
			} else if (other instanceof EditorParameterExpression) {
				val epe = other as EditorParameterExpression
				if (epe.parameter.type != attribute.attribute.EType) {
					error("Data type mismatch.", GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE,
						ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE)
					return
				}
			} else {
				val ace = other as ArithmeticCalculationExpression
				if (ace.expression instanceof EditorLiteralExpression) {
					val ele = ace.expression as EditorLiteralExpression
					val type = GTEditorAttributeUtils.convertStringToEDataType(ele.value);
					if (type != attribute.attribute.EType) {
						error("Data type mismatch.", GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE,
							ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE)
					}
				} else if (ace.expression instanceof EditorAttributeExpression) {
					val eae = ace.expression as EditorAttributeExpression
					if (eae.attribute.EType != attribute.attribute.EType) {
						error("Data type mismatch.", GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE,
							ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE)
						return
					}
				} else {
					if (!isParseable(attribute)) {
						error(String.format(PARAMETER_NO_NUMBER_MESSAGE, attribute.node.name, attribute.attribute.name),
							GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE, PARAMETER_NO_NUMBER)
						return
					}
				}
			}

		} else if (attribute.eContainer.eContainer instanceof EditorAttributeAssignment) {
			val eaa = attribute.eContainer.eContainer as EditorAttributeAssignment
			if (eaa.attribute.EType != attribute.attribute.EType) {
				error("Data type mismatch.", GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE,
					ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE)
			}
			if (targetNodes.findFirst[node|node.isLocal] !== null) {
				error("Attributes of local nodes may not be used in attribute assignments",
					GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__NODE,
					CODE_PREFIX + "arithmetics.nonLocalAttributes")
			}
		}

	}

	// checks if an attribute is parseable as a number
	def isParseable(EditorAttributeExpression attribute) {
		val type = attribute.attribute.EAttributeType
		return type == EcorePackage.Literals.EDOUBLE || type == EcorePackage.Literals.EFLOAT ||
			type == EcorePackage.Literals.EINT || type == EcorePackage.Literals.ESHORT ||
			type == EcorePackage.Literals.ELONG || type == EcorePackage.Literals.EBYTE
	}

	@Check
	def checkRecursiveInvocation(EditorCountExpression expr) {
		var container = expr.eContainer
		while (container !== null && !(container instanceof EditorPattern)) {
			container = container.eContainer
		}
		if (container === null)
			return

		val pattern = container as EditorPattern
		if (expr.invokedPatten == pattern)
			error(RECURSIVE_COUNT_INVOCATION_MESSAGE, GTPackage.Literals.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN,
				RECURSIVE_COUNT_INVOCATION)
	}

	@Check
	def checkIfPatternDisjunct(EditorPattern pattern) {
		val disjunctPatternFinder = new GTDisjointPatternFinder(pattern)
		if (disjunctPatternFinder.disjoint) {
			warning(
				String.format(PATTERN_DISJOINT_MESSAGE, pattern.name,
					GTDisjointPatternFinder::getDisjointPatternFormat(disjunctPatternFinder.subpatterns)),
				GTPackage.Literals.EDITOR_PATTERN__NAME, PATTERN_DISJOINT)
		}
	}
	
	@Check
	def checkIteratorName(EditorReferenceIterator iterator) {
		val pattern = GTEditorPatternUtils.getContainer(iterator, typeof(EditorPatternImpl));
		val nodeNames = pattern.nodes.map[node | node.name].toSet
		val iteratorNames = pattern.nodes.flatMap[node | node.iterators].filter[itr | itr.name !== null && itr !== iterator].map[itr | itr.name].toSet
		if(nodeNames.contains(iterator.name))
			error("Iterators cannot be named '%s'. Use a different name.", GTPackage.Literals.EDITOR_REFERENCE_ITERATOR__NAME, iterator.name)
		if(iteratorNames.contains(iterator.name))
			error("Iterators cannot be named '%s'. Use a different name.", GTPackage.Literals.EDITOR_REFERENCE_ITERATOR__NAME, iterator.name)
	}

}
