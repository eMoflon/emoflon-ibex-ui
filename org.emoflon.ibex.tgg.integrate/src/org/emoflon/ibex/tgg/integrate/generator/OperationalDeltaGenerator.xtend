package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta
import com.google.inject.Inject
import org.emoflon.ibex.tgg.integrate.api.variable.OperationalDeltaPipelineExecuter
import java.util.Optional

class OperationalDeltaGenerator {

	@Inject
	VariableGenerator variableGenerator
	
	@Inject
	SatisfactionRuleGenerator satisfactionRuleGenerator

	def generate(OperationalDelta operationalDelta, String strategyName) {
		'''
		«FOR variable : operationalDelta.variables»
			«variableGenerator.generate(variable, '''new «OperationalDeltaPipelineExecuter.name»(conflict, "«strategyName»")''')»
		«ENDFOR»
		boolean satisfiesOperationalDelta = «satisfactionRuleGenerator.generate(operationalDelta.rule)»;
		
		if (satisfiesOperationalDelta) {
			return «Optional.name».of("«strategyName»");
		}
		'''
	}

}