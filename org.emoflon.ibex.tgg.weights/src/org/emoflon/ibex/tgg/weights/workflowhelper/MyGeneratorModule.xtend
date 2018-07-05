package org.emoflon.ibex.tgg.weights.workflowhelper

import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule
import org.eclipse.xtext.xtext.generator.XtextGeneratorResourceSetInitializer

class MyGeneratorModule extends DefaultGeneratorModule {
	def Class<? extends XtextGeneratorResourceSetInitializer> bindXtextGeneratorResourceSetInitializer() {
		MyResourceSetInitializer
	}
}
