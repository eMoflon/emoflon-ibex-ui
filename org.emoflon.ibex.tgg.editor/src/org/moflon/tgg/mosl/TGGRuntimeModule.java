/*
 * generated by Xtext
 */
package org.moflon.tgg.mosl;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.moflon.tgg.mosl.scoping.TGGScopeProvider;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class TGGRuntimeModule extends org.moflon.tgg.mosl.AbstractTGGRuntimeModule
{

   @Override
   public Class<? extends IScopeProvider> bindIScopeProvider()
   {
      return TGGScopeProvider.class;
   }

   @Override
   public void configure(final Binder binder)
   {
      super.configure(binder);
   }

   // Temporarily solution issue #781 (EObjectValidator has been switched off completely :-))
   @Override
   public org.eclipse.emf.ecore.EValidator.Registry bindEValidatorRegistry()
   {
      org.eclipse.emf.ecore.EValidator.Registry registry = super.bindEValidatorRegistry();
      return registry;
   }

}
