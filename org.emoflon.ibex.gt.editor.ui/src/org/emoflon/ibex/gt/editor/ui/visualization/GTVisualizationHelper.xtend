package org.emoflon.ibex.gt.editor.ui.visualization

import org.emoflon.ibex.gt.editor.gT.EditorAndCondition
import org.emoflon.ibex.gt.editor.gT.EditorConditionExpression
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference
import org.emoflon.ibex.gt.editor.gT.EditorEnforce
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorParameter

/**
 * Utility methods to print objects of the editor model.
 */
class GTVisualizationHelper {

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
	 * Returns the conditions of the pattern.
	 */
	public static def String getConditionString(EditorPattern pattern) {
		'''
			«FOR c : pattern.conditions SEPARATOR ' **||** '»
				(«getConditionString(c.expression)»)
			«ENDFOR»
		'''
	}

	/**
	 * Returns the condition.
	 */
	private static def String getConditionString(EditorConditionExpression condition) {
		if (condition instanceof EditorAndCondition) {
			return '''«getConditionString(condition.left)» **&&** «getConditionString(condition.right)»'''
		}
		if (condition instanceof EditorConditionReference) {
			return '''«getConditionString(condition.condition.expression)»'''
		}
		if (condition instanceof EditorEnforce) {
			return '''**enforce** «condition.pattern.name»'''
		}
		if (condition instanceof EditorForbid) {
			return '''**forbid** «condition.pattern.name»'''
		}
		return ""
	}
}
