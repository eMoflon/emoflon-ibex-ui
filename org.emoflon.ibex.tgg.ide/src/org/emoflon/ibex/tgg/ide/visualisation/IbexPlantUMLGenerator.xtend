package org.emoflon.ibex.tgg.ide.visualisation

import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.Optional
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.tuple.Pair
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern
import org.moflon.tgg.mosl.tgg.CorrVariablePattern
import org.moflon.tgg.mosl.tgg.LinkVariablePattern
import org.moflon.tgg.mosl.tgg.Nac
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern
import org.moflon.tgg.mosl.tgg.Operator
import org.moflon.tgg.mosl.tgg.Rule
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
	
	public static def String visualiseTGGFile(TripleGraphGrammarFile file, Optional<String> selected) {
		if (!selected.present)
			return '''title Choose the name of a single TGG rule or NAC to visualise it!'''
		else {
			val chosenRule = file.rules.filter[r | r.name.equals(selected.get)]
			if(chosenRule.length == 1)
				return visualiseTGGRule(chosenRule.get(0))
			else {
				val chosenNac = file.nacs.filter[n | n.name.equals(selected.get)]
				if(chosenNac.length == 1)
				return visualiseNAC(chosenNac.get(0))
				else
					return '''title I don't know how to visualise "«StringUtils.abbreviate(selected.get.replaceAll("\\s+",""), 20)»"...'''		
			}
		}	
	}
	
	def static String visualiseNAC(Nac n) {
		'''
			«plantUMLPreamble»
			
			«IF (n.targetPatterns.empty)»
				together {
					«FOR sp : n.sourcePatterns»
						«visualiseContextPattern(sp, "SRC")»
					«ENDFOR»
				}
				
				namespace «n.rule.name» <<frame>> {
					«FOR sp : n.rule.sourcePatterns»
						«visualisePattern(sp, "SRC")»
					«ENDFOR»
				}
				
				«connectSameObjectVariables(n.sourcePatterns, n.rule.sourcePatterns, n.rule.name)»
			«ELSE»
				together {
					«FOR tp : n.targetPatterns»
						«visualiseContextPattern(tp, "TRG")»
					«ENDFOR»
				}
				
				namespace «n.rule.name» <<frame>> {
					«FOR tp : n.rule.targetPatterns»
						«visualisePattern(tp, "TRG")»
					«ENDFOR»
				}
				
				
				«connectSameObjectVariables(n.targetPatterns, n.rule.targetPatterns, n.rule.name)»
			«ENDIF»
		'''
	}
	
	def static connectSameObjectVariables(EList<ContextObjectVariablePattern> nac, EList<ObjectVariablePattern> rule, String ruleName) {
		nac.filter[ov | refInRule(rule, ov) !== null]
		   .map[ ov | '''«idForPattern(ov.name, ov.type.name)» .. «idForPattern(ruleName, refInRule(rule, ov).name, refInRule(rule, ov).type.name)»''']
		   .join("\n")
	}
	
	protected def static ObjectVariablePattern refInRule(EList<ObjectVariablePattern> rule, ContextObjectVariablePattern ov) {
		rule.findFirst[_ov | _ov.name.equals(ov.name)]
	}
	
	def static visualiseContextPattern(ContextObjectVariablePattern p, String domain) {
		'''
		 class «idForPattern(p.name, p.type.name)» <<BLACK>> <<«domain»>>
		 «FOR lv : p.linkVariablePatterns»
		 	«visaliseContextLinkVariable(p, lv)»
		 «ENDFOR»
		'''
	}
	
	def static visaliseContextLinkVariable(ContextObjectVariablePattern src, ContextLinkVariablePattern p) {
		'''«idForPattern(src.name, src.type.name)» --> «idForPattern(p.target.name, p.target.type.name)» : " «p.type.name»"'''
	}
	
	def static String visualiseTGGRule(Rule r) {
		'''
			«plantUMLPreamble»
			
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
		'''
	}
	
	protected def static CharSequence plantUMLPreamble(){
		'''
			hide empty members
			hide circle
			hide stereotype
			
			skinparam shadowing false
			
			skinparam class {
				BorderColor<<GREEN>> SpringGreen
				BorderColor<<BLACK>> Black
				BackgroundColor<<TRG>> MistyRose
				BackgroundColor<<SRC>> LightYellow
				BackgroundColor<<CORR>> LightCyan 
				ArrowColor Black
			}	
		'''
	}
	
	private def static visualiseCorrs(CorrVariablePattern corr) {
		'''
		«idForPattern(corr.source.name, corr.source.type.name)» ...«IF (corr.op !== null)»[#SpringGreen]«ENDIF» «idForPattern(corr.target.name, corr.target.type.name)» : «StringUtils.abbreviate(corr.name + ":" + corr.type.name, 11)»
		'''
	}
	
	private def static visualisePattern(ObjectVariablePattern p, String domain) {
		'''
		 class «idForPattern(p.name, p.type.name)» <<«opToColour(p.op)»>> <<«domain»>>
		 «FOR lv : p.linkVariablePatterns»
		 	«org.emoflon.ibex.tgg.ide.visualisation.IbexPlantUMLGenerator.visualiseLinkVariable(p, lv)»
		 «ENDFOR»
		'''
	}
	
	private def static String idForPattern(String namespace, String name, String typeName) {
		'''"«namespace».«name» : «typeName»"'''
	}
	
	private def static String idForPattern(String name, String typeName) {
		'''"«name» : «typeName»"'''
	}
	
	private def static visualiseLinkVariable(ObjectVariablePattern src, LinkVariablePattern p) {
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
			BackGroundColor<<NAC>> #ff6666
			BorderColor Black
			ArrowColor Black
		}
		
		«FOR r:tgg.rules»
			 «IF r.abstractRule»abstract«ENDIF» class "«r.name»" «platformURIToRule(projectName, r.name)»
		«ENDFOR»
		«FOR r:tgg.complementRules»
			 class "«r.name»" «platformURIToRule(projectName, r.name)»
		«ENDFOR»
		«FOR n:tgg.nacs»
			class "«n.name»"<<NAC>> «platformURIToRule(projectName, n.name)»
			"«n.rule.name»" --> "«n.name»"
		«ENDFOR»
		«FOR r:tgg.rules»
			«FOR sup:r.supertypes»
				"«r.name»" -up-|> "«sup.name»"
			«ENDFOR»
		«ENDFOR»
		«FOR r:tgg.complementRules»
			«IF r.kernel !== null»
				"«r.kernel.name»" *--> "0..*" "«r.name»"
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	def static platformURIToRule(String projectName, String ruleName) {
		val files = WorkspaceHelper.getProjectByName(projectName).allFiles.filter[f | f.name.endsWith(ruleName + ".tgg")]
		if(files.size == 1)
			'''[[platform:/resource/«projectName»/«files.get(0).projectRelativePath»]]'''
		else
			''' '''
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
