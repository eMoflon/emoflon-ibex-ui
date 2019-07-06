package org.emoflon.ibex.tgg.ui.debug.options;

import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager.VisualizationLabelOptions;

public interface IUserOptions {

	public boolean displayFullRuleForMatches();

	public IBeXOp getOp();

	/**
	 * @return the visualization option for correspondence labels
	 */
	public VisualizationLabelOptions getCorrLabelVisualization();

	/**
	 * @param corrLabelVisualization the visualization option for correspondence
	 *                               labels
	 */
	public void setCorrLabelVisualization(VisualizationLabelOptions corrLabelVisualization);
}
