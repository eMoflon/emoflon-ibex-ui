package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

import language.BindingType;
import language.DomainType;
import language.TGGRuleNode;

public class TGGRuleNodeAdapter implements Node {

	private static Map<TGGRuleNode, TGGRuleNodeAdapter> wrappers = new HashMap<>();

	public static TGGRuleNodeAdapter adapt(TGGRuleNode ruleNode, Domain domain, IBeXOperation operationType) {
		if (wrappers.containsKey(ruleNode))
			throw new IllegalStateException("The specified rule has already been adapted.");

		TGGRuleNodeAdapter adapter = new TGGRuleNodeAdapter(ruleNode, domain, operationType);
		wrappers.put(ruleNode, adapter);
		return adapter;
	}

	public static TGGRuleNodeAdapter get(TGGRuleNode ruleNode) {
		if (!wrappers.containsKey(ruleNode))
			throw new IllegalStateException("The specified rule has not been adapted yet.");
		return wrappers.get(ruleNode);
	}

	// ----------

	private TGGRuleNode node;
	private Action action;

	private TGGRuleNodeAdapter(TGGRuleNode ruleNode, Domain domain, IBeXOperation operationType) {
		node = ruleNode;

		if (!BindingType.CREATE.equals(node.getBindingType()))
			action = Action.CONTEXT;
		else if ((Domain.SRC.equals(domain) && IBeXOperation.FWD.equals(operationType)) || //
				(Domain.TRG.equals(domain) && IBeXOperation.BWD.equals(operationType)))
			action = Action.TRANSLATE;
		else
			action = Action.CREATE;
	}

	@Override
	public Domain getDomain() {
		if (DomainType.SRC.equals(node.getDomainType()))
			return Domain.SRC;
		else
			return Domain.TRG;
	}

	@Override
	public String getType() {
		return node.getType().getName();
	}

	@Override
	public List<String> getAttributes() {
		// TODO Requires a String for each line of attributes that should be displayed
		// For rule-nodes we can leave this empty for now, but we may want to fill in
		// the fields it has later
		return Collections.emptyList();
	}

	@Override
	public String getName() {
		return node.getName();
	}

	@Override
	public Action getAction() {
		return action;
	}
}
