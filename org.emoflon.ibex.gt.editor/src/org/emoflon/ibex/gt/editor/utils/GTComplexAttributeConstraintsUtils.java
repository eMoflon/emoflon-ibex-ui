package org.emoflon.ibex.gt.editor.utils;

import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeCondition;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraint;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintArgument;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintAttributeValueExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintPredicate;
import org.moflon.core.utilities.UtilityClassNotInstantiableException;

/**
 * Methods for working with complex attribute constraints of
 * {@link EditorPattern} objects
 * 
 * @author Roland Kluge - Initial implementation
 *
 */
public final class GTComplexAttributeConstraintsUtils {

	private GTComplexAttributeConstraintsUtils() {
		throw new UtilityClassNotInstantiableException();
	}

	/**
	 * Checks whether the editor pattern has an attribute condition with a free
	 * variable
	 * 
	 * @param editorPattern the pattern to check
	 * @return true if a free variable exists
	 */
	public static boolean hasFreeVariablesInAttributeConditions(final EditorPattern editorPattern) {
		return editorPattern.getComplexAttributeConstraints().stream()
				.anyMatch(GTComplexAttributeConstraintsUtils::hasFreeVariablesInCondition);
	}

	/**
	 * @param condition the condition to check
	 * @return true if the given condition contains a predicate containing a free
	 *         variable
	 */
	private static boolean hasFreeVariablesInCondition(final EditorPatternAttributeCondition condition) {
		return condition.getConstraints().stream()
				.anyMatch(GTComplexAttributeConstraintsUtils::hasFreeVariablesInPredicates);
	}

	/**
	 * @param constraint the constraint to check
	 * @return true if the given constraint is a predicate containing a free
	 *         variable
	 */
	private static boolean hasFreeVariablesInPredicates(final EditorPatternAttributeConstraint constraint) {
		if (constraint instanceof EditorPatternAttributeConstraintPredicate) {
			final EditorPatternAttributeConstraintPredicate predicate = (EditorPatternAttributeConstraintPredicate) constraint;
			return predicate.getArgs().stream()
					.anyMatch(GTComplexAttributeConstraintsUtils::hasFreeVariablesInArgument);
		}
		return false;
	}

	/**
	 * @param argument the argument to check
	 * @return true if the given argument represents a free variable
	 */
	private static boolean hasFreeVariablesInArgument(final EditorPatternAttributeConstraintArgument argument) {
		if (argument instanceof EditorPatternAttributeConstraintAttributeValueExpression) {
			final EditorPatternAttributeConstraintAttributeValueExpression valueExpression = (EditorPatternAttributeConstraintAttributeValueExpression) argument;
			return valueExpression.isFree();
		}
		return false;
	}
}
