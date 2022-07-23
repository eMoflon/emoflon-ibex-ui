package org.emoflon.ibex.tgg.editor.ui.highlighting.rules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.emoflon.ibex.tgg.editor.ui.highlighting.TGGHighlightingConfiguration;
import org.emoflon.ibex.tgg.editor.ui.highlighting.TGGTokenMapper;

public class DontIgnoreDefaultAndPunctuationHighlightingRule extends AbstractIgnoreHighlightingRule {

	public DontIgnoreDefaultAndPunctuationHighlightingRule() {
		super("DontIgnoreDefault", "An Ignore Highlighting Rule");
	}

	@Override
	protected boolean getIgnoreConditions(EObject moslObject, INode node) {
		if(node != null && node.getGrammarElement() instanceof Keyword){
			return !isDefaultOrPunctuation(Keyword.class.cast(node.getGrammarElement()));
		}
		return false;
	}

	private boolean isDefaultOrPunctuation(Keyword keyword){
		String id = TGGTokenMapper.getIDFromToken(keyword.getValue());
		return id !=null && (id.equals(TGGHighlightingConfiguration.DEFAULT_ID) || id.equals(TGGHighlightingConfiguration.PUNCTUATION_ID));
	}


}
