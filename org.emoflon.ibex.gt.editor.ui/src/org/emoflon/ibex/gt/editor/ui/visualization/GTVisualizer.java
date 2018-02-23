package org.emoflon.ibex.gt.editor.ui.visualization;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile;
import org.emoflon.ibex.gt.editor.gT.Rule;
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator;
import org.moflon.core.ui.visualisation.EMoflonVisualiser;

/**
 * The GTVisualizer provides a PlantUML visualization of graph transformation
 * rules.
 */
public class GTVisualizer extends EMoflonVisualiser {

	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		return this.visualize(editor, selection) //
				.orElse(EMoflonPlantUMLGenerator.emptyDiagram());
	}

	/**
	 * Provides a PlantUML visualization for the selected content of the editor.
	 * 
	 * @param editor
	 *            the editor
	 * @param selection
	 *            the current selection
	 * @return an {@link Optional} for the PlantUML code
	 */
	private Optional<String> visualize(final IEditorPart editor, final ISelection selection) {
		Optional<GraphTransformationFile> file = this.loadFileFromEditor(editor);
		if (!file.isPresent()) {
			return Optional.empty();
		}

		EList<Rule> rules = file.get().getRules();
		String visualizationCode = "";
		if (rules.size() == 0) {
			visualizationCode = GTPlantUMLGenerator.visualizeNothing();
		} else if (rules.size() == 1) {
			visualizationCode = GTPlantUMLGenerator.visualizeRule(rules.get(0));
		} else {
			Optional<Rule> rule = this.determineSelectedRule(selection, rules);
			if (rule.isPresent()) {
				visualizationCode = GTPlantUMLGenerator.visualizeRule(rule.get());
			} else {
				visualizationCode = GTPlantUMLGenerator.visualizeRuleHierarchy(rules);
			}
		}
		return Optional.of(visualizationCode);
	}

	/**
	 * Checks whether there is a rule with the name being equal to the current
	 * selected text.
	 * 
	 * @param selection
	 *            the current selection
	 * @param rules
	 *            the rules
	 * @return an {@link Optional} for a {@link Rule}
	 */
	private Optional<Rule> determineSelectedRule(ISelection selection, EList<Rule> rules) {
		if (selection instanceof TextSelection) {
			TextSelection selectedText = (TextSelection) selection;
			String text = selectedText.getText().trim();
			return rules.stream().filter(rule -> rule.getName().equals(text)).findAny();
		}
		return Optional.empty();
	}

	@Override
	public boolean supportsEditor(final IEditorPart editor) {
		return this.loadFileFromEditor(editor).isPresent();
	}

	@Override
	public boolean supportsSelection(final ISelection selection) {
		return true;
	}

	/**
	 * Loads the file from the given editor.
	 * 
	 * @param editor
	 *            the editor
	 * @return an {@link Optional} for the {@link GraphTransformationFile}
	 */
	private Optional<GraphTransformationFile> loadFileFromEditor(final IEditorPart editor) {
		try {
			return Optional.of(editor) //
					.filter(e -> e instanceof XtextEditor).map(e -> (XtextEditor) e)
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.filter(e -> e instanceof GraphTransformationFile).map(e -> (GraphTransformationFile) e);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
