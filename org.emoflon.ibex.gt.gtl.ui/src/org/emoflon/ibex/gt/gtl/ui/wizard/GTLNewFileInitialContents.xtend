package org.emoflon.ibex.gt.gtl.ui.wizard

import org.eclipse.core.resources.IProject
import java.io.ByteArrayInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import org.eclipse.core.resources.IFile
import java.io.File

/**
 * Create the files with initial content.
 */
class GTLNewFileInitialContents {

	/**
	 * Init project files.
	 */
	def static generateInitialContents(IProject project, String basePackage) {
		val packagePath = basePackage.replace(".", "/")

		// Add a file with an example rule.
		val examplePath = '''«project.location.toPortableString»/src/«packagePath»/Example.gtl'''
		val fileContent = getFileContent(basePackage)
		createFoldersIfNecessary(examplePath) 
		Files.write(Paths.get(examplePath), fileContent.bytes)
		
		// Add a .gitignore
		val gitIgnoreContent = 
		'''
		/bin/
		/src-gen/
		'''
		
		val gitIgnorePath = '''«project.location.toPortableString»/.gitignore'''
		createFoldersIfNecessary(gitIgnorePath) 
		Files.write(Paths.get(gitIgnorePath), gitIgnoreContent.bytes)
	}

	/**
	 * Generate an example .gtl file content based on the given parameters.
	 */
	def static String getFileContent(String pkg) {
		return '''
			package «pkg»
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			pattern example {
				[=] object : EObject
			};
		'''
	}

	/**
	 * Init the file with example content.
	 */
	def static void initFileContent(IFile file, String pkg) {
		val content = new ByteArrayInputStream(getFileContent(pkg).getBytes(StandardCharsets.UTF_8))
		file.setContents(content, true, true, null)
	}
	
	def static void createFoldersIfNecessary(String file) {
		createFoldersIfNecessary(new File(file));
	}
	
	def static void createFoldersIfNecessary(File file) {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs()
		}
	}
}
