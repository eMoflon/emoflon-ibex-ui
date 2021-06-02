package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.preferSource;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.OperationalDeltaCommons;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.classification.ClassifiedMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.classification.DeletionType;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;

public class PreferSourceOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	public PreferSourceOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
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
		if (domainTypes.contains(DomainType.TRG)) {
			if (modifications.contains(BindingType.CREATE)) {
				count += countElementsToBeCreated(conflict);
			}

			if (modifications.contains(BindingType.DELETE)) {
				count += countElementsToBeDeleted(conflict);
			}
		}

		return count;
	}

	private int countElementsToBeCreated(DeletePreserveConflict conflict) {
		return conflict.getScopeMatches().stream().filter(match -> OperationalDeltaCommons.isOfType(match, PatternType.SRC))
				.mapToInt(match -> countGreenElementsForCorrespondingRule(match)).sum();
	}

	private int countElementsToBeDeleted(DeletePreserveConflict conflict) {
		Set<ITGGMatch> matches = new HashSet<ITGGMatch>();
		matches.add(conflict.getMatch());
		matches.addAll(conflict.getScopeMatches());
		return matches.stream() //
				.filter(match -> OperationalDeltaCommons.isOfType(match, PatternType.CONSISTENCY)) //
				// TODO: INTEGRATE: matchClassifier().get() may not return most recent classification. Investigate?
				.filter(consistencyMatch -> staysBrokenAfterConflictResolution(conflict.integrate().matchClassifier().get(consistencyMatch))) //
				.mapToInt(match -> countGreenElementsForCorrespondingRule(match)).sum();
	}

	private int countGreenElementsForCorrespondingRule(ITGGMatch match) {
		EList<TGGRule> rules = conflict.integrate().getTGG().getRules();
		return rules.stream().filter(rule -> rule.getName().equals(match.getRuleName())).findFirst()
				.map(rule -> TGGModelUtils.getNodesByOperatorAndDomain(rule, BindingType.CREATE, DomainType.TRG).size())
				.orElse(0);
	}

	private boolean staysBrokenAfterConflictResolution(ClassifiedMatch brokenMatch) {
		if (brokenMatch == null) {
			return false;
		}

		// TODO: INTEGRATE: Coordinate with CR
		DeletionType deletionType = brokenMatch.getDeletionType();
		return deletionType.equals(DeletionType.SRC_FULL_TRG_NOT)
				|| deletionType.equals(DeletionType.SRC_FULL_TRG_PARTLY)
				|| deletionType.equals(DeletionType.SRC_PARTLY_TRG_FULL)
				|| deletionType.equals(DeletionType.SRC_PARTLY_TRG_NOT)
				|| deletionType.equals(DeletionType.SRC_PARTLY_TRG_PARTLY)
				|| deletionType.equals(DeletionType.COMPLETELY);
	}
}
