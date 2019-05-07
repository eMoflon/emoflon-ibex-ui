package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
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
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;
import net.miginfocom.swt.MigLayout;
import net.sourceforge.plantuml.SourceStringReader;

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

    private Map<String, byte[]> ruleImageCache = new HashMap<>();
    private Map<IMatch, byte[]> matchImageCache = new HashMap<>();

    @Override
    public void display(String pRuleName) {

	TGGRule rule = dataProvider.getRule(pRuleName);

	if (rule == null)
	    throw new IllegalArgumentException("Unknown rule");

	byte[] image;
	if (ruleImageCache.containsKey(pRuleName)) {
	    image = ruleImageCache.get(pRuleName);
	} else {
	    image = generatePlantUMLImage(VictoryPlantUMLGenerator.visualiseTGGRule(rule));
	    ruleImageCache.put(pRuleName, image);
	}
	displayImage(image);
    }

    @Override
    public void display(IMatch pMatch) {

	TGGRule rule = dataProvider.getRule(pMatch.getRuleName());
	Collection<EObject> matchNeighborhood = dataProvider.getMatchNeighbourhood(pMatch, 1);

	if (rule == null)
	    throw new IllegalArgumentException("Unknown rule");

	byte[] image;
	if (matchImageCache.containsKey(pMatch)) {
	    image = matchImageCache.get(pMatch);
	} else {
	    image = generatePlantUMLImage(
		    VictoryPlantUMLGenerator.visualiseMatch(pMatch, rule, matchNeighborhood, userOptionsManager));
	    matchImageCache.put(pMatch, image);
	}
	displayImage(image);
    }

    private byte[] generatePlantUMLImage(String pPlantUMLString) {
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	try {
	    new SourceStringReader(pPlantUMLString).outputImage(outputStream);
	} catch (IOException pIOE) {
	    // TODO what do I do here?
	}
	return outputStream.toByteArray();
    }

    private void displayImage(byte[] pImageData) {
	imageContainer.setImage(new Image(Display.getCurrent(), new ByteArrayInputStream(pImageData)));
    }
}
