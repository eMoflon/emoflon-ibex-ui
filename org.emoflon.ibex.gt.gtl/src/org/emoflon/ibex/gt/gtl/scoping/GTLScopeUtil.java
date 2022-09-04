package org.emoflon.ibex.gt.gtl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;

public final class GTLScopeUtil {
	public static boolean isPatternImportPattern(final EObject context, final EReference reference) {
		return context instanceof PatternImport && reference == GTLPackage.Literals.PATTERN_IMPORT__PATTERN;
	}

	public static boolean isGTLRuleRefinementRule(final EObject context, final EReference reference) {
		return context instanceof GTLRuleRefinement && reference == GTLPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE;
	}

	public static boolean isSlimRuleNodeMappingSrc(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNodeMapping
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__SRC_NODE;
	}

	public static boolean isSlimRuleNodeMappingTrg(final EObject context, final EReference reference) {
		return context instanceof SlimRuleNodeMapping
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__TRG_NODE;
	}
}
