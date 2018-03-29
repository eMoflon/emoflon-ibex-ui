package org.emoflon.ibex.gt.editor.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.Relation;
import org.emoflon.ibex.gt.editor.gT.StringConstant;

/**
 * Utility methods for attribute validation.
 */
public class GTEditorAttributeUtils {
	private final static List<String> stringTypes = Arrays.asList("EChar", "ECharacterObject", "EString");
	private final static List<String> incomparableType = Arrays.asList("EBoolean", "EBooleanObject");
	public final static List<Relation> equalityChecks = Arrays.asList(Relation.EQUAL, Relation.UNEQUAL);

	/**
	 * Parses the literal value to the expected type.
	 * 
	 * @param type
	 *            the expected data type
	 * @param expression
	 *            the editor expression
	 * @return an Optional for an Object of the type if the expression can be
	 *         converted to the type. Otherwise the Optional will be empty.
	 */
	public static Optional<Object> convertLiteralValueToObject(final EDataType type,
			final EditorLiteralExpression expression) {
		if (stringTypes.contains(type.getName()) && !(expression instanceof StringConstant)) {
			return Optional.empty();
		}

		if (type.isSerializable()) {
			return convertEDataTypeStringToObject(type, expression.getValue());
		}

		// EDataType which are not serializable cannot be specified in the editor.
		return Optional.empty();
	}

	/**
	 * Parses the String to the expected type.
	 * 
	 * @param type
	 *            the expected data type
	 * @param s
	 *            the string to parse
	 * @return an Optional for an Object of the type if the string can be converted
	 *         to the type. Otherwise the Optional will be empty.
	 */
	public static Optional<Object> convertEDataTypeStringToObject(final EDataType type, final String s) {
		try {
			final Object object = type.getEPackage().getEFactoryInstance().createFromString(type, s);
			return Optional.of(object);
		} catch (final Exception e) {
			return Optional.empty();
		}
	}

	/**
	 * Checks whether the data type is comparable.
	 * 
	 * @param datatype
	 *            the data type to check
	 * @return true if the implementation of the data type implements Comparable
	 */
	public static boolean isComparable(final EDataType datatype) {
		if (incomparableType.contains(datatype.getName())) {
			return false;
		}
		if (datatype instanceof EEnum) {
			return false;
		}
		return true;
	}

	/**
	 * Checks whether the relation is an equality check.
	 * 
	 * @param relation
	 *            the relation to check
	 * @return true if the relation is Equal or Unequal
	 */
	public static boolean isEqualityCheck(final Relation relation) {
		return equalityChecks.contains(relation);
	}
}
