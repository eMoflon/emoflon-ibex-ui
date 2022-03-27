/*
 * generated by Xtext
 */
package org.moflon.tgg.mosl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jdt.internal.core.JavaProject
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.moflon.core.utilities.ExtensionsUtil
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
import org.emoflon.ibex.tgg.builder.TGGBuilderExtension
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class TGGGenerator implements IGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var lResource = input.resourceSet as SynchronizedXtextResourceSet
		val project = lResource.classpathURIContext as JavaProject
		val iProject = project.project
		
		val xtextParsedTGG = input.getContents().get(0) as TripleGraphGrammarFile;
		if(xtextParsedTGG.schema == null)
			return;
		
		ExtensionsUtil
			.collectExtensions(TGGBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(TGGBuilderExtension))
			.forEach[builder | builder.run(iProject, input)];
	}
		
}
