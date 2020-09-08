package org.emoflon.ibex.tgg.ide.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.wizards.JavaCapabilityConfigurationPage;
import org.eclipse.ui.PlatformUI;
import org.moflon.core.plugins.BuildPropertiesFileBuilder;
import org.moflon.core.plugins.manifest.ManifestFileUpdater;
import org.moflon.core.utilities.ExtensionsUtil;
import org.moflon.core.utilities.LogUtils;
import org.moflon.core.utilities.WorkspaceHelper;

public class IbexTGGNature implements IProjectNature {
	public static final String IBEX_TGG_NATURE_ID = "org.emoflon.ibex.tgg.ide.nature";
	public static final String IBEX_TGG_BUILDER_ID = "org.emoflon.ibex.tgg.ide.builder";
	public static final String XTEXT_NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature";
	public static final String PLUGIN_NATURE_ID = "org.eclipse.pde.PluginNature";
	public static final String SCHEMA_FILE = "src/org/emoflon/ibex/tgg/Schema.tgg";
//	private static final String INATURE_EXTENSON_ID = "org.emoflon.ibex.tgg.ide.IbexTGGNatureExtension";

	private IProject project;

	private static Logger logger = Logger.getLogger(IbexTGGNature.class);

//	private final Collection<NatureExtension> natureExtensions;

//	public IbexTGGNature() {
//		this.natureExtensions = ExtensionsUtil.collectExtensions(IbexTGGNature.INATURE_EXTENSON_ID, "class", NatureExtension.class);
//	}

