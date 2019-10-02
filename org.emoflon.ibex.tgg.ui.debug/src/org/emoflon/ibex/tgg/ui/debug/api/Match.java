package org.emoflon.ibex.tgg.ui.debug.api;

/**
 * A representation of a match, providing all necessary info for visualization
 * by Victory.
 */
public interface Match {
    public String getName();

    public boolean isBlocked();

    public String getBlockingReason();

    public Rule getRule();

    public Graph getGraph(int pNeighbourhoodSize);
}
