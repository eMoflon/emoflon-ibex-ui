/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class IntegrateScopeProvider extends AbstractIntegrateScopeProvider {

	@Inject
	private PipelineTypeFilterScopeProvider pipelineTypeFilterScopeProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == IntegratePackage.Literals.PIPELINE_STAGE_TYPE__TYPE) {
			return pipelineTypeFilterScopeProvider.provide((PipelineStageType)context);
		}
		
		return super.getScope(context, reference);
	}

}
