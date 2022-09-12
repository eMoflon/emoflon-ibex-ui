package org.emoflon.ibex.common.slimgt.validation;

import java.util.Set;

public final class SlimGTValidatorUtils {
	/**
	 * The list of invalid node names.
	 */
	public final static Set<String> NODE_NAME_BACKLIST = Set.of("class", "rule", "abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "const", "continue", "default", "do", "double", "EAttribute",
			"EBoolean", "EDataType", "EClass", "EClassifier", "EDouble", "EFloat", "EInt", "else", "enum", "EPackage",
			"EReference", "EString", "extends", "final", "finally", "float", "for", "goto", "if", "implements",
			"import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
			"public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw",
			"throws", "transient", "try", "void", "volatile", "while");

	/**
	 * The list of invalid pattern names.
	 */
	public final static Set<String> RULE_NAME_BACKLIST = Set.of("clone", "equals", "finalize", "getClass", "hashCode",
			"notify", "notifyAll", "toString", "wait", "abstract", "assert", "boolean", "break", "byte", "case",
			"catch", "char", "class", "const", "continue", "default", "do", "double", "EAttribute", "EBoolean",
			"EDataType", "EClass", "EClassifier", "EDouble", "EFloat", "EInt", "else", "enum", "EPackage", "EReference",
			"EString", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import",
			"instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
			"transient", "try", "void", "volatile", "while");
}
