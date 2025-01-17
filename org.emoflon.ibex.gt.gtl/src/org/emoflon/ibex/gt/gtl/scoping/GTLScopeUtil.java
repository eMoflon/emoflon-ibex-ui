package org.emoflon.ibex.gt.gtl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleCondition;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeAssignment;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementNode;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleWatchDog;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation;

public final class GTLScopeUtil {
	public static boolean isPatternImportPattern(final EObject context, final EReference reference) {
		return context instanceof PatternImport && reference == GTLPackage.Literals.PATTERN_IMPORT__PATTERN;
	}

	public static boolean isGTLRuleRefinementRule(final EObject context, final EReference reference) {
		return (context instanceof SlimRule || context instanceof GTLRuleRefinement)
				&& (reference == GTLPackage.Literals.SLIM_RULE__REFINEMENT
						|| reference == SlimGTPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE);
	}

	public static boolean isGTLRuleRefinementNodeRefinement(final EObject context, final EReference reference) {
		return (context instanceof SlimRule || context instanceof SlimRuleNodeContext
				|| context instanceof SlimRuleNodeCreation || context instanceof GTLRuleNodeDeletion
				|| context instanceof GTLRuleRefinementNode)
				&& (reference == GTLPackage.Literals.GTL_RULE_NODE_DELETION__REFINEMENT
						|| reference == GTLPackage.Literals.SLIM_RULE_NODE_CREATION__REFINEMENT
						|| reference == GTLPackage.Literals.SLIM_RULE_NODE_CONTEXT__REFINEMENT
						|| reference == GTLPackage.Literals.GTL_RULE_REFINEMENT_NODE__SUPER_RULE);
	}

	public static boolean isGTLRuleRefinementNodeNode(final EObject context, final EReference reference) {
		return context instanceof GTLRuleRefinementNode
				&& reference == GTLPackage.Literals.GTL_RULE_REFINEMENT_NODE__REFINEMENT_NODE;
	}

	public static boolean isGTLParameterExpressionParameter(final EObject context, final EReference reference) {
		return context instanceof GTLParameterExpression
				&& reference == GTLPackage.Literals.GTL_PARAMETER_EXPRESSION__PARAMETER;
	}

	public static boolean isGTLEdgeIteratorType(final EObject context, final EReference reference) {
		return context instanceof GTLEdgeIterator && reference == GTLPackage.Literals.GTL_EDGE_ITERATOR__TYPE;
	}

	public static boolean isGTLEdgeIteratorSubType(final EObject context, final EReference reference) {
		return context instanceof GTLEdgeIterator && reference == GTLPackage.Literals.GTL_EDGE_ITERATOR__SUB_TYPE;
	}

	public static boolean isAttributeConditionExpressionNode(EObject context, EReference reference) {
		return context instanceof SlimRuleCondition
				&& reference != SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE;
	}

	public static boolean isAttributeConditionExpressionFeature(EObject context, EReference reference) {
		return context instanceof SlimRuleCondition
				&& reference == SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE;
	}

	public static boolean isIteratorAttributeExpressionFeature(final EObject context, final EReference reference) {
		return context instanceof GTLIteratorAttributeExpression
				&& reference == GTLPackage.Literals.GTL_ITERATOR_ATTRIBUTE_EXPRESSION__FEATURE;
	}

	public static boolean isGTLEdgeIteratorAttributeAssignment(final EObject context) {
		return context instanceof GTLEdgeIteratorAttributeAssignment;
	}

	public static boolean isGTLEdgeIteratorReferenceSource(final EObject context, final EReference reference) {
		return context instanceof GTLEdgeIteratorReference
				&& reference == GTLPackage.Literals.GTL_EDGE_ITERATOR_REFERENCE__SOURCE;
	}

	public static boolean isGTLEdgeIteratorReferenceType(final EObject context, final EReference reference) {
		return context instanceof GTLEdgeIteratorReference
				&& reference == GTLPackage.Literals.GTL_EDGE_ITERATOR_REFERENCE__TYPE;
	}

	public static boolean isGTLEdgeIteratorReferenceTarget(final EObject context, final EReference reference) {
		return context instanceof GTLEdgeIteratorReference
				&& reference == GTLPackage.Literals.GTL_EDGE_ITERATOR_REFERENCE__TARGET;
	}

	public static boolean isGTLRuleWatchDogNode(final EObject context, final EReference reference) {
		return context instanceof GTLRuleWatchDog
				&& reference == GTLPackage.Literals.GTL_RULE_WATCH_DOG__NODE_ATTRIBUTE;
	}
}
