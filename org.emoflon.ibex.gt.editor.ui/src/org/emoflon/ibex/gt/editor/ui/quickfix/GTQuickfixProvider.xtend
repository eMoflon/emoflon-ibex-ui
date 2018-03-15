package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.validation.Issue

import org.emoflon.ibex.gt.editor.gT.ContextReference
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.GTFactory
import org.emoflon.ibex.gt.editor.gT.Import
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.OperatorNode
import org.emoflon.ibex.gt.editor.gT.OperatorReference
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils

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
	def removeImport(Issue issue, IssueResolutionAcceptor acceptor) {
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

	/**
	 * Converts the name of a node or a rule to lower case. 
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
	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT)
	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def converTargetNodeToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		val targetNodeName = issue.data.get(0)
		val label = '''Convert node '«targetNodeName»' to to a context node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Reference) {
					val targetNode = element.target
					if (targetNode instanceof OperatorNode) {
						val contextNode = GTFactory.eINSTANCE.createContextNode
						contextNode.name = targetNode.name
						contextNode.type = targetNode.type
						contextNode.references.addAll(targetNode.references)
						element.target = contextNode

						val rule = element.eContainer.eContainer as Rule
						rule.nodes.set(rule.nodes.indexOf(targetNode), contextNode)
					}
				}
			]
		)
	}

	/**
	 * Converts the target node of a created reference to a created node. 
	 */
	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	def converTargetNodeToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptChangeOperatorNode(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Converts the target node of a deleted reference to a deleted node. 
	 */
	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def converTargetNodeToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptChangeOperatorNode(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Changes the operator of the target node of the reference to an operator node with the given operator. 
	 */
	private def acceptChangeOperatorNode(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val targetNodeName = issue.data.get(0)
		val label = '''Convert node '«targetNodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof OperatorReference) {
					if (element.target instanceof OperatorNode) {
						(element.target as OperatorNode).operator = newOperator
					}
				}
			]
		)
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

	/**
	 * Converts the operator node which contains a context reference with a context node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	def convertToContextNode(Issue issue, IssueResolutionAcceptor acceptor) {
		val nodeName = issue.data.get(2)
		val label = '''Convert node '«nodeName»' to a context node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof OperatorNode) {
					val contextNode = GTFactory.eINSTANCE.createContextNode
					contextNode.name = element.name
					contextNode.type = element.type
					contextNode.references.addAll(element.references)

					val rule = element.eContainer as Rule
					rule.nodes.set(rule.nodes.indexOf(element), contextNode)
				}
			]
		)
	}

	/**
	 * Converts the created node which contains a deleted reference to a deleted node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED)
	def convertToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptChangeOperatorOfOperatorNode(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Converts the deleted node which contains a created reference to a created node.
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptChangeOperatorOfOperatorNode(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Changes the operator of the operator node affected by the issue to the given operator.
	 */
	private def acceptChangeOperatorOfOperatorNode(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val nodeName = issue.data.get(2)
		val label = '''Convert node '«nodeName»' to a «operatorName» node.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof OperatorNode) {
					element.operator = newOperator
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
		this.acceptConvertOperatorReference(issue, acceptor, 'created', Operator.CREATE)
	}

	/**
	 * Replaces the context or created reference within a deleted node with a deleted reference. 
	 */
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT)
	@Fix(GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED)
	def convertToDeletedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptConvertOperatorReference(issue, acceptor, 'deleted', Operator.DELETE)
	}

	/**
	 * Converts the reference affected by the issue to an operator node with the given operator.
	 */
	private def acceptConvertOperatorReference(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		Operator newOperator) {
		val referenceTypeName = issue.data.get(0)
		val referenceTargetNodeName = issue.data.get(1)
		val label = '''Convert reference '«referenceTypeName»' to a «operatorName» reference.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Node) {
					val node = element as Node
					GTEditorModelUtils.getReferences(node).filter [
						it.type.name.equals(referenceTypeName) && it.target.name.equals(referenceTargetNodeName)
					].forEach [
						if (it instanceof ContextReference) {
							val newReference = GTFactory.eINSTANCE.createOperatorReference
							newReference.operator = newOperator
							newReference.type = it.type
							newReference.target = it.target
							it.eResource.contents.add(newReference)
							node.references.set(node.references.indexOf(it), newReference)
						} else if (it instanceof OperatorReference) {
							it.operator = newOperator
						}
					]
				}
			]
		)
	}
}
