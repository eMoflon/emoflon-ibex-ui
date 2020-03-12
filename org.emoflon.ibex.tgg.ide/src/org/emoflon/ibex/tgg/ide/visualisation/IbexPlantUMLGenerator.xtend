package org.emoflon.ibex.tgg.ide.visualisation

import java.util.ArrayList
import org.apache.commons.lang3.StringUtils
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.util.EcoreUtil
import org.emoflon.ibex.tgg.ide.transformation.EditorTGGtoFlattenedTGG
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator
import org.moflon.core.utilities.WorkspaceHelper
import org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern
import org.moflon.tgg.mosl.tgg.CorrVariablePattern
import org.moflon.tgg.mosl.tgg.LinkVariablePattern
import org.moflon.tgg.mosl.tgg.Nac
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern
import org.moflon.tgg.mosl.tgg.Operator
import org.moflon.tgg.mosl.tgg.Rule
import org.moflon.tgg.mosl.tgg.TggFactory
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
 
class IbexPlantUMLGenerator {
  
	def static String visualiseTGGFile(TripleGraphGrammarFile file, String selected) {
		val chosenRule = file.rules.filter[r|r.name.equals(selected)]
		if (chosenRule.length == 1) {
			return visualiseTGGRule(chosenRule.get(0))
		}
 
		val chosenNac = file.nacs.filter[n|n.name.equals(selected)]
		if (chosenNac.length == 1) {
			return visualiseNAC(chosenNac.get(0))
		}

		return '''title I don't know how to visualise "«StringUtils.abbreviate(selected.replaceAll("\\s+",""), 20)»"...'''
	}

	def static String visualiseNAC(Nac n) {
		val file = TggFactory.eINSTANCE.createTripleGraphGrammarFile;
		file.rules.add(EcoreUtil.copy(n.rule));
		val flattenedTGG = new EditorTGGtoFlattenedTGG().flatten(file);
		val ruleOp = flattenedTGG.map([tgg|tgg.rules.get(0)]);
		return ruleOp.map([ rule |
			'''
				«EMoflonPlantUMLGenerator.plantUMLPreamble»
				
				«IF (!n.sourcePatterns.empty)»
					together {
						«FOR sp : n.sourcePatterns»
							«visualiseContextPattern(sp, "SRC")»
						«ENDFOR»
					}
					
					namespace «rule.name» <<frame>> {
						«FOR sp : rule.sourcePatterns»
							«visualisePattern(sp, "SRC")»
						«ENDFOR»
					}
					
					«connectSameObjectVariables(n.sourcePatterns, rule.sourcePatterns, rule.name)»
				«ELSEIF (!n.targetPatterns.empty)»
					together {
						«FOR tp : n.targetPatterns»
							«visualiseContextPattern(tp, "TRG")»
						«ENDFOR»
					}
					
					namespace «rule.name» <<frame>> {
						«FOR tp : rule.targetPatterns»
							«visualisePattern(tp, "TRG")»
						«ENDFOR»
					}
					
					«connectSameObjectVariables(n.targetPatterns, rule.targetPatterns, rule.name)»
				«ELSE»
					namespace «rule.name» <<frame>> {
					«FOR sp : rule.sourcePatterns»
						«visualisePattern(sp, "SRC")»
					«ENDFOR»
					«FOR tp : rule.targetPatterns»
						«visualisePattern(tp, "TRG")»
					«ENDFOR»
					}
				«ENDIF»
			'''
		]).orElse("title Unable to visualise NAC")
	}


	def static connectSameObjectVariables(EList<ContextObjectVariablePattern> nac, EList<ObjectVariablePattern> rule,
		String ruleName) {
		nac.filter[ov|refInRule(rule, ov.name) !== null].map [ ov |
			'''«idForPattern(ov.name, ov.type.name)» .. «idForPattern(ruleName, refInRule(rule, ov.name).name, refInRule(rule, ov.name).type.name)»'''
		].join("\n")
	}

	// connect kernel and complement rules vars
	def static connectSameObjectVariablesCR(EList<ObjectVariablePattern> cr, EList<ObjectVariablePattern> rule,
		String ruleName) {
		cr.filter[ov|refInRule(rule, ov.name) !== null].map [ ov |
			'''«idForPattern(ov.name, ov.type.name)» .[#Blue]. «idForPattern(ruleName, refInRule(rule, ov.name).name, refInRule(rule, ov.name).type.name)»'''
		].join("\n")
	}

	protected def static ObjectVariablePattern refInRule(EList<ObjectVariablePattern> rule, String ovName) {
		rule.findFirst[_ov|_ov.name.equals(ovName)]
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
			«EMoflonPlantUMLGenerator.plantUMLPreamble»
			
			together {
				«FOR tp : r.targetPatterns»
					«visualisePattern(tp, "TRG")»
			«ENDFOR»
			}
			
			together {
			«FOR sp : r.sourcePatterns»
				«visualisePattern(sp, "SRC")»
			«ENDFOR»
			}
			
			together {
			«FOR cp : r.correspondencePatterns»
				«visualiseCorrs(cp)»
			«ENDFOR»			
			}
		'''
	}

	private def static visualiseCorrs(CorrVariablePattern corr) {
		'''
			«idForPattern(corr.source.name, corr.source.type.name)» .«IF (corr.op !== null)»[#SpringGreen]«ENDIF» «idForPattern(corr.target.name, corr.target.type.name)» : «StringUtils.abbreviate(":" + corr.type.name, 11)»
		'''
	}

	private def static visualisePattern(ObjectVariablePattern p, String domain) {
		'''
			class «idForPattern(p.name, p?.type.name)» <<«opToColour(p.op)»>> <<«domain»>>
			«FOR lv : p.linkVariablePatterns»
				«IbexPlantUMLGenerator.visualiseLinkVariable(p, lv)»
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
		if (op !== null)
			return "GREEN"
		else
			return "BLACK"
	}

	def static String visualiseTGGRuleOverview(String projectName, TripleGraphGrammarFile tgg) {
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
			
			«FOR r : tgg.rules»
				«IF r.abstractRule»abstract«ENDIF» class "«r.name»" «platformURIToRule(projectName, r.name)»
			«ENDFOR»
			«FOR n : tgg.nacs»
				class "«n.name»"<<NAC>> «platformURIToRule(projectName, n.name)»
				"«n.rule.name»" --> "«n.name»"
			«ENDFOR»
			«FOR r : tgg.rules»
				«FOR sup:r.supertypes»
					"«r.name»" -up-|> "«sup.name»"
				«ENDFOR»
			«ENDFOR»
		'''
	}

	def static platformURIToRule(String projectName, String ruleName) {
		val files = WorkspaceHelper.getProjectByName(projectName).allFiles.filter[f|f.name.equals(ruleName + ".tgg")]
		if (files.size == 1)
			'''[[platform:/resource/«projectName»/«files.get(0).projectRelativePath»]]'''
		else
			''' '''
	}

	def static IFile[] allFiles(IProject project) {
		allFileMembers(project.getFolder("src"))
	}

	def static ArrayList<IFile> allFileMembers(IFolder folder) {
		val ArrayList<IFile> files = new ArrayList()
		files.addAll(folder.members.filter[f|f instanceof IFile].map[f|f as IFile])
		folder.members.filter[f|f instanceof IFolder].forEach[f|files.addAll(allFileMembers(f as IFolder))]
		return files
	}
}
