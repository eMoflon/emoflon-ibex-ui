package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.mergeAndPreserve;

import java.util.Set;

import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;

import language.BindingType;
import language.DomainType;

public class MergeAndPreserveOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	public MergeAndPreserveOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		super(conflict, domainTypes, modifications);
	}

	@Override
	public int evaluate() {
		if (conflict instanceof DeletePreserveConflict) {
			return new DeletePreserveMergeAndPreserveOperationalDeltaEvaluator((DeletePreserveConflict) conflict,
					domainTypes, modifications).evaluate();
		}

		return 0;
	}

}
