package org.emoflon.ibex.tgg.ui.debug.plantuml

import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator
import language.TGGRule
import language.TGGRuleNode
import language.BindingType
import language.TGGRuleEdge
import java.util.Map
import language.DomainType
import language.TGGRuleCorr
import org.emoflon.ibex.tgg.operational.matches.IMatch
import java.util.Collection
import java.security.DomainCombiner

class VictoryPlantUMLGenerator {
	
	def static String visualiseTGGRule(TGGRule rule) {
		
		val nodeGroupMap = rule.nodes.groupBy[it.domainType]
		val nodeIdMap = rule.nodes.toInvertedMap[idForNode]
		
		'''
			@startuml
			«EMoflonPlantUMLGenerator.plantUMLPreamble»

			together {
				«FOR node : nodeGroupMap.get(DomainType.SRC)»
					«visualiseRuleNode(nodeIdMap.get(node), bindingToColour(node.bindingType), node.domainType)»
				«ENDFOR»
			}

			together {
				«FOR node : nodeGroupMap.get(DomainType.TRG)»
					«visualiseRuleNode(nodeIdMap.get(node), bindingToColour(node.bindingType), node.domainType)»
				«ENDFOR»
			}
			
			«FOR node : nodeGroupMap.get(DomainType.CORR)»
				«val corrNode = node as TGGRuleCorr»
				«visualiseRuleCorrEdge(nodeIdMap.get(corrNode.source), nodeIdMap.get(corrNode.target), corrNode.type.name, corrNode.bindingType === BindingType.CREATE)»
			«ENDFOR»
			
			«FOR edge : rule.edges»
				«if(edge.domainType !== DomainType.CORR) visualiseRuleEdge(nodeIdMap.get(edge.srcNode), nodeIdMap.get(edge.trgNode), edge.type.name, edge.bindingType === BindingType.CREATE)»
			«ENDFOR»
			@enduml
		'''
	}
	def static String visualiseMatch(IMatch match, TGGRule rule) {
		
		val paramToNodeMap = match.parameterNames.toInvertedMap[param | rule.nodes.findFirst[node | param === node.name]]
		val nonCorrParams = match.parameterNames.filter[paramToNodeMap.get(it).domainType !== DomainType.CORR]
		val paramToNodeIdMap = paramToNodeMap.mapValues[idForNode(it)]
		
		'''
			@startuml
			«EMoflonPlantUMLGenerator.plantUMLPreamble»
			
			«visualiseRulePrecondition(rule)»
			
			together {
				«FOR String param : nonCorrParams»
					class «match.get(param).class.name» <<BLACK>> <<SRC>>
				«ENDFOR»
			}
			
			«FOR String param : nonCorrParams»
				«paramToNodeIdMap.get(param)» <...> «match.get(param).class.name»
			«ENDFOR»
			
			@enduml
		'''
	}
	
	private def static String visualiseRulePrecondition(TGGRule rule) {
		'''
			together {
				«FOR node : rule.nodes.filter[it.bindingType !== BindingType.CREATE && it.domainType !== DomainType.CORR]»
					«visualiseRuleNode(idForNode(node), bindingToColour(node.bindingType), node.domainType)»
				«ENDFOR»
				«FOR edge : rule.edges.filter[it.bindingType !== BindingType.CREATE && it.domainType !== DomainType.CORR]»
					«visualiseRuleEdge(idForNode(edge.srcNode), idForNode(edge.trgNode), edge.type.name, false)»
				«ENDFOR»
				«FOR corrNode : rule.nodes.filter[it.bindingType !== BindingType.CREATE && it.domainType === DomainType.CORR].map[it as TGGRuleCorr]»
					«visualiseRuleCorrEdge(idForNode(corrNode.source), idForNode(corrNode.target), corrNode.type.name, false)»
				«ENDFOR»
			}
		'''
	}
	
	private def static visualiseRuleNode(String ruleId, String bindingColour, DomainType domainType) {
		'''class «ruleId» <<«bindingColour»>> <<«domainType»>>'''
	}

	private def static visualiseRuleEdge(String srcNodeId, String trgNodeId, String edgeId, boolean bindingTypeCreate) {
		'''«srcNodeId» -«IF (bindingTypeCreate)»[#SpringGreen]«ENDIF»-> «trgNodeId» : "«edgeId»"'''
	}
	
	private def static visualiseRuleCorrEdge(String srcNodeId, String trgNodeId, String edgeId, boolean bindingTypeCreate) {
		'''«srcNodeId» ...«IF (bindingTypeCreate)»[#SpringGreen]«ENDIF» «trgNodeId» : "«edgeId»"'''
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