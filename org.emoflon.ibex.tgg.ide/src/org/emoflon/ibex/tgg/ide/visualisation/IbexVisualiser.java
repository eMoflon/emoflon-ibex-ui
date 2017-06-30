package org.emoflon.ibex.tgg.ide.visualisation;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.emoflon.ibex.tgg.ide.visualisation.IbexPlantUMLGenerator;
import org.moflon.util.IbexUtil;

import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;

public abstract class IbexVisualiser implements DiagramTextProvider {

	private static final String PLANTUML_EXTENSON_ID = "net.sourceforge.plantuml.eclipse.diagramTextProvider";
	private static final String PLANTUML_EXTENSION_PROPERTY = "providerClass";

	@Override
	public String getDiagramText(IEditorPart editor, ISelection selection){
		return IbexPlantUMLGenerator.wrapInTags(getDiagramBody(editor, selection));
	}
	
	abstract protected String getDiagramBody(IEditorPart editor, ISelection selection);

	protected <T> Function<Object, Optional<T>> maybeCast(Class<T> type){
		return (input) -> {
			if(type.isInstance(input)){
				return Optional.of(type.cast(input));
			} else {
				return Optional.empty();
			}
		};
	}
	
	@Override
	public boolean supportsSelection(ISelection selection) {
		return true;
	}
	
	protected boolean noOtherVisualisationRegisteredForSelection(IEditorPart editor, ISelection selection, Class<?> vis){
		Collection<DiagramTextProvider> extensions = IbexUtil.collectExtensions(PLANTUML_EXTENSON_ID, PLANTUML_EXTENSION_PROPERTY, DiagramTextProvider.class);
		return extensions.stream()
				.filter(e -> !vis.isInstance(e))
				.noneMatch(e -> e.supportsEditor(editor) && e.supportsSelection(selection));
	}
}
