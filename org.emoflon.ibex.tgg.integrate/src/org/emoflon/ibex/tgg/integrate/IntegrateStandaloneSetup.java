/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class IntegrateStandaloneSetup extends IntegrateStandaloneSetupGenerated {

	public static void doSetup() {
		new IntegrateStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
