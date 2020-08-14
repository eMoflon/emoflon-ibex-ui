package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionChecker
import org.emoflon.ibex.tgg.integrate.integrate.And
import org.emoflon.ibex.tgg.integrate.integrate.Comparison
import org.emoflon.ibex.tgg.integrate.integrate.Or
import org.emoflon.ibex.tgg.integrate.integrate.Predicate
import org.emoflon.ibex.tgg.integrate.integrate.Resolution
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule
import org.emoflon.ibex.tgg.integrate.integrate.Variable

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
			satisfactionRule.firstRule.compile
			satisfactionRule.otherRules.forEach[rule|rule.compile]
			compileResolutionCheck
			result
		}

		def compile(Comparison comparison) {
			result +=
				'''«comparison.v1.compile» «comparison.n1.compile» «comparison.c1» «comparison.v2.compile» «comparison.n2.compile»'''
		}

		def String compile(Variable v) {
			return '''«IF v !== null»«v.name»«ENDIF»'''
		}

		def String compile(Integer n) {
			return '''«IF n !== null»«n.intValue»«ENDIF»'''
		}

		def compile(Predicate p) {
			switch p {
				And: p.compile
				Or: p.compile
			}
		}

		def compile(And and) {
			result += "&&"
			and.comparison.compile
		}

		def compile(Or or) {
			result += "||"
			or.comparison.compile
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
