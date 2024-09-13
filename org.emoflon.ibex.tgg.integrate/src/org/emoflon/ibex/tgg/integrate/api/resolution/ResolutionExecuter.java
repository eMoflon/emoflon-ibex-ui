package org.emoflon.ibex.tgg.integrate.api.resolution;

import org.emoflon.ibex.tgg.integrate.internal.ConflictResolutionStrategyRegistry;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;

public class ResolutionExecuter {

	public static void execute(String resolutionStrategyName, Conflict conflict) {
		ConflictResolutionStrategyRegistry
			.getConflictResolver(resolutionStrategyName)
			.accept(conflict);
	}
	
}
