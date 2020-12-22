package org.emoflon.ibex.tgg.integrate.generator

import com.google.common.collect.ImmutableSet
import org.eclipse.emf.ecore.EClass
import org.emoflon.ibex.tgg.integrate.api.variable.PipelineExecuter
import org.emoflon.ibex.tgg.integrate.api.variable.TypeFilterData
import org.emoflon.ibex.tgg.integrate.integrate.Variable
import org.emoflon.ibex.tgg.integrate.internal.PipelineVisitor
import org.eclipse.emf.common.util.EList

class VariableGenerator {

	def String generate(Variable variable, String pipelineExecutorConstructorCall) {
		val vc = new VariableCompiler(variable, pipelineExecutorConstructorCall)
		vc.compile
	}

	private static class VariableCompiler {

		final Variable variable
		final String executerName;
		String result

		new(Variable variable, String pipelineExecutorConstructorCall) {
			this.variable = variable
			this.executerName = '''«variable.name»Executer'''
		
			this.result = '''«PipelineExecuter.name» «executerName» = «pipelineExecutorConstructorCall»'''
		}

		def String compile() {
			new PipelineVisitor(variable)
				.src[stage|result += '''.src()''']
				.trg[stage|result += '''.trg()''']
				.created[stage|result += '''.created()''']
				.deleted[stage|result += '''.deleted()''']
				.type[stage|result += '''.types(«compileTypes(stage.types)»)''']
				.count[stage|result += ''';int «variable.name» = «executerName».count();''']
				.exists[stage|result += ''';boolean «variable.name» = «executerName».exists();''']
				.visit()

			result
		}
		
		def String compileTypes(EList<EClass> types) {
			val typeFilters = '''
			«FOR type : types SEPARATOR ','»
				new «TypeFilterData.name»("«type.name»", "«type.EPackage.name»")
			«ENDFOR»
			'''
			
			'''«ImmutableSet.name».of(«typeFilters»)'''
		}

	}

}
