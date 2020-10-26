package org.emoflon.ibex.tgg.integrate.internal.delta.strategies;

import java.util.Set;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;

import language.BindingType;
import language.DomainType;

public abstract class RevokeStrategyOperationalDeltaEvaluator {
	
	protected final Conflict conflict;
	protected final Set<DomainType> domainTypes;
	protected final Set<BindingType> modifications;
	
	public RevokeStrategyOperationalDeltaEvaluator(Conflict conflict, Set<DomainType> domainTypes,
			Set<BindingType> modifications) {
		this.conflict = conflict;
		this.domainTypes = domainTypes;
		this.modifications = modifications;
	}


}
