package org.emoflon.ibex.tgg.ide.visualisation

import java.util.Collection
import org.apache.commons.lang3.tuple.Pair
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.moflon.tgg.mosl.tgg.CorrVariablePattern
import org.moflon.tgg.mosl.tgg.LinkVariablePattern
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern
import org.moflon.tgg.mosl.tgg.Operator
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
import java.util.HashMap

class IbexPlantUMLGenerator {
	
	private static var idMap = new HashMap<EObject, String>();
	
	public static def String wrapInTags(String body){
		'''
		@startuml
		«body»
		@enduml
		'''
	}
	
	public static def String emptyDiagram(){
		'''
		title Choose an element that can be visualised
		'''
	}
	
	public static def String visualiseTGGFile(TripleGraphGrammarFile file) {
		'''
		«IF file.rules.length != 1»title "I can only visualise exactly one TGG rule in one file"
		«ELSE»
		«var r = file.rules.get(0)»
		digraph root {
			fontname=Monospace
			fontsize=9
			subgraph "cluster_source" {
				 label="";
				 pencolor="invis";
			     «FOR sp : r.sourcePatterns»
			    	«visualisePattern(sp, "LIGHTYELLOW")»
			     «ENDFOR»
			}
			subgraph "cluster_target" {
				 label="";
				 pencolor="invis";
				 «FOR sp : r.targetPatterns»
				 	«visualisePattern(sp, "MISTYROSE")»
				 «ENDFOR»
			}
			subgraph "correspondence" {
				 label="";
				 pencolor="invis";
				 «FOR cp : r.correspondencePatterns»
				 	«visualiseCorrs(cp)»
				 «ENDFOR»
			}
		}
		«ENDIF»
		'''
	}
	
	private def static visualiseCorrs(CorrVariablePattern corr) {
		'''
		«idForPattern(corr.source)» -> «idForPattern(corr.target)» [penwidth=7, dir="both", style="tapered", arrowtail="none", arrowhead="none", color=«operatorToColour(corr.op)», constraint=false];
		'''
	}
	
	private def static visualisePattern(ObjectVariablePattern p, String domainColour) {
		'''
		 «idForPattern(p)» [fontsize=9, fontname=Monospace, penwidth=1, shape=record, color=«operatorToColour(p.op)», fillcolor=«domainColour», label="{«p.name» : «p.type.name» | }",style=filled];
		 «FOR lv : p.linkVariablePatterns»
		 «visaliseLinkVariable(p, lv)»
		 «ENDFOR»
		'''
	}
	
	private def static idForPattern(ObjectVariablePattern p) {
		'''"«p.name» : «p.type.name»"'''
	}
	
	private def static visaliseLinkVariable(ObjectVariablePattern src, LinkVariablePattern p) {
		'''«idForPattern(src)» -> «idForPattern(p.target)» [fontname=Monospace, penwidth=1, color=«operatorToColour(p.op)», label="«p.type.name»", fontsize=8, constraint=true];'''
	}
	
	private def static operatorToColour(Operator op) {
		if(op != null)
			return "GREEN"
		else
			return "BLACK"
	}
	
	public def static String visualiseEcoreElements(Collection<EClass> eclasses, Collection<EReference> refs){
		'''
		«FOR c : eclasses»
		class «identifierForClass(c)»
			«FOR s : c.ESuperTypes»
			«identifierForClass(c)»--|>«identifierForClass(s)»
			«ENDFOR»
		«ENDFOR»
		«FOR r : refs»
		«identifierForClass(r.EContainingClass)»«IF r.isContainment» *«ENDIF»--> «multiplicityFor(r)» «identifierForClass(r.EReferenceType)» : "«r.name»"
		«ENDFOR»
		'''
	}
	
	private def static multiplicityFor(EReference r) {
		'''"«IF r.lowerBound == -1»*«ELSE»«r.lowerBound»«ENDIF»..«IF r.upperBound == -1»*«ELSE»«r.upperBound»«ENDIF»"'''
	}
	
	private def static String identifierForClass(EClass c)
		'''"«c.EPackage.name».«c.name»"'''
		
	public def static String visualiseModelElements(Collection<EObject> objects, Collection<Pair<String, Pair<EObject, EObject>>> links){
		idMap.clear
		
		'''
		«FOR o : objects»
		object «identifierForObject(o)»{
			«visualiseAllAttributes(o)»
		}
		«ENDFOR»
		«FOR l : links»
		«identifierForObject(l.right.left)» --> «identifierForObject(l.right.right)» : "«l.left»"
		«ENDFOR»
		'''
	}
	
	def static visualiseAllAttributes(EObject o) {
		'''
		«FOR a : o.eClass.EAllAttributes»
			«a.name» = «o.eGet(a)»
		«ENDFOR»
		'''
	}
	
	private def static Object identifierForObject(EObject o){
		if(!idMap.containsKey(o))
			idMap.put(o, '''o«idMap.keySet.size + 1»''')
			
		'''«idMap.get(o)».«o.eClass.name»'''	
	}
	
	public def static String visualiseTGGRuleOverview(TripleGraphGrammarFile tgg){
		'''
		digraph root {
			fontname=Monospace
			fontsize=9
			label="";
		«FOR r:tgg.rules»
			"«r.name»" [fontsize=9, fontname=Monospace, shape=box, color=«IF r.abstractRule»GREY«ELSE»BLACK«ENDIF», style=rounded, href=""];
		«ENDFOR»
		«FOR r:tgg.rules»
			«FOR sup:r.supertypes»
				"«r.name»" -> "«sup.name»" [penwidth=1, arrowtail="none", arrowhead="onormal", color=BLACK, constraint=true];
			«ENDFOR»
		«ENDFOR»
		«FOR r:tgg.rules»
			«IF r.kernel != null»
				"«r.kernel.name»" -> «r.name» [penwidth=1, dir="both", arrowtail="odiamond", arrowhead="vee", label=" 0..*", fontsize=8, color=BLACK, constraint=true];
			«ENDIF»
		«ENDFOR»
		}
		'''
	}
}
