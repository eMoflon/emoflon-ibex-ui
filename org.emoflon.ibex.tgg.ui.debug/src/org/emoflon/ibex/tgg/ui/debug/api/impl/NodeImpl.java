package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.DomainType;

public class NodeImpl implements Node {
    private String type;
    private String name;
    private DomainType domain;
    private Action action;
    private Collection<String> attributes;

    public NodeImpl(String pType, String pLabel, DomainType pDomain, Collection<String> pAttributes) {
	type = pType;
	name = pLabel;
	domain = pDomain;
	attributes = pAttributes;
    }

    public String getType() {
	return type;
    }

    public void setType(String pType) {
	type = pType;
    }

    public String getName() {
	return name;
    }

    public void setName(String pName) {
	name = pName;
    }

    public DomainType getDomain() {
	return domain;
    }

    public void setDomain(DomainType pDomain) {
	domain = pDomain;
    }

    public Action getAction() {
	return action;
    }

    public void setAction(Action pAction) {
	action = pAction;
    }

    public Collection<String> getAttributes() {
	return attributes;
    }

    public void setAttributes(Collection<String> pAttributes) {
	attributes = pAttributes;
    }
}
