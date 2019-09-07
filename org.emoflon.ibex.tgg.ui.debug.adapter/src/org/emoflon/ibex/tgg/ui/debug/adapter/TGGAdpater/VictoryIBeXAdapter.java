package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.io.IOException;
import java.util.Collection;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.DataPackage;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryDataProvider;
import org.emoflon.ibex.tgg.operational.strategies.OperationalStrategy;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;

public class VictoryIBeXAdapter extends IbexController implements DataProvider {

    public static VictoryIBeXAdapter create(OperationalStrategy pOperationalStrategy) {
	pOperationalStrategy.getOptions().flattenedTGG().getRules().forEach(TGGRuleAdapter::adapt);

	VictoryIBeXAdapter adapter = new VictoryIBeXAdapter(pOperationalStrategy);
	Victory.create(adapter);
	return adapter;
    }

    private IVictoryDataProvider dataProvider;

    private VictoryIBeXAdapter(OperationalStrategy pOperationalStrategy) {
	dataProvider = new VictoryDataProvider(pOperationalStrategy);
    }

    public boolean runUI() {
	return Victory.run();
    }

    @Override
    public IMatch chooseOneMatch(DataPackage pDataPackage) {
	Match chosenMatch = Victory.selectMatch(new DataPackageAdapter(pDataPackage));
	if (chosenMatch instanceof IbexMatchAdapter)
	    return ((IbexMatchAdapter) chosenMatch).getWrappedMatch().getIMatch();
	else
	    throw new IllegalStateException(
		    "Victory returned something that wasn't a MatchAdapter. Something must have gone terribly wrong.");
    }

    @Override
    public Collection<Rule> getAllRules() {
	return TGGRuleAdapter.getAllRules();
    }

    @Override
    public void saveModels() throws IOException {
	dataProvider.saveModels();
    }
}
