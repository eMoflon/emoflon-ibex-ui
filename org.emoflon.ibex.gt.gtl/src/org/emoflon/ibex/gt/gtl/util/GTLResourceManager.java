package org.emoflon.ibex.gt.gtl.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.common.slimgt.util.XtextResourceManager;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.moflon.core.utilities.LogUtils;

public class GTLResourceManager {
	Logger logger = Logger.getLogger(GTLResourceManager.class);
	final protected XtextResourceManager xtextResources;

	public GTLResourceManager() {
		this.xtextResources = new XtextResourceManager();
	}

	public GTLResourceManager(final XtextResourceManager xtextResources) {
		this.xtextResources = xtextResources;
	}

	public Optional<EditorFile> loadGTLModelByFullPath(final EObject context, final String path) {
		return loadGTLModelByFullPath(context.eResource(), path);
	}

	public Optional<EditorFile> loadGTLModelByFullPath(final Resource requester, final String path) {
		Resource resource = null;
		URI gtModelUri = null;
		EditorFile file = null;

		File importFile = new File(path);
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			gtModelUri = URI.createFileURI(path);

			IProject other = SlimGTWorkspaceUtil.getProjectOfFile(SlimGTWorkspaceUtil.getCurrentProject(requester),
					new File(path), ".gtl", true);
			if (other == null)
				return Optional.empty();

			URI platformUri = toPlatformURI(other, gtModelUri);

			try {
				resource = xtextResources.loadResource(requester, platformUri);
				file = (EditorFile) resource.getContents().get(0);
			} catch (Exception e) {
				LogUtils.error(logger, e);
				return Optional.empty();
			}
		}

		if (file == null) {
			return Optional.empty();
		} else {
			return Optional.of(file);
		}
	}

	public Optional<EditorFile> loadGTLModelByRelativePath(final EObject context, final String path) {
		return loadGTLModelByRelativePath(context.eResource(), path);
	}

	public Optional<EditorFile> loadGTLModelByRelativePath(final Resource requester, final String path) {
		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(requester);
		Resource resource = null;
		URI gtModelUri = null;
		String absolutePath = null;
		EditorFile file = null;

		try {
			absolutePath = Paths.get(currentProject.getLocation().toPortableString()).resolve(Paths.get(path)).toFile()
					.getCanonicalPath();
		} catch (IOException e1) {
			return Optional.empty();
		}

		gtModelUri = URI.createFileURI(absolutePath);
		IProject other = SlimGTWorkspaceUtil.getProjectOfFile(currentProject, new File(absolutePath), ".gtl", true);
		if (other == null)
			return Optional.empty();

		URI platformUri = toPlatformURI(other, gtModelUri);
		try {
			resource = xtextResources.loadResource(requester, platformUri);
			file = (EditorFile) resource.getContents().get(0);
		} catch (Exception e) {
			LogUtils.error(logger, e);
			return Optional.empty();
		}

		if (file == null) {
			return Optional.empty();
		} else {
			return Optional.of(file);
		}
	}

	public Optional<EditorFile> loadGTLModelByImport(final PatternImport imp) {
		String currentImport = imp.getFile().getValue().replace("\"", "");
		File importFile = new File(currentImport);
		Optional<EditorFile> optFile = null;
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			optFile = loadGTLModelByFullPath(imp, currentImport);
		} else {
			optFile = loadGTLModelByRelativePath(imp, currentImport);
		}
		return optFile;
	}

	public Collection<EditorFile> loadAllEditorFilesInPackage(final EditorFile ef) {
		Collection<EditorFile> pkgScope = new LinkedList<>();

		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(ef.eResource());
		String currentFile = ef.eResource().getURI().toString().replace("platform:/resource/", "")
				.replace(currentProject.getName(), "");
		currentFile = currentProject.getLocation().toPortableString() + currentFile;
		currentFile = currentFile.replace("/", "\\");

		IWorkspace ws = ResourcesPlugin.getWorkspace();
		for (IProject project : ws.getRoot().getProjects()) {
			try {
				if (!project.hasNature("org.emoflon.ibex.gt.gtl.ui.nature"))
					continue;
			} catch (CoreException e) {
				continue;
			}

			File projectFile = new File(project.getLocation().toPortableString());
			List<File> gtFiles = new LinkedList<>();
			SlimGTWorkspaceUtil.gatherFilesWithEnding(gtFiles, projectFile, ".gtl", true);

			for (File gtFile : gtFiles) {
				URI gtModelUri;
				try {
					gtModelUri = URI.createFileURI(gtFile.getCanonicalPath());
				} catch (IOException e) {
					LogUtils.error(logger, e);
					continue;
				}

				String fileString = gtModelUri.toFileString();

				if (fileString.equals(currentFile))
					continue;
				URI platformUri = toPlatformURI(project, gtModelUri);
				Resource resource = xtextResources.loadResource(ef.eResource(), platformUri);
				if (resource == null)
					continue;

				if (resource.getContents().isEmpty())
					continue;

				EObject gtlModel = resource.getContents().get(0);

				if (gtlModel == null)
					continue;

				if (gtlModel instanceof EditorFile otherEditorFile) {
					if (otherEditorFile.getPackage().getName().equals(ef.getPackage().getName())) {
						pkgScope.add(otherEditorFile);
					}
				}
			}
		}

		return pkgScope;
	}

	public URI toPlatformURI(IProject project, URI fileURI) {
		String fileString = fileURI.toFileString();
		String projectRelativePath = Path.of(project.getLocation().toPortableString()).relativize(Path.of(fileString))
				.toFile().getPath();
		URI uri = URI.createPlatformResourceURI(project.getName() + "/" + projectRelativePath, false);
		return uri;
	}

	public Collection<SlimRule> getAllRulesInScope(EditorFile ef) {
		Set<SlimRule> ruleSet = new HashSet<>();

		// Add directly imported patterns
		ef.getImportedPatterns().stream().filter(pi -> !pi.isImportingAll())
				.forEach(pi -> ruleSet.add(pi.getPattern()));
		ruleSet.addAll(ef.getRules());

		// Add imported patterns by wildcard
		ef.getImportedPatterns().stream().filter(pi -> pi.isImportingAll()).forEach(pi -> {
			Optional<EditorFile> optEditorFile = loadGTLModelByImport(pi);
			if (optEditorFile.isPresent()) {
				ruleSet.addAll(optEditorFile.get().getRules());
			}
		});

		// Add patterns in package name
		Collection<EditorFile> scope = loadAllEditorFilesInPackage(ef);
		scope.forEach(other -> ruleSet.addAll(other.getRules()));

		return ruleSet;
	}
}
