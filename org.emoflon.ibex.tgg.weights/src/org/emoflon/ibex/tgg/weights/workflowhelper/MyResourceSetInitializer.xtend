package org.emoflon.ibex.tgg.weights.workflowhelper

import org.eclipse.xtext.xtext.generator.XtextGeneratorResourceSetInitializer
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.List
import language.LanguagePackage
import language.csp.CspFactory
import language.csp.definition.DefinitionFactory
import language.basic.BasicFactory
import language.basic.expressions.ExpressionsFactory
import language.inplaceAttributes.InplaceAttributesFactory
import org.eclipse.emf.ecore.EcorePackage

class MyResourceSetInitializer extends XtextGeneratorResourceSetInitializer {
	override initialize(ResourceSet resourceSet, List<String> referencedResources) {
		resourceSet.packageRegistry.put("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore",
			EcorePackage.eINSTANCE)
		resourceSet.packageRegistry.put("http://www.eclipse.org/emf/2002/Ecore", EcorePackage.eINSTANCE)
		resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore",
			LanguagePackage.eINSTANCE)
		resourceSet.packageRegistry.put(
			"platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#//inplaceAttributes",
			InplaceAttributesFactory.eINSTANCE)
		resourceSet.packageRegistry.put(
			"platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#//csp", CspFactory.eINSTANCE)
		resourceSet.packageRegistry.put(
			"platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#//csp/definition",
			DefinitionFactory.eINSTANCE)
		resourceSet.packageRegistry.put(
			"platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#//basic", BasicFactory.eINSTANCE)
		resourceSet.packageRegistry.put(
			"platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#//basic/expressions",
			ExpressionsFactory.eINSTANCE)
		super.initialize(resourceSet, referencedResources)
	}
}
