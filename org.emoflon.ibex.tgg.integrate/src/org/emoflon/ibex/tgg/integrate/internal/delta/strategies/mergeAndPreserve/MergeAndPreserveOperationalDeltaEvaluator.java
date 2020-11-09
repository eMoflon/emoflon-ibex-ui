package org.emoflon.ibex.tgg.integrate.internal.delta.strategies.mergeAndPreserve;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.integrate.internal.delta.strategies.ResolutionStrategyOperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.DeletePreserveConflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.modelchange.ModelChanges;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.MatchAnalysis;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.TGGMatchUtil;
import org.emoflon.ibex.tgg.util.TGGModelUtils;

import language.BindingType;
import language.DomainType;
import language.TGGRule;
import language.TGGRuleElement;
import language.TGGRuleNode;

public class MergeAndPreserveOperationalDeltaEvaluator extends ResolutionStrategyOperationalDeltaEvaluator {

	private final TGGMatchUtil util;
	private final Set<EObject> byUserDeletedElements;

	public MergeAndPreserveOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		super(conflict, domainTypes, modifications);
		this.util = new TGGMatchUtil(conflict.integrate());
		this.byUserDeletedElements = collectAllByUserDeletedElements();
	}

	private Set<EObject> collectAllByUserDeletedElements() {
		ModelChanges userModelChanges = conflict.integrate().getUserModelChanges();

		Set<EObject> deletedElements = new HashSet<EObject>();
		userModelChanges.getDeletedElements().forEach(element -> {
			deletedElements.addAll(getChildren(element));
			deletedElements.add(element);
		});

		return deletedElements;
	}

	private Set<EObject> getChildren(EObject element) {
		Set<EObject> children = new HashSet<EObject>();
		element.eContents().forEach(child -> {
			children.addAll(getChildren(child));
			children.add(child);
		});

		return children;
	}

	@Override
	public int evaluate() {
		if (conflict instanceof DeletePreserveConflict) {
			return new DeletePreserveMergeAndPreserveOperationalDeltaEvaluator((DeletePreserveConflict) conflict,
					domainTypes, modifications, util, byUserDeletedElements).evaluate();
		}

		return 0;
	}

}
