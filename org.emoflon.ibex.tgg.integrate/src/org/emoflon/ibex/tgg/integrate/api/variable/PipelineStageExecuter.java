package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictElements;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictEltFilter;

public class PipelineStageExecuter {

	private final Conflict conflict;
	private ConflictEltFilter filter;
	private Set<TypeFilterData> typeFilterData;

	public PipelineStageExecuter(Conflict conflict) {
		this.filter = new ConflictEltFilter();
		this.conflict = conflict;
		this.typeFilterData = new HashSet<TypeFilterData>();
	}

	public PipelineStageExecuter src() {
		this.filter = filter.src();
		return this;
	}

	public PipelineStageExecuter trg() {
		this.filter = filter.trg();
		return this;
	}

	public PipelineStageExecuter created() {
		this.filter = filter.created();
		return this;
	}

	public PipelineStageExecuter deleted() {
		this.filter = filter.deleted();
		return this;
	}

	public PipelineStageExecuter types(Set<TypeFilterData> data) {
		this.typeFilterData.addAll(data);
		return this;
	}

	public int count() {
		Set<EObject> elements = executeFilter();
		return elements.size();
	}

	public boolean exists() {
		Set<EObject> elements = executeFilter();
		return !elements.isEmpty();
	}

	private Set<EObject> executeFilter() {
		ConflictElements filteredElements = new ConflictElements(conflict, filter, true);
		Set<EObject> elements = filteredElements.getObjects();
		return executeTypeFilter(elements);
	}

	private Set<EObject> executeTypeFilter(Set<EObject> elements) {
		if (typeFilterData.isEmpty()) {
			return elements;
		}

		return elements.stream().filter(e -> checkIfAnyTypeMatches(e)).collect(Collectors.toSet());
	}

	private boolean checkIfAnyTypeMatches(EObject element) {
		EClass eClass = element.eClass();
		return typeFilterData.stream()
			.anyMatch(data -> eClassMatchesTypeFilterData(eClass, data));
	}
	
	private boolean eClassMatchesTypeFilterData(EClass eClass, TypeFilterData data) {
		String name = eClass.getName();
		String packageName = eClass.getEPackage().getName();
		
		return data.getElementName().equals(name)
				&& data.getPackageName().equals(packageName);
	}

}
