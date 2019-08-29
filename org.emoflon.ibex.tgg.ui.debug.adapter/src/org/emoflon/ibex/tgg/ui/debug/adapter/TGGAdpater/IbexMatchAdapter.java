package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.operational.monitoring.IbexMatch;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;

public class IbexMatchAdapter implements Match {
    private IbexMatch match;

    public IbexMatchAdapter(IbexMatch pMatch) {
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
	return null;
    }
}
