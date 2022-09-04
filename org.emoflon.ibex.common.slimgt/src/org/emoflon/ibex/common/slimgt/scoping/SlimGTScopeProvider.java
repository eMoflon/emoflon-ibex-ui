/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.common.slimgt.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.ibex.common.slimgt.slimGT.EditorFile;
import org.emoflon.ibex.common.slimgt.slimGT.SlimParameter;
import org.emoflon.ibex.common.slimgt.slimGT.impl.EditorFileImpl;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class SlimGTScopeProvider extends AbstractSlimGTScopeProvider {
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			return IScope.NULLSCOPE;
		try {
			return getScopeInternal(context, reference);
		} catch (Exception e) {
			e.printStackTrace();
			return IScope.NULLSCOPE;
		}
	}

	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		if (SlimGTScopeUtil.isSlimParameterType(context, reference)) {
			return scopeForParameterType((SlimParameter) context, reference);
		} else {
			return super.getScope(context, reference);
		}
	}

	protected IScope scopeForParameterType(SlimParameter context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFileImpl.class);
		return Scopes.scopeFor(SlimGTModelUtil.getDatatypes(ef));
	}
}
