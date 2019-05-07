package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean displayFullRuleForMatches = false;

    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    public void setDisplayFullRuleForMatches(boolean pDisplayFullRuleForMatches) {
	displayFullRuleForMatches = pDisplayFullRuleForMatches;
    }
}
