package org.emoflon.ibex.gt.gtl.ui.wizard

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.resource.FileExtensionProvider
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import org.eclipse.core.resources.IFile

/**
 * Create the files with initial content.
 */
class GTLNewFileInitialContents {

	/**
	 * Init project files.
	 */
	def static generateInitialContents(FileExtensionProvider fileExtensionProvider, IFileSystemAccess2 fsa, IProject project) {

		val packagePath = project.name.replace(".", "/")

		// Add a file with an example rule.
		fsa.generateFile(
			"src/" + packagePath + "/Rules." + fileExtensionProvider.primaryFileExtension,
			getFileContent(packagePath)
		)

		// Add a .gitignore
		fsa.generateFile(
			".gitignore",
			'''
				/bin/
				/src-gen/
			'''
		)
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
