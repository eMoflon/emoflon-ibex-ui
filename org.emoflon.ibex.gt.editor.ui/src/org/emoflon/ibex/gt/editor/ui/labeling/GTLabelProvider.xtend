package org.emoflon.ibex.gt.editor.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.utils.GTFlattener
import org.emoflon.ibex.gt.editor.ui.visualization.GTVisualizationUtils

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html
 */
class GTLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	override getText(Object element) {
		if (element instanceof EditorPattern) {
			val flattenedPattern = new GTFlattener(element).flattenedPattern
			return '''«element.type.toString» «element.name»«GTVisualizationUtils.signature(flattenedPattern)»'''
		}

		return super.getText(element)
	}
}
