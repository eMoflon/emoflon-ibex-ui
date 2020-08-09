package org.emoflon.ibex.tgg.integrate.generator

import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.emoflon.ibex.tgg.integrate.api.IConflictResolutionStrategy
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.ConflictContainer
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.MatchAnalysis
import javax.inject.Inject
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict

class ConflictResolutionStrategyGenerator {

	@Inject VariableGenerator variableGenerator

	def doGenerate(ConflictResolutionStrategy strategy, QualifiedName packageName, String className,
		IFileSystemAccess2 fsa) {
		val fileName = packageName.toString("/") + "/" + className + ".java"
		fsa.generateFile(fileName, '''
			package «packageName»;
			
			public class «className» implements «IConflictResolutionStrategy.name» {
				
				@Override
				public boolean canSolve(«Conflict.name» conflict, «MatchAnalysis.name» matchAnalysis) {
				«FOR variable : strategy.variables»
					«variableGenerator.generate(variable)»
				«ENDFOR»
				return false;
				}
				
				@Override
				public void solve(«Conflict.name» conflict, «MatchAnalysis.name» matchAnalysis) {
				}
			}
		''')
	}
}
