package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.DataPackage;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;

public class VictoryIBeXAdapter extends IbexController {

    public VictoryIBeXAdapter(DataProvider pDataProvider) {
	Victory.create(pDataProvider);
    }

    public boolean runUI() {
	return Victory.run();
    }

    @Override
    public IMatch chooseOneMatch(DataPackage pDataPackage) {
	Match chosenMatch = Victory.selectMatch(new DataPackageAdapter(pDataPackage));
	if (chosenMatch instanceof MatchAdapter)
	    return ((MatchAdapter) chosenMatch).getWrappedMatch().getIMatch();
	else
	    throw new IllegalStateException(
		    "Victory returned something that wasn't a MatchAdapter. Something must have gone terribly wrong.");
    }

    @Override
    protected int getRequestedMatchCount() {
	// TODO
	return 0;
    }
}
