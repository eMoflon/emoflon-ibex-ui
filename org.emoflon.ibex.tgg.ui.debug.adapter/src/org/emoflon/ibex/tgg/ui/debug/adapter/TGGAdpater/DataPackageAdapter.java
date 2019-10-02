package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;

public class DataPackageAdapter implements DataPackage {
	private Collection<Match> matches;
	private List<RuleApplication> ruleApplications;

	public DataPackageAdapter(org.emoflon.ibex.tgg.operational.monitoring.DataPackage pDataPackage) {
		matches = pDataPackage.getMatches().stream()//
				.map((match) -> IbexMatchAdapter.adapt(match))//
				.collect(Collectors.toSet());
		ruleApplications = pDataPackage.getProtocol().stream()//
				.map((step) -> ProtocolStepAdapter.adapt(step))//
				.collect(Collectors.toList());
	}

	@Override
	public Collection<Match> getMatches() {
		return matches;
	}

	@Override
	public List<RuleApplication> getRuleApplications() {
		return ruleApplications;
	}
}
