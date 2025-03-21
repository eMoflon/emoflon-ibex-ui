package org.emoflon.ibex.tgg.integrate.generator

import com.google.common.collect.ImmutableList
import java.util.List
import org.apache.commons.lang3.StringUtils
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.naming.QualifiedName
import org.emoflon.ibex.tgg.integrate.api.ConflictContainerProcessor
import org.emoflon.ibex.tgg.integrate.api.ConflictResolutionSpecification
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.ConflictContainer
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.resolution.util.ConflictResolver

import static extension org.eclipse.xtext.EcoreUtil2.*

class ConflictResolverGenerator {

	final static String CLASS_POSTFIX = "ConflictResolver"

	def void doGenerate(Resource resource, QualifiedName packageName, IFileSystemAccess2 fsa,
		List<String> crsClassNames) {
		val className = getClassPrefix(resource) + CLASS_POSTFIX
		val filePath = packageName.toString("/") + "/" + className + ".java"

		fsa.generateFile(filePath, '''
			package «packageName»;
			
			public class «className» implements «ConflictResolver.name»{
				
				private final «List.name»<«ConflictResolutionSpecification.name»> conflictResolutionStrategies;
				
				public «className»() {
					this.conflictResolutionStrategies = «ImmutableList.name».of(
						«FOR crsClassName : crsClassNames SEPARATOR ','»
							new «crsClassName»()
						«ENDFOR»
					);
				}
					
				@Override
				public void resolveConflict(«ConflictContainer.name» conflictContainer) {
					«ConflictContainerProcessor.name».process(conflictContainer, conflictResolutionStrategies);
				}
			}
		''')
	}

	def String getClassPrefix(Resource resource) {
		val prefix = resource.normalizedURI.lastSegment.replace(".integ", "")
		StringUtils.capitalize(prefix)
	}

}
