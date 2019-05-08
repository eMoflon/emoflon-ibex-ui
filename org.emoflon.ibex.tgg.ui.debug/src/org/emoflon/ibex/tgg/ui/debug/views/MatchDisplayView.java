package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.IMatchVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.TGGRuleVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.VisualisableElement;

import net.miginfocom.swt.MigLayout;

public class MatchDisplayView extends Composite implements IVisualiser {

    private IVictoryDataProvider dataProvider;
    private UserOptionsManager userOptionsManager;

    private Label imageContainer;

    private MatchDisplayView(Composite parent, IVictoryDataProvider pDataProvider,
	    UserOptionsManager pUserOptionsManager) {
	super(parent, SWT.NONE);
	setLayout(new MigLayout("fill"));

	dataProvider = pDataProvider;
	userOptionsManager = pUserOptionsManager;
    }

    private MatchDisplayView build() {
	setLayout(new MigLayout("fill"));

	imageContainer = new Label(this, SWT.BORDER | SWT.CENTER);
	imageContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	imageContainer.setLayoutData("grow");
	imageContainer.setImage(null);
	imageContainer.pack();

	Button toggleFullRuleVisButton = new Button(this, SWT.TOGGLE);
	toggleFullRuleVisButton.setText("Full rule Vis");
	toggleFullRuleVisButton.setLayoutData("dock north");
	toggleFullRuleVisButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayFullRuleForMatches(toggleFullRuleVisButton.getSelection());
		refresh();
	    }
	});

	pack();
	return this;
    }

    public static MatchDisplayView create(Composite pParent, IVictoryDataProvider pDataProvider,
	    UserOptionsManager pUserOptionsManager) {
	return new MatchDisplayView(pParent, pDataProvider, pUserOptionsManager).build();
    }

    /*
     * display specific code
     */

    private Map<String, VisualisableElement> ruleElementMap = new HashMap<>();
    private Map<IMatch, VisualisableElement> matchElementMap = new HashMap<>();

    private VisualisableElement currentElement;

    @Override
    public void display(String pRuleName) {

	if (!ruleElementMap.containsKey(pRuleName)) {
	    VisualisableElement ruleElement = new TGGRuleVisualisation(dataProvider.getRule(pRuleName),
		    userOptionsManager);
	    ruleElementMap.put(pRuleName, ruleElement);
	}

	currentElement = ruleElementMap.get(pRuleName);

	refresh();
    }

    @Override
    public void display(IMatch pMatch) {

	if (!matchElementMap.containsKey(pMatch)) {
	    VisualisableElement matchElement = new IMatchVisualisation(pMatch, dataProvider, userOptionsManager);
	    matchElementMap.put(pMatch, matchElement);
	}

	currentElement = matchElementMap.get(pMatch);

	refresh();
    }

    @Override
    public void refresh() {
	if (userOptionsManager.isInvalid()) {
	    ruleElementMap.values().forEach(VisualisableElement::invalidate);
	    matchElementMap.values().forEach(VisualisableElement::invalidate);
	    userOptionsManager.revalidate();
	}

	displayImage(currentElement.getImage());
    }

    private void displayImage(byte[] pImageData) {
	imageContainer.setImage(new Image(Display.getCurrent(), new ByteArrayInputStream(pImageData)));
    }
}
