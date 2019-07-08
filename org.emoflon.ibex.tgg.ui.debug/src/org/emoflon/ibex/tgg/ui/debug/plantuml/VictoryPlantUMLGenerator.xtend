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
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager.VisualizationLabelOptions
import org.apache.commons.lang3.StringUtils

class VictoryPlantUMLGenerator {
	
	def static String visualiseTGGRule(TGGRule rule, IUserOptions userOptions) {
		'''
			@startuml
			«plantUMLPreamble»

			«visualiseRule(rule, false, true, userOptions.op, userOptions.corrLabelVisualization)»
			
			@enduml
		'''
	}
	
	def static String visualiseMatch(IMatch match, TGGRule rule, Collection<EObject> matchNeighborhood, IUserOptions userOptions) {
		
		// TODO implement usage of actual match neighborhood
		
		val paramToNodeMap = match.parameterNames.toInvertedMap[param | rule.nodes.findFirst[node | param === node.name]]
		val paramToNodeIdMap = paramToNodeMap.mapValues[idForNode(it)]
		val srcParamToEObjectMap = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.SRC].toInvertedMap[match.get(it) as EObject]
		val trgParamToEObjectMap = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.TRG].toInvertedMap[match.get(it) as EObject]
		val nonCorrParamToEObjectMap = srcParamToEObjectMap.union(trgParamToEObjectMap)
		val nonCorrEObjectMapping = mapEObjects(nonCorrParamToEObjectMap.values)
		
		val corrEdges = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.CORR]
											.map[match.get(it) as EObject]
											.map[(it.eGet(it.eClass.getEStructuralFeature("source")) as EObject -> it.eGet(it.eClass.getEStructuralFeature("target")) as EObject) -> it.eClass.name]
		
		'''
			@startuml
			«plantUMLPreamble»
			
			«visualiseRule(rule, true, userOptions.displayFullRuleForMatches, userOptions.op, userOptions.corrLabelVisualization)»
			
			«visualiseEObjectGraph(mapEObjects(srcParamToEObjectMap.values), mapEObjects(trgParamToEObjectMap.values), corrEdges, userOptions.corrLabelVisualization)»
			
			«FOR String param : nonCorrParamToEObjectMap.keySet»
				«paramToNodeIdMap.get(param)» #.[#Blue]..# «nonCorrEObjectMapping.get(nonCorrParamToEObjectMap.get(param)).key»
			«ENDFOR»
			
			@enduml
		'''
	}
	
	def static String visualiseObjectGraph(TGGObjectGraph eObjects, VisualizationLabelOptions corrLabelVisualizationOption) {
		'''
			@startuml
			«plantUMLPreamble»

			«visualiseEObjectGraph(
				mapEObjects(eObjects.srcElements),
				mapEObjects(eObjects.trgElements),
				eObjects.corrElements.map[
					(it.eGet(it.eClass.getEStructuralFeature("source")) as EObject 
						-> it.eGet(it.eClass.getEStructuralFeature("target")) as EObject)
				 			-> it.eClass.name
				], corrLabelVisualizationOption)»
			
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

			skinparam object {
				BorderColor Black
				BackgroundColor<<TRG>> MistyRose
				BackgroundColor<<SRC>> LightYellow
				BackgroundColor<<CORR>> LightCyan 
				ArrowColor Black
			}
		'''
	}
	
	private def static String visualiseRule(TGGRule rule, boolean groupFullRule, boolean showCreated, IBeXOp op, VisualizationLabelOptions corrLabelVisualizationOption) {
		
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
						«visualiseRuleCorrEdge(nodeIdMap.get(corrNode.source), nodeIdMap.get(corrNode.target), corrNode.type.name, corrNode.bindingType === BindingType.CREATE, corrLabelVisualizationOption)»
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
	
	private def static String visualiseEObjectGraph(Map<EObject, Pair<String, String>> srcObjectMapping, Map<EObject, Pair<String, String>> trgObjectMapping, Iterable<Pair<Pair<EObject, EObject>, String>> corrEdges, VisualizationLabelOptions corrLabelVisualizationOption) {
		'''
		together {
			«visualiseEObjectGroup(srcObjectMapping, "<<SRC>>")»
			«visualiseEObjectGroup(trgObjectMapping, "<<TRG>>")»
			
			«IF corrEdges !== null»
				«FOR edge : corrEdges»
					«srcObjectMapping.get(edge.key.key).key» ... «trgObjectMapping.get(edge.key.value).key» «getLabel(edge.value, corrLabelVisualizationOption)»
				«ENDFOR»
			«ENDIF»
		}
		'''
	}
	
	private def static String visualiseEObjectGroup(Map<EObject, Pair<String, String>> eObjectMapping, String colorDefinitions) {
		'''
			together {
				«FOR object: eObjectMapping.keySet»
					object "«eObjectMapping.get(object).value»" as «eObjectMapping.get(object).key» «colorDefinitions» {
						«FOR EAttribute attr : object.eClass.EAttributes»
							«attr.EType.name» «attr.name» «object.eGet(attr)»
						«ENDFOR»
					}
				«ENDFOR»
				
				«FOR object: eObjectMapping.keySet»
					«FOR contentObject : object.eContents»
						«IF eObjectMapping.containsKey(contentObject)»
							«eObjectMapping.get(object).key» --> «eObjectMapping.get(contentObject).key» : «contentObject.eContainingFeature.name»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}
	
	private def static Map<EObject, Pair<String, String>> mapEObjects(Collection<EObject> eObjects) {
		eObjects.toInvertedMap[
				val id = labelFor(it) + "_" + indexFor(it)
				val label = id + " : " + it.eClass.name
				id->label
			]
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
	
	private def static String visualiseRuleCorrEdge(String srcNodeId, String trgNodeId, String edgeId, boolean bindingTypeCreate, VisualizationLabelOptions corrLabelVisualizationOption) {
		'''«srcNodeId» ...«IF (bindingTypeCreate)»[#SpringGreen]«ENDIF» «trgNodeId» «getLabel(edgeId, corrLabelVisualizationOption)»'''
	}
	
	private def static String idForNode(TGGRuleNode node) {
		'''"«node.name» : «node.type.name»"'''
	}
	
	private def static String getLabel(String name, VisualizationLabelOptions labelOptions) {
		switch(labelOptions) {
			case FULLNAME: ''': "«name»"'''
			case ABBREVIATED : ''': "«StringUtils.abbreviateMiddle(name, "...", 10)»"'''
			case NONE: ''
		}
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