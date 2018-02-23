package org.emoflon.ibex.gt.editor.ui.visualization

import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.ContextNode
import org.emoflon.ibex.gt.editor.gT.ContextReference
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.OperatorNode
import org.emoflon.ibex.gt.editor.gT.OperatorReference
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule

/**
 * Utility methods to generate PlantUML code.
 */
class GTPlantUMLGenerator {
	static val ContextColor = 'Black'
	static val CreateColor = 'DarkGreen'
	static val DeleteColor = 'Red'

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
			
			«FOR node : rule.nodes»
				class «nodeClassName(node)» <<«nodeSkin(node)»>>
			«ENDFOR»
			
			«FOR node : rule.nodes»
				«FOR reference : node.constraints.filter[it instanceof Reference].map[it as Reference]»
					«nodeClassName(node)» -[#«referenceColor(reference)»]-> «nodeClassName(reference.target)»: <color:«referenceColor(reference)»>«reference.type.name»
				«ENDFOR»
			«ENDFOR»
			
			center footer Rule «rule.name»
		'''
	}

	/**
	 * Returns the name and type name of the node.
	 */
	private static def String nodeClassName(Node node) {
		'''"«node.name»: «node.type.name»"'''
	}

	/**
	 * Returns the skin name for the node.
	 */
	private static def String nodeSkin(Node node) {
		if (node instanceof ContextNode) {
			'CONTEXT'
		} else if (node instanceof OperatorNode) {
			node.operator.getName
		} else {
			''
		}
	}

	/**
	 * Returns the color for the reference.
	 */
	private static def String referenceColor(Reference reference) {
		if (reference instanceof ContextReference) {
			'''«ContextColor»'''
		} else if (reference instanceof OperatorReference) {
			if (reference.operator === Operator.CREATE) {
				'''«CreateColor»'''
			} else {
				'''«DeleteColor»'''
			}
		} else {
			''
		}
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
