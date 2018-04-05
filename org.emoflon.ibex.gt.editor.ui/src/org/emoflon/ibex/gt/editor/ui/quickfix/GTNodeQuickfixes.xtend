package org.emoflon.ibex.gt.editor.ui.quickfix

import java.util.regex.Pattern

import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorReference


/**
 * Quickfixes for nodes.
 */
class GTNodeQuickfixes {

	/**
	 * Changes the operator of the node affected by the issue.
	 */
	static def changeNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String nodeName, String operatorName,
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
					removeNodeOperator(node, context.xtextDocument)
				} else {
					node.operator = newOperator
				}
			]
		)
	}

	/**
	 * Changes the operator of the target node of the reference to an operator node with the given operator. 
	 */
	static def changeTargetNodeOperator(Issue issue, IssueResolutionAcceptor acceptor, String operatorName,
		EditorOperator newOperator) {
		val targetNodeName = issue.data?.get(0)
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
							removeNodeOperator(targetNode, context.xtextDocument)
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
	private static def removeNodeOperator(EditorNode node, IXtextDocument document) {
		if (node.operator != EditorOperator.CONTEXT) {
			val xtextNode = NodeModelUtils.getNode(node);
			val regex = Pattern.quote(if(node.operator == EditorOperator.CREATE) '++' else '--')
			val newText = xtextNode.text.replaceFirst(regex, '').trim
			document.replace(xtextNode.offset, xtextNode.length, newText)
		}
	}

	/**
	 * Replaces the type of the node.
	 */
	static def replaceNodeType(Issue issue, IssueResolutionAcceptor acceptor, EClass newType, int relevance) {
		val label = String.format("Replace node type with '%s'.", newType.name)
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorNode) {
					element.type = newType
				}
			],
			relevance
		)
	}
}
