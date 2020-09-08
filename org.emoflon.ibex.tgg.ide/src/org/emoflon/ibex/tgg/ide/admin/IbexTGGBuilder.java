package org.emoflon.ibex.tgg.ide.admin;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.moflon.core.utilities.ExtensionsUtil;
import org.moflon.core.utilities.MoflonUtil;
import org.moflon.core.utilities.WorkspaceHelper;
import org.moflon.tgg.mosl.TGGStandaloneSetup;

public class IbexTGGBuilder extends IncrementalProjectBuilder implements IResourceDeltaVisitor {
	public static final String INTERNAL_TGG_MODEL_EXTENSION = ".tgg.xmi";
	public static final String INTERNAL_TGG_FLATTENED_MODEL_EXTENSION = "_flattened.tgg.xmi";
	public static final String ECORE_FILE_EXTENSION = ".ecore";
	public static final String TGG_FILE_EXTENSION = ".tgg";
	public static final String EDITOR_MODEL_EXTENSION = ".editor.xmi";
	public static final String EDITOR_FLATTENED_MODEL_EXTENSION = "_flattened.editor.xmi";
	public static final String SRC_FOLDER = "src";
	public static final String MODEL_FOLDER = "model";
	public static final String RUN_FILE_PATH_PREFIX = "src/org/emoflon/ibex/tgg/run/";
	public static final String CONFIG_FILE_PATH_PREFIX = RUN_FILE_PATH_PREFIX + "config/";
	public static final Logger logger = Logger.getLogger(IbexTGGBuilder.class);
	private boolean buildIsNecessary = false;
//	private boolean failed = false;
	
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		super.clean(monitor);
		TGGStandaloneSetup.doSetup();
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		switch (kind) {
		case CLEAN_BUILD:
//			TGGStandaloneSetup.doSetup();
		case FULL_BUILD:
//			if(!generateFiles() && kind != CLEAN_BUILD) {
//				this.build(CLEAN_BUILD, args, monitor);
//			}
			fullBuild();
			break;
		 case AUTO_BUILD:
		 case INCREMENTAL_BUILD:
//			 generateFilesIfchangeIsRelevant();
			 break;
		default:
			break;
		}

		return null;
	}
	
	private void fullBuild() {
		logger.info(getProject().getName() + ": Full build");
		runBuilderExtensions();
	}
	
	/**
	 * Runs the registered GTBuilderExtensions for the package.
	 * 
	 * @param action the method to call on the builder extension
	 */
	private void runBuilderExtensions() {
		final ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(final Throwable e) {
				logger.error(e.getMessage());
			}

			@Override
			public void run() throws Exception {
				ExtensionsUtil
						.collectExtensions(TGGBuilderExtension.BUILDER_EXTENSON_ID, "class", TGGBuilderExtension.class)
						.forEach(builder -> builder.run(getProject()));
			}
		};
		SafeRunner.run(runnable);
	}


	/**
	 * Creates a new file as RUN_FILE_PATH + fileName + ".java"
	 * 
	 * @param fileName
	 *            The name of the file to be generated
	 * @param generator
	 *            A bi-function used to generate the string content of the new
	 *            file of the form: (project name, file name) -> file contents
	 * @throws CoreException
	 */
	public static void createDefaultRunFile(IProject project, String fileName, BiFunction<String, String, String> generator) throws CoreException {
		establishDefaultRunFile(project, fileName, false, generator, false);
	}

	public static void createDefaultConfigFile(IProject project, String fileName, BiFunction<String, String, String> generator) throws CoreException {
		establishDefaultConfigFile(project, fileName, generator, false);
	}

	public static void createDefaultDebugRunFile(IProject project, String fileName, BiFunction<String, String, String> generator) throws CoreException {
		establishDefaultRunFile(project, fileName, true, generator, false);
	}

	public void enforceDefaultRunFile(IProject project, String fileName, BiFunction<String, String, String> generator) throws CoreException {
		establishDefaultRunFile(project, fileName, false, generator, true);
	}

	public static void enforceDefaultConfigFile(IProject project, String fileName, BiFunction<String, String, String> generator) throws CoreException {
		establishDefaultConfigFile(project, fileName, generator, true);
	}

	public static void establishDefaultRunFile(IProject project, String fileName, boolean debug, BiFunction<String, String, String> generator, Boolean force) throws CoreException {
		createIfNotExists(project, RUN_FILE_PATH_PREFIX + MoflonUtil.lastCapitalizedSegmentOf(project.getName()).toLowerCase() + (debug ? "/debug/" : "/"), fileName, ".java", generator, force);
	}

	public static void establishDefaultConfigFile(IProject project, String fileName, BiFunction<String, String, String> generator, Boolean force) throws CoreException {
		createIfNotExists(project, RUN_FILE_PATH_PREFIX + MoflonUtil.lastCapitalizedSegmentOf(project.getName()).toLowerCase() + "/config/", fileName, ".java", generator, force);
	}

	/**
	 * Creates a new file as path + fileName + ending
	 * 
	 * @param path
	 *            The project relative path to the file
	 * @param ending
	 *            The file extension to use
	 * @param fileName
	 *            The name of the file to be generated
	 * @param generator
	 *            A bi-function used to generate the string content of the new
	 *            file of the form: (project name, file name) -> file contents
	 * @throws CoreException
	 */
	public static void createIfNotExists(IProject project, String path, String fileName, String ending, BiFunction<String, String, String> generator, Boolean force) throws CoreException {
		IPath pathToFile = new Path(path + fileName + ending);
		IFile file = project.getFile(pathToFile);

		if (force)
			file.delete(true, new NullProgressMonitor());

		if (!file.exists()) {
			String defaultContent = generator.apply(project.getName(), fileName);
			WorkspaceHelper.addAllFoldersAndFile(project, pathToFile, defaultContent, new NullProgressMonitor());
		}
	}

	private String determineNameOfGeneratedFile() {
		return MoflonUtil.lastCapitalizedSegmentOf(getProject().getName());
	}

	public static void saveModelInProject(IFile file, ResourceSet rs, EObject model) throws IOException {
		URI uri = URI.createPlatformResourceURI(file.getProject().getName()//
				+ "/" + file.getProjectRelativePath().toString(), true);
		Resource resource = rs.createResource(uri);
		resource.getContents().add(model);
		Map<Object, Object> options = ((XMLResource) resource).getDefaultSaveOptions();
		options.put(XMIResource.OPTION_SAVE_ONLY_IF_CHANGED, XMIResource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl() {
			@Override
			public URI deresolve(URI uri) {
				return uri;
			}
		});
		resource.save(options);
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		if (buildIsNecessary)
			return false;

		if (isTggFileToBeCompiled(delta)) {
			buildIsNecessary = true;
			return false;
		}

		return true;
	}

	private boolean isTggFileToBeCompiled(IResourceDelta delta) {
		return delta.getResource().getName().endsWith(TGG_FILE_EXTENSION) && !delta.getResource().getProjectRelativePath().toString().startsWith("bin/");
	}

}
