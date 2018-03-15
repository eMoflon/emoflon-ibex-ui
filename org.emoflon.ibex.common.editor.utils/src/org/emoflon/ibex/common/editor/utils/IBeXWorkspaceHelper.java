package org.emoflon.ibex.common.editor.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.moflon.core.utilities.WorkspaceHelper;

public class IBeXWorkspaceHelper {
	/**
	 * Adds the nature as first one to the given project if the project does not
	 * have the nature yet.
	 * 
	 * @param project
	 *            the project
	 * @param natureId
	 *            the nature ID
	 * @param monitor
	 *            the monitor, may be <code>null</code>
	 * @throws CoreException
	 *             if an error occurs while reading/writing the project
	 */
	public static void addFirstProjectNature(final IProject project, final String natureId,
			final IProgressMonitor monitor) throws CoreException {
		Objects.requireNonNull(project, "Project must not be null!");
		Objects.requireNonNull(natureId, "Nature must not be null!");

		if (WorkspaceHelper.hasNature(project, natureId)) {
			return;
		}

		final SubMonitor subMon = SubMonitor.convert(monitor,
				String.format("Add nature %s to project %s", natureId, project.getName()), 2);

		final IProjectDescription description = project.getDescription();
		final List<String> natures = new ArrayList<>(Arrays.asList(description.getNatureIds()));
		if (!natures.contains(natureId)) {
			natures.add(0, natureId);
			description.setNatureIds(natures.toArray(new String[natures.size()]));
		}
		project.setDescription(description, subMon.split(1));
	}
}
