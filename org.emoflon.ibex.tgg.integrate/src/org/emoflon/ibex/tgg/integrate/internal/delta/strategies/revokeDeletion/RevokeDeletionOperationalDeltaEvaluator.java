package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.revokeDeletion;

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
			if (domainTypes.contains(DomainType.SOURCE)) {
				count += countElementsToBeCreated(conflict, PatternType.TARGET, DomainType.SOURCE);
			}
			
			if (domainTypes.contains(DomainType.TARGET)) {
				count += countElementsToBeCreated(conflict, PatternType.SOURCE, DomainType.TARGET);
			}
		}
		
		return count;
	}

	private int countElementsToBeCreated(DeletePreserveConflict conflict, PatternType patternType,
			DomainType domainType) {
		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(patternType)).collect(Collectors.toSet());
		Set<TGGRule> relevantRules = conflict.integrate().getTGG().getRuleSet().getRules().stream()
				.filter(rule -> OperationalDeltaCommons.ruleIsInAnyMatch(rule, matches)).collect(Collectors.toSet());

		return relevantRules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}

}
