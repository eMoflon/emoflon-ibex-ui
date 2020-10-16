package org.emoflon.ibex.gt.editor.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression;
import org.emoflon.ibex.gt.editor.gT.EditorRelation;
import org.emoflon.ibex.gt.editor.gT.StringConstant;

/**
 * Utility methods for attribute validation.
 */
public class GTEditorAttributeUtils {
	private final static List<String> stringTypes = Arrays.asList("EChar", "ECharacterObject", "EString");
	private final static List<String> incomparableType = Arrays.asList("EBoolean", "EBooleanObject");
	public final static List<EditorRelation> equalityChecks = Arrays.asList(EditorRelation.EQUAL,
			EditorRelation.UNEQUAL);

	/**
	 * Parses the literal value to the expected type.
	 * 
	 * @param type       the expected data type
	 * @param expression the editor expression
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
	 * @param type the expected data type
	 * @param s    the string to parse
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
	 * Parses the String to the first possible type.
	 * 
	 * @param type the expected data type
	 * @param s    the string to parse
	 * @return an Optional for an Object of the type if the string can be converted
	 *         to the type. Otherwise the Optional will be empty.
	 */
	public static Optional<Object> convertEDataTypeStringToObject(final String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (final Exception e) {
			try {
				return Optional.of(Double.parseDouble(s));
			} catch (final Exception e1) {
				if(s.equalsIgnoreCase("false")) {
					return Optional.of(false);
				} else if(s.equalsIgnoreCase("true")) {
					return Optional.of(true);
				} else {
					return Optional.of(s);
				}
			}
		} 
	}
	
	/**
	 * Parses the String to the first possible type.
	 * 
	 * @param type the expected data type
	 * @param s    the string to parse
	 * @return an Optional for an Object of the type if the string can be converted
	 *         to the type. Otherwise the Optional will be empty.
	 */
	public static EDataType convertStringToEDataType(final String s) {
		try {
			Integer.parseInt(s);
			return EcorePackage.Literals.EINT;
		} catch (final Exception e) {
			try {
				Double.parseDouble(s);
				return EcorePackage.Literals.EDOUBLE;
			} catch (final Exception e1) {
				if(s.equalsIgnoreCase("false")) {
					return EcorePackage.Literals.EBOOLEAN;
				} else if(s.equalsIgnoreCase("true")) {
					return EcorePackage.Literals.EBOOLEAN;
				} else {
					return EcorePackage.Literals.ESTRING;
				}
			}
		} 
	}

	/**
	 * Checks whether the data type is comparable.
	 * 
	 * @param datatype the data type to check
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
	 * @param relation the relation to check
	 * @return true if the relation is Equal or Unequal
	 */
	public static boolean isEqualityCheck(final EditorRelation relation) {
		return equalityChecks.contains(relation);
	}

	/**
	 * Tries to find a suitable {@link EDataType} for the given
	 * {@link LiteralExpression}
	 * 
	 * @param expression the expression
	 * @return an {@link Optional} containing the identified {@link EDataType} (if a
	 *         match was found)
	 */
	public static Optional<EDataType> guessEDataType(final EditorLiteralExpression expression) {
		if (expression instanceof StringConstant)
			return Optional.of(EcorePackage.eINSTANCE.getEString());

		final String value = expression.getValue();
		switch (value) {
		case "true":
		case "false":
			return Optional.of(EcorePackage.eINSTANCE.getEBoolean());
		default:
			return guessNumericDataType(value);
		}

	}

	/**
	 * Tries to determine an appropriate numeric {@link EDataType} that is capable
	 * of parsing the given value
	 * 
	 * @param value the literal value
	 * @return possibly a numeric {@link EDataType}
	 */
	private static Optional<EDataType> guessNumericDataType(final String value) {
		final Collection<EDataType> candidateEDataTypestypes = getCandidateNumericDataTypes(value);

		for (final EDataType type : candidateEDataTypestypes) {
			if (convertEDataTypeStringToObject(type, value).isPresent()) {
				return Optional.of(type);
			}
		}
		return Optional.empty();
	}

	/**
	 * Returns EInt and ELong if the value consists of digits. Returns EInt and
	 * ELong if the value consists of digits and an intermediate period. Else,
	 * returns an empty list
	 * 
	 * @param value the literal value
	 * @return the list of candidate numeric {@link EDataType} objects
	 */
	private static Collection<EDataType> getCandidateNumericDataTypes(final String value) {
		final EcorePackage ecore = EcorePackage.eINSTANCE;
		if (value.matches("\\d+"))
			return Arrays.asList(ecore.getEInt(), ecore.getELong());
		else if (value.matches("\\d+\\.\\d+"))
			return Arrays.asList(ecore.getEDouble(), ecore.getEFloat());
		else
			return Arrays.asList();
	}
}
