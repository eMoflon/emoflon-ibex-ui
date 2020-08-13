package org.emoflon.ibex.tgg.integrate.api.resolution;

import org.emoflon.ibex.tgg.integrate.internal.ConflictResolutionStrategyRegistry;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

public class ResolutionStrategyApplicationChecker {

	public static boolean canBeApplied(String resolutionStrategyName, Conflict conflict) {
		Class<?> crsInterface = ConflictResolutionStrategyRegistry.getCRSInterface(resolutionStrategyName);
		return conflict.getAllImplementedCRSInterfaces().stream()
				.anyMatch(implementedCrsInterface -> implementedCrsInterface.equals(crsInterface));
	}
}
