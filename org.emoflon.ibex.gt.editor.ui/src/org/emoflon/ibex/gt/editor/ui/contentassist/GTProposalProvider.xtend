package org.emoflon.ibex.gt.editor.ui.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.emoflon.ibex.common.editor.utils.WorkspaceSearch
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
class GTProposalProvider extends AbstractGTProposalProvider {

	/**
	 * Suggest to import .ecore files in workspace.
	 */
	override completeImport_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeImport_Name(model, assignment, context, acceptor)

		val gtFile = model.eContainer as GraphTransformationFile
		WorkspaceSearch.getEcoreURIsInWorkspace(gtFile.imports.map[it.name].toList).forEach [
			acceptor.accept(createCompletionProposal('''"«it»"''', context))
		]
	}
}
