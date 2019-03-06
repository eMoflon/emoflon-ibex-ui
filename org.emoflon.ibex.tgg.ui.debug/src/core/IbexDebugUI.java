package core;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryMonitor.IMatchChooser;

import net.miginfocom.swt.MigLayout;
import views.MatchDisplayView;
import views.MatchListView;

public class IbexDebugUI implements Runnable {

    private static Thread uiThread;
    public static final Display DISPLAY = new Display();

    /**
     * Creates, starts and returns a new IBeX debugging UI.<br>
     * Note that the debugging UI is automatically started on its own thread. No
     * further initialization is required.
     * 
     * @return the IBeX debugging UI that was created
     */
    public static IbexDebugUI create() {
	if (uiThread != null)
	    throw new IllegalStateException("UI thread is already running");

	IbexDebugUI ibexDebugUI = new IbexDebugUI();
	uiThread = new Thread(ibexDebugUI);
	uiThread.setName("IbexDebugUI - SWT UI thread");
	uiThread.start();

	return ibexDebugUI;
    }

    // -----------------------------------

    private IbexController controller;
    private MatchListView matchListView;
    private MatchDisplayView matchDisplayView;

    /**
     * Returns the IBeX-Controller for this debugging UI.<br>
     * If the UI has not finished initializing, this method will block the calling
     * thread until the IBeX-Controller is available.
     * 
     * @return the IBeX-Controller for this debugging UI
     */
    public IMatchChooser getIbexController() {
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

    @Override
    public void run() {
	Shell shell = new Shell(DISPLAY);
	shell.setLayout(new MigLayout("fill", "[30%][70%]"));

	matchListView = MatchListView.create(shell);
	matchListView.setLayoutData("grow");

	matchDisplayView = MatchDisplayView.create(shell);
	matchDisplayView.setLayoutData("grow");
	matchListView.registerMatchDisplayView(matchDisplayView);

	controller = new IbexController(matchListView);
	notify();

	shell.open();
	while (!shell.isDisposed())
	    if (!DISPLAY.readAndDispatch())
		DISPLAY.sleep();
	DISPLAY.dispose();
    }
}
