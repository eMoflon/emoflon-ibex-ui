package org.emoflon.ibex.tgg.ide.admin;

import static org.moflon.util.WorkspaceHelper.addAllFoldersAndFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.emoflon.ibex.tgg.ide.transformation.EditorTGGtoFlattenedTGG;
import org.moflon.tgg.mosl.defaults.AttrCondDefLibraryProvider;
import org.moflon.tgg.mosl.tgg.AttrCond;
import org.moflon.tgg.mosl.tgg.AttrCondDef;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;
import org.moflon.util.IbexUtil;
import org.moflon.util.LogUtils;

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
	private static final String IBUILDER_EXTENSON_ID = "org.emoflon.ibex.tgg.ide.IbexTGGBuilderExtension";
	public static final Logger logger = Logger.getLogger(IbexTGGBuilder.class);
	private boolean buildIsNecessary = false;
	
	private Collection<BuilderExtension> builderExtensions;
	
	// Blackboard for computed results and sharing data between builder extensions
	private Map<String, Object> blackboard;

	public IbexTGGBuilder() {
		builderExtensions = IbexUtil.collectExtensions(IBUILDER_EXTENSON_ID, "class", BuilderExtension.class);
	}
	
	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		blackboard = new HashMap<>();
		
		switch (kind) {
		case CLEAN_BUILD:
		case FULL_BUILD:
		case AUTO_BUILD:
		case INCREMENTAL_BUILD:
			generateFilesIfchangeIsRelevant();
			break;
		default:
			break;
		}

		return null;
	}

	private void generateFilesIfchangeIsRelevant() throws CoreException {
		IResourceDelta delta = getDelta(getProject());
		
		if(delta != null)
			delta.accept(this);
		
		if(buildIsNecessary)
			generateFiles();
		
		buildIsNecessary = false;		
	}

	private void generateFiles() {
		performClean();
		generateAttrCondLib();
		generateEditorModel()
			.ifPresent(editorModel -> 
				generateFlattenedEditorModel(editorModel)
					.ifPresent(flattenedEditorModel -> 
						generateExtraModels(this, editorModel, flattenedEditorModel)
					)
			);
	}
	
	private Optional<TripleGraphGrammarFile> generateFlattenedEditorModel(TripleGraphGrammarFile editorModel) {
		EditorTGGtoFlattenedTGG flattener = new EditorTGGtoFlattenedTGG();
		TripleGraphGrammarFile flattenedTGG = flattener.flatten(editorModel);

		try {
			ResourceSet rs = editorModel.eResource().getResourceSet();
			IFile tggFile = getProject().getFolder(IbexTGGBuilder.MODEL_FOLDER).getFile(getProject().getName() + EDITOR_FLATTENED_MODEL_EXTENSION);
			saveModelInProject(tggFile, rs, flattenedTGG);
			return Optional.of(flattenedTGG);
		} catch (IOException e) {
			LogUtils.error(logger, e);
		}
		
		return Optional.empty();
	}

	/**
	 * Creates a new file as RUN_FILE_PATH + fileName + ".java"
	 * 
	 * @param fileName
	 *            The name of the file to be generated
	 * @param generator
	 *            A bi-function used to generate the string content of the new file of the form: (project name, file name) -> file
	 *            contents
	 * @throws CoreException
	 */
	public void createDefaultRunFile(String fileName, BiFunction<String, String, String> generator) throws CoreException {
		createIfNotExists(RUN_FILE_PATH_PREFIX+getProject().getName().toLowerCase()+"/", fileName, ".java", generator);
	}

	/**
	 * Creates a new file as path + fileName + ending
	 * 
	 * @param path
	 * 			The project relative path to the file
	 * @param ending
	 * 			The file extension to use
	 * @param fileName
	 *            The name of the file to be generated
	 * @param generator
	 *            A bi-function used to generate the string content of the new file of the form: (project name, file name) -> file
	 *            contents
	 * @throws CoreException
	 */
	public void createIfNotExists(String path, String fileName, String ending, BiFunction<String, String, String> generator) throws CoreException {
		IPath pathToFile = new Path(path + fileName + ending);
		IFile file = getProject().getFile(pathToFile);
		if (!file.exists()){ 
			String defaultContent = generator.apply(getProject().getName(), fileName);
			addAllFoldersAndFile(getProject(), pathToFile, defaultContent, new NullProgressMonitor());
		}
	}
	
	private void generateAttrCondLib() {
		try {
			AttrCondDefLibraryProvider.syncAttrCondDefLibrary(getProject());
		} catch (CoreException | IOException e) {
			LogUtils.error(logger, e);
		}
	}

	private Optional<TripleGraphGrammarFile> generateEditorModel() {
		try {
			XtextResourceSet resourceSet = new XtextResourceSet();
			IFile schemaFile = getProject().getFile(IbexTGGNature.SCHEMA_FILE);
			if (schemaFile.exists()) {
				XtextResource schemaResource = loadSchema(resourceSet, schemaFile);
				if (schemaIsOfExpectedType(schemaResource)) {
					// Load
					loadAllRules(resourceSet, getProject().getFolder(SRC_FOLDER));
					EcoreUtil2.resolveLazyCrossReferences(schemaResource, () -> false); 
					resourceSet.getResources().forEach(r -> EcoreUtil2.resolveLazyCrossReferences(r, () -> false));
					EcoreUtil.resolveAll(resourceSet);
					
					// Combine to form single tgg model
					TripleGraphGrammarFile xtextParsedTGG = (TripleGraphGrammarFile) schemaResource.getContents().get(0);
					collectAllRules(xtextParsedTGG, resourceSet);
					addAttrCondDefLibraryReferencesToSchema(xtextParsedTGG);
					
					// Persist and return
					IFile editorFile = getProject().getFolder(IbexTGGBuilder.MODEL_FOLDER).getFile(getProject().getName() + EDITOR_MODEL_EXTENSION);
					saveModelInProject(editorFile, resourceSet, xtextParsedTGG);
					return Optional.of(xtextParsedTGG);
				}
			}
		} catch (CoreException | IOException e) {
			LogUtils.error(logger, e);
		}

		return Optional.empty();
	}

	private void collectAllRules(TripleGraphGrammarFile xtextParsedTGG, XtextResourceSet resourceSet) {
		Collection<Resource> resources = resourceSet.getResources();
		for (Resource resource : resources) {
			assert(resource.getContents().size() == 1);
			if (!resource.getContents().isEmpty()) {
				EObject root = resource.getContents().get(0);
				if (root instanceof TripleGraphGrammarFile) {
					TripleGraphGrammarFile f = (TripleGraphGrammarFile) root;
					xtextParsedTGG.getRules().addAll(f.getRules());
					xtextParsedTGG.getNacs().addAll(f.getNacs());
					xtextParsedTGG.getComplementRules().addAll(f.getComplementRules());
				}
			}
		}
	}

	private void addAttrCondDefLibraryReferencesToSchema(TripleGraphGrammarFile xtextParsedTGG) {
		EList<AttrCondDef> usedAttrCondDefs = new BasicEList<AttrCondDef>();
		for (Rule rule : xtextParsedTGG.getRules()) {
			for (AttrCond attrCond : rule.getAttrConditions()) {
				if (!usedAttrCondDefs.contains(attrCond.getName()) && !attrCond.getName().isUserDefined()) {
					usedAttrCondDefs.add(attrCond.getName());
				}
			}
		}
		xtextParsedTGG.getSchema().getAttributeCondDefs().addAll(usedAttrCondDefs);
	}

	private void loadAllRules(XtextResourceSet resourceSet, IFolder root) throws CoreException, IOException {
		for (IResource iResource : root.members()) {
			if (iResource instanceof IFile) {
				loadRules(iResource, resourceSet);
			} else if (iResource instanceof IFolder) {
				loadAllRules(resourceSet, IFolder.class.cast(iResource));
			}
		}
	}

	private void loadRules(IResource iResource, XtextResourceSet resourceSet) throws IOException {
		IFile ruleFile = (IFile) iResource;
		if (ruleFile.getName().endsWith(TGG_FILE_EXTENSION)) {
			resourceSet.getResource(URI.createPlatformResourceURI(ruleFile.getFullPath().toString(), true), true);	
		}
	}

	private boolean schemaIsOfExpectedType(XtextResource schemaResource) {
		return schemaResource.getContents().size() == 1
				&& schemaResource.getContents().get(0) instanceof TripleGraphGrammarFile;
	}

	private XtextResource loadSchema(XtextResourceSet resourceSet, IFile schemaFile) throws IOException {
		XtextResource schemaResource = (XtextResource) resourceSet
				.createResource(URI.createPlatformResourceURI(schemaFile.getFullPath().toString(), false));
		schemaResource.load(null);
		EcoreUtil.resolveAll(resourceSet);
		return schemaResource;
	}
	
	private void generateExtraModels(IbexTGGBuilder builder, TripleGraphGrammarFile editorModel, TripleGraphGrammarFile flattenedEditorModel) {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				LogUtils.error(logger, e);
			}

			@Override
			public void run() throws Exception {
				builderExtensions.forEach(builderExt -> builderExt.run(builder, editorModel, flattenedEditorModel));
			}
		};
		SafeRunner.run(runnable);
	}

	public static void saveModelInProject(IFile file, ResourceSet rs, EObject model) throws IOException {
		URI uri = URI.createPlatformResourceURI(file.getProject().getName() + "/" + file.getProjectRelativePath().toString(), true);
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
		if(buildIsNecessary)
			return false;
		
		if (isTggFileToBeCompiled(delta)) {
			buildIsNecessary = true;
			return false;
		}
		
		return true;
	}
	
	private boolean isTggFileToBeCompiled(IResourceDelta delta) {
		return delta.getResource().getName().endsWith(TGG_FILE_EXTENSION)
				&& !delta.getResource().getProjectRelativePath().toString().startsWith("bin/");
	}

	private void performClean() {
		List<String> toDelete = Arrays.asList(
				MODEL_FOLDER + "/" + getProject().getName() + ECORE_FILE_EXTENSION,
				MODEL_FOLDER + "/" + getProject().getName() + EDITOR_MODEL_EXTENSION,
				MODEL_FOLDER + "/" + getProject().getName() + INTERNAL_TGG_MODEL_EXTENSION,
				MODEL_FOLDER + "/" + getProject().getName() + EDITOR_FLATTENED_MODEL_EXTENSION,
				MODEL_FOLDER + "/" + getProject().getName() + INTERNAL_TGG_FLATTENED_MODEL_EXTENSION
			);
		toDelete.stream().map(f -> getProject().getFile(f)).filter(IFile::exists).forEach(f -> {
			try {
				f.delete(true, new NullProgressMonitor());
			} catch (CoreException e) {
				LogUtils.error(logger, e);
			}
		});
		
		builderExtensions.forEach(be -> be.performClean(this));
	}
	
	@SuppressWarnings("unchecked")
	public <T> T computeOrGetFromBlackboard(String key, Supplier<T> computation){
		if(!blackboard.containsKey(key))
			blackboard.put(key, computation.get());
		
		return (T) blackboard.get(key);
	}
}
