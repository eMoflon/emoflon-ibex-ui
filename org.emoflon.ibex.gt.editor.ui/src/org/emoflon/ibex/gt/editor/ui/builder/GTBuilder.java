package org.emoflon.ibex.gt.editor.ui.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.emoflon.ibex.common.editor.utils.ExtensionsUtil;

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
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		this.srcFolder = this.getProject().getFolder(SOURCE_FOLDER);
		if (!this.srcFolder.exists()) {
			this.log("src folder is missing");
			return null;
		}

		switch (kind) {
		case AUTO_BUILD:
		case INCREMENTAL_BUILD:
			this.log("incremental build");
			Arrays.stream(this.getDelta(this.getProject()).getAffectedChildren())
					.filter(affectedChild -> "src".equals(affectedChild.getProjectRelativePath().toString())).findAny()
					.ifPresent(srcDelta -> this.buildPackages(this.getPackagesFromDelta(srcDelta)));
			break;
		case CLEAN_BUILD:
		case FULL_BUILD:
			this.log("full build");
			buildPackages(this.findSourcePackages());
			break;
		default:
			break;
		}
		return null;
	}

	/**
	 * Performs a build for the given packages.
	 * 
	 * @param packages
	 *            the packages to build
	 */
	private void buildPackages(final List<IPath> packages) {
		packages.forEach(p -> this.runExtraBuilderExtensions(p));
	}

	/**
	 * Calculates the set of packages containing .gt files in the given delta.
	 * 
	 * @param delta
	 *            the delta
	 * @return the list of package paths affected by the delta
	 */
	private List<IPath> getPackagesFromDelta(final IResourceDelta delta) {
		ArrayList<IPath> paths = new ArrayList<IPath>();
		IResource deltaResource = delta.getResource();
		if (deltaResource.getType() == IResource.FOLDER) {
			Arrays.stream(delta.getAffectedChildren()).forEach(c -> {
				paths.addAll(this.getPackagesFromDelta(c));
			});
			boolean isRulePackage = Arrays.stream(delta.getAffectedChildren()) //
					.filter(c -> c.getResource().getType() == IResource.FILE)
					.anyMatch(c -> c.getResource().getName().endsWith(".gt"));
			if (isRulePackage) {
				paths.add(deltaResource.getLocation().makeRelativeTo(this.srcFolder.getLocation()));
			}
		}
		return paths;
	}

	/**
	 * Runs the registered GTBuilderExtensions for the package.
	 * 
	 * @param packagePath
	 *            the path of the package to build
	 */
	private void runExtraBuilderExtensions(final IPath packagePath) {
		IProject project = this.getProject();
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				logError(e.getMessage());
			}

			@Override
			public void run() throws Exception {
				ExtensionsUtil
						.collectExtensions(GTBuilderExtension.BUILDER_EXTENSON_ID, "class", GTBuilderExtension.class)
						.forEach(ext -> ext.run(project, packagePath));
			}
		};
		SafeRunner.run(runnable);
	}

	/**
	 * Logs the message on the console.
	 */
	private void log(final String message) {
		Logger.getRootLogger().info(this.getProject().getName() + ": " + message);
	}

	/**
	 * Logs the error message on the console.
	 */
	private void logError(final String message) {
		Logger.getRootLogger().error(this.getProject().getName() + ": " + message);
	}

	/**
	 * Returns a list of packages in the project's source folder which contain .gt
	 * files.
	 * 
	 * @return the list of package paths
	 */
	private List<IPath> findSourcePackages() {
		return this.findFolders(this.srcFolder).stream() //
				.map(p -> p.getLocation().makeRelativeTo(this.srcFolder.getLocation())) // relative paths
				.collect(Collectors.toList());
	}

	/**
	 * Determines the set of folders in the given container which contain .gt files.
	 * 
	 * @param container
	 *            the container to check for folders
	 * @return the folders in the container which contain .gt files
	 */
	private Set<IContainer> findFolders(final IContainer container) {
		final HashSet<IContainer> set = new HashSet<IContainer>();
		try {
			for (final IResource member : container.members()) {
				if (member instanceof IContainer) {
					set.addAll(this.findFolders((IContainer) member));
				}
			}
			boolean isRulePackage = Arrays.stream(container.members()) //
					.filter(m -> m instanceof IFile).map(m -> (IFile) m) // find a file
					.anyMatch(f -> "gt".equals(f.getFileExtension())); // with extension gt
			if (isRulePackage) {
				set.add(container);
			}
		} catch (Throwable e) {
			this.logError(e.getMessage());
		}
		return set;
	}
}
