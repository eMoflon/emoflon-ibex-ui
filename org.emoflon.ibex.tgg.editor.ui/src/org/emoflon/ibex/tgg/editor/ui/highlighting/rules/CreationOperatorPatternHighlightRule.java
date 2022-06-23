package org.emoflon.ibex.tgg.editor.ui.highlighting.rules;

import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.emoflon.ibex.tgg.editor.tgg.Operator;
import org.emoflon.ibex.tgg.editor.ui.highlighting.utils.TGGEditorColor;

public class CreationOperatorPatternHighlightRule extends AbstractOperatorPatternHighlightRule {

	public CreationOperatorPatternHighlightRule() {
		super("CreatePattern", "Create-Operator");
	}

	@Override
	public boolean getOperatorCondition(Operator op) {
		return op!= null && op.getValue() != null && op.getValue().contains("++");
	}

	@Override
	protected TextStyle getTextStyle() {
	      TextStyle ts = new TextStyle();
	      ts.setColor(TGGEditorColor.DARK_GREEN.getColor());
	      return ts;
	}

}
