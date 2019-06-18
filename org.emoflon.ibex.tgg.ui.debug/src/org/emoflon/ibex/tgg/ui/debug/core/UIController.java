package org.emoflon.ibex.tgg.ui.debug.core;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.victory.IbexController;
import org.emoflon.ibex.tgg.operational.victory.VictoryDataPackage;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;

public class UIController extends IbexController {

    private MatchListView matchListView; // TODO convert to interface

    public UIController(MatchListView pMatchListView) {
	matchListView = pMatchListView;
    }

    @Override
    public void update(ObservableEvent eventType, Object... additionalInformation) {
	// CONCURRENCY: Ibex thread only

	// TODO implement
    }

    @Override
    public IMatch chooseOneMatch(VictoryDataPackage pDataPackage) {
	// CONCURRENCY: Ibex thread only

	IbexDebugUI.getDisplay().syncExec(() -> matchListView.populate(pDataPackage.getMatches()));

	return matchListView.getChosenMatch();
    }

    @Override
    protected int getRequestedMatchCount() {

	// TODO implement actual user-specified setting

	return 100;
    }
}
