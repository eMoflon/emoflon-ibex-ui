package org.emoflon.ibex.tgg.editor.ui.highlighting;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.emoflon.ibex.tgg.editor.services.TGGGrammarAccess;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.AbstractHighlightingRule;
import org.emoflon.ibex.tgg.editor.ui.highlighting.utils.TGGHighlightProviderHelper;

import com.google.inject.Inject;

public class TGGSemanticHighlightCalculator extends DefaultSemanticHighlightingCalculator {

	@Inject
	TGGGrammarAccess ga;

	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {

		if (resource == null || resource.getParseResult() == null)
			return;
		INode rootNode = resource.getParseResult().getRootNode();
		Collection<AbstractHighlightingRule> rules = TGGHighlightProviderHelper.getHighlightRules();
		for (INode node : rootNode.getLeafNodes()) {
			findHighlightingRuleForNode(node, rules, acceptor);
		}
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator);

	}

	private void findHighlightingRuleForNode(INode node, Collection<AbstractHighlightingRule> rules, IHighlightedPositionAcceptor acceptor) {
		EObject moslObject = NodeModelUtils.findActualSemanticObjectFor(node);
		for (AbstractHighlightingRule rule : rules) {
			if (rule.canProvideHighlighting(moslObject, node, acceptor))
				return;
		}
	}

}
