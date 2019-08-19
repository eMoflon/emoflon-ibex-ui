package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.ui.debug.api.IRuleCorr;
import org.emoflon.ibex.tgg.ui.debug.api.IRuleNode;
import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryBindingType;
import org.emoflon.ibex.tgg.ui.debug.api.enums.VictoryDomainType;
import language.TGGRuleCorr;

public class TGGRuleCorrAdapter extends RuleNodeAdapter implements IRuleCorr{

	private TGGRuleCorr corrNode;

	public TGGRuleCorrAdapter(TGGRuleCorr pCorrNode) {
		super(pCorrNode);
		corrNode = pCorrNode;

	}

	@Override
	public IRuleNode getSource() {

		return new RuleNodeAdapter (corrNode.getSource());
	}

	@Override
	public IRuleNode getTarget() {

		return new RuleNodeAdapter (corrNode.getTarget());
	}

	//TODO: redundant code, can be removed

	@Override
	public String getTypeName() {

		return corrNode.getType().getName();
	}
	@Override
	public VictoryDomainType getDomainType() {
		return DomainTypeAdapter.adapt(corrNode.getDomainType());
	}

	@Override
	public VictoryBindingType getBindingType() {

		return BindingTypeAdapter.adapt(corrNode.getBindingType());
	}


}
