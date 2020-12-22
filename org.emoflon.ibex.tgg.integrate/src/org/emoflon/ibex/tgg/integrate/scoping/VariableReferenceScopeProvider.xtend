package org.emoflon.ibex.tgg.integrate.scoping

import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.EcoreUtil2
import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionSpecification

class VariableReferenceScopeProvider {

	def IScope provide(EObject context) {

		val operationalDelta = EcoreUtil2.getContainerOfType(context, OperationalDelta)
		if (operationalDelta !== null) {
			return new SimpleScope(Scopes.scopeFor(operationalDelta.getVariables()),
				Scopes.scopedElementsFor(operationalDelta.getVariables(),
					new DefaultDeclarativeQualifiedNameProvider()));
		}

		val conflictResolutionSpecification = EcoreUtil2.getContainerOfType(context, ConflictResolutionSpecification);
		return new SimpleScope(Scopes.scopeFor(conflictResolutionSpecification.getVariables()),
			Scopes.scopedElementsFor(conflictResolutionSpecification.getVariables(),
				new DefaultDeclarativeQualifiedNameProvider()));

	}

}
