package org.emoflon.ibex.tgg.ide.visualisation;

import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.tgg.ide.admin.IbexTGGBuilder;
import org.emoflon.ibex.tgg.ide.transformation.EditorTGGtoFlattenedTGG;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

public class IbexTGGVisualiser extends IbexVisualiser {
	
	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		return maybeVisualiseTGGRule(editor, selection)   .orElse(
			   maybeVisualiseTGGSchema(editor, selection) .orElse(
			   IbexPlantUMLGenerator.emptyDiagram()))     ;
	}
	
	private Optional<String> maybeVisualiseTGGSchema(IEditorPart editor, ISelection selection) {
		return extractTGGFileFromEditor(editor)
				.filter(file -> file.getSchema() != null)
				.map(file -> file.eResource().getURI().segment(1))
				.map(projectName -> IbexPlantUMLGenerator.visualiseTGGRuleOverview(projectName, loadTGG(projectName)));
	}

	private TripleGraphGrammarFile loadTGG(String projectName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource tgg = rs.getResource(URI.createPlatformResourceURI(projectName + "/" + 
				IbexTGGBuilder.MODEL_FOLDER + "/" + projectName + 
				IbexTGGBuilder.EDITOR_MODEL_EXTENSION, true), true);
		return (TripleGraphGrammarFile) tgg.getContents().get(0);
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
