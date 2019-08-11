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
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider
import java.util.ArrayList
import org.eclipse.emf.ecore.EReference
import java.util.HashMap
import org.eclipse.emf.ecore.util.EContentsEList

class VictoryPlantUMLGenerator {

	static val createColor = "SpringGreen"
	static val contextColor = "Black"
	static val translateColor = "Gainsboro"
	static val srcColor = "LightYellow"
	static val trgColor = "MistyRose"
	static val corrColor = "LightCyan"

	def static String visualiseTGGRule(TGGRule rule, IUserOptions userOptions) {
		val nodeIdMap = rule.nodes.toInvertedMap[idForNode]
		'''
			@startuml
			«plantUMLPreamble»
			
			«visualiseRule(rule, false, true, true, true, true, userOptions, nodeIdMap)»
			
			@enduml
		'''
	}

	def static String visualiseMatch(IMatch match, TGGRule rule, IUserOptions userOptions,
		IVictoryDataProvider dataProvider) {

		val paramToNodeMap = match.parameterNames.toInvertedMap[param|rule.nodes.findFirst[node|param === node.name]]
		val nodeIdMap = rule.nodes.toInvertedMap[idForNode]
		val srcParamToEObjectMap = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.SRC].
			toInvertedMap[match.get(it) as EObject]
		val trgParamToEObjectMap = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.TRG].
			toInvertedMap[match.get(it) as EObject]
		val nonCorrParamToEObjectMap = srcParamToEObjectMap.union(trgParamToEObjectMap)
		val nonCorrEObjectMapping = mapEObjects(nonCorrParamToEObjectMap.values, userOptions.nodeLabelVisualization)

		val corrEdges = match.parameterNames.filter[paramToNodeMap.get(it).domainType === DomainType.CORR].map [
			match.get(it) as EObject
		].map [
			(it.eGet(it.eClass.getEStructuralFeature("source")) as EObject ->
				it.eGet(it.eClass.getEStructuralFeature("target")) as EObject) -> it.eClass.name
		]

		val srcEObjects = dataProvider.getMatchNeighbourhoods(srcParamToEObjectMap.values, userOptions.neighborhoodSize)
		val trgEObjects = dataProvider.getMatchNeighbourhoods(trgParamToEObjectMap.values, userOptions.neighborhoodSize)
		// TODO can we deal with corrs in this context?

		val noteText = '''
			«IF srcParamToEObjectMap.empty && trgParamToEObjectMap.empty && !userOptions.displayFullRuleForMatches»
				Rule application does not require context.
			«ENDIF»
			«IF !userOptions.displayFullRuleForMatches»
				Created elements are hidden.
			«ENDIF»
			«IF !userOptions.displaySrcContextForMatches»
				SRC elements are hidden.
			«ENDIF»
			«IF !userOptions.displayTrgContextForMatches»
				TRG elements are hidden.
			«ENDIF»
			«IF !userOptions.displayCorrContextForMatches»
				CORR elements are hidden.
			«ENDIF»
		'''
		
		'''
			@startuml
			«plantUMLPreamble»
			«visualiseRule(rule, true, userOptions.displayFullRuleForMatches, userOptions.displaySrcContextForMatches, userOptions.displayTrgContextForMatches, userOptions.displayCorrContextForMatches, userOptions, nodeIdMap)»
			«IF noteText != ""»
				note as n0
					«noteText»
				end note
			«ENDIF»
			«visualiseEObjectGraph(
							mapEObjects(srcEObjects, userOptions.nodeLabelVisualization), 
							mapEObjects(trgEObjects, userOptions.nodeLabelVisualization), 
							corrEdges, 
							userOptions.displayFullRuleForMatches, userOptions.displaySrcContextForMatches, userOptions.displayTrgContextForMatches, userOptions.displayCorrContextForMatches,
							userOptions 
						)»
			
			«FOR String param : nonCorrParamToEObjectMap.keySet»
				«IF (paramToNodeMap.get(param).domainType === DomainType.SRC && userOptions.displaySrcContextForMatches)
					|| (paramToNodeMap.get(param).domainType === DomainType.TRG && userOptions.displayTrgContextForMatches)»
					«nodeIdMap.get(paramToNodeMap.get(param))» #.[#Blue]..# «nonCorrEObjectMapping.get(nonCorrParamToEObjectMap.get(param)).key»
				«ENDIF»
			«ENDFOR»
			
			@enduml
		'''
	}

	def static String visualiseObjectGraph(TGGObjectGraph eObjects, IUserOptions userOptions, IVictoryDataProvider dataProvider) {
		'''
			@startuml
			«plantUMLPreamble»
			
			«visualiseEObjectGraph(
				mapEObjects(dataProvider.getMatchNeighbourhoods(eObjects.srcElements, userOptions.neighborhoodSize), userOptions.nodeLabelVisualization),
				mapEObjects(dataProvider.getMatchNeighbourhoods(eObjects.trgElements, userOptions.neighborhoodSize), userOptions.nodeLabelVisualization),
				eObjects.corrElements.map[
					(it.eGet(it.eClass.getEStructuralFeature("source")) as EObject 
						-> it.eGet(it.eClass.getEStructuralFeature("target")) as EObject)
				 			-> it.eClass.name
				], true, true, true, true, userOptions)»
			
			@enduml
		'''
	}

	private def static String plantUMLPreamble() {
		'''
			hide empty members
			hide circle
			hide stereotype
			
			skinparam shadowing false
			
			skinparam class {
				BorderColor<<CREATE>> «createColor»
				BorderColor<<TRANSLATE>> «translateColor»
				BorderColor<<OTHER>> «contextColor»
				BackgroundColor<<TRG>> «trgColor»
				BackgroundColor<<SRC>> «srcColor»
				BackgroundColor<<CORR>> «corrColor»
				ArrowColor «contextColor»
			}
			
			skinparam object {
				BorderColor «contextColor»
				BackgroundColor<<TRG>> «trgColor»
				BackgroundColor<<SRC>> «srcColor»
				BackgroundColor<<CORR>> «corrColor» 
				ArrowColor «contextColor»
			}
		'''
	}

	private def static String visualiseRule(TGGRule rule, boolean groupFullRule, boolean showCreated, boolean showSrc,
		boolean showTrg, boolean showCorr, IUserOptions userOptions, Map<TGGRuleNode, String> nodeIdMap) {

		val nodeGroupMap = rule.nodes.groupBy[it.domainType]
		val hasCorrNodes = nodeGroupMap.containsKey(DomainType.CORR);
		val srcNodesConnectedByCorr = if(hasCorrNodes) nodeGroupMap.get(DomainType.CORR).filter [
				(showCreated || it.bindingType !== BindingType.CREATE)
			].map[(it as TGGRuleCorr).source].toList else new ArrayList
		val trgNodesConnectedByCorr = if(hasCorrNodes) nodeGroupMap.get(DomainType.CORR).filter [
				(showCreated || it.bindingType !== BindingType.CREATE)
			].map[(it as TGGRuleCorr).target].toList else new ArrayList

		'''
			«IF groupFullRule»together {«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.SRC)»
				together {
					«FOR node : nodeGroupMap.get(DomainType.SRC)»
						«IF (showSrc && (showCreated || node.bindingType !== BindingType.CREATE || isToBeTranslatedElement(node.bindingType, node.domainType, userOptions.op))) || (showCorr && srcNodesConnectedByCorr.contains(node))»
							«visualiseRuleNode(
								nodeIdMap.get(node), 
								org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator.getNodeLabel(node.name, node.type.name, userOptions.nodeLabelVisualization), 
								getColorDefinitions(node.bindingType, node.domainType, userOptions.op)
							)»
						«ENDIF»
					«ENDFOR»
				}
			«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.TRG)»
				together {
					«FOR node : nodeGroupMap.get(DomainType.TRG)»
						«IF (showTrg && (showCreated || node.bindingType !== BindingType.CREATE || isToBeTranslatedElement(node.bindingType, node.domainType, userOptions.op))) || (showCorr && trgNodesConnectedByCorr.contains(node))»
							«visualiseRuleNode(
								nodeIdMap.get(node), 
								org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator.getNodeLabel(node.name, node.type.name, userOptions.nodeLabelVisualization), 
								getColorDefinitions(node.bindingType, node.domainType, userOptions.op)
							)»
						«ENDIF»
					«ENDFOR»
				}
			«ENDIF»
			
			«IF nodeGroupMap.containsKey(DomainType.CORR) && showCorr»
				«FOR node : nodeGroupMap.get(DomainType.CORR)»
					«val corrNode = node as TGGRuleCorr»
					«IF showCreated || corrNode.bindingType !== BindingType.CREATE || isToBeTranslatedElement(node.bindingType, node.domainType, userOptions.op)»
						«visualiseRuleCorrEdge(
							nodeIdMap.get(corrNode.source), 
							nodeIdMap.get(corrNode.target), 
							corrNode.type.name, 
							corrNode.bindingType === BindingType.CREATE, 
							userOptions.corrLabelVisualization
						)»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
			
			«FOR edge : rule.edges»
				«IF (edge.domainType == DomainType.SRC && showSrc && (showCreated || edge.bindingType !== BindingType.CREATE || isToBeTranslatedElement(edge.bindingType, edge.domainType, userOptions.op)))
					|| (edge.domainType == DomainType.TRG && showTrg && (showCreated || edge.bindingType !== BindingType.CREATE || isToBeTranslatedElement(edge.bindingType, edge.domainType, userOptions.op)))»
					«visualiseRuleEdge(
						nodeIdMap.get(edge.srcNode), 
						nodeIdMap.get(edge.trgNode), 
						edge.type.name, 
						getColorDefinitionsForEdge(edge.bindingType, edge.domainType, userOptions), 
						userOptions.edgeLabelVisualization
					)»
				«ENDIF»
			«ENDFOR»
			
			«IF groupFullRule»}«ENDIF»
		'''
	}

	private def static String visualiseEObjectGraph(Map<EObject, Pair<String, String>> srcObjectMapping,
		Map<EObject, Pair<String, String>> trgObjectMapping, Iterable<Pair<Pair<EObject, EObject>, String>> corrEdges,
		boolean showCreated, boolean showSrc, boolean showTrg, boolean showCorr, IUserOptions userOptions) {
		
		val srcObjectConnectedByCorr = corrEdges.map[edge | edge.key.key];
		val trgObjectConnectedByCorr = corrEdges.map[edge | edge.key.value];
		val srcCorrConnectedObjectMapping = srcObjectMapping.filter[p1, p2| srcObjectConnectedByCorr.toList.contains(p1)]
		val trgCorrConnectedObjectMapping = trgObjectMapping.filter[p1, p2| trgObjectConnectedByCorr.toList.contains(p1)]
		'''
			together {
				«IF showSrc»
					«visualiseEObjectGroup(srcObjectMapping, "<<SRC>>")»
				«ELSE»
					«IF showCorr»
					«visualiseEObjectGroup(srcCorrConnectedObjectMapping, "<<SRC>>")»
					«ENDIF»
				«ENDIF»
				«IF showTrg»
					«visualiseEObjectGroup(trgObjectMapping, "<<TRG>>")»
				«ELSE»
					«IF showCorr»
						«visualiseEObjectGroup(trgCorrConnectedObjectMapping, "<<TRG>>")»
					«ENDIF»
				«ENDIF»
				
				«IF corrEdges !== null && showCorr»
					«FOR edge : corrEdges»
						«srcObjectMapping.get(edge.key.key).key» ... «trgObjectMapping.get(edge.key.value).key» «getEdgeLabel(edge.value, userOptions.corrLabelVisualization)»
					«ENDFOR»
				«ENDIF»
			}
		'''
	}

	private def static String visualiseEObjectGroup(Map<EObject, Pair<String, String>> eObjectMapping,
		String colorDefinitions) {
		'''
			together {
				«FOR object : eObjectMapping.keySet»
					object "«eObjectMapping.get(object).value»" as «eObjectMapping.get(object).key» «colorDefinitions» {
						«FOR EAttribute attr : object.eClass.EAttributes»
							«attr.EType.name» «attr.name» «object.eGet(attr)»
						«ENDFOR»
					}
				«ENDFOR»
				
				«FOR object : eObjectMapping.keySet»
					«FOR contentObject : object.eContents»
						«IF eObjectMapping.containsKey(contentObject)»
							«eObjectMapping.get(object).key» --> «eObjectMapping.get(contentObject).key» : «contentObject.eContainingFeature.name»
						«ENDIF»
					«ENDFOR»
					«FOR crossReference : object.crossReferences.entrySet»
						«IF eObjectMapping.containsKey(crossReference.key)»
							«eObjectMapping.get(object).key» --> «eObjectMapping.get(crossReference.key).key» : «crossReference.value.name»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}
	
	private def static Map<EObject,EReference> getCrossReferences(EObject object) {
		var map = new HashMap<EObject, EReference>();
		var featureIterator = object.eCrossReferences().iterator() as EContentsEList.FeatureIterator<EObject>
		while(featureIterator.hasNext) {
			var eObject = featureIterator.next() as EObject;
	    	var eReference = featureIterator.feature() as EReference;
	    	map.put(eObject, eReference)
		}
		
		return map;		
	}

	private def static Map<EObject, Pair<String, String>> mapEObjects(Collection<EObject> eObjects,
		VisualizationLabelOptions nodeLabelVisualizationOptions) {
		eObjects.toInvertedMap [
			val id = labelFor(it) + "_" + indexFor(it)
			val label = org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator.getNodeLabel(id, it.eClass.name,
				nodeLabelVisualizationOptions)
			id -> label
		]
	}

	private def static String labelFor(EObject object) {
		if (object.eContainingFeature() !== null) {
			return object.eContainingFeature().getName();
		} else {
			return "root";
		}
	}

	private def static String indexFor(EObject object) {
		if (object.eContainer() === null) {
			val resource = object.eResource()
			return resource.getResourceSet().getResources().indexOf(resource) + "_" +
				resource.getContents().indexOf(object)
		} else {
			val container = object.eContainer()
			return indexFor(container) + "_" + container.eContents().indexOf(object)
		}
	}

	private def static String visualiseRuleNode(String ruleId, String nodeLabel, String colorDefinitions) {
		'''class "«nodeLabel»" as «ruleId» «colorDefinitions»'''
	}

	private def static String visualiseRuleEdge(String srcNodeId, String trgNodeId, String edgeId,
		String colorDefinitions, VisualizationLabelOptions edgeVisualizationOptions) {

		'''«srcNodeId» -«colorDefinitions»-> «trgNodeId» «getEdgeLabel(edgeId, edgeVisualizationOptions)»'''
	}

	private def static String visualiseRuleCorrEdge(String srcNodeId, String trgNodeId, String edgeId,
		boolean bindingTypeCreate, VisualizationLabelOptions corrLabelVisualizationOption) {
		'''«srcNodeId» ...«IF (bindingTypeCreate)»[#«createColor»]«ENDIF» «trgNodeId» «getEdgeLabel(edgeId, corrLabelVisualizationOption)»'''
	}

	private def static String idForNode(TGGRuleNode node) {
		'''«node.type.name»_«java.util.UUID.randomUUID().toString().replace("-","_")»'''
	}

	private def static String getColorDefinitionsForEdge(BindingType binding, DomainType domain, IUserOptions userOptions) {
		var bindingColor = if(isToBeTranslatedElement(binding, domain, userOptions.op)) {
			translateColor
		} else if (binding === BindingType.CREATE) {
			createColor
		} else {
			contextColor
		}
		'''[#«bindingColor»]'''
	}

	private def static String getEdgeLabel(String name, VisualizationLabelOptions labelOptions) {
		if (labelOptions == VisualizationLabelOptions.NONE) {
			''
		} else {
			''': «getAbbreviatedName(name, labelOptions)»'''
		}
	}

	private def static String getNodeLabel(String name, String type, VisualizationLabelOptions labelOptions) {
		if (labelOptions == VisualizationLabelOptions.NONE) {
			'''«getAbbreviatedName(name, labelOptions)» : «getAbbreviatedName(type, VisualizationLabelOptions.ABBREVIATED)»'''
		} else {
			'''«getAbbreviatedName(name, labelOptions)» : «getAbbreviatedName(type, labelOptions)»'''
		}

	}

	private def static String getAbbreviatedName(String name, VisualizationLabelOptions labelOptions) {
		switch (labelOptions) {
			case FULLNAME: return '''«name»'''
			case ABBREVIATED: return '''«StringUtils.abbreviateMiddle(name, "...", 10)»'''
			case NONE: return ''''''
		}
	}

	private def static String getColorDefinitions(BindingType binding, DomainType domain, IBeXOp op) {

		var bindingColor = if(isToBeTranslatedElement(binding, domain, op)) {
			"TRANSLATE"
		} else if (binding === BindingType.CREATE) {
			"CREATE"
		} else {
			"OTHER"
		}

		'''<<«bindingColor»>> <<«domain»>>'''
	}
	
	private def static boolean isToBeTranslatedElement(BindingType binding, DomainType domain, IBeXOp op) {
		return binding === BindingType.CREATE && 
			((op === IBeXOp.INITIAL_FWD && domain === DomainType.SRC)  ||
				(op === IBeXOp.INITIAL_BWD && domain === DomainType.TRG))
	}
}
