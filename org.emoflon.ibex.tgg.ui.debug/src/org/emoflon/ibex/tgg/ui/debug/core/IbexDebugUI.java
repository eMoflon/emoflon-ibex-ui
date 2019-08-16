package org.emoflon.ibex.tgg.ui.debug.core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.ui.debug.options.IBeXOp;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.views.MatchDisplayView;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;
import org.emoflon.ibex.tgg.ui.debug.views.ProtocolView;

public class IbexDebugUI {

    private static IbexDebugUI instance;
    
    private static Display display;
    private Shell shell;
    private boolean exitCode;

    private IbexDebugUI(IVictoryDataProvider pDataProvider, IBeXOp pOp) {
	dataProvider = pDataProvider;
	userOptionsManager = new UserOptionsManager(pOp);
    }

    /**
     * Creates and returns a new IBeX debugging UI.
     * <p>
     * If the <code>pRunOnNewThread</code> flag is set to <code>true</code>, then
     * the debugging UI is automatically started on its own thread. No further
     * initialization is required.
     * <p>
     * If the flag is set to false, then the UI needs to be specifically started by
     * calling {@link IbexDebugUI#run()}. Note that the UI will use the calling
     * thread as its event loop, thereby blocking any execution of other statements
     * until the UI is closed.
     * 
     * @return the IBeX debugging UI that was created
     */
    public static IbexDebugUI create(IVictoryDataProvider pDataProvider, IBeXOp pOp) {
	if(instance != null)
	    throw new IllegalStateException("UI was already created");
	
	Thread.currentThread().setName("IbexDebugUI - SWT UI thread");
	return instance = new IbexDebugUI(pDataProvider, pOp);
    }

    public static Display getDisplay() {
	return display;
    }

    // -----------------------------------

    private UIController controller;
    private IVictoryDataProvider dataProvider;
    private MatchListView matchListView;
    private ProtocolView protocolView;
    private MatchDisplayView matchDisplayView;
    private UserOptionsManager userOptionsManager;

    public boolean run() {
	display = new Display();
	shell = new Shell(display);

	initUI(shell);

	shell.open();
	while (!shell.isDisposed())
	    if (!display.readAndDispatch())
		display.sleep();
	display.dispose();
	
	return exitCode;
    }
    
    public static void exit(boolean pRestart) {
	instance.exitCode = pRestart;
	instance.shell.dispose();
	instance = null;
    }
    
    private void initUI(Shell pShell) {
	pShell.setLayout(new GridLayout());

	SashForm mainSashForm = new SashForm(pShell, SWT.HORIZONTAL);
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

	// TODO this is ugly, find a better solution
	matchListView.registerSharedFocus(protocolView);
	protocolView.registerSharedFocus(matchListView);

	leftPanelSashForm.setWeights(new int[] { 60, 40 });

	matchDisplayView = MatchDisplayView.create(mainSashForm, dataProvider, userOptionsManager);
	matchDisplayView.setLayoutData(new GridData(GridData.FILL_BOTH));

	mainSashForm.setWeights(new int[] { 30, 70 });

	matchListView.registerVisualiser(matchDisplayView);
	protocolView.registerVisualiser(matchDisplayView);

	controller = new UIController(matchListView, protocolView);

	synchronized (this) {
	    notify();
	}
    }

    /**
     * Returns the IBeX-Controller for this debugging UI.<br>
     * If the UI has not finished initializing, this method will block the calling
     * thread until the IBeX-Controller is available.
     * 
     * @return the IBeX-Controller for this debugging UI
     */
    public IbexController getIbexController() {
	synchronized (this) {
	    while (controller == null)
		try {
		    wait();
		} catch (InterruptedException pIE) {
		    // TODO calling thread was interrupted. What now..?
		}
	    return controller;
	}
    }
}
