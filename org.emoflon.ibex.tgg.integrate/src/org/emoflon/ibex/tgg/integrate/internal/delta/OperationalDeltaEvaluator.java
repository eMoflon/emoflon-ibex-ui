package org.emoflon.ibex.tgg.integrate.internal.delta;

import java.util.Set;

import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.mergeAndPreserve.MergeAndPreserveOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.preferSource.PreferSourceOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.preferTarget.PreferTargetOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.revokeAddition.RevokeAdditionOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.revokeDeletion.RevokeDeletionOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.BindingType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.DomainType;

public class OperationalDeltaEvaluator {

	// TODO: INTEGRATE: Do not use BindingType for storing information about possible modifications due to operational delta. Use own type.
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
