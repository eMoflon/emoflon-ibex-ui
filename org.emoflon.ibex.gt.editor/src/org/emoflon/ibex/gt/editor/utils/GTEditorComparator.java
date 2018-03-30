package org.emoflon.ibex.gt.editor.utils;

import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;
import org.emoflon.ibex.gt.editor.gT.EditorExpression;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.Parameter;

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
	 * @return <code>true</code> if the expressions are equal
	 */
	public static boolean areExpressionsEqual(final EditorExpression a, final EditorExpression b) {
		if (a instanceof EditorAttributeExpression && b instanceof EditorAttributeExpression) {
			EditorAttributeExpression aAttributeExp = (EditorAttributeExpression) a;
			EditorAttributeExpression bAttributeExp = (EditorAttributeExpression) b;
			return aAttributeExp.getNode().getName().equals(bAttributeExp.getNode().getName())
					&& aAttributeExp.getAttribute().equals(bAttributeExp.getAttribute());
		}
		if (a instanceof EditorParameterExpression && b instanceof EditorParameterExpression) {
			Parameter p1 = ((EditorParameterExpression) a).getParameter();
			Parameter p2 = ((EditorParameterExpression) b).getParameter();
			return p1 != null && p2 != null && p1.getName().equals(p2.getName());
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
		return a.getType().equals(b.getType()) // equal type
				&& a.getTarget().getName().equals(b.getTarget().getName()); // equal target
	}
}
