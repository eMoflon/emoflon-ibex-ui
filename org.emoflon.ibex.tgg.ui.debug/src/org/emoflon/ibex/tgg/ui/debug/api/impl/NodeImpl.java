package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.List;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

public class NodeImpl implements Node {
	private String pType;
	private String pName;
	private Domain pDomain;
	private Action pAction;
	private List<String> pAttributes;

	public NodeImpl(String pType, String pName, Domain pDomain, Action pAction, List<String> pAttributes) {
		this.pType = pType;
		this.pName = pName;
		this.pDomain = pDomain;
		this.pAttributes = pAttributes;
		this.pAction = pAction;
	}

	public String getType() {
		return pType;
	}

	public void setType(String pType) {
		this.pType = pType;
	}

	public void setLabel(String pName) {
		this.pName = pName;
	}

	public List<String> getAttributes() {
		return pAttributes;
	}

	public void setLabel(List<String> pAttributes) {
		this.pAttributes = pAttributes;
	}

	@Override
	public String getName() {
		return pName;
	}

	@Override
	public Domain getDomain() {
		return pDomain;
	}

	@Override
	public Action getAction() {
		return pAction;
	}
}