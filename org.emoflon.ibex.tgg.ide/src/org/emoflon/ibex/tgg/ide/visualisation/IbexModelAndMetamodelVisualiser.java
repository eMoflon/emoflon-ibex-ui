package org.emoflon.ibex.tgg.ide.visualisation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.emoflon.ibex.tgg.ide.visualisation.IbexPlantUMLGenerator;

public class IbexModelAndMetamodelVisualiser extends IbexVisualiser {

	private IEditorPart editor;

	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		return maybeVisualiseMetamodel(editor).orElse(
			   maybeVisualiseModel(editor).orElse(
			   IbexPlantUMLGenerator.emptyDiagram()));
	}

	@SuppressWarnings("rawtypes")
	private Optional<List> multiSelectionInEcoreEditor(IEditorPart editor){
		return Optional.of(editor)
				.flatMap(maybeCast(EcoreEditor.class))
				.map(EcoreEditor::getSelection)
				.flatMap(maybeCast(IStructuredSelection.class))
				.map(IStructuredSelection::toList);
	}
	
	private Optional<String> maybeVisualiseMetamodel(IEditorPart editor) {
		return extractMetamodelElementsFromEditor(editor)
				.map(p -> IbexPlantUMLGenerator.visualiseEcoreElements(p.getLeft(), p.getRight()));
	}
	
	private Optional<String> maybeVisualiseModel(IEditorPart editor) {
		return  extractModelElementsFromEditor(editor)
				.map(p -> IbexPlantUMLGenerator.visualiseModelElements(p.getLeft(), p.getRight()));
	}
	
	private Optional<Pair<Collection<EObject>, Collection<Pair<String, Pair<EObject, EObject>>>>>
	extractModelElementsFromEditor(IEditorPart editor2) {
		return Optional.of(editor)
				.flatMap(this::multiSelectionInEcoreEditor)
				.map(this::determineObjectsAndLinksToVisualise)
				.map(p -> p.getLeft().isEmpty()? null : p);
	}

	private Optional<Pair<Collection<EClass>, Collection<EReference>>> 
	extractMetamodelElementsFromEditor(IEditorPart editor) {
		return Optional.of(editor)
				.flatMap(this::multiSelectionInEcoreEditor)
				.map(this::determineClassesAndRefsToVisualise)
				.map(p -> p.getLeft().isEmpty()? null : p);
	}

	private Pair<Collection<EClass>, Collection<EReference>> determineClassesAndRefsToVisualise(Collection<Object> selection){
		Collection<EClass> chosenClasses = selection
				.stream()
				.filter(EClass.class::isInstance)
				.map(EClass.class::cast)
				.collect(Collectors.toSet());
		
		Collection<EReference> refs = chosenClasses
				.stream()
				.flatMap(c -> c.getEReferences().stream())
				.collect(Collectors.toSet());
		
		return Pair.of(chosenClasses, refs);
	}
	
	@SuppressWarnings("rawtypes")
	private Pair<Collection<EObject>, Collection<Pair<String, Pair<EObject, EObject>>>> 
	determineObjectsAndLinksToVisualise(Collection<Object> selection){
		Collection<EObject> chosenObjects = selection
				.stream()
				.filter(EObject.class::isInstance)
				.map(EObject.class::cast)
				.collect(Collectors.toSet());
		
		Collection<Pair<String, Pair<EObject, EObject>>> refs = new HashSet<>();
		for (EObject o : new ArrayList<EObject>(chosenObjects)) {
			for (EContentsEList.FeatureIterator featureIterator = (EContentsEList.FeatureIterator) o.eCrossReferences().iterator(); featureIterator.hasNext();) {
				EObject eObject = (EObject) featureIterator.next();
				EReference eReference = (EReference) featureIterator.feature();
				if(chosenObjects.contains(eObject))
					refs.add(Pair.of(eReference.getName(), Pair.of(o, eObject)));
			}
			for (EContentsEList.FeatureIterator featureIterator = (EContentsEList.FeatureIterator) o.eContents().iterator(); featureIterator.hasNext();) {
				EObject eObject = (EObject) featureIterator.next();
				EReference eReference = (EReference) featureIterator.feature();
				if(chosenObjects.contains(eObject))
					refs.add(Pair.of(eReference.getName(), Pair.of(o, eObject)));
			}
		}
		
		return Pair.of(chosenObjects, refs);
	}
	
	@Override
	public boolean supportsEditor(IEditorPart editor) {
		this.editor = editor;
		return extractMetamodelElementsFromEditor(editor).isPresent() || 
				extractModelElementsFromEditor(editor).isPresent();
	}
	
	@Override
	public boolean supportsSelection(ISelection selection) {
		return noOtherVisualisationRegisteredForSelection(editor, selection, IbexModelAndMetamodelVisualiser.class);
	}
}
