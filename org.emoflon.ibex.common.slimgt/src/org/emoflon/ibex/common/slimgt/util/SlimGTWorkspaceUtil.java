package org.emoflon.ibex.common.slimgt.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public final class SlimGTWorkspaceUtil {
	public static void gatherFilesWithEnding(Collection<File> gtFiles, File root, String ending, boolean ignoreBin) {
		if (root.isDirectory() && root.exists()) {
			if (ignoreBin && root.getName().equals("bin"))
				return;
			for (File subFile : root.listFiles()) {
				gatherFilesWithEnding(gtFiles, subFile, ending, ignoreBin);
			}
			return;
		} else if (!root.isDirectory() && root.exists()) {
			if (root.getName().endsWith(ending)) {
				gtFiles.add(root);
				return;
			}
		} else {
			return;
		}
	}

	public static synchronized IProject getCurrentProject(final Resource resource) {
		IProject project = null;
		IWorkbenchWindow window = null;

		if (Display.getCurrent() == null && resource != null) {
			String platformString = resource.getURI().toPlatformString(true);
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new org.eclipse.core.runtime.Path(platformString)).getProject();
		} else {
			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		}

		if (window != null) {
			IWorkbenchPage activePage = window.getActivePage();
			IEditorPart activeEditor = activePage.getActiveEditor();

			if (activeEditor != null) {
				IEditorInput input = activeEditor.getEditorInput();

				project = input.getAdapter(IProject.class);
				if (project == null) {
					IResource otherResource = input.getAdapter(IResource.class);
					if (resource != null) {
						project = otherResource.getProject();
					}
				}
			}
		}

		return project;
	}

	public static Optional<IProject> getProjectOfFile(final IProject current, final File file, String ending,
			boolean ignoreBin) {
		File otherProjectFile = null;
		File cf = file;
		while (cf != null && cf.exists()) {
			if (cf.isDirectory()) {
				File[] files = cf.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return (name.equals(".project"));
					}
				});
				// check if this directory contains a .project file
				if (files != null && files.length > 0) {
					otherProjectFile = cf;
					break;
				}
				// otherwise go up
				cf = cf.toPath().getParent().toFile();
			} else {
				cf = cf.toPath().getParent().toFile();
			}
		}

		if (otherProjectFile == null)
			return Optional.empty();

		String otherProjectPath = null;

		try {
			otherProjectPath = otherProjectFile.getCanonicalPath();
		} catch (IOException e) {
			return Optional.empty();
		}

		String currentProjectPath = current.getLocation().toOSString();
		if (currentProjectPath.equals(otherProjectPath))
			return Optional.of(current);

		IWorkspace workspace = current.getWorkspace();
		for (IProject project : workspace.getRoot().getProjects()) {
			String projectPath = project.getLocation().toOSString();
			if (projectPath.equals(otherProjectPath)) {
				return Optional.of(project);
			}
		}

		return Optional.empty();
	}

}
