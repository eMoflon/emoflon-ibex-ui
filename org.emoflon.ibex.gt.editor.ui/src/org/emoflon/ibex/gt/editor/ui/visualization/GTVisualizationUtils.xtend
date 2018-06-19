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


/**
 * Utility methods to print objects of the editor model.
 */
class GTVisualizationUtils {
	
	/**
	 * Returns the signature of the pattern.
	 */
	public static def String signature(EditorPattern pattern) {
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
	public static def String getConditionString(EditorPattern pattern) {
		'''
			«FOR c : pattern.conditions SEPARATOR ' **||** '»
				«getConditionString(c)»
			«ENDFOR»
		'''
	}

	/**
	 * Returns a String representation of the flattened clauses of the condition.
	 */
	public static def String getConditionString(EditorCondition condition) {
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

	/**
	 * Returns a String representation of the expression.
	 */
	public static def String toString(EditorExpression expression) {
		if (expression === null) {
			return 'INVALID expression'
		}
		if (expression instanceof EditorAttributeExpression) {
			val nodeName = if(expression.node === null) '?' else expression.node.name
			val attributeName = if(expression.attribute === null) '?' else expression.attribute.name
			return '''«nodeName».«attributeName»'''
		}
		if (expression instanceof EditorEnumExpression) {
			return toString(expression)
		}
		if (expression instanceof EditorLiteralExpression) {
			return '''«expression.value.toString»'''
		}
		if (expression instanceof EditorParameterExpression) {
			if (expression.parameter === null) {
				return 'unknown parameter'
			}
			return '''«expression.parameter.name»'''
		}
		return '''«expression.toString»'''
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
