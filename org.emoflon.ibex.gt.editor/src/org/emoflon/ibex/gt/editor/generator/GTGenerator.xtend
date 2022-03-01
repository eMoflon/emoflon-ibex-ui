package org.emoflon.ibex.gt.editor.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.eclipse.jdt.internal.core.JavaProject
import org.moflon.core.utilities.ExtensionsUtil
import org.emoflon.ibex.gt.editor.ui.builder.GTBuilderExtension
import org.eclipse.core.resources.IContainer
import java.util.HashSet
import java.util.Arrays
import org.eclipse.core.runtime.IPath
import org.eclipse.core.resources.IResource
import java.util.Set
import org.eclipse.emf.ecore.resource.ResourceSet

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GTGenerator extends AbstractGenerator {

	var ResourceSet resourceSet = null

	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var lResource = input.resourceSet as SynchronizedXtextResourceSet
		val project = lResource.classpathURIContext as JavaProject
		val iProject = project.project
		
		// small trick to make sure that GT projects are only build once (every new build process creates new ResourceSets)
		if(resourceSet != null && lResource.hashCode == resourceSet.hashCode) {
			return
		}
		resourceSet = lResource
		
		ExtensionsUtil
			.collectExtensions(GTBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(GTBuilderExtension))
			.forEach[builder | builder.run(iProject)];
	}
}
