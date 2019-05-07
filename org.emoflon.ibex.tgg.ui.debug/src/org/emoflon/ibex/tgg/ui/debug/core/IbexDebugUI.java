package org.emoflon.ibex.tgg.ui.debug.core;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.views.MatchDisplayView;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;

import net.miginfocom.swt.MigLayout;

public class IbexDebugUI implements Runnable {

    private static Display display;

    private IbexDebugUI(IVictoryDataProvider pDataProvider) {
	dataProvider = pDataProvider;
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
    public static IbexDebugUI create(IVictoryDataProvider pDataProvider, boolean pRunOnNewThread) {
	IbexDebugUI ibexDebugUI = new IbexDebugUI(pDataProvider);
	if (pRunOnNewThread) {
	    Thread uiThread = new Thread(ibexDebugUI);
	    uiThread.setName("IbexDebugUI - SWT UI thread");
	    uiThread.start();
	} else {
	    Thread.currentThread().setName("IbexDebugUI - SWT UI thread");
	}

	return ibexDebugUI;
    }

    public static Display getDisplay() {
	return display;
    }

    // -----------------------------------

    private UIController controller;
    private IVictoryDataProvider dataProvider;
    private MatchListView matchListView;
    private MatchDisplayView matchDisplayView;
    private UserOptionsManager userOptionsManager;

    @Override
    public void run() {
	display = new Display();
	Shell shell = new Shell(display);

	initUI(shell);

	shell.open();
	while (!shell.isDisposed())
	    if (!display.readAndDispatch())
		display.sleep();
	display.dispose();
    }

    private void initUI(Shell pShell) {
	pShell.setLayout(new MigLayout("fill", "[30%][70%]"));

	userOptionsManager = new UserOptionsManager();

	matchListView = MatchListView.create(pShell);
	matchListView.setLayoutData("grow");

	matchDisplayView = MatchDisplayView.create(pShell, dataProvider, userOptionsManager);
	matchDisplayView.setLayoutData("grow");

	matchListView.registerVisualiser(matchDisplayView);

	controller = new UIController(matchListView);
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
