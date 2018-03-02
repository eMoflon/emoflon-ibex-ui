package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.emf.ecore.EClass

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

	@Fix(GTValidator.IMPORT_DUPLICATE)
	@Fix(GTValidator.IMPORT_FILE_DOES_NOT_EXIST)
	def removeDuplicateImport(Issue issue, IssueResolutionAcceptor acceptor) {
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
					convertNodeNameToLowerCase(element as Node)
				} else if (element instanceof Rule) {
					convertRuleNameToLowerCase(element as Rule)
				}
			]
		)
	}

	private def convertNodeNameToLowerCase(Node node) {
		node.name = node.name.toFirstLower
	}

	private def convertRuleNameToLowerCase(Rule rule) {
		rule.name = rule.name.toFirstLower
	}

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
					convertNodeNameToLowerCamelCase(element as Node)
				} else if (element instanceof Rule) {
					convertRuleNameToLowerCamelCase(element as Rule)
				}
			]
		)
	}

	private def convertNodeNameToLowerCamelCase(Node node) {
		// Keep leading _ if present before.
		node.name = (if(node.name.startsWith('_')) '_' else '') + convertToLowerCamelCase(node.name)
	}

	private def convertRuleNameToLowerCamelCase(Rule rule) {
		rule.name = convertToLowerCamelCase(rule.name)
	}

	private def convertToLowerCamelCase(String s) {
		var camelCase = ''
		for (part : s.split('_')) {
			if (part.length > 0) {
				camelCase = camelCase + part.substring(0, 1).toUpperCase + part.substring(1).toLowerCase
			}
		}
		return camelCase.toFirstLower
	}

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
						contextNode.constraints.addAll(targetNode.constraints)
						element.target = contextNode

						val rule = element.eContainer.eContainer as Rule
						rule.nodes.set(rule.nodes.indexOf(targetNode), contextNode)
					}
				}
			]
		)
	}

	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_CREATE)
	def converTargetNodeToCreatedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptConvertOperatorNode(issue, acceptor, 'created', Operator.CREATE)
	}

	@Fix(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_DELETE)
	def converTargetNodeToDeletedNode(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptConvertOperatorNode(issue, acceptor, 'deleted', Operator.DELETE)
	}

	private def acceptConvertOperatorNode(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
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
			this.acceptChangeNodeType(issue, acceptor, prefix, it)
		]
	}

	private def acceptChangeNodeType(Issue issue, IssueResolutionAcceptor acceptor, String prefix, EClass newClass) {
		val label = String.format(prefix + "Replace node type with '%s'.", newClass.name)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof Node) {
					element.type = newClass
				}
			]
		)
	}

	@Fix(GTValidator.REFERENCE_EXPECT_CREATE)
	def convertToCreatedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptConvertOperatorReference(issue, acceptor, 'created', Operator.CREATE)
	}

	@Fix(GTValidator.REFERENCE_EXPECT_DELETE)
	def convertToDeletedReference(Issue issue, IssueResolutionAcceptor acceptor) {
		this.acceptConvertOperatorReference(issue, acceptor, 'deleted', Operator.DELETE)
	}

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
							node.constraints.set(node.constraints.indexOf(it), newReference)
						} else if (it instanceof OperatorReference) {
							it.operator = newOperator
						}
					]
				}
			]
		)
	}
}