	@Override
	public void configure() throws CoreException {
		PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
			try {
				IbexTGGNature.this.performSetUpRoutines();
				IbexTGGNature.this.addIBexTGGBuilder();
			} catch (CoreException | IOException e) {
				LogUtils.error(IbexTGGNature.logger, e);
			}
		});
	}

	private void addIBexTGGBuilder() throws CoreException {
		IProjectDescription projectDescription = this.project.getDescription();
		ICommand[] buildSpec = projectDescription.getBuildSpec();
		ICommand command = projectDescription.newCommand();
		command.setBuilderName(IbexTGGNature.IBEX_TGG_BUILDER_ID);
		Collection<ICommand> list = new ArrayList<>();
		list.add(command);
		list.addAll(Arrays.asList(buildSpec));
		projectDescription.setBuildSpec(list.toArray(new ICommand[list.size()]));
		this.project.setDescription(projectDescription, new NullProgressMonitor());
	}

	private void performSetUpRoutines() throws CoreException, IOException {
		this.setUpAsJavaProject(this.project, new NullProgressMonitor());
		this.setUpAsPluginProject();
		this.setUpAsXtextProject();
		this.setUpAsIbexProject();
//		for (NatureExtension ne : this.natureExtensions)
//			ne.setUpProject(this.project);
	}

	private void setUpAsJavaProject(final IProject project, final IProgressMonitor monitor) {
		final SubMonitor subMon = SubMonitor.convert(monitor, "Set up Java project", 1);
		final JavaCapabilityConfigurationPage jcpage = new JavaCapabilityConfigurationPage();
		final IJavaProject javaProject = JavaCore.create(project);

		PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
			jcpage.init(javaProject, null, null, true);
			try {
				jcpage.configureJavaProject(subMon.newChild(1));
			} catch (final Exception e) {
				IbexTGGNature.logger.error("Exception during setup of Java project", e);
			}
		});
	}

	private void setUpAsIbexProject() throws CoreException, IOException {
		new ManifestFileUpdater().processManifest(this.project, manifest -> {
			boolean changed = false;
			changed |= ManifestFileUpdater.updateDependencies(manifest, Arrays.asList(
					// Misc deps
					"org.apache.log4j", "com.google.guava", "org.sat4j.core", "org.sat4j.pb",

					// EMF deps
					"org.eclipse.emf.ecore.xmi",

					// Ibex deps
					"org.emoflon.ibex.common", "org.emoflon.ibex.tgg.language", "org.emoflon.ibex.tgg.runtime", "org.emoflon.ibex.tgg.ui.debug", "org.emoflon.ibex.tgg.ui.debug.adapter",

					//Xtend deps
					"org.eclipse.xtend.lib"

					));
			return changed;
		});
	}

	private void setUpAsXtextProject() throws CoreException {
		WorkspaceHelper.addNature(this.project, IbexTGGNature.XTEXT_NATURE_ID, new NullProgressMonitor());
	}

	private void setUpAsPluginProject() throws CoreException, IOException {
		WorkspaceHelper.addNature(this.project, IbexTGGNature.PLUGIN_NATURE_ID, new NullProgressMonitor());
		this.setUpBuildProperties();
		this.setUpManifestFile();
		IbexTGGNature.addContainerToBuildPath(this.project, "org.eclipse.pde.core.requiredPlugins");
	}

	/**
	 * Adds the given container to the build path of the given project if it
	 * contains no entry with the same name, yet.
	 */
	public static void addContainerToBuildPath(final IProject project, final String container) {
		IbexTGGNature.addContainerToBuildPath(JavaCore.create(project), container);
	}

	/**
	 * Adds the given container to the build path of the given java project.
	 */
	private static void addContainerToBuildPath(final IJavaProject iJavaProject, final String container) {
		try {
			// Get current entries on the classpath
			Collection<IClasspathEntry> classpathEntries = new ArrayList<>(
					Arrays.asList(iJavaProject.getRawClasspath()));

			IbexTGGNature.addContainerToBuildPath(classpathEntries, container);

			IbexTGGNature.setBuildPath(iJavaProject, classpathEntries);
		} catch (JavaModelException e) {
			LogUtils.error(IbexTGGNature.logger, e, "Unable to set classpath variable");
		}
	}

	/**
	 * Adds the given container to the list of build path entries (if not included,
	 * yet)
	 */
	private static void addContainerToBuildPath(final Collection<IClasspathEntry> classpathEntries,
			final String container) {
		IClasspathEntry entry = JavaCore.newContainerEntry(new Path(container));
		for (IClasspathEntry iClasspathEntry : classpathEntries) {
			if (iClasspathEntry.getPath().equals(entry.getPath())) {
				// No need to add variable - already on classpath
				return;
			}
		}

		classpathEntries.add(entry);
	}

	private static void setBuildPath(final IJavaProject javaProject, final Collection<IClasspathEntry> entries,
			final IProgressMonitor monitor) throws JavaModelException {
		final SubMonitor subMon = SubMonitor.convert(monitor, "Set build path", 1);
		// Create new buildpath
		IClasspathEntry[] newEntries = new IClasspathEntry[entries.size()];
		entries.toArray(newEntries);

		// Set new classpath with added entries
		javaProject.setRawClasspath(newEntries, subMon.newChild(1));
	}

	private static void setBuildPath(final IJavaProject javaProject, final Collection<IClasspathEntry> entries)
			throws JavaModelException {
		IbexTGGNature.setBuildPath(javaProject, entries, new NullProgressMonitor());
	}

	private void setUpBuildProperties() throws CoreException {
		IbexTGGNature.logger.debug("Adding build.properties");
		Properties buildProperties = new Properties();
		buildProperties.put("bin.includes", "META-INF/, bin/, model/");
		buildProperties.put("source..", "src/");
		buildProperties.put("output..", "bin/");
		new BuildPropertiesFileBuilder().createBuildProperties(this.project, new NullProgressMonitor(), buildProperties);
	}

	private void setUpManifestFile() throws CoreException, IOException {
		IbexTGGNature.logger.debug("Adding MANIFEST.MF");
		new ManifestFileUpdater().processManifest(this.project, manifest -> {
			return ManifestFileUpdater.setBasicProperties(manifest, this.project.getName());
		});
	}

	@Override
	public void deconfigure() throws CoreException {
		// Not required
	}

	@Override
	public IProject getProject() {
		return this.project;
	}

	@Override
	public void setProject(final IProject project) {
		this.project = project;
	}
}
