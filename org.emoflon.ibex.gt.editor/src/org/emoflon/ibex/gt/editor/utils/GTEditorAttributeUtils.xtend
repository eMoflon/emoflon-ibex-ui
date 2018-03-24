package org.emoflon.ibex.gt.editor.utils

import java.util.Optional

import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.emoflon.ibex.gt.editor.gT.LiteralValue
import org.emoflon.ibex.gt.editor.gT.Relation
import org.emoflon.ibex.gt.editor.gT.StringConstant

/**
 * Utility methods for attribute validation.
 */
class GTEditorAttributeUtils {
	private static val stringTypes = #[
		"EChar",
		"ECharacterObject",
		"EString"
	]

	private static val incomparableType = #[
		"EBoolean",
		"EBooleanObject"
	]

	public static val equalityChecks = #[
		Relation.EQUAL,
		Relation.UNEQUAL
	]

	/**
	 * Parses the literal value to the expected type.
	 */
	static def convertLiteralValueToObject(EDataType expectedType, LiteralValue expression) {
		if (stringTypes.contains(expectedType.name) && !(expression instanceof StringConstant)) {
			return Optional.empty
		}

		if (expectedType.serializable) {
			return convertEDataTypeStringToObject(expectedType, expression.value)
		}

		// EDataType which are not serializable cannot be specified in the editor.
		return Optional.empty
	}

	/**
	 * Parses the String to the expected type.
	 */
	static def convertEDataTypeStringToObject(EDataType type, String s) {
		try {
			val object = type.EPackage.EFactoryInstance.createFromString(type, s)
			return Optional.of(object)
		} catch (IllegalArgumentException e) {
			return Optional.empty
		}
	}

	/**
	 * Checks whether the data type is comparable.
	 */
	static def isComparable(EDataType datatype) {
		if (incomparableType.contains(datatype.name)) {
			return false
		}
		if (datatype instanceof EEnum) {
			return false
		}
		return true
	}

	/**
	 * Checks whether the relation is an equality check.
	 */
	static def isEqualityCheck(Relation relation) {
		return equalityChecks.contains(relation)
	}
}
