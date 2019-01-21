package org.emoflon.ibex.gt.editor.utils;

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionParameter;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConditionSpecification;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraint;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintArgument;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintAttributeValueExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintPredicate;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintVariable;
import org.emoflon.ibex.gt.editor.gT.EditorPatternAttributeConstraintVariableReference;
import org.moflon.core.utilities.UtilityClassNotInstantiableException;

/**
 * Collection of methods for pretty-printing elements of the GT language
 * 
 * @author Roland Kluge - Initial implementation
 *
 */
public final class GtPrettyPrinter {

	// Disable constructor
	private GtPrettyPrinter() {
		throw new UtilityClassNotInstantiableException();
	}

	public static String describe(final EditorAttributeConditionSpecification conditionSpecification) {
		final String parameterList = conditionSpecification.getParameters().stream().map(GtPrettyPrinter::describe)
				.collect(Collectors.joining(","));
		return String.format("%s(%s)", conditionSpecification.getName(), parameterList);
	}

	public static String describe(final EditorAttributeConditionParameter parameter) {
		return String.format("%s:%s", parameter.getName(), describe(parameter.getType()));
	}

	public static String describe(final EditorPatternAttributeConstraintVariable variable) {
		return String.format("%s:%s", variable.getName(), describe(variable.getType()));
	}

	public static String describe(final EditorPatternAttributeConstraint constraint) {
		if (constraint instanceof EditorPatternAttributeConstraintPredicate)
			return describe(EditorPatternAttributeConstraintPredicate.class.cast(constraint));
		else if (constraint instanceof EditorPatternAttributeConstraintVariable)
			return describe(EditorPatternAttributeConstraintVariable.class.cast(constraint));
		else
			return describeDefault(constraint);
	}

	public static String describe(final EditorPatternAttributeConstraintPredicate predicate) {
		final String parameterList = predicate.getArgs().stream().map(GtPrettyPrinter::describe)
				.collect(Collectors.joining(","));
		return String.format("%s(%s)", predicate.getName().getName(), parameterList);
	}

	public static String describe(final EditorPatternAttributeConstraintArgument predicateArgument) {
		if (predicateArgument instanceof EditorPatternAttributeConstraintAttributeValueExpression)
			return describe(EditorPatternAttributeConstraintAttributeValueExpression.class.cast(predicateArgument));
		else if (predicateArgument instanceof EditorLiteralExpression)
			return describe(EditorLiteralExpression.class.cast(predicateArgument));
		else if (predicateArgument instanceof EditorEnumExpression)
			return describe(EditorEnumExpression.class.cast(predicateArgument));
		else if (predicateArgument instanceof EditorPatternAttributeConstraintVariableReference)
			return describe(EditorPatternAttributeConstraintVariableReference.class.cast(predicateArgument));
		else if (predicateArgument instanceof EditorParameterExpression)
			return describe(EditorParameterExpression.class.cast(predicateArgument));
		else
			return describeDefault(predicateArgument);
	}

	public static String describe(final EditorPatternAttributeConstraintAttributeValueExpression expression) {
		return String.format("%s.%s", expression.getEditorNode().getName(), expression.getAttribute().getName());
	}

	public static String describe(final EditorLiteralExpression expression) {
		return String.format("%s", expression.getValue());
	}

	public static String describe(final EditorEnumExpression expression) {
		return String.format("%s::%s", expression.getLiteral(), describe(expression.getLiteral().getEEnum()));
	}

	public static String describe(final EditorPatternAttributeConstraintVariableReference variableReference) {
		final EditorPatternAttributeConstraintVariable variable = variableReference.getName();
		return String.format("%s:%s", variable.getName(), describe(variable.getType()));
	}

	public static String describe(final EditorParameterExpression expression) {
		return String.format("param::%s", expression.getParameter().getName());
	}

	public static String describe(final EClassifier eClassifier) {
		return eClassifier != null ? eClassifier.getName() : "unknown type";
	}

	public static String describeDefault(final Object object) {
		return object.toString();
	}
}
