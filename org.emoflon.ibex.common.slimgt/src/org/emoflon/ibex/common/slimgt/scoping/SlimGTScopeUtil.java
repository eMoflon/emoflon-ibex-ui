package org.emoflon.ibex.common.slimgt.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimParameter;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;

public final class SlimGTScopeUtil {
	public static boolean isSlimParameterType(final EObject context, final EReference reference) {
		return context instanceof SlimParameter && reference == SlimGTPackage.Literals.SLIM_PARAMETER__TYPE;
	}

	public static boolean isSlimRuleNodeType(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNode && reference == SlimGTPackage.Literals.SLIM_RULE_NODE__TYPE;
	}
}
