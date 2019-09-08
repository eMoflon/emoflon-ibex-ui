package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;

import language.BindingType;
import language.TGGRuleEdge;

public class TGGRuleEdgeAdapter implements Edge {

    private static Map<TGGRuleEdge, TGGRuleEdgeAdapter> wrappers = new HashMap<>();

    public static TGGRuleEdgeAdapter adapt(TGGRuleEdge pRuleEdge, Domain pDomain, IBeXOperation pOperationType) {
	if (!wrappers.containsKey(pRuleEdge))
	    wrappers.put(pRuleEdge, new TGGRuleEdgeAdapter(pRuleEdge, pDomain, pOperationType));
	return wrappers.get(pRuleEdge);
    }

    // ----------

    private TGGRuleEdge edge;
    private Action action;

    private TGGRuleEdgeAdapter(TGGRuleEdge pEdge, Domain pDomain, IBeXOperation pOperationType) {
	edge = pEdge;

	if (!BindingType.CREATE.equals(edge.getBindingType()))
	    action = Action.CONTEXT;
	else if ((Domain.SRC.equals(pDomain) && IBeXOperation.FWD.equals(pOperationType)) || //
		(Domain.TRG.equals(pDomain) && IBeXOperation.BWD.equals(pOperationType)))
	    action = Action.TRANSLATE;
	else
	    action = Action.CREATE;
    }

    @Override
    public Node getSrcNode() {
	return TGGRuleNodeAdapter.adapt(edge.getSrcNode(), null, null); // TODO
    }

    @Override
    public Node getTrgNode() {
	return TGGRuleNodeAdapter.adapt(edge.getTrgNode(), null, null); // TODO
    }

    @Override
    public String getLabel() {
	return edge.getType().getName();
    }

    @Override
    public EdgeType getType() {
	return EdgeType.NORMAL;
    }

    @Override
    public Action getAction() {
	return action;
    }
}
