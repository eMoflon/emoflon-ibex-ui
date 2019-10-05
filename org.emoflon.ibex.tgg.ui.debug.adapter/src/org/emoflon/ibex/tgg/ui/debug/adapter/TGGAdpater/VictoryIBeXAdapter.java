package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
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

	public static VictoryIBeXAdapter create(OperationalStrategy operationalStrategy, IBeXOperation operationType) {
		operationalStrategy.getOptions().flattenedTGG().getRules()
				.forEach(rule -> TGGRuleAdapter.adapt(rule, operationType));

		dataProvider = new VictoryDataProvider(operationalStrategy);
		VictoryIBeXAdapter adapter = new VictoryIBeXAdapter();
		Victory.create(adapter);
		return adapter;
	}

	public static Collection<EObject> getNeighbourhood(Collection<EObject> nodes, int neighbourhoodSize) {
		return dataProvider.getMatchNeighbourhoods(nodes, neighbourhoodSize);
	}

	private static IVictoryDataProvider dataProvider;

	private VictoryIBeXAdapter() {
	}

	public boolean runUI() {
		return Victory.run();
	}

	@Override
	public IMatch chooseOneMatch(DataPackage dataPackage) {
		Match chosenMatch = Victory.selectMatch(new DataPackageAdapter(dataPackage));
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
	public void saveModels(String[] saveLocations) throws IOException {
		dataProvider.saveModels(saveLocations);
	}

	@Override
	public String[][] getDefaultSaveData() {
		return dataProvider.getDefaultSaveData();
	}

	@Override
	public void addBreakpoint(Rule pRule) {
	    // TODO implement
	}

	@Override
	public void removeBreakpoint(Rule pRule) {
	    // TODO implement
	}

}
