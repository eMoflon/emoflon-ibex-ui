package org.emoflon.ibex.tgg.integrate.generator

import javax.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.naming.QualifiedName
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict
import org.apache.commons.lang3.StringUtils
import java.util.Optional
import org.emoflon.ibex.tgg.integrate.api.variable.ConflictPipelineExecuter
import org.emoflon.ibex.tgg.integrate.api.ConflictResolutionSpecification

class ConflictResolutionSpecificationGenerator {

	@Inject VariableGenerator variableGenerator
	@Inject SatisfactionRuleGenerator satisfactionRuleGenerator
	@Inject ResolutionGenerator resolutionGenerator
 
	def String doGenerate(org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionSpecification specification, QualifiedName packageName, IFileSystemAccess2 fsa) {
		val className = StringUtils.capitalize(specification.name)
		val fileName = packageName.toString("/") + "/" + className + ".java"
		fsa.generateFile(fileName, '''
			package «packageName»;
			
			public class «className» implements «ConflictResolutionSpecification.name» {
				
				@Override
				public boolean conflictSatisfiesRule(«Conflict.name» conflict) {
				«FOR variable : specification.variables»
					«variableGenerator.generate(variable, '''new «ConflictPipelineExecuter.name»(conflict)''')»
				«ENDFOR»
				
					return «satisfactionRuleGenerator.generate(specification.rule)»;
				}

				
				@Override
				public «Optional.name»<String> getResolutionStrategyNameToApply(«Conflict.name» conflict) {
					«resolutionGenerator.generate(specification.resolution)»
				}
			}
		''')
		
		className
	}
}
