package org.emoflon.ibex.common.visualization

import org.emoflon.ibex.common.coremodel.IBeXCoreModel.IBeXPatternSet
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.GTPattern
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.GTRule
import org.emoflon.ibex.common.coremodel.IBeXCoreModel.IBeXNode
import java.util.List
import org.emoflon.ibex.common.coremodel.IBeXCoreModel.IBeXEdge

/**
 * Utility methods to generate PlantUML code.
 */
class IBeXPatternPlantUMLGenerator {
	static val ContextColor = 'Black'
	static val LocalColor = 'DarkSlateGray'
	static val CreateColor = 'DarkGreen'
	static val DeleteColor = 'Crimson'

	/**
	 * Visualizes the pattern invocations in the pattern set. 
	 */
	static def String visualizePatternInvocations(IBeXPatternSet patternSet) {
		'''
			«commonLayoutSettings»
			
			«FOR pattern : patternSet.patterns»
				class "«pattern.name»"
			«ENDFOR»
			
			«FOR pattern : patternSet.patterns»
				«FOR invocation: pattern.invocations»
					"«pattern.name»" --> "«invocation.invocation.name»"
				«ENDFOR»
			«ENDFOR»
			
			center footer
				= Pattern Invocations
			end footer
		'''
	}

	/**
	 * Visualizes the context pattern.
	 */
	static def String visualizeContextPattern(GTPattern pattern) {
		'''
			«commonLayoutSettings»
			
			skinparam class {
				BorderColor<<CONTEXT>> «ContextColor»
				BorderColor<<LOCAL>> «LocalColor»
				FontColor<<CONTEXT>> «ContextColor»
				FontColor<<LOCAL>> «LocalColor»
			}
			
			«printPattern(pattern, '', true)»
			
			center footer
				= Context Pattern «pattern.name»
			end footer
		'''
	}

	/**
	 * Outputs the context pattern.
	 */
	private static def String printPattern(GTPattern pattern, String prefix, boolean positive) {
		val packageName = prefix + pattern.name
		'''
			package "«packageName»" «IF !positive»#FFCCCC«ENDIF» {}
			«visualizeNodes(pattern.signatureNodes, 'CONTEXT', packageName)»
			«visualizeNodes(pattern.localNodes, 'LOCAL', packageName)»
			«visualizeEdges(pattern.edges, ContextColor, packageName, '')»
			«var j = 0»
			«FOR invocation : pattern.invocations»
				«val newPrefix = j++ + "\\"»
				«printPattern(invocation.invocation as GTPattern, newPrefix, invocation.positive)»
				
				«FOR mapEntry : invocation.mapping.entrySet»
					"«node(mapEntry.key, packageName)»" #--# "«node(mapEntry.value, newPrefix + invocation.invocation.name)»"
				«ENDFOR»
			«ENDFOR»
		'''
	}

	/**
	 * Visualizes the create pattern.
	 */
	static def String visualizeRule(GTRule rule) {
		val packageName = rule.name
		'''
			«commonLayoutSettings»
			
			skinparam class {
				BorderColor<<CONTEXT>> «ContextColor»
				BorderColor<<CREATE>> «CreateColor»
				FontColor<<CONTEXT>> «ContextColor»
				BorderColor<<LOCAL>> «LocalColor»
				FontColor<<LOCAL>> «LocalColor»
				FontColor<<CREATE>> «CreateColor»
				BorderColor<<DELETE>> «DeleteColor»
				FontColor<<DELETE>> «DeleteColor»
			}
			
			package "«packageName»" {}
			
			«visualizeNodes(rule.precondition.signatureNodes.filter[n | !rule.deletion.nodes.contains(n)].toList, 'CONTEXT', packageName)»
			«visualizeNodes(rule.precondition.localNodes.toList, 'LOCAL', packageName)»
			«visualizeEdges(rule.precondition.edges.filter[e | !rule.deletion.edges.contains(e)].toList, ContextColor, packageName, '')»
			«visualizeNodes(rule.creation.nodes, 'CREATE', packageName)»
			«visualizeEdges(rule.creation.edges, CreateColor, packageName, '++')»
			«visualizeNodes(rule.deletion.nodes, 'DELETE', packageName)»
			«visualizeEdges(rule.deletion.edges, DeleteColor, packageName, '--')»

			«var j = 0»
			«FOR invocation : rule.precondition.invocations»
			«val newPrefix = j++ + "\\"»
			«printPattern(invocation.invocation as GTPattern, newPrefix, invocation.positive)»				
			«FOR mapEntry : invocation.mapping.entrySet»
			"«node(mapEntry.key, packageName)»" #--# "«node(mapEntry.value, newPrefix + invocation.invocation.name)»"
			«ENDFOR»
			«ENDFOR»
			
			center footer
				= Rule «rule.name»
			end footer
		'''
	}

	/**
	 * Outputs the nodes.
	 */
	private static def String visualizeNodes(List<IBeXNode> nodes, String type, String nodePrefix) {
		'''
			«FOR node : nodes»
				class "«node(node, nodePrefix)»" <<«type»>>
			«ENDFOR»
		'''
	}

	/**
	 * Outputs the node name and type with the prefix.
	 */
	private static def String node(IBeXNode node, String prefix) {
		'''«prefix».«node.name» : «node.type.name»'''
	}

	/**
	 * Outputs the edges.
	 */
	private static def String visualizeEdges(List<IBeXEdge> edges, String color, String nodePrefix, String op) {
		'''
			«FOR edge : edges»
				"«node(edge.source, nodePrefix)»" -[#«color»]-> "«node(edge.target, nodePrefix)»": «» <color:«color»>«op»«edge.type.name»
			«ENDFOR»
		'''
	}

	/**
	 * Prints the common settings for all visualizations.
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
