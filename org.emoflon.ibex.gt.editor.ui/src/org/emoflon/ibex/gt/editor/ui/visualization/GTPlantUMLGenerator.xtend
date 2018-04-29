package org.emoflon.ibex.gt.editor.ui.visualization

import java.util.HashSet
import java.util.Set

import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.EditorAndCondition
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference
import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorConditionExpression
import org.emoflon.ibex.gt.editor.gT.EditorEnforce
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorExpression
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils
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
	 * Returns the PlantUML code for the visualization of the given pattern.
	 */
	public static def String visualizePattern(EditorPattern pattern) {
		val flattenedPattern = new GTFlattener(pattern).getFlattenedPattern
		val nodeNamesInFlattenedPattern = flattenedPattern.nodes.map[it.name]
		'''
			«commonLayoutSettings»
			
			skinparam class {
				HeaderBackgroundColor<<CONTEXT>> «ContextColor»
				HeaderBackgroundColor<<CREATE>> «CreateColor»
				HeaderBackgroundColor<<DELETE>> «DeleteColor»
				BorderColor<<CONTEXT>> «ContextColor»
				BorderColor<<CREATE>> «CreateColor»
				BorderColor<<DELETE>> «DeleteColor»
				FontColor White
			}
			
			namespace «pattern.name» {
				«visualizeGraph(flattenedPattern)»
			}
			
			«FOR p : getConditionPatterns(pattern)»
				«val flattenedConditionPattern = new GTFlattener(p).getFlattenedPattern»
				namespace «p.name» #EEEEEE {
					«visualizeGraph(flattenedConditionPattern)»
				}
				
				«FOR node : flattenedConditionPattern.nodes»
					«IF nodeNamesInFlattenedPattern.contains(node.name)»
						"«pattern.name».«nodeName(flattenedPattern, node.name)»" #--# "«p.name».«nodeName(node)»"
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			
			«IF !pattern.conditions.isEmpty»
				legend bottom
					«getConditionString(pattern)»
				endlegend
			«ENDIF»
			
			center footer
				= «pattern.name»
				«signature(flattenedPattern)»
			end footer
		'''
	}

	/**
	 * Visualizes the nodes and edges. 
	 */
	private static def String visualizeGraph(EditorPattern pattern) {
		'''
			«FOR node : pattern.nodes»
				class "«nodeName(node)»" <<«nodeSkin(node)»>> {
					«FOR attr: node.attributes»
						«attributeConstraint(attr)»
					«ENDFOR»
				}
			«ENDFOR»
			
			«FOR node : pattern.nodes»
				«FOR reference : node.references»
					"«nodeName(node)»" -[#«referenceColor(reference)»]-> "«nodeName(reference.target)»": «referenceLabel(reference)»
				«ENDFOR»
			«ENDFOR»
		'''
	}

	/**
	 * Prints the name and type name of the node.
	 */
	private static def String nodeName(EditorNode node) {
		if (node === null) {
			return '?'
		}
		val type = if(node.type === null) '?' else node.type.name
		'''«node.name»: «type»'''
	}
	
	/**
	 * Prints the node with the given name in the pattern.
	 */
	private static def String nodeName(EditorPattern pattern, String name) {
		return nodeName(pattern.nodes.findFirst[it.name == name])
	}

	/**
	 * Prints the skin name for the node.
	 */
	private static def String nodeSkin(EditorNode node) {
		return node.operator.getName
	}

	/**
	 * Prints the attribute constraint.
	 */
	private static def String attributeConstraint(EditorAttribute attr) {
		val operator = if(attr.relation == EditorRelation.ASSIGNMENT) '+' else '#'
		val name = if(attr.attribute === null || attr.attribute.name === null) '?' else attr.attribute.name
		val relation = if(attr.relation === null) '?' else attr.relation.toString
		'''«operator» «name» «relation» «expression(attr.value)»'''
	}

	/**
	 * Prints the color for the reference.
	 */
	private static def String referenceColor(EditorReference reference) {
		if (reference.operator == EditorOperator.CONTEXT) {
			'''«ContextColor»'''
		} else if (reference.operator === EditorOperator.CREATE) {
			'''«CreateColor»'''
		} else if (reference.operator === EditorOperator.DELETE) {
			'''«DeleteColor»'''
		} else {
			''
		}
	}

	/**
	 * Prints the reference label in the color of the reference operator.
	 */
	private static def String referenceLabel(EditorReference reference) {
		val type = if(reference === null || reference.type === null) '?' else reference.type.name
		'''<color:«referenceColor(reference)»>«type»'''
	}

	/**
	 * Prints the expression.
	 */
	private static def String expression(EditorExpression expression) {
		if (expression === null) {
			return 'INVALID expression'
		}
		if (expression instanceof EditorAttributeExpression) {
			val nodeName = if(expression.node === null) '?' else expression.node.name
			val attributeName = if(expression.attribute === null) '?' else expression.attribute.name
			return '''«nodeName».«attributeName»'''
		}
		if (expression instanceof EditorEnumExpression) {
			return '''«expression.literal.literal»'''
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

	/**
	 * Extracts the patterns from the conditions of the pattern.
	 */
	private static def Set<EditorPattern> getConditionPatterns(EditorPattern pattern) {
		val patterns = new HashSet
		pattern.conditions.forEach [
			patterns.addAll(getConditionPatterns(it.expression))
		]
		return patterns
	}

	/**
	 * Extracts the patterns from a single condition. 
	 */
	private static def Set<EditorPattern> getConditionPatterns(EditorConditionExpression condition) {
		val patterns = new HashSet
		if (condition instanceof EditorAndCondition) {
			patterns.addAll(getConditionPatterns(condition.left))
			patterns.addAll(getConditionPatterns(condition.right))
		}
		if (condition instanceof EditorConditionReference) {
			patterns.addAll(getConditionPatterns(condition.condition.expression))
		}
		if (condition instanceof EditorEnforce) {
			patterns.add(condition.pattern)
		}
		if (condition instanceof EditorForbid) {
			patterns.add(condition.pattern)
		}
		return patterns
	}

	/**
	 * Prints the conditions of the pattern.
	 */
	private static def String getConditionString(EditorPattern pattern) {
		'''
			«FOR c : pattern.conditions SEPARATOR ' **||** '»
				(«getConditionString(c.expression)»)
			«ENDFOR»
		'''
	}

	/**
	 * Print the condition.
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
	}

	/**
	 * Prints the signature of the pattern.
	 */
	private static def String signature(EditorPattern pattern) {
		'''«FOR parameter : pattern.parameters BEFORE '(' SEPARATOR ', ' AFTER ')'»«parameterDeclaration(parameter)»«ENDFOR»'''
	}

	/**
	 * Prints the parameter declaration. 
	 */
	private static def parameterDeclaration(EditorParameter parameter) {
		val type = if(parameter.type === null) '?' else parameter.type.name
		'''«parameter.name»: «type»'''
	}

	/**
	 * Returns the PlantUML code for the visualization of the refinement hierarchy of the given patterns.
	 */
	public static def String visualizePatternHierarchy(EList<EditorPattern> patterns) {
		val allPatterns = new HashSet(patterns)
		for (p : patterns) {
			for (s : GTEditorPatternUtils.getAllSuperPatterns(p)) {
				if (!allPatterns.contains(s)) {
					allPatterns.add(s)
				}
			}
		}

		'''
			«commonLayoutSettings»
			
			left to right direction
			
			skinparam class {
				BackgroundColor White
				BorderColor Black
				ArrowColor Black
			}
			
			«FOR pattern : allPatterns»
				«IF pattern.abstract»abstract «ENDIF»class "«pattern.name»" «link(pattern)»
			«ENDFOR»
			
			«FOR pattern : allPatterns»
				«FOR sup: pattern.superPatterns»
					«IF sup.name !== null»
						"«pattern.name»" --|> "«sup.name»"
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			
			center footer
				= Pattern Refinement Hierarchy
			end footer
		'''
	}

	/**
	 * Prints the link to the pattern.
	 */
	private static def link(EditorPattern pattern) {
		val resource = pattern.eResource
		val uri = resource.URI + '#' + resource.getURIFragment(pattern)
		'''[[«uri»]]'''
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
}
