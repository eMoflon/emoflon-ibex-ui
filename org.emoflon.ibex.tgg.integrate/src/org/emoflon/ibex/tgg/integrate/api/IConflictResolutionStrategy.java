package org.emoflon.ibex.tgg.integrate.api;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

public interface IConflictResolutionStrategy {

	boolean canSolve(Conflict conflict);

	void solve(Conflict conflict);
}
