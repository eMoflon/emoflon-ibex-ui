package org.emoflon.ibex.tgg.tggl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceType;
import org.emoflon.ibex.tgg.tggl.tGGL.Schema;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;

public class TGGLScopeUtil {

	public static boolean isSchemaSourceTypes(EObject context, EReference reference) {
		return context instanceof Schema && //
				reference == TGGLPackage.Literals.SCHEMA__SOURCE_TYPES;
	}
	
	public static boolean isSchemaTargetTypes(EObject context, EReference reference) {
		return context instanceof Schema && //
				reference == TGGLPackage.Literals.SCHEMA__TARGET_TYPES;
	}
	
	public static boolean isSlimRuleNodeType(EObject context, EReference reference) {
		return context instanceof SlimRuleNode //
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE__TYPE; //
	}
	
	public static boolean isCorrespondenceTypeSuper(EObject context, EReference reference) {
		return context instanceof CorrespondenceType //
				&& reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__SUPER;
	}
	
	public static boolean isCorrespondenceNodeType(EObject context, EReference reference) {
		return context instanceof CorrespondenceNode //
				&& reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TYPE;
	}
	
	public static boolean isCorrespondenceSourceType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType &&  //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__SOURCE; //
	}
	
	public static boolean isCorrespondenceTargetType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType &&  //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__TARGET; //
	}
	
	public static boolean isCorrespondenceNodeSource(EObject context, EReference reference) {
		return context instanceof CorrespondenceNode && //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__SOURCE;
	}
	
	public static boolean isCorrespondenceNodeTarget(EObject context, EReference reference) {
		return context instanceof CorrespondenceNode && //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET;
	}
	
	public static boolean isEdgeTargetReference(EObject context, EReference reference) {
		return context instanceof SlimRuleEdge && //
				(reference == SlimGTPackage.Literals.SLIM_RULE_EDGE__TARGET || //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__SOURCE || //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET); //
	}
	
	public static boolean isRuleNodeMappingSource(EObject context, EReference reference) {
		return context instanceof SlimRuleNodeMapping && //
				reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__SRC_NODE; //
	}
	
	public static boolean isRuleNodeMappingTarget(EObject context, EReference reference) {
		return context instanceof SlimRuleNodeMapping && //
				reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__TRG_NODE; //
	}
	
	public static boolean isTGGRuleRefinements(EObject context, EReference reference) {
		return context instanceof TGGRule && //
				reference == TGGLPackage.Literals.TGG_RULE__REFINEMENTS;
	}
	
	public static boolean isTGGRuleRefinementAliasedSuperRule(EObject context, EReference reference) {
		return context instanceof TGGRule && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT_ALIASED__SUPER_RULE;
	}
	
	public static boolean isTGGRuleRefinementPlainName(EObject context, EReference reference) {
		return context instanceof TGGRule && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT_PLAIN__SUPER_RULE;
	}
	
	public static boolean isTGGRuleRefinmentNodeRefinement(EObject context, EReference reference) {
		return context instanceof TGGLRuleRefinementNode && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT_NODE__REFINEMENT;
	}
	
	public static boolean isTGGRuleRefinmentNodeNode(EObject context, EReference reference) {
		return context instanceof TGGLRuleRefinementNode && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT_NODE__NODE;
	}
}
