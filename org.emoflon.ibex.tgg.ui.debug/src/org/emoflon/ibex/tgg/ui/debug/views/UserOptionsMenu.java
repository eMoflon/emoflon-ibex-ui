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
    private Button displayCorrButton;
    private Button displaySrcButton;
    private Button displayTrgButton;
    private Combo corrVisCombo;
    private Combo edgeVisCombo;
    private Combo nodeVisCombo;

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
	fullRuleVisButton.setText("Display created elements in match");
	fullRuleVisButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	fullRuleVisButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayFullRuleForMatches(fullRuleVisButton.getSelection());
		matchDisplayView.refresh();
	    }
	});

	displaySrcButton = new Button(panel, SWT.CHECK);
	displaySrcButton.setText("Display src elements in match");
	displaySrcButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	displaySrcButton.setSelection(userOptionsManager.displaySrcContextForMatches());
	displaySrcButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplaySrcContextForMatches(displaySrcButton.getSelection());
		matchDisplayView.refresh();
	    }
	});

	displayTrgButton = new Button(panel, SWT.CHECK);
	displayTrgButton.setText("Display trg elements in match");
	displayTrgButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	displayTrgButton.setSelection(userOptionsManager.displayTrgContextForMatches());
	displayTrgButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayTrgContextForMatches(displayTrgButton.getSelection());
		matchDisplayView.refresh();
	    }
	});

	displayCorrButton = new Button(panel, SWT.CHECK);
	displayCorrButton.setText("Display corr elements in match");
	displayCorrButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	displayCorrButton.setSelection(userOptionsManager.displayCorrContextForMatches());
	displayCorrButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayCorrContextForMatches(displayCorrButton.getSelection());
		matchDisplayView.refresh();
	    }
	});

	corrVisCombo = new Combo(panel, SWT.READ_ONLY);
	corrVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
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

	edgeVisCombo = new Combo(panel, SWT.READ_ONLY);
	edgeVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	final String[] edgeVisualizationOptions = new String[] { "Show Edge Labels", "Show abbreviated Edge Labels",
		"Hide Edge Labels" };
	for (String option : edgeVisualizationOptions) {
	    edgeVisCombo.add(option);
	}
	switch (userOptionsManager.getEdgeLabelVisualization()) {
	case FULLNAME:
	    edgeVisCombo.select(0);
	    break;
	case ABBREVIATED:
	    edgeVisCombo.select(1);
	    break;
	case NONE:
	    edgeVisCombo.select(2);
	    break;
	}
	edgeVisCombo.addSelectionListener(new SelectionListener() {

	    private VisualizationLabelOptions getSelectedVisualization(String selectedVisualization) {
		if (selectedVisualization.equals(edgeVisualizationOptions[0])) {
		    return VisualizationLabelOptions.FULLNAME;
		} else if (selectedVisualization.equals(edgeVisualizationOptions[1])) {
		    return VisualizationLabelOptions.ABBREVIATED;
		} else if (selectedVisualization.equals(edgeVisualizationOptions[2])) {
		    return VisualizationLabelOptions.NONE;
		} else {
		    throw new RuntimeException("Unknown visualization option: " + selectedVisualization);
		}
	    }

	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setEdgeLabelVisualization(getSelectedVisualization(edgeVisCombo.getText()));
		matchDisplayView.refresh();
	    }

	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
		userOptionsManager.setEdgeLabelVisualization(getSelectedVisualization(edgeVisCombo.getText()));
		matchDisplayView.refresh();
	    }
	});

	nodeVisCombo = new Combo(panel, SWT.READ_ONLY);
	nodeVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	final String[] nodeVisualizationOptions = new String[] { "Show Node Labels", "Show abbreviated Node Labels",
		"Hide Node Labels" };
	for (String option : nodeVisualizationOptions) {
	    nodeVisCombo.add(option);
	}
	switch (userOptionsManager.getNodeLabelVisualization()) {
	case FULLNAME:
	    nodeVisCombo.select(0);
	    break;
	case ABBREVIATED:
	    nodeVisCombo.select(1);
	    break;
	case NONE:
	    nodeVisCombo.select(2);
	    break;
	}
	nodeVisCombo.addSelectionListener(new SelectionListener() {

	    private VisualizationLabelOptions getSelectedVisualization(String selectedVisualization) {
		if (selectedVisualization.equals(nodeVisualizationOptions[0])) {
		    return VisualizationLabelOptions.FULLNAME;
		} else if (selectedVisualization.equals(nodeVisualizationOptions[1])) {
		    return VisualizationLabelOptions.ABBREVIATED;
		} else if (selectedVisualization.equals(nodeVisualizationOptions[2])) {
		    return VisualizationLabelOptions.NONE;
		} else {
		    throw new RuntimeException("Unknown visualization option: " + selectedVisualization);
		}
	    }

	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setNodeLabelVisualization(getSelectedVisualization(nodeVisCombo.getText()));
		matchDisplayView.refresh();
	    }

	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
		userOptionsManager.setNodeLabelVisualization(getSelectedVisualization(nodeVisCombo.getText()));
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
