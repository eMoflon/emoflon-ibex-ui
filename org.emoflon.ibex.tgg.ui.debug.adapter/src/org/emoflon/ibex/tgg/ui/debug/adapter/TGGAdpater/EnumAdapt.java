package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;

import language.BindingType;
import language.DomainType;

public class EnumAdapt {

    public static Action adaptBindingType(BindingType value) {

	switch (value) {
	case CONTEXT:
	    return Action.CONTEXT;
	case CREATE:
	    return Action.CREATE;
	// TODO: handle case: Translate
	}

	throw new IllegalArgumentException("Adapter doesn't handle case: " + value);
    }

    public static Domain adaptDomainType(DomainType value) {
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
