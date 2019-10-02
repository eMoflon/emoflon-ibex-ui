package org.emoflon.ibex.tgg.ui.debug.views;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.RuleApplication;
import org.emoflon.ibex.tgg.ui.debug.core.IExitCodeReceiver;
import org.emoflon.ibex.tgg.ui.debug.core.VictoryUI;
import org.emoflon.ibex.tgg.ui.debug.options.UserOptionsManager;
import org.emoflon.ibex.tgg.ui.debug.util.ModelLocationDialog;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.MatchVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.RuleApplicationVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.RuleVisualisation;
import org.emoflon.ibex.tgg.ui.debug.views.visualisable.VisualisableElement;

public class MatchDisplayView extends Composite implements IVisualiser {

    private IExitCodeReceiver exitCodeReceiver;
    private DataProvider dataProvider;
    private UserOptionsManager userOptionsManager;
    private UserOptionsMenu userOptionsMenu;

    private ScrolledComposite imageScroller;
    private Label imageContainer;
    
    private Map<Rule, VisualisableElement> ruleCache = new HashMap<>();
    private Map<Match, VisualisableElement> matchCache = new HashMap<>();
    private Map<Collection<RuleApplication>, VisualisableElement> ruleApplicationCache = new HashMap<>();

    private VisualisableElement currentElement;
	private Button userOptionsMenuButton;
	private Button saveModelsButton;
	private Button restartButton;
	private Button terminateButton;

    private MatchDisplayView(Composite parent, IExitCodeReceiver pExitCodeReceiver, DataProvider pDataProvider,
	    UserOptionsManager pUserOptionsManager) {
	super(parent, SWT.NONE);

	exitCodeReceiver = pExitCodeReceiver;
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
	buttonRow.setLayout(new GridLayout(4, false));

	userOptionsMenuButton = new Button(buttonRow, SWT.PUSH);
	userOptionsMenuButton.setText("User Options");
	userOptionsMenuButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	userOptionsMenuButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		userOptionsMenu.show();
	    }
	});

	saveModelsButton = new Button(buttonRow, SWT.PUSH);
	saveModelsButton.setText("Save Models");
	saveModelsButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
	saveModelsButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		new ModelLocationDialog(new String[] { "src model save location", //
			"trg model save location", //
			"corr model save location", //
			"protocol save location" }, //
			dataProvider.getDefaultSaveData(), //
			"Save All", //
			saveLocations -> {
			    try {
				dataProvider.saveModels(saveLocations);
			    } catch (IOException e) {
				throw new IllegalArgumentException("Save Models has a problem.");
			    }
			}).build(VictoryUI.getDisplay().getActiveShell());
	    }
	});

	restartButton = new Button(buttonRow, SWT.PUSH);
	restartButton.setText("Restart");
	restartButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	restartButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		exitCodeReceiver.exit(true);
	    }
	});

	terminateButton = new Button(buttonRow, SWT.PUSH);
	terminateButton.setText("Quit");
	terminateButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	terminateButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent pSelectionEvent) {
		exitCodeReceiver.exit(false);
	    }
	});

	userOptionsMenu = new UserOptionsMenu(userOptionsManager, this);
	userOptionsMenu.build(getShell());
	this.updateToolTips();
	pack();
	return this;
    }

    public static MatchDisplayView create(Composite pParent, IExitCodeReceiver pExitCodeReceiver,
	    DataProvider pDataProvider, UserOptionsManager pUserOptionsManager) {
	return new MatchDisplayView(pParent, pExitCodeReceiver, pDataProvider, pUserOptionsManager).build();
    }

    /*
     * display specific code
     */


    @Override
    public void display(Rule pRule) {

	if (!ruleCache.containsKey(pRule))
	    ruleCache.put(pRule, new RuleVisualisation(pRule, userOptionsManager, dataProvider));

	currentElement = ruleCache.get(pRule);

	refresh();
    }

    @Override
    public void display(Match pMatch) {

	if (!matchCache.containsKey(pMatch))
	    matchCache.put(pMatch, new MatchVisualisation(pMatch, userOptionsManager, dataProvider));

	currentElement = matchCache.get(pMatch);

	refresh();
    }

    @Override
    public void display(Collection<RuleApplication> pRuleApplications) {

	if (!ruleApplicationCache.containsKey(pRuleApplications))
	    ruleApplicationCache.put(pRuleApplications,
		    new RuleApplicationVisualisation(pRuleApplications, userOptionsManager, dataProvider));

	currentElement = ruleApplicationCache.get(pRuleApplications);
	refresh();
    }

    @Override
    public void refresh() {
		if(currentElement == null)
		    return;
	
		if (userOptionsManager.isInvalid()) {
		    ruleCache.values().forEach(VisualisableElement::invalidate);
		    matchCache.values().forEach(VisualisableElement::invalidate);
		    ruleApplicationCache.values().forEach(VisualisableElement::invalidate);
		    currentElement.invalidate();
		    userOptionsManager.revalidate();
		}
	
		displayImage(currentElement.getImage());
    }
    
    public void updateToolTips() {
    	userOptionsMenuButton.setToolTipText(ToolTips.MATCHDISPLAY_USEROPTION_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
    	terminateButton.setToolTipText(ToolTips.MATCHDISPLAY_TERMINATE_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
    	restartButton.setToolTipText(ToolTips.MATCHDISPLAY_RESTART_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
    	saveModelsButton.setToolTipText(ToolTips.MATCHDISPLAY_SAVE_MODELS_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
    	imageContainer.setToolTipText(ToolTips.MATCHDISPLAY_IMAGECONTAINER.getDescription(userOptionsManager.getToolTipSetting()));
    }

    private void displayImage(byte[] pImageData) {
	Image image = new Image(Display.getCurrent(), new ByteArrayInputStream(pImageData));
	imageScroller.setMinSize(image.getBounds().width, image.getBounds().height);
	imageContainer.setImage(image);
    }
}
