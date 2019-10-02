package org.emoflon.ibex.tgg.ui.debug.api;

import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;

/**
 * The main interaction point for any adapter to use Victory. Provides static
 * methods for initializing the Victory UI and interacting with it.
 */
public final class Victory {
	private static VictoryUI ui;
	private static final Match[] selectedMatch = new Match[1];

	public static void create(DataProvider pDataProvider) {

		if (ui != null)
			throw new IllegalStateException("Victory has already been initialised yet.");

		ui = new VictoryUI(pDataProvider);
	}

	public static boolean run() {
		boolean exitCode = ui.run();
		ui = null;
		return exitCode;
	}

	public static Match selectMatch(DataPackage pDataPackage) {
		// CONCURRENCY: This method is only called by the match-providing thread

		if (ui == null)
			throw new IllegalStateException("Victory has not been initialised yet.");

		// TODO what happens if the match-provider calls this before the UI has its run
		// method called?
		// Does the Display queue up this call until it starts reading and dispatching
		// events?
		// Or does everything crash and burn?
		VictoryUI.getDisplay().syncExec(() -> ui.accept(pDataPackage));

		synchronized (selectedMatch) {
			while (selectedMatch[0] == null)
				try {
					selectedMatch.wait();
				} catch (InterruptedException pIE) {
					// TODO calling thread was interrupted. What now..?
				}
			Match match = selectedMatch[0];
			selectedMatch[0] = null;
			return match;
		}
	}

	public static void setSelectedMatch(Match pMatch) {
		synchronized (selectedMatch) {
			selectedMatch[0] = pMatch;
			selectedMatch.notify();
		}
	}
}
