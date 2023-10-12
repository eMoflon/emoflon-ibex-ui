package org.emoflon.ibex.tgg.editor.defaults;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.moflon.core.utilities.WorkspaceHelper;

public class AttrCondDefLibraryProvider {

	private static final String ATTR_COND_DEF_LIBRARY_PATH = "src/org/emoflon/ibex/tgg/csp/lib/AttrCondDefLibrary.tgg";

	public static void syncAttrCondDefLibrary(IProject project) throws CoreException, IOException {
		String path = ATTR_COND_DEF_LIBRARY_PATH;
		String defaultLib = DefaultFilesHelper.generateDefaultAttrCondDefLibrary();
		IPath pathToLib = new Path(path);
		IFile attrLibFile = project.getFile(pathToLib);
		if (attrLibFile.exists()) {
			String contents = Files.readString(attrLibFile.getLocation().toPath());
			if (!contents.equals(defaultLib)) {
				WorkspaceHelper.addAllFoldersAndFile(project, pathToLib, defaultLib, new NullProgressMonitor());
			}
		} else {
			WorkspaceHelper.addAllFoldersAndFile(project, pathToLib, defaultLib, new NullProgressMonitor());
		}
	}

}