package org.emoflon.ibex.gt.gtl.ui.wizard

import org.eclipse.core.resources.IProject
import java.io.ByteArrayInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import org.eclipse.core.resources.IFile

/**
 * Create the files with initial content.
 */
class GTLNewFileInitialContents {

	/**
	 * Init project files.
	 */
	def static generateInitialContents(IProject project) {

		val packagePath = project.name.replace(".", "/")

		// Add a file with an example rule.
		val examplePath = '''«project.location.toPortableString»/src/«packagePath»/Rules.gtl'''
		val fileContent = getFileContent(packagePath)
		Files.write(Paths.get(examplePath), fileContent.bytes)
		
		// Add a .gitignore
		val gitIgnoreContent = 
		'''
		/bin/
		/src-gen/
		'''
		
		val gitIgnorePath = '''«project.location.toPortableString»/.gitignore'''
		Files.write(Paths.get(gitIgnorePath), gitIgnoreContent.bytes)
	}

	/**
	 * Generate an example .gtl file content based on the given parameters.
	 */
	def static String getFileContent(String pkg) {
		return '''
			package «pkg»
			pattern example() {
				object : EObject
			}
		'''
	}

	/**
	 * Init the file with example content.
	 */
	def static void initFileContent(IFile file) {
		val fileName = file.getName()
		val ruleName = fileName.substring(0, 1).toLowerCase() + fileName.substring(1, fileName.length() - 3)
		val content = new ByteArrayInputStream(getFileContent(ruleName).getBytes(StandardCharsets.UTF_8))
		file.setContents(content, true, true, null)
	}
}
