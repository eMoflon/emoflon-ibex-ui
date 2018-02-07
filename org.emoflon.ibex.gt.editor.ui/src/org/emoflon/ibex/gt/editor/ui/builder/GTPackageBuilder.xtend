package org.emoflon.ibex.gt.editor.ui.builder

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.util.Set

import org.apache.log4j.Logger
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.runtime.IPath
import org.eclipse.core.resources.IProject

/** 
 * Code generator for the Graph Transformation API.
 */
class GTPackageBuilder {
	static val SOURCE_FOLDER = 'src'
	static val SOURCE_GEN_FOLDER = 'src-gen'

	IProject project
	IPath path
	String packageName
	IFolder sourceGenPackage

	/**
	 * Creates a generator for the path to a package in the project.
	 */
	new(IProject project, IPath path) {
		this.project = project
		this.path = path
		this.packageName = this.path.toString.replace('/', '.')
	}

	/**
	 * Start the generation.
	 */
	def generate() {
		this.log("Start generation")
		this.ensureSourceGenPackageExists
		this.generateModel
		this.generateAPI
		this.log("Finished generation")
	}

	/**
	 * Creates the target package.
	 */
	private def ensureSourceGenPackageExists() {
		var folder = this.ensureFolderExists(this.project.getFolder(SOURCE_GEN_FOLDER))
		for (var i = 0; i < this.path.segmentCount; i++) {
			val s = this.path.segment(i)
			folder = this.ensureFolderExists(folder.getFolder(s))
		}
		this.sourceGenPackage = folder
	}

	/**
	 * Creates the model.
	 */
	private def generateModel() {
		val modelFolder = this.ensureFolderExists(this.sourceGenPackage.getFolder('model'))
		this.writeFile(modelFolder.getFile("text.txt"), "blub")
	}

	/**
	 * Generates the API.
	 */
	private def generateAPI() {
		val apiPackage = this.ensureFolderExists(this.sourceGenPackage.getFolder('api'))
		this.ensureFolderExists(apiPackage.getFolder('matches'))
		this.ensureFolderExists(apiPackage.getFolder('rules'))
	}

	/**
	 * Logs the message on the console.
	 */
	private def log(String message) {
		Logger.rootLogger.info(this.project.name + " - " + this.packageName + ": " + message)
	}

	/**
	 * Creates the given folder if the folder does not exist yet.
	 */
	private def ensureFolderExists(IFolder folder) {
		if (!folder.exists) {
			folder.create(true, true, null)
		}
		return folder
	}
	
	/**
	 * Creates the file containing the content.
	 */
	private def writeFile(IFile file, String content) {
		val contentStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))
		if (file.exists) {
			file.setContents(contentStream, true, true, null)
		} else {
			file.create(contentStream, true, null)
		}
	}

	/**
	 * Returns a list of paths in the given project which contain .gt files.
	 */
	public static def Set<IPath> findSourcePackagesInProject(IProject project) {
		return findFolders(project.getFolder(SOURCE_FOLDER)).map [
			it.location.makeRelativeTo(project.getFolder(SOURCE_FOLDER).location)
		].toSet
	}

	/**
	 * Returns a set of folders in the given container which contain .gt files.
	 */
	private static def Set<IContainer> findFolders(IContainer container) {
		val members = container.members()
		val set = newHashSet()
		for (member : members) {
			if (member instanceof IContainer) {
				val c = member as IContainer
				set.addAll(findFolders(c))
			} else if (member instanceof IFile) {
				val f = member as IFile
				if (f.fileExtension == "gt") {
					set.add(f.parent)
				}
			}
		}
		return set.toSet
	}

}
