package org.emoflon.ibex.gt.editor.ui.visualization

import java.util.HashSet
import java.util.Set
import org.apache.commons.lang3.StringUtils
import org.eclipse.emf.common.util.EList
import org.emoflon.ibex.gt.editor.gT.EditorCondition
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.utils.GTConditionHelper
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils
import org.emoflon.ibex.gt.editor.utils.GTFlattener
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment

/**
 * Utility methods to generate PlantUML code.
 */
class GTPlantUMLGenerator {
	static val ContextColor = 'Black'
	static val CreateColor = 'DarkGreen'
	static val DeleteColor = 'Crimson'
	static val AtrConstrColor = 'White'
	static int MAX_STR_LENGTH = 100

	/**
	 * Returns the PlantUML code for the visualization of an empty file.
	 */
	static def String visualizeNothing() {
		'''
			title There is nothing to visualize yet.
		'''
	}

	/**
	 * Returns the PlantUML code for the visualization of the given pattern.
	 */
	static def String visualizePattern(EditorPattern pattern) {
		val flattenedPattern = new GTFlattener(pattern).getFlattenedPattern
		val nodeNamesInFlattenedPattern = flattenedPattern.nodes.map[it.name]
		'''
			«commonLayoutSettings»
			
			skinparam class {
				HeaderBackgroundColor<<CONTEXT>> «ContextColor»
				HeaderBackgroundColor<<CREATE>> «CreateColor»
				HeaderBackgroundColor<<DELETE>> «DeleteColor»
				HeaderBackgroundColor<<ATR_CONSTR>> «AtrConstrColor»
				BorderColor<<CONTEXT>> «ContextColor»
				BorderColor<<CREATE>> «CreateColor»
				BorderColor<<DELETE>> «DeleteColor»
				BorderColor<<ATR_CONSTR>> «ContextColor»
				FontColor<<ATR_CONSTR>> «ContextColor»
				FontColor White
			}
			
			namespace «pattern.name» {
				«visualizeGraph(flattenedPattern)»
				«visualizeAttributeConstraints(flattenedPattern)»
				«visualizeRate(flattenedPattern)»
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
					«GTVisualizationUtils.getConditionString(pattern)»
				endlegend
			«ENDIF»
			
			center footer
				= «pattern.name»
				«GTVisualizationUtils.signature(flattenedPattern)»
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
						«org.emoflon.ibex.gt.editor.ui.visualization.GTPlantUMLGenerator.attributeAssignment(attr)»
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
	 * Visualizes attribute constraints. 
	 */
	private static def String visualizeAttributeConstraints(EditorPattern pattern) {
		if(pattern.attributeConstraints.isEmpty)
			return ""
		
		return '''
			class "Attribute Constraints" <<ATR_CONSTR>>{
			«FOR constraint : pattern.attributeConstraints»
				«attributeConstraint(constraint)»
			«ENDFOR»
			}
		'''
	}
	
	/**
	 * Visualizes rule rate. 
	 */
	def static visualizeRate(EditorPattern pattern) {
		if(!pattern.stochastic || pattern.probability === null)
			return ""
		return '''
			class "Rule Probability" <<ATR_CONSTR>>{
				# P(..) = «GTVisualizationUtils.toString(pattern.probability)»
			}
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
	private static def String attributeConstraint(EditorAttributeConstraint attr) {
		val operator = '#'
		val relation = if(attr.relation === null) '?' else attr.relation.toString
		'''«operator» «StringUtils.abbreviateMiddle(GTVisualizationUtils.toString(attr.lhs), "...", MAX_STR_LENGTH)» «relation» «StringUtils.abbreviateMiddle(GTVisualizationUtils.toString(attr.rhs), "...", MAX_STR_LENGTH)»'''
	}
	
	/**
	 * Prints the attribute constraint.
	 */
	private static def String attributeAssignment(EditorAttributeAssignment attr) {
		val operator = '+'
		val name = if(attr.attribute === null || attr.attribute.name === null) '?' else attr.attribute.name
		val relation = ':='
		'''«operator» «name» «relation» «StringUtils.abbreviateMiddle(GTVisualizationUtils.toString(attr.value), "...", MAX_STR_LENGTH)»'''
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
	 * Extracts the patterns from the conditions of the pattern.
	 */
	private static def Set<EditorPattern> getConditionPatterns(EditorPattern pattern) {
		val patterns = new HashSet
		for (c : pattern.conditions) {
			patterns.addAll(getConditionPatterns(c))
		}
		return patterns
	}

	/**
	 * Extracts the patterns from a list of simple conditions.
	 */
	private static def Set<EditorPattern> getConditionPatterns(EditorCondition condition) {
		val patterns = new HashSet
		for (c : new GTConditionHelper(condition).getApplicationConditions()) {
			patterns.add(c.pattern)
		}
		return patterns
	}

	/**
	 * Returns the PlantUML code for the visualization of the refinement hierarchy of the given patterns.
	 */
	static def String visualizePatternHierarchy(EList<EditorPattern> patterns) {
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
