package org.emoflon.ibex.tgg.integrate.generator

import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.tgg.integrate.integrate.AndExpression
import org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression
import org.emoflon.ibex.tgg.integrate.integrate.ComparisonExpression
import org.emoflon.ibex.tgg.integrate.integrate.LiteralValue
import org.emoflon.ibex.tgg.integrate.integrate.OrExpression
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference
import org.emoflon.ibex.tgg.integrate.integrate.WrappedOrExpression

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
		
		def void compile(BooleanExpression e) {
			compileNext(e.expression)
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
				BooleanExpression: next.compile
				ComparisonExpression: next.compile
				LiteralValue: next.compile
				VariableReference: next.compile
			}
		}
	}
}
