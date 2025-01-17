package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.resolution.util.ConflictElements;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.resolution.util.ConflictEltFilter;

public class ConflictPipelineExecuter implements PipelineExecuter {

	private final Conflict conflict;
	private ConflictEltFilter filter;
	private Set<TypeFilterData> typeFilterData;
	
	public ConflictPipelineExecuter(Conflict conflict) {
		this.conflict = conflict;
		this.filter = new ConflictEltFilter();
		this.typeFilterData = new HashSet<TypeFilterData>();
	}
	
	@Override
	public PipelineExecuter src() {
		filter.src();
		return this;
	}

	@Override
	public PipelineExecuter trg() {
		filter.trg();
		return this;
	}

	@Override
	public PipelineExecuter created() {
		filter.created();
		return this;
	}

	@Override
	public PipelineExecuter deleted() {
		filter.deleted();
		return this;
	}

	@Override
	public PipelineExecuter types(Set<TypeFilterData> data) {
		this.typeFilterData.addAll(data);
		return this;
	}

	@Override
	public int count() {
		return executeFilter().size();
	}

	@Override
	public boolean exists() {
		return !executeFilter().isEmpty();
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
