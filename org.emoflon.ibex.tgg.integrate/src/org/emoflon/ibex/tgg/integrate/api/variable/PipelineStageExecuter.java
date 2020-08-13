package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictElements;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictEltFilter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.EltFilter;
import org.emoflon.ibex.tgg.operational.strategies.integrate.util.TGGMatchUtil;

import language.TGGRuleElement;
import language.TGGRuleNode;

public class PipelineStageExecuter {

	public static ConflictEltFilter executeSrc() {
		return new ConflictEltFilter().src();
	}

	public static ConflictEltFilter executeTrg() {
		return new ConflictEltFilter().trg();
	}

	public static ConflictEltFilter executeCreatedFilter(ConflictEltFilter filter) {
		return filter.created();
	}

	public static ConflictEltFilter executeDeletedFilter(ConflictEltFilter filter) {
		return filter.deleted();
	}

	public static Set<EObject> executeElementFilter(ConflictEltFilter filter, Conflict c) {
		ConflictElements filteredElements = new ConflictElements(c, filter, true);
		return filteredElements.getObjects();
	}

	public static Set<EObject> executeTypeFilter(Set<EObject> elements,
			Collection<String> filterClassNames) {

		Predicate<TGGRuleNode> hasType = e -> {
			String name = e.getType().getName();
			return filterClassNames.contains(name);
		};

		return elements.stream().filter(e -> e instanceof TGGRuleNode).map(e -> (TGGRuleNode) e).filter(hasType)
				.collect(Collectors.toSet());
	}

	public static int executeCount(Collection<?> elements) {
		return elements.size();
	}
}
