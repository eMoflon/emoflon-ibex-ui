package org.emoflon.ibex.tgg.integrate.api;

import java.util.List;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.ConflictContainer;

public class ConflictContainerProcessor {

	public static void process(ConflictContainer conflictContainer, List<IConflictResolutionStrategy> conflictResolutionStrategies) {
		conflictContainer.getConflicts().forEach(conflict -> processConflict(conflict, conflictResolutionStrategies));
		conflictContainer.getSubContainers().forEach(subContainer -> process(subContainer, conflictResolutionStrategies));
	}
	
	private static void processConflict(Conflict conflict, List<IConflictResolutionStrategy> conflictResolutionStrategies) {
		for (IConflictResolutionStrategy conflictResolutionStrategy : conflictResolutionStrategies) {
			if (conflictResolutionStrategy.canSolve(conflict)) {
				conflictResolutionStrategy.solve(conflict);
				break;
			}
		}
	}
	
}
