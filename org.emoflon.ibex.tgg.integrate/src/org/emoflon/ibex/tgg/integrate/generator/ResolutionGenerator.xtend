package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionChecker
import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import java.util.Optional
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategyWithOperationalDelta

class ResolutionGenerator {

	def generate(Resolution resolution) {
		'''
			«FOR strategyWithOperationalDelta: resolution.strategies»
				«strategyWithOperationalDelta.generate()»
			«ENDFOR»
			
			«IF resolution.fallback !== null»
			if («ResolutionChecker.name».resolutionWillBeExecuted("«resolution.fallback.name»"", conflict)) {
				return «Optional.name».of("«resolution.fallback.name»");
			}
			«ENDIF»
			
			return «Optional.name».empty();
		'''
	}
	
	def generate(ResolutionStrategyWithOperationalDelta strategyWithOperationalDelta) {
		'''
			if («ResolutionChecker.name».resolutionWillBeExecuted("«strategyWithOperationalDelta.strategy.name»", conflict)) {
				return «Optional.name».of("«strategyWithOperationalDelta.strategy.name»");
			}
		'''
	}
	
}
