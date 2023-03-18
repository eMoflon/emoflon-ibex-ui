package org.emoflon.ibex.tgg.tggl.util;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.getElements;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.NodeExpression;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRule;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNode;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGDomainRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLFactory;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.tGGL.impl.TGGLFactoryImpl;

public class TGGLModelFlattener {

	private Logger logger = Logger.getLogger(TGGLModelFlattener.class);
	private TGGLFactory tggFactory = TGGLFactoryImpl.eINSTANCE;
	private Collection<EObject> flattenedObjects = new HashSet<>();
	
	/**
	 * Resolves all refinements by creating copies and repairing all references
	 * 
	 * @param resourceDescriptionsProvider
	 * @param manager
	 * @param input
	 * @return
	 */
	public EditorFile flatten(ResourceDescriptionsProvider resourceDescriptionsProvider, IContainer.Manager manager, Resource input) {
		var workspaceUtil = new TGGLWorkspaceUtil();
		var container = new InjectionContainer(resourceDescriptionsProvider, manager);
		var files = workspaceUtil.getAllResolvedFilesInScope(container, input);
		
		var mainFile = collectInformation(files);
		flatten(mainFile);
		return mainFile;
	}
	
	
	private void flatten(EditorFile mainFile) {
		for(var pattern : mainFile.getPatterns()) {
			var patternHierarchy = new HierarchyManager<>(pattern, p -> p.getRefinements().stream().map(r -> (SlimRule) r.getSuperRule()).toList());
			for(var nextPattern : patternHierarchy.getHierarchyElements()) {
				flattenPattern(nextPattern);
			}
		}
		
		for(var tggRule : mainFile.getRules()) {
			var ruleHierarchy = new HierarchyManager<>(tggRule, rule -> rule.getRefinements().stream().map(r -> r.getSuperRule()).toList());
			for(var nextRule : ruleHierarchy.getHierarchyElements()) {
				flattenTGGRule(nextRule);
			}
		}
			
	}


	private void flatten(TGGDomainRule domainRule, TGGDomainRule superDomainRule, Collection<EObject> refinedTargets) {
		// only create elements that were not refined already
		for(var contextNode : superDomainRule.getContextNodes()) {
			if(refinedTargets.contains(contextNode.getContext()))
				continue;
			
			var copy = EcoreUtil.copy(contextNode);
			domainRule.getContextNodes().add(copy);
		}
		
		for(var createdNode : superDomainRule.getCreatedNodes()) {
			if(refinedTargets.contains(createdNode.getCreation()))
				continue;
			
			var copy = EcoreUtil.copy(createdNode);
			domainRule.getCreatedNodes().add(copy);
		}
	}


	private void flatten(TGGCorrRule domainRule, TGGCorrRule superDomainRule, Collection<EObject> refinedTargets) {
		for(var contextNode : superDomainRule.getContextCorrespondenceNodes()) {
			if(refinedTargets.contains(contextNode.getContext()))
				continue;
			
			var copy = EcoreUtil.copy(contextNode);
			domainRule.getContextCorrespondenceNodes().add(copy);
		}
		
		for(var createdNode : superDomainRule.getCreatedCorrespondenceNodes()) {
			if(refinedTargets.contains(createdNode.getCreation()))
				continue;
			
			var copy = EcoreUtil.copy(createdNode);
			domainRule.getCreatedCorrespondenceNodes().add(copy);
		}
		
		for(var contextNode : getElements(domainRule, TGGCorrespondenceNodeContext.class)) {
			contextNode.setRefinement(null);
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(domainRule, TGGCorrespondenceNodeCreation.class)) {
			createdNode.setRefinement(null);
			createdNode.setRefining(false);
		}
	}


	private void flatten(SlimRule pattern, SlimRule superPattern, Collection<EObject> refinedTargets) {		
		// only create elements that were not refined already
		for(var contextNode : superPattern.getContextNodes()) {
			if(refinedTargets.contains(contextNode.getContext()))
				continue;
			
			var copy = EcoreUtil.copy(contextNode);
			pattern.getContextNodes().add(copy);
		}
		
		for(var createdNode : superPattern.getCreatedNodes()) {
			if(refinedTargets.contains(createdNode.getCreation()))
				continue;
			
			var copy = EcoreUtil.copy(createdNode);
			pattern.getCreatedNodes().add(copy);
		}
		
		for(var contextNode : getElements(pattern, SlimRuleNodeContext.class)) {
			contextNode.setRefinement(null);
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(pattern, SlimRuleNodeCreation.class)) {
			createdNode.setRefinement(null);
			createdNode.setRefining(false);
		}
	}


	private void flattenPattern(SlimRule pattern) {
		if(flattenedObjects.contains(pattern))
			return;
		
		Collection<EObject> refinedTargets = getElements(pattern, TGGRuleRefinementNode.class).stream().map(r -> r.getNode()).collect(Collectors.toSet());
		for(var refinement : pattern.getRefinements()) {
			var superPattern = refinement.getSuperRule();
			
			flatten(pattern, (SlimRule) superPattern, refinedTargets);
		}
		
		// now we have some nodes which are not connected to elements of our current rule, so we fix them
		repairEdges(pattern);
		repairNodeExpressions(pattern);
		repairInvocationMappings(pattern);
		removeRefinements(pattern);
	}


