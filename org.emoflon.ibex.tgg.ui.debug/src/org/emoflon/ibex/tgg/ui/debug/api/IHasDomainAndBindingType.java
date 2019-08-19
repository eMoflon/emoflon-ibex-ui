package org.emoflon.ibex.tgg.ui.debug.api;

import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryBindingType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryDomainType;

public interface IHasDomainAndBindingType {
	
	VictoryDomainType getDomainType();
	VictoryBindingType getBindingType();
}
