package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean isInvalid = false;

    private boolean displayFullRuleForMatches = false;

    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    public void setDisplayFullRuleForMatches(boolean pDisplayFullRuleForMatches) {
	if (displayFullRuleForMatches != pDisplayFullRuleForMatches) {
	    displayFullRuleForMatches = pDisplayFullRuleForMatches;
	    isInvalid = true;
	}
    }

    public boolean isInvalid() {
	return isInvalid;
    }

    public void revalidate() {
	isInvalid = false;
    }
}
