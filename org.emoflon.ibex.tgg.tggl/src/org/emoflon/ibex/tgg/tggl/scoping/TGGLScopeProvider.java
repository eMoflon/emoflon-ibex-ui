/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl.scoping;

import static org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil.*;
import static org.emoflon.ibex.tgg.tggl.scoping.TGGLScopeUtil.*;
import static org.emoflon.ibex.tgg.tggl.util.TGGLWorkspaceUtil.*;

import java.io.File;
import java.io.IOException;
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
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.ibex.common.slimgt.scoping.SlimGTAliasedTypeScope;
import org.emoflon.ibex.common.slimgt.slimGT.GTLRuleRefinementAliased;
import org.emoflon.ibex.common.slimgt.slimGT.GTLRuleRefinementPlain;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferenceAlias;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferencePlain;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleSimpleEdge;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.tgg.tggl.scoping.scopes.TGGLAliasedPatternScope;
import org.emoflon.ibex.tgg.tggl.scoping.scopes.TGGLAliasedRuleScope;
import org.emoflon.ibex.tgg.tggl.scoping.scopes.TGGLFQAttributeConditionScope;
import org.emoflon.ibex.tgg.tggl.tGGL.AttributeConditionDefinition;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceType;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.Schema;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRule;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGDomainRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementPlain;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.util.TGGLWorkspaceUtil;

import static org.emoflon.ibex.common.slimgt.util.SlimGTCollectionUtil.*;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
enum DomainType {
	SOURCE, CORRESPONDENCE, TARGET, SOURCE_AND_TARGET
}

public class TGGLScopeProvider extends AbstractTGGLScopeProvider {

	@Override
	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {

		// package references
		if (isSchemaSourceTypes(context, reference))
			return getPackagesFromImports(context, reference);
		if (isSchemaTargetTypes(context, reference))
			return getPackagesFromImports(context, reference);

		// pattern invocation
		if(isSlimRuleInvocationSupportPattern(context, reference))
			return getPatterns(context, reference);
		
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

		// attribute feature
		if (isNodeAttributeExpressionFeature(context, reference))
			return getNodeAttributeExpressionFeatures(context, reference);
		if (isNodeExpressionNode(context, reference))
			return getNodeExpressionNode(context, reference);
		if (isRuleConditionNode(context, reference))
			return getNodeExpressionNode(context, reference);
		
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

		if (isSlimRuleRefinements(context, reference))
			return getPatternCandidates(context, reference);
		if (isSlimRuleRefinementAliasedSuperRule(context, reference))
			return getPatternCandidates(context, reference);
		
		if (isSlimRuleNodeNode(context, reference))
			return getTargetNodesFromRefinement(context, reference);
		if (isCorrespondenceNodeNode(context, reference))
			return getTargetNodesFromRefinedRule(context, reference);

		// attribute conditions
		if (isTGGRuleConditionName(context, reference))
			return getCondition(context, reference);

		return super.getScopeInternal(context, reference);
	}

	private IScope getPatterns(EObject context, EReference reference) {
		var patterns = getAllPatternsInScope(context);
		patterns = patterns.stream().filter(pattern -> !pattern.isAbstract()).collect(Collectors.toSet());

		// remove self reference
		return Scopes.scopeFor(patterns);
	}

	private IScope getPatternCandidates(EObject context, EReference reference) {
		var pattern = (SlimRule) context;
		var patterns = getAllPatternsInScope(context);

		// remove self reference
		patterns.remove(pattern);
		return Scopes.scopeFor(patterns);
	}

	private IScope getCondition(EObject context, EReference reference) {
		var conditionDefinitions = new HashSet<AttributeConditionDefinition>();
		var editorFiles = getAllFilesInScope(context);
		var thisEditorFile = getContainer(context, EditorFile.class);
		editorFiles.add(thisEditorFile);

		for (var editorFile : editorFiles) {
			for (var library : editorFile.getLibraries()) {
				conditionDefinitions.addAll(library.getAttributeCondDefs());
			}
		}

		return new TGGLFQAttributeConditionScope(conditionDefinitions);
	}

