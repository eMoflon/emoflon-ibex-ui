package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.ui.debug.api.Match;

public class MatchAdapter implements Match {
	IMatch match;

	public MatchAdapter(IMatch match) {
		super();
		this.match = match;
	}

	public IMatch unWrap() {

		return this.match;

	}

	@Override
	public String getRuleName() {
		return match.getRuleName();
	}

	@Override
	public Collection<String> getParameterNames() {
		return match.getParameterNames();
	}

	@Override
	public String getPatternName() {

		return match.getPatternName();
	}
}
