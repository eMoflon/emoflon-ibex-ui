package org.emoflon.ibex.tgg.ui.debug.plantuml

import language.TGGRule
import language.TGGRuleNode
import language.BindingType
import java.util.Map
import language.DomainType
import language.TGGRuleCorr
import org.emoflon.ibex.tgg.operational.matches.IMatch
import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions
import org.emoflon.ibex.tgg.ui.debug.options.IBeXOp

class VictoryPlantUMLGenerator {
	
	def static String visualiseTGGRule(TGGRule rule, IUserOptions userOptions) {
		'''
			@startuml
			«plantUMLPreamble»

			«visualiseRule(rule, false, true, userOptions.op)»
			
			@enduml
		'''
	}
	
	def static String visualiseMatch(IMatch match, TGGRule rule, Collection<EObject> matchNeighborhood, IUserOptions userOptions) {
		
		// TODO implement usage of actual match neighborhood
		
		val paramToNodeMap = match.parameterNames.toInvertedMap[param | rule.nodes.findFirst[node | param === node.name]]
		val paramToNodeIdMap = paramToNodeMap.mapValues[idForNode(it)]
		val nonCorrParamToEObjectMap = match.parameterNames.filter[paramToNodeMap.get(it).domainType !== DomainType.CORR].toInvertedMap[match.get(it) as EObject]
		val eObjectMapping = nonCorrParamToEObjectMap.values.toInvertedMap[
			val id = labelFor(it) + "_" + indexFor(it)
			val label = id + " : " + it.eClass.name
			id->label
		]
		
		'''
			@startuml
			«plantUMLPreamble»
			
			«visualiseRule(rule, true, userOptions.displayFullRuleForMatches, userOptions.op)»
			
			«visualiseEObjectGraph(eObjectMapping)»
			
			«FOR String param : nonCorrParamToEObjectMap.keySet»
				«paramToNodeIdMap.get(param)» #.[#Blue]..# «eObjectMapping.get(nonCorrParamToEObjectMap.get(param)).key»
			«ENDFOR»
			
			@enduml
		'''
	}
	
	private def static String plantUMLPreamble(){
		'''
			hide empty members
			hide circle
			hide stereotype
			
			skinparam shadowing false
			
			skinparam class {
				BorderColor<<CREATE>> SpringGreen
				BorderColor<<TRANSLATE>> Gold
				BorderColor<<OTHER>> Black
				BackgroundColor<<TRG>> MistyRose
				BackgroundColor<<SRC>> LightYellow
				BackgroundColor<<CORR>> LightCyan 
				ArrowColor Black
			}	
		'''
	}
	
	private def static String visualiseRule(TGGRule rule, boolean groupFullRule, boolean showCreated, IBeXOp op) {
		
		val nodeGroupMap = rule.nodes.groupBy[it.domainType]
		val nodeIdMap = rule.nodes.toInvertedMap[idForNode]
		
		'''
			«IF groupFullRule»together {«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.SRC)»
				together {
					«FOR node : nodeGroupMap.get(DomainType.SRC)»
						«IF showCreated || node.bindingType !== BindingType.CREATE»
							«visualiseRuleNode(nodeIdMap.get(node), getColorDefinitions(node.bindingType, node.domainType, op))»
						«ENDIF»
					«ENDFOR»
				}
			«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.TRG)»
				together {
					«FOR node : nodeGroupMap.get(DomainType.TRG)»
						«IF showCreated || node.bindingType !== BindingType.CREATE»
							«visualiseRuleNode(nodeIdMap.get(node), getColorDefinitions(node.bindingType, node.domainType, op))»
						«ENDIF»
					«ENDFOR»
				}
			«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.CORR)»
				«FOR node : nodeGroupMap.get(DomainType.CORR)»
					«val corrNode = node as TGGRuleCorr»
					«IF showCreated || corrNode.bindingType !== BindingType.CREATE»
						«visualiseRuleCorrEdge(nodeIdMap.get(corrNode.source), nodeIdMap.get(corrNode.target), corrNode.type.name, corrNode.bindingType === BindingType.CREATE)»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
			
			«FOR edge : rule.edges»
				«IF edge.domainType !== DomainType.CORR && (showCreated || edge.bindingType !== BindingType.CREATE)»
					«visualiseRuleEdge(nodeIdMap.get(edge.srcNode), nodeIdMap.get(edge.trgNode), edge.type.name, edge.bindingType === BindingType.CREATE)»
				«ENDIF»
			«ENDFOR»
			
			«IF groupFullRule»}«ENDIF»
		'''
	}
	
	private def static String visualiseEObjectGraph(Map<EObject, Pair<String, String>> eObjectMapping) {
		'''
		together {
			«FOR object: eObjectMapping.keySet»
				object "«eObjectMapping.get(object).value»" as «eObjectMapping.get(object).key» <<BLACK>> <<SRC>> {
					«FOR EAttribute attr : object.eClass.EAttributes»
						«attr.EType.name» «attr.name» «object.eGet(attr)»
					«ENDFOR»
				}
				
				«FOR contentObject : object.eContents»
					«IF eObjectMapping.containsKey(contentObject)»
						«eObjectMapping.get(object).key» --> «eObjectMapping.get(contentObject).key» : «contentObject.eContainingFeature.name»
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
		}
		'''
	}
	
	private def static String labelFor(EObject object) {
		if(object.eContainingFeature() !== null) {
			return object.eContainingFeature().getName();
		} else {
			return "root";
		}
	}

	private def static String indexFor(EObject object) {
		if (object.eContainer() === null) {
			val resource = object.eResource()
			return resource.getResourceSet().getResources().indexOf(resource) + "_" + resource.getContents().indexOf(object)
		} else {
			val container = object.eContainer()
			return indexFor(container) + "_" + container.eContents().indexOf(object)
		}
	}
	
	private def static String visualiseRuleNode(String ruleId, String colorDefinitions) {
		'''class «ruleId» «colorDefinitions»'''
	}

	private def static String visualiseRuleEdge(String srcNodeId, String trgNodeId, String edgeId, boolean bindingTypeCreate) {
		'''«srcNodeId» -«IF (bindingTypeCreate)»[#SpringGreen]«ENDIF»-> «trgNodeId» : "«edgeId»"'''
	}
	
	private def static String visualiseRuleCorrEdge(String srcNodeId, String trgNodeId, String edgeId, boolean bindingTypeCreate) {
		'''«srcNodeId» ...«IF (bindingTypeCreate)»[#SpringGreen]«ENDIF» «trgNodeId» : "«edgeId»"'''
	}
	
	private def static String idForNode(TGGRuleNode node) {
		'''"«node.name» : «node.type.name»"'''
	}
	
	private def static String getColorDefinitions(BindingType binding, DomainType domain, IBeXOp op) {
		
		var bindingColour = "OTHER"
		if(binding === BindingType.CREATE)
			if((op === IBeXOp.INITIAL_FWD && domain === DomainType.SRC)
				|| (op === IBeXOp.INITIAL_BWD && domain === DomainType.TRG))
					bindingColour = "TRANSLATE"
			else
				bindingColour = "CREATE"
		
		'''<<«bindingColour»>> <<«domain»>>'''
	}

}