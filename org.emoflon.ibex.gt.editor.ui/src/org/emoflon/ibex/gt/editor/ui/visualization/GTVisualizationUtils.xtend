package org.emoflon.ibex.gt.editor.ui.visualization

import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition
import org.emoflon.ibex.gt.editor.gT.EditorApplicationConditionType
import org.emoflon.ibex.gt.editor.gT.EditorCondition
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorParameter
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
		'''«FOR c : conditions SEPARATOR ' **&&** '»«getConditionString(c)»«ENDFOR»'''
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
}
