package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

public interface Match {
    String getRuleName();

    Collection<String> getParameterNames();

    String getPatternName();
}
