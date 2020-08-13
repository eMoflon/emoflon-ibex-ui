package org.emoflon.ibex.tgg.integrate.generator

import java.util.Map
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategy

class ResolutionStrategyGenerator {
	static final Map<String, String> RESOLUTION_STRATEGY_MAPPING = Map.of(
		// "actAndLetRepair", CRS_ActAndLetRepair,
		"mergeAndPreserve",
		"crs_mergeAndPreserve()",
		"preferSource",
		"crs_preferSource()",
		"preferTarget",
		"crs_preferTarget()",
		"revokeAddition",
		"crs_revokeAddition()",
		"revokeDeletion",
		"crs_revokeDeletion()",
		"revokeChanges",
		"crs_revokeChanges()"
	);
	
	def generate(ResolutionStrategy resolutionStrategy) {
		
	}
	
	static class ResolutionStrategyCompiler {
		ResolutionStrategy resolutionStrategy
		String result
		
		new(ResolutionStrategy resolutionStrategy) {
			this.resolutionStrategy = resolutionStrategy
			result = ""
		}
		
		def compile() {
			resolutionStrategy.name
			result
		}
	}
	
}
