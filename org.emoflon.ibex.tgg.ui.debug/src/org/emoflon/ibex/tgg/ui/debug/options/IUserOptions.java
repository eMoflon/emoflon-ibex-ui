package org.emoflon.ibex.tgg.ui.debug.options;

public interface IUserOptions {
    public enum Op {
	MODELGEN, INITIAL_FWD, INITIAL_BWD;
    }

    public boolean displayFullRuleForMatches();

    public Op getOp();
}
