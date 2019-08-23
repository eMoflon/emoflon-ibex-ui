package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import language.TGGRuleNode;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

public class NodeAdapter implements Node {

	private TGGRuleNode node;

	public NodeAdapter(TGGRuleNode node) {
		super();
		this.node = node;
	}

	public TGGRuleNode unWrap() {

		return this.node;

	}

	@Override
	public Domain getDomain() {

		return DomainTypeAdapter.adapt(node.getDomainType());
	}

	@Override
	public String getType() {

		return node.getType().getName();
	}

	// TODO: what is expected here?? check!!
	@Override
	public String getLabel() {

		return node.getName();
	}

	// TODO: implementation!!
	@Override
	public Collection<String> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
