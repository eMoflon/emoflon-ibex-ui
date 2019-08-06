package org.emoflon.ibex.tgg.ui.debug.options;

public class UserOptionsManager implements IUserOptions {

    private boolean isInvalid = false;

    private boolean displayFullRuleForMatches = false;

    private boolean displaySrcContextForMatches = true;
    private boolean displayTrgContextForMatches = true;
    private boolean displayCorrContextForMatches = true;

    private final IBeXOp op;
    private VisualizationLabelOptions corrLabelVisualization = VisualizationLabelOptions.ABBREVIATED;
    private VisualizationLabelOptions edgeLabelVisualization = VisualizationLabelOptions.ABBREVIATED;
    private VisualizationLabelOptions nodeLabelVisualization = VisualizationLabelOptions.ABBREVIATED;
    private int neighborhoodSize = 0;

    public UserOptionsManager(IBeXOp pOp) {
	op = pOp;
    }

    @Override
    public boolean displayFullRuleForMatches() {
	return displayFullRuleForMatches;
    }

    @Override
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
    @Override
    public VisualizationLabelOptions getCorrLabelVisualization() {
	return corrLabelVisualization;
    }

    /**
     * @param corrLabelVisualization the visualization option for correspondence
     *                               labels
     */
    public void setCorrLabelVisualization(VisualizationLabelOptions corrLabelVisualization) {
	if (this.corrLabelVisualization != corrLabelVisualization) {
	    this.corrLabelVisualization = corrLabelVisualization;
	    isInvalid = true;
	}
    }

    /**
     * @return the visualization option for edge labels
     */
    @Override
    public VisualizationLabelOptions getEdgeLabelVisualization() {
	return edgeLabelVisualization;
    }

    /**
     * @param nodeLabelVisualization the visualization option for node labels
     */
    public void setEdgeLabelVisualization(VisualizationLabelOptions edgeLabelVisualization) {
	if (this.edgeLabelVisualization != edgeLabelVisualization) {
	    this.edgeLabelVisualization = edgeLabelVisualization;
	    isInvalid = true;
	}
    }

    /**
     * @return the visualization option for node labels
     */
    @Override
    public VisualizationLabelOptions getNodeLabelVisualization() {
	return nodeLabelVisualization;
    }

    /**
     * @param nodeLabelVisualization the visualization option for node labels
     */
    public void setNodeLabelVisualization(VisualizationLabelOptions nodeLabelVisualization) {
	if (this.nodeLabelVisualization != nodeLabelVisualization) {
	    this.nodeLabelVisualization = nodeLabelVisualization;
	    isInvalid = true;
	}
    }

    /**
     * @return the displaySrcContextForMatches
     */
    @Override
    public boolean displaySrcContextForMatches() {
	return displaySrcContextForMatches;
    }

    /**
     * @param displaySrcContextForMatches the displaySrcContextForMatches to set
     */
    public void setDisplaySrcContextForMatches(boolean displaySrcContextForMatches) {
	if (this.displaySrcContextForMatches != displaySrcContextForMatches) {
	    this.displaySrcContextForMatches = displaySrcContextForMatches;
	    this.isInvalid = true;
	}
    }

    /**
     * @return the displayTrgContextForMatches
     */
    @Override
    public boolean displayTrgContextForMatches() {
	return displayTrgContextForMatches;
    }

    /**
     * @param displayTrgContextForMatches the displayTrgContextForMatches to set
     */
    public void setDisplayTrgContextForMatches(boolean displayTrgContextForMatches) {
	if (this.displayTrgContextForMatches != displayTrgContextForMatches) {
	    this.displayTrgContextForMatches = displayTrgContextForMatches;
	    isInvalid = true;
	}
    }

    /**
     * @return the displayTrgContextForMatches
     */
    @Override
    public boolean displayCorrContextForMatches() {
	return displayCorrContextForMatches;
    }

    /**
     * @param displayTrgContextForMatches the displayTrgContextForMatches to set
     */
    public void setDisplayCorrContextForMatches(boolean displayCorrContextForMatches) {
	if (this.displayCorrContextForMatches != displayCorrContextForMatches) {
	    this.displayCorrContextForMatches = displayCorrContextForMatches;
	    isInvalid = true;
	}
    }

    public enum VisualizationLabelOptions {
	FULLNAME, ABBREVIATED, NONE
    }

    public int getNeighborhoodSize() {
	return neighborhoodSize;
    }

    public void setNeighborhoodSize(int pSize) {
	if (neighborhoodSize != pSize) {
	    neighborhoodSize = pSize;
	    isInvalid = true;
	}
    }
}
