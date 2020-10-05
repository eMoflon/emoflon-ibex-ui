package org.emoflon.ibex.tgg.integrate.generator

import com.google.common.collect.ImmutableSet
import org.eclipse.emf.ecore.EClass
import org.emoflon.ibex.tgg.integrate.api.variable.PipelineStageExecuter
import org.emoflon.ibex.tgg.integrate.api.variable.TypeFilterData
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
				.src[stage|result += '''.src()''']
				.trg[stage|result += '''.trg()''']
				.created[stage|result += '''.created()''']
				.deleted[stage|result += '''.deleted()''']
				.type[stage|result += '''.types(«compileTypes(stage.type)»)''']
				.count[stage|result += ''';int «variable.name» = «executerName».count();''']
				.exists[stage|result += ''';boolean «variable.name» = «executerName».exists();''']
				.visit()

			result
		}
		
		def String compileTypes(EClass eClass) {
			'''«ImmutableSet.name».of(new «TypeFilterData.name»("«eClass.name»", "«eClass.EPackage.name»"))'''
		}

	}

}
