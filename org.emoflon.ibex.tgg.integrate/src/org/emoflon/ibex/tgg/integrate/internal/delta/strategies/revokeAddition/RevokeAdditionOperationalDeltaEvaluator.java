package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.revokeAddition;

import java.util.Set;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.OperationalDeltaCommons;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.patterns.PatternType;
import org.emoflon.ibex.tgg.runtime.matches.ITGGMatch;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.BindingType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.DomainType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGRule;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

public class RevokeAdditionOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	public RevokeAdditionOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		super(conflict, domainTypes, modifications);
	}

	@Override
	public int evaluate() {
		if (conflict instanceof DeletePreserveConflict) {
			return evaluate((DeletePreserveConflict) conflict);
		}

		return 0;
	}

	private int evaluate(DeletePreserveConflict conflict) {
		if (!modifications.contains(BindingType.DELETE)) {
			return 0;
		}

		int count = 0;
		if (domainTypes.contains(DomainType.SOURCE) && conflict.getDomainToBePreserved().equals(DomainType.SOURCE)) {
			count += countElementsToBeDeleted(conflict, DomainType.SOURCE);
		}

		if (domainTypes.contains(DomainType.TARGET) && conflict.getDomainToBePreserved().equals(DomainType.TARGET)) {
			count += countElementsToBeDeleted(conflict, DomainType.TARGET);
		}

		return count;
	}

	private int countElementsToBeDeleted(DeletePreserveConflict conflict, DomainType domainType) {
		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(PatternType.CONSISTENCY)).collect(Collectors.toSet());

		matches.add(conflict.getMatch());

		Set<TGGRule> relevantRules = conflict.integrate().getTGG().getRuleSet().getRules().stream()
				.filter(rule -> OperationalDeltaCommons.ruleIsInAnyMatch(rule, matches)).collect(Collectors.toSet());

		return relevantRules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}

}
