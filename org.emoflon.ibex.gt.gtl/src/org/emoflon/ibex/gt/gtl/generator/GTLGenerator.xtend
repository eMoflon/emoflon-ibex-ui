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
import java.util.LinkedList
import java.io.File
import java.util.HashMap
import java.util.Collection
import org.emoflon.ibex.gt.gtl.gTL.EditorFile
import org.emoflon.ibex.gt.gtl.util.GTLResourceManager
import org.emoflon.ibex.gt.gtl.util.GTLModelFlattener
import org.apache.log4j.Logger
import org.moflon.core.utilities.LogUtils

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GTLGenerator extends AbstractGenerator {

	Logger logger = Logger.getLogger(typeof(GTLGenerator));
	var ResourceSet resourceSet = null
	var projects = new HashSet<IProject>()

	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var lResource = input.resourceSet as SynchronizedXtextResourceSet
		val iProject = SlimGTWorkspaceUtil.getCurrentProject(input)
		
		// small trick to make sure that GT projects are only build once (every new build process creates new ResourceSets)
		if(resourceSet !== null && projects.contains(iProject)) {
//			logger.info('''Project «iProject.name» is already up to date.''')
//			return
		}else if(resourceSet !== null && !projects.contains(iProject)) {
			projects.add(iProject)
		} else {
			projects.clear
			projects.add(iProject)
			resourceSet = lResource
		}
		
		logger.info('''Building project «iProject.name» ...''')
		val files = new LinkedList
		SlimGTWorkspaceUtil.gatherFilesWithEnding(files, new File(iProject.location.toPortableString), ".gtl", true)
		
		val manager = new GTLResourceManager();
		val pkg2Files = new HashMap<String, Collection<EditorFile>>
		for(File f : files) {
			val efOpt = manager.loadGTLModelByFullPath(input, f.canonicalPath)
			if(efOpt.isPresent) {
				val ef = efOpt.get
				var editorFiles = pkg2Files.get(ef.package.name)
				if(editorFiles === null) {
					editorFiles = new LinkedList
					pkg2Files.put(ef.package.name, editorFiles)
				}
				editorFiles.add(ef)
			}
		}
		
		logger.info('''Building project «iProject.name» -> flattening gtl files ...''')
		val pkg2flattened = new HashMap<String, EditorFile>
		try{
			flatten(pkg2flattened, pkg2Files, manager);
		} catch(Exception e) {
			LogUtils.error(logger, e)
		}
		
		logger.info('''Building project «iProject.name» -> calling gtl builder extensions ...''')
		ExtensionsUtil
			.collectExtensions(SlimGTBuilderExtension.BUILDER_EXTENSON_ID, "builder", typeof(SlimGTBuilderExtension))
			.filter[builder | builder.hasProperNature(iProject)]
			.forEach[builder | pkg2flattened.values.forEach[ef | builder.build(iProject, ef)]];
	}
	
	def void flatten(HashMap<String, EditorFile> pkg2flattened, HashMap<String, Collection<EditorFile>> pkg2Files, GTLResourceManager manager) {
		for(String pkg : pkg2Files.keySet) {
			val efs = pkg2Files.get(pkg)
			val flattener = new GTLModelFlattener(manager, efs)
			val flattenedEf = flattener.flattenedModel
			pkg2flattened.put(pkg, flattenedEf)
		}
	}
}
