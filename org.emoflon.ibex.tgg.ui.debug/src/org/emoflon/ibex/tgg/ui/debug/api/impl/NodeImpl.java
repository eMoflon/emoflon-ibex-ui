package org.emoflon.ibex.tgg.ui.debug.api.impl;

import java.util.Collection;

import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.DomainType;

public class NodeImpl implements Node {
    private String type;
    private String label;
    private DomainType domain;
    private Collection<String> attributes;

    public NodeImpl(String pType, String pLabel, DomainType pDomain, Collection<String> pAttributes) {
	type = pType;
	label = pLabel;
	domain = pDomain;
	attributes = pAttributes;
    }

    public String getType() {
	return type;
    }

    public void setType(String pType) {
	type = pType;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String pLabel) {
	label = pLabel;
    }

    public DomainType getDomain() {
	return domain;
    }

    public void setDomain(DomainType pDomain) {
	domain = pDomain;
    }

    public Collection<String> getAttributes() {
	return attributes;
    }

    public void setAttributes(Collection<String> pAttributes) {
	attributes = pAttributes;
    }
}
