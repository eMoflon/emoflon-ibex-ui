package org.emoflon.ibex.gt.editor.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionParameter;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintArgument;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintPredicate;

public class GTEnumExpressionHelper {

	/**
	 * Returns the position of the given predicate argument in the argument list of
	 * the given predicate
	 * 
	 * @param predicate         the predicate
	 * @param predicateArgument the argument
	 * @return the position or a negative value if the argument is not part of the
	 *         argument list of the predicate
	 */
	public static int getOffsetOfExpression(final EditorPatternAttributeConstraintPredicate predicate,
			final EditorPatternAttributeConstraintArgument predicateArgument) {
		int offset = -1;
		for (int i = 0; i < predicate.getArgs().size(); i++)
			if (predicate.getArgs().get(i).equals(predicateArgument))
				offset = i;
		return offset;
	}

	/**
	 * Determines the {@link EDataType} of the given {@link EditorEnumExpression}
	 * 
	 * @param expression the expression
	 * @return the type or <code>null</code> if not type could be found
	 */
	public static EDataType getEnumDataType(final EditorEnumExpression expression) {
		final EObject container = expression.eContainer();
		if (container instanceof EditorAttribute) {
			final EditorAttribute attributeConstraint = (EditorAttribute) container;
			return attributeConstraint.getAttribute().getEAttributeType();
		} else if (container instanceof EditorPatternAttributeConstraintPredicate) {
			final EditorPatternAttributeConstraintPredicate predicate = (EditorPatternAttributeConstraintPredicate) container;
			final int offset = getOffsetOfExpression(predicate, expression);
			final EList<EditorAttributeConditionParameter> argumentTypes = predicate.getName().getParameters();
			return argumentTypes.get(offset).getType();
		} else
			return null;
	}
}
