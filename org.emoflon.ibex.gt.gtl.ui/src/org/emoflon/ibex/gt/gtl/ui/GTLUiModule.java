/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.emoflon.ibex.common.slimgt.ide.highlighting.SlimGTSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class GTLUiModule extends AbstractGTLUiModule {

	public GTLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator () {
		return SlimGTSemanticHighlightingCalculator.class;
	}
}
