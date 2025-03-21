package org.emoflon.ibex.tgg.integrate.api.variable;

import java.util.HashSet;
import java.util.Set;

import org.emoflon.ibex.tgg.integrate.internal.delta.OperationalDeltaEvaluator;
import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.BindingType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.DomainType;

public class OperationalDeltaPipelineExecuter implements PipelineExecuter {

	private final Conflict conflict;
	private final Set<DomainType> domainTypes;
	private final Set<BindingType> modifications;
	private final String resolutionStrategy;
	
	public OperationalDeltaPipelineExecuter(Conflict conflict, String resolutionStrategy) {
		this.conflict = conflict;
		this.domainTypes = new HashSet<DomainType>();
		this.modifications = new HashSet<BindingType>();
		this.resolutionStrategy = resolutionStrategy;
	}

	@Override
	public PipelineExecuter src() {
		domainTypes.add(DomainType.SOURCE);
		return this;
	}

	@Override
	public PipelineExecuter trg() {
		domainTypes.add(DomainType.TARGET);
		return this;
	}

	@Override
	public PipelineExecuter created() {
		modifications.add(BindingType.CREATE);
		return this;
	}

	@Override
	public PipelineExecuter deleted() {		
		modifications.add(BindingType.DELETE);
		return this;
	}

	@Override
	public PipelineExecuter types(Set<TypeFilterData> data) {
		// TODO INTEGRATE: Implement type filtering for operational delta evaluation
		return this;
	}

	@Override
	public int count() {
		int count = OperationalDeltaEvaluator.evaluate(conflict, domainTypes, modifications, resolutionStrategy);
		return count;
	}

	@Override
	public boolean exists() {
		int count = OperationalDeltaEvaluator.evaluate(conflict, domainTypes, modifications, resolutionStrategy);
		return count > 0;
	}

}
