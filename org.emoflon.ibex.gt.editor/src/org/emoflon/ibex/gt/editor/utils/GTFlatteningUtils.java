package org.emoflon.ibex.gt.editor.utils;

import java.util.Optional;

import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorRelation;

/**
 * Utility methods for flattening of rules.
 */
public class GTFlatteningUtils {

	/**
	 * Returns the operator if elements with the two given elements are merged.
	 * 
	 * @param a
	 *            the operator of the first element
	 * @param b
	 *            the operator of the second element
	 * @return the operator of the merged element
	 */
	public static Optional<EditorOperator> getMergedOperator(final EditorOperator a, final EditorOperator b) {
		if (a.equals(b)) {
			return Optional.of(a);
		}

		// Context overwrites create/delete.
		if (a == EditorOperator.CONTEXT || b == EditorOperator.CONTEXT) {
			return Optional.of(EditorOperator.CONTEXT);
		}

		return Optional.empty();
	}

	/**
	 * Returns the operator if elements with the two given elements are merged.
	 * 
	 * @param operators
	 *            the operators
	 * @return an Optional for the operator of the merged element. The Optional is
	 *         empty if and only if no operator can be derived according to the
	 *         flattening algorithm.
	 */
	public static Optional<EditorOperator> mergeOperators(final EditorOperator... operators) {
		if (operators.length < 1) {
			return Optional.empty();
		}
		EditorOperator result = operators[0];
		for (int i = 1; i < operators.length; i++) {
			Optional<EditorOperator> o = getMergedOperator(result, operators[i]);
			if (o.isPresent()) {
				result = o.get();
			} else {
				return Optional.empty();
			}
		}
		return Optional.of(result);
	}

	/**
	 * Checks whether the node has any attribute assignment for the same attribute,
	 * but another value.
	 * 
	 * @param node
	 *            the node to check
	 * @param attribute
	 *            the attribute assignment to check
	 * @return <code>true</code> if and only if the node has another assignment for
	 *         the same attribute
	 */
	public static boolean hasConflictingAssignment(final EditorNode node, final EditorAttribute attribute) {
		boolean isAssignment = attribute.getRelation() == EditorRelation.ASSIGNMENT;
		return isAssignment && !node.getAttributes().stream().filter(
				a -> a.getRelation() == EditorRelation.ASSIGNMENT && a.getAttribute().equals(attribute.getAttribute()))
				.allMatch(a -> GTEditorComparator.areExpressionsEqual(a.getValue(), attribute.getValue()));
	}
}
