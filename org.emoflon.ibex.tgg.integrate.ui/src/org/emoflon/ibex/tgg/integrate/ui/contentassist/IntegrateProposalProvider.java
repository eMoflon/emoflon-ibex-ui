/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.moflon.core.utilities.WorkspaceSearch;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class IntegrateProposalProvider extends AbstractIntegrateProposalProvider {

	@Override
	public void complete_Import(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		
		WorkspaceSearch.getEcoreURIsInWorkspace(null).stream()
				.map(uri -> "\"" + uri + "\"")
				.map(uri -> createCompletionProposal(uri, context))
				.forEach(acceptor::accept);
	}

}
