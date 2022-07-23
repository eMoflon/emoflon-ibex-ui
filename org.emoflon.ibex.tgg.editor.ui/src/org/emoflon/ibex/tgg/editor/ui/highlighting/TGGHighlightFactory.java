package org.emoflon.ibex.tgg.editor.ui.highlighting;

import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.CreatedAndRefinedVariablePatternHighlightingRule;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.CreationOperatorPatternHighlightRule;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.DontIgnoreDefaultAndPunctuationHighlightingRule;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.NoOperatorPatternHighlightRule;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.RefinedVariablePatternHighlightingRule;

public class TGGHighlightFactory {

	/**
	 * In this method must all new HighlightingRules be created. If a Rule is not created it will not be
	 * used.
	 */
	public static void createAllInstances() {
		new NoOperatorPatternHighlightRule();
		new CreationOperatorPatternHighlightRule();
		new RefinedVariablePatternHighlightingRule();
		new CreatedAndRefinedVariablePatternHighlightingRule();
		new DontIgnoreDefaultAndPunctuationHighlightingRule();
	}

}
