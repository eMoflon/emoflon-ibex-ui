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
import org.emoflon.ibex.tgg.ui.debug.api.enums.DebuggerMode;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.BreakpointManager;
import org.emoflon.ibex.tgg.ui.debug.core.IDebugModeUpdater;
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
	private IDebugModeUpdater debugModeUpdater;
	private DataProvider dataProvider;
	private UserOptionsManager userOptionsManager;
	private UserOptionsMenu userOptionsMenu;
	
	private BreakpointManager breakpointManager;
	private BreakpointMenu breakpointMenu;

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
	private Button runButton;
	private Button stepButton;
	private Button configureBreakpointsButton;

	private MatchDisplayView(Composite parent, IExitCodeReceiver exitCodeReceiver, IDebugModeUpdater debugModeUpdater, DataProvider dataProvider,
			UserOptionsManager userOptionsManager, BreakpointManager breakpointManager) {
		super(parent, SWT.NONE);

		this.exitCodeReceiver = exitCodeReceiver;
		this.dataProvider = dataProvider;
		this.userOptionsManager = userOptionsManager;
		this.breakpointManager = breakpointManager;
		this.debugModeUpdater = debugModeUpdater;
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
		buttonRow.setLayout(new GridLayout(7, false));

		userOptionsMenuButton = new Button(buttonRow, SWT.PUSH);
		userOptionsMenuButton.setText("User Options");
		userOptionsMenuButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		userOptionsMenuButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				userOptionsMenu.show();
			}
		});
		
		runButton = new Button(buttonRow, SWT.PUSH);
		runButton.setText("Run");
		runButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		runButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				switch (debugModeUpdater.getDebuggerMode()) {
					case RUN:
						debugModeUpdater.setDebuggerMode(DebuggerMode.STEP);
						break;
					case STEP:
						debugModeUpdater.setDebuggerMode(DebuggerMode.RUN);
						break;
					default:
						break;
					}
				}
		});
		stepButton = new Button(buttonRow, SWT.PUSH);
		stepButton.setText("Step");
		stepButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		stepButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				debugModeUpdater.step();
			}
		});
		
		configureBreakpointsButton = new Button(buttonRow, SWT.PUSH);
		configureBreakpointsButton.setText("Configure Breakpoints");
		configureBreakpointsButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		configureBreakpointsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				breakpointMenu.show();
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
		
		breakpointMenu = new BreakpointMenu(userOptionsManager, breakpointManager, dataProvider);
		breakpointMenu.build(getShell());
		
		this.updateToolTips();
		pack();
		return this;
	}

	public static MatchDisplayView create(Composite parent, IExitCodeReceiver exitCodeReceiver, IDebugModeUpdater debugModeUpdater,
			DataProvider dataProvider, UserOptionsManager userOptionsManager, BreakpointManager breakpointManager) {
		return new MatchDisplayView(parent, exitCodeReceiver, debugModeUpdater, dataProvider, userOptionsManager, breakpointManager).build();
	}

	/*
	 * display specific code
	 */

	@Override
	public void display(Rule rule) {

		if (!ruleCache.containsKey(rule))
			ruleCache.put(rule, new RuleVisualisation(rule, userOptionsManager, dataProvider));

		currentElement = ruleCache.get(rule);

		refresh();
	}

	@Override
	public void display(Match match) {

		if (!matchCache.containsKey(match))
			matchCache.put(match, new MatchVisualisation(match, userOptionsManager, dataProvider));

		currentElement = matchCache.get(match);

		refresh();
	}

	@Override
	public void display(Collection<RuleApplication> ruleApplications) {

		if (!ruleApplicationCache.containsKey(ruleApplications))
			ruleApplicationCache.put(ruleApplications,
					new RuleApplicationVisualisation(ruleApplications, userOptionsManager, dataProvider));

		currentElement = ruleApplicationCache.get(ruleApplications);
		refresh();
	}

	@Override
	public void refresh() {
		if (currentElement == null)
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
		userOptionsMenuButton.setToolTipText(
				ToolTips.MATCHDISPLAY_USEROPTION_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
		terminateButton.setToolTipText(
				ToolTips.MATCHDISPLAY_TERMINATE_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
		restartButton.setToolTipText(
				ToolTips.MATCHDISPLAY_RESTART_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
		saveModelsButton.setToolTipText(
				ToolTips.MATCHDISPLAY_SAVE_MODELS_BUTTON.getDescription(userOptionsManager.getToolTipSetting()));
		imageContainer.setToolTipText(
				ToolTips.MATCHDISPLAY_IMAGECONTAINER.getDescription(userOptionsManager.getToolTipSetting()));
	}
	
	public void updateDebuggerMode() {
		DebuggerMode newDebuggerMode = debugModeUpdater.getDebuggerMode();
		switch(newDebuggerMode) {
		case RUN:
			this.runButton.setText("Break");
			this.stepButton.setEnabled(false);
			this.configureBreakpointsButton.setEnabled(false);
			this.breakpointMenu.hide();
			break;
		case STEP:
			this.runButton.setText("Run");
			this.stepButton.setEnabled(true);
			this.configureBreakpointsButton.setEnabled(true);
			break;
		}
	}

	private void displayImage(byte[] imageData) {
		Image image = new Image(Display.getCurrent(), new ByteArrayInputStream(imageData));
		imageScroller.setMinSize(image.getBounds().width, image.getBounds().height);
		imageContainer.setImage(image);
	}
}
