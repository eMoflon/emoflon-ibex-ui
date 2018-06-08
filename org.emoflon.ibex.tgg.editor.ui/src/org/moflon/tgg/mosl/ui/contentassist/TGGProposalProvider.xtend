package org.moflon.tgg.mosl.ui.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.moflon.core.utilities.WorkspaceSearch
import org.moflon.tgg.mosl.tgg.AttributeExpression
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
class TGGProposalProvider extends AbstractTGGProposalProvider {

	/**
	 * Suggest to import .ecore files from eMoflon EMF Projects.
	 */
	override completeImport_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeImport_Name(model, assignment, context, acceptor)

		val tggFile = model.eContainer as TripleGraphGrammarFile
		WorkspaceSearch.getEcoreURIsInWorkspace(tggFile.imports.map[it.name].toList).forEach [
			acceptor.accept(createCompletionProposal('''"«it»"''', context))
		]
	}

	override completeAttributeConstraint_Op(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeAttributeConstraint_Op(model, assignment, context, acceptor)

		val comparisonOps = newArrayList(" == ", " != ", " <= ", " >= ", " < ", " > ")
		for (opProposal : comparisonOps) {
			acceptor.accept(createCompletionProposal(opProposal, context))
		}
	}

	override completeAttributeExpression_Attribute(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeAttributeExpression_Attribute(model, assignment, context, acceptor);

		if (model instanceof AttributeExpression) {
			var attrVar = model as AttributeExpression

			for (attr : attrVar.objectVar.type.EAllAttributes) {
				acceptor.accept(createCompletionProposal(attr.name, context))
			}
		}
	}
}
