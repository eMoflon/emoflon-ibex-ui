/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class GTLStandaloneSetup extends GTLStandaloneSetupGenerated {

	public static void doSetup() {
		new GTLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
