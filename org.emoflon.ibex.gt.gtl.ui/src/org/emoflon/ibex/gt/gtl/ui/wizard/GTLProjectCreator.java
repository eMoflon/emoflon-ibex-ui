package org.emoflon.ibex.gt.gtl.ui.wizard;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.emoflon.ibex.gt.gtl.ui.builder.GTLNature;
import org.moflon.core.plugins.manifest.ManifestFileUpdater;

/**
 * Creator for Graph Transformation Projects.
 */
public class GTLProjectCreator extends AbstractPluginProjectCreator {

	@Override
	protected PluginProjectFactory createProjectFactory() {
		final PluginProjectFactory projectFactory = super.createProjectFactory();
		projectFactory.setWithPluginXml(false);
		IClasspathEntry cpEntry = JavaRuntime.getDefaultJREContainerEntry();
		projectFactory.setJreContainerEntry(cpEntry);
		return projectFactory;
	}

	@Override
	protected IProject createProject(IProgressMonitor monitor) {
		IProject project = super.createProject(monitor);
		try {
			new ManifestFileUpdater().processManifest(project, manifest -> {
				return ManifestFileUpdater.setBasicProperties(manifest, project.getName());
			});
			addNatureIfNotExists(project, GTLNature.NATURE_ID);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}

	protected void addNatureIfNotExists(final IProject project, final String nature) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures;
		int idx = -1;
		for (int i = 0; i < natures.length; i++) {
			if (natures[i].equals(nature)) {
				idx = i;
				break;
			}
		}

		if (idx >= 0) {
			natures[idx] = natures[0];
			natures[0] = nature;
			newNatures = new String[natures.length];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
		} else {
			newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 1, natures.length);
			newNatures[0] = nature;
		}

		// validate the natures
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = workspace.validateNatureSet(newNatures);

		// only apply new nature, if the status is ok
		if (status.getCode() == IStatus.OK) {
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
	}

	@Override
	protected DefaultProjectInfo getProjectInfo() {
		return (DefaultProjectInfo) super.getProjectInfo();
	}

	@Override
	protected String getModelFolderName() {
		return "src";
	}

	@Override
	protected List<String> getAllFolders() {
		return List.of(getModelFolderName(), "src-gen");
	}

	@Override
	protected List<String> getRequiredBundles() {
		return List.of();
	}

	@Override
	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		GTLNewFileInitialContents.generateInitialContents(project);
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}
}
