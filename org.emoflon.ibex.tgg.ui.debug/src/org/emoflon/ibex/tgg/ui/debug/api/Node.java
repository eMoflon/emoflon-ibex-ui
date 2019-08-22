package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.enums.DomainType;

public interface Node {

    public String getType();

    public String getName();

    public DomainType getDomain();

    public Collection<String> getAttributes();
}
