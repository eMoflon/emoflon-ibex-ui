package org.emoflon.ibex.gt.editor.ui.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;
import org.emoflon.ibex.gt.editor.ui.builder.GTNature;
import org.moflon.core.plugins.manifest.ManifestFileUpdater;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Creator for Graph Transformation Projects.
 */
public class GTProjectCreator extends AbstractPluginProjectCreator {
	@Inject
	private GTNewFileInitialContents initialContents;

	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;

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
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
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
		return ImmutableList.of(getModelFolderName(), "src-gen");
	}

	@Override
	protected String[] getProjectNatures() {
		final ArrayList<String> natures = Lists.newArrayList(GTNature.NATURE_ID);
		natures.addAll(Lists.newArrayList(super.getProjectNatures()));
		return natures.toArray(new String[natures.size()]);
	}

	@Override
	protected String[] getBuilders() {
		final ArrayList<String> builders = Lists.newArrayList(GTNature.getRequiredBuilders());
		builders.addAll(Lists.newArrayList(super.getBuilders()));
		return builders.toArray(new String[builders.size()]);
	}

	@Override
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList();
	}

	@Override
	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		final IFileSystemAccess2 access = getFileSystemAccess(project, monitor);
		initialContents.generateInitialContents(access, project);
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	protected IFileSystemAccess2 getFileSystemAccess(final IProject project, final IProgressMonitor monitor) {
		final EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
		access.setContext(project);
		access.setMonitor(monitor);
		final OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultOutput.setDescription("Output Folder");
		defaultOutput.setOutputDirectory("./");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(false);
		defaultOutput.setSetDerivedProperty(false);
		defaultOutput.setKeepLocalHistory(false);
		final HashMap<String, OutputConfiguration> outputConfigurations = new HashMap<>();
		outputConfigurations.put(IFileSystemAccess.DEFAULT_OUTPUT, defaultOutput);
		access.setOutputConfigurations(outputConfigurations);
		return access;
	}
}
