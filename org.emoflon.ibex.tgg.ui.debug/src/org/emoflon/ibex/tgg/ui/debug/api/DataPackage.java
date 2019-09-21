package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;
import java.util.List;

public interface DataPackage {
    public Collection<Match> getMatches();

    public List<RuleApplication> getRuleApplications();
}
