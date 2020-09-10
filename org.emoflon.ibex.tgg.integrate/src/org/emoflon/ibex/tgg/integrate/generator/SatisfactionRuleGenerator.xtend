package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule
import org.emoflon.ibex.tgg.integrate.integrate.OrExpression
import org.emoflon.ibex.tgg.integrate.integrate.ComparisonExpression
import org.emoflon.ibex.tgg.integrate.integrate.LiteralValue
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference
import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionChecker
import org.emoflon.ibex.tgg.integrate.integrate.AndExpression
import org.emoflon.ibex.tgg.integrate.integrate.WrappedOrExpression

class SatisfactionRuleGenerator {

	def generate(SatisfactionRule satisfactionRule, Resolution resolution) {
		val satisfactionRuleCompiler = new SatisfactionRuleCompiler(satisfactionRule, resolution)
		satisfactionRuleCompiler.compile()
	}

	private static class SatisfactionRuleCompiler {

		SatisfactionRule satisfactionRule
		Resolution resolution
		String result

		new(SatisfactionRule satisfactionRule, Resolution resolution) {
			this.satisfactionRule = satisfactionRule
			this.resolution = resolution
			this.result = ""
		}

		def compile() {
			compileNext(satisfactionRule.expression)
			result
		}
		
		def void compile(WrappedOrExpression e) {
			result += '''('''
			compileNext(e.expression)
			result += ''')'''
		}

		def void compile(OrExpression e) {
			compileNext(e.left)
			result += '''||'''
			e.right.forEach[r | compileNext(r)]
		}

		def void compile(AndExpression e) {
			compileNext(e.left)
			result += '''&&'''
			e.right.forEach[r | compileNext(r)]
		}

		def void compile(ComparisonExpression e) {
			compileNext(e.lhs)
			result += e.op
			compileNext(e.rhs)
		}

		def void compile(LiteralValue lv) {
			result += '''«lv.value»'''
		}

		def void compile(VariableReference vr) {
			result += '''«vr.ref.name»'''
		}

		def void compileNext(EObject next) {
			switch (next) {
				WrappedOrExpression: next.compile
				OrExpression: next.compile
				AndExpression: next.compile
				ComparisonExpression: next.compile
				LiteralValue: next.compile
				VariableReference: next.compile
			}
		}

		def compileResolutionCheck() {
			result += '''&& 
				«IF resolution.fallback === null»
					«ResolutionChecker.name».resolutionWillBeExecuted(
										"«resolution.strategy.name»",
										conflict)
				«ELSE»
					«ResolutionChecker.name».anyResolutionWillBeExecuted(
						"«resolution.strategy.name»", 
						"«resolution.fallback.name»", 
						conflict)
				«ENDIF»
			'''
		}
	}
}
