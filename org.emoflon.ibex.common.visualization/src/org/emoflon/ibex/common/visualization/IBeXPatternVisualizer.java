package org.emoflon.ibex.common.visualization;

import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.common.transformation.SlimGtToIBeXCoreTransformer;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.util.GTLModelFlattener;
import org.emoflon.ibex.gt.gtl.util.GTLResourceManager;
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.GTModel;
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.GTPattern;
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.GTRule;
import org.emoflon.ibex.gt.gtmodel.IBeXGTModel.IBeXGTModelFactory;
import org.emoflon.ibex.gt.transformation.GTLtoGTModelTransformer;
import org.moflon.core.ui.visualisation.common.EMoflonDiagramTextProvider;

/**
 * The IBeXPatternVisualizer provides a PlantUML visualization of an
 * IBeXPatternSet or a single pattern.
 */
public class IBeXPatternVisualizer implements EMoflonDiagramTextProvider {

	@Override
	public String getDiagramBody(final IEditorPart editor, final ISelection selection) {
		EditorFile editorFile = maybeCast(XtextEditor.class).apply(editor)
				.map(file -> file.getDocument().readOnly(doc -> doc.getContents().get(0))) //
				.flatMap(maybeCast(EditorFile.class)).get();

		IProject project = maybeCast(XtextEditor.class).apply(editor) //
				.map(file -> file.getResource().getProject()) //
				.get();

		TextSelection textSelection = (TextSelection) selection;
		for (SlimRule rule : editorFile.getRules()) {
			ICompositeNode object = NodeModelUtils.getNode(rule);
			if (object.getStartLine() <= textSelection.getStartLine() + 1
					&& object.getEndLine() >= textSelection.getEndLine() + 1) {
				try {
					return visualizeSelection(project, editorFile, rule);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			return visualizeSelection(project, editorFile, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Visualizes the first selected element
	 * 
	 * @param selection the selection
	 * @return the PlantUMl code for the visualization
	 * @throws Exception
	 */
	private static String visualizeSelection(final IProject project, final EditorFile editorFile,
			final SlimRule selection) throws Exception {
		GTLResourceManager manager = new GTLResourceManager();
		GTLModelFlattener flattener = new GTLModelFlattener(manager, editorFile, true);
		EditorFile flattened = flattener.getFlattenedModel();
		SlimGtToIBeXCoreTransformer<EditorFile, GTModel, IBeXGTModelFactory> transformer = new GTLtoGTModelTransformer(
				flattened, project);
		GTModel model = transformer.transform();

		if (selection != null) {
			Optional<GTRule> candidateRule = model.getRuleSet().getRules().stream()
					.filter(rule -> rule.getName().equals(selection.getName())).findFirst();
			if (candidateRule.isPresent()) {
				return IBeXPatternPlantUMLGenerator.visualizeRule(candidateRule.get());
			}
			Optional<GTPattern> candidatePattern = model.getPatternSet().getPatterns().stream()
					.filter(pattern -> pattern.getName().equals(selection.getName()))
					.map(pattern -> (GTPattern) pattern).findFirst();
			if (candidatePattern.isPresent()) {
				return IBeXPatternPlantUMLGenerator.visualizeContextPattern(candidatePattern.get());
			}
		}
		return IBeXPatternPlantUMLGenerator.visualizePatternInvocations(model.getPatternSet());
	}

	@Override
	public boolean supportsEditor(final IEditorPart editor) {
		return Optional.of(editor) //
				.flatMap(maybeCast(XtextEditor.class)) //
				.map(file -> file.getDocument().readOnly(doc -> doc.getContents().get(0))) //
				.flatMap(maybeCast(EditorFile.class)) //
				.isPresent();
	}

	@Override
	public boolean supportsSelection(ISelection selection) {
		// Note: If the editor is detected correctly, this must be true anyways!
		return true;
	}

}
