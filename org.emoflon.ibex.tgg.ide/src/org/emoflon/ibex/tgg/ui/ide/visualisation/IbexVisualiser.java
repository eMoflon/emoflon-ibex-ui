package org.emoflon.ibex.tgg.ui.ide.visualisation;

import java.util.Optional;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.moflon.util.LogUtils;

import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;

public abstract class IbexVisualiser implements DiagramTextProvider {

	private static final String PLANTUML_EXTENSON_ID = "net.sourceforge.plantuml.eclipse.diagramTextProvider";
	private static final String PLANTUML_EXTENSION_PROPERTY = "providerClass";
	private Logger logger = Logger.getLogger(IbexVisualiser.class);

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
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(PLANTUML_EXTENSON_ID);
		
		try {
            for (IConfigurationElement e : config) {
                final Object o = e.createExecutableExtension(PLANTUML_EXTENSION_PROPERTY);
                if (o instanceof DiagramTextProvider && !vis.isInstance(o)) {
                    DiagramTextProvider dtp = (DiagramTextProvider)o;
                    if(dtp.supportsEditor(editor) && dtp.supportsSelection(selection)){
                    	return false;
                    }
                }
            }
        } catch (CoreException ex) {
            LogUtils.error(logger, ex);
        }
        
        // No registered vis can handle this case
        return true;
	}
}
