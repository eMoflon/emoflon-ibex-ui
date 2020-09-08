package org.emoflon.ibex.tgg.ide.admin;

import org.eclipse.core.resources.IProject;

public interface TGGBuilderExtension {
	
	public static final String BUILDER_EXTENSON_ID = "org.emoflon.ibex.tgg.ide.TGGBuilderExtension";
	
	/**
	 * Builds the package in the given project. This will be triggered for each
	 * package containing .gt files.
	 * 
	 * @param project
	 *            the project to build
	 */
	public void run(IProject project);
}
