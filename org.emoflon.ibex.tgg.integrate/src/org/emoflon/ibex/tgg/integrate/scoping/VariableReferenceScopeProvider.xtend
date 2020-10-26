package org.emoflon.ibex.tgg.integrate.scoping

import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.EcoreUtil2
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy
import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta

class VariableReferenceScopeProvider {

	def IScope provide(EObject context) {

		val operationalDelta = EcoreUtil2.getContainerOfType(context, OperationalDelta)
		if (operationalDelta !== null) {
			return new SimpleScope(Scopes.scopeFor(operationalDelta.getVariables()),
				Scopes.scopedElementsFor(operationalDelta.getVariables(),
					new DefaultDeclarativeQualifiedNameProvider()));
		}

		val conflictResolutionStrategy = EcoreUtil2.getContainerOfType(context, ConflictResolutionStrategy);
		return new SimpleScope(Scopes.scopeFor(conflictResolutionStrategy.getVariables()),
			Scopes.scopedElementsFor(conflictResolutionStrategy.getVariables(),
				new DefaultDeclarativeQualifiedNameProvider()));

	}

}
