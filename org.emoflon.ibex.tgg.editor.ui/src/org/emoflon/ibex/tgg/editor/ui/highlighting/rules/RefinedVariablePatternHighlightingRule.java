package org.emoflon.ibex.tgg.editor.ui.highlighting.rules;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.emoflon.ibex.tgg.editor.tgg.Operator;
import org.emoflon.ibex.tgg.editor.ui.highlighting.utils.TGGEditorColor;

public class RefinedVariablePatternHighlightingRule extends AbstractRefinedVariablePatternHighlightingRule {

	public RefinedVariablePatternHighlightingRule() {
		super("RefinedPattern", "Refined Pattern", 100);
	}

	@Override
	protected TextStyle getTextStyle() {
	      TextStyle ts = new TextStyle();
	      ts.setColor(TGGEditorColor.BLACK.getColor());
	      ts.setStyle(SWT.BOLD);
	      return ts;
	}

	@Override
	public boolean getOperatorCondition(Operator op) {
		return op == null || op.getValue() == null || "".equals(op.getValue());
	}





}
