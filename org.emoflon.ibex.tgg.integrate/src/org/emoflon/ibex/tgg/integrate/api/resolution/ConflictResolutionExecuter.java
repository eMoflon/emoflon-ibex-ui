package org.emoflon.ibex.tgg.integrate.api.resolution;

import org.emoflon.ibex.tgg.integrate.internal.ConflictResolutionStrategyRegistry;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

public class ConflictResolutionExecuter {

	public void execute(String conflictResolutionStrategyName, Conflict conflict) {
		ConflictResolutionStrategyRegistry.getConflictResolver(conflictResolutionStrategyName).accept(conflict);
	}
}
