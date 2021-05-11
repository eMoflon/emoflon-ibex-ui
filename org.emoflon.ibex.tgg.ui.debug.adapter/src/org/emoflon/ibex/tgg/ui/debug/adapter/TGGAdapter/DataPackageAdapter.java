package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.TripleGraph;

public class DataPackageAdapter implements DataPackage {
	private Collection<Match> matches;
	private List<RuleApplication> ruleApplications;
	private TripleGraph tripleGraph;	

	public DataPackageAdapter(org.emoflon.ibex.tgg.operational.monitoring.DataPackage dataPackage) {
		matches = dataPackage.getMatches().stream()//
				.map((match) -> IbexMatchAdapter.adapt(match))//
				.collect(Collectors.toSet());
		ruleApplications = dataPackage.getProtocol().stream()//
				.map((step) -> ProtocolStepAdapter.adapt(step))//
				.collect(Collectors.toList());
		tripleGraph = TripleGraphAdapter.adapt(dataPackage.getTripleGraph());
		
	}

	@Override
	public Collection<Match> getMatches() {
		return matches;
	}

	@Override
	public List<RuleApplication> getRuleApplications() {
		return ruleApplications;
	}

	@Override
	public TripleGraph getTripleGraph() {
		return tripleGraph;
	}

}
