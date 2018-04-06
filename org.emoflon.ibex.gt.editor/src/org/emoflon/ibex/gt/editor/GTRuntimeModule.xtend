package org.emoflon.ibex.gt.editor

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider
import org.emoflon.ibex.gt.editor.scoping.GTLinkingDiagnosticMessageProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class GTRuntimeModule extends AbstractGTRuntimeModule {

	def Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return GTLinkingDiagnosticMessageProvider
	}
}
