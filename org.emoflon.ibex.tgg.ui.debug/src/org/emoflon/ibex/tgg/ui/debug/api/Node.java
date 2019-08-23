package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

public interface Node {

    public String getType();

    public String getName();

    public Domain getDomain();

    public Action getAction();

    public Collection<String> getAttributes();
}
