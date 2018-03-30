package org.emoflon.ibex.gt.editor.utils;

import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;
import org.emoflon.ibex.gt.editor.gT.EditorExpression;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression;
import org.emoflon.ibex.gt.editor.gT.EditorReference;

/**
 * Utility methods to compare whether two editor elements are equal.
 */
public class GTEditorComparator {

	/**
	 * Checks whether the attribute constraints express the same.
	 * 
	 * @param a
	 *            the first attribute
	 * @param b
	 *            the second attribute
	 * @return <code>true</code> if and only if the attribute constraints are of the
	 *         same type and relation and have equal values
	 */
	public static boolean areAttributeConstraintsEqual(final EditorAttribute a, final EditorAttribute b) {
		return a.getAttribute().equals(b.getAttribute()) // equal types
				&& a.getRelation().equals(b.getRelation()) // equal relation
				&& areExpressionsEqual(a.getValue(), b.getValue()); // equal value
	}

	/**
	 * Checks whether the expressions are equal.
	 * 
	 * @param a
	 *            the first expression
	 * @param b
	 *            the second expression
	 * @return <code>true</code> if and only if the expressions are equal
	 */
	public static boolean areExpressionsEqual(final EditorExpression a, final EditorExpression b) {
		if (a instanceof EditorAttributeExpression && b instanceof EditorAttributeExpression) {
			return areAttributeExpressionsEqual((EditorAttributeExpression) a, (EditorAttributeExpression) b);
		}
		if (a instanceof EditorParameterExpression && b instanceof EditorParameterExpression) {
			return areParameterExpressionsEqual((EditorParameterExpression) a, (EditorParameterExpression) b);
		}
		if (a instanceof EditorEnumExpression && b instanceof EditorEnumExpression) {
			return ((EditorEnumExpression) a).getLiteral().equals(((EditorEnumExpression) b).getLiteral());
		}
		if (a instanceof EditorLiteralExpression && b instanceof EditorLiteralExpression) {
			return ((EditorLiteralExpression) a).getValue().equals(((EditorLiteralExpression) b).getValue());
		}
		return false;
	}

	/**
	 * Checks whether the attribute expressions are equal.
	 * 
	 * @param a
	 *            the first attribute expression
	 * @param b
	 *            the second attribute expression
	 * @return <code>true</code> if and only if the expressions refer to nodes of
	 *         the same name and have the same attribute
	 */
	public static boolean areAttributeExpressionsEqual(final EditorAttributeExpression a,
			final EditorAttributeExpression b) {
		return a.getNode().getName().equals(b.getNode().getName()) && a.getAttribute().equals(b.getAttribute());
	}

	/**
	 * Checks whether the parameter expressions are equal.
	 * 
	 * @param a
	 *            the first parameter expression
	 * @param b
	 *            the second parameter expression
	 * @return <code>true</code> if and only if the expressions refer to parameters
	 *         of the same name
	 */
	public static boolean areParameterExpressionsEqual(final EditorParameterExpression a,
			final EditorParameterExpression b) {
		return a.getParameter() != null && b.getParameter() != null
				&& a.getParameter().getName().equals(b.getParameter().getName());
	}

	/**
	 * Checks whether the references express the same.
	 * 
	 * @param a
	 *            the first reference
	 * @param b
	 *            the second reference
	 * @return <code>true</code> if and only if the references are of the same type
	 *         and point to nodes of the same name
	 */
	public static boolean areReferencesEqual(final EditorReference a, final EditorReference b) {
		return a.getType().equals(b.getType()) && a.getTarget().getName().equals(b.getTarget().getName());
	}
}
