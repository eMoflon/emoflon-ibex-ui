package org.emoflon.ibex.tgg.ui.debug.core;

import java.util.Arrays;
import java.util.List;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.ui.debug.api.DataPackage;
import org.emoflon.ibex.tgg.ui.debug.views.MatchListView;

public class UIController extends IbexController {

    private MatchListView matchListView; // TODO convert to interface
    private List<IVictoryDataConsumer> dataConsumers;

    public UIController(MatchListView pMatchListView, IVictoryDataConsumer... pDataConsumers) {
	dataConsumers = Arrays.asList(pDataConsumers);
	matchListView = pMatchListView;
    }

    @Override
    public void update(ObservableEvent eventType, Object... additionalInformation) {
	// CONCURRENCY: Ibex thread only

	// TODO implement
    }

    @Override
    public IMatch chooseOneMatch(DataPackage pDataPackage) {
	// CONCURRENCY: Ibex thread only

	IbexDebugUI.getDisplay().syncExec(() -> dataConsumers.forEach(consumer -> consumer.accept(pDataPackage)));
	IbexDebugUI.getDisplay().syncExec(() -> matchListView.populate(pDataPackage.getMatches()));

	return matchListView.getChosenMatch();
    }

    @Override
    protected int getRequestedMatchCount() {

	// TODO implement actual user-specified setting

	return 100;
    }
}
