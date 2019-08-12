package org.emoflon.ibex.tgg.ui.debug.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
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
    private Scale neighborhoodScale;

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

	edgeVisCombo = new Combo(panel, SWT.READ_ONLY);
	edgeVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	for (String option : VisualizationLabelOptions.getOptionNames(VisualizationLabelOptions.EDGE))
	    edgeVisCombo.add(option);
	edgeVisCombo.select(userOptionsManager.getEdgeLabelVisualization().ordinal());
	edgeVisCombo.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setEdgeLabelVisualization(VisualizationLabelOptions.get(edgeVisCombo.getText()));
		matchDisplayView.refresh();
	    }
	});

	nodeVisCombo = new Combo(panel, SWT.READ_ONLY);
	nodeVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	for (String option : VisualizationLabelOptions.getOptionNames(VisualizationLabelOptions.NODE))
	    nodeVisCombo.add(option);
	nodeVisCombo.select(userOptionsManager.getNodeLabelVisualization().ordinal());
	nodeVisCombo.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setNodeLabelVisualization(VisualizationLabelOptions.get(nodeVisCombo.getText()));
		matchDisplayView.refresh();
	    }
	});

	corrVisCombo = new Combo(panel, SWT.READ_ONLY);
	corrVisCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	for (String option : VisualizationLabelOptions.getOptionNames(VisualizationLabelOptions.CORR))
	    corrVisCombo.add(option);
	corrVisCombo.select(userOptionsManager.getCorrLabelVisualization().ordinal());
	corrVisCombo.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager.setCorrLabelVisualization(VisualizationLabelOptions.get(corrVisCombo.getText()));
		matchDisplayView.refresh();
	    }
	});

	Composite neighborhoodOption = new Composite(panel, SWT.NONE);
	neighborhoodOption.setLayout(new GridLayout(2, false));
	neighborhoodOption.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

	Label neighborhoodLabel = new Label(neighborhoodOption, SWT.NONE);
	neighborhoodLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	neighborhoodLabel.setText("Neighborhood size:");

	neighborhoodScale = new Scale(neighborhoodOption, SWT.HORIZONTAL);
	neighborhoodScale.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	neighborhoodScale.setMinimum(0);
	neighborhoodScale.setPageIncrement(1);
	neighborhoodScale.setMaximum(3);
	neighborhoodScale.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setNeighborhoodSize(neighborhoodScale.getSelection());
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
