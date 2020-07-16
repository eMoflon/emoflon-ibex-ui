package org.emoflon.ibex.tgg.integrate.generator.pipeline

import org.emoflon.ibex.tgg.integrate.integrate.Pipeline
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc

class PipelineGenerator {
	
	def compile(Pipeline pipeline) {
		if (pipeline.first instanceof PipelineStageSrc) {
			compile(pipeline.first as PipelineStageSrc)
		}
	}
	
	def compile(PipelineStageSrc p) {
		'''
		private
		'''
	}
	
}