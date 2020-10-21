package org.emoflon.ibex.gt.editor.ui.visualization

import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition
import org.emoflon.ibex.gt.editor.gT.EditorApplicationConditionType
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorCondition
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorExpression
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.utils.GTConditionHelper
import org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression
import org.emoflon.ibex.gt.editor.gT.ArithmeticExpression
import org.emoflon.ibex.gt.editor.gT.ArithmeticCalculationExpression
import org.emoflon.ibex.gt.editor.gT.AddExpression
import org.emoflon.ibex.gt.editor.gT.MultExpression
import org.emoflon.ibex.gt.editor.gT.ExpExpression
import org.emoflon.ibex.gt.editor.gT.MinMaxExpression
import org.emoflon.ibex.gt.editor.gT.OneParameterArithmetics
import org.emoflon.ibex.gt.editor.gT.AddOperator
import org.emoflon.ibex.gt.editor.gT.MultOperator
import org.emoflon.ibex.gt.editor.gT.MinMaxOperator
import org.emoflon.ibex.gt.editor.gT.AllOneParameterOperators
import org.emoflon.ibex.gt.editor.gT.EditorCountExpression
import org.emoflon.ibex.gt.editor.gT.PossibleStochasticRanges
import org.emoflon.ibex.gt.editor.gT.StochasticDistribution
import org.emoflon.ibex.gt.editor.gT.EditorProbability
import org.emoflon.ibex.gt.editor.gT.StochasticFunction

/**
 * Utility methods to print objects of the editor model.
 */
class GTVisualizationUtils {
	
	/**
	 * Returns the signature of the pattern.
	 */
	static def String signature(EditorPattern pattern) {
		'''«FOR parameter : pattern.parameters BEFORE '(' SEPARATOR ', ' AFTER ')'»«parameterDeclaration(parameter)»«ENDFOR»'''
	}

	/**
	 * Returns the parameter declaration. 
	 */
	private static def parameterDeclaration(EditorParameter parameter) {
		val type = if(parameter.type === null) '?' else parameter.type.name
		'''«parameter.name»: «type»'''
	}

	/**
	 * Returns a String representation of the conditions (alternatives) of the pattern.
	 */
	static def String getConditionString(EditorPattern pattern) {
		'''
			«FOR c : pattern.conditions SEPARATOR ' **||** '»
				«getConditionString(c)»
			«ENDFOR»
		'''
	}

	/**
	 * Returns a String representation of the flattened clauses of the condition.
	 */
	static def String getConditionString(EditorCondition condition) {
		val conditions = new GTConditionHelper(condition).getApplicationConditions()
		if (conditions.size == 1) {
			return getConditionString(conditions.get(0))
		}
		'''(«FOR c : conditions SEPARATOR ' **&&** '»«getConditionString(c)»«ENDFOR»)'''
	}

	/**
	 * Returns a String representation of the application condition.
	 */
	private static def String getConditionString(EditorApplicationCondition condition) {
		if (condition.type == EditorApplicationConditionType.POSITIVE) {
			return '''**enforce** «condition.pattern.name»'''
		}
		if (condition.type == EditorApplicationConditionType.NEGATIVE) {
			return '''**forbid** «condition.pattern.name»'''
		}
		return ""
	}
	
	static def String toString(EditorProbability probability) {
		if(probability instanceof ArithmeticExpression) {
			return toString(probability)
		} else {
			val sf = probability as StochasticFunction
			if(sf.functionExpression === null)
				return ''
			
			return '''«toString(sf.functionExpression)»«IF sf.parameter !== null», param: («toString(sf.parameter)»)«ENDIF»'''
		}
	}

	/**
	 * Returns a String representation of the expression.
	 */
	static def String toString(EditorExpression expression) {
		if (expression === null) {
			return 'INVALID expression'
		}
		
		if (expression instanceof EditorEnumExpression) {
			return toString(expression)
		} else if (expression instanceof EditorParameterExpression) {
			if (expression.parameter === null) {
				return 'unknown parameter'
			}
			return '''«expression.parameter.name»'''
		} else if (expression instanceof StochasticFunctionExpression) {
			return '''«IF expression.operatorRange != PossibleStochasticRanges.NEUTRAL»«toString(expression.operatorRange)»«ENDIF»«toString(expression.distribution)»(«toString(expression.mean)»«IF expression.hasSd», «toString(expression.sd)»«ENDIF»)'''
		} else {
			return toString((expression as ArithmeticCalculationExpression).expression)
		}	
	}
	
