package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.DataPackage;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.operational.strategies.OperationalStrategy;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;

public class VictoryIBeXAdapter extends IbexController implements DataProvider {
	public static VictoryIBeXAdapter adapter;

	public static VictoryIBeXAdapter create(OperationalStrategy pOperationalStrategy, IBeXOperation pOperationType) {
		pOperationalStrategy.getOptions().flattenedTGG().getRules()
				.forEach(rule -> TGGRuleAdapter.adapt(rule, pOperationType));

		dataProvider = new VictoryDataProvider(pOperationalStrategy);
		adapter = new VictoryIBeXAdapter();
		Victory.create(adapter);
		return adapter;
	}

	public static Collection<EObject> getNeighbourhood(Collection<EObject> pNodes, int pNeighbourhoodSize) {
		return dataProvider.getMatchNeighbourhoods(pNodes, pNeighbourhoodSize);
	}

	public static TGGObjectGraph getNeighbourhood(int index, Collection<EObject> pSrcElements, Collection<EObject> pTrgElements,
			Collection<EObject> pCorrElements, int pNeighbourhoodSize, String ruleName) {
				
		System.out.println("pSrcElements before: " + pSrcElements.size());
		System.out.println("pTrgElements before: " + pTrgElements.size());
		
//		pSrcElements = dataProvider.getMatchNeighbourhoods(pSrcElements, pNeighbourhoodSize);
//		pTrgElements = dataProvider.getMatchNeighbourhoods(pTrgElements, pNeighbourhoodSize);
		
		System.out.println("pSrcElements after: " + pSrcElements.size());
		System.out.println("pTrgElements after: " + pTrgElements.size());
		return adapter.constructTGGObjectGraph(index, pSrcElements, pTrgElements, pCorrElements, ruleName);
	}

	private static IVictoryDataProvider dataProvider;

	private VictoryIBeXAdapter() {
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
