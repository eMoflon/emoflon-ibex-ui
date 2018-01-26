package org.emoflon.ibex.tgg.ide.visualisation;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.tgg.ide.admin.IbexTGGBuilder;
import org.emoflon.ibex.tgg.ide.transformation.EditorTGGtoFlattenedTGG;
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator;
import org.moflon.core.ui.visualisation.EMoflonVisualiser;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

public class IbexTGGVisualiser extends EMoflonVisualiser {
	
	private Logger logger = Logger.getLogger(IbexTGGVisualiser.class);
	
	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		return maybeVisualiseTGGRule(editor, selection)   .orElse(
			   maybeVisualiseTGGSchema(editor, selection) .orElse(
			   EMoflonPlantUMLGenerator.emptyDiagram()))     ;
	}
	
	private Optional<String> maybeVisualiseTGGSchema(IEditorPart editor, ISelection selection) {
		try {
			return extractTGGFileFromEditor(editor)
				.filter(file -> file.getSchema() != null)
				.map(file -> file.eResource().getURI().segment(1))
				.map(projectName -> IbexPlantUMLGenerator.visualiseTGGRuleOverview(projectName, loadTGG(projectName)));
		}catch (Exception e) {
			return Optional.empty(); 
		}
	}

	private TripleGraphGrammarFile loadTGG(String projectName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource tgg = rs.getResource(URI.createPlatformResourceURI(projectName + "/" + 
				IbexTGGBuilder.MODEL_FOLDER + "/" + projectName + 
				IbexTGGBuilder.EDITOR_MODEL_EXTENSION, true), true);
		return (TripleGraphGrammarFile) tgg.getContents().get(0);
	}

	private Optional<String> maybeVisualiseTGGRule(IEditorPart editor, ISelection selection) {
		try {
			return extractTGGFileFromEditor(editor)
				.map(file -> file.getSchema() == null? file : null)
				.flatMap(this::flatten)
				.map(flattened -> IbexPlantUMLGenerator.visualiseTGGFile(flattened, determineNameOfChosenRule(flattened, selection)));
		} catch(Exception e) {
			logger.debug("Unable to visualise " + selection);
			return Optional.empty();
		}
	}

	private Optional<String> determineNameOfChosenRule(TripleGraphGrammarFile flattened, ISelection selection) {
		// If there's only one TGG rule in the file then this is the only thing to visualise anyway
		if(flattened.getRules().size() == 1 && flattened.getNacs().size() == 0 && flattened.getComplementRules().size() == 0)
			return Optional.of(flattened.getRules().get(0).getName());
		
		// If there's only one NAC then visualise this
		if(flattened.getRules().size() == 0 && flattened.getNacs().size() == 1 && flattened.getComplementRules().size() == 0)
			return Optional.of(flattened.getNacs().get(0).getName());
		
		// If there's only one complement rule then visualise this
		if(flattened.getRules().size() == 0 && flattened.getNacs().size() == 0 && flattened.getComplementRules().size() == 1)
			return Optional.of(flattened.getComplementRules().get(0).getName());
				
		// If not visualise what the user has selected in the TGG editor
		if(selection instanceof TextSelection){
			TextSelection selectedText = (TextSelection)selection;
			String text = selectedText.getText();
			if(text != null && !text.isEmpty())
			return Optional.of(selectedText.getText());
		}
		
		return Optional.empty();
	}

	private Optional<TripleGraphGrammarFile> flatten(TripleGraphGrammarFile file) {
		return new EditorTGGtoFlattenedTGG().flatten(file);
	}
	
	@Override
	public boolean supportsEditor(IEditorPart editor) {
		return extractTGGFileFromEditor(editor).isPresent();
	}

	private Optional<TripleGraphGrammarFile> extractTGGFileFromEditor(IEditorPart editor) {
		try {
			return Optional.of(editor)
					.flatMap(maybeCast(XtextEditor.class))
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.flatMap(maybeCast(TripleGraphGrammarFile.class));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
