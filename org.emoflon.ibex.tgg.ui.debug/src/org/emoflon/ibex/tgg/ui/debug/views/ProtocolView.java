package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryDataPackage;
import org.emoflon.ibex.tgg.ui.debug.core.IVictoryDataConsumer;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol.ProtocolContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.protocol.ProtocolNode;

import language.TGGRule;

public class ProtocolView extends Composite implements ISharedFocusElement, IVictoryDataConsumer {

    private IVisualiser visualiser;

    private TreeViewer treeViewer;
    private ProtocolContentManager contentManager;

    private ProtocolView(Composite pParent, Collection<TGGRule> pRules) {
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

		if (!pEvent.getSelection().isEmpty())
		    sharedFocusElements.forEach(ISharedFocusElement::focusRemoved);

		if (pEvent.getSelection() instanceof IStructuredSelection) {
		    Collection<EObject> objectGraph = new HashSet<>();
		    for (Object element : pEvent.getStructuredSelection().toList())
			if (element instanceof ProtocolNode)
			    objectGraph.addAll(((ProtocolNode) element).getChanges());
		    visualiser.display(objectGraph);
		}
	    }
	});

	pack();
	return this;
    }

    public static ProtocolView create(Composite pParent, Collection<TGGRule> pRules) {
	return new ProtocolView(pParent, pRules).build();
    }

    public void registerVisualiser(IVisualiser pVisualiser) {
	visualiser = pVisualiser;
    }

    @Override
    public void accept(VictoryDataPackage pDataPackage) {
	contentManager.populate(pDataPackage.getProtocol());
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
