package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.revokeDeletion;

import java.util.Set;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.OperationalDeltaCommons;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;

public class RevokeDeletionOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	public RevokeDeletionOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
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
		int count = 0;
		if (modifications.contains(BindingType.CREATE)) {
			if (domainTypes.contains(DomainType.SRC)) {
				count += countElementsToBeCreated(conflict, PatternType.TRG, DomainType.SRC);
			}
			
			if (domainTypes.contains(DomainType.TRG)) {
				count += countElementsToBeCreated(conflict, PatternType.SRC, DomainType.TRG);
			}
		}
		
		return count;
	}

	private int countElementsToBeCreated(DeletePreserveConflict conflict, PatternType patternType,
			DomainType domainType) {
		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(patternType)).collect(Collectors.toSet());
		Set<TGGRule> relevantRules = conflict.integrate().getTGG().getRules().stream()
				.filter(rule -> OperationalDeltaCommons.ruleIsInAnyMatch(rule, matches)).collect(Collectors.toSet());

		return relevantRules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}

}
