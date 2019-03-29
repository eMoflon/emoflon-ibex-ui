package org.emoflon.ibex.tgg.ui.debug.plantuml

import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator
import language.TGGRule
import language.TGGRuleNode
import language.BindingType
import language.TGGRuleEdge
import java.util.Map
import language.DomainType
import language.TGGRuleCorr

class VictoryPlantUMLGenerator {
	
	def static String visualiseTGGRule(TGGRule rule) {
		
		val nodeGroupMap = rule.nodes.groupBy[it.domainType]
		val nodeIdMap = rule.nodes.toInvertedMap[idForNode]
		
		'''
			@startuml
			«EMoflonPlantUMLGenerator.plantUMLPreamble»

			together {
				«FOR node : nodeGroupMap.get(DomainType.SRC)»
					«visualiseNode(node, nodeIdMap)»
				«ENDFOR»
			}

			together {
				«FOR node : nodeGroupMap.get(DomainType.TRG)»
					«visualiseNode(node, nodeIdMap)»
				«ENDFOR»
			}
			
			«FOR node : nodeGroupMap.get(DomainType.CORR)»
				«visualiseCorrEdge(node as TGGRuleCorr, nodeIdMap)»
			«ENDFOR»
			
			«FOR edge : rule.edges»
				«if(edge.domainType !== DomainType.CORR)visualiseEdge(edge, nodeIdMap)»
			«ENDFOR»
			@enduml
		'''
	}
	
	private def static visualiseNode(TGGRuleNode node, Map<TGGRuleNode,String> ruleIdMap) {
		'''class «ruleIdMap.get(node)» <<«bindingToColour(node.bindingType)»>> <<«node.domainType»>>'''
	}

	private def static visualiseEdge(TGGRuleEdge edge, Map<TGGRuleNode,String> ruleIdMap) {
		'''«ruleIdMap.get(edge.srcNode)» -«IF (edge.bindingType === BindingType.CREATE)»[#SpringGreen]«ENDIF»-> «ruleIdMap.get(edge.trgNode)» : "«edge.type.name»"'''
	}
	
	private def static visualiseCorrEdge(TGGRuleCorr corrNode, Map<TGGRuleNode,String> ruleIdMap) {
		'''«ruleIdMap.get(corrNode.source)» ...«IF (corrNode.bindingType === BindingType.CREATE)»[#SpringGreen]«ENDIF» «ruleIdMap.get(corrNode.target)» : "«corrNode.type.name»"'''
	}
	
	private def static String idForNode(TGGRuleNode node) {
		'''"«node.name» : «node.type.name»"'''
	}
	
	private def static bindingToColour(BindingType binding) {
		if (binding === BindingType.CREATE)
			return "GREEN"
		else
			return "BLACK"
	}
}