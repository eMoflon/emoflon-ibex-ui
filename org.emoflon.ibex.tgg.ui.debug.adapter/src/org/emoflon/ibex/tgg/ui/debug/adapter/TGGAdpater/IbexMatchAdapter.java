package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

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

public class IbexMatchAdapter implements Match {

    private static Map<IbexMatch, IbexMatchAdapter> wrappers = new HashMap<>();

    public static IbexMatchAdapter adapt(IbexMatch pMatch) {
	if (!wrappers.containsKey(pMatch))
	    wrappers.put(pMatch, new IbexMatchAdapter(pMatch));
	return wrappers.get(pMatch);
    }

    // ----------

    private IbexMatch match;
    private Map<Integer, Graph> graphs = new HashMap<>();

    private IbexMatchAdapter(IbexMatch pMatch) {
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
    public Graph getGraph(int pNeighbourhoodSize) {
	if (!graphs.containsKey(pNeighbourhoodSize))
	    buildGraph(pNeighbourhoodSize);
	return graphs.get(pNeighbourhoodSize);
    }

    private void buildGraph(int pNeighbourhoodSize) {
	IMatch iMatch = match.getIMatch();
	GraphBuilder graphBuilder = new GraphBuilder();
	TGGRuleAdapter rule = TGGRuleAdapter.getRuleByName(iMatch.getRuleName());

	Map<EObject, TGGRuleNodeAdapter> modelObjectToRuleNodeMap = new HashMap<>();
	rule.getNodes().forEach(node -> {
	    if (iMatch.getParameterNames().contains(node.getName()))
		modelObjectToRuleNodeMap.put((EObject) iMatch.get(node.getName()), node);
	});

	Collection<EObject> srcObjects = new HashSet<>();
	Collection<EObject> trgObjects = new HashSet<>();
	modelObjectToRuleNodeMap.forEach((modelNode, ruleNode) -> {
	    switch (ruleNode.getDomain()) {
	    case SRC:
		srcObjects.add(modelNode);
		break;
	    case TRG:
		trgObjects.add(modelNode);
	    }
	});
	srcObjects.addAll(VictoryIBeXAdapter.getNeighbourhood(srcObjects, pNeighbourhoodSize));
	trgObjects.addAll(VictoryIBeXAdapter.getNeighbourhood(trgObjects, pNeighbourhoodSize));

	EObjectAdapter.constructGraphDomain(graphBuilder, Domain.SRC, srcObjects);
	EObjectAdapter.constructGraphDomain(graphBuilder, Domain.TRG, trgObjects);

	EObjectAdapter.constructCorrEdges(graphBuilder, rule.getCorrs().stream()//
		.filter(corr -> iMatch.getParameterNames().contains(corr.getName()))//
		.map(corr -> (EObject) iMatch.get(corr.getName()))//
		.collect(Collectors.toSet()));

	modelObjectToRuleNodeMap.forEach((modelNode, ruleNode) -> graphBuilder.addEdge("", ruleNode,
		EObjectAdapter.get(modelNode), EdgeType.MATCH, Action.CONTEXT));

	graphs.put(pNeighbourhoodSize, graphBuilder.build());
    }
}
