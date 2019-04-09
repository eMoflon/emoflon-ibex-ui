package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.ui.debug.plantuml.VictoryPlantUMLGenerator;

import language.TGGRule;
import net.miginfocom.swt.MigLayout;
import net.sourceforge.plantuml.SourceStringReader;

public class MatchDisplayView extends Composite implements IVisualiser {

    private IVictoryDataProvider dataProvider;

    private Label imageContainer;

    private MatchDisplayView(Composite parent, IVictoryDataProvider pDataProvider) {
	super(parent, SWT.NONE);
	setLayout(new MigLayout("fill"));

	dataProvider = pDataProvider;
    }

    private MatchDisplayView build() {
	imageContainer = new Label(this, SWT.BORDER | SWT.CENTER);
	imageContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	imageContainer.setLayoutData("grow");
	imageContainer.setImage(null);
	imageContainer.pack();

	pack();
	return this;
    }

    public static MatchDisplayView create(Composite pParent, IVictoryDataProvider pDataProvider) {
	return new MatchDisplayView(pParent, pDataProvider).build();
    }

    @Override
    public void display(String pRuleName) {

	TGGRule rule = dataProvider.getRule(pRuleName);

	if (rule == null)
	    throw new IllegalArgumentException("Unknown rule");

	displayPlantUMLString(VictoryPlantUMLGenerator.visualiseTGGRule(rule));
    }

    @Override
    public void display(IMatch pMatch) {

	TGGRule rule = dataProvider.getRule(pMatch.getRuleName());

	if (rule == null)
	    throw new IllegalArgumentException("Unknown rule");

	displayPlantUMLString(VictoryPlantUMLGenerator.visualiseMatch(pMatch, rule));
    }

    private void displayPlantUMLString(String pPlantUMLString) {
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	try {
	    new SourceStringReader(pPlantUMLString).outputImage(outputStream);
	} catch (IOException pIOE) {
	    // TODO what do I do here?
	}

	imageContainer.setImage(new Image(Display.getCurrent(), new ByteArrayInputStream(outputStream.toByteArray())));
    }
}
