package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.integrate.And
import org.emoflon.ibex.tgg.integrate.integrate.Comparison
import org.emoflon.ibex.tgg.integrate.integrate.Or
import org.emoflon.ibex.tgg.integrate.integrate.Predicate
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule
import org.emoflon.ibex.tgg.integrate.integrate.Variable

class SatisfactionRuleGenerator {

	def generate(SatisfactionRule satisfactionRule) {
		val satisfactionRuleCompiler = new SatisfactionRuleCompiler(satisfactionRule)
		satisfactionRuleCompiler.compile()
	}

	private static class SatisfactionRuleCompiler {

		SatisfactionRule satisfactionRule
		String result

		new(SatisfactionRule satisfactionRule) {
			this.satisfactionRule = satisfactionRule
			this.result = ""
		}

		def compile() {
			satisfactionRule.firstRule.compile
			satisfactionRule.otherRules.forEach[rule|rule.compile]
			result
		}

		def compile(Comparison comparison) {
			result += '''«comparison.v1.compile» «comparison.n1.compile» «comparison.c1» «comparison.v2.compile» «comparison.n2.compile»'''
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
	}
}
