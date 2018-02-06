package org.emoflon.ibex.gt.editor.ui.wizard

import com.google.inject.Inject

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.resource.FileExtensionProvider

/**
 * Create the files with initial content.
 */
class GTNewProjectWizardInitialContents {
	@Inject
	FileExtensionProvider fileExtensionProvider

	def generateInitialContents(IFileSystemAccess2 fsa, IProject project) {
		val packagePath = project.name.replace(".", "/")
		fsa.generateFile(
			"src/" + packagePath + "/Rules." + fileExtensionProvider.primaryFileExtension,
			'''
				import "http://www.eclipse.org/emf/2002/Ecore"
				
				rule firstRule() {
					object: EObject
				}
			'''
		)
	}
}
