package org.emoflon.ibex.gt.editor.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class GTLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
}
