package org.emoflon.ibex.tgg.editor.ui.highlighting.rules;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.emoflon.ibex.tgg.editor.tgg.Operator;
import org.emoflon.ibex.tgg.editor.ui.highlighting.utils.TGGEditorColor;

public class CreatedAndRefinedVariablePatternHighlightingRule extends AbstractRefinedVariablePatternHighlightingRule {

	public CreatedAndRefinedVariablePatternHighlightingRule() {
		super("CreatedAndRefined", "Created and Refined VariablePattern", 150);
	}

	@Override
	public boolean getOperatorCondition(Operator op) {
		return op!= null && op.getValue() != null && op.getValue().contains("++");
	}

	@Override
	protected TextStyle getTextStyle() {
	      TextStyle ts = new TextStyle();
	      ts.setColor(TGGEditorColor.DARK_GREEN.getColor());
	      ts.setStyle(SWT.BOLD);
	      return ts;
	}

}
