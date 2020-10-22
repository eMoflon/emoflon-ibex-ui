package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.emoflon.ibex.gt.editor.gT.GTPackage

/**
 * Custom error codes and messages for scoping violations.
 */
class GTLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
	static val CODE_PREFIX = "org.emoflon.ibex.gt.editor."

	public static val ATTRIBUTE_NOT_FOUND = CODE_PREFIX + "attribute.type.notFound"
	public static val ATTRIBUTE_NOT_FOUND_MESSAGE = "Could not find attribute '%s'."

	public static val ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND = CODE_PREFIX + "attributeExpression.attribute.notFound"
	public static val ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND_MESSAGE = "Could not find attribute '%s'."

	public static val ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND = CODE_PREFIX + "attributeExpression.node.notFound"
	public static val ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND_MESSAGE = "Could not find node '%s'."

	public static val NODE_TYPE_NOT_FOUND = CODE_PREFIX + "node.type.notFound"
	public static val NODE_TYPE_NOT_FOUND_MESSAGE = "Could not find class '%s'."

	public static val PARAMETER_TYPE_NOT_FOUND = CODE_PREFIX + "parameter.type.notFound"
	public static val PARAMETER_TYPE_NOT_FOUND_MESSAGE = "Could not find data type '%s'."

	public static val PARAMETER_EXPRESSION_PARAMETER_NOT_FOUND = CODE_PREFIX + "parameterExpression.parameter.notFound"
	public static val PARAMETER_EXPRESSION_PARAMETER_NOT_FOUND_MESSAGE = "Could not find parameter '%s' of type '%s'."

	public static val REFERENCE_NOT_FOUND = CODE_PREFIX + "reference.type.notFound"
	public static val REFERENCE_NOT_FOUND_MESSAGE = "Could not find reference '%s'."

	public static val REFERENCE_TARGET_NODE_NOT_FOUND = CODE_PREFIX + "reference.target.nodeNotFound"
	public static val REFERENCE_TARGET_NODE_NOT_FOUND_MESSAGE = "Could not find node '%s' of type '%s'."

	override getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		
		// Node of attribute expression not found.
		if (context.reference === GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__NODE) {
			return new DiagnosticMessage(ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND_MESSAGE,
				Severity.ERROR, ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND
			)
		}
		
		// Attribute type of attribute expression not found.
		if (context.reference === GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE) {
			return new DiagnosticMessage( ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND_MESSAGE,
				Severity.ERROR, ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND
			)
		}
		
		//TODO: Other possible lazy-linking occurrences

		return super.getUnresolvedProxyMessage(context)
	}
}
