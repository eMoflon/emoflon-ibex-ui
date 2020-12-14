package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.mergeAndPreserve;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.MatchAnalysis;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.TGGMatchUtil;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;
import language.TGGRuleElement;
import language.TGGRuleNode;

class DeletePreserveMergeAndPreserveOperationalDeltaEvaluator {

	private final DeletePreserveConflict conflict;
	private final Set<DomainType> domainTypes;
	private final Set<BindingType> modifications;
	private final TGGMatchUtil util;
	private final Set<EObject> byUserDeletedElements;

	public DeletePreserveMergeAndPreserveOperationalDeltaEvaluator(DeletePreserveConflict conflict,
			Set<DomainType> domainTypes, Set<BindingType> modifications, TGGMatchUtil util,
			Set<EObject> byUserDeletedElements) {
		this.conflict = conflict;
		this.domainTypes = domainTypes;
		this.modifications = modifications;
		this.util = util;
		this.byUserDeletedElements = removeElementsToBeRevoked(byUserDeletedElements);
	}

	private Set<EObject> removeElementsToBeRevoked(Set<EObject> byUserDeletedElements) {
		Predicate<EObject> isNotInCausingMatch = (element) -> {
			return conflict.getCausingMatches().stream().noneMatch(match -> match.getObjects().contains(element));
		};

		return byUserDeletedElements.stream().filter(isNotInCausingMatch).collect(Collectors.toSet());
	}

	public int evaluate() {
		int count = 0;
		if (domainTypes.contains(DomainType.SRC)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(conflict, PatternType.TRG, DomainType.SRC);
			}

			if (modifications.contains(BindingType.DELETE)) {
				Set<TGGRule> rulesToBeExecuted = getRulesToBeExecuted(conflict, DomainType.TRG);
				count += evaluateRules(rulesToBeExecuted, DomainType.SRC);
			}
		}

		if (domainTypes.contains(DomainType.TRG)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(conflict, PatternType.SRC, DomainType.TRG);
			}

			if (modifications.contains(BindingType.DELETE)) {
				Set<TGGRule> rulesToBeExecuted = getRulesToBeExecuted(conflict, DomainType.SRC);
				count += evaluateRules(rulesToBeExecuted, DomainType.TRG);
			}
		}

		return count;
	}

	private int countElementsToBeCreated(DeletePreserveConflict conflict, PatternType patternType,
			DomainType domainType) {

		Set<ITGGMatch> matches = conflict.getScopeMatches().stream()
				.filter(match -> match.getType().equals(patternType)).collect(Collectors.toSet());
		Set<TGGRule> relevantRules = conflict.integrate().getTGG().getRules().stream()
				.filter(rule -> ruleIsInAnyMatch(rule, matches)).collect(Collectors.toSet());

		return evaluateRules(relevantRules, domainType);
	}

	private Set<TGGRule> getRulesToBeExecuted(DeletePreserveConflict conflict, DomainType domainType) {
		Set<ITGGMatch> matchesWithElementsDeletedByUser = getMatchesWithElementsDeletedByUser(conflict, domainType);
		EList<TGGRule> rules = conflict.integrate().getTGG().getRules();
		Set<TGGRule> relevantRules = rules.stream()
				.filter(rule -> ruleIsInAnyMatch(rule, matchesWithElementsDeletedByUser)).collect(Collectors.toSet());

		return relevantRules;
	}

	private Set<ITGGMatch> getMatchesWithElementsDeletedByUser(DeletePreserveConflict conflict, DomainType domainType) {
		EltFilter filter = new EltFilter().create().deleted().domains(domainType);

		Set<ITGGMatch> matchesWithElementsDeletedByUser = conflict.getScopeMatches().stream().filter(match -> {
			MatchAnalysis analysis = util.getAnalysis(match);
			Set<TGGRuleElement> elts = analysis.getElts(filter);
			return elts.stream().anyMatch(element -> elementWasDeletedByUser(element, analysis));
		}).collect(Collectors.toSet());

		return matchesWithElementsDeletedByUser;
	}

	private boolean elementWasDeletedByUser(TGGRuleElement element, MatchAnalysis analysis) {
		if (element instanceof TGGRuleNode) {
			TGGRuleNode node = (TGGRuleNode) element;
			EObject object = analysis.getObject(node);
			return byUserDeletedElements.contains(object);
		}

		return false;
	}

	private boolean ruleIsInAnyMatch(TGGRule rule, Set<ITGGMatch> matches) {
		return matches.stream().anyMatch(match -> match.getRuleName().equals(rule.getName()));
	}

	private int evaluateRules(Set<TGGRule> rules, DomainType domainType) {
		return rules.stream()
				.mapToInt(
						rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, domainType).size())
				.sum();
	}
}
