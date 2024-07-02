package org.emoflon.ibex.tgg.integrate.api;

import java.util.Optional;

import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;

public interface ConflictResolutionSpecification {

	boolean conflictSatisfiesRule(Conflict conflict);
	
	Optional<String> getResolutionStrategyNameToApply(Conflict conflict);

}
