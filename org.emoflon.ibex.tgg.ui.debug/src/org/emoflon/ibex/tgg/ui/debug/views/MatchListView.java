package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.emoflon.ibex.tgg.operational.matches.IMatch;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import net.miginfocom.swt.MigLayout;

public class MatchListView extends Composite {

    private MatchDisplayView matchDisplayView;

    private Tree treeView;
    private Button applyButton;

    private final BiMap<String, TreeItem> ruleItems;
    private final BiMap<IMatch, TreeItem> matchItems;

    private IMatch[] chosenMatch = new IMatch[1];

    private MatchListView(Composite pParent) {
	super(pParent, SWT.NONE);

	ruleItems = HashBiMap.create();
	matchItems = HashBiMap.create();
    }

    private MatchListView build() {
	setLayout(new MigLayout("fill"));

	treeView = new Tree(this, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.SINGLE);
	treeView.setLayoutData("grow");

	// begin test code
	for (int i = 0; i < 5; i++) {
	    TreeItem item = new TreeItem(treeView, SWT.NONE);
	    item.setText(String.valueOf(i));
	    for (int j = 0; j < 3; j++) {
		TreeItem subItem = new TreeItem(item, SWT.NONE);
		subItem.setText(String.valueOf(i) + " " + String.valueOf(j));
	    }
	}
	// end test code

	treeView.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {

		// begin test code
		if (matchDisplayView != null) {
		    String source = "@startuml\n";
		    source += "Bob -> Alice : ";
		    source += treeView.getSelection()[0].getText() + "\n";
		    source += "@enduml\n";
		    matchDisplayView.display(source);
		}
		// end test code

		// TreeItem selectedItem = treeView.getSelection()[0];
		// if (matchDisplayView != null) {
		// String source = null; // TODO build source String
		// matchDisplayView.display(source);
		// }
		//
		// applyButton.setEnabled(matchItems.containsValue(selectedItem));
	    }
	});
	treeView.pack();

	applyButton = new Button(this, SWT.PUSH);
	applyButton.setText("Apply match");
	applyButton.setLayoutData("dock south");
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

    public void registerMatchDisplayView(MatchDisplayView pMatchDisplayView) {
	matchDisplayView = pMatchDisplayView;
    }

    // TODO get test data to try this out
    public void display(Collection<IMatch> pMatches) {

	// TODO make sure this is correctly disposing of everything
	// Do I need to dispose of the TreeItems recursively manually?
	treeView.removeAll();

	if (pMatches == null)
	    return;

	for (IMatch match : pMatches) {
	    String ruleName = match.getRuleName();
	    if (!ruleItems.containsKey(ruleName)) {
		TreeItem ruleItem = new TreeItem(treeView, SWT.NONE);
		ruleItem.setText(ruleName);
		ruleItems.put(ruleName, ruleItem);
	    }
	    TreeItem matchItem = new TreeItem(ruleItems.get(ruleName), SWT.NONE);
	    matchItem.setText(match.getPatternName());
	    matchItems.put(match, matchItem);
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
