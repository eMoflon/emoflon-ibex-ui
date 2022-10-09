package org.emoflon.ibex.common.slimgt.build;

import org.eclipse.core.resources.IProject;
import org.emoflon.ibex.common.slimgt.slimGT.EditorFile;

public interface SlimGTBuilderExtension {
	static final String BUILDER_EXTENSON_ID = "org.emoflon.ibex.common.slimgt.SlimGTBuilderExtension";

	/**
	 * Builds the project.
	 * 
	 * @param project The project to build
	 */
	public void build(IProject project, EditorFile flattenedEditorFile);

	/**
	 * Checks whether the given project has the proper nature.
	 * 
	 * @param project The project to build
	 */
	public boolean hasProperNature(IProject project);
}
