/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.emoflon.ibex.gt.editor.ui.internal.EditorActivator;

public class GTUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return EditorActivator.getInstance().getInjector("org.emoflon.ibex.gt.editor.GT");
	}

}
