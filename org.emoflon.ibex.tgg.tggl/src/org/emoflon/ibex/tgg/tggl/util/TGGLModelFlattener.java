package org.emoflon.ibex.tgg.tggl.util;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.getElements;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLFactory;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.impl.TGGLFactoryImpl;

public class TGGLModelFlattener {

	private Map<EObject, EObject> original2flattenedCopy = new HashMap<>();
	private Logger logger = Logger.getLogger(TGGLModelFlattener.class);
	private TGGLFactory tggFactory = TGGLFactoryImpl.eINSTANCE;
	
	public EditorFile flatten(ResourceDescriptionsProvider resourceDescriptionsProvider, IContainer.Manager manager, Resource input) {
		var workspaceUtil = new TGGLWorkspaceUtil();
		var container = new InjectionContainer(resourceDescriptionsProvider, manager);
		var files = workspaceUtil.getAllResolvedFilesInScope(container, input);
		
		var mainFile = collectInformation(files);
		flatten(mainFile);
		
		
		return mainFile;
	}
	
	
	private void flatten(EditorFile mainFile) {
		for(var tggRule : mainFile.getRules()) {
			var ruleHierarchy = new HierarchyManager<>(tggRule, rule -> rule.getRefinements().stream().map(r -> r.getSuperRule()).toList());
			for(var nextRule : ruleHierarchy.getHierarchyElements()) {
				flattenTGGRule(tggRule);
			}
		}
			
	}


	private void flattenTGGRule(TGGRule tggRule) {

		for(var refinement : tggRule.getRefinements()) {
			var superRule = refinement.getSuperRule();
			
		}
		
		// clean up refinements because we no longer need them
		tggRule.getRefinements().clear();
	}


	private void replaceSlimNode(SlimRuleNode oldNode, SlimRuleNode newNode) {
		
	}
	
	private EditorFile collectInformation(Collection<EditorFile> files) {
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
