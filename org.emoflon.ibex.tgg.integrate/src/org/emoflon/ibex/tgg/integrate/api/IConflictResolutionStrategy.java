package org.emoflon.ibex.tgg.integrate.api;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.ConflictContainer;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.MatchAnalysis;

public interface IConflictResolutionStrategy {

	boolean canSolve(Conflict conflict, MatchAnalysis matchAnalysis);

	void solve(Conflict conflict, MatchAnalysis matchAnalysis);
}
