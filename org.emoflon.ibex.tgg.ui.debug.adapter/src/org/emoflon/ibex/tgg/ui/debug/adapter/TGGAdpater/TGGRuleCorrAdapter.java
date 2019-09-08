package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;

import language.BindingType;
import language.TGGRuleCorr;

public class TGGRuleCorrAdapter implements Edge {

    private static Map<TGGRuleCorr, TGGRuleCorrAdapter> wrappers = new HashMap<>();

    public static TGGRuleCorrAdapter adapt(TGGRuleCorr pProtocolStep) {
	if (!wrappers.containsKey(pProtocolStep))
	    wrappers.put(pProtocolStep, new TGGRuleCorrAdapter(pProtocolStep));
	return wrappers.get(pProtocolStep);
    }

    // ----------

    private TGGRuleCorr corr;

    private TGGRuleCorrAdapter(TGGRuleCorr pCorr) {
	corr = pCorr;
    }

    @Override
    public String getLabel() {
	return ":" + corr.getType().getName();
    }

    @Override
    public Node getSrcNode() {
	return TGGRuleNodeAdapter.get(corr.getSource());
    }

    @Override
    public Node getTrgNode() {
	return TGGRuleNodeAdapter.get(corr.getTarget());
    }

    @Override
    public EdgeType getType() {
	return EdgeType.CORR;
    }

    @Override
    public Action getAction() {
	if (BindingType.CREATE.equals(corr.getBindingType()))
	    return Action.CREATE;
	else
	    return Action.CONTEXT;
    }

    public String getName() {
	return corr.getName();
    }
}
