/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.scoping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.ibex.common.slimgt.scoping.SlimGTScopeUtil;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanExpression;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleCondition;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.gt.gtl.gTL.EdgeIteratorOperator;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeAssignment;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementAliased;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementNode;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementPlain;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleWatchDog;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext;
import org.emoflon.ibex.gt.gtl.util.GTLModelUtil;
import org.emoflon.ibex.gt.gtl.util.GTLResourceManager;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class GTLScopeProvider extends AbstractGTLScopeProvider {

	protected GTLResourceManager gtlManager = new GTLResourceManager(resourceManager);

	@Override
	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		if (GTLScopeUtil.isPatternImportPattern(context, reference)) {
			return scopeForPatternImportPattern((PatternImport) context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementRule(context, reference)) {
			return scopeForRuleRefinementRule(context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementNodeRefinement(context, reference)) {
			return scopeForRuleRefinementNodeRefinement(context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementNodeNode(context, reference)) {
			return scopeForRuleRefinementNodeNode((GTLRuleRefinementNode) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeType(context, reference)) {
			return scopeForSlimRuleNodeType((SlimRuleNode) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleEdgeTarget(context, reference)) {
			return scopeForSlimEdgeTarget((SlimRuleEdge) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeMappingSrc(context, reference)) {
			return scopeForNodeMappingSrc(context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeMappingTrg(context, reference)) {
			return scopeForNodeMappingTrg((SlimRuleNodeMapping) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleInvocationPattern(context, reference)) {
			return scopeForInvocationSupportPattern((SlimRuleInvocation) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorType(context, reference)) {
			return scopeForGTLEdgeIteratorType((GTLEdgeIterator) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorSubType(context, reference)) {
			return scopeForGTLEdgeIteratorSubType((GTLEdgeIterator) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceSource(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceSource((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceType(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceType((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceTarget(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceTarget((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLParameterExpressionParameter(context, reference)) {
			return scopeForParameterExpressionParameter((GTLParameterExpression) context, reference);
		}
		if (SlimGTScopeUtil.isCountExpressionPattern(context, reference)) {
			return scopeForCountExpressionPattern((CountExpression) context, reference);
		}
		if (GTLScopeUtil.isAttributeConditionExpressionNode(context, reference)) {
			return scopeForAttributeConditionExpressionNode((SlimRuleCondition) context, reference);
		}
		if (SlimGTScopeUtil.isNodeAttributeExpressionNode(context, reference)) {
			return scopeForAttributeExpressionNode(context, reference);
		}
		if (SlimGTScopeUtil.isNodeAttributeExpressionFeature(context, reference)) {
			return scopeForAttributeExpressionFeature((NodeAttributeExpression) context, reference);
		}
		if (GTLScopeUtil.isIteratorAttributeExpressionFeature(context, reference)) {
			return scopeForIteratorAttributeExpressionFeature((GTLIteratorAttributeExpression) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorAttributeAssignment(context)) {
			return scopeForGTLEdgeIteratorAttributeAssignment((GTLEdgeIteratorAttributeAssignment) context, reference);
		}
		if (GTLScopeUtil.isGTLRuleWatchDogNode(context, reference)) {
			return scopeForGTLRuleWatchDogNode((GTLRuleWatchDog) context, reference);
		}
		if (SlimGTScopeUtil.isValueOrArithmeticExpression(context)) {
			return scopeForValueOrArithmeticExpression(context, reference);
		}
		if (SlimGTScopeUtil.isBooleanExpression(context)) {
			return scopeForBooleanExpression((BooleanExpression) context, reference);
		}

		return super.getScopeInternal(context, reference);
	}

	protected IScope scopeForPatternImportPattern(PatternImport context, EReference reference) {
		if (context == null || context.getFile() == null || context.getFile().getValue() == null
				|| context.getFile().getValue().isBlank())
			return IScope.NULLSCOPE;

		Optional<EditorFile> optEditorFile = gtlManager.loadGTLModelByImport(context);
		if (optEditorFile.isPresent()) {
			return Scopes.scopeFor(optEditorFile.get().getRules());
		} else {
			return IScope.NULLSCOPE;
		}
	}

	protected IScope scopeForRuleRefinementRule(EObject context, EReference reference) {
		EditorFile currentFile = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		Collection<SlimRule> allRules = gtlManager.getAllRulesInScope(currentFile);
		allRules.remove(currentRule);
		return Scopes.scopeFor(allRules);
	}

	protected IScope scopeForRuleRefinementNodeRefinement(EObject context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		Collection<EObject> refinements = currentRule.getRefinement().stream()
				.filter(ref -> (ref instanceof GTLRuleRefinementPlain)).map(ref -> (GTLRuleRefinementPlain) ref)
				.map(ref -> ref.getSuperRule()).collect(Collectors.toSet());
		refinements.addAll(currentRule.getRefinement().stream().filter(ref -> (ref instanceof GTLRuleRefinementAliased))
				.map(ref -> (GTLRuleRefinementAliased) ref).collect(Collectors.toSet()));
		return Scopes.scopeFor(refinements);
	}

	protected IScope scopeForRuleRefinementNodeNode(GTLRuleRefinementNode context, EReference reference) {
		if (context.getSuperRule() == null)
			return IScope.NULLSCOPE;

		Optional<SlimRule> optRule = GTLModelUtil.refinementNodeToRule(context.getSuperRule());
		if (!optRule.isPresent())
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(GTLModelUtil.getAllRuleNodes(optRule.get()).stream().filter(n -> {
			if (context.eContainer() instanceof SlimRuleNodeContext && n.eContainer() instanceof SlimRuleNodeContext) {
				return true;
			} else if (context.eContainer() instanceof SlimRuleNodeCreation
					&& n.eContainer() instanceof SlimRuleNodeCreation) {
				return true;
			} else if (context.eContainer() instanceof GTLRuleNodeDeletion
					&& n.eContainer() instanceof GTLRuleNodeDeletion) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList()));
	}

	@Override
	protected IScope scopeForSlimRuleNodeType(org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode context,
			EReference reference) {
		SlimRuleNode ruleNode = (SlimRuleNode) context;
		if (!GTLModelUtil.ruleNodeIsRefining(ruleNode)) {
			return super.scopeForSlimRuleNodeType(context, reference);
		} else {
			if (GTLModelUtil.getRefinementNode(ruleNode) == null
					|| GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode() == null)
				return IScope.NULLSCOPE;

			EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);

			Collection<EClass> superTypes = SlimGTModelUtil.getClasses(ef).stream()
					.filter(cls -> cls.getEAllSuperTypes() != null && cls.getEAllSuperTypes().size() > 0)
					.filter(cls -> cls.getEAllSuperTypes().stream()
							.filter(superCls -> superCls.getName().equals(
									GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode().getType().getName()))
							.findAny().isPresent())
					.collect(Collectors.toSet());
			superTypes.add(GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode().getType());

			return Scopes.scopeFor(superTypes);
		}

	}

	protected IScope scopeForSlimEdgeTarget(SlimRuleEdge context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		// Find nodes with correct type. Allowed: Exact type match or target type is a
		// subtype of the edge type.
		Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllRuleNodes(currentRule).stream()
				.filter(sn -> sn.getType().getName().equals(context.getType().getEType().getName())
						|| sn.getType().getEAllSuperTypes().stream()
								.filter(superCls -> superCls.getName().equals(context.getType().getEType().getName()))
								.findAny().isPresent())
				.collect(Collectors.toSet());
		// TODO: Prohibit self-edges?
//		allRuleNodes.remove(currentRuleNode);

		return Scopes.scopeFor(allRuleNodes);
	}

	protected IScope scopeForNodeMappingSrc(EObject context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		EObject container = SlimGTModelUtil.getContainer(context, SlimRuleInvocation.class);
		if (container != null && container instanceof SlimRuleInvocation invocation) {
			return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(currentRule));
		}
		container = SlimGTModelUtil.getContainer(context, CountExpression.class);
		if (container != null && container instanceof CountExpression count) {
			return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(currentRule));
		}

		return IScope.NULLSCOPE;
	}

	protected IScope scopeForNodeMappingTrg(SlimRuleNodeMapping context, EReference reference) {
		EObject container = SlimGTModelUtil.getContainer(context, SlimRuleInvocation.class);
		if (container != null && container instanceof SlimRuleInvocation invocation) {
			if (invocation.getSupportPattern() != null
					&& invocation.getSupportPattern() instanceof SlimRule otherRule) {
				return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(otherRule));
			} else {
				return IScope.NULLSCOPE;
			}

		}
		container = SlimGTModelUtil.getContainer(context, CountExpression.class);
		if (container != null && container instanceof CountExpression count) {
			if (count.getSupportPattern() != null && count.getSupportPattern() instanceof SlimRule otherRule) {
				return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(otherRule));
			} else {
				return IScope.NULLSCOPE;
			}
		}

		container = SlimGTModelUtil.getContainer(context, SlimRuleInvocation.class);
		if (container != null && container instanceof SlimRuleInvocation invocation
				&& invocation.getSupportPattern() != null
				&& invocation.getSupportPattern() instanceof SlimRule trgRule) {
			Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllDeletedAndContextRuleNodes(trgRule);
			return Scopes.scopeFor(allRuleNodes);
		}

		container = SlimGTModelUtil.getContainer(context, CountExpression.class);
		if (container != null && container instanceof CountExpression count && count.getSupportPattern() != null
				&& count.getSupportPattern() instanceof SlimRule trgRule) {
			Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllDeletedAndContextRuleNodes(trgRule);
			return Scopes.scopeFor(allRuleNodes);
		}

		return IScope.NULLSCOPE;
	}

	private IScope scopeForInvocationSupportPattern(SlimRuleInvocation context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);

		return Scopes.scopeFor(gtlManager.getAllRulesInScope(ef).stream()
				.filter(r -> !r.getName().equals(rule.getName()))
				.filter(r -> r.getParameters() == null || r.getParameters().size() == 0).collect(Collectors.toList()));
	}

	protected IScope scopeForParameterExpressionParameter(GTLParameterExpression context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllParameters(currentRule));
	}

	protected IScope scopeForCountExpressionPattern(CountExpression context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);

		return Scopes.scopeFor(gtlManager.getAllRulesInScope(ef).stream().filter(r -> !r.equals(rule))
				.filter(r -> r.getParameters() == null || r.getParameters().size() == 0).collect(Collectors.toList()));
	}

	protected IScope scopeForValueOrArithmeticExpression(EObject context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	private IScope scopeForBooleanExpression(BooleanExpression context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeConditionExpressionNode(SlimRuleCondition context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeExpressionNode(EObject context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeExpressionFeature(NodeAttributeExpression context, EReference reference) {
		if (context.getNodeExpression() == null)
			return IScope.NULLSCOPE;

		if (context.getNodeExpression().getNode() == null)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(context.getNodeExpression().getNode().getType().getEAllAttributes());
	}

	protected IScope scopeForIteratorAttributeExpressionFeature(GTLIteratorAttributeExpression context,
			EReference reference) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr.getType() == null)
			return IScope.NULLSCOPE;

		if (itr.isCasting() && itr.getSubType() != null) {
			return Scopes.scopeFor(itr.getSubType().getEAllAttributes());
		} else {
			return Scopes.scopeFor(((EClass) itr.getType().getEType()).getEAllAttributes());
		}

	}

	protected IScope scopeForGTLEdgeIteratorType(GTLEdgeIterator context, EReference reference) {
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		if (node.eContainer() instanceof SlimRuleNodeCreation)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(
				node.getType().getEAllReferences().stream().filter(ref -> ref.isMany()).collect(Collectors.toList()));
	}

	protected IScope scopeForGTLEdgeIteratorSubType(GTLEdgeIterator context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		return Scopes.scopeFor(SlimGTModelUtil.getClasses(ef).stream()
				.filter(cls -> cls.getEAllSuperTypes().stream()
						.filter(sCls -> sCls.getName().equals(context.getType().getEType().getName())).findAny()
						.isPresent())
				.collect(Collectors.toSet()));
	}

	protected IScope scopeForGTLEdgeIteratorAttributeAssignment(GTLEdgeIteratorAttributeAssignment context,
			EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllCreatedAndContextRuleNodes(rule));
	}

	protected IScope scopeForGTLEdgeIteratorReferenceSource(GTLEdgeIteratorReference context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr == null)
			return IScope.NULLSCOPE;

		if (context.getOperator() == EdgeIteratorOperator.DELETE) {
			return Scopes.scopeFor(List.of(node));
		} else {
			return Scopes.scopeFor(GTLModelUtil.getAllCreatedAndContextRuleNodes(rule));
		}
	}

	protected IScope scopeForGTLEdgeIteratorReferenceType(GTLEdgeIteratorReference context, EReference reference) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr == null)
			return IScope.NULLSCOPE;

		if (context.getOperator() == null)
			return IScope.NULLSCOPE;

		if (context.getSource() == null)
			return IScope.NULLSCOPE;

		if (context.getSource().getType() == null)
			return IScope.NULLSCOPE;

		if (context.getOperator() == EdgeIteratorOperator.CREATE) {
			return Scopes.scopeFor(context.getSource().getType().getEAllReferences());
		} else {
			if (itr.getType() != null) {
				return Scopes.scopeFor(List.of(itr.getType()));
			} else {
				return IScope.NULLSCOPE;
			}
		}

	}

	protected IScope scopeForGTLEdgeIteratorReferenceTarget(GTLEdgeIteratorReference context, EReference reference) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr == null)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(List.of(itr));
	}

	protected IScope scopeForGTLRuleWatchDogNode(GTLRuleWatchDog context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllContextRuleNodes(rule));
	}
}
