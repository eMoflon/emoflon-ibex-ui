package org.emoflon.ibex.tgg.ui.debug.api;

public interface Match {
    public String getName();

    public boolean isBlocked();

    public String getBlockingReason();

    public Rule getRule();

    public Graph getGraph(int pNeighbourhoodSize);
}
