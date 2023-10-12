package org.emoflon.ibex.common.visualization.tgg;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGModel;
import org.emoflon.ibex.tgg.tggmodel.IBeXTGGModel.TGGRule;
import org.moflon.core.ui.VisualiserUtilities;
import org.moflon.core.ui.visualisation.common.EMoflonDiagramTextProvider;

public class IBeXTggXmiVisualizer implements EMoflonDiagramTextProvider {

	@Override
	public String getDiagramBody(IEditorPart editor, ISelection selection) {
		if (selection instanceof IStructuredSelection structuredSelection)
			return visualizeSelection(structuredSelection);

		throw new IllegalArgumentException("Invalid selection: " + selection);
	}

	@SuppressWarnings("unchecked")
	private String visualizeSelection(IStructuredSelection selection) {
		Object element = selection.getFirstElement();
		if (element instanceof TGGModel tgg)
			return IBeXTggXmiPlantUMLGenerator.visualizeTGG(tgg);
		if (element instanceof TGGRule tggRule)
			return IBeXTggXmiPlantUMLGenerator.visualizeTGGRule(tggRule);
//		if (element instanceof EditorFile ef) {
//		if (element instanceof org.emoflon.ibex.tgg.tggl.tGGL.TGGRule rule) {
//			TGGLModelFlattener flattener = new TGGLModelFlattener();
//			flattener.flattenTGGRule(rule);
//		}
		// TODO larsF, adrianM: fix this to visualize sc rules again
//				if (element instanceof ExternalShortcutRule extShortcutRule)
//			return IBeXTggXmiPlantUMLGenerator.visualizeSCRuleMerged(extShortcutRule);
//		if (element instanceof TGGRuleElementMapping ruleEltMapping) {
//			if (selection.size() <= 1)
//				return IBeXTggXmiPlantUMLGenerator.visualizeMapping(ruleEltMapping);
//			else if (selection.toList().stream().allMatch(e -> e instanceof TGGRuleElementMapping))
//				return IBeXTggXmiPlantUMLGenerator.visualizeMappings(selection.toList());
//		}

		throw new IllegalArgumentException("Invalid selection: " + selection);
	}

	@Override
	public boolean supportsSelection(ISelection selection) {
		Collection<EObject> elements = VisualiserUtilities.extractEcoreSelection(selection);
		if (elements == null)
			return false;

		for(var element : elements) {
			if(isPartOfTGGLanguage(element))
				return true;
		}
		return false;
	}

	private boolean isPartOfTGGLanguage(EObject element) {
		String packageName = element.eClass().getEPackage().getName();
		return packageName.contains("IBeXTGGModel") || packageName.contains("repair");
	}

	@Override
	public boolean supportsEditor(final IEditorPart editor) {
		return Optional.of(editor) //
				.flatMap(maybeCast(EcoreEditor.class)) //
				.map(EcoreEditor::getSelection) //
				.flatMap(maybeCast(TreeSelection.class)) //
				.map(TreeSelection::getFirstElement) //
				.filter(elt -> elt instanceof TGGModel || elt instanceof TGGRule
//						TODO larsF, adrianM: and this
//						|| elt instanceof ExternalShortcutRule
//						|| elt instanceof TGGRuleElementMapping
						) //
				.isPresent();
	}

}