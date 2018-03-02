package org.emoflon.ibex.gt.editor.utils

import org.emoflon.ibex.gt.editor.gT.ContextReference
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.OperatorReference
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Reference

/**
 * Utility methods for working with {@link GraphTransformationFile} models.
 */
class GTEditorUtils {
	/**
	 * Returns all references of a node.
	 */
	static def getReferences(Node node) {
		return node.constraints.filter [
			it instanceof Reference
		].map [
			it as Reference
		]
	}

	/**
	 * Returns the context references of a node.
	 */
	static def getContextReferences(Node node) {
		return node.constraints.filter [
			it instanceof ContextReference
		].map [
			it as ContextReference
		]
	}

	/**
	 * Returns the operator references of a node.
	 */
	static def getOperatorReferences(Node node) {
		return node.constraints.filter [
			it instanceof OperatorReference
		].map [
			it as OperatorReference
		]
	}

	/**
	 * Returns the create operator references of a node.
	 */
	static def getCreateReferences(Node node) {
		return getOperatorReferences(node).filter [
			it.operator == Operator.CREATE
		]
	}

	/**
	 * Returns the delete operator references of a node.
	 */
	static def getDeleteReferences(Node node) {
		return getOperatorReferences(node).filter [
			it.operator == Operator.DELETE
		]
	}
}
