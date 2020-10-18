package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionChecker
import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import java.util.Optional

class ResolutionGenerator {

	def generate(Resolution resolution) {
		'''
			if («ResolutionChecker.name».resolutionWillBeExecuted("«resolution.strategy.name»", conflict)) {
				return «Optional.name».of("«resolution.strategy.name»");
			}
			
			«IF resolution.fallback !== null»
			if («ResolutionChecker.name».resolutionWillBeExecuted("«resolution.fallback.name»"", conflict)) {
				return «Optional.name».of("«resolution.strategy.name»");
			}
			«ENDIF»
			
			return «Optional.name».empty();
		'''
	}
}
