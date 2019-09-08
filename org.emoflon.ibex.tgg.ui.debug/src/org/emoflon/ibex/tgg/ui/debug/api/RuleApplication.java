package org.emoflon.ibex.tgg.ui.debug.api;

public interface RuleApplication {
    public int getIndex();
    
    public String getRuleName();

    public RuleApplicationMerger getMerger();
}
