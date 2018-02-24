package org.emoflon.ibex.gt.editor

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class GTStandaloneSetup extends GTStandaloneSetupGenerated {

	def static void doSetup() {
		new GTStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
