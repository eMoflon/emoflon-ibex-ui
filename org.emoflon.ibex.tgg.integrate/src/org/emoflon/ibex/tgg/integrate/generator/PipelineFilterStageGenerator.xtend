package org.emoflon.ibex.tgg.integrate.generator

import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.emoflon.ibex.tgg.integrate.integrate.PipelineFilterStage
import org.emoflon.ibex.tgg.integrate.integrate.PipelineTypeFilterStage

class PipelineFilterStageGenerator {
	
	def doGenerate(PipelineFilterStage stage, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if(stage instanceof PipelineTypeFilterStage) {
			
		}
	}
	

	private def compile(PipelineTypeFilterStage stage) {
		stage.type.instanceClassName
	}
}