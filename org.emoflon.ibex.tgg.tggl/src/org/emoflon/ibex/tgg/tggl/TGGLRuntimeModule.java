/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl;

import org.eclipse.xtext.validation.IResourceValidator;
import org.emoflon.ibex.tgg.tggl.validation.TGGLResourceValidator;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class TGGLRuntimeModule extends AbstractTGGLRuntimeModule {

	@Override
	public void configure(Binder binder) {
		binder.bind(IResourceValidator.class).to(TGGLResourceValidator.class);
		super.configure(binder);
	}
	
}
