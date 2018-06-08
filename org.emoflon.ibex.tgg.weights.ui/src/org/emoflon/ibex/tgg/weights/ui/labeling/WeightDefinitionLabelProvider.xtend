/*
 * generated by Xtext 2.14.0
 */
package org.emoflon.ibex.tgg.weights.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionFile
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider
import org.emoflon.ibex.tgg.weights.weightDefinition.RuleWeightDefinition
import org.emoflon.ibex.tgg.weights.weightDefinition.DefaultCalculation
import org.emoflon.ibex.tgg.weights.weightDefinition.HelperFunction
import org.emoflon.ibex.tgg.weights.weightDefinition.HelperFuncParameter

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class WeightDefinitionLabelProvider extends XbaseLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
	def text(WeightDefinitionFile file) {
		val fileName = file.eResource.URI.lastSegment
		fileName.substring(0, fileName.length - 5)
	}
	
	def text(RuleWeightDefinition ruleElement) {
		ruleElement.rule.name
	}
	
	def text(DefaultCalculation defaultCalc) {
		"Default weight"
	}
	
	def text(HelperFunction helperFunc) {
		var text = '''«helperFunc.name»('''
		var first = true
		for(param : helperFunc.params) {
			if(!first)
				text += ", "
			first = false
			text += param.parameterType.type.simpleName
		}
		text += ''') : «helperFunc.returnType.type.simpleName»'''
	}
}
