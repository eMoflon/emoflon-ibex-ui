package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.mergeAndPreserve;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.OperationalDeltaCommons;
import org.emoflon.ibex.tgg.patterns.PatternType;
import org.emoflon.ibex.tgg.runtime.matches.ITGGMatch;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.BindingType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.DomainType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGRule;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGRuleElement;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

class DeletePreserveMergeAndPreserveOperationalDeltaEvaluator {

	private final DeletePreserveConflict conflict;
	private final Set<DomainType> domainTypes;
	private final Set<BindingType> modifications;

	public DeletePreserveMergeAndPreserveOperationalDeltaEvaluator(DeletePreserveConflict conflict,
			Set<DomainType> domainTypes, Set<BindingType> modifications) {
		this.conflict = conflict;
		this.domainTypes = domainTypes;
		this.modifications = modifications;
	}

	public int evaluate() {
		int count = 0;
		if (domainTypes.contains(DomainType.SOURCE)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(PatternType.TARGET, DomainType.SOURCE);
			}

			if (modifications.contains(BindingType.DELETE)) {
				List<TGGRule> rulesToBeExecuted = getRelevantRules(DomainType.TARGET);
				count += evaluateRules(rulesToBeExecuted, DomainType.SOURCE);
			}
		}

		if (domainTypes.contains(DomainType.TARGET)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(PatternType.SOURCE, DomainType.TARGET);
			}

			if (modifications.contains(BindingType.DELETE)) {
				List<TGGRule> rulesToBeExecuted = getRelevantRules(DomainType.SOURCE);
				count += evaluateRules(rulesToBeExecuted, DomainType.TARGET);
			}
		}

		return count;
	}

	private int countElementsToBeCreated(PatternType patternType, DomainType domainType) {

		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(patternType)).collect(Collectors.toSet());
		List<TGGRule> relevantRules = conflict.integrate().getTGG().getRuleSet().getRules().stream()
				.filter(rule -> OperationalDeltaCommons.ruleIsInAnyMatch(rule, matches)).collect(Collectors.toList());

		return evaluateRules(relevantRules, domainType);
	}

	private List<TGGRule> getRelevantRules(DomainType domainType) {
		Predicate<ITGGMatch> hasDeletedElementsOnDomain = hasDeletedElementsOnDomain(domainType);
		
		EList<TGGRule> rules = conflict.integrate().getTGG().getRuleSet().getRules();
		List<ITGGMatch> matchesToBeResolved = conflict.getScopeMatches().stream()//
				.filter(match -> match.getType().equals(PatternType.CONSISTENCY))
				.filter(brokenMatch -> !conflict.getCausingMatches().contains(brokenMatch))//
				.filter(hasDeletedElementsOnDomain).collect(Collectors.toList());

		List<TGGRule> relevantRules = matchesToBeResolved.stream()//
				.map(match -> rules.stream().filter(rule -> rule.getName().equals(match.getRuleName())).findFirst())//
				.filter(Optional::isPresent)//
				.map(Optional::get).collect(Collectors.toList());

		return relevantRules;
	}

	private Predicate<ITGGMatch> hasDeletedElementsOnDomain(DomainType domainType) {
		return match -> {
			EltFilter filter = new EltFilter().deleted().domains(domainType);
			Set<TGGRuleElement> elts = conflict.integrate().matchUtils().get(match).getElts(filter);
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
