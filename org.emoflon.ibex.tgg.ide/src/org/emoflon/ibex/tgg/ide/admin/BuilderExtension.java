package org.emoflon.ibex.tgg.ide.admin;

import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

public interface BuilderExtension {
	public void run(IbexTGGBuilder builder, TripleGraphGrammarFile editorModel, TripleGraphGrammarFile flattenedEditorModel);
}
