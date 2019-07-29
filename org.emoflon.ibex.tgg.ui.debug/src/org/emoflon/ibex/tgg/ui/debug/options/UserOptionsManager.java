package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean isInvalid = false;

    private boolean displayFullRuleForMatches = false;
    private final IBeXOp op;

    private VisualizationLabelOptions corrLabelVisualization = VisualizationLabelOptions.ABBREVIATED;

    public UserOptionsManager(IBeXOp pOp) {
	op = pOp;
    }

    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    public IBeXOp getOp() {
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

    /**
     * @return the visualization option for correspondence labels
     */
    public VisualizationLabelOptions getCorrLabelVisualization() {
	return corrLabelVisualization;
    }

    /**
     * @param corrLabelVisualization
     *            the visualization option for correspondence labels
     */
    public void setCorrLabelVisualization(VisualizationLabelOptions corrLabelVisualization) {
	if (this.corrLabelVisualization != corrLabelVisualization) {
	    this.corrLabelVisualization = corrLabelVisualization;
	    isInvalid = true;
	}
    }

    public enum VisualizationLabelOptions {
	FULLNAME, ABBREVIATED, NONE
    }
}
