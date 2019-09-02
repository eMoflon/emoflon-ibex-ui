package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.monitoring.IbexMatch;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class IbexMatchAdapter implements Match {

    private static Map<IbexMatch, IbexMatchAdapter> wrappers = new HashMap<>();

    public static IbexMatchAdapter adapt(IbexMatch pMatch) {
	if (!wrappers.containsKey(pMatch))
	    wrappers.put(pMatch, new IbexMatchAdapter(pMatch));
	return wrappers.get(pMatch);
    }

    // ----------

    private IbexMatch match;

    private IbexMatchAdapter(IbexMatch pMatch) {
	match = pMatch;
    }

    public IbexMatch getWrappedMatch() {
	return match;
    }

    @Override
    public String getName() {
	return match.getName();
    }

    @Override
    public boolean isBlocked() {
	return match.isBlocked();
    }

    @Override
    public String getBlockingReason() {
	return match.getBlockingReason();
    }

    @Override
    public Rule getRule() {
	return TGGRuleAdapter.getRuleByName(match.getIMatch().getRuleName());
    }

    @Override
    public Graph getGraph() {
	// TODO build graph
	return new GraphBuilder().build();
    }
}
