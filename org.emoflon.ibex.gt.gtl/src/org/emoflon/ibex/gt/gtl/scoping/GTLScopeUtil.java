package org.emoflon.ibex.gt.gtl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;

public final class GTLScopeUtil {
	public static boolean isPatternImportPattern(final EObject context, final EReference reference) {
		return context instanceof PatternImport && reference == GTLPackage.Literals.PATTERN_IMPORT__PATTERN;
	}
}