	static def String toString(ArithmeticExpression expression) {
		if(expression === null)
			return ''
			
		if(expression instanceof AddExpression) {
			val ae = expression
			return '''«toString(ae.left)» «toString(ae.addOperator)» «toString(ae.right)»'''
		} else if(expression instanceof MultExpression) {
			val me = expression
			return '''«toString(me.left)» «toString(me.multOperator)» «toString(me.right)»'''
		} else if(expression instanceof ExpExpression) {
			val ee = expression
			return '''«toString(ee.left)» ^ «toString(ee.right)»'''
		} else if(expression instanceof MinMaxExpression) {
			val mme = expression
			return '''«toString(mme.minMaxOperator)»(«toString(mme.left)», «toString(mme.right)»)'''
		} else if(expression instanceof OneParameterArithmetics) {
			val opa = expression
			return '''«IF opa.isNegative»-«ENDIF»«IF opa.operator!=AllOneParameterOperators.BRACKET»«toString(opa.operator)»«ENDIF»(«toString(opa.expression)»)'''
		} else if(expression instanceof EditorLiteralExpression) { // Arithmetic Attribute -> EditorLiteralExpression
			return '''«expression.value.toString»'''
		} else if(expression instanceof EditorAttributeExpression) { // Arithmetic Attribute -> EditorAttributeExpression
			val nodeName = if(expression.node === null) '?' else expression.node.name
			val attributeName = if(expression.attribute === null) '?' else expression.attribute.name
			return '''«nodeName».«attributeName»'''
		} else { // Arithmetic Attribute -> EditorCountExpression
			val ece = expression as EditorCountExpression
			return '''count(«ece.invokedPatten.name»)'''
		}
	}
	
	static def String toString(AddOperator operator) {
		switch(operator) {
			case ADDITION: {
				return '+'
			}
			case SUBTRACTION: {
				return '-'
			}
		}
	}
	
	static def String toString(MultOperator operator) {
		switch(operator) {
			case DIVISION: {
				return '/'
			}
			case MODULO: {
				return '%'
			}
			case MULTIPLICATION: {
				return '*'
			}
			
		}
	}
		
	static def String toString(MinMaxOperator operator) {
		switch(operator) {
			case MAX: {
				return 'max'
			}
			case MIN: {
				return 'min'
			}
		}
	}
	
	static def String toString(AllOneParameterOperators operator) {
		switch(operator) {
			case ABSOLUTE: {
				return 'abs'
			}
			case BRACKET: {
				return ''
			}
			case COS: {
				return 'cos'
			}
			case EEXPONENTIAL: {
				return 'exp'
			}
			case LOGARITHMUS: {
				return 'log'
			}
			case NAT_LOG: {
				return 'ln'
			}
			case ROOT: {
				return 'sqrt'
			}
			case SIN: {
				return 'sin'
			}
			case TAN: {
				return 'tan'
			}

		}
	}
	
	static def String toString(PossibleStochasticRanges operator) {
		switch(operator) {
			case NEGATIVE: {
				return '-'
			}
			case NEUTRAL: {
				return ''
			}
			case POSITIVE: {
				return '+'
			}
		}
	}
	
	static def String toString(StochasticDistribution operator) {
		switch(operator) {
			case EXPONENTIAL: {
				return 'Exp'
			}
			case NORMAL: {
				return 'N'
			}
			case UNIFORM: {
				return 'U'
			}

		}
	}

	private static def String toString(EditorEnumExpression expression) {
		if (expression.literal === null) {
			return ''
		}
		val literal = expression.literal.literal
		if (literal !== null && !literal.isEmpty) {
			return literal
		}
		val name = expression.literal.name
		if (name !== null && !name.isEmpty) {
			return name
		}
	}
}
