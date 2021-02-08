package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;
import org.emoflon.ibex.tgg.operational.matches.ImmutableMatchContainer;
import org.emoflon.ibex.tgg.operational.monitoring.DataPackage;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.IbexController;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryDataProvider;
import org.emoflon.ibex.tgg.operational.strategies.OperationalStrategy;
import org.emoflon.ibex.tgg.operational.updatepolicy.IUpdatePolicy;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.Victory;
import org.emoflon.ibex.tgg.ui.debug.api.enums.DebuggerMode;

public class VictoryIBeXAdapter extends IbexController implements DataProvider {

	public static VictoryIBeXAdapter create(OperationalStrategy operationalStrategy, IBeXOperation operationType) {
		operationalStrategy.getOptions().tgg.flattenedTGG().getRules()
				.forEach(rule -> TGGRuleAdapter.adapt(rule, operationType));

		dataProvider = new VictoryDataProvider(operationalStrategy);
		return new VictoryIBeXAdapter();
	}

	public static Collection<EObject> getNeighbourhood(Collection<EObject> nodes, int neighbourhoodSize) {
		return dataProvider.getMatchNeighbourhoods(nodes, neighbourhoodSize);
	}
	
	@Override
	public void register(OperationalStrategy pOperationalStrategy) {
		// remember the originally configured update policy of the operational strategy
		this.automaticUpdatePolicy = pOperationalStrategy.getUpdatePolicy();
		super.register(pOperationalStrategy);
	}
	
	public void setAutomaticUpdatePolicy(IUpdatePolicy updatePolicy) {
		this.automaticUpdatePolicy = updatePolicy;
	}

	private static IVictoryDataProvider dataProvider;
	
	private IUpdatePolicy automaticUpdatePolicy;

	private Victory victory;

	private VictoryIBeXAdapter() {
		victory = new Victory();
	}

	public boolean run(Runnable matchProvider) {
		return victory.run(this, matchProvider);
	}

	@Override
	public ITGGMatch chooseOneMatch(ImmutableMatchContainer matchContainer) {
		
		DataPackage dataPackage = this.createDataPackage(matchContainer.getMatches());
		
		victory.updateUI(new DataPackageAdapter(dataPackage), null);
		
		ITGGMatch chosenMatch;
		
		//check if breakpoint is hit by the current match-set
		boolean breakpointHit = victory.checkBreakpointsBeforeMatchSelection(new DataPackageAdapter(dataPackage));
		if(breakpointHit)
			System.out.println("Breakpoint hit for found matches");
		
		
		switch(victory.getDebuggerMode()) {
			case RUN:
				chosenMatch = chooseMatchAutomatically(matchContainer, dataPackage);
				break;
			case STEP:
				chosenMatch = chooseMatchDebugger(matchContainer, dataPackage);
				break;
			default:
				throw new IllegalStateException("The debugger is in unhandled state:"+victory.getDebuggerMode());
		}
		
		System.out.println("Applying match of rule: "+chosenMatch.getRuleName());
		
		this.setPreviouslyAppliedRule(chosenMatch.getRuleName());
		
		return chosenMatch;
	}
	
	private ITGGMatch chooseMatchAutomatically(ImmutableMatchContainer matchContainer, DataPackage dataPackage) {
		ITGGMatch chosenMatch = this.automaticUpdatePolicy.chooseOneMatch(matchContainer);
		Match autoChosenMatch = IbexMatchAdapter.adapt(this.getIbexMatchForTggMatch(chosenMatch));
		System.out.println("Match of rule "+chosenMatch.getRuleName()+" automatically chosen.");
		boolean breakpointHit = victory.checkBreakpointsAfterMatchSelection(new DataPackageAdapter(dataPackage), autoChosenMatch);
		if(breakpointHit) {
			System.out.println("Breakpoint hit for chosen match of rule "+chosenMatch.getRuleName());
		}
		victory.updateUI(new DataPackageAdapter(dataPackage), autoChosenMatch);
		if(victory.getDebuggerMode() == DebuggerMode.STEP) {
//			victory.updateUI(new DataPackageAdapter(dataPackage), autoChosenMatch);
			return this.chooseMatchDebugger(matchContainer, dataPackage);
		}
		return chosenMatch;
	}
	
	private ITGGMatch chooseMatchDebugger(ImmutableMatchContainer matchContainer, DataPackage dataPackage) {
		System.out.println("Asking the user to choose a match.");
		
		Match uiChosenMatch = victory.selectMatch();
		
		if(uiChosenMatch == null) {
			// skipped match selection -> select automatically
			return this.chooseMatchAutomatically(matchContainer, dataPackage);
		}
		
		if (uiChosenMatch instanceof IbexMatchAdapter)
			return ((IbexMatchAdapter) uiChosenMatch).getWrappedMatch().getIMatch();
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

}
