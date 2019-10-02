package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.TreeNode;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.MatchListContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.MatchNode;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.matchList.RuleNode;

public class MatchListView extends Composite implements ISharedFocusElement {

	private IVisualiser visualiser;

	private TreeViewer treeViewer;
	private MatchListContentManager contentManager;
	private Button applyButton;

	private ProtocolView protocolView;

	private Match[] chosenMatch = new Match[1];

	private Collection<ISharedFocusElement> sharedFocusElements = new HashSet<>();

	private Button expandAllButton;

	private Button collapseAllButton;

	private final IUserOptions userOptions;

	private MatchListView(Composite parent, Collection<Rule> rules, IUserOptions userOptions) {
		super(parent, SWT.NONE);

		this.userOptions = userOptions;
		contentManager = new MatchListContentManager(rules, userOptions);
	}

	private MatchListView build() {
		setLayout(new GridLayout(1, false));

		Composite c = new Composite(this, SWT.NORMAL);
		c.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		c.setLayout(new GridLayout(2, false));

		Font font = FontDescriptor.createFrom(new FontData("Monospaced", 10, SWT.BOLD))
				.createFont(VictoryUI.getDisplay());
		expandAllButton = new Button(c, SWT.PUSH);
		expandAllButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		expandAllButton.setText(" + ");
		expandAllButton.setSize(15, 15);
		expandAllButton.setFont(font);
		expandAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				treeViewer.expandAll();
			}
		});

		collapseAllButton = new Button(c, SWT.PUSH);
		collapseAllButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		collapseAllButton.setText(" - ");
		collapseAllButton.setSize(15, 15);
		collapseAllButton.setFont(font);
		collapseAllButton.setAlignment(SWT.CENTER);
		collapseAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				treeViewer.collapseAll();
			}
		});

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
				protocolView.highlight(null);

				if (!pEvent.getSelection().isEmpty()) {
					sharedFocusElements.forEach(ISharedFocusElement::focusRemoved);
				}

				if (pEvent.getSelection() instanceof IStructuredSelection) {
					Object selectedElement = pEvent.getStructuredSelection().getFirstElement();
					if (selectedElement instanceof MatchNode) {
						Match match = ((MatchNode) selectedElement).getMatch();
						visualiser.display(match);
						applyButton.setEnabled(!match.isBlocked());
					} else if (selectedElement instanceof RuleNode) {
						protocolView.highlight(((RuleNode) selectedElement).getRule().getName());
						visualiser.display(((RuleNode) selectedElement).getRule());
						List<TreeNode> matchNodes = ((RuleNode) selectedElement).getChildren().stream()
								.filter(c -> c instanceof MatchNode && !((MatchNode) c).getMatch().isBlocked())
								.collect(Collectors.toList());
						applyButton.setEnabled(!matchNodes.isEmpty());
					}
				}
			}
		});
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent pEvent) {
				Object selection = treeViewer.getStructuredSelection().getFirstElement();
				if (selection instanceof MatchNode) {
					applyMatch((MatchNode) selection);
				} else if (selection instanceof RuleNode) {
					applyRandomMatch((RuleNode) selection);
				}
			}
		});

		applyButton = new Button(this, SWT.PUSH);
		applyButton.setText("Apply");
		applyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				Object selection = treeViewer.getStructuredSelection().getFirstElement();
				if (selection instanceof MatchNode && !((MatchNode) selection).getMatch().isBlocked())
					applyMatch((MatchNode) selection);
				else if (selection instanceof RuleNode)
					applyRandomMatch((RuleNode) selection);
			}
		});

		this.updateToolTips();
		pack();
		return this;
	}

	public static MatchListView create(Composite parent, Collection<Rule> rules, IUserOptions userOptions) {
		return new MatchListView(parent, rules, userOptions).build();
	}

	public void registerVisualiser(IVisualiser visualiser) {
		this.visualiser = visualiser;
	}

	/**
	 * Populates the list-view with the given collection of matches.
	 * 
	 * @param pMatches the collection of matches to populate the list-view with
	 */
	public void populate(Collection<Match> matches) {
		applyButton.setEnabled(false);
		contentManager.populate(matches);
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

	@Override
	public void focusRemoved() {
		treeViewer.setSelection(null);
	}

	@Override
	public void registerSharedFocus(ISharedFocusElement sharedFocusElement) {
		sharedFocusElements.add(sharedFocusElement);
	}

	private void applyMatch(MatchNode matchNode) {
		synchronized (chosenMatch) {
			Victory.setSelectedMatch(matchNode.getMatch());
			RuleNode ruleNode = (RuleNode) matchNode.getParent();
			ruleNode.increaseTimesApplied();
			chosenMatch.notify();
		}
	}

	private void applyRandomMatch(RuleNode ruleNode) {
		synchronized (ruleNode) {
			List<TreeNode> matchNodes = ruleNode.getChildren().stream()
					.filter(c -> c instanceof MatchNode && !((MatchNode) c).getMatch().isBlocked())
					.collect(Collectors.toList());
			if (matchNodes.isEmpty()) {
				return;
			}
			int i = new Random().nextInt(matchNodes.size());
			applyMatch(((MatchNode) matchNodes.get(i)));
		}
	}

	public void updateToolTips() {
		treeViewer.getControl().setToolTipText(ToolTips.MATCHLIST_TREE.getDescription(userOptions.getToolTipSetting()));
		applyButton.setToolTipText(ToolTips.MATCHLIST_APPLY_BUTTON.getDescription(userOptions.getToolTipSetting()));
		collapseAllButton
				.setToolTipText(ToolTips.MATCHLIST_COLLAPSE_BUTTON.getDescription(userOptions.getToolTipSetting()));
		expandAllButton
				.setToolTipText(ToolTips.MATCHLIST_EXPAND_BUTTON.getDescription(userOptions.getToolTipSetting()));
	}

	/**
	 * @param protocolView the protocolView to set
	 */
	public void setProtocolView(ProtocolView protocolView) {
		this.protocolView = protocolView;
	}
}
