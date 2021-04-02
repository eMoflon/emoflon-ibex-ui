package org.emoflon.ibex.tgg.ui.debug.api;

import org.emoflon.ibex.tgg.ui.debug.api.enums.DebuggerMode;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.BreakpointManager;
import org.emoflon.ibex.tgg.ui.debug.core.IDebugModeUpdater;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;

/**
 * The main interaction point for any adapter to use Victory. Provides static
 * methods for initializing the Victory UI and interacting with it.
 */
public final class Victory implements IDebugModeUpdater {
	private VictoryUI ui;
	private final Match[] selectedMatch = new Match[1];
	private Match preSelectedMatch = null;
	private boolean skipMatchSelection = false;
	private BreakpointManager breakpointManager;
	
	private DebuggerMode currentMode = DebuggerMode.STEP;

	@SuppressWarnings("deprecation")
	public boolean run(DataProvider dataProvider, Runnable matchProvider) {
		
		this.breakpointManager = new BreakpointManager();
		
		if (ui != null)
			throw new IllegalStateException("Victory has already been initialised.");
		ui = new VictoryUI(this, dataProvider, breakpointManager);

		Thread matchProviderThread = new Thread(matchProvider);
		matchProviderThread.start();

		boolean exitCode = ui.run();
		ui = null;

		if (matchProviderThread.isAlive())
			try {
				matchProviderThread.join(500);
			} catch (InterruptedException pIE) {
			} finally {
				if (matchProviderThread.isAlive())
					matchProviderThread.stop();
			}

		return exitCode;
	}
	
	public DebuggerMode getDebuggerMode() {
		synchronized (currentMode) {
			return currentMode;
		}
	}
	
	public void setDebuggerMode(DebuggerMode debuggerMode) {
		synchronized (currentMode) {
			currentMode = debuggerMode;
		}
		VictoryUI.getDisplay().syncExec(() -> ui.setDebuggerMode(currentMode));
	}
	
	public boolean checkBreakpointsBeforeMatchSelection(DataPackage dataPackage) {
		//check if any breakpoint is hit
		Match m = this.breakpointManager.checkBreakpointsBeforeMatchSelection(dataPackage);
		if(m != null) {
			this.setDebuggerMode(DebuggerMode.STEP);
			VictoryUI.getDisplay().syncExec(() -> ui.setMatchSelection(m));
			return true;
		}
		return false;
	}
	
	public void updateUI(DataPackage dataPackage, Match chosenMatch) {
		if (ui == null)
			throw new IllegalStateException("Victory has not been initialised yet.");
		VictoryUI.getDisplay().syncExec(() -> ui.accept(dataPackage));
		if(chosenMatch != null && this.getDebuggerMode() == DebuggerMode.STEP) {
			VictoryUI.getDisplay().syncExec(() -> ui.setMatchSelection(chosenMatch));
		}
		preSelectedMatch = chosenMatch;
	}
	
	public boolean checkBreakpointsAfterMatchSelection(DataPackage dataPackage, Match chosenMatch) {
		//check if any breakpoint is hit
		if(this.breakpointManager.checkBreakpointsAfterMatchSelection(dataPackage, chosenMatch)) {
			this.setDebuggerMode(DebuggerMode.STEP);
			VictoryUI.getDisplay().syncExec(() -> ui.setMatchSelection(chosenMatch));
			return true;
		}
		return false;
	}

	public Match selectMatch() {
		// CONCURRENCY: This method is only called by the match-providing thread
		synchronized (selectedMatch) {
			this.skipMatchSelection = false;
			this.setSelectedMatch(null);
		}

		synchronized (selectedMatch) {
			while (selectedMatch[0] == null && !skipMatchSelection)
				try {
					selectedMatch.wait();
				} catch (InterruptedException pIE) {
					// TODO calling thread was interrupted. What now..?
				}
			Match match = selectedMatch[0];
			if(match == null) {
				match = preSelectedMatch;
				preSelectedMatch = null;
				VictoryUI.getDisplay().syncExec(() -> ui.setMatchSelection(null));
			}
			
			return match;
		}
	}

	public void setSelectedMatch(Match match) {
		synchronized (selectedMatch) {
			selectedMatch[0] = match;
			selectedMatch.notify();
		}
	}
	
	public void skipMatchSelection() {
		synchronized (selectedMatch) {
			this.skipMatchSelection = true;
			selectedMatch.notify();
		}
	}
	
	
	
	public void step() {
		//TODO
	}
}
