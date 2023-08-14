package org.emoflon.ibex.tgg.tggl.util;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.getElements;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.tGGL.impl.TGGLFactoryImpl;
import org.moflon.core.utilities.eMoflonEMFUtil;


public class TGGLModelFlattener {

	private Logger logger = Logger.getLogger(TGGLModelFlattener.class);
	private TGGLFactory tggFactory = TGGLFactoryImpl.eINSTANCE;
	private Collection<EObject> flattenedObjects = new HashSet<>();
	private Map<EObject, RefinementMapping> container2refinementMapping = new HashMap<>();
	
	private Map<EObject, EObject> copyOf = new HashMap<>();
	
	private Map<EObject, EObject> copied2originalFileContents;
	private Map<EObject, EObject> original2copiedFileContents;
	
	/**
	 * Resolves all refinements by creating copies and repairing all references
	 * 
	 * @param resourceDescriptionsProvider
	 * @param manager
	 * @param input
	 * @return
	 */
	public EditorFile flatten(ResourceDescriptionsProvider resourceDescriptionsProvider, IContainer.Manager manager, Resource input) {
		var container = new InjectionContainer(resourceDescriptionsProvider, manager);
		var files = TGGLWorkspaceUtil.getAllResolvedFilesInScope(container, input);
		
		var mainFile = collectInformation(files);
		flatten(mainFile);
		return mainFile;
	}
	
	/**
	 * Collect all project files based on the given eObject.
	 * Then, resolves all refinements by creating copies and repairing all references
	 * 
	 * @param eObject
	 * @return the flattened copy of eObject
	 */
	@SuppressWarnings("unchecked")
	public <T extends EObject> T flatten(T eObject) {
		Collection<EditorFile> files = TGGLWorkspaceUtil.getAllFilesInScope(eObject);
		
		var mainFile = collectInformation(files);
		flatten(mainFile);
		EObject flattenedObject = original2copiedFileContents.get(eObject);
		return (T) flattenedObject;
	}
	
