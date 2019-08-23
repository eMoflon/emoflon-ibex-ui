package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

import language.DomainType;

public class DomainTypeAdapter {
    public static Domain adapt(DomainType value) {
	switch (value) {
	case TRG:
	    return Domain.TRG;
	case SRC:
	    return Domain.SRC;
	default:
	    break;
	}

	throw new IllegalArgumentException("Adapter doesn't handle case: " + value);
    }
}
