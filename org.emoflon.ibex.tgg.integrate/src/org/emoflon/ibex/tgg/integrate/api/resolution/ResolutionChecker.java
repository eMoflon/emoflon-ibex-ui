package org.emoflon.ibex.tgg.integrate.api.resolution;

import org.emoflon.ibex.tgg.integrate.internal.ConflictResolutionStrategyRegistry;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;

public class ResolutionChecker {

	public static boolean resolutionWillBeExecuted(String strategyName, Conflict conflict) {
		return !strategyName.equals(ConflictResolutionStrategyRegistry.CONTINUE_NAME)
				&& implementsNecessaryInterface(conflict, strategyName);
	}

	public static boolean anyResolutionWillBeExecuted(String strategyName, String fallbackName, Conflict conflict) {
		return resolutionWillBeExecuted(strategyName, conflict) || resolutionWillBeExecuted(fallbackName, conflict);
	}

	static boolean implementsNecessaryInterface(Conflict conflict, String strategyName) {
		Class<?> necessaryCRSInterface = ConflictResolutionStrategyRegistry.getCRSInterface(strategyName);
		return conflict.getAllImplementedCRSInterfaces().stream()
				.anyMatch(implementedCRSInterface -> implementedCRSInterface.equals(necessaryCRSInterface));
	}

}
