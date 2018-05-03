package org.emoflon.ibex.gt.editor.ui.visualization

import org.emoflon.ibex.gt.editor.gT.EditorConditionReference
import org.emoflon.ibex.gt.editor.gT.EditorEnforce
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorSimpleCondition
import java.util.List

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
	 * Returns a String representation of the conditions (alternatives) of the pattern.
	 */
	public static def String getConditionString(EditorPattern pattern) {
		'''
			«FOR c : pattern.conditions SEPARATOR ' **||** '»
				«getConditionString(c.conditions)»
			«ENDFOR»
		'''
	}

	/**
	 * Returns a String representation of the simple conditions.
	 */
	public static def String getConditionString(List<EditorSimpleCondition> conditions) {
		'''«FOR c : conditions SEPARATOR ' **&&** '»«getConditionString(c)»«ENDFOR»'''
	}

	/**
	 * Returns a String representation of the simple condition.
	 */
	private static def String getConditionString(EditorSimpleCondition condition) {
		if (condition instanceof EditorConditionReference) {
			return '''«getConditionString(condition.condition.conditions)»'''
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
