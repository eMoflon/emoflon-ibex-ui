package org.emoflon.ibex.gt.editor.validation

import java.util.Collection

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition
import org.emoflon.ibex.gt.editor.gT.EditorApplicationConditionType
import org.emoflon.ibex.gt.editor.gT.EditorAttribute
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
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.utils.GTConditionHelper
import org.emoflon.ibex.gt.editor.utils.GTEditorAttributeComparator
import org.emoflon.ibex.gt.editor.utils.GTEditorAttributeUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTFlatteningUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils
import org.emoflon.ibex.gt.editor.utils.GTFlattener
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionOperationalization
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionAdornment
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionType
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionSpecification
import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionParameter

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
    "rule"
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
    "wait"
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
  public static val CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE = "Condition may not use '%s' because it has multiple conditions."

  public static val CONDITION_PATTERN_INVALID_PARAMETERS = CODE_PREFIX + "condition.pattern.invalid.hasParameters"
  public static val CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE = "Condition may not use '%s' because it has parameters."

  public static val CONDITION_PATTERN_INVALID_RULE = CODE_PREFIX + "condition.pattern.invalid.isRule"
  public static val CONDITION_PATTERN_INVALID_RULE_MESSAGE = "Condition may not use '%s' because it is a rule."

  public static val CONDITION_SELF_REFERENCE = CODE_PREFIX + "condition.selfReference"
  public static val CONDITION_SELF_REFERENCE_MESSAGE = "Condition '%s' references itself which is not allowed."

  // Constants for attribute constraints library
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.inconsistentAdornment";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT = "Operations of type 'extend' must have at least one F adornment, and operations of type 'check' must have only B adornments."

  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_LENGTH_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.inconsistentAdornmentLength";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_LENGTH = "Number of adornments must match number of parameters."

  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_PARAMETER_NAMES_REUSE_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.inconsistentParameterNamesWhileReusing";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_PARAMETER_NAMES_REUSE = "Parameter names in reusing operation specification must be the same as in reused %s."

  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_REUSE_CYCLE_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.reuseCycle";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_REUSE_CYCLE = "Cycle in reuse relation."

  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNTERMINATED_PARAMETER_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.unterminatedParameterReference";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNTERMINATED_PARAMETER = "Unterminated parameter reference in code fragment."

  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNKNOWN_PARAMETER_CODE = CODE_PREFIX +
    "attributeConstraintsLibrary.unknownParameterReference";
  public static val EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNKNOWN_PARAMETER = "Unknown parameter referenced in code fragment: %s"

  public static val EDITOR_ATTRIBUTE_CONDITION_PARAMETER_NAME_PATTERN = "[a-zA-z][a-zA-z0-9]*"

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
          String.format(PATTERN_SUPER_PATTERNS_INVALID_PARAMETER_MESSAGE, pattern.toText, parameterName, typeList),
          GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS,
          PATTERN_SUPER_PATTERNS_INVALID_PARAMETER
        )
      }
    }
  }

  /**
   * EditorPattern are not allowed to have multiple OR connected EditorConditions for TIE-GT
   * (currently disabled because we would have to decide whether this is TIE-GT or IBeX) 
   */
  // @Check 
  def checkPatternNoORConnectedConditions(EditorPattern pattern) {
    if (pattern.conditions.size > 1)
      error(
        String.format(PATTERN_OR_CONNECTED_CONDITIONS_NOT_SUPPORTED, pattern.toText),
        GTPackage.Literals.EDITOR_PATTERN__CONDITIONS,
        PATTERN_CONDITIONS_UNSUPPORTED
      )
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
          String.format(PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE, pattern.toText, nodeName),
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
    val isRule = GTEditorPatternUtils.containsCreatedOrDeletedElements(flattenedPattern)
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
                String.format(NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE, node.name, it.type.name,
                  superPattern.toText),
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

    val node = attributeConstraint.eContainer as EditorNode
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
          GTEditorAttributeComparator.areAttributeConstraintsEqual(it, attributeConstraint)
        ]
        if (constraints.size > 1) {
          warning(
            String.format(ATTRIBUTE_DUPLICATE_CONDITION_MESSAGE, attribute.name, node.name, getTimes(constraints.size)),
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

    // An and clause must not contain a PAC and a NAC for the same pattern.
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
  def checkEnforce(EditorApplicationCondition applicationCondition) {
    checkPatternInApplicationCondition(applicationCondition.pattern,
      GTPackage.Literals.EDITOR_APPLICATION_CONDITION__PATTERN)
  }

  /**
   * Validates that the given pattern has no parameters and is no rule.
   */
  def checkPatternInApplicationCondition(EditorPattern pattern, EStructuralFeature feature) {
    // Patterns in conditions must not be rules.
    if (pattern.type === EditorPatternType.RULE) {
      error(
        String.format(CONDITION_PATTERN_INVALID_RULE_MESSAGE, pattern.name),
        feature,
        CONDITION_PATTERN_INVALID_RULE
      )
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
    return s + " and '" + sortedNames.last + "'"
  }

  /**
   * Checks that an extend operation has at least one free adornment and that a check operation has only bound operations
   */
  @Check
  def checkConsistencyOfOperationTypeAndAdornment(
    EditorAttributeConditionOperationalization editorAttributeConditionOperationalization) {
    val adornments = editorAttributeConditionOperationalization.adornments
    val operationType = editorAttributeConditionOperationalization.operationalizationType
    val hasFreeAdornment = hasFreeAdornment(adornments)
    if ((operationType == EditorAttributeConditionType.CHECK && hasFreeAdornment) ||
      (operationType == EditorAttributeConditionType.EXTEND && !hasFreeAdornment)) {
      error(
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT,
        GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION__OPERATIONALIZATION_TYPE,
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_CODE
      )
    }
  }

  def static boolean hasFreeAdornment(Collection<EditorAttributeConditionAdornment> adornments) {
    return adornments.exists[it == EditorAttributeConditionAdornment.FREE]
  }

  /**
   * Checks that the adornment of an operationalization matches the length of the parameter list
   */
  @Check
  def checkParameterCountVsAdornmentLength(
    EditorAttributeConditionOperationalization editorAttributeConditionOperationalization) {
    val adornments = editorAttributeConditionOperationalization.adornments
    val constraintSpecification = editorAttributeConditionOperationalization.eContainer
    if (constraintSpecification instanceof EditorAttributeConditionSpecification) {
      val parameters = constraintSpecification.parameters
      if (parameters.size != adornments.size) {
        error(
          EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_LENGTH,
          GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION__OPERATIONALIZATION_TYPE,
          EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_ADORNMENT_LENGTH_CODE
        )
      }
    }
  }

  /**
   * Checks that the reuse relation is free of loops and that the parameter names of the reusing and reused specification match 
   */
  @Check
  def checkParameterListLengthWhenReusing(EditorAttributeConditionSpecification editorAttributeConditionSpecification) {
    if (hasReuseCycle(editorAttributeConditionSpecification)) {
      error(
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_REUSE_CYCLE,
        GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_SPECIFICATION__REUSED_CONDITION_SPECIFICATION,
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_REUSE_CYCLE_CODE
      )
      return
    }

    val reusedCondition = findReusedSpecification(editorAttributeConditionSpecification)
    if (reusedCondition !== null) {
      val parameters = editorAttributeConditionSpecification.parameters
      val parametersOfReusedCondition = reusedCondition.parameters
      if (!haveSameNames(parameters, parametersOfReusedCondition)) {
        error(
          EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_PARAMETER_NAMES_REUSE,
          GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_SPECIFICATION__NAME,
          EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_INCONSISTENT_PARAMETER_NAMES_REUSE_CODE
        )
      }
    }
  }

  def hasReuseCycle(EditorAttributeConditionSpecification specification) {
    if (specification.reusedConditionSpecification === null)
      return false

    var reusedCondition = specification.reusedConditionSpecification
    while (reusedCondition.reusedConditionSpecification !== null) {
      reusedCondition = reusedCondition.reusedConditionSpecification
      if (reusedCondition === specification) {
        return true
      }
    }

    return false
  }

  /**
   * Precondition: specification.reusedConditionSpecification !== null
   */
  def findReusedSpecification(EditorAttributeConditionSpecification specification) {
    var reusedCondition = specification.reusedConditionSpecification
    if (reusedCondition === null)
      return null

    while (reusedCondition.reusedConditionSpecification !== null)
      reusedCondition = reusedCondition.reusedConditionSpecification

    return reusedCondition
  }

  def haveSameNames(EList<EditorAttributeConditionParameter> parameters1,
    EList<EditorAttributeConditionParameter> parameters2) {
    if (parameters1.size != parameters2.size)
      return false

    for (var i = 0; i < parameters1.size; i++) {
      if (!parameters1.get(i).name.equals(parameters2.get(i).name))
        return false
    }

    return true;
  }

  /**
   * Checks that parameter names that occur in the specification string correspond to parameters 
   */
  @Check
  def checkParameterNamesInTargetPlatformSpecification(
    EditorAttributeConditionOperationalization editorAttributeConditionOperationalization) {
    val codeFragment = editorAttributeConditionOperationalization.specification
    if (countDelimiters(codeFragment) % 2 == 1) {
      error(
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNTERMINATED_PARAMETER,
        GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION__SPECIFICATION,
        EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNTERMINATED_PARAMETER_CODE
      )
    }
    val parameterNamesInSpecification = getParameterNames(codeFragment)
    val constraintSpecification = editorAttributeConditionOperationalization.eContainer
    if (constraintSpecification instanceof EditorAttributeConditionSpecification) {
      val parameters = constraintSpecification.parameters
      val parameterNamesOfPredicate = getParameterNames(parameters)

      val unknonParameters = newHashSet()
      unknonParameters.addAll(parameterNamesInSpecification.filter[!parameterNamesOfPredicate.contains(it)])
      if (!unknonParameters.isEmpty) {
        error(
          String.format(EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNKNOWN_PARAMETER,
            unknonParameters),
          GTPackage.Literals.EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION__SPECIFICATION,
          EDITOR_ATTRIBUTE_CONDITION_OPERATIONALIZATION_SPECIFICATION_UNKNOWN_PARAMETER_CODE
        )
      }
    }

  }

  def getParameterNames(EList<EditorAttributeConditionParameter> list) {
    return list.map[it.name]
  }

  def getParameterNames(String codeFragment) {
    val parameterPattern = java.util.regex.Pattern.compile(
      "\\$(" + EDITOR_ATTRIBUTE_CONDITION_PARAMETER_NAME_PATTERN + ")\\$")
    val matcher = parameterPattern.matcher(codeFragment)
    var parameterNames = newArrayList
    var start = 0
    while (matcher.find(start)) {
      parameterNames.add(matcher.group(1))
      start = matcher.end
    }
    return parameterNames
  }

  def countDelimiters(String string) {
    var int count = 0;
    for (var int i = 0; i < string.length; i++) {
      if (string.charAt(i) == '$') {
        count++
      }
    }
    return count
  }

}