	private IScope getNodeAttributeExpressionFeatures(EObject context, EReference reference) {
		var slimNode = getContainer(context, SlimRuleNode.class);
		if (slimNode != null) {
			return Scopes.scopeFor(slimNode.getType().getEAllAttributes());
		}

		var nodeAttributeExpression = getContainer(context, NodeAttributeExpression.class);
		if (nodeAttributeExpression != null) {
			return Scopes.scopeFor(nodeAttributeExpression.getNodeExpression().getNode().getType().getEAllAttributes());
		}
		return IScope.NULLSCOPE;
	}
	
	private IScope getNodeExpressionNode(EObject context, EReference reference) {
		var slimRule = getContainer(context, SlimRule.class);
		var nodeCandidates = new HashSet<EObject>();
		if(slimRule != null) {
			nodeCandidates.addAll(getNodesFromPattern(slimRule));
		}
		
		var tggRule = getContainer(context, TGGRule.class);
		if(tggRule != null) {
			nodeCandidates.addAll(getNodesFromDomain(tggRule, getDomainType(context)));
		}

		return Scopes.scopeFor(nodeCandidates);
	}

	private IScope getPackagesFromImports(EObject context, EReference reference) {
		var schema = getSchemaInScope(context);
		var editorFile = getContainer(schema, EditorFile.class);

		var output = new LinkedList<EObject>();
		var packageRefs = editorFile.getImports().stream().flatMap(i -> i.getPackageAliases().stream()).toList();
		var packages = getPackages(editorFile);

		output.addAll(packageRefs);
		output.addAll(packages);
		return Scopes.scopeFor(output);
	}

	private IScope getCorrespondenceReferencedNodes(EObject context, EReference reference) {
		var corrNode = (TGGCorrespondenceNode) context;
		var domain = DomainType.SOURCE;
		if (reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TARGET)
			domain = DomainType.TARGET;

		var tggRule = getContainer(context, TGGRule.class);
		Collection<SlimRuleNode> nodes;
		switch (domain) {
		case SOURCE:
			nodes = getSourceNodes(tggRule);
			break;
		case TARGET:
			nodes = getTargetNodes(tggRule);
			break;
		default:
			throw new RuntimeException("Should not occur");
		}

		// we still have to filter nodes for those that match the correspondence nodes
		// type
		var corrType = corrNode.getType();
		EClass referencedType;
		switch (domain) {
		case SOURCE:
			referencedType = corrType.getSource();
			break;
		case TARGET:
			referencedType = corrType.getTarget();
			break;
		default:
			throw new RuntimeException("Should not occur");
		}
		final EClass finalTargetType = referencedType;
		nodes = filterSlimNodesIfNotSubType(nodes, finalTargetType);

		return Scopes.scopeFor(nodes);
	}
	
	private IScope getTargetNodesFromRefinement(EObject context, EReference reference) {
		var tggRule = getContainer(context, TGGRule.class);
		if(tggRule != null)
			return getTargetNodesFromRefinedRule(context, reference);
		
		var pattern = getContainer(context, SlimRule.class);
		if(pattern != null)
			return getTargetNodesFromRefinedPattern(context, reference);
		
		throw new RuntimeException("Should never occur");
	}

	private IScope getTargetNodesFromRefinedRule(EObject context, EReference reference) {
		var tggRule = getContainer(context, TGGRule.class);

		Collection<EObject> nodes = new HashSet<>();
		Collection<TGGLRuleRefinementAliased> ruleAliases = new HashSet<>();
		for (var ruleRefinement : tggRule.getRefinements()) {
			var refinedRule = ruleRefinement.getSuperRule();
			nodes.addAll(getNodesFromDomain(refinedRule, getDomainType(context)));

			if (ruleRefinement instanceof TGGLRuleRefinementAliased alias)
				ruleAliases.add(alias);
		}

		return new TGGLAliasedRuleScope(ruleAliases, nodes);
	}
	
	private IScope getTargetNodesFromRefinedPattern(EObject context, EReference reference) {
		var pattern = getContainer(context, SlimRule.class);

		Collection<EObject> nodes = new HashSet<>();
		Collection<GTLRuleRefinementAliased> ruleAliases = new HashSet<>();
		for (var ruleRefinement : pattern.getRefinements()) {
			var refinedRule = ruleRefinement.getSuperRule();
			nodes.addAll(refinedRule.getContextNodes().stream().map(c -> c.getContext()).toList());

			if (ruleRefinement instanceof GTLRuleRefinementAliased alias)
				ruleAliases.add(alias);
		}

		return new TGGLAliasedPatternScope(ruleAliases, nodes);
	}

