/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.eclipse.jdt.internal.core.JavaProject
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class TGGLGenerator extends AbstractGenerator {
	var oldFsa = null

	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var lResource = input.resourceSet as SynchronizedXtextResourceSet
		val project = lResource.classpathURIContext as JavaProject
		val iProject = project.project
		
		val xtextParsedTGG = input.getContents().get(0) as EditorFile;
		if(xtextParsedTGG.schema === null)
			return;
			
		// trick to avoid xtext triggering endless loops
		if(fsa !== null && oldFsa.hashCode == fsa.hashCode) 
			return;
		
		this.oldFsa = fsa
		
//		ExtensionsUtil
//			.collectExtensions(TGGBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(TGGBuilderExtension))
//			.forEach[builder | builder.run(iProject, input)];
	}
}
