package org.emoflon.ibex.tgg.integrate.validation

import java.util.HashSet
import org.eclipse.xtext.validation.Check
import org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression
import org.emoflon.ibex.tgg.integrate.integrate.ComparisonExpression
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy
import org.emoflon.ibex.tgg.integrate.integrate.Integrate
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference
import org.emoflon.ibex.tgg.integrate.internal.MutableValue
import org.emoflon.ibex.tgg.integrate.internal.PipelineVisitor

class IntegrateValidator extends AbstractIntegrateValidator {

	/*@Check
	def void checkFallbackStrategyIsProvided(Resolution resolution) {
		val strategy = resolution.getStrategy();
		val fallback = resolution.getFallback();
		if (strategy !== null && strategyNeedsFallback(strategy.getName()) && fallback === null) {
			error("Chosen resolution strategy needs a fallback strategy", strategy,
				IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME);
		}
	}

	private def boolean strategyNeedsFallback(String strategyName) {
		return ConflictResolutionStrategyRegistry.RESOLUTION_STRATEGY_NAMES.contains(strategyName);
	}

	@Check
	def void checkFallbackStrategyWillNeverBeExecuted(Resolution resolution) {
		val strategy = resolution.getStrategy();
		val fallback = resolution.getFallback();
		if (strategy !== null && strategyIsFallback(strategy.getName()) && fallback !== null) {
			warning("Fallback strategy will never be executed", fallback,
				IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME);
		}
	}

	private def boolean strategyIsFallback(String strategyName) {
		return ConflictResolutionStrategyRegistry.FALLBACK_STRATEGY_NAMES.contains(strategyName);
	}*/

	@Check
	def void checkConflictResolutionStrategiesHaveUniqueName(Integrate integrate) {
		val crsNames = new HashSet<String>();
		for (ConflictResolutionStrategy crs : integrate.getConflictResolutionStrategies()) {
			if (crsNames.contains(crs.getName())) {
				error("Name of conflict resolution strategies must be unique", crs,
					IntegratePackage.Literals.CONFLICT_RESOLUTION_STRATEGY__NAME);
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
