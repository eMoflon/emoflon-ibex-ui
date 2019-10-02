package org.emoflon.ibex.tgg.ui.debug.api;

import java.util.Collection;

/**
 * Defines how multiple {@link RuleApplication}s are merged together into a
 * single Graph for joint visualization.
 */
public interface RuleApplicationMerger {
	public Graph getMergedGraph(Collection<RuleApplication> ruleApplications, int neighbourhoodSize);
}
