package org.emoflon.ibex.gt.editor.ui.quickfix

import java.util.regex.Pattern

import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorImport
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorPatternType
import org.emoflon.ibex.gt.editor.gT.EditorReference
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
		val importName = issue.data.get(0)
		var label = '''Remove import '«importName»'.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorImport) {
					val file = element.eContainer as EditorGTFile
					file.imports.remove(element)
				}
			]
		)
	}

	/**
	 * Converts the name of a node, a parameter or a pattern to lower case. 
	 */
	@Fix(GTValidator.NAME_EXPECT_LOWER_CASE)
	def convertNameToLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lower case.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorNode) {
					element.name = element.name.toFirstLower
				} else if (element instanceof EditorParameter) {
					element.name = element.name.toFirstLower
				} else if (element instanceof EditorPattern) {
					element.name = element.name.toFirstLower
				}
			]
		)
	}

	/**
	 * Converts the name of a node, a parameter or a pattern to lowerCamelCase.
	 */
	@Fix(GTValidator.NAME_EXPECT_CAMEL_CASE)
	def convertNameToLowerCamelCase(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = 'Convert name to lowerCamelCase.'
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorNode) {
					val node = element as EditorNode
					// Keep leading _ if present before.
					node.name = (if(node.name.startsWith('_')) '_' else '') + convertToLowerCamelCase(node.name)
				} else if (element instanceof EditorParameter) {
					element.name = convertToLowerCamelCase(element.name)
				} else if (element instanceof EditorPattern) {
					element.name = convertToLowerCamelCase(element.name)
				}
			]
		)
	}

	/**
	 * Converts the string to lowerCamelCase.
	 */
	private def convertToLowerCamelCase(String s) {
		var camelCase = ''
		for (part : s.split('_')) {
			if (part.length > 0) {
				camelCase = camelCase + part.substring(0, 1).toUpperCase + part.substring(1).toLowerCase
			}
		}
		return camelCase.toFirstLower
	}

	@Fix(GTValidator.PATTERN_TYPE_INVALID_PATTERN)
	def convertPatternToRule(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.acceptPatternTypeChange(issue, acceptor, EditorPatternType.PATTERN, EditorPatternType.RULE)
	}

	@Fix(GTValidator.PATTERN_TYPE_INVALID_RULE)
	def convertRuleToPattern(Issue issue, IssueResolutionAcceptor acceptor) {
		GTPatternQuickfixes.acceptPatternTypeChange(issue, acceptor, EditorPatternType.RULE, EditorPatternType.PATTERN)
	}

	/**
	 * Remove duplicate super pattern.
	 */
	@Fix(GTValidator.RULE_SUPER_RULES_DUPLICATE)
	def removeSuperRule(Issue issue, IssueResolutionAcceptor acceptor) {
		val ruleName = issue.data.get(0)
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
	 * Converts the target node of a reference to a context node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Converts the target node of a created reference to a created node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	def convertTargetNodeToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'created', EditorOperator.CREATE)
	}

	/**
	 * Converts the target node of a deleted reference to a deleted node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'deleted', EditorOperator.DELETE)
	}

	/**
	 * Changes the operator of the target node of the reference to an operator node with the given operator. 
	 */
	private def changeTargetNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		EditorOperator newOperator) {
		val targetNodeName = issue.data.get(0)
		val label = '''Convert target node '«targetNodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorReference) {
					val targetNode = element.target
					if (targetNode instanceof EditorNode) {
						if (newOperator == EditorOperator.CONTEXT) {
							this.removeNodeOperator(targetNode, context.xtextDocument)
						} else {
							targetNode.operator = newOperator
						}
					}
				}
			]
		)
	}

	/**
	 * Removes the operator of the given node by modifying the Xtext document. 
	 */
	private def removeNodeOperator(EditorNode node, IXtextDocument document) {
		if (node.operator != EditorOperator.CONTEXT) {
			val xtextNode = NodeModelUtils.getNode(node);
			val regex = Pattern.quote(if(node.operator == EditorOperator.CREATE) '++' else '--')
			val newText = xtextNode.text.replaceFirst(regex, '').trim
			document.replace(xtextNode.offset, xtextNode.length, newText)
		}
	}

	/**
	 * Adds an abstract modifier to the rule which contains a created node with an abstract type.
	 */
	@Fix(GTValidator.CREATE_NODE_TYPE_ABSTRACT)
	def addAbstractModifierToRuleWithAbstractNodeType(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = String.format("Make rule '%s' abstract.", issue.data.get(1))
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
			val label = String.format("Replace node type with '%s'.", it.name)
			acceptor.accept(
				issue,
				label,
				label,
				null,
				[ element, context |
					if (element instanceof EditorNode) {
						element.type = it
					}
				],
				if(it.EAllSuperTypes.contains(abstractClass)) 2 else 1
			)
		]
	}

	/**
	 * Removes one of multiple conflicting attribute assignments.
	 */
	@Fix(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS)
	def removeAssignment(Issue issue, IssueResolutionAcceptor acceptor) {
		removeAttribute(issue, acceptor, 'assignment')
	}

	/**
	 * Removes a duplicate attribute condition.
	 */
	@Fix(GTValidator.ATTRIBUTE_DUPLICATE_CONDITION)
	def removeAttributeCondition(Issue issue, IssueResolutionAcceptor acceptor) {
		removeAttribute(issue, acceptor, 'constraint')
	}

	/**
	 * Removes an attribute assignment/constraint.
	 */
	private static def removeAttribute(Issue issue, IssueResolutionAcceptor acceptor, String name) {
		val attributeName = issue.data.get(0)
		val label = '''Remove «name» for attribute '«attributeName»'.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorAttribute) {
					val node = element.eContainer as EditorNode
					node.attributes.remove(element)
				}
			]
		)
	}

	@Fix(GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE)
	@Fix(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS)
	def changeAttributeAssignmentToCondition(Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.code.equals(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS) && issue.data.get(1).equals("CREATE")) {
			// For created nodes this quickfix is not allowed.
			return;
		}

		EditorRelation.VALUES.filter[it != EditorRelation.ASSIGNMENT].forEach [
			this.changeAttributeConstraintRelation(
				issue,
				acceptor,
				'''Convert assignment for '%s' to «it.literal» condition.''',
				it
			)
		]
	}

	@Fix(GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE)
	def changeAttributeConditionToAssignment(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeAttributeConstraintRelation(
			issue,
			acceptor,
			"Convert condition for '%s' to assignment.",
			EditorRelation.ASSIGNMENT
		)
	}

	@Fix(GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE)
	def changeAttributeConstraintToEqualityRelation(Issue issue, IssueResolutionAcceptor acceptor) {
		GTEditorAttributeUtils.equalityChecks.forEach [
			this.changeAttributeConstraintRelation(
				issue,
				acceptor,
				'''Convert assignment for '%s' to «it.literal» condition.''',
				it
			)
		]
	}

	/**
	 * Changes the relation of the attribute constraint.
	 */
	private def changeAttributeConstraintRelation(Issue issue, IssueResolutionAcceptor acceptor, String text,
		EditorRelation newRelation) {
		val attributeName = issue.data.get(0)
		val label = String.format(text, attributeName)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorAttribute) {
					element.relation = newRelation
				}
			]
		)
	}

	/**
	 * Converts the operator node which contains a context reference to a context node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, issue.data.get(2), 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Converts the created node which contains a deleted reference to a deleted node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, issue.data.get(2), 'deleted', EditorOperator.DELETE)
	}

	/**
	 * Converts the deleted node which contains a created reference to a created node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, issue.data.get(2), 'created', EditorOperator.CREATE)
	}

	/**
	 * Converts the created/deleted node which is a context node in a super rule into a context node. 
	 */
	@Fix(GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE)
	def convertToContextNode2(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, issue.data.get(0), 'context', EditorOperator.CONTEXT)
	}

	/**
	 * Changes the operator of the node affected by the issue.
	 */
	private def changeNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String nodeName, String operatorName,
		EditorOperator newOperator) {
		val label = '''Convert node '«nodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				var EditorNode node
				if (element instanceof EditorReference) {
					node = element.eContainer as EditorNode
				}
				if (element instanceof EditorNode) {
					node = element as EditorNode
				}
				if (newOperator == EditorOperator.CONTEXT) {
					this.removeNodeOperator(node, context.xtextDocument)
				} else {
					node.operator = newOperator
				}
			]
		)
	}

	/**
	 * Replaces the context or deleted reference within a created node with a created reference.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToCreatedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeReferenceOperator(issue, acceptor, 'created', EditorOperator.CREATE)
	}

	/**
	 * Replaces the context or created reference within a deleted node with a deleted reference. 
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToDeletedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeReferenceOperator(issue, acceptor, 'deleted', EditorOperator.DELETE)
	}

	/**
	 * Changes the operator of the reference affected by the issue.
	 */
	private def changeReferenceOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		EditorOperator newOperator) {
		val referenceTypeName = issue.data.get(0)
		val referenceTargetNodeName = issue.data.get(1)
		val label = '''Convert reference '«referenceTypeName» -> «referenceTargetNodeName»' to a «operatorName» reference.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorReference) {
					element.operator = newOperator
				}
			]
		)
	}
}
