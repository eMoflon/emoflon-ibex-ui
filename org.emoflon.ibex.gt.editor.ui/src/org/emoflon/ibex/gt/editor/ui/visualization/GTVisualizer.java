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
	protected String getDiagramBody(final IEditorPart editor, final ISelection selection) {
		Optional<GraphTransformationFile> file = this.loadFileFromEditor(editor);
		if (!file.isPresent()) {
			return EMoflonPlantUMLGenerator.emptyDiagram();
		}

		EList<Rule> rules = file.get().getRules();
		if (rules.size() == 0) {
			return GTPlantUMLGenerator.visualizeNothing();
		}
		if (rules.size() == 1) {
			return GTPlantUMLGenerator.visualizeRule(rules.get(0));
		}
		Optional<Rule> rule = determineSelectedRule(selection, rules);
		if (rule.isPresent()) {
			return GTPlantUMLGenerator.visualizeRule(rule.get());
		} else {
			return GTPlantUMLGenerator.visualizeRuleHierarchy(rules);
		}
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
	private static Optional<Rule> determineSelectedRule(final ISelection selection, final EList<Rule> rules) {
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
					.flatMap(maybeCast(XtextEditor.class))
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.flatMap(maybeCast(GraphTransformationFile.class));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
