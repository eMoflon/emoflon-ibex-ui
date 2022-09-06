package org.emoflon.ibex.common.slimgt.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.EnumExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimParameter;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;

public final class SlimGTScopeUtil {
	public static boolean isSlimParameterType(final EObject context, final EReference reference) {
		return context instanceof SlimParameter && reference == SlimGTPackage.Literals.SLIM_PARAMETER__TYPE;
	}

	public static boolean isSlimRuleNodeType(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNode && reference == SlimGTPackage.Literals.SLIM_RULE_NODE__TYPE;
	}

	public static boolean isSlimRuleEdgeType(final EObject context, final EReference reference) {
		return context instanceof SlimRuleEdge && reference == SlimGTPackage.Literals.SLIM_RULE_EDGE__TYPE;
	}

	public static boolean isSlimRuleNodeMappingSrc(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNodeMapping
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__SRC_NODE;
	}

	public static boolean isSlimRuleNodeMappingTrg(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNodeMapping
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__TRG_NODE;
	}

	public static boolean isEnumExpressionLiteral(final EObject context, final EReference reference) {
		return context instanceof EnumExpression && reference == SlimGTPackage.Literals.ENUM_EXPRESSION__LITERAL;
	}

	public static boolean isCountExpressionPattern(EObject context, EReference reference) {
		return context instanceof CountExpression
				&& reference == SlimGTPackage.Literals.COUNT_EXPRESSION__INVOKED_PATTEN;
	}
}
