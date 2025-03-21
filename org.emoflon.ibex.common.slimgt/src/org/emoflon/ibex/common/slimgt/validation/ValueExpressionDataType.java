package org.emoflon.ibex.common.slimgt.validation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;

public enum ValueExpressionDataType {
	INTEGER("Integer", EcorePackage.Literals.EINT), DOUBLE("Double", EcorePackage.Literals.EDOUBLE),
	STRING("String", EcorePackage.Literals.ESTRING), ENUM("ENUM", EcorePackage.Literals.EENUMERATOR),
	BOOLEAN("Boolean", EcorePackage.Literals.EBOOLEAN), DATE("Date", EcorePackage.Literals.EDATE),
	OBJECT("Object", EcorePackage.Literals.EOBJECT), NULL("Null", null), UNSUPPORTED("Unsupported", null),
	CONFLICT("Conflict", null);

	final public String name;
	final public EClassifier type;

	private ValueExpressionDataType(final String name, final EClassifier type) {
		this.name = name;
		this.type = type;
	}

	public static ValueExpressionDataType mergeWithInteger(ValueExpressionDataType type) {
		switch (type) {
		case DOUBLE:
			return DOUBLE;
		case INTEGER:
			return INTEGER;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithDouble(ValueExpressionDataType type) {
		switch (type) {
		case DOUBLE:
			return DOUBLE;
		case INTEGER:
			return DOUBLE;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithString(ValueExpressionDataType type) {
		switch (type) {
		case STRING:
			return STRING;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithEnum(ValueExpressionDataType type) {
		switch (type) {
		case ENUM:
			return ENUM;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithBoolean(ValueExpressionDataType type) {
		switch (type) {
		case BOOLEAN:
			return BOOLEAN;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithDate(ValueExpressionDataType type) {
		switch (type) {
		case DATE:
			return DATE;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithNull(ValueExpressionDataType type) {
		switch (type) {
		case NULL:
			return NULL;
		default:
			return CONFLICT;
		}
	}

	public static ValueExpressionDataType mergeWithObject(ValueExpressionDataType type) {
		switch (type) {
		case OBJECT:
			return OBJECT;
		default:
			return CONFLICT;
		}
	}
}
