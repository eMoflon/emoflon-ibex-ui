package org.emoflon.ibex.tgg.ui.debug.api;

public interface RuleApplication {
    public int getIndex();

    public Graph getGraph(int pNeighbourhoodSize);
}
