package org.emoflon.ibex.gt.editor.ui.visualization

import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.utils.GTFlattener

/**
 * Utility methods to generate PlantUML code.
 */
class GTPlantUMLGenerator {
	static val ContextColor = 'Black'
	static val CreateColor = 'DarkGreen'
	static val DeleteColor = 'Crimson'

	/**
	 * Returns the PlantUML code for the visualization of an empty file.
	 */
	public static def String visualizeNothing() {
		'''
			title There is nothing to visualize yet.
		'''
	}

	/**
	 * Returns the PlantUML code for the visualization of the given rule.
	 */
	public static def String visualizeRule(Rule rule) {
		val flattenedRule = new GTFlattener(rule).flattenedRule
		'''
			«printCommonLayoutSettings»
			
			skinparam class {
				BackgroundColor<<CONTEXT>> «ContextColor»
				BackgroundColor<<CREATE>> «CreateColor»
				BackgroundColor<<DELETE>> «DeleteColor»
				BorderColor<<CONTEXT>> «ContextColor»
				BorderColor<<CREATE>> «CreateColor»
				BorderColor<<DELETE>> «DeleteColor»
				FontColor White
			}
			
			«FOR node : flattenedRule.nodes»
				class «nodeName(node)» <<«nodeSkin(node)»>>
			«ENDFOR»
			
			«FOR node : flattenedRule.nodes»
				«FOR reference : node.references»
					«nodeName(node)» -[#«referenceColor(reference)»]-> «nodeName(reference.target)»: «referenceLabel(reference)»
				«ENDFOR»
			«ENDFOR»
			
			center footer
				Rule «ruleSignature(flattenedRule)» 
			end footer
		'''
	}

	/**
	 * Returns the name and type name of the node.
	 */
	private static def String nodeName(Node node) {
		if (node === null) {
			return '"?"'
		}
		val type = if(node.type === null) '?' else node.type.name
		'''"«node.name»: «type»"'''
	}

	/**
	 * Returns the skin name for the node.
	 */
	private static def String nodeSkin(Node node) {
		return node.operator.getName
	}

	/**
	 * Returns the color for the reference.
	 */
	private static def String referenceColor(Reference reference) {
		if (reference.operator == Operator.CONTEXT) {
			'''«ContextColor»'''
		} else if (reference.operator === Operator.CREATE) {
			'''«CreateColor»'''
		} else if (reference.operator === Operator.DELETE) {
			'''«DeleteColor»'''
		} else {
			''
		}
	}

	/**
	 * Returns the PlantUML code for the reference label in the color of the reference operator.
	 */
	private static def String referenceLabel(Reference reference) {
		'''<color:«referenceColor(reference)»>«reference.type.name»'''
	}

	/**
	 * Returns the signature (name and parameters) for the rule.
	 */
	private static def String ruleSignature(Rule rule) {
		'''
			«rule.name»«IF rule.parameters.size == 0»()«ENDIF»
			«FOR parameter : rule.parameters BEFORE '(' SEPARATOR ', ' AFTER ')'»«parameterName(parameter)»«ENDFOR»
		'''
	}

	private static def parameterName(Parameter parameter) {
		val type = if(parameter.type === null) '?' else parameter.type.name
		'''«parameter.name»: «type»'''
	}

	/**
	 * Returns the PlantUML code for the visualization of the refinement hierarchy of the given rules.
	 */
	public static def String visualizeRuleHierarchy(EList<Rule> rules) {
		'''
			«printCommonLayoutSettings»
			
			skinparam class {
				BackgroundColor White
				BorderColor Black
				ArrowColor Black
			}
			
			«FOR r : rules»
				«IF r.abstract»abstract«ENDIF» class "«r.name»"
			«ENDFOR»
			
			«FOR r : rules»
				«FOR sup: r.superRules»
					"«r.name»" -up-|> "«sup.name»"
				«ENDFOR»
			«ENDFOR»
			
			center footer Rule Refinement Hierarchy
		'''
	}

	/**
	 * Common settings for all visualizations.
	 */
	private static def String printCommonLayoutSettings() {
		'''
			hide empty members
			hide circle
			hide stereotype
			
			skinparam padding 2
			skinparam shadowing false
		'''
	}
}
