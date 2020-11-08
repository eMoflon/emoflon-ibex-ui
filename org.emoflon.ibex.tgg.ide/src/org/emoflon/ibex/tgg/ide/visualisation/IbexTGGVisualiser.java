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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.tgg.ide.admin.IbexTGGBuilder;
import org.emoflon.ibex.tgg.ide.transformation.EditorTGGtoFlattenedTGG;
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator;
import org.moflon.core.ui.visualisation.common.EMoflonVisualiser;
import org.moflon.core.utilities.MoflonUtil;
import org.moflon.tgg.mosl.tgg.Nac;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

public class IbexTGGVisualiser extends EMoflonVisualiser {

	private Logger logger = Logger.getLogger(IbexTGGVisualiser.class);

	private Optional<String> lastDiagramBody = Optional.empty();

	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		try {
			String body = maybeVisualiseTGGRule(editor, selection) //
					.orElse(maybeVisualiseTGGSchema(editor, selection)//
							.orElse(defaultDiagramBody()));
			lastDiagramBody = Optional.of(body);
		} catch (Exception e) {
			logger.warn("Unable to visualise current state in editor, reverting to last diagram if available.");
		}

		return defaultDiagramBody();
	}

	private String defaultDiagramBody() {
		return lastDiagramBody.orElse(EMoflonPlantUMLGenerator.errorDiagram());
	}

	private Optional<String> maybeVisualiseTGGSchema(IEditorPart editor, ISelection selection) {
		try {
			return extractTGGFileFromEditor(editor) //
					.filter(file -> file.getSchema() != null) //
					.map(file -> file.eResource().getURI().segment(1)) //
					.map(projectName -> IbexPlantUMLGenerator.visualiseTGGRuleOverview(projectName,
							loadTGG(projectName)));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	private TripleGraphGrammarFile loadTGG(String projectName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource tgg = rs.getResource(URI.createPlatformResourceURI(projectName + "/" + IbexTGGBuilder.MODEL_FOLDER
				+ "/" + MoflonUtil.lastCapitalizedSegmentOf(projectName) + IbexTGGBuilder.EDITOR_MODEL_EXTENSION, true),
				true);
		return (TripleGraphGrammarFile) tgg.getContents().get(0);
	}

	private Optional<String> maybeVisualiseTGGRule(IEditorPart editor, ISelection selection) {
		return extractTGGFileFromEditor(editor) //
				.map(file -> file.getSchema() == null ? file : null) //
				.map(file -> {
					try {
						return visualise(file, selection);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				});
	}

	public String visualise(TripleGraphGrammarFile file, ISelection selection) throws Exception {
		Optional<TripleGraphGrammarFile> flattenedOptional = flatten(file);
		if (!flattenedOptional.isPresent()) {
			logger.debug("Unable to visualise " + selection);
			return null;
		}
		TripleGraphGrammarFile flattened = flattenedOptional.get();

		// If there's only one TGG rule, then visualize this.
		if (flattened.getRules().size() == 1)
			return IbexPlantUMLGenerator.visualiseTGGRule(flattened.getRules().get(0));

		// Otherwise visualize what the user has selected in the TGG editor.
		return visualizeSelection(file, flattened, selection);
	}

	private String visualizeSelection(TripleGraphGrammarFile file, TripleGraphGrammarFile flattened,
			ISelection selection) throws Exception {
		if (selection instanceof TextSelection) {
			TextSelection textSelection = (TextSelection) selection;
			int selectionStart = textSelection.getStartLine() + 1;
			int selectionEnd = textSelection.getEndLine() + 1;

			for (final Rule rule : file.getRules()) {
				ICompositeNode object = NodeModelUtils.getNode(rule);
				if (selectionStart >= object.getStartLine() && selectionEnd <= object.getEndLine()) {
					return IbexPlantUMLGenerator.visualiseTGGRule(flattenedRuleIfPossible(rule, flattened));
				}
			}

			String text = textSelection.getText();
			if (text != null && !text.isEmpty()) {
				return IbexPlantUMLGenerator.visualiseTGGFile(flattened, text);
			}
		}

		return IbexPlantUMLGenerator.visualiseTGGRuleOverview(file.eResource().getURI().segment(1), file);
	}

	private Rule flattenedRuleIfPossible(Rule rule, TripleGraphGrammarFile flattened) {
		return flattened.getRules()//
				.stream()//
				.filter(r -> r.getName().equals(rule.getName()))//
				.findAny()//
				.orElse(rule);
	}

	private Optional<TripleGraphGrammarFile> flatten(TripleGraphGrammarFile file) throws Exception {
		return new EditorTGGtoFlattenedTGG().flatten(file);
	}

	@Override
	public boolean supportsEditor(IEditorPart editor) {
		return extractTGGFileFromEditor(editor).isPresent();
	}

	private Optional<TripleGraphGrammarFile> extractTGGFileFromEditor(IEditorPart editor) {
		try {
			return Optional.of(editor) //
					.flatMap(maybeCast(XtextEditor.class)) //
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.flatMap(maybeCast(TripleGraphGrammarFile.class));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
