package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplicationMerger;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.impl.EdgeImpl;
import org.emoflon.ibex.tgg.ui.debug.api.impl.NodeImpl;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class ProtocolStepAdapter implements RuleApplication {

	private static ProtocolStepMerger protocolStepMerger = new ProtocolStepMerger();

	private static Map<ProtocolStep, ProtocolStepAdapter> wrappers = new HashMap<>();

	public static ProtocolStepAdapter adapt(ProtocolStep pProtocolStep) {
		if (!wrappers.containsKey(pProtocolStep))
			wrappers.put(pProtocolStep, new ProtocolStepAdapter(pProtocolStep));
		return wrappers.get(pProtocolStep);
	}

	// ----------

	private ProtocolStep protocolStep;

	private ProtocolStepAdapter(ProtocolStep pProtocolStep) {
		protocolStep = pProtocolStep;
	}

	public int getIndex() {
		return protocolStep.getIndex();
	}

	public RuleApplicationMerger getMerger() {
		return protocolStepMerger;
	}

	private static class ProtocolStepMerger implements RuleApplicationMerger {
		@Override
		public Graph getMergedGraph(Collection<RuleApplication> pRuleApplications, int pNeighbourhoodSize) {

			Collection<EObject> srcElements = null;
			Collection<EObject> trgElements = null;
			Collection<EObject> corrElements = null;

			for (RuleApplication ruleApplication : pRuleApplications) {
				if (!(ruleApplication instanceof ProtocolStepAdapter))
					throw new IllegalStateException(
							"This merger only supports RuleApplications of type ProtocolStepAdapter.");

				srcElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getSrcElements();
				trgElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getTrgElements();
				corrElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getCorrElements();
			}

			TGGObjectGraph objectGraph = VictoryIBeXAdapter.getNeighbourhood(srcElements, trgElements, corrElements, pNeighbourhoodSize);
						
			GraphBuilder builder = new GraphBuilder();
			Collection<Node> nodes = new HashSet<>();
			for (org.emoflon.ibex.tgg.operational.monitoring.data.Node n : objectGraph.getNodes()) {
				Node nn = convertNode(n);
				nodes.add(nn);
				builder.addNode(nn);
			}

			for (org.emoflon.ibex.tgg.operational.monitoring.data.Edge e : objectGraph.getEdges()) {
				Node s = nodes.stream().filter(n -> n.getName().equals(e.getSrcNode().getName())
						&& n.getType().equals(e.getSrcNode().getType())).findFirst().orElseGet(null);

				Node t = nodes.stream().filter(n -> n.getName().equals(e.getTrgNode().getName())
						&& n.getType().equals(e.getTrgNode().getType())).findFirst().orElseGet(null);

				builder.addEdge(convertEdge(e, s, t));
			}

			return builder.build();
		}
	}

	private static Edge convertEdge(org.emoflon.ibex.tgg.operational.monitoring.data.Edge e, Node s, Node t) {
		Action action = Action.valueOf(e.getAction().toString());
		EdgeType type = EdgeType.valueOf(e.getType().toString());
		return new EdgeImpl(e.getLabel(), s, t, type, action);
	}

	private static Node convertNode(org.emoflon.ibex.tgg.operational.monitoring.data.Node n) {
		Action action = null;
		if (n.getAction() != null) {
			action = Action.valueOf(n.getAction().toString());
		}
		Domain domain = Domain.valueOf(n.getDomain().toString());
//		if (domain == null) {
//			if (Domain.valueOf(n.getDomain().toString()) != null) {
//				domain = Domain.valueOf(n.getDomain().toString());
//			}
//		}
		return new NodeImpl(n.getType(), n.getName(), domain, action, n.getAttributes());
	}

	@Override
	public String getRuleName() {
		// TODO return name of protocol step
		return protocolStep.getRuleName();
	}
}
