package org.emoflon.ibex.common.visualization.tgg;

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
import org.emoflon.ibex.tgg.compiler.defaults.TGGBuildUtil;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.util.TGGLModelFlattener;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGModel;
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator;
import org.moflon.core.ui.visualisation.common.EMoflonDiagramTextProvider;
import org.moflon.core.utilities.MoflonUtil;
import org.eclipse.emf.ecore.EObject;

public class IbexTGGVisualiser implements EMoflonDiagramTextProvider {

	private Logger logger = Logger.getLogger(IbexTGGVisualiser.class);

	private Optional<String> lastDiagramBody = Optional.empty();

	@Override
	public String getDiagramBody(IEditorPart editor, ISelection selection) {
		try {
			String body = maybeVisualiseTGGRule(editor, selection) //
//					.orElse(maybeVisualiseTGGSchema(editor, selection)//
							.orElse(defaultDiagramBody());
			lastDiagramBody = Optional.of(body);
		} catch (Exception e) {
			logger.warn("Unable to visualise current state in editor, reverting to last diagram if available.");
		}

		return defaultDiagramBody();
	}

	private String defaultDiagramBody() {
		return lastDiagramBody.orElse(EMoflonPlantUMLGenerator.errorDiagram());
	}

//	private Optional<String> maybeVisualiseTGGSchema(IEditorPart editor, ISelection selection) {
//		try {
//			return extractTGGFileFromEditor(editor) //
//					.filter(file -> file.getSchema() != null) //
//					.map(file -> ((EObject) file).eResource().getURI().segment(1)) //
//					.map(projectName -> IbexPlantUMLGenerator.visualiseTGGRuleOverview(projectName,	loadTGG(projectName)));
//		} catch (Exception e) {
//			return Optional.empty();
//		}
//	}

	private TGGModel loadTGG(String projectName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource tgg = rs.getResource(URI.createPlatformResourceURI(projectName + "/" + TGGBuildUtil.MODEL_FOLDER
				+ "/" + MoflonUtil.lastCapitalizedSegmentOf(projectName) + TGGBuildUtil.INTERNAL_TGG_MODEL_EXTENSION, true),
				true);
		return (TGGModel) tgg.getContents().get(0);
	}

	private Optional<String> maybeVisualiseTGGRule(IEditorPart editor, ISelection selection) {
		return extractTGGFileFromEditor(editor) //
				.map(file -> file.getSchema() == null ? file : null) //
				.map(file -> ((EObject) file).eResource().getURI().segment(1)) //
				.map(projectName -> {
					try {
						return visualizeSelection(loadTGG(projectName), extractTGGFileFromEditor(editor).get(), selection);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				});
	}

	private String visualizeSelection(TGGModel model, EditorFile file, ISelection selection) throws Exception {
		if (selection instanceof TextSelection) {
			TextSelection textSelection = (TextSelection) selection;
			int selectionStart = textSelection.getStartLine() + 1;
			int selectionEnd = textSelection.getEndLine() + 1;

			for (final var rule : file.getRules()) {
				ICompositeNode object = NodeModelUtils.getNode(rule);
				if (selectionStart >= object.getStartLine() && selectionEnd <= object.getEndLine()) {
					for(var tggRule : model.getRuleSet().getRules()) {
						if(tggRule.getName().equals(rule.getName()))
							return IBeXTggXmiPlantUMLGenerator.visualizeTGGRule(tggRule);
					}
				}
			}

			String text = textSelection.getText();
//			if (text != null && !text.isEmpty()) {
//				return IbexPlantUMLGenerator.visualiseTGGFile(flattened, text);
//			}
		}

//		return null;
		return IBeXTggXmiPlantUMLGenerator.visualizeTGG(model);
	}

//	private Rule flattenedRuleIfPossible(Rule rule, TripleGraphGrammarFile flattened) {
//		return flattened.getRules()//
//				.stream()//
//				.filter(r -> r.getName().equals(rule.getName()))//
//				.findAny()//
//				.orElse(rule);
//	}

//	private Optional<EditorFile> flatten(EditorFile file) throws Exception {
//		return new TGGLModelFlattener().flatten(file);
//	}

	@Override
	public boolean supportsEditor(IEditorPart editor) {
		return extractTGGFileFromEditor(editor).isPresent();
	}
	
	@Override
	public boolean supportsSelection(ISelection selection) {
		//Note: If the editor is detected correctly, this must be true anyways!
		return true;
	}

	private Optional<EditorFile> extractTGGFileFromEditor(IEditorPart editor) {
		try {
			return Optional.of(editor) //
					.flatMap(maybeCast(XtextEditor.class)) //
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.flatMap(maybeCast(EditorFile.class));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
