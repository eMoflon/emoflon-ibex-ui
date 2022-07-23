/*
 * generated by Xtext 2.26.0
 */
package org.emoflon.ibex.tgg.integrate.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.emoflon.ibex.tgg.integrate.ui.internal.IntegrateActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class IntegrateExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(IntegrateActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		IntegrateActivator activator = IntegrateActivator.getInstance();
		return activator != null ? activator.getInjector(IntegrateActivator.ORG_EMOFLON_IBEX_TGG_INTEGRATE_INTEGRATE) : null;
	}

}
