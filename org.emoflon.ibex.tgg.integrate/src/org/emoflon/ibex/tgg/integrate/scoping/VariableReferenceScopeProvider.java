package org.emoflon.ibex.tgg.integrate.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference;

public class VariableReferenceScopeProvider {
	
	public IScope provide(EObject context) {
		ConflictResolutionStrategy conflictResolutionStrategy = EcoreUtil2.getContainerOfType(context, ConflictResolutionStrategy.class);
		
		return new SimpleScope(Scopes.scopeFor(conflictResolutionStrategy.getVariables()),
				Scopes.scopedElementsFor(conflictResolutionStrategy.getVariables(), new DefaultDeclarativeQualifiedNameProvider()));
	}
}
