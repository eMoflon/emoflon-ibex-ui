package org.emoflon.ibex.tgg.tggl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRule;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMappings;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleSimpleEdge;
import org.emoflon.ibex.tgg.tggl.tGGL.AttributeCondition;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceType;
import org.emoflon.ibex.tgg.tggl.tGGL.Schema;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRuleRefinementNode;

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
		return context instanceof TGGCorrespondenceNode //
				&& reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TYPE;
	}

	public static boolean isCorrespondenceSourceType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType && //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__SOURCE; //
	}

	public static boolean isCorrespondenceTargetType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType && //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__TARGET; //
	}

	public static boolean isCorrespondenceNodeSource(EObject context, EReference reference) {
		return context instanceof TGGCorrespondenceNode && //
				reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__SOURCE;
	}

	public static boolean isCorrespondenceNodeTarget(EObject context, EReference reference) {
		return context instanceof TGGCorrespondenceNode && //
				reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TARGET;
	}

	public static boolean isNodeAttributeExpressionFeature(EObject context, EReference reference) {
		return context instanceof NodeAttributeExpression && //
				reference == SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE;
	}
	
	public static boolean isNodeExpressionNode(EObject context, EReference reference) {
		return (context instanceof SlimRuleAttributeAssignment) && //
				reference == SlimGTPackage.Literals.NODE_EXPRESSION__NODE;
	}

	public static boolean isTGGRuleConditionName(EObject context, EReference reference) {
		return (context instanceof TGGRule || context instanceof AttributeCondition) && //
				reference == TGGLPackage.Literals.ATTRIBUTE_CONDITION__NAME;
	}

	public static boolean isEdgeTargetReference(EObject context, EReference reference) {
		return context instanceof SlimRuleSimpleEdge && //
				(reference == SlimGTPackage.Literals.SLIM_RULE_EDGE__TARGET || //
						reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__SOURCE || //
						reference == TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__TARGET); //
	}

	public static boolean isRuleNodeMappingSource(EObject context, EReference reference) {
		return (context instanceof SlimRuleNodeMappings || //
				context instanceof SlimRuleNodeMapping) && //
				reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__SOURCE; //
	}

	public static boolean isRuleNodeMappingTarget(EObject context, EReference reference) {
		return (context instanceof SlimRuleNodeMappings || //
				context instanceof SlimRuleNodeMapping) && //
				reference == SlimGTPackage.Literals.SLIM_RULE_NODE_MAPPING__TARGET; //
	}

	public static boolean isTGGRuleRefinements(EObject context, EReference reference) {
		return context instanceof TGGRule && //
				reference == TGGLPackage.Literals.TGG_RULE__REFINEMENTS;
	}

	public static boolean isTGGRuleRefinementAliasedSuperRule(EObject context, EReference reference) {
		return context instanceof TGGRule && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT__SUPER_RULE;
	}
	
	public static boolean isSlimRuleRefinements(EObject context, EReference reference) {
		return context instanceof SlimRule && //
				reference == SlimGTPackage.Literals.GTL_RULE_REFINEMENT;
	}

	public static boolean isSlimRuleRefinementAliasedSuperRule(EObject context, EReference reference) {
		return context instanceof SlimRule && //
				reference == SlimGTPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE;
	}

	public static boolean isSlimRuleNodeNode(EObject context, EReference reference) {
		return (context instanceof SlimRule || //
				context instanceof TGGRuleRefinementNode || //
				context instanceof SlimRuleNodeCreation || //
				context instanceof SlimRuleNodeContext) && //
				reference == TGGLPackage.Literals.TGG_RULE_REFINEMENT_NODE__NODE;
	}

	public static boolean isCorrespondenceNodeNode(EObject context, EReference reference) {
		return (context instanceof SlimRule || //
				context instanceof TGGCorrespondenceNodeContext || //
				context instanceof TGGCorrespondenceNodeCreation || //
				context instanceof TGGLRuleRefinementCorrespondenceNode) && //
				reference == TGGLPackage.Literals.TGGL_RULE_REFINEMENT_CORRESPONDENCE_NODE__NODE;
	}
}
