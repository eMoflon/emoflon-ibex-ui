package org.emoflon.ibex.gt.editor.ui.builder;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PlatformUI;

/**
 * Builder for Graph Transformation Projects.
 */
public class GTBuilder extends IncrementalProjectBuilder {
	public static final String BUILDER_ID = "org.emoflon.ibex.gt.editor.ui.builder";

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		switch (kind) {
		case AUTO_BUILD:
		case CLEAN_BUILD:
		case FULL_BUILD:
		case INCREMENTAL_BUILD:
			generateIfNecessary();
			break;
		default:
			break;
		}
		return null;
	}

	private void generateIfNecessary() {
		Arrays.stream(this.getDelta(this.getProject()).getAffectedChildren())
				.filter(affectedChild -> "src".equals(affectedChild.getProjectRelativePath().toString())).findAny()
				.ifPresent(srcDelta -> {
					GTPackageBuilder.findSourcePackagesInProject(this.getProject()).forEach(packagePath -> {
						this.generatePackage(packagePath);
					});
				});
	}

	/**
	 * Starts generator for the given package.
	 * 
	 * @param packagePath
	 *            the path of the package
	 */
	private void generatePackage(final IPath packagePath) {
		IProject project = this.getProject();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				new GTPackageBuilder(project, packagePath).generate();
			}
		});
	}
}
