package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

public interface RuleApplicationMerger {
    public Graph getMergedGraph(Collection<RuleApplication> pRuleApplications, int pNeighbourhoodSize);
}
