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

			int index = -1;
			Collection<EObject> srcElements = null;
			Collection<EObject> trgElements = null;
			Collection<EObject> corrElements = null;
			Collection<EObject> matchSrcElements = null;
			Collection<EObject> matchTrgElements = null;
			Collection<EObject> matchCorrElements = null;
			String ruleName = "";

			for (RuleApplication ruleApplication : pRuleApplications) {
				if (!(ruleApplication instanceof ProtocolStepAdapter))
					throw new IllegalStateException(
							"This merger only supports RuleApplications of type ProtocolStepAdapter.");

				index = ((ProtocolStepAdapter) ruleApplication).protocolStep.getIndex();
				srcElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getSrcElements();
				trgElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getTrgElements();
				corrElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getCorrElements();
				matchSrcElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getMatchSrcElements();
				matchTrgElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getMatchTrgElements();
				matchCorrElements = ((ProtocolStepAdapter) ruleApplication).protocolStep.getMatchCorrElements();
				ruleName = ((ProtocolStepAdapter) ruleApplication).protocolStep.getRuleName();
			}
			
			Collection<EObject> nSrcElements = VictoryIBeXAdapter.getNeighbourhood(matchSrcElements, pNeighbourhoodSize - 1);
			Collection<EObject> nTrgElements = VictoryIBeXAdapter.getNeighbourhood(matchTrgElements, pNeighbourhoodSize - 1);
			
			TGGObjectGraph objectGraph = VictoryIBeXAdapter.cTGGObjectGraph(index, srcElements, trgElements, corrElements, ruleName);
						
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

			for (EObject en : nSrcElements) {
				Node nn = convertNode(VictoryIBeXAdapter.gNode(en, "SRC"));
				
				Node s = nodes.stream().filter(
						n -> n.getName().equals(nn.getName()) &&
						n.getDomain().equals(nn.getDomain()) &&
						n.getType().equals(nn.getType()) 
				).findFirst().orElseGet(() -> nn);	

				nodes.add(s);
				builder.addNode(s);	
				
			}
			
			for (EObject en : nTrgElements) {
				Node nn = convertNode(VictoryIBeXAdapter.gNode(en, "TRG"));
				
				Node s = nodes.stream().filter(
						n -> n.getName().equals(nn.getName()) &&
						n.getDomain().equals(nn.getDomain()) &&
						n.getType().equals(nn.getType()) 
				).findFirst().orElseGet(() -> nn);				
				
				nodes.add(s);
				builder.addNode(s);	
				
			}	
			
			if (pNeighbourhoodSize > 0) {
				for (EObject en : matchCorrElements) {
					EObject sne = (EObject) en.eGet(en.eClass().getEStructuralFeature("source"));
					EObject tne = (EObject) en.eGet(en.eClass().getEStructuralFeature("target"));
					Node sn = convertNode(VictoryIBeXAdapter.gNode(sne, "SRC"));
					Node tn = convertNode(VictoryIBeXAdapter.gNode(tne, "TRG"));
					
					Node s = nodes.stream().filter(
							n -> n.getName().equals(sn.getName()) &&
							n.getDomain().equals(sn.getDomain()) &&
							n.getType().equals(sn.getType()) 
					).findFirst().orElseGet(() -> sn);
					
	
					Node t = nodes.stream().filter(
							n -> n.getName().equals(tn.getName()) &&
							n.getDomain().equals(tn.getDomain()) &&
							n.getType().equals(tn.getType()) 
					).findFirst().orElseGet(() -> tn);
					
					
					EdgeImpl e = new EdgeImpl("", s, t, EdgeType.CORR, Action.CONTEXT);
					builder.addEdge(e);
				}
				
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
