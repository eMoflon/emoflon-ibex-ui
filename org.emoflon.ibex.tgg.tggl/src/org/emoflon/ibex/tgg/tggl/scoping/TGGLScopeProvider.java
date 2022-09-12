/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl.scoping;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.*;
import static org.emoflon.ibex.tgg.tggl.scoping.TGGLScopeUtil.*;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.emoflon.ibex.common.slimgt.scoping.SlimGTQualifiedNameScope;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRule;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtils;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.Schema;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementPlain;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
enum DomainType {
	SOURCE, CORRESPONDENCE, TARGET
}

public class TGGLScopeProvider extends AbstractTGGLScopeProvider {

	@Override
	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		
		// package references
		if (isSchemaSourceTypes(context, reference))
			return getPackagesFromImports(context, reference);
		if (isSchemaTargetTypes(context, reference))
			return getPackagesFromImports(context, reference);
		
		// node type references
		if (isSlimRuleNodeType(context, reference))
			return getTypes(context, reference, getDomainType(context));
		if (isCorrespondenceNodeType(context, reference))
			return getTypes(context, reference, DomainType.CORRESPONDENCE);
		
		if (isCorrespondenceSourceType(context, reference))
			return getTypes(context, reference, DomainType.SOURCE);
		if (isCorrespondenceTargetType(context, reference))
			return getTypes(context, reference, DomainType.TARGET);

		// edge target references
		if (isEdgeTargetReference(context, reference))
			return getEdgeTargetReference(context, reference);
		
		if (isCorrespondenceNodeSource(context, reference))
			return getCorrespondenceReferencedNodes(context, reference);
		if (isCorrespondenceNodeTarget(context, reference))
			return getCorrespondenceReferencedNodes(context, reference);
		
		// mapping references
		if (isRuleNodeMappingSource(context, reference))
			return getMappingSourceNodes(context, reference);
		if (isRuleNodeMappingTarget(context, reference))
			return getMappingTargetNodes(context, reference);

		// refinement references
		if (isTGGRuleRefinements(context, reference))
			return getTGGRuleCandidates(context, reference);
		if (isTGGRuleRefinementAliasedSuperRule(context, reference))
			return getTGGRuleCandidates(context, reference);
//		if (isTGGRuleRefinementPlainName(context, reference))
//			return getTGGRuleCandidates(context, reference);
		
		if (isTGGRuleRefinmentNodeRefinement(context, reference))
			return getRefinedRules(context, reference);
		if (isTGGRuleRefinmentNodeNode(context, reference))
			return getTargetNodesFromRefinedRule(context, reference);
		