	public EObject getOriginalEObject(EObject eObjectOfFlattenedModel) {
		return copied2originalFileContents.get(eObjectOfFlattenedModel);
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

	private void addEdgesFromRefinement(org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode node, org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode superNode) {
		for(var edge : superNode.getContextEdges()) {
			var edgeCopy = EcoreUtil.copy(edge);
			node.getContextEdges().add(edgeCopy);
		}
		
		for(var edge : superNode.getCreatedEdges()) {
			var edgeCopy = EcoreUtil.copy(edge);
			node.getCreatedEdges().add(edgeCopy);
		}
	}

	private void flatten(TGGDomainRule domainRule, TGGDomainRule superDomainRule, Collection<EObject> refinedTargets) {
		var refinementMapping = container2refinementMapping.get(domainRule.eContainer());

		// first flatten refined created nodes because these can contain assignments
		for(var createdNode : domainRule.getCreatedNodes()) {
			flattenNodeCreationRefinement(createdNode);
		}
		
		// only create elements that were not refined already
		for(var contextNode : superDomainRule.getContextNodes()) {
			var context = contextNode.getContext();
			if(isInRefinedTargets(refinedTargets, context)) {
				addEdgesFromRefinement((org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode) refinementMapping.refined2refining().get(getCopyOrigin(context)), context);
				continue;
			}
			
			
			var copy = EcoreUtil.copy(contextNode);
			domainRule.getContextNodes().add(copy);
			copyOf.put(copy.getContext(), contextNode.getContext());
			refinementMapping.refined2refining().put(context, copy.getContext());
		}
		
		for(var createdNode : superDomainRule.getCreatedNodes()) {
			var created = createdNode.getCreation();
			if(isInRefinedTargets(refinedTargets, created)) {
				addEdgesFromRefinement((org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode) refinementMapping.refined2refining().get(getCopyOrigin(created)), created);
				continue;
			}
			
			var copy = EcoreUtil.copy(createdNode);
			domainRule.getCreatedNodes().add(copy);
			copyOf.put(copy.getCreation(), createdNode.getCreation());
			refinementMapping.refined2refining().put(created, copy.getCreation());
		}
		
		// copy conditions from super rule to this rule
		for(var superCondition : superDomainRule.getConditions()) {
			var copy = EcoreUtil.copy(superCondition);
			domainRule.getConditions().add(copy);
		}
	}
	
	private void flatten(TGGCorrRule domainRule, TGGCorrRule superDomainRule, Collection<EObject> refinedTargets) {
		var refinementMapping = container2refinementMapping.get(domainRule.eContainer());

		for(var contextNode : superDomainRule.getContextCorrespondenceNodes()) {
			if(isInRefinedTargets(refinedTargets, contextNode.getContext()))
				continue;
			
			var copy = EcoreUtil.copy(contextNode);
			domainRule.getContextCorrespondenceNodes().add(copy);
			copyOf.put(copy.getContext(), contextNode.getContext());
			refinementMapping.refined2refining().put(contextNode, copy);
		}
		
		for(var createdNode : superDomainRule.getCreatedCorrespondenceNodes()) {
			if(isInRefinedTargets(refinedTargets, createdNode.getCreation()))
				continue;
			
			var copy = EcoreUtil.copy(createdNode);
			domainRule.getCreatedCorrespondenceNodes().add(copy);
			copyOf.put(copy.getCreation(), createdNode.getCreation());
			refinementMapping.refined2refining().put(createdNode, copy);
		}
		
		for(var contextNode : getElements(domainRule, TGGCorrespondenceNodeContext.class)) {
			var corrNode = contextNode.getContext();
			if(corrNode.getSource() == null) {
				corrNode.setSource(contextNode.getRefinement().get(0).getNode().getSource());
			}
			if(corrNode.getTarget() == null) {
				corrNode.setTarget(contextNode.getRefinement().get(0).getNode().getTarget());
			}
			
			contextNode.getRefinement().clear();
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(domainRule, TGGCorrespondenceNodeCreation.class)) {
			var corrNode = createdNode.getCreation();
			if(corrNode.getSource() == null) {
				corrNode.setSource(createdNode.getRefinement().get(0).getNode().getSource());
			}
			if(corrNode.getTarget() == null) {
				corrNode.setTarget(createdNode.getRefinement().get(0).getNode().getTarget());
			}
			
			createdNode.getRefinement().clear();
			createdNode.setRefining(false);
		}
	}


	private void flatten(SlimRule pattern, SlimRule superPattern, Collection<EObject> refinedTargets) {	
		var refinementMapping = container2refinementMapping.get(pattern);
		
		// only create elements that were not refined already
		for(var contextNode : superPattern.getContextNodes()) {
			if(refinedTargets.contains(contextNode.getContext()))
				continue;
			
			var copy = EcoreUtil.copy(contextNode);
			pattern.getContextNodes().add(copy);
			refinementMapping.refined2refining().put(contextNode, copy);
		}
		
		for(var createdNode : superPattern.getCreatedNodes()) {
			if(refinedTargets.contains(createdNode.getCreation()))
				continue;
			
			var copy = EcoreUtil.copy(createdNode);
			pattern.getCreatedNodes().add(copy);
			refinementMapping.refined2refining().put(createdNode, copy);
		}
		
		// remove refinements
		for(var contextNode : getElements(pattern, SlimRuleNodeContext.class)) {
			contextNode.getRefinement().clear();
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(pattern, SlimRuleNodeCreation.class)) {
			createdNode.getRefinement().clear();
			createdNode.setRefining(false);
		}
	}

	private void flattenPattern(SlimRule pattern) {
		if(flattenedObjects.contains(pattern))
			return;
		
		var refinementMapping = new RefinementMapping(new HashMap<>());
		container2refinementMapping.put(pattern, refinementMapping);
		
		// register refinements to ease flattening and repairs 
		Collection<EObject> refinedTargets = new HashSet<>();
		for(var refinement : getElements(pattern, TGGRuleRefinementNode.class)) {
			// get the node that refines this element by getting the container which has to contain exactly one
			var refinementContainer = refinement.eContainer();
			var node = getElements(refinementContainer, SlimRuleNode.class).iterator().next();
			refinedTargets.add(refinement.getNode());
			refinementMapping.refined2refining().put(refinement.getNode(), node);
		}

		// copy information from refined pattern
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
		
		var refinementMapping = new RefinementMapping(new HashMap<>());
		container2refinementMapping.put(tggRule, refinementMapping);
		
		createMissingDefaultElements(tggRule);
		
		// register refinements to ease flattening and repairs 
		Map<String, Collection<EObject>> ruleName2refinedTargets = new HashMap<>();
		for(var refinement : getElements(tggRule, TGGRuleRefinementNode.class)) {
			// get the node that refines this element by getting the container which has to contain exactly one
			var refinementContainer = refinement.eContainer();
			
			// since the copied refinement does not contain eAdapters, we retrieve the original one here
			EObject originalRefinement = this.copied2originalFileContents.get(refinement);
			
			// we have to figure out which rule's node is refined exactly
			var refinementNode = NodeModelUtils.getNode(originalRefinement);
			var refinementTokenText = resolveRefinedRuleName(tggRule, NodeModelUtils.getTokenText(refinementNode));
			var refinedTargets = ruleName2refinedTargets.computeIfAbsent(refinementTokenText, k -> new HashSet<EObject>());
			
			var node = getElements(refinementContainer, SlimRuleNode.class).iterator().next();
			refinedTargets.add(refinement.getNode());
			refinementMapping.refined2refining().put(refinement.getNode(), node);
		}
		
		for(var refinement : getElements(tggRule, TGGLRuleRefinementCorrespondenceNode.class)) {
			// get the node that refines this element by getting the container which has to contain exactly one
			var refinementContainer = refinement.eContainer();
			
			// since the copied refinement does not contain eAdapters, we retrieve the original one here
			EObject originalRefinement = this.copied2originalFileContents.get(refinement);
			
			// we have to figure out which rule's node is refined exactly
			var refinementNode = NodeModelUtils.getNode(originalRefinement);
			var refinementTokenText = resolveRefinedRuleName(tggRule, NodeModelUtils.getTokenText(refinementNode));
			var refinedTargets = ruleName2refinedTargets.computeIfAbsent(refinementTokenText, k -> new HashSet<EObject>());
			
			var node = getElements(refinementContainer, TGGCorrespondenceNode.class).iterator().next();
			refinedTargets.add(refinement.getNode());
			refinementMapping.refined2refining().put(refinement.getNode(), node);
		}
		
		for(var refinement : tggRule.getRefinements()) {
			var superRule = refinement.getSuperRule();
			
			flatten(tggRule.getSourceRule(), superRule.getSourceRule(), ruleName2refinedTargets.computeIfAbsent(superRule.getName(), k -> new HashSet<EObject>()));
			flatten(tggRule.getTargetRule(), superRule.getTargetRule(), ruleName2refinedTargets.computeIfAbsent(superRule.getName(), k -> new HashSet<EObject>()));
			flatten(tggRule.getCorrRule(), superRule.getCorrRule(), ruleName2refinedTargets.computeIfAbsent(superRule.getName(), k -> new HashSet<EObject>()));

			tggRule.getAttrConditions().addAll(EcoreUtil.copyAll(superRule.getAttrConditions()));
		}
		
		
		// now we have some nodes which are not connected to elements of our current rule, so we fix them
		repairEdges(tggRule);
		repairCorrepondencesNodes(tggRule);
		repairNodeExpressions(tggRule);
		repairInvocationMappings(tggRule);
		removeRefinements(tggRule);
		
		// remove duplicate elements
		optimize(tggRule);
		
		// clean up refinements because we no longer need them
		tggRule.getRefinements().clear();
		
		flattenedObjects.add(tggRule);
	}

	private void optimize(TGGRule tggRule) {
		var nodes = getElements(tggRule, SlimRuleNode.class);
		nodes.forEach(this::removeDuplicateOutgoingEdges);
	}


	/**
	 * Resolve a refined rules name which can be given as an alias
	 * @param rule
	 * @param ruleNameOrAlias
	 * @return the name of the refined rule
	 */
	private String resolveRefinedRuleName(TGGRule rule, String tokenText) {
		var ruleNameOrAlias = tokenText.substring(0, tokenText.indexOf("."));
		for(var refinement : rule.getRefinements()) {
			if(refinement.getSuperRule().getName().equals(ruleNameOrAlias))
				return ruleNameOrAlias;
			if(refinement instanceof TGGLRuleRefinementAliased aliasedRefinement) {
				if(aliasedRefinement.getName().equals(ruleNameOrAlias)) {
					return aliasedRefinement.getSuperRule().getName();
				}
			}
		}
		throw new RuntimeException("Cannot resolve " + ruleNameOrAlias + " from " + rule.getName());
	}

	private void removeRefinements(EObject root) {
		for(var contextNode : getElements(root, SlimRuleNodeContext.class)) {
			contextNode.getRefinement().clear();;
			contextNode.setRefining(false);
		}
		
		for(var createdNode : getElements(root, SlimRuleNodeCreation.class)) {
			createdNode.getRefinement().clear();
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

	private void flattenNodeCreationRefinement(SlimRuleNodeCreation node) {
		Collection<SlimRuleNode> refinedTargets = getElements(node, TGGRuleRefinementNode.class).stream().map(r -> r.getNode()).collect(Collectors.toSet());
		
		// we have to copy assignments to the refining node
		for(var refinedTarget : refinedTargets) {
			var copy = EcoreUtil.copy(refinedTarget);
			
			node.getCreation().getAssignments().addAll(copy.getAssignments());
		}
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
		var refinementMapping = container2refinementMapping.get(root);
		if(refinementMapping.refined2refining().containsKey(oldNode)) {
			return (SlimRuleNode) refinementMapping.refined2refining().get(oldNode);
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
		
		var copyResult = eMoflonEMFUtil.copyAll(files);
		var copies = copyResult.copies();
		this.copied2originalFileContents = copyResult.copies2originals();
		this.original2copiedFileContents = copyResult.originals2copies();
		
		XtextResource r = new XtextResource();
		r.getContents().addAll(copies);
		
		EcoreUtil.resolveAll(r);
		
		for(var file : copies) {
			if(file.getSchema() != null)
				mainFile.setSchema(file.getSchema());
			
			mainFile.getImports().addAll(file.getImports());
			mainFile.getLibraries().addAll(file.getLibraries());
			mainFile.getPatterns().addAll(file.getPatterns());
			mainFile.getRules().addAll(file.getRules());
		}
		
		return mainFile;
	}
	
	/**
	 * This method determines if an element is in the refined targets by traversing over its copy hierarchy
	 * @param refinedTargets
	 * @param node
	 * @return
	 */
	private boolean isInRefinedTargets(Collection<? extends EObject> refinedTargets, EObject node) {
		var checkedNode = node;
		while(copyOf.containsKey(checkedNode)) {
			checkedNode = copyOf.get(checkedNode);
		}
		
		return refinedTargets.contains(checkedNode);
	}
	
	private EObject getCopyOrigin(EObject node) {
		var checkedNode = node;
		while(copyOf.containsKey(checkedNode)) {
			checkedNode = copyOf.get(checkedNode);
		}
		
		return checkedNode;
	}
	
	private void removeDuplicateOutgoingEdges(SlimRuleNode node) {
		var toBeRemoved = new HashSet<EObject>();
		var allContextEdges = new HashSet<>();
		for(var contextEdge : node.getContextEdges()) {
			var edge = contextEdge.getContext();
			if(!allContextEdges.add(new Edge(node, edge.getType(), edge.getTarget()))) {
				toBeRemoved.add(contextEdge);
			}
		}
		
		var allCreatedEdges = new HashSet<>();
		for(var createdEdge : node.getCreatedEdges()) {
			var edge = createdEdge.getCreation();
			if(!allCreatedEdges.add(new Edge(node, edge.getType(), edge.getTarget()))) {
				toBeRemoved.add(createdEdge);
			}
		}
		EcoreUtil.deleteAll(toBeRemoved, true);
	}
}

record Edge(EObject source, EReference type, EObject target) {
	
}

record RefinementMapping(Map<EObject, EObject> refined2refining) {
	
};
