package org.emoflon.ibex.tgg.integrate.generator

import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.naming.QualifiedName
import org.emoflon.ibex.tgg.integrate.api.IConflictResolutionStrategy
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict
import org.apache.commons.lang3.StringUtils
import java.util.Optional

class ConflictResolutionStrategyGenerator {

	@Inject VariableGenerator variableGenerator
	@Inject SatisfactionRuleGenerator satisfactionRuleGenerator
	@Inject ResolutionGenerator resolutionGenerator

	def String doGenerate(ConflictResolutionStrategy strategy, QualifiedName packageName, IFileSystemAccess2 fsa) {
		val className = StringUtils.capitalize(strategy.name)
		val fileName = packageName.toString("/") + "/" + className + ".java"
		fsa.generateFile(fileName, '''
			package «packageName»;
			
			public class «className» implements «IConflictResolutionStrategy.name» {
				
				@Override
				public boolean conflictSatisfiesRule(«Conflict.name» conflict) {
				«FOR variable : strategy.variables»
					«variableGenerator.generate(variable)»
				«ENDFOR»
				
					return «satisfactionRuleGenerator.generate(strategy.rule, strategy.resolution)»;
				}

				
				@Override
				public «Optional.name»<String> getResolutionStrategyNameToApply(«Conflict.name» conflict) {
					«resolutionGenerator.generate(strategy.resolution)»
				}
			}
		''')
		
		className
	}
}
