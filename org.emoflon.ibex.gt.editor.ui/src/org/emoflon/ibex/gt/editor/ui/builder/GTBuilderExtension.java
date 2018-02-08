package org.emoflon.ibex.gt.editor.ui.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

/**
 * This builder extension will be called by the {@link GTBuilder} if the set of
 * rules in a package has been changed.
 * 
 * @author Patrick Robrecht
 * @version 1.0
 * @since 1.0
 */
public interface GTBuilderExtension {
	static final String BUILDER_EXTENSON_ID = "org.emoflon.ibex.gt.editor.ui.GTBuilderExtension";

	/**
	 * Builds the package of a project.
	 * 
	 * @param project
	 *            the project to build
	 * @param packagePath
	 *            the path to the package
	 */
	public void run(IProject project, IPath packagePath);
}
