package org.emoflon.ibex.tgg.integrate.internal.delta.strategies;

import java.util.Set;

import org.emoflon.ibex.tgg.runtime.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.BindingType;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.DomainType;

public abstract class ResolutionStrategyOperationalDeltaEvaluator {
	
	protected final Conflict conflict;
	protected final Set<DomainType> domainTypes;
	protected final Set<BindingType> modifications;
	
	public ResolutionStrategyOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		this.conflict = conflict;
		this.domainTypes = domainTypes;
		this.modifications = modifications;
	}

	public abstract int evaluate();
}
