package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictElements;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.util.ConflictEltFilter;

public class PipelineStageExecuter {	
	
	private final Conflict conflict;
	private ConflictEltFilter filter;
	private Set<String> typeNames;
	
	public PipelineStageExecuter(Conflict conflict) {
		this.filter = new ConflictEltFilter();
		this.conflict = conflict;
		this.typeNames = new HashSet<String>();
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
	
	public PipelineStageExecuter types(Set<String> typeNames) {
		this.typeNames.addAll(typeNames);
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
		ConflictElements filteredElements = new ConflictElements(conflict, filter, false);
		Set<EObject> elements = filteredElements.getObjects();
		// TODO: Implement type filtering
		return elements;
	}

}
