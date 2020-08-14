package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionExecuter

class ResolutionGenerator {

	def generate(Resolution resolution) {
		'''
		«IF resolution.fallback === null»
		«ResolutionExecuter.name».execute(
			"«resolution.strategy.name»",
			conflict);
		«ELSE»
		«ResolutionExecuter.name».execute(
			"«resolution.strategy.name»", 
			"«resolution.fallback.name»", 
			conflict);
		«ENDIF»
		'''
	}
}