	private void flattenTGGRule(TGGRule tggRule) {
		if(flattenedObjects.contains(tggRule))
			return;

		createMissingDefaultElements(tggRule);
		
		Collection<EObject> refinedTargets = new HashSet<>();
		// collect source and target nodes
		refinedTargets.addAll(getElements(tggRule, TGGRuleRefinementNode.class).stream().map(r -> r.getNode()).toList());
		
		// collect correspondence nodes
		refinedTargets.addAll(tggRule.getCorrRule().getContextCorrespondenceNodes().stream().filter(n -> n.getRefinement() != null).map(n -> n.getRefinement().getNode()).toList());
		refinedTargets.addAll(tggRule.getCorrRule().getCreatedCorrespondenceNodes().stream().filter(n -> n.getRefinement() != null).map(n -> n.getRefinement().getNode()).toList());
		
		for(var refinement : tggRule.getRefinements()) {
			var superRule = refinement.getSuperRule();
			
			flatten(tggRule.getSourceRule(), superRule.getSourceRule(), refinedTargets);
			flatten(tggRule.getTargetRule(), superRule.getTargetRule(), refinedTargets);
			flatten(tggRule.getCorrRule(), superRule.getCorrRule(), refinedTargets);
		}
		
		// now we have some nodes which are not connected to elements of our current rule, so we fix them
		repairEdges(tggRule);
		repairCorrepondencesNodes(tggRule);
		repairNodeExpressions(tggRule);
		repairInvocationMappings(tggRule);
		removeRefinements(tggRule);
		
		// clean up refinements because we no longer need them
		tggRule.getRefinements().clear();
		
		flattenedObjects.add(tggRule);
	}


	private void removeRefinements(EObject root) {
		for(var contextNode : getElements(root, SlimRuleNodeContext.class)) {
			contextNode.setRefinement(null);
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(root, SlimRuleNodeCreation.class)) {
			createdNode.setRefinement(null);
			createdNode.setRefining(false);
		}
	}
	
	private void createMissingDefaultElements(TGGRule tggRule) {
		if(tggRule.getSourceRule() == null)
			tggRule.setSourceRule(TGGLFactory.eINSTANCE.createTGGDomainRule());
		if(tggRule.getCorrRule() == null)
			tggRule.setCorrRule(TGGLFactory.eINSTANCE.createTGGCorrRule());
		if(tggRule.getTargetRule() == null)
			tggRule.setTargetRule(TGGLFactory.eINSTANCE.createTGGDomainRule());
	}


	private void repairInvocationMappings(EObject root) {
		var invocations = getElements(root, SlimRuleInvocation.class);
		for(var invocation : invocations) {
			var supportPattern = invocation.getSupportPattern();
			var mappings = invocation.getMappings();
			
			for(var mapping : mappings.getMappings()) {
				var source = mapping.getSource();
				var target = mapping.getTarget();

				mapping.setSource(getSlimNode(root, (SlimRuleNode) source));
				mapping.setSource(getSlimNode(supportPattern, (SlimRuleNode) target));
			}
		}
	}


	private void repairNodeExpressions(EObject root) {
		var nodeExpressions = getElements(root, NodeExpression.class);
		for(var expr : nodeExpressions) {
			var oldNode = expr.getNode();
			expr.setNode(getSlimNode(root, (SlimRuleNode) oldNode));
		}
	}


	private void repairCorrepondencesNodes(TGGRule tggRule) {
		var nodes = getElements(tggRule, TGGCorrespondenceNode.class);
		for(var node : nodes) {
			var source = node.getSource();
			node.setSource(getSlimNode(tggRule, source));
			
			var target = node.getTarget();
			node.setTarget(getSlimNode(tggRule, target));
		}
	}

	private void repairEdges(EObject root) {
		var edges = getElements(root, SlimRuleEdge.class);
		
		for(var edge : edges) {
			var oldTarget = edge.getTarget();
			edge.setTarget(getSlimNode(root, (SlimRuleNode) oldTarget));
		}
	}
	
	private SlimRuleNode getSlimNode(EObject root, SlimRuleNode oldNode) {
		var nodes = getElements(root, SlimRuleNode.class);
		
		// first we try to figure out if there is a refinement 
		for(var node : nodes) {
			var container = node.eContainer();
			if(container instanceof SlimRuleNodeContext context) {
				if(context.getRefinement() != null && context.getRefinement().getNode().getName().equals(oldNode.getName())) {
					return context.getRefinement().getNode();
				}
			}
			if(container instanceof SlimRuleNodeCreation creation) {
				if(creation.getRefinement() != null  && creation.getRefinement().getNode().getName().equals(oldNode.getName())) {
					return creation.getRefinement().getNode();
				}
			}
		}
		
		// if this was not the case, we can just take the name an
		for(var node : nodes) {
			if(node.getName().equals(oldNode.getName()))
				return node;
		}
		
		return null;
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
