package org.emoflon.ibex.common.slimgt.ide.highlighting

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage
import org.emoflon.ibex.common.slimgt.services.SlimGTGrammarAccess
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge

class SlimGTSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
    @Inject package SlimGTGrammarAccess grammar

    override protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
        CancelIndicator cancelIndicator) {
        switch (object) {
            SlimRuleEdge: {
                highlightFeature(acceptor, object, SlimGTPackage.eINSTANCE.slimRuleEdge_Type, HighlightingStyles.DEFAULT_ID)
                return true
            }
            default: false
        }
    }
}