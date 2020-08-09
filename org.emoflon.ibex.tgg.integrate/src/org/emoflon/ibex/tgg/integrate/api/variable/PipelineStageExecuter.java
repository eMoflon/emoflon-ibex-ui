package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.TGGMatchUtil;

import language.TGGRuleElement;
import language.TGGRuleNode;

public class PipelineStageExecuter {

	public static EltFilter executeSrc() {
		return new EltFilter().src();
	}

	public static EltFilter executeTrg() {
		return new EltFilter().trg();
	}

	public static EltFilter executeCreatedFilter(EltFilter filter) {
		return filter;
	}

	public static EltFilter executeDeletedFilter(EltFilter filter) {
		return filter.delete().deleted();
	}

	public static Set<TGGRuleElement> executeElementFilter(EltFilter filter, Conflict c) {
		TGGMatchUtil util = new TGGMatchUtil(c.integrate());
		return util.getElts(c.getBrokenMatch().getMatch(), filter);
	}

	public static Set<TGGRuleElement> executeTypeFilter(Set<TGGRuleElement> elements,
			Collection<EClassifier> typeClassifiers) {

		Set<?> clazzes = typeClassifiers.stream().map(tc -> tc.getInstanceClass()).collect(Collectors.toSet());
		Predicate<TGGRuleNode> hasType = e -> {
			Class<?> clazz = e.getType().getInstanceClass();
			return clazzes.contains(clazz);
		};

		return elements.stream().filter(e -> e instanceof TGGRuleNode).map(e -> (TGGRuleNode) e).filter(hasType)
				.collect(Collectors.toSet());
	}

	public static int executeCount(Collection<?> elements) {
		return elements.size();
	}
}
