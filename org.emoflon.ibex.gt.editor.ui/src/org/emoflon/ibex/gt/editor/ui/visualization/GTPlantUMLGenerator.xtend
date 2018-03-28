package org.emoflon.ibex.gt.editor.ui.visualization

import java.util.List
import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.AttributeConstraint
import org.emoflon.ibex.gt.editor.gT.EnumValue
import org.emoflon.ibex.gt.editor.gT.Expression
import org.emoflon.ibex.gt.editor.gT.LiteralValue
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.ParameterValue
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
			«commonLayoutSettings»
			«legendSettings»
			
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
			
			legend
				Attributes:
				«attributeConstraints(flattenedRule.nodes)»
			end legend
			
			center footer
				= «rule.name»
				«ruleSignature(flattenedRule)»
			end footer
		'''
	}

	/**
	 * Prints the name and type name of the node.
	 */
	private static def String nodeName(Node node) {
		if (node === null) {
			return '"?"'
		}
		val type = if(node.type === null) '?' else node.type.name
		'''"«node.name»: «type»"'''
	}

	/**
	 * Prints the skin name for the node.
	 */
	private static def String nodeSkin(Node node) {
		return node.operator.getName
	}

	/**
	 * Prints the color for the reference.
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
	 * Prints the reference label in the color of the reference operator.
	 */
	private static def String referenceLabel(Reference reference) {
		'''<color:«referenceColor(reference)»>«reference.type.name»'''
	}

	/**
	 * Prints the attribute constraints of the given nodes.
	 */
	private static def String attributeConstraints(List<Node> nodes) {
		'''
			«FOR node : nodes»
				«FOR attr: node.attributes»
					«node.name».«attributeConstraint(attr)»
				«ENDFOR»
			«ENDFOR»
		'''
	}

	/**
	 * Prints the attribute constraint.
	 */
	private static def String attributeConstraint(AttributeConstraint attr) {
		val name = if(attr.attribute === null || attr.attribute.name === null) '?' else attr.attribute.name
		val relation = if(attr.relation === null) '?' else attr.relation.toString
		'''«name» «relation» «expression(attr.value)»'''
	}

	/**
	 * Prints the expression.
	 */
	private static def String expression(Expression expression) {
		if (expression instanceof EnumValue) {
			return '''«expression.literal.literal»'''
		}
		if (expression instanceof LiteralValue) {
			return '''«expression.value.toString»'''
		}
		if (expression instanceof ParameterValue) {
			if (expression.parameter === null) {
				return 'unknown parameter'
			}
			return '''«expression.parameter.name»'''
		}
		return '''«expression.toString»'''
	}

	/**
	 * Prints the signature of the rule.
	 */
	private static def String ruleSignature(Rule rule) {
		'''«FOR parameter : rule.parameters BEFORE '(' SEPARATOR ', ' AFTER ')'»«parameterDeclaration(parameter)»«ENDFOR»'''
	}

	/**
	 * Prints the parameter declaration. 
	 */
	private static def parameterDeclaration(Parameter parameter) {
		val type = if(parameter.type === null) '?' else parameter.type.name
		'''«parameter.name»: «type»'''
	}

	/**
	 * Returns the PlantUML code for the visualization of the refinement hierarchy of the given rules.
	 */
	public static def String visualizeRuleHierarchy(EList<Rule> rules) {
		'''
			«commonLayoutSettings»
			
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
			
			center footer
				= Rule Refinement Hierarchy
			end footer
		'''
	}

	/**
	 * Print the common settings for all visualizations.
	 */
	private static def String commonLayoutSettings() {
		'''
			hide empty members
			hide circle
			hide stereotype
			
			skinparam padding 2
			skinparam shadowing false
		'''
	}

	/**
	 * Prints the legend settings.
	 */
	private static def String legendSettings() {
		'''
			skinparam legendBackgroundColor White
			skinparam legendBorderColor White
			skinparam legendFontSize 18
			skinparam legendFontName Courier New
		'''
	}
}
