package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionChecker
import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import java.util.Optional
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategyWithOperationalDelta
import com.google.inject.Inject

class ResolutionGenerator {

	@Inject
	OperationalDeltaGenerator operationalDeltaGenerator

	def generate(Resolution resolution) {
		'''
			«FOR strategyWithOperationalDelta : resolution.strategies»
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
		val strategyName = strategyWithOperationalDelta.strategy.name
		
		'''
			if («ResolutionChecker.name».resolutionWillBeExecuted("«strategyWithOperationalDelta.strategy.name»", conflict)) {
				«IF strategyWithOperationalDelta.operationalDelta !== null»
					«operationalDeltaGenerator.generate(
						strategyWithOperationalDelta.operationalDelta, 
						strategyName
					)»
				«ELSE»
					return «Optional.name».of("«strategyName»");
				«ENDIF»
				
			}
		'''
	}

}
