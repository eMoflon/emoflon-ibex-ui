package org.emoflon.ibex.gt.editor.ui.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.moflon.core.utilities.WorkspaceSearch
import org.emoflon.ibex.gt.editor.gT.EditorImport

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
class GTProposalProvider extends AbstractGTProposalProvider {

	/**
	 * Suggest to import .ecore files in workspace.
	 */
	override completeEditorImport_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeEditorImport_Name(model, assignment, context, acceptor)

		val gtFile = if(model instanceof EditorGTFile) model else model.eContainer as EditorGTFile
		val currentImports = gtFile.imports
		.filter[import|import instanceof EditorImport].map[import | import as EditorImport]
		.map[it.name].toList
		WorkspaceSearch.getEcoreURIsInWorkspace(currentImports).forEach [
			acceptor.accept(createCompletionProposal('''"«it»"''', context))
		]

		val ecoreImport = "http://www.eclipse.org/emf/2002/Ecore"
		if (!currentImports.contains(ecoreImport)) {
			acceptor.accept(createCompletionProposal('''"«ecoreImport»"''', context))
		}
	}
}
