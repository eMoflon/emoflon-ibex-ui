package org.emoflon.ibex.tgg.integrate.validation

import java.util.HashSet
import org.eclipse.xtext.validation.Check
import org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression
import org.emoflon.ibex.tgg.integrate.integrate.ComparisonExpression
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionSpecification
import org.emoflon.ibex.tgg.integrate.integrate.Integrate
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference
import org.emoflon.ibex.tgg.integrate.internal.MutableValue
import org.emoflon.ibex.tgg.integrate.internal.PipelineVisitor

class IntegrateValidator extends AbstractIntegrateValidator {

	@Check
	def void checkConflictResolutionStrategiesHaveUniqueName(Integrate integrate) {
		val crsNames = new HashSet<String>();
		for (ConflictResolutionSpecification crs : integrate.getConflictResolutionSpecifications()) {
			if (crsNames.contains(crs.getName())) {
				error("Name of conflict resolution strategies must be unique", crs,
					IntegratePackage.Literals.CONFLICT_RESOLUTION_SPECIFICATION__NAME);
			} else {
				crsNames.add(crs.getName());
			}
		}
	}

	@Check
	def void checkVariableReferenceInBooleanExpressionCanBeEvaluedToBoolean(VariableReference vr) {
		if (vr.eContainer instanceof BooleanExpression) {
			val value = MutableValue.of(false)
			new PipelineVisitor(vr.ref).exists[e|value.set(true)].visit()

			if (!value.get) {
				error("Variable cannot be evaluated to a boolean expression", vr, IntegratePackage.Literals.VARIABLE_REFERENCE__REF)
			}
		}
	}
	
	@Check
	def void checkVariableReferenceInComparisonCanBeEvaluatedToNumerical(VariableReference vr) {
		if (vr.eContainer instanceof ComparisonExpression) {
			val value = MutableValue.of(false)
			new PipelineVisitor(vr.ref).count[c|value.set(true)].visit()

			if (!value.get) {
				error("Variable cannot be evaluated to a numerical expression", vr, IntegratePackage.Literals.VARIABLE_REFERENCE__REF)
			}
		}
	}

}
