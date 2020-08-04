package org.emoflon.ibex.tgg.integrate.api;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.ConflictContainer;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.MatchAnalysis;

public interface IConflictResolutionStrategy {

	boolean canSolve(ConflictContainer container, MatchAnalysis matchAnalysis);

	void solve(ConflictContainer container, MatchAnalysis matchAnalysis);
}
