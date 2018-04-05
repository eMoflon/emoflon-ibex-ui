package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage

/**
 * Custom error messages.
 */
class GTLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {
	private static val CODE_PREFIX = "org.emoflon.ibex.gt.editor."

	public static val NODE_TYPE_NOT_FOUND = CODE_PREFIX + "node.type.typeNotFound"
	public static val NODE_TYPE_NOT_FOUND_MESSAGE = "Could not find class '%s'."

	public static val PARAMETER_TYPE_NOT_FOUND = CODE_PREFIX + "paramter.type.typeNotFound"
	public static val PARAMETER_TYPE_NOT_FOUND_MESSAGE = "Could not find data type '%s'."

	public static val REFERENCE_TARGET_NODE_NOT_FOUND = CODE_PREFIX + "reference.target.nodeNotFound"
	public static val REFERENCE_TARGET_NODE_NOT_FOUND_MESSAGE = "Could not find node '%s' of type '%s'."

	public static val RULE_SUPER_RULE_NOT_FOUND = CODE_PREFIX + "rule.superRules.ruleNotFound"
	public static val RULE_SUPER_RULE_NOT_FOUND_MESSAGE = "Could not find rule '%s'."

	override getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		var linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e) {
			linkText = e.getNode().getText();
		}

		// Parameter type not found in scope.
		if (context.reference === GTPackage.Literals.PARAMETER__TYPE) {
			return new DiagnosticMessage(
				String.format(PARAMETER_TYPE_NOT_FOUND_MESSAGE, linkText),
				Severity.ERROR,
				PARAMETER_TYPE_NOT_FOUND
			)
		}

		// Node type not found in scope.
		if (context.reference === GTPackage.Literals.NODE__TYPE) {
			return new DiagnosticMessage(
				String.format(NODE_TYPE_NOT_FOUND_MESSAGE, linkText),
				Severity.ERROR,
				NODE_TYPE_NOT_FOUND
			)
		}

		// Node for reference target not found in scope.
		if (context.reference === GTPackage.Literals.EDITOR_REFERENCE__TARGET) {
			val expectedType = (context.context as EditorReference).type.EReferenceType.name
			return new DiagnosticMessage(
				String.format(REFERENCE_TARGET_NODE_NOT_FOUND_MESSAGE, linkText, expectedType),
				Severity.ERROR,
				REFERENCE_TARGET_NODE_NOT_FOUND
			)
		}

		// Super rule not found in scope.
		if (context.reference === GTPackage.Literals.RULE__SUPER_RULES) {
			return new DiagnosticMessage(
				String.format(RULE_SUPER_RULE_NOT_FOUND_MESSAGE, linkText),
				Severity.ERROR,
				RULE_SUPER_RULE_NOT_FOUND
			)
		}

		return super.getUnresolvedProxyMessage(context)
	}
}
