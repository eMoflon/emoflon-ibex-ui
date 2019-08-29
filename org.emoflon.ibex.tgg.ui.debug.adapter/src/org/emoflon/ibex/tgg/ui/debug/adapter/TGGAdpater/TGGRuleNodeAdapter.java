package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

import language.TGGRuleNode;

public class TGGRuleNodeAdapter implements Node {

    private static Map<TGGRuleNode, TGGRuleNodeAdapter> wrappers = new HashMap<>();

    public static TGGRuleNodeAdapter adapt(TGGRuleNode pRuleNode) {
	if (!wrappers.containsKey(pRuleNode))
	    wrappers.put(pRuleNode, new TGGRuleNodeAdapter(pRuleNode));
	return wrappers.get(pRuleNode);
    }

    // ----------

    private TGGRuleNode node;

    private TGGRuleNodeAdapter(TGGRuleNode pNode) {
	node = pNode;
    }

    @Override
    public Domain getDomain() {
	return EnumAdapt.adaptDomainType(node.getDomainType());
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
	// TODO Auto-generated method stub
	return null;
    }
}
