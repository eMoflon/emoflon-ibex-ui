package org.emoflon.ibex.tgg.tggl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLFactory;
import org.emoflon.ibex.tgg.tggl.tGGL.impl.TGGLFactoryImpl;

public class TGGLModelFlattener {

	private Map<EObject, EObject> original2flattenedCopy = new HashMap<>();
	private Logger logger = Logger.getLogger(TGGLModelFlattener.class);
	private TGGLFactory tggFactory = TGGLFactoryImpl.eINSTANCE;

	public EditorFile flatten(Resource input) {
		var workspaceUtil = new TGGLWorkspaceUtil();
		var files = workspaceUtil.getAllResolvedFilesInScope(input);
		return flatten(files);
	}
	
	public EditorFile flatten(Collection<EditorFile> files) {
		var mainFile = tggFactory.createEditorFile();
		
		var copies = EcoreUtil.copyAll(files);
		XtextResource r = new XtextResource();
		r.getContents().addAll(copies);
		
		EcoreUtil.resolveAll(r);
		
		for(var file : files) {
			if(file.getSchema() != null)
				mainFile.setSchema(file.getSchema());
			
			mainFile.getImports().addAll(file.getImports());
			mainFile.getLibraries().addAll(file.getLibraries());
			mainFile.getPatterns().addAll(file.getPatterns());
			mainFile.getRules().addAll(file.getRules());
		}
		
		return mainFile;
	}
	
}
