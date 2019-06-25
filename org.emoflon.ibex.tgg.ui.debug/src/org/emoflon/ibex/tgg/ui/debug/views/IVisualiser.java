package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.matches.IMatch;

import language.TGGRule;

public interface IVisualiser {
    /**
     * Called to request the visualisation of a TGG rule.
     * 
     * @param pRuleName the name of the rule to be visualised
     */
    public void display(TGGRule pRuleName);

    /**
     * Called to request the visualisation of a match.
     * 
     * @param pMatch the match to be visualised
     */
    public void display(IMatch pMatch);

    /**
     * Called to request the visualisation of a collection of EObjects.
     * 
     * @param pObjectGraph the EObjects to be visualised
     */
    public void display(Collection<EObject> pObjectGraph, Collection<EObject> pCorrElements);

    /**
     * Called to force a refresh of the currently visualised element.
     */
    public default void refresh() {
	// don't do anything
    }
}
