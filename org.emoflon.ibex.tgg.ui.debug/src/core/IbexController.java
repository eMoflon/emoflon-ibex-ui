package core;

import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.matches.ImmutableMatchContainer;
import org.emoflon.ibex.tgg.operational.monitoring.VictoryMonitor.IMatchChooser;

import views.MatchListView;

public class IbexController implements IMatchChooser {

    private MatchListView matchListView; // TODO convert to interface

    public IbexController(MatchListView pMatchListView) {
	matchListView = pMatchListView;
    }

    @Override
    public IMatch chooseOneMatch(ImmutableMatchContainer pMatchContainer) {
	IbexDebugUI.DISPLAY.syncExec(() -> matchListView.display(pMatchContainer.getMatches()));

	return matchListView.getChosenMatch();
    }

    @Override
    public void matchHasBeenApplied(IMatch match) {
	// don't care about this yet
	// TODO implement later
    }
}
