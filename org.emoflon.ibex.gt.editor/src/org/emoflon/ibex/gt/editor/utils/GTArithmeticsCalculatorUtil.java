package org.emoflon.ibex.gt.editor.utils;

import org.emoflon.ibex.gt.editor.gT.AddExpression;
import org.emoflon.ibex.gt.editor.gT.ArithmeticAttribute;
import org.emoflon.ibex.gt.editor.gT.ArithmeticExpression;
import org.emoflon.ibex.gt.editor.gT.ExpExpression;
import org.emoflon.ibex.gt.editor.gT.MinMaxExpression;
import org.emoflon.ibex.gt.editor.gT.MultExpression;
import org.emoflon.ibex.gt.editor.gT.OneParameterArithmetics;

/**
 * Utility class for calculating arithmetic expressions for the GTValidator class
 *
 */
public class GTArithmeticsCalculatorUtil {
	
	/**
	 * Calculates the value of the arithmeticExpression; can only be calculated when the expression
	 * does not have an arithmeticNodeAttribute
	 * 
	 * @param expression the arithmeticexpression
	 * @return the calculation
	 * @throws IllegalArgumentException when the expression has an airhtmeticNodeAttribute
	 */
	public static double getValue(final ArithmeticExpression expression) throws IllegalArgumentException {
		
		if(expression instanceof ArithmeticAttribute) {
			return  ((ArithmeticAttribute) expression).getStaticAttribute();
		}
		if(expression instanceof OneParameterArithmetics) {
			double value = getValue(((OneParameterArithmetics) expression).getExpression());
			double result = 0.0;
			switch(((OneParameterArithmetics) expression).getOperator()) {
				case ABSOLUTE: 		result = Math.abs(value);
									break;
				case BRACKET: 		result = value;
									break;
				case EEXPONENTIAL: 	result = Math.exp(value);
									break;
				case LOGARITHMUS: 	result = Math.log10(value);
									break;
				case NAT_LOG: 		result = Math.log(value);
									break;
				case ROOT: 			result = Math.sqrt(value);
									break;
				case COS: 			result = Math.cos(value);
									break;
				case SIN:			result = Math.sin(value);
									break;
				case TAN: 			result = Math.tan(value);
									break;
			}
			if(((OneParameterArithmetics) expression).isNegative()) return -result;
			else return result;
		}
		if(expression instanceof ExpExpression) {
			double left = getValue(((ExpExpression) expression).getLeft());
			double right = getValue(((ExpExpression) expression).getRight());
			return Math.pow(left, right);
		}
		if(expression instanceof MultExpression) {
			double left = getValue(((MultExpression) expression).getLeft());
			double right = getValue(((MultExpression) expression).getRight());
			switch (((MultExpression) expression).getMultOperator()) {
				case MULTIPLICATION:return left * right;
				case DIVISION: 		return left / right;
				case MODULO: 		return left % right;
			}
		}
		if(expression instanceof AddExpression) {
			double left = getValue(((AddExpression) expression).getLeft());
			double right = getValue(((AddExpression) expression).getRight());
			switch(((AddExpression) expression).getAddOperator()) {
				case ADDITION: return left + right;
				case SUBTRACTION: return left - right;
			}
		}
		if(expression instanceof MinMaxExpression) {
			double left = getValue(((MinMaxExpression) expression).getLeft());
			double right = getValue(((MinMaxExpression) expression).getRight());
			switch(((MinMaxExpression) expression).getMinMaxOperator()) {
				case MAX: return Math.max(left, right);
				case MIN: return Math.min(left, right);
			}
		}
		// if the expression is an arithmeticNodeAttribute it can't be calculated for the validator
		throw new IllegalArgumentException("The ArithmeticExpression has an arithmeticNodeAttribute");
	}
}
