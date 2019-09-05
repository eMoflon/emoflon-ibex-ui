package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IbexMatch;
import org.emoflon.ibex.tgg.ui.debug.api.Graph;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

import language.DomainType;
import language.TGGRule;
import language.TGGRuleNode;

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
		IMatch iMatch = pMatch.getIMatch();
		GraphBuilder graphBuilder = new GraphBuilder();
		TGGRuleAdapter rule = TGGRuleAdapter.getRuleByName(iMatch.getRuleName());
		Map<String, TGGRuleNodeAdapter> paramToNodeMap = new HashMap<String, TGGRuleNodeAdapter>();
		Collection<String> parameterNames = iMatch.getParameterNames();
		for (String param : parameterNames) {
			TGGRuleNodeAdapter node = rule.getNodes().stream().filter(n -> n.getName().equals(param)).findFirst()
					.orElse(null);
			paramToNodeMap.put(param, node);
		}

		for (Map.Entry<String, TGGRuleNodeAdapter> entry : paramToNodeMap.entrySet()) {
			TGGRuleNodeAdapter ruleNode = entry.getValue();
			if (ruleNode.getDomain().equals(Domain.SRC)) {

				EObject obj = (EObject) iMatch.get(entry.getKey());
				graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.SRC));

			} else if (ruleNode.getDomain().equals(Domain.TRG)) {

				EObject obj = (EObject) iMatch.get(entry.getKey());
				graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.TRG));
			} else {

				EObject obj = (EObject) iMatch.get(entry.getKey());
				graphBuilder.addEdge(":" + obj.eClass().getName(), //
						EObjectAdapter.adapt((EObject) obj.eGet(obj.eClass().getEStructuralFeature("source")),
								Domain.SRC), //
						EObjectAdapter.adapt((EObject) obj.eGet(obj.eClass().getEStructuralFeature("target")),
								Domain.TRG), //
						EdgeType.CORR, //
						Action.CONTEXT);
			}
		}
	}

	// Alternate implementation using TGGIbex elements

	/*
	 * private IbexMatchAdapter(IbexMatch pMatch) { match = pMatch; IMatch iMatch =
	 * pMatch.getIMatch(); GraphBuilder graphBuilder = new GraphBuilder(); TGGRule
	 * rule = TGGRuleAdapter.getRuleByName(iMatch.getRuleName()).getWrappedRule();
	 * Map<String, TGGRuleNode> paramToNodeMap = new HashMap<String, TGGRuleNode>();
	 * Collection<String> parameterNames = iMatch.getParameterNames(); for (String
	 * param : parameterNames) { TGGRuleNode node =
	 * rule.getNodes().stream().filter(n ->
	 * n.getName().equals(param)).findFirst().orElse(null);
	 * paramToNodeMap.put(param, node); }
	 * 
	 * 
	 * 
	 * for (Map.Entry<String, TGGRuleNode> entry : paramToNodeMap.entrySet()) {
	 * TGGRuleNode ruleNode = entry.getValue(); if
	 * (ruleNode.getDomainType().equals(DomainType.SRC)) {
	 * 
	 * EObject obj = (EObject) iMatch.get(entry.getKey());
	 * graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.SRC));
	 * 
	 * } else if (ruleNode.getDomainType().equals(DomainType.TRG)) {
	 * 
	 * EObject obj = (EObject) iMatch.get(entry.getKey());
	 * graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.TRG)); } else {
	 * 
	 * EObject obj = (EObject) iMatch.get(entry.getKey()); graphBuilder.addEdge(":"
	 * + obj.eClass().getName(), // EObjectAdapter.adapt((EObject)
	 * obj.eGet(obj.eClass().getEStructuralFeature("source")), Domain.SRC), //
	 * EObjectAdapter.adapt((EObject)
	 * obj.eGet(obj.eClass().getEStructuralFeature("target")), Domain.TRG), //
	 * EdgeType.CORR, // Action.CONTEXT); } } }
	 */

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
