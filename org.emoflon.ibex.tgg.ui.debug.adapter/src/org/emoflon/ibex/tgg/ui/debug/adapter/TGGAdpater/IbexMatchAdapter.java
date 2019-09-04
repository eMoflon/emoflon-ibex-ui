package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    private IMatch iMatch;

    private IbexMatchAdapter(IbexMatch pMatch) {
	match = pMatch;
    }

    private IbexMatchAdapter(IMatch pMatch) {
	iMatch = pMatch;
	GraphBuilder graphBuilder = new GraphBuilder();
	Map<String, TGGRuleNode> paramToNodeMap = new HashMap<String, TGGRuleNode>();
	paramToNodeMap.putAll((Map<? extends String, ? extends TGGRuleNode>) iMatch.getParameterNames());

	for (Map.Entry<String, TGGRuleNode> entry : paramToNodeMap.entrySet()) {
	    TGGRuleNode ruleNode = entry.getValue();
	    if (ruleNode.getDomainType().equals(DomainType.SRC)) {
		EObject obj = (EObject) iMatch.get(entry.getKey());
		graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.SRC));

//		Map<String, EObject> srcParamToEObjectMap = new HashMap<String, EObject>();
//		srcParamToEObjectMap.put(entry.getKey(), (EObject) iMatch.get(entry.getKey()));

	    } else if (ruleNode.getDomainType().equals(DomainType.TRG)) {

		EObject obj = (EObject) iMatch.get(entry.getKey());
		graphBuilder.addNode(EObjectAdapter.adapt(obj, Domain.TRG));
//		Map<String, EObject> trgParamToEObjectMap = new HashMap<String, EObject>();
//		trgParamToEObjectMap.put(entry.getKey(), (EObject) iMatch.get(entry.getKey()));
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
//		Map<String, EObject> corrParamToEObjectMap = new HashMap<String, EObject>();
//		corrParamToEObjectMap.put(entry.getKey(), (EObject) iMatch.get(entry.getKey()));
	}
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
