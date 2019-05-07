package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean isMatchCacheInvalid = false;

    private boolean displayFullRuleForMatches = false;

    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    public void setDisplayFullRuleForMatches(boolean pDisplayFullRuleForMatches) {
	if (displayFullRuleForMatches != pDisplayFullRuleForMatches) {
	    displayFullRuleForMatches = pDisplayFullRuleForMatches;
	    isMatchCacheInvalid = true;
	}
    }

    public boolean isMatchCacheInvalid() {
	return isMatchCacheInvalid;
    }

    public void setMatchCacheValidated() {
	isMatchCacheInvalid = false;
    }
}
