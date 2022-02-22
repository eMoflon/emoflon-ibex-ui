package org.emoflon.ibex.gt.editor.ui.builder;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.PlatformUI;

/**
 * Nature for Graph Transformation Projects.
 */
public class GTNature implements IProjectNature {
	public static final String NATURE_ID = "org.emoflon.ibex.gt.editor.ui.nature";

	private IProject project;

	@Override
	public void configure() throws CoreException {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					addGTBuilder();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addGTBuilder() throws CoreException {
		IProjectDescription projectDescription = project.getDescription();
		ICommand[] buildSpec = projectDescription.getBuildSpec();

		Collection<ICommand> list = new ArrayList<>();
		getRequiredBuilders().forEach(builderId -> {
			ICommand command = projectDescription.newCommand();
			command.setBuilderName(builderId);
			list.add(command);
		});

		list.addAll(Arrays.asList(buildSpec));
		projectDescription.setBuildSpec(list.toArray(new ICommand[list.size()]));
		project.setDescription(projectDescription, new NullProgressMonitor());
	}

	@Override
	public void deconfigure() throws CoreException {
		// Not required
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * Returns the list of required builders for the nature.
	 * @return the builder IDs
	 */
	public static Collection<String> getRequiredBuilders() {
		return Lists.newArrayList(GTBuilder.BUILDER_ID);
	}
}
