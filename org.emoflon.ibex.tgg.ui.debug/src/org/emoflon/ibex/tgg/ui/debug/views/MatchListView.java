package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.MatchListContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.MatchNode;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.RuleNode;

public class MatchListView extends Composite implements ISharedFocusElement {

    private IVisualiser visualiser;

    private TreeViewer treeViewer;
    private MatchListContentManager contentManager;
    private Button applyButton;

    private Match[] chosenMatch = new Match[1];

    private MatchListView(Composite pParent, Collection<Rule> pRules) {
	super(pParent, SWT.NONE);

	contentManager = new MatchListContentManager(pRules);
    }

    private MatchListView build() {
	setLayout(new GridLayout(3, false));

	treeViewer = new TreeViewer(this, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.SINGLE);
	treeViewer.setContentProvider(contentManager.getTreeContentManager());
	treeViewer.setLabelProvider(contentManager.getTreeContentManager().getCellLabelProvider());
	GridData gridData = new GridData(GridData.FILL_BOTH);
	gridData.horizontalSpan = 3;
	treeViewer.getControl().setLayoutData(gridData);
	treeViewer.setInput("root");

	treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    @Override
	    public void selectionChanged(SelectionChangedEvent pEvent) {

		applyButton.setEnabled(false);

		if (!pEvent.getSelection().isEmpty())
		    sharedFocusElements.forEach(ISharedFocusElement::focusRemoved);

		if (pEvent.getSelection() instanceof IStructuredSelection) {
		    Object selectedElement = pEvent.getStructuredSelection().getFirstElement();
		    if (selectedElement instanceof MatchNode) {
			Match match = ((MatchNode) selectedElement).getMatch();
			visualiser.display(match);
			applyButton.setEnabled(!match.isBlocked());
		    } else if (selectedElement instanceof RuleNode)
			visualiser.display(((RuleNode) selectedElement).getRule());
		}
	    }
	});
	treeViewer.addDoubleClickListener(new IDoubleClickListener() {
	    @Override
	    public void doubleClick(DoubleClickEvent pEvent) {
		Object selection = treeViewer.getStructuredSelection().getFirstElement();
		if (selection instanceof MatchNode)
		    Victory.setSelectedMatch(((MatchNode) selection).getMatch());
	    }
	});

	applyButton = new Button(this, SWT.PUSH);
	applyButton.setText("Apply");
	applyButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		Object selection = treeViewer.getStructuredSelection().getFirstElement();
		if (selection instanceof MatchNode)
		    Victory.setSelectedMatch(((MatchNode) selection).getMatch());
	    }
	});

	Button collapseAllButton = new Button(this, SWT.PUSH);
	collapseAllButton.setText("Collapse All");
	collapseAllButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		treeViewer.collapseAll();
	    }
	});

	Button expandAllButton = new Button(this, SWT.PUSH);
	expandAllButton.setText("Expand All");
	expandAllButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		treeViewer.expandAll();
	    }
	});

	pack();
	return this;
    }

    public static MatchListView create(Composite pParent, Collection<Rule> pRules) {
	return new MatchListView(pParent, pRules).build();
    }

    public void registerVisualiser(IVisualiser pVisualiser) {
	visualiser = pVisualiser;
    }

    /**
     * Populates the list-view with the given collection of matches.
     * 
     * @param pMatches
     *            the collection of matches to populate the list-view with
     */
    public void populate(Collection<Match> pMatches) {
	applyButton.setEnabled(false);
	contentManager.populate(pMatches);
	treeViewer.refresh();
    }

    /**
     * Blocks the calling thread until a chosen match is available.
     * 
     * @return the match chosen by the user
     */
    public Match getChosenMatch() {
	synchronized (chosenMatch) {
	    while (chosenMatch[0] == null)
		try {
		    chosenMatch.wait();
		} catch (InterruptedException pIE) {
		    // TODO calling thread was interrupted. What now..?
		}
	    Match match = chosenMatch[0];
	    chosenMatch[0] = null;
	    return match;
	}
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
