package org.emoflon.ibex.tgg.ui.debug.views;

import org.emoflon.ibex.tgg.operational.matches.IMatch;

public interface IVisualiser {
    /**
     * Called to request the visualisation of a TGG rule.
     * 
     * @param pRuleName
     *            the name of the rule to be visualised
     */
    public default void display(String pRuleName) {
	// don't do anything
    }

    /**
     * Called to request the visualisation of a match.
     * 
     * @param pMatch
     *            the match to be visualised
     */
    public default void display(IMatch pMatch) {
	// don't do anything
    }
}
