package org.emoflon.ibex.tgg.tggl.generator;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;

public interface TGGBuilderExtension {

	public static final String BUILDER_EXTENSON_ID = "org.emoflon.ibex.tgg.editor.TGGBuilderExtension";

	/**
	 * Builds the package in the given project. This will be triggered for each package containing .gt
	 * files.
	 * 
	 * @param project the project to build
	 */
	public void run(IProject project, Resource schemaResource);

}
