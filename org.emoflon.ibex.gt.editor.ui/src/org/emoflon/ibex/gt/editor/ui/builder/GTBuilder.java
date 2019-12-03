package org.emoflon.ibex.gt.editor.ui.builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.moflon.core.utilities.ExtensionsUtil;

/**
 * Builder for Graph Transformation Projects.
 */
public class GTBuilder extends IncrementalProjectBuilder {
	/**
	 * The ID of the GTBuilder.
	 */
	public static final String BUILDER_ID = "org.emoflon.ibex.gt.editor.ui.builder";

	/**
	 * The name of the source folder. The builds are only triggered for changes in
	 * this folder.
	 */
	public final static String SOURCE_FOLDER = "src";

	/**
	 * the project's source folder.
	 */
	private IFolder srcFolder;

	@Override
	protected IProject[] build(final int kind, final Map<String, String> args, final IProgressMonitor monitor)
			throws CoreException {
		srcFolder = getProject().getFolder(SOURCE_FOLDER);
		if (!srcFolder.exists()) {
			log("src folder is missing");
			return null;
		}

		// Run builder extensions for the project.
		runBuilderExtensions(ext -> ext.run(getProject()));

		// Run builder extensions for each package.
		switch (kind) {
		case AUTO_BUILD:
		case INCREMENTAL_BUILD:
			incrementalBuild();
			break;
		case CLEAN_BUILD:
		case FULL_BUILD:
			fullBuild();
			break;
		default:
			break;
		}
		return null;
	}

	/**
	 * Performs an incremental build.
	 */
	private void incrementalBuild() {
		log("incremental build");
		Arrays.stream(getDelta(getProject()).getAffectedChildren())
				.filter(child -> child.getProjectRelativePath().toString().contains("src"))
				.filter(child -> !child.getProjectRelativePath().toString().contains("src-gen"))
				.filter(srcDelta -> folderContainsGTModel(srcDelta))
				.forEach(srcDelta -> buildPackages(getPackagesFromDelta(srcDelta)));
	}
	
	private boolean folderContainsGTModel(IResourceDelta srcDelta) {
		Queue<IResourceDelta> affectedChildren = new LinkedList<>();
		affectedChildren.addAll(Arrays.asList(srcDelta.getAffectedChildren()));
		while(!affectedChildren.isEmpty()) {
			IResourceDelta child = affectedChildren.poll();
			if(child.getResource().getType() == IResource.FILE) {
				if(child.getResource().getProjectRelativePath().toString().contains(".gt"));
					return true;
				
			}
			affectedChildren.addAll(Arrays.asList(child.getAffectedChildren()));
		}
		return false;
	}

	/**
	 * Performs a full build.
	 */
	private void fullBuild() {
		log("full build");
		buildPackages(findFolders(srcFolder));
	}

	/**
	 * Performs a build for the given packages.
	 * 
	 * @param packages the packages to build
	 */
	private void buildPackages(final Set<IPath> packages) {
		packages.forEach(packagePath -> runBuilderExtensions(ext -> ext.run(getProject(), packagePath)));
	}

	/**
	 * Runs the registered GTBuilderExtensions for the package.
	 * 
	 * @param action the method to call on the builder extension
	 */
	private void runBuilderExtensions(final Consumer<GTBuilderExtension> action) {
		final ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(final Throwable e) {
				logError(e.getMessage());
			}

			@Override
			public void run() throws Exception {
				ExtensionsUtil
						.collectExtensions(GTBuilderExtension.BUILDER_EXTENSON_ID, "class", GTBuilderExtension.class)
						.forEach(action);
			}
		};
		SafeRunner.run(runnable);
	}

	/**
	 * Logs the message on the console.
	 */
	private void log(final String message) {
		Logger.getRootLogger().info(getProject().getName() + ": " + message);
	}

	/**
	 * Logs the error message on the console.
	 */
	private void logError(final String message) {
		Logger.getRootLogger().error(getProject().getName() + ": " + message);
	}

	/**
	 * Determines the folders containing .gt files in the given delta.
	 * 
	 * @param delta the delta
	 * @return the package paths affected by the delta
	 */
	private Set<IPath> getPackagesFromDelta(final IResourceDelta delta) {
		final Set<IPath> paths = new HashSet<>();
		final IResource resource = delta.getResource();
		if (resource.getType() == IResource.FOLDER) {
			Arrays.stream(delta.getAffectedChildren()).forEach(c -> {
				paths.addAll(getPackagesFromDelta(c));
			});
			if (isRulePackage(delta.getAffectedChildren())) {
				paths.add(resource.getLocation().makeRelativeTo(srcFolder.getLocation()));
			}
		}
		return paths;
	}

	/**
	 * Checks whether the given resource delta contains at least one gt file.
	 * 
	 * @param delta the resources delta
	 * @return true if a gt file is found
	 */
	private static boolean isRulePackage(final IResourceDelta[] delta) {
		return Arrays.stream(delta) //
				.filter(c -> c.getResource().getType() == IResource.FILE)
				.anyMatch(c -> c.getResource().getName().endsWith(".gt"));
	}

	/**
	 * Determines the folders in the given container which contain .gt files.
	 * 
	 * @param container the container to check for folders
	 * @return the package paths in the container which contain .gt files
	 */
	private Set<IPath> findFolders(final IContainer container) {
		final Set<IPath> set = new HashSet<>();
		IResource[] members;
		try {
			members = container.members();
		} catch (final Throwable e) {
			logError(e.getMessage());
			return set;
		}
		Arrays.stream(members) //
				.filter(m -> m instanceof IContainer).map(m -> (IContainer) m) //
				.forEach(m -> set.addAll(findFolders(m)));
		if (isRulePackage(members)) {
			set.add(container.getLocation().makeRelativeTo(srcFolder.getLocation()));
		}
		return set;
	}

	/**
	 * Checks whether the given resources contain at least one gt file.
	 * 
	 * @param members the resources to search
	 * @return true if a gt file is found
	 */
	private static boolean isRulePackage(final IResource[] members) {
		return Arrays.stream(members) //
				.filter(m -> m instanceof IFile).map(m -> (IFile) m) // find a file
				.anyMatch(f -> "gt".equals(f.getFileExtension())); // with extension gt
	}
}