		return super.getScopeInternal(context, reference);
	}

	private IScope getPackagesFromImports(EObject context, EReference reference) {
		var schema = getSchemaInScope(context);
		var editorFile = getContainer(schema, EditorFile.class);
		var packages = getPackages(editorFile);
		return Scopes.scopeFor(packages);
	}

	private IScope getCorrespondenceReferencedNodes(EObject context, EReference reference) {
		var corrNode = (CorrespondenceNode) context;
		var domain = DomainType.SOURCE;
		if(reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET)
			domain = DomainType.TARGET;
		
		var tggRule = getContainer(context, TGGRule.class);
		Collection<SlimRuleNode> nodes;
		switch(domain) {
		case SOURCE:
			nodes = getSourceNodes(tggRule);
			break;
		case TARGET:
			nodes = getTargetNodes(tggRule);
			break;
		default:
			throw new RuntimeException("Should not occur");
		}
		
		// we still have to filter nodes for those that match the correspondence nodes type
		var corrType = corrNode.getType();
		EClass referencedType;
		switch(domain) {
		case SOURCE:
			referencedType = corrType.getSource();
			break;
		case TARGET:
			referencedType = corrType.getTarget();
			break;
		default:
			throw new RuntimeException("Should not occur");
		}
		
		nodes = nodes.stream().filter(n -> referencedType.isSuperTypeOf(n.getType())).toList();
		return Scopes.scopeFor(nodes);
	}

	private IScope getTargetNodesFromRefinedRule(EObject context, EReference reference) {
		var ruleRefinementNode = (TGGLRuleRefinementNode) context;
		var refinement = ruleRefinementNode.getRefinement();
		var tggRule = extractTGGRule(refinement);

		Collection<EObject> nodes = null;
		switch(getDomainType(context)) {
		case SOURCE:
			nodes = getNodesFromDomain(tggRule, DomainType.SOURCE);
			break;
		case CORRESPONDENCE:
			nodes = getNodesFromDomain(tggRule, DomainType.CORRESPONDENCE);
			break;
		case TARGET:
			nodes = getNodesFromDomain(tggRule, DomainType.TARGET);
			break;
		}
		
		return Scopes.scopeFor(nodes);
	}

	private TGGRule extractTGGRule(EObject refinement) {
		if(refinement instanceof TGGRule tggRule)
			return tggRule;
		if(refinement instanceof TGGLRuleRefinementPlain plain) 
			return plain.getSuperRule();
		if(refinement instanceof TGGLRuleRefinementAliased aliased)
			return aliased.getSuperRule();
		return null;
	}

	private IScope getRefinedRules(EObject context, EReference reference) {
		var tggRule = getContainer(context, TGGRule.class);
		var refinedRules = new HashSet<EObject>();
		for(var refinement : tggRule.getRefinements()) {
			if(refinement instanceof TGGLRuleRefinementPlain plain) {
				refinedRules.add(plain);
			}
			else if(refinement instanceof TGGLRuleRefinementAliased aliased) {
				refinedRules.add(aliased);
				refinedRules.add(aliased.getSuperRule());
			} 
		}
		return Scopes.scopeFor(refinedRules);
	}

	private IScope getMappingTargetNodes(EObject context, EReference reference) {
		var mapping = (SlimRuleNodeMapping) context;

		// get invocation and extract matching types from the support pattern
		var invocation = getContainer(context, SlimRuleInvocation.class);
		var supportPattern = invocation.getSupportPattern();
		
		Set<SlimRuleNode> nodeCandidates = new HashSet<>();
		var sourceNode = mapping.getSrcNode();
		
		// only show nodes with correct mode (context/creation)
		var creationNode = getContainer(sourceNode, SlimRuleNodeCreation.class);
		if(creationNode != null) {
			nodeCandidates.addAll(getSlimRuleNodesFromCreation(supportPattern.getCreatedNodes()));			
		}
		var contextNode = getContainer(sourceNode, SlimRuleNodeContext.class);
		if(contextNode != null) {
			nodeCandidates.addAll(getSlimRuleNodesFromContext(supportPattern.getContextNodes()));
		}
		
		// only show nodes that have a matching type
		nodeCandidates = nodeCandidates.stream() //
				.filter(n -> sourceNode.getType().isSuperTypeOf(n.getType())).collect(Collectors.toSet()); 
		
		return Scopes.scopeFor(nodeCandidates);
	}

	// only allow candidates from the rule that have the right domain
	private IScope getMappingSourceNodes(EObject context, EReference reference) {
		var slimRule = getContainer(context, SlimRule.class);
		var nodeCandidates = new HashSet<EObject>();
		nodeCandidates.addAll(slimRule.getContextNodes());
		nodeCandidates.addAll(slimRule.getCreatedNodes());

		return Scopes.scopeFor(nodeCandidates);
	}

	private IScope getTGGRuleCandidates(EObject context, EReference reference) {
		var rule = getContainer(context, TGGRule.class);
		var rules = getAllRulesInScope(context);

		// remove self reference
		rules.remove(rule);
		return Scopes.scopeFor(rules);
	}

	private IScope getEdgeTargetReference(EObject context, EReference reference) {
		switch (getDomainType(context)) {
		case SOURCE:
			return Scopes.scopeFor(getTargetNodes(context, reference, DomainType.SOURCE));
		case CORRESPONDENCE:
			return Scopes.scopeFor(getTargetNodes(context, reference, DomainType.CORRESPONDENCE));
		case TARGET:
			return Scopes.scopeFor(getTargetNodes(context, reference, DomainType.TARGET));
		}
		throw new RuntimeException("Could not resolve edge targets for " + context);
	}

	private Collection<SlimRuleNode> getTargetNodes(EObject context, EReference reference, DomainType domain) {
		var tggRule = getContainer(context, TGGRule.class);
		
		Collection<SlimRuleNode> nodes = null;
		switch(domain) {
		case SOURCE:
			nodes = getSourceNodes(tggRule);
			break;
		case CORRESPONDENCE:
			if (reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__SOURCE) 
				nodes = getSourceNodes(tggRule);
			if (reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET) 
				nodes = getTargetNodes(tggRule);
			break;
		case TARGET:
			nodes = getTargetNodes(tggRule);
			break;
		default:
			break;
		
		}

		// only allow elements with a matching type
		EClass targetType = null;
		if (context instanceof SlimRuleEdge edge) {
			targetType = (EClass) edge.getType().getEType();
		} else if (context instanceof CorrespondenceNode correspondence) {
			if (reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__SOURCE)
				targetType = correspondence.getType().getSource();
			if (reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET)
				targetType = correspondence.getType().getTarget();

		} else
			throw new RuntimeException("Cannot resolve type for context element " + context);

		final EClass finalTargetType = targetType;
		nodes = nodes.parallelStream() //
				.filter(n -> finalTargetType.isSuperTypeOf(n.eClass())) //
				.collect(Collectors.toSet()); //

		return nodes;
	}
	
	private Collection<CorrespondenceNode> toCorrespondenceNodes(Collection<EObject> objects) {
		return objects.stream().map(o -> (CorrespondenceNode) o).toList();
	}
	
	private Collection<SlimRuleNode> toSlimNodes(Collection<EObject> objects) {
		return objects.stream().map(o -> (SlimRuleNode) o).toList();
	}

	public Collection<SlimRuleNode> getSourceNodes(TGGRule rule) {
		return toSlimNodes(getNodesFromDomain(rule, DomainType.SOURCE));
	}
	
	public Collection<CorrespondenceNode> getCorrespondenceNodes(TGGRule rule) {
		return toCorrespondenceNodes(getNodesFromDomain(rule, DomainType.CORRESPONDENCE));
	}
	
	public Collection<SlimRuleNode> getTargetNodes(TGGRule rule) {
		return toSlimNodes(getNodesFromDomain(rule, DomainType.TARGET));
	}
	
	private Collection<EObject> getNodesFromDomain(TGGRule rule, DomainType domain) {
		Set<EObject> nodes = new HashSet<>();
		var ruleCandidates = new HashSet<TGGRule>();
		var refinedNodes = new HashSet<Object>();
		ruleCandidates.add(rule);

		// find all nodes in each TGG rule that is refined
		while (!ruleCandidates.isEmpty()) {
			var currentRule = ruleCandidates.iterator().next();
			ruleCandidates.remove(currentRule);
			
			// extract refined rule from refinements
			for(var refinement : currentRule.getRefinements()) {
				ruleCandidates.add(extractTGGRule(refinement));
			}

			Set<EObject> newNodes = new HashSet<>();
			switch (domain) {
			case SOURCE:
				newNodes.addAll(getSlimRuleNodesFromContext(rule.getSourceRule().getContextNodes()));
				newNodes.addAll(getSlimRuleNodesFromCreation(rule.getSourceRule().getCreatedNodes()));
				break;
			case CORRESPONDENCE:
				newNodes.addAll(rule.getCorrespondenceNodes());
				break;
			case TARGET:
				newNodes.addAll(getSlimRuleNodesFromContext(rule.getTargetRule().getContextNodes()));
				newNodes.addAll(getSlimRuleNodesFromCreation(rule.getTargetRule().getCreatedNodes()));
				break;
			}
			
			for(var newNode : newNodes) {
				var tggNode = (org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNode) newNode;
				if(tggNode.getRefinement() != null)
					refinedNodes.add(tggNode.getRefinement().getNode());
				
				// only add nodes that have not been refined and thus have been overlapped with another node
				if(!refinedNodes.contains(tggNode)) {
					nodes.add(tggNode);
				}
			}
		}
		return nodes;
	}

	private Collection<SlimRuleNode> getSlimRuleNodesFromContext(Collection<SlimRuleNodeContext> contextElements) {
		return contextElements.stream().map(c -> c.getContext()).toList();
	}

	private Collection<SlimRuleNode> getSlimRuleNodesFromCreation(Collection<SlimRuleNodeCreation> createdElements) {
		return createdElements.stream().map(c -> c.getCreation()).toList();
	}

	private DomainType getDomainType(EObject context) {
		var tggRule = getContainer(context, TGGRule.class);
		var rule = getContainer(context, SlimRule.class);
		if (rule != null) {
			if (tggRule.getSourceRule().equals(rule))
				return DomainType.SOURCE;
			if (tggRule.getTargetRule().equals(rule))
				return DomainType.TARGET;
		}

		// else it must be a correspondence node
		if (tggRule.getCorrespondenceNodes().contains(context)) {
			return DomainType.CORRESPONDENCE;
		}

		throw new RuntimeException("Could not identify domain of element " + context);
	}

	private IScope getTypes(EObject context, EReference reference, DomainType domain) {
		var schema = getSchemaInScope(context);

		switch (domain) {
		case SOURCE:
			return new SlimGTQualifiedNameScope(getTypes(schema.getSourceTypes()));
		case CORRESPONDENCE:
			return Scopes.scopeFor(schema.getCorrespondenceTypes());
		case TARGET:
			return new SlimGTQualifiedNameScope(getTypes(schema.getTargetTypes()));
		}
		return IScope.NULLSCOPE;
	}

	public Collection<EClass> getTypes(Collection<EPackage> packages) {
		var types = new HashSet<EClass>();
		var packageCandidates = new HashSet<EPackage>(packages);
		while (!packageCandidates.isEmpty()) {
			var pkg = packageCandidates.iterator().next();
			packageCandidates.remove(pkg);
			for (var classifier : pkg.getEClassifiers()) {
				if (classifier instanceof EClass eClass && !eClass.isAbstract())
					types.add(eClass);
			}
		}
		return types;
	}

	public Collection<TGGRule> getAllRulesInScope(EObject obj) {
		var ef = getContainer(obj, EditorFile.class);
		Collection<TGGRule> ruleSet = new HashSet<>();
		ruleSet.addAll(ef.getRules());

		for (var file : getAllFilesInScope(ef)) {
			ruleSet.addAll(file.getRules());
		}
		return ruleSet;
	}

	public Schema getSchemaInScope(EObject obj) {
		var editorFile = getContainer(obj, EditorFile.class);
		if (editorFile.getSchema() != null)
			return editorFile.getSchema();
		
		for (var otherFile : getAllFilesInScope(editorFile)) {
			if (otherFile.getSchema() != null)
				return otherFile.getSchema();
		}
		return null;
	}

	public Collection<EditorFile> getAllFilesInScope(EObject obj) {
		var editorFile = getContainer(obj, EditorFile.class);
		Collection<EditorFile> editorFiles = new HashSet<>();

		IProject currentProject = SlimGTWorkspaceUtils.getCurrentProject(editorFile.eResource());
		String currentFile = editorFile.eResource().getURI().toString().replace("platform:/resource/", "")
				.replace(currentProject.getName(), "");
		currentFile = currentProject.getLocation().toPortableString() + currentFile;
		currentFile = currentFile.replace("/", "\\");

		File projectFile = new File(currentProject.getLocation().toPortableString());
		List<File> tggFiles = new LinkedList<>();
		SlimGTWorkspaceUtils.gatherFilesWithEnding(tggFiles, projectFile, ".tggl", true);

		for (File tggFile : tggFiles) {
			URI tggModelUri;
			try {
				tggModelUri = URI.createFileURI(tggFile.getCanonicalPath());
			} catch (IOException e) {
				continue;
			}

			String fileString = tggModelUri.toFileString();

			if (fileString.equals(currentFile))
				continue;

			Resource resource = loadResource(editorFile.eResource(), tggModelUri);
			if (resource == null)
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
		
}
