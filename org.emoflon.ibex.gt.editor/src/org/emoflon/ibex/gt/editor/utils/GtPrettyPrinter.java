package org.emoflon.ibex.gt.editor.utils;

import org.eclipse.emf.ecore.EClassifier;
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
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

	public static String describe(final EditorPattern editorPattern) {
		return editorPattern.getName();
	}

	public static String describe(final EditorNode editorNode) {
		return String.format("%s:%s", editorNode.getName(), describe(editorNode.getType()));
	}

	public static String describe(final EditorLiteralExpression expression) {
		return String.format("%s", expression.getValue());
	}

	public static String describe(final EditorEnumExpression expression) {
		return String.format("%s::%s", expression.getLiteral(), describe(expression.getLiteral().getEEnum()));
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
