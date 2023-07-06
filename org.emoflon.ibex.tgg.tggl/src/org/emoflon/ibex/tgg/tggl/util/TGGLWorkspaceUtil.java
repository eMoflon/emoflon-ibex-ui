package org.emoflon.ibex.tgg.tggl.util;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.getContainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
				String filePath = tggFile.getCanonicalPath().
						replaceAll("\\\\", "/"). // windows hack
						replaceFirst(projectPath, currentProject.getName());
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
		var editorFiles = new LinkedList<EditorFile>();

		var resourceSet = input.getResourceSet();

		var index = container.resourceDescriptionsProvider().createResourceDescriptions();
		var resDesc = index.getResourceDescription(input.getURI());
		if(resDesc == null) {
			var files = new LinkedList<File>();
			var project = SlimGTWorkspaceUtil.getCurrentProject(input);
			var projectFolder = new File(project.getLocation().toPortableString());
			SlimGTWorkspaceUtil.gatherFilesWithEnding(files, projectFolder, ".tggl", true);
			
			for(var file : files) {
				var platformUri = toPlatformURI(project, file.getAbsolutePath());
				var resource = resourceSet.getResource(platformUri, true);
				EObject tggModel = resource.getContents().get(0);
				if (tggModel == null)
					continue;
				if (tggModel instanceof EditorFile otherEditorFile) {
					editorFiles.add(otherEditorFile);
				}
			}
		}
		else {
			
			var cont = container.containerManager().getContainer(resDesc, index);
			
			var descriptions = cont.getResourceDescriptions();
			for (IResourceDescription rd : descriptions) {
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
//		}
		}
		
//		EcoreUtil.resolveAll(resourceSet);
		return editorFiles;
	}

	public static URI toPlatformURI(IProject project, String path) {
		String projectRelativePath = Path.of(project.getLocation().toPortableString()).relativize(Path.of(path))
				.toFile().getPath();
		URI uri = URI.createPlatformResourceURI(project.getName() + "/" + projectRelativePath, false);
		return uri;
	}
}
