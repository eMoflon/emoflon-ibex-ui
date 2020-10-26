package org.emoflon.ibex.tgg.integrate.internal.delta;

import java.util.Set;

import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.MergeAndPreserveOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.PreferSourceOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.PreferTargetOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.RevokeAdditionOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.RevokeDeletionOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

import language.BindingType;
import language.DomainType;

public class OperationalDeltaEvaluator {

	public static int evaluate(Conflict conflict, Set<DomainType> domainTypes, Set<BindingType> modifications, String resolutionStrategy) {
		switch (resolutionStrategy) {
		case "preferSource":
			return new PreferSourceOperationalDeltaEvaluator(conflict, domainTypes, modifications).evaluate();
		case "preferTarget":
			return new PreferTargetOperationalDeltaEvaluator(conflict, domainTypes, modifications).evaluate();
		case "revokeAddition":
			return new RevokeAdditionOperationalDeltaEvaluator(conflict, domainTypes, modifications).evaluate();
		case "revokeDeletion":
			return new RevokeDeletionOperationalDeltaEvaluator(conflict, domainTypes, modifications).evaluate();
		case "mergeAndPreserve":
			return new MergeAndPreserveOperationalDeltaEvaluator(conflict, domainTypes, modifications).evaluate();
		default:
			return 0;
		}
	}

}
