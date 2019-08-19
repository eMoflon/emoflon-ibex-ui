package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryDomainType;

public interface Node {

    public String getType();

    public String getLabel();

    public VictoryDomainType getDomain();

    public Collection<String> getAttributes();
}
