package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.emoflon.ibex.tgg.operational.matches.IMatch;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class MatchListView extends Composite {

	private IVisualiser visualiser;

	private Tree treeView;
	private Button applyButton;

	private final BiMap<String, TreeItem> ruleItems;
	private final BiMap<IMatch, TreeItem> matchItems;

	private final HashMap<TreeItem, Boolean> itemToApplicability;

	private IMatch[] chosenMatch = new IMatch[1];

	private MatchListView(Composite pParent) {
		super(pParent, SWT.NONE);

		registerVisualiser(null);

		ruleItems = HashBiMap.create();
		matchItems = HashBiMap.create();
		itemToApplicability = new HashMap<TreeItem, Boolean>();
	}

	private MatchListView build() {
		setLayout(new GridLayout());

		treeView = new Tree(this, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.SINGLE);
		treeView.setLayoutData(new GridData(GridData.FILL_BOTH));

		treeView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {

				TreeItem selectedItem = treeView.getSelection()[0];
				applyButton.setEnabled(
						itemToApplicability.containsKey(selectedItem) && itemToApplicability.get(selectedItem));

				if (ruleItems.containsValue(selectedItem))
					visualiser.display(ruleItems.inverse().get(selectedItem));
				else if (matchItems.containsValue(selectedItem))
					visualiser.display(matchItems.inverse().get(selectedItem));

			}
		});
		treeView.pack();

		applyButton = new Button(this, SWT.PUSH);
		applyButton.setText("Apply match");
		applyButton.setLayoutData(new GridData()); // TODO
		applyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {

				TreeItem selectedItem = treeView.getSelection()[0];
				if (!matchItems.containsValue(selectedItem))
					; // TODO error -> why was the apply button even enabled?

				synchronized (chosenMatch) {
					chosenMatch[0] = matchItems.inverse().get(selectedItem);
					chosenMatch.notify();
				}
			}
		});

		pack();
		return this;
	}

	public static MatchListView create(Composite pParent) {
		return new MatchListView(pParent).build();
	}

	public void registerVisualiser(IVisualiser pVisualiser) {
		if (pVisualiser == null)
			visualiser = new IVisualiser() {
			};
		else
			visualiser = pVisualiser;
	}

	/**
	 * Populates the list-view with the given collection of matches.
	 * 
	 * @param pMatches the collection of matches to populate the list-view with
	 */
	public void populate(Collection<IMatch> applicableMatches, Collection<IMatch> inapplicableMatches) {
		treeView.removeAll();
		ruleItems.clear();
		matchItems.clear();
		applyButton.setEnabled(false);

		if (applicableMatches != null) {
			for (IMatch match : applicableMatches) {
				String ruleName = match.getRuleName();
				if (!ruleItems.containsKey(ruleName)) {
					TreeItem ruleItem = new TreeItem(treeView, SWT.NONE);
					ruleItem.setText(ruleName);
					ruleItems.put(ruleName, ruleItem);
					itemToApplicability.put(ruleItem, false);
				}
				TreeItem matchItem = new TreeItem(ruleItems.get(ruleName), SWT.NONE);
				matchItem.setText(match.getPatternName());
				matchItems.put(match, matchItem);
				itemToApplicability.put(matchItem, true);
			}
		}

		if (inapplicableMatches != null) {
			for (IMatch match : inapplicableMatches) {
				String ruleName = match.getRuleName();
				if (!ruleItems.containsKey(ruleName)) {
					TreeItem ruleItem = new TreeItem(treeView, SWT.NONE);
					ruleItem.setText(ruleName);
					ruleItems.put(ruleName, ruleItem);
					itemToApplicability.put(ruleItem, false);
				}
				TreeItem matchItem = new TreeItem(ruleItems.get(ruleName), SWT.NONE);
				matchItem.setText("[blocked] " + match.getPatternName());
				matchItem.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
				matchItems.put(match, matchItem);
				itemToApplicability.put(matchItem, false);
			}
		}
	}

	/**
	 * Blocks the calling thread until a chosen match is available.
	 * 
	 * @return the match chosen by the user
	 */
	public IMatch getChosenMatch() {
		synchronized (chosenMatch) {
			while (chosenMatch[0] == null)
				try {
					chosenMatch.wait();
				} catch (InterruptedException pIE) {
					// TODO calling thread was interrupted. What now..?
				}
			IMatch match = chosenMatch[0];
			chosenMatch[0] = null;
			return match;
		}
	}
}
