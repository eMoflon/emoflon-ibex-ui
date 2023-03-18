package org.emoflon.ibex.tgg.tggl.util;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.getContainer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.common.slimgt.util.XtextResourceManager;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;

public class TGGLWorkspaceUtil {

	protected static XtextResourceManager resourceManager = new XtextResourceManager();
	
	public static void clearResourceCache() {
		resourceManager.clearCache();
	}

	protected static Collection<EditorFile> getFilesInScope(EditorFile editorFile, boolean excludeOwn) {
		var rs = editorFile.eResource().getResourceSet();
		Collection<EditorFile> editorFiles = new HashSet<>();

		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(editorFile.eResource());

		String projectPath = currentProject.getLocation().toPortableString();
		List<File> tggFiles = new LinkedList<>();
		SlimGTWorkspaceUtil.gatherFilesWithEnding(tggFiles, new File(projectPath), ".tggl", true);

		for (File tggFile : tggFiles) {
			URI tggModelUri;
			try {
				String filePath = tggFile.getCanonicalPath().replaceFirst(projectPath, currentProject.getName());
				tggModelUri = URI.createPlatformResourceURI(filePath, true);
			} catch (IOException e) {
				continue;
			}

			if (excludeOwn && editorFile.eResource().getURI().equals(tggModelUri))
				continue;

			Resource resource = resourceManager.loadResource(rs, editorFile.eResource(), tggModelUri);
			if (resource == null)
				continue;

			if (resource.getContents().isEmpty())
				continue;
			
			EObject tggModel = resource.getContents().get(0);

			if (tggModel == null)
				continue;

			if (tggModel instanceof EditorFile otherEditorFile) {
				editorFiles.add(otherEditorFile);
			}
		}
		return editorFiles;
	}

	public static Collection<EditorFile> getAllFilesInScope(EObject obj) {
		EditorFile editorFile = getContainer(obj, EditorFile.class);
		return getFilesInScope(editorFile, false);
	}

	public static Collection<EditorFile> getAllOtherFilesInScope(EditorFile editorFile) {
		return getFilesInScope(editorFile, true);
	}

	public static Collection<EditorFile> getAllResolvedFilesInScope(InjectionContainer container, EObject obj) {
		return getAllResolvedFilesInScope(container, obj.eResource());
	}

	public static Collection<EditorFile> getAllResolvedFilesInScope(InjectionContainer container, Resource input) {
		var resourceSet = input.getResourceSet();

		var index = container.resourceDescriptionsProvider().createResourceDescriptions();
		var resDesc = index.getResourceDescription(input.getURI());
		var visibleContainers = container.containerManager().getVisibleContainers(resDesc, index);

		var editorFiles = new LinkedList<EditorFile>();

		for (IContainer c : visibleContainers) {
			for (IResourceDescription rd : c.getResourceDescriptions()) {
				if (rd.getURI().toString().endsWith(".tggl")) {
					var resource = resourceSet.getResource(rd.getURI(), true);
					EObject tggModel = resource.getContents().get(0);
					if (tggModel == null)
						continue;
					if (tggModel instanceof EditorFile otherEditorFile) {
						editorFiles.add(otherEditorFile);
					}
				}
			}
		}
//		EcoreUtil.resolveAll(resourceSet);
		return editorFiles;
	}

}
