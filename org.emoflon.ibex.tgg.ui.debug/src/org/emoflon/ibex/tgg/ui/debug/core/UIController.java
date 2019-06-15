package org.emoflon.ibex.tgg.ui.debug.core;

import java.util.Collection;
import java.util.Map;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
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
    public IMatch chooseOneMatch(Map<IMatch, Collection<IMatch>> applicableMatches, Map<IMatch, Collection<IMatch>> inapplicableMatches) {
	// CONCURRENCY: Ibex thread only

	IbexDebugUI.getDisplay().syncExec(() -> matchListView.populate(applicableMatches.keySet(), inapplicableMatches.keySet()));

	return matchListView.getChosenMatch();
    }

    @Override
    protected int getRequestedMatchCount() {

	// TODO implement actual user-specified setting

	return 100;
    }
}
