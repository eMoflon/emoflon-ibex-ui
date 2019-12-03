package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraphBuilder;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplicationMerger;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class ProtocolStepAdapter implements RuleApplication {

	private static ProtocolStepMerger protocolStepMerger = new ProtocolStepMerger();

	private static Map<ProtocolStep, ProtocolStepAdapter> wrappers = new HashMap<>();

	public static ProtocolStepAdapter adapt(ProtocolStep protocolStep) {
		if (!wrappers.containsKey(protocolStep))
			wrappers.put(protocolStep, new ProtocolStepAdapter(protocolStep));
		return wrappers.get(protocolStep);
	}

	// ----------

	private ProtocolStep protocolStep;

	private ProtocolStepAdapter(ProtocolStep protocolStep) {
		this.protocolStep = protocolStep;
	}

	public int getIndex() {
		return protocolStep.getIndex();
	}

	public RuleApplicationMerger getMerger() {
		return protocolStepMerger;
	}

	private static class ProtocolStepMerger implements RuleApplicationMerger {
		@Override
		public Graph getMergedGraph(Collection<RuleApplication> ruleApplications, int neighbourhoodSize) {

			TGGObjectGraphBuilder objectGraphBuilder = new TGGObjectGraphBuilder();
			for (RuleApplication ruleApplication : ruleApplications) {
				if (!(ruleApplication instanceof ProtocolStepAdapter))
					throw new IllegalStateException(
							"This merger only supports RuleApplications of type ProtocolStepAdapter.");

				objectGraphBuilder.add(((ProtocolStepAdapter) ruleApplication).protocolStep.getObjectGraph());
			}
			TGGObjectGraph objectGraph = objectGraphBuilder.build();

			GraphBuilder builder = new GraphBuilder();
			EObjectAdapter.constructGraphDomain(builder, Domain.SRC,
					VictoryIBeXAdapter.getNeighbourhood(objectGraph.getSrcElements(), neighbourhoodSize));
			EObjectAdapter.constructGraphDomain(builder, Domain.TRG,
					VictoryIBeXAdapter.getNeighbourhood(objectGraph.getTrgElements(), neighbourhoodSize));
			EObjectAdapter.constructCorrEdges(builder, objectGraph.getCorrElements());
			return builder.build();
		}
	}

	@Override
	public String getRuleName() {
		return protocolStep.getAppliedRule().getName();
	}
}
