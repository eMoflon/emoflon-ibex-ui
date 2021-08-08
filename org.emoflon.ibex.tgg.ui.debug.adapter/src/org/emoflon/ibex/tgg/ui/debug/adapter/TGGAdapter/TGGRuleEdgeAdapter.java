package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

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

	public static TGGRuleEdgeAdapter adapt(TGGRuleEdge ruleEdge, Domain domain, IBeXOperation operationType) {
		if (!wrappers.containsKey(ruleEdge))
			wrappers.put(ruleEdge, new TGGRuleEdgeAdapter(ruleEdge, domain, operationType));
		return wrappers.get(ruleEdge);
	}

	// ----------

	private TGGRuleEdge edge;
	private Action action;

	private TGGRuleEdgeAdapter(TGGRuleEdge ruleEdge, Domain domain, IBeXOperation operationType) {
		edge = ruleEdge;

		if (!BindingType.CREATE.equals(edge.getBindingType()))
			action = Action.CONTEXT;
		else if ((Domain.SRC.equals(domain) && (IBeXOperation.FWD.equals(operationType) || IBeXOperation.CC.equals(operationType) || IBeXOperation.CO.equals(operationType) )) || //
				(Domain.TRG.equals(domain) && (IBeXOperation.BWD.equals(operationType) || IBeXOperation.CC.equals(operationType) || IBeXOperation.CO.equals(operationType))))
			action = Action.TRANSLATE;
		else
			action = Action.CREATE;
	}

	@Override
	public Node getSrcNode() {
		return TGGRuleNodeAdapter.get(edge.getSrcNode());
	}

	@Override
	public Node getTrgNode() {
		return TGGRuleNodeAdapter.get(edge.getTrgNode());
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
