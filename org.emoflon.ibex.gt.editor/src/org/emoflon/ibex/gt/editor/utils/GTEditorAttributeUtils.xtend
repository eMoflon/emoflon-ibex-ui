package org.emoflon.ibex.gt.editor.utils

import org.emoflon.ibex.gt.editor.gT.BooleanConstant
import org.emoflon.ibex.gt.editor.gT.DecimalConstant
import org.emoflon.ibex.gt.editor.gT.IntegerConstant
import org.emoflon.ibex.gt.editor.gT.LiteralValue
import org.emoflon.ibex.gt.editor.gT.StringConstant
import org.eclipse.emf.ecore.EDataType

/**
 * Utility methods for attribute validation.
 */
class GTEditorAttributeUtils {
	/**
	 * The list of valid EDataType names for boolean constants.
	 */
	private static val dataTypesBoolean = #[
		"EBoolean",
		"EBooleanObject"
	]

	/**
	 * The list of valid EDataType names for character constants. 
	 */
	private static val dataTypesChar = #[
		"EChar",
		"ECharacterObject"
	]

	/**
	 * The list of valid EDataType names for integer constants.
	 */
	private static val dataTypesInteger = #[
		"EBigInteger",
		"EByte",
		"EByteObject",
		"EInt",
		"EIntegerObject",
		"ELong",
		"ELongObject",
		"EShort",
		"EShortObject"
	]

	/**
	 * The list of valid EDataType names for decimal constants.  
	 */
	private static val dataTypesDecimal = #[
		"EBigDecimal",
		"EDouble",
		"EDoubleObject",
		"EFloat",
		"EFloatObject"
	]

	/**
	 * Checks whether the literal value fits to the expected type. 
	 */
	static def isValidLiteralValue(LiteralValue value, EDataType expectedType) {
		if (isBoolean(expectedType)) {
			return value instanceof BooleanConstant
		}
		if (isChar(expectedType)) {
			return value instanceof StringConstant && (value as StringConstant).value.length == 1
		}
		if (isDecimal(expectedType)) {
			return value instanceof DecimalConstant || value instanceof IntegerConstant
		}
		if (isInteger(expectedType)) {
			return value instanceof IntegerConstant
		}
		if (isString(expectedType)) {
			return value instanceof StringConstant
		}
		return true
	}

	static def isBoolean(EDataType expectedType) {
		return dataTypesBoolean.contains(expectedType.name)
	}

	static def isChar(EDataType expectedType) {
		return dataTypesChar.contains(expectedType.name)
	}

	static def isDecimal(EDataType expectedType) {
		return dataTypesDecimal.contains(expectedType.name)
	}

	static def isInteger(EDataType expectedType) {
		return dataTypesInteger.contains(expectedType.name)
	}

	static def isString(EDataType expectedType) {
		return "EString".equals(expectedType.name)
	}
}
