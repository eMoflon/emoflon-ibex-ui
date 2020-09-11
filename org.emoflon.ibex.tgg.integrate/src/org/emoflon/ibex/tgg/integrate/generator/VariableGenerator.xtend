package org.emoflon.ibex.tgg.integrate.generator

import java.util.Set
import org.emoflon.ibex.tgg.integrate.api.variable.PipelineStageExecuter
import org.emoflon.ibex.tgg.integrate.integrate.Variable
import org.emoflon.ibex.tgg.integrate.internal.PipelineVisitor

class VariableGenerator {

	def String generate(Variable variable) {
		val vc = new VariableCompiler(variable)
		vc.compile
	}

	private static class VariableCompiler {

		final Variable variable
		final String executerName;
		String result

		new(Variable variable) {
			this.variable = variable
			this.executerName = '''«variable.name»Executer'''
			this.result = '''«PipelineStageExecuter.name» «executerName» = new «PipelineStageExecuter.name»(conflict)'''
		}

		def String compile() {
			new PipelineVisitor(variable)
				.src[_|result += '''.src()''']
				.trg[_|result += '''.trg()''']
				.created[_|result += '''.created()''']
				.deleted[_|result += '''.deleted()''']
				.type[p|result += '''.types(«Set.name».of("«p.type.name»"))''']
				.count[_|result += ''';int «variable.name» = «executerName».count();''']
				.exists[_|result += ''';boolean «variable.name» = «executerName».exists();''']
				.visit()

			result
		}

	}

}