	private TGGRule extractTGGRule(EObject refinement) {
		if (refinement instanceof TGGRule tggRule)
			return tggRule;
		if (refinement instanceof TGGLRuleRefinementPlain plain)
			return plain.getSuperRule();
		if (refinement instanceof TGGLRuleRefinementAliased aliased)
			return aliased.getSuperRule();
		return null;
	}
	
	private SlimRule extractPattern(EObject refinement) {
		if (refinement instanceof SlimRule pattern)
			return pattern;
		if (refinement instanceof GTLRuleRefinementPlain plain)
			return (SlimRule) plain.getSuperRule();
		if (refinement instanceof GTLRuleRefinementAliased aliased)
			return (SlimRule) aliased.getSuperRule();
		return null;
	}

	private IScope getRefinedRules(EObject context, EReference reference) {
		var tggRule = getContainer(context, TGGRule.class);
		var refinedRules = new HashSet<EObject>();
		for (var refinement : tggRule.getRefinements()) {
			if (refinement instanceof TGGLRuleRefinementPlain plain) {
				refinedRules.add(plain);
			} else if (refinement instanceof TGGLRuleRefinementAliased aliased) {
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
		var sourceNode = mapping.getSource();

		// only show nodes with correct mode (context/creation)
		var contextNode = getContainer(sourceNode, SlimRuleNodeContext.class);
		if (contextNode != null) {
			nodeCandidates.addAll(getSlimRuleNodesFromContext(castCollection(supportPattern.getContextNodes(), SlimRuleNodeContext.class)));
		}

		// only show nodes that have a matching type
		nodeCandidates = nodeCandidates.stream() //
				.filter(n -> sourceNode.getType().isSuperTypeOf(n.getType())).collect(Collectors.toSet());

		return Scopes.scopeFor(nodeCandidates);
	}

	private IScope getMappingSourceNodes(EObject context, EReference reference) {
		var slimRule = getContainer(context, SlimRule.class);
		var nodeCandidates = new HashSet<EObject>();
		if(slimRule != null) {
			nodeCandidates.addAll(getNodesFromPattern(slimRule));
		}
		
		var tggRule = getContainer(context, TGGRule.class);
		if(tggRule != null) {
			nodeCandidates.addAll(getNodesFromDomain(tggRule, getDomainType(context)));
		}

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
		return Scopes.scopeFor(getTargetNodes(context, reference, getDomainType(context)));
	}

	private Collection<SlimRuleNode> getTargetNodes(EObject context, EReference reference, DomainType domain) {
		var tggRule = getContainer(context, TGGRule.class);
		var pattern = getContainer(context, SlimRule.class);

		Collection<SlimRuleNode> nodes = null;
		switch (domain) {
		case SOURCE:
			nodes = getSourceNodes(tggRule);
			break;
		case CORRESPONDENCE:
			if (reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__SOURCE)
				nodes = getSourceNodes(tggRule);
			if (reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TARGET)
				nodes = getTargetNodes(tggRule);
			break;
		case TARGET:
			nodes = getTargetNodes(tggRule);
			break;
		case SOURCE_AND_TARGET: 
			nodes = getSlimRuleNodesFromContext(castCollection(pattern.getContextNodes(), SlimRuleNodeContext.class));
			break;
		default:
			break;

		}

		// only allow elements with a matching type
		EClass targetType = null;
		if (context instanceof SlimRuleSimpleEdge edge) {
			targetType = (EClass) edge.getType().getEType();
		} else if (context instanceof TGGCorrespondenceNode correspondence) {
			if (reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__SOURCE)
				targetType = correspondence.getType().getSource();
			if (reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TARGET)
				targetType = correspondence.getType().getTarget();

		} else
			throw new RuntimeException("Cannot resolve type for context element " + context);

		final EClass finalTargetType = targetType;
		// Find nodes with correct type. Allowed: Exact type match or target type is a
		// subtype of the edge type.
		nodes = filterSlimNodesIfNotSubType(nodes, finalTargetType);

		return nodes;
	}

	private Collection<EClass> filterTypesIfNoSubType(Collection<EClass> types, final EClass superType) {
		types = types.stream()
				.filter(sn -> sn.getName().equals(superType.getName()) || sn.getEAllSuperTypes().stream()
						.filter(superCls -> superCls.getName().equals(superType.getName())).findAny().isPresent())
				.collect(Collectors.toSet());
		return types;
	}

	private Collection<SlimRuleNode> filterSlimNodesIfNotSubType(Collection<SlimRuleNode> nodes,
			final EClass superType) {
		nodes = nodes.stream()
				.filter(sn -> sn.getType().getName().equals(superType.getName()) || sn.getType().getEAllSuperTypes()
						.stream().filter(superCls -> superCls.getName().equals(superType.getName())).findAny()
						.isPresent())
				.collect(Collectors.toSet());
		return nodes;
	}

	private Collection<TGGCorrespondenceNode> filterCorrespondenceNodesIfNotSubType(Collection<TGGCorrespondenceNode> nodes, final CorrespondenceType finalTargetType) {
		nodes = nodes.stream().filter(sn -> sn.getType().getName().equals(finalTargetType.getName())
				|| getEAllSuperTypes(sn.getType()).contains(finalTargetType)).collect(Collectors.toSet());
		return nodes;
	}

	private Collection<CorrespondenceType> getEAllSuperTypes(CorrespondenceType corrType) {
		var superTypes = new HashSet<CorrespondenceType>();
		var superType = corrType;
		while (superType != null) {
			superTypes.add(superType);
			superType = superType.getSuper();
		}
		return superTypes;
	}

	private Collection<TGGCorrespondenceNode> toCorrespondenceNodes(Collection<EObject> objects) {
		return objects.stream().map(o -> (TGGCorrespondenceNode) o).toList();
	}

	private Collection<SlimRuleNode> toSlimNodes(Collection<EObject> objects) {
		return objects.stream().map(o -> (SlimRuleNode) o).toList();
	}

	public Collection<SlimRuleNode> getSourceNodes(TGGRule rule) {
		return toSlimNodes(getNodesFromDomain(rule, DomainType.SOURCE));
	}

	public Collection<TGGCorrespondenceNode> getCorrespondenceNodes(TGGRule rule) {
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
			for (var refinement : currentRule.getRefinements()) {
				ruleCandidates.add(extractTGGRule(refinement));
			}

			Set<EObject> newNodes = new HashSet<>();
			switch (domain) {
			case SOURCE:
				if (currentRule.getSourceRule() != null) {
					newNodes.addAll(getSlimRuleNodesFromContext(currentRule.getSourceRule().getContextNodes()));
					newNodes.addAll(getSlimRuleNodesFromCreation(currentRule.getSourceRule().getCreatedNodes()));
				}
				break;
			case CORRESPONDENCE:
				newNodes.addAll(getCorrespondenceNodesFromContext(currentRule.getCorrRule().getContextCorrespondenceNodes()));
				newNodes.addAll(getCorrespondenceNodesFromCreation(currentRule.getCorrRule().getCreatedCorrespondenceNodes()));
				break;
			case TARGET:
				if (currentRule.getTargetRule() != null) {
					newNodes.addAll(getSlimRuleNodesFromContext(currentRule.getTargetRule().getContextNodes()));
					newNodes.addAll(getSlimRuleNodesFromCreation(currentRule.getTargetRule().getCreatedNodes()));
				}
				break;
			case SOURCE_AND_TARGET: 
				if (currentRule.getSourceRule() != null) {
					newNodes.addAll(getSlimRuleNodesFromContext(currentRule.getSourceRule().getContextNodes()));
					newNodes.addAll(getSlimRuleNodesFromCreation(currentRule.getSourceRule().getCreatedNodes()));
				}
				if (currentRule.getTargetRule() != null) {
					newNodes.addAll(getSlimRuleNodesFromContext(currentRule.getTargetRule().getContextNodes()));
					newNodes.addAll(getSlimRuleNodesFromCreation(currentRule.getTargetRule().getCreatedNodes()));
				}
			}

			for (var newNode : newNodes) {
				var refinement = getRuleRefinementNode(newNode);
				if (refinement != null && refinement instanceof TGGRuleRefinementNode nodeRefinement)
					refinedNodes.add(nodeRefinement.getNode());
				if (refinement != null && refinement instanceof TGGLRuleRefinementCorrespondenceNode corrRefinement)
					refinedNodes.add(corrRefinement.getNode());

				// only add nodes that have not been refined and thus have been overlapped with
				// another node
				if (!refinedNodes.contains(newNode)) {
					nodes.add(newNode);
				}
			}
		}
		return nodes;
	}
	
	private Collection<EObject> getNodesFromPattern(SlimRule pattern) {
		Set<EObject> nodes = new HashSet<>();
		var patternCandidates = new HashSet<SlimRule>();
		var refinedNodes = new HashSet<Object>();
		patternCandidates.add(pattern);

		// find all nodes in each TGG rule that is refined
		while (!patternCandidates.isEmpty()) {
			var currentPattern = patternCandidates.iterator().next();
			patternCandidates.remove(currentPattern);

			// extract refined rule from refinements
			for (var refinement : currentPattern.getRefinements()) {
				patternCandidates.add(extractPattern(refinement));
			}

			var newNodes = getSlimRuleNodesFromContext(castCollection(currentPattern.getContextNodes(), SlimRuleNodeContext.class));

			for (var newNode : newNodes) {
				var refinement = getRuleRefinementNode(newNode);
				if (refinement != null && refinement instanceof TGGRuleRefinementNode nodeRefinement)
					refinedNodes.add(nodeRefinement.getNode());

				// only add nodes that have not been refined and thus have been overlapped with
				// another node
				if (!refinedNodes.contains(newNode)) {
					nodes.add(newNode);
				}
			}
		}
		return nodes;
	}
	
	private EObject getRuleRefinementNode(EObject context) {
		var contextNode = getContainer(context, org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeContext.class);
		if (contextNode != null)
			return contextNode.getRefinement();

		var creationNode = getContainer(context, org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeCreation.class);
		if (creationNode != null)
			return creationNode.getRefinement();

		var contextCorrespondenceNode = getContainer(context, TGGCorrespondenceNodeContext.class);
		if (contextCorrespondenceNode != null)
			return contextCorrespondenceNode.getRefinement();
		
		var creationCorrespondenceNode = getContainer(context, TGGCorrespondenceNodeCreation.class);
		if (creationCorrespondenceNode != null)
			return creationCorrespondenceNode.getRefinement();
		return null;
	}

	private Collection<SlimRuleNode> getSlimRuleNodesFromContext(Collection<SlimRuleNodeContext> contextElements) {
		return contextElements.stream().map(c -> c.getContext()).toList();
	}

	private Collection<SlimRuleNode> getSlimRuleNodesFromCreation(Collection<SlimRuleNodeCreation> createdElements) {
		return createdElements.stream().map(c -> c.getCreation()).toList();
	}
	
	private Collection<TGGCorrespondenceNode> getCorrespondenceNodesFromContext(Collection<TGGCorrespondenceNodeContext> contextElements) {
		return contextElements.stream().map(c -> c.getContext()).toList();
	}

	private Collection<TGGCorrespondenceNode> getCorrespondenceNodesFromCreation(Collection<TGGCorrespondenceNodeCreation> createdElements) {
		return createdElements.stream().map(c -> c.getCreation()).toList();
	}

	private DomainType getDomainType(EObject context) {
		var tggRule = getContainer(context, TGGRule.class);
		var rule = getContainer(context, TGGDomainRule.class);
		if (rule != null) {
			if (tggRule.getSourceRule().equals(rule))
				return DomainType.SOURCE;
			if (tggRule.getTargetRule().equals(rule))
				return DomainType.TARGET;
		}

		// else it must be a correspondence node
		var corrRule = getContainer(context, TGGCorrRule.class);
		if (corrRule != null) {
			return DomainType.CORRESPONDENCE;
		}

		var pattern = getContainer(context, SlimRule.class);
		if(pattern != null) {
			return DomainType.SOURCE_AND_TARGET;
		}
		
		return DomainType.SOURCE_AND_TARGET;
//		throw new RuntimeException("Could not identify domain of element " + context);
	}

	private IScope getTypes(EObject context, EReference reference, DomainType domain) {
		var schema = getSchemaInScope(context);
		var editorFile = getContainer(schema, EditorFile.class);

		var refinedType = getRefinedType(context);
		switch (domain) {
			case SOURCE: {
				var sourceTypes = getTypes(schema.getSourceTypes());
				if (refinedType != null && refinedType instanceof EClass refinedEClass)
					sourceTypes = filterTypesIfNoSubType(sourceTypes, refinedEClass);
				return new SlimGTAliasedTypeScope(editorFile.getImports(), sourceTypes);
			}
			case CORRESPONDENCE: {
				Collection<CorrespondenceType> correspondenceTypes = schema.getCorrespondenceTypes();
				if (refinedType != null && refinedType instanceof CorrespondenceType corrType)
					correspondenceTypes = filterCorrespondenceTypesIfNoSubType(correspondenceTypes, corrType);
				return Scopes.scopeFor(correspondenceTypes);
			}
			case TARGET: {
				var targetTypes = getTypes(schema.getTargetTypes());
				if (refinedType != null && refinedType instanceof EClass refinedEClass)
					targetTypes = filterTypesIfNoSubType(targetTypes, refinedEClass);
				return new SlimGTAliasedTypeScope(editorFile.getImports(), targetTypes);
			}
			case SOURCE_AND_TARGET: {
				var types = join(getTypes(schema.getSourceTypes()), getTypes(schema.getTargetTypes()));
				if (refinedType != null && refinedType instanceof EClass refinedEClass)
					types = filterTypesIfNoSubType(types, refinedEClass);
				return new SlimGTAliasedTypeScope(editorFile.getImports(), types);
			}
		}
		return IScope.NULLSCOPE;
	}

	private Collection<CorrespondenceType> filterCorrespondenceTypesIfNoSubType(
			Collection<CorrespondenceType> correspondenceTypes, CorrespondenceType corrType) {
		correspondenceTypes = correspondenceTypes.stream().filter(ct -> getEAllSuperTypes(ct).contains(corrType))
				.toList();
		return correspondenceTypes;
	}

	private EObject getRefinedType(EObject context) {
		var creationNode = getContainer(context, org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeCreation.class);
		if (creationNode != null) {
			var refinement = creationNode.getRefinement();
			if (refinement != null)
				return refinement.getNode().getType();
		}

		var contextNode = getContainer(context, org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeContext.class);
		if (contextNode != null) {
			var refinement = contextNode.getRefinement();
			if (refinement != null)
				return refinement.getNode().getType();
		}

		var contextCorrespondenceNode = getContainer(context, TGGCorrespondenceNodeContext.class);
		if (contextCorrespondenceNode != null) {
			var refinement = contextCorrespondenceNode.getRefinement();
			if (refinement != null)
				return refinement.getNode().getType();
		}
		
		var creationCorrespondenceNode = getContainer(context, TGGCorrespondenceNodeCreation.class);
		if (creationCorrespondenceNode != null) {
			var refinement = creationCorrespondenceNode.getRefinement();
			if (refinement != null)
				return refinement.getNode().getType();
		}
		return null;
	}

	public static Collection<EClass> getTypes(Collection<EObject> packageReferences) {
		var types = new HashSet<EClass>();
		var packages = getReferencedPackages(packageReferences);
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

	public static Collection<EPackage> getReferencedPackages(Collection<EObject> packageReferences) {
		var packages = new HashSet<EPackage>();
		for (var packageReference : packageReferences) {
			if (packageReference instanceof PackageReferencePlain plain)
				packages.add(plain.getImportedPackage());
			if (packageReference instanceof PackageReferenceAlias alias)
				packages.add(alias.getImportedPackage());
			if (packageReference instanceof EPackage pkg)
				packages.add(pkg);
		}
		return packages;
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

	public Collection<SlimRule> getAllPatternsInScope(EObject obj) {
		var ef = getContainer(obj, EditorFile.class);
		Collection<SlimRule> patternSet = new HashSet<>();
		patternSet.addAll(ef.getPatterns());

		for (var file : getAllFilesInScope(ef)) {
			patternSet.addAll(file.getPatterns());
		}
		return patternSet;
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
}
