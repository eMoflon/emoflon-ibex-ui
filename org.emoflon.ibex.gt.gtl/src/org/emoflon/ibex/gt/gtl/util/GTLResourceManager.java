package org.emoflon.ibex.gt.gtl.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
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

	static protected Map<String, FileAlterationObserver> observers = Collections.synchronizedMap(new HashMap<>());
	static protected Map<String, FileAlterationListener> listeners = Collections.synchronizedMap(new HashMap<>());
	static protected Map<String, FileAlterationMonitor> monitors = Collections.synchronizedMap(new HashMap<>());
	protected Map<IProject, Map<String, File>> editorFilesInWS = Collections.synchronizedMap(new HashMap<>());

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

			Optional<IProject> otherOpt = SlimGTWorkspaceUtil
					.getProjectOfFile(SlimGTWorkspaceUtil.getCurrentProject(requester), new File(path), ".gtl", true);
			if (otherOpt.isEmpty())
				return Optional.empty();

			URI platformUri = toPlatformURI(otherOpt.get(), gtModelUri);

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
		Optional<IProject> otherOpt = SlimGTWorkspaceUtil.getProjectOfFile(currentProject, new File(absolutePath),
				".gtl", true);
		if (otherOpt.isEmpty())
			return Optional.empty();

		URI platformUri = toPlatformURI(otherOpt.get(), gtModelUri);
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
		if (imp.getFile() == null)
			return Optional.empty();

		String currentImport = imp.getFile().getValue().replace("\"", "");
		URI platformURI = URI.createURI(currentImport);
		if (platformURI.isPlatform()) {
			Resource requester = imp.eResource();
			EditorFile file = null;
			try {
				Resource resource = xtextResources.loadResource(requester, platformURI);
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

		File importFile = new File(currentImport);
		Optional<EditorFile> optFile = null;
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			optFile = loadGTLModelByFullPath(imp, currentImport);
		} else {
			optFile = loadGTLModelByRelativePath(imp, currentImport);
		}
		return optFile;
	}

	public Collection<EditorFile> loadAllOtherEditorFilesInPackage(final EditorFile ef) {
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

			Map<String, File> editorFiles = editorFilesInWS.get(project);
			if (editorFiles != null) {
				// This project is already known / watched -> return gtl files
				pkgScope.addAll(editorFiles.values().stream().map(f -> {
					URI gtModelUri;
					try {
						gtModelUri = URI.createFileURI(f.getCanonicalPath());
					} catch (IOException e) {
						LogUtils.error(logger, e);
						return Optional.empty();
					}

					URI platformUri = toPlatformURI(project, gtModelUri);

					if (platformUri.toString().equals(ef.eResource().getURI().toString()))
						return Optional.empty();

					Resource resource = xtextResources.loadResource(ef.eResource(), platformUri);
					if (resource == null)
						return Optional.empty();

					if (resource.getContents().isEmpty())
						return Optional.empty();

					EObject gtlModel = resource.getContents().get(0);

					if (gtlModel == null)
						return Optional.empty();

					if (gtlModel instanceof EditorFile otherEditorFile) {
						return Optional.of(otherEditorFile);
					} else {
						return Optional.empty();
					}
				}).filter(opt -> opt.isPresent()).map(opt -> (EditorFile) opt.get())
						.filter(other -> other.getPackage().getName().equals(ef.getPackage().getName()))
						.collect(Collectors.toSet()));

				continue;
			}

			// This is a new or previously unknown IProject -> register file system watcher
			editorFiles = Collections.synchronizedMap(new HashMap<>());
			editorFilesInWS.put(project, editorFiles);

			File projectFile = new File(project.getLocation().toPortableString());
			FileAlterationObserver observer = observers.get(project.getLocation().toPortableString());
			if (observer == null) {
				observer = new FileAlterationObserver(project.getLocation().toPortableString());
				observers.put(project.getLocation().toPortableString(), observer);
			}

			FileAlterationMonitor monitor = monitors.get(project.getLocation().toPortableString());
			if (monitor == null) {
				monitor = new FileAlterationMonitor(1000);
				monitors.put(project.getLocation().toPortableString(), monitor);
			} else {
				try {
					monitor.stop();
				} catch (Exception e) {
				}
			}

			FileAlterationListener listener = listeners.get(project.getLocation().toPortableString());
			if (listener != null) {
				monitor.removeObserver(observer);
				observer.removeListener(listener);
				listeners.remove(project.getLocation().toPortableString());
			}

			listener = new FileAlterationListenerAdaptor() {
				@Override
				public void onFileCreate(File file) {
					if (file.isFile() && file.getName().endsWith(".gtl")) {
						Map<String, File> editorFiles = editorFilesInWS.get(project);
						try {
							editorFiles.put(file.getCanonicalPath(), file);
						} catch (IOException e) {
							LogUtils.error(logger, e);
							return;
						}
					}
				}

				@Override
				public void onFileDelete(File file) {
					if (file.isFile() && file.getName().endsWith(".gtl")) {
						Map<String, File> editorFiles = editorFilesInWS.get(project);
						try {
							editorFiles.remove(file.getCanonicalPath());
						} catch (IOException e) {
							LogUtils.error(logger, e);
							return;
						}
					}
				}

				@Override
				public void onFileChange(File file) {
					// do nothing...
				}
			};
			listeners.put(project.getLocation().toPortableString(), listener);

			observer.addListener(listener);
			monitor.addObserver(observer);
			try {
				monitor.start();
			} catch (Exception e) {
				LogUtils.error(logger, e);
				continue;
			}

			// Crawl this project initially to get all currently present gtl files
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
					editorFiles.put(gtModelUri.toFileString(), gtFile);

					if (otherEditorFile.getPackage().getName().equals(ef.getPackage().getName())
							&& !fileString.equals(currentFile)) {
						pkgScope.add(otherEditorFile);
					}
				}
			}
		}

		return pkgScope;
	}

	public Collection<EditorFile> loadAllEditorFilesInWorkspaceNotInPackage(final EditorFile requester) {
		Collection<EditorFile> pkgScope = new LinkedList<>();

		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(requester.eResource());
		String currentFile = requester.eResource().getURI().toString().replace("platform:/resource/", "")
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

			Map<String, File> editorFiles = editorFilesInWS.get(project);
			if (editorFiles != null) {
				// This project is already known / watched -> return gtl files
				pkgScope.addAll(editorFiles.values().stream().map(f -> {
					URI gtModelUri;
					try {
						gtModelUri = URI.createFileURI(f.getCanonicalPath());
					} catch (IOException e) {
						LogUtils.error(logger, e);
						return Optional.empty();
					}

					URI platformUri = toPlatformURI(project, gtModelUri);

					if (platformUri.toString().equals(requester.eResource().getURI().toString()))
						return Optional.empty();

					Resource resource = xtextResources.loadResource(requester.eResource(), platformUri);
					if (resource == null)
						return Optional.empty();

					if (resource.getContents().isEmpty())
						return Optional.empty();

					EObject gtlModel = resource.getContents().get(0);

					if (gtlModel == null)
						return Optional.empty();

					if (gtlModel instanceof EditorFile otherEditorFile) {
						return Optional.of(otherEditorFile);
					} else {
						return Optional.empty();
					}
				}).filter(opt -> opt.isPresent()).map(opt -> (EditorFile) opt.get())
						.filter(other -> !other.getPackage().getName().equals(requester.getPackage().getName()))
						.collect(Collectors.toSet()));

				continue;
			}

			// This is a new or previously unknown IProject -> register file system watcher
			editorFiles = Collections.synchronizedMap(new HashMap<>());
			editorFilesInWS.put(project, editorFiles);

			File projectFile = new File(project.getLocation().toPortableString());
			FileAlterationObserver observer = observers.get(project.getLocation().toPortableString());
			if (observer == null) {
				observer = new FileAlterationObserver(project.getLocation().toPortableString());
				observers.put(project.getLocation().toPortableString(), observer);
			}

			FileAlterationMonitor monitor = monitors.get(project.getLocation().toPortableString());
			if (monitor == null) {
				monitor = new FileAlterationMonitor(1000);
				monitors.put(project.getLocation().toPortableString(), monitor);
			}

			FileAlterationListener listener = listeners.get(project.getLocation().toPortableString());
			if (listener != null) {
				try {
					monitor.stop();
				} catch (Exception e) {
				}

				monitor.removeObserver(observer);
				observer.removeListener(listener);
				listeners.remove(project.getLocation().toPortableString());
			}

			listener = new FileAlterationListenerAdaptor() {
				@Override
				public void onFileCreate(File file) {
					if (file.isFile() && file.getName().endsWith(".gtl")) {
						Map<String, File> editorFiles = editorFilesInWS.get(project);
						try {
							editorFiles.put(file.getCanonicalPath(), file);
						} catch (IOException e) {
							LogUtils.error(logger, e);
							return;
						}
					}
				}

				@Override
				public void onFileDelete(File file) {
					if (file.isFile() && file.getName().endsWith(".gtl")) {
						Map<String, File> editorFiles = editorFilesInWS.get(project);
						try {
							editorFiles.remove(file.getCanonicalPath());
						} catch (IOException e) {
							LogUtils.error(logger, e);
							return;
						}
					}
				}

				@Override
				public void onFileChange(File file) {
					// do nothing...
				}
			};
			listeners.put(project.getLocation().toPortableString(), listener);

			observer.addListener(listener);
			monitor.addObserver(observer);
			try {
				monitor.start();
			} catch (Exception e) {
				LogUtils.error(logger, e);
				continue;
			}

			// Crawl this project initially to get all currently present gtl files
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
				Resource resource = xtextResources.loadResource(requester.eResource(), platformUri);
				if (resource == null)
					continue;

				if (resource.getContents().isEmpty())
					continue;

				EObject gtlModel = resource.getContents().get(0);

				if (gtlModel == null)
					continue;

				if (gtlModel instanceof EditorFile otherEditorFile) {
					editorFiles.put(gtModelUri.toFileString(), gtFile);

					if (!otherEditorFile.getPackage().getName().equals(requester.getPackage().getName())
							&& !fileString.equals(currentFile)) {
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
		Collection<EditorFile> scope = loadAllOtherEditorFilesInPackage(ef);
		scope.forEach(other -> ruleSet.addAll(other.getRules()));

		return ruleSet;
	}
}
