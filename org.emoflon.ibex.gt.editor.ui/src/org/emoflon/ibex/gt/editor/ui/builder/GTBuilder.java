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
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;

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
	private final static String SOURCE_FOLDER = "src";

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		switch (kind) {
		case AUTO_BUILD:
		case INCREMENTAL_BUILD:
			this.log("Start incremental build");
			buildIncremental();
			break;
		case CLEAN_BUILD:
		case FULL_BUILD:
			this.log("Start full build");
			buildPackages(this.findSourcePackages());
			break;
		default:
			break;
		}
		return null;
	}

	/**
	 * Performs an incremental build.
	 */
	private void buildIncremental() {
		Arrays.stream(this.getDelta(this.getProject()).getAffectedChildren())
				.filter(affectedChild -> "src".equals(affectedChild.getProjectRelativePath().toString())).findAny()
				.ifPresent(srcDelta -> this.buildPackagesForDelta(srcDelta));
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
	 * Performs a build for the packages in the given delta.
	 * 
	 * @param delta
	 *            the resource delta including the recent changes
	 */
	private void buildPackagesForDelta(final IResourceDelta delta) {
		List<IPath> packages = this.findSourcePackages();
		// TODO remove all packages with are not in the delta.
		this.buildPackages(packages);
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
				collectExtensions(GTBuilderExtension.BUILDER_EXTENSON_ID, "class", GTBuilderExtension.class)
						.forEach(ext -> {
							ext.run(project, packagePath);
						});
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
		IFolder srcFolder = this.getProject().getFolder(SOURCE_FOLDER);
		return this.findFolders(srcFolder).stream() //
				.map(p -> p.getLocation().makeRelativeTo(srcFolder.getLocation())) // relative paths
				.collect(Collectors.toList());
	}

	/**
	 * Returns a set of folders in the given container which contain .gt files.
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
					final IContainer c = (IContainer) member;
					set.addAll(findFolders(c));
					boolean isRulePackage = Arrays.stream(c.members()) //
							.filter(m -> m instanceof IFile).map(m -> (IFile) m) // find a file
							.anyMatch(f -> "gt".equals(f.getFileExtension())); // with extension gt
					if (isRulePackage) {
						set.add(c);
					}
				}
			}
		} catch (Throwable e) {
			this.logError(e.getMessage());
		}
		return set;
	}

	// TODO Refactor code: duplicate of
	// org.emoflon.ibex.tgg.editor/src/org/moflon/util/IbexUtil.java
	private static <T> List<T> collectExtensions(final String extensionID, final String property,
			final Class<T> extensionType) {
		List<T> extensions = new ArrayList<T>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionID);
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension(property);
				if (extensionType.isInstance(o)) {
					extensions.add(extensionType.cast(o));
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return extensions;
	}
}
