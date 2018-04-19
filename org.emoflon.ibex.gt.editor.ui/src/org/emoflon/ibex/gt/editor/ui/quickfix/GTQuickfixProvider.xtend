package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorPatternType
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.utils.GTEditorAttributeUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.validation.GTValidator

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class GTQuickfixProvider extends DefaultQuickfixProvider {

	/**
	 * Remove a duplicate or invalid import.
	 */
	@Fix(GTValidator.IMPORT_DUPLICATE)
	@Fix(GTValidator.IMPORT_FILE_DOES_NOT_EXIST)
	@Fix(GTValidator.IMPORT_NO_ECORE)
	def removeImport(Issue issue, IssueResolutionAcceptor acceptor) {
		GTImportQuickfixes.removeImport(issue, acceptor)
	}

	/**
	 * Converts the name of a node, a parameter or a pattern to lower case. 
	 */
	@Fix(GTValidator.NAME_EXPECT_LOWER_CASE)
	def convertNameToLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNameQuickfixes.toLowerCase(issue, acceptor)
	}

	/**
	 * Converts the name of a node, a parameter or a pattern to lowerCamelCase.
	 */
	@Fix(GTValidator.NAME_EXPECT_CAMEL_CASE)
	def convertNameToLowerCamelCase(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNameQuickfixes.toLowerCamelCase(issue, acceptor)
	}

	/**
	 * Converts a pattern to a rule.
	 */
	@Fix(GTValidator.PATTERN_TYPE_INVALID_PATTERN)
	def convertPatternToRule(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.changePatternType(issue, acceptor, EditorPatternType.PATTERN, EditorPatternType.RULE)
	}

	/**
	 * Converts a rule to a pattern.
	 */
	@Fix(GTValidator.PATTERN_TYPE_INVALID_RULE)
	def convertRuleToPattern(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.changePatternType(issue, acceptor, EditorPatternType.RULE, EditorPatternType.PATTERN)
	}

	/**
	 * Removes the duplicate super pattern(s).
	 */
	@Fix(GTValidator.PATTERN_SUPER_PATTERNS_DUPLICATE)
	def removeSuperRule(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.makeSuperPatternsDistinct(issue, acceptor)
	}

	/**
	 * Converts the target node of a reference to a context node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeTargetNodeOperator(issue, acceptor, 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Converts the target node of a created reference to a created node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	def convertTargetNodeToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeTargetNodeOperator(issue, acceptor, 'created', EditorOperator.CREATE)
	}

	/**
	 * Converts the target node of a deleted reference to a deleted node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeTargetNodeOperator(issue, acceptor, 'deleted', EditorOperator.DELETE)
	}

	/**
	 * Adds an abstract modifier to the rule which contains a created node with an abstract type.
	 */
	@Fix(GTValidator.CREATE_NODE_TYPE_ABSTRACT)
	def addAbstractModifierToRuleWithAbstractNodeType(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.makeAbstract(issue, acceptor)
	}

	/**
	 * Suggests to replace the abstract type of a created node with a concrete type. 
	 */
	@Fix(GTValidator.CREATE_NODE_TYPE_ABSTRACT)
	def changeAbstractNodeTypeToConcreteType(Issue issue, IssueResolutionAcceptor acceptor) {
		val allClasses = EditorUtils.getActiveXtextEditor().document.readOnly [ resource |
			val file = resource.contents.get(0)
			if (file instanceof EditorGTFile) {
				GTEditorModelUtils.getClasses(file)
			}
		]
		val abstractClass = allClasses.findFirst [
			it.name == issue.data.get(0) // the name of the abstract class
		]
		allClasses.filter[!it.abstract].forEach [
			GTNodeQuickfixes.replaceNodeType(issue, acceptor, it,
				if(it.EAllSuperTypes.contains(abstractClass)) 2 else 1)
		]
	}

	/**
	 * Removes one of multiple conflicting attribute assignments.
	 */
	@Fix(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS)
	def removeAssignment(Issue issue, IssueResolutionAcceptor acceptor) {
		GTAttributeQuickfixes.removeAttribute(issue, acceptor, 'assignment')
	}

	/**
	 * Removes a duplicate attribute condition.
	 */
	@Fix(GTValidator.ATTRIBUTE_DUPLICATE_CONDITION)
	def removeAttributeCondition(Issue issue, IssueResolutionAcceptor acceptor) {
		GTAttributeQuickfixes.removeAttribute(issue, acceptor, 'constraint')
	}

	/**
	 * Change the relation of an assignment. 
	 */
	@Fix(GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE)
	@Fix(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS)
	def changeAttributeAssignmentToCondition(Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.code.equals(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS) && issue.data.get(1).equals("CREATE")) {
			// For created nodes this quickfix is not allowed.
			return;
		}

		EditorRelation.VALUES.filter[it != EditorRelation.ASSIGNMENT].forEach [
			GTAttributeQuickfixes.changeAttributeRelation(
				issue,
				acceptor,
				'''Convert assignment for '%s' to «it.literal» condition.''',
				it
			)
		]
	}

	/**
	 * Converts the attribute condition in an assignment to an assignment. 
	 */
	@Fix(GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE)
	def changeAttributeConditionToAssignment(Issue issue, IssueResolutionAcceptor acceptor) {
		GTAttributeQuickfixes.changeAttributeRelation(
			issue,
			acceptor,
			"Convert condition for '%s' to assignment.",
			EditorRelation.ASSIGNMENT
		)
	}

	/**
	 * Converts the condition to an equality check relation.
	 */
	@Fix(GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
	def changeAttributeConstraintToEqualityRelation(Issue issue, IssueResolutionAcceptor acceptor) {
		GTEditorAttributeUtils.equalityChecks.forEach [
			GTAttributeQuickfixes.changeAttributeRelation(
				issue,
				acceptor,
				'''Convert condition for '%s' to «it.literal» condition.''',
				it
			)
		]
	}

	/**
	 * Converts the operator node which contains a context reference to a context node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeNodeOperator(issue, acceptor, issue.data.get(2), 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Converts the created node which contains a deleted reference to a deleted node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeNodeOperator(issue, acceptor, issue.data.get(2), 'deleted', EditorOperator.DELETE)
	}

	/**
	 * Converts the deleted node which contains a created reference to a created node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeNodeOperator(issue, acceptor, issue.data.get(2), 'created', EditorOperator.CREATE)
	}

	/**
	 * Converts the created/deleted node which is a context node in a super rule into a context node. 
	 */
	@Fix(GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE)
	def convertToContextNode2(Issue issue, IssueResolutionAcceptor acceptor) {
		GTNodeQuickfixes.changeNodeOperator(issue, acceptor, issue.data.get(0), 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Replaces the context or deleted reference within a created node with a created reference.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToCreatedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		GTReferenceQuickfixes.changeReferenceOperator(issue, acceptor, 'created', EditorOperator.CREATE)
	}

	/**
	 * Replaces the context or created reference within a deleted node with a deleted reference. 
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToDeletedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		GTReferenceQuickfixes.changeReferenceOperator(issue, acceptor, 'deleted', EditorOperator.DELETE)
	}
}
