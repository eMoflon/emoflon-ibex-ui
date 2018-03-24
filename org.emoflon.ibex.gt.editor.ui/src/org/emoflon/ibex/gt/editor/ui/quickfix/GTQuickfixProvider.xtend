package org.emoflon.ibex.gt.editor.ui.quickfix

import java.util.regex.Pattern

import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.gT.AttributeConstraint
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Import
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Relation
import org.emoflon.ibex.gt.editor.gT.Rule
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
				if (element instanceof Import) {
					val file = element.eContainer as GraphTransformationFile
					file.imports.remove(element)
				}
			]
		)
	}

	/**
	 * Converts the name of a node, a parameter or a rule to lower case. 
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
				if (element instanceof Node) {
					element.name = element.name.toFirstLower
				} else if (element instanceof Parameter) {
					element.name = element.name.toFirstLower
				} else if (element instanceof Rule) {
					element.name = element.name.toFirstLower
				}
			]
		)
	}

	/**
	 * Converts the name of a node or a rule to lowerCamelCase.
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
				if (element instanceof Node) {
					val node = element as Node
					// Keep leading _ if present before.
					node.name = (if(node.name.startsWith('_')) '_' else '') + convertToLowerCamelCase(node.name)
				} else if (element instanceof Parameter) {
					val parameter = element as Parameter
					parameter.name = convertToLowerCamelCase(parameter.name)
				} else if (element instanceof Rule) {
					val rule = element as Rule
					rule.name = convertToLowerCamelCase(rule.name)
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

	/**
	 * Converts the target node of a reference to a context node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'context', Operator.CONTEXT)
	}

	/**
	 * Converts the target node of a created reference to a created node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	def convertTargetNodeToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Converts the target node of a deleted reference to a deleted node. 
	 */
	@Fix(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def convertTargetNodeToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeTargetNodeOperator(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Changes the operator of the target node of the reference to an operator node with the given operator. 
	 */
	private def changeTargetNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val targetNodeName = issue.data.get(0)
		val label = '''Convert target node '«targetNodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Reference) {
					val targetNode = element.target
					if (targetNode instanceof Node) {
						if (newOperator == Operator.CONTEXT) {
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
	private def removeNodeOperator(Node node, IXtextDocument document) {
		if (node.operator != Operator.CONTEXT) {
			val xtextNode = NodeModelUtils.getNode(node);
			val regex = Pattern.quote(if(node.operator == Operator.CREATE) '++' else '--')
			val newText = xtextNode.text.replaceFirst(regex, '').trim
			document.replace(xtextNode.offset, xtextNode.length, newText)
		}
	}

	/**
	 * Adds an abstract modifier to the rule which contains a node with an abstract type.
	 */
	@Fix(GTValidator.CREATE_NODE_TYPE_ABSTRACT)
	def addAbstractModifierToRuleWithAbstractNodeType(Issue issue, IssueResolutionAcceptor acceptor) {
		val label = String.format("[Rule] Make rule '%s' abstract.", issue.data.get(1))
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				val rule = element.eContainer
				if (rule instanceof Rule) {
					rule.abstract = true
				}
			]
		)
	}

	/**
	 * Suggests to replace the abstract type of a created node with a concrete type. 
	 */
	@Fix(GTValidator.CREATE_NODE_TYPE_ABSTRACT)
	def changeAbstractNodeTypeToConcreteType(Issue issue, IssueResolutionAcceptor acceptor) {
		val allClasses = EditorUtils.getActiveXtextEditor().document.readOnly [ resource |
			val file = resource.contents.get(0)
			if (file instanceof GraphTransformationFile) {
				GTEditorModelUtils.getClasses(file)
			}
		]
		val abstractClass = allClasses.findFirst [
			it.name == issue.data.get(0) // the name of the abstract class
		]
		allClasses.filter[!it.abstract].forEach [
			var prefix = ''
			if (it.EAllSuperTypes.contains(abstractClass)) {
				// Workaround to display subclasses of the current abstract class as first elements
				prefix = '[Subclass] '
			}
			val label = String.format(prefix + "Replace node type with '%s'.", it.name)
			acceptor.accept(
				issue,
				label,
				label,
				null,
				[ element, context |
					if (element instanceof Node) {
						element.type = it
					}
				]
			)
		]
	}

	@Fix(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS)
	def removeAssignment(Issue issue, IssueResolutionAcceptor acceptor) {
		val attributeName = issue.data.get(0)
		val label = '''Remove assignment for attribute '«attributeName»'.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof AttributeConstraint) {
					val node = element.eContainer as Node
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

		Relation.VALUES.filter[it != Relation.ASSIGNMENT].forEach [
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
			Relation.ASSIGNMENT
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
		Relation newRelation) {
		val attributeName = issue.data.get(0)
		val label = String.format(text, attributeName)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof AttributeConstraint) {
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
		this.changeNodeOperator(issue, acceptor, 'context', Operator.CONTEXT)
	}

	/**
	 * Converts the created node which contains a deleted reference to a deleted node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Converts the deleted node which contains a created reference to a created node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeNodeOperator(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Changes the operator of the node affected by the issue.
	 */
	private def changeNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val nodeName = issue.data.get(2)
		val label = '''Convert node '«nodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Reference) {
					val node = element.eContainer as Node
					if (newOperator == Operator.CONTEXT) {
						this.removeNodeOperator(node, context.xtextDocument)
					} else {
						node.operator = newOperator
					}
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
		this.changeReferenceOperator(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Replaces the context or created reference within a deleted node with a deleted reference. 
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToDeletedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.changeReferenceOperator(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Changes the operator of the reference affected by the issue.
	 */
	private def changeReferenceOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val referenceTypeName = issue.data.get(0)
		val referenceTargetNodeName = issue.data.get(1)
		val label = '''Convert reference '«referenceTypeName» -> «referenceTargetNodeName»' to a «operatorName» reference.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Reference) {
					element.operator = newOperator
				}
			]
		)
	}
}
