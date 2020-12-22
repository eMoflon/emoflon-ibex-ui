package org.emoflon.ibex.tgg.integrate.api;

import java.util.List;
import java.util.Optional;

import org.emoflon.ibex.tgg.integrate.api.resolution.ResolutionExecuter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.ConflictContainer;

public class ConflictContainerProcessor {

	public static void process(ConflictContainer conflictContainer, List<ConflictResolutionSpecification> conflictResolutionStrategies) {
		conflictContainer.getConflicts().forEach(conflict -> processConflict(conflict, conflictResolutionStrategies));
		conflictContainer.getSubContainers().forEach(subContainer -> process(subContainer, conflictResolutionStrategies));
	}
	
	private static void processConflict(Conflict conflict, List<ConflictResolutionSpecification> conflictResolutionStrategies) {
		for (ConflictResolutionSpecification conflictResolutionStrategy : conflictResolutionStrategies) {
			if (conflictResolutionStrategy.conflictSatisfiesRule(conflict)) {
				Optional<String> resolutionStrategyNameToApply = conflictResolutionStrategy.getResolutionStrategyNameToApply(conflict);
				if (resolutionStrategyNameToApply.isPresent()) {
					ResolutionExecuter.execute(resolutionStrategyNameToApply.get(), conflict);
					return;
				}
			}
		}
	}
	
}
