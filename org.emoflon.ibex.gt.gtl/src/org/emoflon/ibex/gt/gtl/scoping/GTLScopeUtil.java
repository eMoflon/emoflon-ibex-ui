package org.emoflon.ibex.gt.gtl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeAssignment;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;

public final class GTLScopeUtil {
	public static boolean isPatternImportPattern(final EObject context, final EReference reference) {
		return context instanceof PatternImport && reference == GTLPackage.Literals.PATTERN_IMPORT__PATTERN;
	}

	public static boolean isGTLRuleRefinementRule(final EObject context, final EReference reference) {
		return context instanceof GTLRuleRefinement && reference == GTLPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE;
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

	public static boolean isGTLEdgeIteratorAttributeExpressionIterator(final EObject context,
			final EReference reference) {
		return context instanceof GTLEdgeIteratorAttributeExpression
				&& reference == GTLPackage.Literals.GTL_EDGE_ITERATOR_ATTRIBUTE_EXPRESSION__ITERATOR;
	}

	public static boolean isGTLEdgeIteratorAttributeExpressionAttribute(final EObject context,
			final EReference reference) {
		return context instanceof GTLEdgeIteratorAttributeExpression
				&& reference == GTLPackage.Literals.GTL_EDGE_ITERATOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE;
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
}
