package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;

import language.BindingType;
import language.TGGRuleEdge;

public class TGGRuleEdgeAdapter implements Edge {

    private static Map<TGGRuleEdge, TGGRuleEdgeAdapter> wrappers = new HashMap<>();

    public static TGGRuleEdgeAdapter adapt(TGGRuleEdge pProtocolStep) {
	if (!wrappers.containsKey(pProtocolStep))
	    wrappers.put(pProtocolStep, new TGGRuleEdgeAdapter(pProtocolStep));
	return wrappers.get(pProtocolStep);
    }

    // ----------

    private TGGRuleEdge edge;

    private TGGRuleEdgeAdapter(TGGRuleEdge pEdge) {
	edge = pEdge;

    }

    @Override
    public Node getSrcNode() {
	return TGGRuleNodeAdapter.adapt(edge.getSrcNode());
    }

    @Override
    public Node getTrgNode() {
	return TGGRuleNodeAdapter.adapt(edge.getTrgNode());
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
	if (BindingType.CREATE.equals(edge.getBindingType()))
	    return Action.CREATE;
	else
	    return Action.CONTEXT;
    }
}
