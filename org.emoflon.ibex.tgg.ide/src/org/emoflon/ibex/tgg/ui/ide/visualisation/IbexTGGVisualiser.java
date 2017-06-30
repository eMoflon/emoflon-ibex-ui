package org.emoflon.ibex.tgg.ui.ide.visualisation;

import java.util.Optional;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.tgg.ui.ide.transformation.EditorTGGtoFlattenedTGG;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

public class IbexTGGVisualiser extends IbexVisualiser {
	
	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		return maybeVisualiseTGGRule(editor, selection).orElse(
			   IbexPlantUMLGenerator.emptyDiagram());
	}
	
	private Optional<String> maybeVisualiseTGGRule(IEditorPart editor, ISelection selection) {
		return extractTGGFileFromEditor(editor)
				.map(file -> file.getSchema() == null? file : null)
				.map(this::flatten)
				.map(IbexPlantUMLGenerator::visualiseTGGFile);
	}

	private TripleGraphGrammarFile flatten(TripleGraphGrammarFile file) {
		return new EditorTGGtoFlattenedTGG().flatten(file);
	}
	
	@Override
	public boolean supportsEditor(IEditorPart editor) {
		return extractTGGFileFromEditor(editor).isPresent();
	}

	private Optional<TripleGraphGrammarFile> extractTGGFileFromEditor(IEditorPart editor) {
		return Optional.of(editor)
				.flatMap(maybeCast(XtextEditor.class))
				.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
				.flatMap(maybeCast(TripleGraphGrammarFile.class));
	}
}
