package org.emoflon.ibex.gt.editor.utils

import java.util.Optional

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2

import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile

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
				classes.addAll(getClasses(it))
			]
		]
		return classes
	}

	/**
	 * Returns all EClasses from the given resource. 
	 */
	def static getClasses(Resource resource) {
		return EcoreUtil2.getAllContentsOfType(resource.contents.get(0), EClass)
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
}
