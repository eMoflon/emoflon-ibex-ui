package org.emoflon.ibex.tgg.integrate.internal.delta.strategies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;

public class PreferSourceOperationalDeltaEvaluator {

	private final Conflict conflict;
	private final Set<DomainType> domainTypes;
	private final Set<BindingType> modifications;

	public PreferSourceOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		super();
		this.conflict = conflict;
		this.domainTypes = domainTypes;
		this.modifications = modifications;
	}

	public int evaluate() {
		if (conflict instanceof DeletePreserveConflict) {
			return evaluate((DeletePreserveConflict) conflict);
		}

		return 0;
	}

	private int evaluate(DeletePreserveConflict conflict) {
		if (!domainTypes.contains(DomainType.TRG)) {
			// PreferSource will only affect changes in target domain
			return 0;
		}

		switch (conflict.getDomainToBePreserved()) {
		case SRC:
			return countElementsToBeCreated(conflict);
		case TRG:
			return countElementsToBeDeleted(conflict);
		default:
			return 0;
		}
	}

	private int countElementsToBeCreated(DeletePreserveConflict conflict) {
		if (!modifications.contains(BindingType.CREATE)) {
			return 0;
		}

		return conflict.getScopeMatches().stream().filter(match -> !isOfType(match, PatternType.SRC))
				.mapToInt(match -> countGreenElementsForCorrespondingRule(match)).sum();
	}

	private int countElementsToBeDeleted(DeletePreserveConflict conflict) {
		if (!modifications.contains(BindingType.DELETE)) {
			return 0;
		}

		Set<ITGGMatch> matches = new HashSet<ITGGMatch>();
		matches.add(conflict.getMatch());
		matches.addAll(conflict.getScopeMatches());

		return matches.stream().filter(match -> isOfType(match, PatternType.CONSISTENCY))
				.mapToInt(match -> countGreenElementsForCorrespondingRule(match)).sum();
	}

	private int countGreenElementsForCorrespondingRule(ITGGMatch match) {
		EList<TGGRule> rules = conflict.integrate().getTGG().getRules();
		return rules.stream().filter(rule -> rule.getName().equals(match.getRuleName())).findFirst()
				.map(rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, DomainType.TRG).size())
				.orElse(0);
	}

	private boolean isOfType(ITGGMatch match, PatternType... types) {
		return Arrays.stream(types).anyMatch(type -> match.getType().equals(type));
	}

}
