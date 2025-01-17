/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl.generator

import com.google.inject.Inject
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.emoflon.ibex.common.slimgt.build.SlimGTBuilderExtension
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile
import org.emoflon.ibex.tgg.tggl.util.TGGLModelFlattener
import org.moflon.core.utilities.ExtensionsUtil

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class TGGLGenerator extends AbstractGenerator {
	var oldFsa = null
	
	@Inject
  	ResourceDescriptionsProvider resourceDescriptionsProvider;
 
    @Inject
 	IContainer.Manager containerManager;
	
	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if(input.contents.empty)
			return;
			
		var content = input.contents.get(0)
		if(content instanceof EditorFile) {
			if(content.schema == null)
				return
		}
		
		// trick to avoid xtext triggering endless loops
		if(oldFsa !== null && oldFsa.hashCode == fsa.hashCode) 
			return;
		
		val newFile = new TGGLModelFlattener().flatten(resourceDescriptionsProvider, containerManager, input);
		
		this.oldFsa = fsa
		
		val iProject = SlimGTWorkspaceUtil.getCurrentProject(input)

		ExtensionsUtil
			.collectExtensions(SlimGTBuilderExtension.BUILDER_EXTENSON_ID, "builder", typeof(SlimGTBuilderExtension))
			.filter[builder | builder.hasProperNature(iProject)]
			.forEach[builder | builder.build(iProject, newFile)];
		
		wipeProblemView(iProject);
	}
	
	def void wipeProblemView(IProject project) {
		var markers = project.findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE)
		for(IMarker marker : markers) {
			marker.delete()
		}
    	project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());	
	}
}
