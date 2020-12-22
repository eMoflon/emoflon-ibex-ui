package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.deleteCorrespondences;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.OperationalDeltaCommons;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;
import language.TGGRuleElement;

public class DeleteCorrespondenceOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	public DeleteCorrespondenceOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
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
		if (domainTypes.contains(DomainType.SRC)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(PatternType.TRG, DomainType.SRC);
			}
		}

		if (domainTypes.contains(DomainType.TRG)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += evaluateConsistencyMatches(DomainType.SRC, DomainType.TRG);
			}
		}

		return count;
	}

	private int countElementsToBeCreated(PatternType patternType, DomainType domainType) {

		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(patternType)).collect(Collectors.toSet());
		List<TGGRule> relevantRules = conflict.integrate().getTGG().getRules().stream()
				.filter(rule -> OperationalDeltaCommons.ruleIsInAnyMatch(rule, matches)).collect(Collectors.toList());

		return evaluateRules(relevantRules, domainType);
	}

	private int evaluateConsistencyMatches(DomainType srcDomainType, DomainType trgDomainType) {
		Predicate<ITGGMatch> hasDeletedElementsOnDomain = hasDeletedElementsOnDomain(srcDomainType);
		Set<ITGGMatch> matches = new HashSet<ITGGMatch>();
		matches.addAll(conflict.getConflictMatches());
		matches.addAll(conflict.getScopeMatches());

		Set<ITGGMatch> relevantMatches = matches.stream()//
				.filter(hasDeletedElementsOnDomain).collect(Collectors.toSet());

		EList<TGGRule> rules = conflict.integrate().getTGG().getRules();
		List<TGGRule> relevantRules = relevantMatches.stream()//
				.map(match -> rules.stream()//
						.filter(rule -> rule.getName().equals(match.getRuleName()))//
						.findFirst())//
				.filter(Optional::isPresent)//
				.map(Optional::get).collect(Collectors.toList());

		return evaluateRules(relevantRules, trgDomainType);
	}

	private Predicate<ITGGMatch> hasDeletedElementsOnDomain(DomainType domainType) {
		return match -> {
			EltFilter filter = new EltFilter().deleted().domains(domainType);
			Set<TGGRuleElement> elts = conflict.integrate().getMatchUtil().getAnalysis(match).getElts(filter);
			return !elts.isEmpty();
		};
	}

	private int evaluateRules(List<TGGRule> rules, DomainType domainType) {
		return rules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}
}
