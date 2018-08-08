package org.emoflon.ibex.tgg.weights.workflowhelper

import java.util.List
import language.LanguagePackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.xtext.generator.XtextGeneratorResourceSetInitializer

class MyResourceSetInitializer extends XtextGeneratorResourceSetInitializer {
	override initialize(ResourceSet resourceSet, List<String> referencedResources) {
		resourceSet.packageRegistry.put("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore",
			EcorePackage.eINSTANCE)
		resourceSet.packageRegistry.put("http://www.eclipse.org/emf/2002/Ecore", EcorePackage.eINSTANCE)
		resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore",
			LanguagePackage.eINSTANCE)
		super.initialize(resourceSet, referencedResources)
	}
}
