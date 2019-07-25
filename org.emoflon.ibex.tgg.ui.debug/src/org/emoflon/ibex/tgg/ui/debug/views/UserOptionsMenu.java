package org.emoflon.ibex.tgg.ui.debug.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager.VisualizationLabelOptions;

public class UserOptionsMenu {

    private UserOptionsManager userOptionsManager;
    private MatchDisplayView matchDisplayView;

    private Shell menuShell;
    private Button fullRuleVisButton;
    private Combo corrVisCombo;

    public UserOptionsMenu(UserOptionsManager pUserOptionsManager, MatchDisplayView pMatchDisplayView) {
	userOptionsManager = pUserOptionsManager;
	matchDisplayView = pMatchDisplayView;
    }

    public void build(Shell pParentShell) {
	menuShell = new Shell(pParentShell, SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.ON_TOP);
	menuShell.setText("User Options Menu");
	menuShell.setLayout(new GridLayout());
	menuShell.addShellListener(new ShellAdapter() {
	    @Override
	    public void shellClosed(ShellEvent pEvent) {
		pEvent.doit = false;
		menuShell.setVisible(false);
	    }
	});

	Composite panel = new Composite(menuShell, SWT.NONE);
	panel.setLayoutData(new GridData(GridData.FILL_BOTH));
	panel.setLayout(new GridLayout());

	fullRuleVisButton = new Button(panel, SWT.CHECK);
	fullRuleVisButton.setText("Full rule visualisation");
	fullRuleVisButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
	fullRuleVisButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayFullRuleForMatches(fullRuleVisButton.getSelection());
		matchDisplayView.refresh();
	    }
	});

	corrVisCombo = new Combo(panel, SWT.READ_ONLY);
	corrVisCombo.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
	final String[] corrVisualizationOptions = new String[] { "Show Corr Labels", "Show abbreviated Corr Labels",
		"Hide Corr Labels" };
	for (String option : corrVisualizationOptions) {
	    corrVisCombo.add(option);
	}
	switch (userOptionsManager.getCorrLabelVisualization()) {
	case FULLNAME:
	    corrVisCombo.select(0);
	    break;
	case ABBREVIATED:
	    corrVisCombo.select(1);
	    break;
	case NONE:
	    corrVisCombo.select(2);
	    break;
	}
	corrVisCombo.addSelectionListener(new SelectionListener() {

	    private VisualizationLabelOptions getSelectedVisualization(String selectedVisualization) {
		if (selectedVisualization.equals(corrVisualizationOptions[0])) {
		    return VisualizationLabelOptions.FULLNAME;
		} else if (selectedVisualization.equals(corrVisualizationOptions[1])) {
		    return VisualizationLabelOptions.ABBREVIATED;
		} else if (selectedVisualization.equals(corrVisualizationOptions[2])) {
		    return VisualizationLabelOptions.NONE;
		} else {
		    throw new RuntimeException("Unknown visualization option: " + selectedVisualization);
		}
	    }

	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setCorrLabelVisualization(getSelectedVisualization(corrVisCombo.getText()));
		matchDisplayView.refresh();
	    }

	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
		userOptionsManager.setCorrLabelVisualization(getSelectedVisualization(corrVisCombo.getText()));
		matchDisplayView.refresh();
	    }
	});

	panel.pack();
	menuShell.pack();

	menuShell.open();
	menuShell.setVisible(false);
    }

    public void show() {
	menuShell.setVisible(true);
    }
}
