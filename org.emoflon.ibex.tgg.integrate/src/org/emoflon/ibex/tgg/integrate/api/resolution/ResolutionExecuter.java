package org.emoflon.ibex.tgg.integrate.api.resolution;

import org.emoflon.ibex.tgg.integrate.internal.ConflictResolutionStrategyRegistry;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

public class ResolutionExecuter {

	public static void execute(String resolutionStrategyName, Conflict conflict) {
		executeResolutionStrategy(resolutionStrategyName, conflict);
	}
	
	public static void execute(String resolutionStrategyName, String fallBackResolutionStrategyName,
			Conflict conflict) {

		if (!executeResolutionStrategy(resolutionStrategyName, conflict)) {
			executeFallbackStrategy(fallBackResolutionStrategyName, conflict);
		}
	}

	private static boolean executeResolutionStrategy(String strategyName, Conflict conflict) {
		boolean implementsNecessaryInterface = ResolutionChecker.implementsNecessaryInterface(conflict, strategyName);
		if (implementsNecessaryInterface) {
			ConflictResolutionStrategyRegistry.getConflictResolver(strategyName).accept(conflict);
			return true;
		}

		return false;
	}

	private static void executeFallbackStrategy(String fallBackResolutionStrategyName, Conflict conflict) {
		ConflictResolutionStrategyRegistry.getConflictResolver(fallBackResolutionStrategyName).accept(conflict);
	}

}
