package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol.ProtocolContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol.RuleApplicationNode;

public class ProtocolView extends Composite implements ISharedFocusElement {

    private IVisualiser visualiser;

    private TreeViewer treeViewer;
    private ProtocolContentManager contentManager;

    private ProtocolView(Composite pParent, Collection<Rule> pRules) {
	super(pParent, SWT.NONE);

	contentManager = new ProtocolContentManager();
    }

    private ProtocolView build() {
	setLayout(new GridLayout());

	treeViewer = new TreeViewer(this, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI);
	treeViewer.setContentProvider(contentManager.getTreeContentManager());
	treeViewer.setLabelProvider(contentManager.getTreeContentManager().getCellLabelProvider());
	treeViewer.setComparator(contentManager.getProtocolNodeComparator());
	treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
	treeViewer.setInput("root");

	treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    @Override
	    public void selectionChanged(SelectionChangedEvent pEvent) {

		if (pEvent.getSelection().isEmpty())
		    return;
		else
		    sharedFocusElements.forEach(ISharedFocusElement::focusRemoved);

		if (pEvent.getSelection() instanceof IStructuredSelection) {
		    @SuppressWarnings("unchecked")
		    List<Object> selection = pEvent.getStructuredSelection().toList();

		    Collection<RuleApplication> ruleApplications = new HashSet<>();
		    for (Object element : selection)
			if (element instanceof RuleApplicationNode)
			    ruleApplications.add(((RuleApplicationNode) element).getModelChanges());
		    visualiser.display(ruleApplications);
		}
	    }
	});

	pack();
	return this;

    }

    public static ProtocolView create(Composite pParent, Collection<Rule> pRules) {
	return new ProtocolView(pParent, pRules).build();
    }

    public void registerVisualiser(IVisualiser pVisualiser) {
	visualiser = pVisualiser;
    }

    public void populate(List<RuleApplication> pRuleApplications) {
	contentManager.populate(pRuleApplications);
	treeViewer.refresh();
    }

    private Collection<ISharedFocusElement> sharedFocusElements = new HashSet<>();

    @Override
    public void focusRemoved() {
	treeViewer.setSelection(null);
    }

    @Override
    public void registerSharedFocus(ISharedFocusElement pSharedFocusElement) {
	sharedFocusElements.add(pSharedFocusElement);
    }

}
