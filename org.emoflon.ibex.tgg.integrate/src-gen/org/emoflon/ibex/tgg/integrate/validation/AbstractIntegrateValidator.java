/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractIntegrateValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage.eINSTANCE);
		return result;
	}
}
