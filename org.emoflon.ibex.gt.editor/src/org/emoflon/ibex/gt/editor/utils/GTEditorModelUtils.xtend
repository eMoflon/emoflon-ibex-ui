package org.emoflon.ibex.gt.editor.utils

import java.util.Optional

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.EcoreUtil2

import org.emoflon.ibex.gt.editor.gT.ContextReference
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.OperatorReference
import org.emoflon.ibex.gt.editor.gT.Operator
import org.eclipse.emf.ecore.EDataType

/**
 * Utility methods for working with {@link GraphTransformationFile} models.
 */
class GTEditorModelUtils {
	/**
	 * Returns all EClasses imported into the given file.
	 */
	def static getClasses(GraphTransformationFile file) {
		val classes = newArrayList()
		file.imports.forEach [
			loadEcoreModel(it.name).ifPresent [
				classes.addAll(EcoreUtil2.getAllContentsOfType(it.contents.get(0), EClass))
			]
		]
		return classes
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 */
	def static getDatatypes(GraphTransformationFile file) {
		val types = newArrayList()
		file.imports.forEach [
			loadEcoreModel(it.name).ifPresent [
				types.addAll(EcoreUtil2.getAllContentsOfType(it.contents.get(0), EDataType))
			]
		]
		return types
	}

	/**
	 * Returns an Optional for the Ecore model resource with the given URI.
	 */
	def static loadEcoreModel(String uri) {
		try {
			var resourceSet = new ResourceSetImpl()
			var resource = resourceSet.getResource(URI.createURI(uri), true)
			resource.load(null)
			return Optional.of(resource)
		} catch (Exception e) {
			return Optional.empty
		}
	}

	/**
	 * Returns the context references of a node.
	 */
	def static getContextReferences(Node node) {
		return node.references.filter [
			it instanceof ContextReference
		].map [
			it as ContextReference
		]
	}

	/**
	 * Returns the operator references of a node.
	 */
	def static getOperatorReferences(Node node) {
		return node.references.filter [
			it instanceof OperatorReference
		].map [
			it as OperatorReference
		]
	}

	/**
	 * Returns the created references of a node.
	 */
	def static getCreatedReferences(Node node) {
		return getOperatorReferences(node).filter [
			it.operator == Operator.CREATE
		]
	}

	/**
	 * Returns the deleted references of a node.
	 */
	def static getDeletedReferences(Node node) {
		return getOperatorReferences(node).filter [
			it.operator == Operator.DELETE
		]
	}
}
