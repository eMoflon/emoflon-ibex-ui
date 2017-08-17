package org.emoflon.ibex.tgg.ide.visualisation

import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.tuple.Pair
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.moflon.tgg.mosl.tgg.CorrVariablePattern
import org.moflon.tgg.mosl.tgg.LinkVariablePattern
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern
import org.moflon.tgg.mosl.tgg.Operator
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
import org.moflon.util.WorkspaceHelper

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
		
		hide empty members
		hide circle
		hide stereotype
		
		skinparam shadowing false
		
		skinparam class {
			BorderColor<<GREEN>> SpringGreen
			BorderColor<<BLACK>> Black
			BackgroundColor<<SRC>> MistyRose
			BackgroundColor<<TRG>> LightYellow
			BackgroundColor<<CORR>> LightCyan 
			ArrowColor Black
		}
		
		together {
		«FOR sp : r.sourcePatterns»
			«visualisePattern(sp, "SRC")»
		«ENDFOR»
		}
		
		together {
 		«FOR tp : r.targetPatterns»
			«visualisePattern(tp, "TRG")»
		«ENDFOR»
		}
		
		together {
		«FOR cp : r.correspondencePatterns»
			«visualiseCorrs(cp)»
		«ENDFOR»			
		}	
		«ENDIF»
		'''
	}
	
	private def static visualiseCorrs(CorrVariablePattern corr) {
		'''
		«idForPattern(corr.source.name, corr.source.type.name)» ...«IF (corr.op !== null)»[#SpringGreen]«ENDIF» «idForPattern(corr.target.name, corr.target.type.name)» : «StringUtils.abbreviate(corr.name + ":" + corr.type.name, 15)»
		'''
	}
	
	private def static visualisePattern(ObjectVariablePattern p, String domain) {
		'''
		 class «idForPattern(p.name, p.type.name)» <<«opToColour(p.op)»>> <<«domain»>>
		 «FOR lv : p.linkVariablePatterns»
		 	«visaliseLinkVariable(p, lv)»
		 «ENDFOR»
		'''
	}
	
	private def static String idForPattern(String name, String typeName) {
		'''"«name» : «typeName»"'''
	}
	
	private def static visaliseLinkVariable(ObjectVariablePattern src, LinkVariablePattern p) {
		'''«idForPattern(src.name, src.type.name)» -«IF (p.op !== null)»[#SpringGreen]«ENDIF»-> «idForPattern(p.target.name, p.target.type.name)» : " «p.type.name»"'''
	}
	
	private def static opToColour(Operator op) {
		if(op !== null)
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
	
	public def static String visualiseTGGRuleOverview(String projectName, TripleGraphGrammarFile tgg){
		'''
		hide empty members
		hide circle
		hide stereotype
				
		skinparam shadowing false
		
		skinparam class {
			BackgroundColor AliceBlue
			BorderColor Black
			ArrowColor Black
		}
		
		«FOR r:tgg.rules»
			 «IF r.abstractRule»abstract«ENDIF» class "«r.name»" [[«platformURIToRule(projectName, r.name)»]]
		«ENDFOR»
		«FOR r:tgg.rules»
			«FOR sup:r.supertypes»
				"«r.name»" -up-|> "«sup.name»"
			«ENDFOR»
		«ENDFOR»
		«FOR r:tgg.rules»
			«IF r.kernel !== null»
				"«r.kernel.name»" *--> "0..*" "«r.name»"
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	def static platformURIToRule(String projectName, String ruleName) {
		'''platform:/resource/«projectName»/«WorkspaceHelper.getProjectByName(projectName).allFiles.filter[f | f.name.endsWith(ruleName + ".tgg")].get(0).projectRelativePath»'''
	}
	
	def static IFile[] allFiles(IProject project){
		allFileMembers(project.getFolder("src"))
	}
	
	def static ArrayList<IFile> allFileMembers(IFolder folder){
		val ArrayList<IFile> files = new ArrayList()
		files.addAll(folder.members.filter[f | f instanceof IFile].map[f | f as IFile])
		folder.members.filter[f | f instanceof IFolder].forEach[f | files.addAll(allFileMembers(f as IFolder))]
		return files
	}
}
