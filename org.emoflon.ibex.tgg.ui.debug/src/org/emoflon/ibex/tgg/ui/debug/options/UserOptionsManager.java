package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean isInvalid = false;

    private boolean displayFullRuleForMatches = false;
    private final Op op;

    public UserOptionsManager(Op pOp) {
	op = pOp;
    }

    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    public Op getOp() {
	return op;
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
