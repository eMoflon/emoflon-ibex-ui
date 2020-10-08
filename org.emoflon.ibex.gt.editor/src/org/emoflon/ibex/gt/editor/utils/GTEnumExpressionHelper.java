package org.emoflon.ibex.gt.editor.utils;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;

public class GTEnumExpressionHelper {

	/**
	 * Determines the {@link EDataType} of the given {@link EditorEnumExpression}
	 * 
	 * @param expression the expression
	 * @return the type or <code>null</code> if not type could be found
	 */
	public static EDataType getEnumDataType(final EditorEnumExpression expression) {
		final EObject container = expression.eContainer();
		if (container instanceof EditorAttributeAssignment) {
			final EditorAttributeAssignment attributeConstraint = (EditorAttributeAssignment) container;
			return attributeConstraint.getAttribute().getEAttributeType();
		} else if (container instanceof EditorAttributeConstraint) {
			final EditorAttributeConstraint predicate = (EditorAttributeConstraint) container;
			return expression.getLiteral().getEEnum();
		} else
			return null;
	}
}
