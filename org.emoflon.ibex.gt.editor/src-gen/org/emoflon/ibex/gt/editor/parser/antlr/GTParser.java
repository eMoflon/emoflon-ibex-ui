/*
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.emoflon.ibex.gt.editor.parser.antlr.internal.InternalGTParser;
import org.emoflon.ibex.gt.editor.services.GTGrammarAccess;

public class GTParser extends AbstractAntlrParser {

	@Inject
	private GTGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalGTParser createParser(XtextTokenStream stream) {
		return new InternalGTParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "EditorGTFile";
	}

	public GTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(GTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}