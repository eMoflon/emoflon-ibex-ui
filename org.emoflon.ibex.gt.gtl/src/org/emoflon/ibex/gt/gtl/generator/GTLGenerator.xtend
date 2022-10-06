/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.moflon.core.utilities.ExtensionsUtil
import org.emoflon.ibex.common.slimgt.build.SlimGTBuilderExtension
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil
import java.util.HashSet
import org.eclipse.core.resources.IProject

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GTLGenerator extends AbstractGenerator {

	var ResourceSet resourceSet = null
	var projects = new HashSet<IProject>()

	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var lResource = input.resourceSet as SynchronizedXtextResourceSet
		val iProject = SlimGTWorkspaceUtil.getCurrentProject(input)
		
		// small trick to make sure that GT projects are only build once (every new build process creates new ResourceSets)
		if(resourceSet !== null && projects.contains(iProject)) {
			return
		}else if(resourceSet !== null && !projects.contains(iProject)) {
			projects.add(iProject)
		} else {
			projects.clear
			projects.add(iProject)
			resourceSet = lResource
		}
		
		ExtensionsUtil
			.collectExtensions(SlimGTBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(SlimGTBuilderExtension))
			.filter[builder | builder.hasProperNature(iProject)]
			.forEach[builder | builder.build(iProject)];
	}
}
