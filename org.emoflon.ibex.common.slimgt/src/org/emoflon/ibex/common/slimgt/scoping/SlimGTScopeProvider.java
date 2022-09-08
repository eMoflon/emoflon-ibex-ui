/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.common.slimgt.scoping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.ibex.common.slimgt.slimGT.EditorFile;
import org.emoflon.ibex.common.slimgt.slimGT.EnumExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimParameter;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class SlimGTScopeProvider extends AbstractSlimGTScopeProvider {

	protected Map<Resource, Map<URI, Resource>> resourceCache = new HashMap<>();

	protected Resource loadResource(final Resource requester, final URI gtModelUri) {
		Map<URI, Resource> cache = resourceCache.get(requester);
		if (cache == null) {
			cache = new HashMap<>();
			resourceCache.put(requester, cache);
		}

		Resource other = cache.get(gtModelUri);
		if (other == null) {
			XtextResourceSet rs = new XtextResourceSet();
			try {
				other = rs.getResource(gtModelUri, true);
			} catch (Exception e) {
				return other;
			}
			cache.put(gtModelUri, other);

			if (other == null)
				return other;

			EcoreUtil2.resolveLazyCrossReferences(other, () -> false);
		}

		return other;
	}

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			return IScope.NULLSCOPE;
		try {
			return getScopeInternal(context, reference);
		}
		catch(NullPointerException e) {
			return IScope.NULLSCOPE;
		}
		catch(Exception e) {
			e.printStackTrace();
			return IScope.NULLSCOPE;
		}
	}

	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		if (SlimGTScopeUtil.isSlimParameterType(context, reference)) {
			return scopeForParameterType((SlimParameter) context, reference);
		} else if (SlimGTScopeUtil.isSlimRuleNodeType(context, reference)) {
			return scopeForSlimRuleNodeType((SlimRuleNode) context, reference);
		} else if (SlimGTScopeUtil.isSlimRuleEdgeType(context, reference)) {
			return scopeForSlimEdgeType((SlimRuleEdge) context, reference);
		} else if (SlimGTScopeUtil.isEnumExpressionLiteral(context, reference)) {
			return scopeForEnumExpressionLiteral((EnumExpression) context, reference);
		} else if (SlimGTScopeUtil.isSlimRuleAttributeAssignmentType(context, reference)) {
			return scopeForlimRuleAttributeAssignmentType((SlimRuleAttributeAssignment) context, reference);
		} else {
			return super.getScope(context, reference);
		}
	}

	protected IScope scopeForParameterType(SlimParameter context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		return Scopes.scopeFor(SlimGTModelUtil.getDatatypes(ef));
	}

	protected IScope scopeForSlimRuleNodeType(SlimRuleNode context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		return Scopes.scopeFor(SlimGTModelUtil.getClasses(ef));
	}

	protected IScope scopeForSlimEdgeType(SlimRuleEdge context, EReference reference) {
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		return Scopes.scopeFor(node.getType().getEAllReferences());
	}

	protected IScope scopeForEnumExpressionLiteral(EnumExpression context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		return Scopes.scopeFor(SlimGTModelUtil.getEnums(ef));
	}

	protected IScope scopeForlimRuleAttributeAssignmentType(SlimRuleAttributeAssignment context, EReference reference) {
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		return Scopes.scopeFor(node.getType().getEAllAttributes());
	}

}
