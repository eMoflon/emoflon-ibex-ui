package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.emoflon.ibex.tgg.operational.matches.IMatch;
import org.emoflon.ibex.tgg.operational.monitoring.IVictoryDataProvider;
import org.emoflon.ibex.tgg.operational.monitoring.data.TGGObjectGraph;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager.VisualizationLabelOptions;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.IMatchVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.ObjectGraphVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.TGGRuleVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.VisualisableElement;

import language.TGGRule;

public class MatchDisplayView extends Composite implements IVisualiser {

    private IVictoryDataProvider dataProvider;
    private UserOptionsManager userOptionsManager;

    private ScrolledComposite imageScroller;
    private Label imageContainer;

    private MatchDisplayView(Composite parent, IVictoryDataProvider pDataProvider,
	    UserOptionsManager pUserOptionsManager) {
	super(parent, SWT.NONE);

	dataProvider = pDataProvider;
	userOptionsManager = pUserOptionsManager;
    }

    private MatchDisplayView build() {
	setLayout(new GridLayout());

	imageScroller = new ScrolledComposite(this, SWT.H_SCROLL | SWT.V_SCROLL);
	imageScroller.setLayoutData(new GridData(GridData.FILL_BOTH));
	imageScroller.setExpandHorizontal(true);
	imageScroller.setExpandVertical(true);
	imageScroller.setAlwaysShowScrollBars(true);

	imageContainer = new Label(imageScroller, SWT.BORDER | SWT.CENTER);
	imageContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	imageContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
	imageContainer.setImage(null);
	imageContainer.pack();

	imageScroller.setContent(imageContainer);

	Composite buttonRow = new Composite(this, SWT.NONE);
	buttonRow.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	buttonRow.setLayout(new GridLayout(5, false));

	Button toggleFullRuleVisButton = new Button(buttonRow, SWT.TOGGLE);
	toggleFullRuleVisButton.setText("Full Vis");
	toggleFullRuleVisButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	toggleFullRuleVisButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setDisplayFullRuleForMatches(toggleFullRuleVisButton.getSelection());
		refresh();
	    }
	});

	Combo selectCorrVisualizationComboBox = new Combo(buttonRow, SWT.READ_ONLY);
	toggleFullRuleVisButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	final String[] corrVisualizationOptions = new String[] { "Show Corr Labels", "Show abbreviated Corr Labels",
		"Hide Corr Labels" };
	for (String option : corrVisualizationOptions) {
	    selectCorrVisualizationComboBox.add(option);
	}
	switch (userOptionsManager.getCorrLabelVisualization()) {
	case FULLNAME:
	    selectCorrVisualizationComboBox.select(0);
	    break;
	case ABBREVIATED:
	    selectCorrVisualizationComboBox.select(1);
	    break;
	case NONE:
	    selectCorrVisualizationComboBox.select(2);
	    break;
	}
	selectCorrVisualizationComboBox.addSelectionListener(new SelectionListener() {

	    private VisualizationLabelOptions getSelectedVisualization(String selectedVisualization) {
		if (selectedVisualization.equals(corrVisualizationOptions[0])) {
		    return VisualizationLabelOptions.FULLNAME;
		} else if (selectedVisualization.equals(corrVisualizationOptions[1])) {
		    return VisualizationLabelOptions.ABBREVIATED;
		} else if (selectedVisualization.equals(corrVisualizationOptions[2])) {
		    return VisualizationLabelOptions.NONE;
		} else {
		    throw new RuntimeException("Unknown visualization option: " + selectedVisualization);
		}
	    }

	    @Override
	    public void widgetSelected(SelectionEvent e) {
		userOptionsManager
			.setCorrLabelVisualization(getSelectedVisualization(selectCorrVisualizationComboBox.getText()));
		refresh();
	    }

	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
		userOptionsManager
			.setCorrLabelVisualization(getSelectedVisualization(selectCorrVisualizationComboBox.getText()));
		refresh();
	    }
	});

	Scale neighborhoodScale = new Scale(buttonRow, SWT.HORIZONTAL);
	neighborhoodScale.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	neighborhoodScale.setMinimum(0);
	neighborhoodScale.setPageIncrement(1);
	neighborhoodScale.setMaximum(3);
	neighborhoodScale.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsManager.setNeighborhoodSize(neighborhoodScale.getSelection());
	    }
	});

	Button saveModelsButton = new Button(buttonRow, SWT.PUSH);
	saveModelsButton.setText("Save Models");
	saveModelsButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
	saveModelsButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		try {
		    dataProvider.saveModels();
		} catch (IOException e) {
		    throw new IllegalArgumentException("Save Models has a problem.");
		}
	    }
	});

	Button terminateButton = new Button(buttonRow, SWT.PUSH);
	terminateButton.setText("Quit Debugger");
	terminateButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	terminateButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		System.exit(0);
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

    private Map<TGGRule, VisualisableElement> ruleElementMap = new HashMap<>();
    private Map<IMatch, VisualisableElement> matchElementMap = new HashMap<>();

    private VisualisableElement currentElement;

    @Override
    public void display(TGGRule pRule) {

	if (!ruleElementMap.containsKey(pRule)) {
	    VisualisableElement ruleElement = new TGGRuleVisualisation(pRule, userOptionsManager);
	    ruleElementMap.put(pRule, ruleElement);
	}

	currentElement = ruleElementMap.get(pRule);

	refresh();
    }

    @Override
    public void display(IMatch pMatch) {

	if (!matchElementMap.containsKey(pMatch)) {
	    VisualisableElement matchElement = new IMatchVisualisation(pMatch, dataProvider, userOptionsManager);
	    matchElementMap.put(pMatch, matchElement);
	}

	refresh();
    }

    @Override
    public void display(TGGObjectGraph pObjectGraph) {
	currentElement = new ObjectGraphVisualisation(pObjectGraph, dataProvider);
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
	Image image = new Image(Display.getCurrent(), new ByteArrayInputStream(pImageData));
	imageScroller.setMinSize(image.getBounds().width, image.getBounds().height);
	imageContainer.setImage(image);
    }
}
