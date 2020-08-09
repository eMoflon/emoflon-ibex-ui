package org.emoflon.ibex.tgg.integrate.generator

import java.util.Set
import language.TGGRuleElement
import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.tgg.integrate.api.variable.PipelineStageExecuter
import org.emoflon.ibex.tgg.integrate.integrate.PipelineCountStage
import org.emoflon.ibex.tgg.integrate.integrate.PipelineCreatedFilterStage
import org.emoflon.ibex.tgg.integrate.integrate.PipelineDeletedFilterStage
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageTrg
import org.emoflon.ibex.tgg.integrate.integrate.PipelineTypeFilterStage
import org.emoflon.ibex.tgg.integrate.integrate.Variable
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter

class VariableGenerator {

	def String generate(Variable variable) {
		val vc = new VariableCompiler(variable)
		vc.compile
	}

	private static class VariableCompiler {

		final Variable variable
		final String variableEltFilterName
		final String variableElementsName

		String result
		boolean isFilterEvaluated

		new(Variable variable) {
			this.variable = variable
			this.variableEltFilterName = '''«variable.name»EltFilter'''
			this.variableElementsName = '''«variable.name»Elements'''
			this.result = ""
			this.isFilterEvaluated = false
		}

		def String compile() {
			val start = variable.pipeline.start
			switch start {
				PipelineStageSrc: start.compile
				PipelineStageTrg: start.compile
			}

			result
		}

		private def void compile(PipelineStageSrc p) {
			result += '''«EltFilter.name» «variableEltFilterName» = «PipelineStageExecuter.name».executeSrc();'''
			compileNext(p.next)
		}

		private def void compile(PipelineStageTrg p) {
			result += '''«EltFilter.name» «variableEltFilterName» = «PipelineStageExecuter.name».executeTrg();'''
			compileNext(p.next)
		}

		private def void compile(PipelineCreatedFilterStage p) {
			result += '''«variableEltFilterName» = «PipelineStageExecuter.name».executeCreatedFilter(«variableEltFilterName»);'''
			compileNext(p.next)
		}

		private def void compile(PipelineDeletedFilterStage p) {
			result += '''«variableEltFilterName» = «PipelineStageExecuter.name».executeDeletedFilter(«variableEltFilterName»);'''
			compileNext(p.next)
		}

		private def void compile(PipelineTypeFilterStage p) {
			withEvaluatedFilter[|
				result += '''«variableElementsName» = «PipelineStageExecuter.name».executeTypeFilter(«variableEltFilterName», «Set.of(p.type)»);'''
			]

			compileNext(p.next)
		}

		private def void compile(PipelineCountStage p) {
			withEvaluatedFilter[|result += '''Integer «variable.name» = «PipelineStageExecuter.name».executeCount(«variableElementsName»);''']
		}

		private def void withEvaluatedFilter(()=>void compile) {
			if (!isFilterEvaluated) {
				result +=
					'''«Set.name»<«TGGRuleElement.name»> «variableElementsName» = «PipelineStageExecuter.name».executeElementFilter(«variableEltFilterName», conflict);'''
				isFilterEvaluated = true
			}

			compile.apply
		}

		private def void compileNext(EObject p) {
			switch p {
				PipelineCreatedFilterStage: p.compile
				PipelineDeletedFilterStage: p.compile
				PipelineTypeFilterStage: p.compile
				PipelineCountStage: p.compile
			}
		}
	}

}
