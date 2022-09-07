package org.emoflon.ibex.tgg.tggl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.tgg.tggl.tGGL.CorrespondenceType;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;

public class TGGLScopeUtil {

	public static boolean isNodeType(EObject context, EReference reference) {
		return context instanceof SlimRuleNode //
				&& reference == SlimGTPackage.Literals.SLIM_RULE_NODE__TYPE; //
	}
	
	public static boolean isCorrespondenceSourceType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType &&  //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__SOURCE; //
	}
	
	public static boolean isCorrespondenceTargetType(EObject context, EReference reference) {
		return context instanceof CorrespondenceType &&  //
				reference == TGGLPackage.Literals.CORRESPONDENCE_TYPE__TARGET; //
	}
	
	public static boolean isEdgeTargetReference(EObject context, EReference reference) {
		return context instanceof SlimRuleEdge && //
				(reference == SlimGTPackage.Literals.SLIM_RULE_EDGE__TARGET || //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__SOURCE || //
				reference == TGGLPackage.Literals.CORRESPONDENCE_NODE__TARGET); //
	}
}
