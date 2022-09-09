/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.common.slimgt.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.validation.Check;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class SlimGTValidator extends AbstractSlimGTValidator {

	/**
	 * This prevents all exceptions being "swallowed" by the default validator
	 * implementation. TODO: Remove this or make it a little nice for future stable
	 * release candidates.
	 */
	@Override
	protected void handleExceptionDuringValidation(final Throwable targetException) throws RuntimeException {
		targetException.printStackTrace();
	}

	@Check
	protected void checkMetamodelImports(Import imp) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		EcorePackage.eINSTANCE.eClass();
		URI uri = URI.createURI(imp.getName().replace("\"", ""));
		Resource r = null;
		EPackage metaModel = null;
		try {
			r = rs.getResource(uri, true);
			metaModel = (EPackage) r.getContents().get(0);
		} catch (Exception e) {
			error("Exception ocurred while loading imported metamodel: " + e.getMessage(),
					SlimGTPackage.Literals.IMPORT__NAME);
			return;
		}

		if (metaModel == null)
			error("Imported metamodel could not be loaded.", SlimGTPackage.Literals.IMPORT__NAME);

	}

}
