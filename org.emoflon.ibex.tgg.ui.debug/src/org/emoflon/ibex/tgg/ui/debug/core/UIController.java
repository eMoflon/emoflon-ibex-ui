package org.emoflon.ibex.tgg.ui.debug.core;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.matches.ImmutableMatchContainer;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;

public class UIController extends IbexController {

    private MatchListView matchListView; // TODO convert to interface

    public UIController(MatchListView pMatchListView) {
	matchListView = pMatchListView;
    }

    @Override
    public IMatch chooseOneMatch(ImmutableMatchContainer pMatchContainer) {
	// CONCURRENCY: Ibex thread only

	IbexDebugUI.getDisplay().syncExec(() -> matchListView.populate(pMatchContainer.getMatches()));

	return matchListView.getChosenMatch();
    }

    @Override
    public void update(ObservableEvent eventType, Object... additionalInformation) {
	// CONCURRENCY: Ibex thread only

	// TODO implement
    }
}
