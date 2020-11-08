package org.emoflon.ibex.tgg.integrate.internal.delta.strategies;

import java.util.Set;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;

public class RevokeAdditionOperationalDeltaEvaluator extends RevokeStrategyOperationalDeltaEvaluator {

	public RevokeAdditionOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		super(conflict, domainTypes, modifications);
	}

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
		if (domainTypes.contains(DomainType.SRC) && conflict.getDomainToBePreserved().equals(DomainType.SRC)) {
			count += countElementsToBeDeleted(conflict, DomainType.SRC);
		}

		if (domainTypes.contains(DomainType.TRG) && conflict.getDomainToBePreserved().equals(DomainType.TRG)) {
			count += countElementsToBeDeleted(conflict, DomainType.TRG);
		}

		return count;
	}

	private int countElementsToBeDeleted(DeletePreserveConflict conflict, DomainType domainType) {
		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(PatternType.CONSISTENCY)).collect(Collectors.toSet());

		matches.add(conflict.getMatch());

		Set<TGGRule> relevantRules = conflict.integrate().getTGG().getRules().stream()
				.filter(rule -> ruleIsInAnyMatch(rule, matches)).collect(Collectors.toSet());

		return relevantRules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}

	private boolean ruleIsInAnyMatch(TGGRule rule, Set<ITGGMatch> matches) {
		return matches.stream().anyMatch(match -> match.getRuleName().equals(rule.getName()));
	}
}
