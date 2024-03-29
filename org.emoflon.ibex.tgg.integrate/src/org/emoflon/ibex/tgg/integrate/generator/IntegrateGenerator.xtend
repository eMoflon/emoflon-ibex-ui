/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.generator

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.emoflon.ibex.tgg.integrate.integrate.Integrate

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class IntegrateGenerator extends AbstractGenerator {

	@Inject ConflictResolutionSpecificationGenerator conflictResolutionSpecificationGenerator;
	@Inject ConflictResolverGenerator conflictResolutionStrategyContainerGenerator;
	@Inject extension IQualifiedNameProvider

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val integrate = resource.contents.get(0) as Integrate

		val packageName = generatePackageName(integrate, resource)
		val crsClassNames = integrate.conflictResolutionSpecifications.map [ crs |
			conflictResolutionSpecificationGenerator.doGenerate(crs, packageName, fsa)
		]

		conflictResolutionStrategyContainerGenerator.doGenerate(resource, packageName, fsa, crsClassNames)
	}

	def QualifiedName generatePackageName(Integrate integrate, Resource resource) {
		val normalizedURI = resource.normalizedURI
		val projectName = normalizedURI.segment(1)
		val specPackageName = normalizedURI.lastSegment.replace(".integ", "")
		
		if (integrate.package !== null) {
			return integrate.package.fullyQualifiedName.append(specPackageName)
		}
		 
		val qn = QualifiedName.create(projectName, "integrate", specPackageName)
		return qn
	}
}
