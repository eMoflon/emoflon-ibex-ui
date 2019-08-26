package org.emoflon.ibex.tgg.ui.debug.core;

import java.util.function.Consumer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.views.MatchDisplayView;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;
import org.emoflon.ibex.tgg.ui.debug.views.ProtocolView;

public class VictoryUI implements IExitCodeReceiver, Consumer<DataPackage> {

    private static Display display;

    public static Display getDisplay() {
	return display;
    }

    private Shell shell;
    private boolean exitCode;
    private DataProvider dataProvider;
    private MatchListView matchListView;
    private ProtocolView protocolView;
    private MatchDisplayView matchDisplayView;
    private UserOptionsManager userOptionsManager;

    public VictoryUI(DataProvider pDataProvider) {
	dataProvider = pDataProvider;
	userOptionsManager = new UserOptionsManager();

	initUI();
    }

    private void initUI() {
	Thread.currentThread().setName("Victory-UI thread");

	display = new Display();
	shell = new Shell(display);

	shell.setLayout(new GridLayout());

	SashForm mainSashForm = new SashForm(shell, SWT.HORIZONTAL);
	mainSashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
	mainSashForm.setLayout(new GridLayout());
	mainSashForm.setBackground(display.getSystemColor(SWT.COLOR_GRAY));

	SashForm leftPanelSashForm = new SashForm(mainSashForm, SWT.VERTICAL);
	leftPanelSashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
	leftPanelSashForm.setLayout(new GridLayout());
	leftPanelSashForm.setBackground(display.getSystemColor(SWT.COLOR_GRAY));

	matchListView = MatchListView.create(leftPanelSashForm, dataProvider.getAllRules());
	matchListView.setLayoutData(new GridData(GridData.FILL_BOTH));

	protocolView = ProtocolView.create(leftPanelSashForm, dataProvider.getAllRules());
	protocolView.setLayoutData(new GridData(GridData.FILL_BOTH));

	matchListView.registerSharedFocus(protocolView);
	protocolView.registerSharedFocus(matchListView);

	leftPanelSashForm.setWeights(new int[] { 60, 40 });

	matchDisplayView = MatchDisplayView.create(mainSashForm, this, dataProvider, userOptionsManager);
	matchDisplayView.setLayoutData(new GridData(GridData.FILL_BOTH));

	mainSashForm.setWeights(new int[] { 30, 70 });

	matchListView.registerVisualiser(matchDisplayView);
	protocolView.registerVisualiser(matchDisplayView);
    }

    public boolean run() {
	shell.open();
	while (!shell.isDisposed())
	    if (!display.readAndDispatch())
		display.sleep();
	display.dispose();

	return exitCode;
    }

    public void exit(boolean pRestart) {
	exitCode = pRestart;
	shell.dispose();
    }

    @Override
    public void accept(DataPackage pDataPackage) {
	matchListView.populate(pDataPackage.getMatches());
	protocolView.populate(pDataPackage.getRuleApplications());
    }

    public Match getSelectedMatch() {
	return matchListView.getChosenMatch();
    }
}
