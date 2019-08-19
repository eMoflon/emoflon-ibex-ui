package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.ui.debug.api.IRuleNode;
import language.TGGRuleNode;
import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryBindingType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryDomainType;


public class RuleNodeAdapter implements IRuleNode {
	
	private TGGRuleNode node;

	public RuleNodeAdapter(TGGRuleNode node) {
		super();
		this.node = node;
	}

	public TGGRuleNode unWrap(){
		
		return this.node;
	
	}

	@Override
	public String getName() {

		return node.getName();
	}


	@Override
	public VictoryDomainType getDomainType() {
		
		return DomainTypeAdapter.adapt(node.getDomainType());
	}

	@Override
	public VictoryBindingType getBindingType() {

		return BindingTypeAdapter.adapt(node.getBindingType());
	}

	@Override
	public String getTypeName() {

		return node.getType().getName();
	}



}
