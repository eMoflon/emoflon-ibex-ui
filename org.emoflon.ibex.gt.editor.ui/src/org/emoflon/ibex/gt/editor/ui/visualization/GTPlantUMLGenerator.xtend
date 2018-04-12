package org.emoflon.ibex.gt.editor.ui.visualization

import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorExpression
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorRelation
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
			
			«FOR node : flattenedPattern.nodes»
				class «nodeName(node)» <<«nodeSkin(node)»>> {
					«FOR attr: node.attributes»
						«attributeConstraint(attr)»
					«ENDFOR»
				}
			«ENDFOR»
			
			«FOR node : flattenedPattern.nodes»
				«FOR reference : node.references»
					«nodeName(node)» -[#«referenceColor(reference)»]-> «nodeName(reference.target)»: «referenceLabel(reference)»
				«ENDFOR»
			«ENDFOR»
			
			center footer
				= «pattern.name»
				«org.emoflon.ibex.gt.editor.ui.visualization.GTPlantUMLGenerator.signature(flattenedPattern)»
			end footer
		'''
	}

	/**
	 * Prints the name and type name of the node.
	 */
	private static def String nodeName(EditorNode node) {
		if (node === null) {
			return '"?"'
		}
		val type = if(node.type === null) '?' else node.type.name
		'''"«node.name»: «type»"'''
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
		'''
			«commonLayoutSettings»
			
			skinparam class {
				BackgroundColor White
				BorderColor Black
				ArrowColor Black
			}
			
			«FOR pattern : patterns»
				«IF pattern.abstract»abstract «ENDIF»class "«pattern.name»" «link(pattern)»
			«ENDFOR»
			
			«FOR pattern : patterns»
				«FOR sup: pattern.superPatterns»
					«IF sup.name !== null»
						"«pattern.name»" -up-|> "«sup.name»"
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
