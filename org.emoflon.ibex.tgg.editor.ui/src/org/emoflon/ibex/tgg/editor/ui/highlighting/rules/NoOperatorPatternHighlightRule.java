package org.emoflon.ibex.tgg.editor.ui.highlighting.rules;

import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.emoflon.ibex.tgg.editor.tgg.Operator;
import org.emoflon.ibex.tgg.editor.ui.highlighting.utils.TGGEditorColor;

public class NoOperatorPatternHighlightRule extends AbstractOperatorPatternHighlightRule {

	public NoOperatorPatternHighlightRule() {
		super("NoOperator", "If no operator exist");
	}

	@Override
	public boolean getOperatorCondition(Operator op) {
		return  op== null || op.getValue() == null || op.getValue().equals("");
	}

	@Override
	protected TextStyle getTextStyle() {
	      TextStyle ts = new TextStyle();
	      ts.setColor(TGGEditorColor.BLACK.getColor());
	      return ts;
	}



}
