package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.tgg.operational.monitoring.data.ProtocolStep;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraphBuilder;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplicationMerger;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
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
			TGGObjectGraphBuilder tObjectGraphBuilder = new TGGObjectGraphBuilder();
			TGGRuleAdapter rule = null;
			for (RuleApplication ruleApplication : ruleApplications) {
				if (!(ruleApplication instanceof ProtocolStepAdapter))
					throw new IllegalStateException(
							"This merger only supports RuleApplications of type ProtocolStepAdapter.");
				
				ProtocolStep cps = ((ProtocolStepAdapter) ruleApplication).protocolStep;
				rule = TGGRuleAdapter.getRuleByName(cps.getAppliedRule().getName());

				wrappers.keySet().stream().filter(p -> p.getIndex() == cps.getIndex()).forEach(p -> tObjectGraphBuilder.add(p.getObjectGraph()));
				
				TGGObjectGraph tGraph = tObjectGraphBuilder.build();
//				tGraph = constructNewGraph(rule, tGraph);
				
				objectGraphBuilder.add(tGraph);
				
			}
			
			TGGObjectGraph objectGraph = objectGraphBuilder.build();

			GraphBuilder builder = new GraphBuilder();
			
			EObjectAdapter.constructGraphDomain(builder, Domain.SRC,
					VictoryIBeXAdapter.getNeighbourhood(objectGraph.getSrcElements(), neighbourhoodSize), rule);
			EObjectAdapter.constructGraphDomain(builder, Domain.TRG,
					VictoryIBeXAdapter.getNeighbourhood(objectGraph.getTrgElements(), neighbourhoodSize), rule);
			EObjectAdapter.constructCorrEdges(builder, objectGraph.getCorrElements(), rule);
			
			return builder.build();

		}
	}

	@Override
	public String getRuleName() {
		return protocolStep.getAppliedRule().getName();
	}
	
	private static TGGObjectGraph constructNewGraph(TGGRuleAdapter rule, TGGObjectGraph objectGraph) {	
		
		Collection<EObject> src = new HashSet<>();
		Collection<EObject> trg = new HashSet<>();		
		
		for (EObject obj : objectGraph.getSrcElements()) {
			EObjectAdapter node = EObjectAdapter.adapt(obj, Domain.SRC, Action.CONTEXT);
			Collection <Node> nodes = new HashSet<Node>(); 
			rule.getGraph().getEdges().stream().filter(e -> e.getAction().equals(Action.CREATE)).forEach(e -> {
				nodes.add(e.getSrcNode());
				nodes.add(e.getTrgNode());
			});
			if (nodes.stream().anyMatch(n ->
					n.getType().equals(node.getType()) &&
					n.getDomain().equals(node.getDomain())
					)) {
				src.add(obj);
			} else {
				System.out.println(node.getType());
				EcoreUtil.remove(obj);
			}
		} 
		
		for (EObject obj : objectGraph.getTrgElements()) {
			EObjectAdapter node = EObjectAdapter.adapt(obj, Domain.TRG, Action.CONTEXT);
			Collection <Node> nodes = new HashSet<Node>(); 
			rule.getGraph().getEdges().stream().filter(e -> e.getAction().equals(Action.CREATE)).forEach(e -> {
				nodes.add(e.getSrcNode());
				nodes.add(e.getTrgNode());
			});
			if (nodes.stream().anyMatch(n ->
					n.getType().equals(node.getType()) &&
					n.getDomain().equals(node.getDomain())
					)) {
				trg.add(obj);
			} else {
				System.out.println(node.getType());
				EcoreUtil.remove(obj);
			}
		} 		
		
		return new TGGObjectGraph(src, trg, objectGraph.getCorrElements());
	}
	
}
