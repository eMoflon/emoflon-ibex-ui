package org.emoflon.ibex.tgg.editor.ui.labeling

import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import com.google.inject.Inject

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
class TGGLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

}
