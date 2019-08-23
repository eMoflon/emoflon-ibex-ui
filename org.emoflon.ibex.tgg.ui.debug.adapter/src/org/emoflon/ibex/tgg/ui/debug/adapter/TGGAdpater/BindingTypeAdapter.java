package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import language.BindingType;

public class BindingTypeAdapter {
    public static Binding adapt(BindingType value) {
	switch (value) {
	case CONTEXT:
	    return Binding.CONTEXT;
	case CREATE:
	    return Binding.CREATE;
	case DELETE:
	    return Binding.DELETE;
	case NEGATIVE:
	    return Binding.NEGATIVE;
	}

	throw new IllegalArgumentException("Adapter doesn't handle case: " + value);
    }
}
