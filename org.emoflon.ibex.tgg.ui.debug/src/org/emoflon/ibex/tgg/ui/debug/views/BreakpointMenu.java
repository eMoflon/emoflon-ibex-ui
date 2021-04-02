package org.emoflon.ibex.tgg.ui.debug.views;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint.BreakpointEvaluationTime;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.BreakpointManager;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.AttributeConditionBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint.CombinationType;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint.EvaluationType;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CreatedTypeBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.NumberOfMatchesBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.RulenameBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.options.IUserOptions;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.breakpointList.BreakpointContentManager;
import org.emoflon.ibex.tgg.ui.debug.views.treeContent.breakpointList.BreakpointNode;

public class BreakpointMenu {
	
	private Shell menuShell;
	private final IUserOptions userOptions;
	private final BreakpointManager breakpointManager;
	private TreeViewer treeViewer;
	private BreakpointContentManager contentManager;
	private Composite breakpointConfigurationComposite;
	private DataProvider dataProvider;
	
	private Set<MenuItem> addBreakpointMenuItems = new HashSet<MenuItem>();
	private Set<MenuItem> removeBreakpointMenuItems = new HashSet<MenuItem>();

	public BreakpointMenu(IUserOptions userOptions, BreakpointManager breakpointManager, DataProvider dataProvider) {
		this.userOptions = userOptions;
		this.breakpointManager = breakpointManager;
		this.contentManager = new BreakpointContentManager(userOptions);
		this.breakpointManager.setBreakpointMenu(this);
		this.dataProvider = dataProvider;
	}
	
	public void updateBreakpoints(Collection<Breakpoint> breakpoints) {
		this.contentManager.populate(breakpoints);
		if(this.treeViewer != null) {
			this.treeViewer.refresh();
		}
	}
	
	public void build(Shell parentShell) {
		menuShell = new Shell(parentShell, SWT.DIALOG_TRIM);
		menuShell.setText("Breakpoint Menu");
		menuShell.setLayout(new GridLayout(1, false));
		menuShell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent pEvent) {
				pEvent.doit = false;
				hide();
			}
		});
		
		treeViewer = new TreeViewer(this.menuShell, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.SINGLE);
		treeViewer.setContentProvider(contentManager.getTreeContentManager());
		treeViewer.setLabelProvider(contentManager.getTreeContentManager().getCellLabelProvider());
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 10;
		gridData.minimumHeight = 500;
		gridData.minimumWidth = 500;
		treeViewer.getControl().setLayoutData(gridData);
		treeViewer.setInput("root");
		
		final Menu treeMenu = new Menu(treeViewer.getTree());
		treeViewer.getTree().setMenu(treeMenu);
		
		Menu menuBar = new Menu(this.menuShell, SWT.BAR);
		this.menuShell.setMenuBar(menuBar);
		
		MenuItem addMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		addMenuHeader.setText("Add");
		Menu addMenu = new Menu(this.menuShell, SWT.DROP_DOWN);
		addMenuHeader.setMenu(addMenu);
		this.addBreakpointMenuItems.add(addMenuHeader);
		
		MenuItem addRuleNameBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		MenuItem addRuleNameBreakpointMenuBar = new MenuItem(addMenu, SWT.PUSH);
		addRuleNameBreakpointTreeMenu.setText("Add rule name breakpoint");
		addRuleNameBreakpointMenuBar.setText("Add rule name breakpoint");
		this.addBreakpointMenuItems.add(addRuleNameBreakpointTreeMenu);
		this.addBreakpointMenuItems.add(addRuleNameBreakpointMenuBar);
		
		SelectionListener selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				RulenameBreakpoint breakpointToAdd = new RulenameBreakpoint("");
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		}; 
		addRuleNameBreakpointTreeMenu.addSelectionListener(selectionListener);
		addRuleNameBreakpointMenuBar.addSelectionListener(selectionListener);
		
		MenuItem addNumberOfMatchesBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		MenuItem addNumberOfMatchesBreakpointMenuBar = new MenuItem(addMenu, SWT.PUSH);
		this.addBreakpointMenuItems.add(addNumberOfMatchesBreakpointTreeMenu);
		this.addBreakpointMenuItems.add(addNumberOfMatchesBreakpointMenuBar);
		addNumberOfMatchesBreakpointTreeMenu.setText("Add number of matches breakpoint");
		addNumberOfMatchesBreakpointMenuBar.setText("Add number of matches breakpoint");
		selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				NumberOfMatchesBreakpoint breakpointToAdd = new NumberOfMatchesBreakpoint(1000);
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		};
		addNumberOfMatchesBreakpointTreeMenu.addSelectionListener(selectionListener);
		addNumberOfMatchesBreakpointMenuBar.addSelectionListener(selectionListener);
		
		MenuItem addCreatedTypeBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		MenuItem addCreatedTypeBreakpointMenuBar = new MenuItem(addMenu, SWT.PUSH);
		this.addBreakpointMenuItems.add(addCreatedTypeBreakpointMenuBar);
		this.addBreakpointMenuItems.add(addCreatedTypeBreakpointTreeMenu);
		addCreatedTypeBreakpointTreeMenu.setText("Add created type breakpoint");
		addCreatedTypeBreakpointMenuBar.setText("Add created type breakpoint");
		selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				CreatedTypeBreakpoint breakpointToAdd = new CreatedTypeBreakpoint("");
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		};
		addCreatedTypeBreakpointTreeMenu.addSelectionListener(selectionListener);
		addCreatedTypeBreakpointMenuBar.addSelectionListener(selectionListener);
		
		MenuItem addAttibuteConditionBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		MenuItem addAttibuteConditionBreakpointMenuBar = new MenuItem(addMenu, SWT.PUSH);
		this.addBreakpointMenuItems.add(addAttibuteConditionBreakpointTreeMenu);
		this.addBreakpointMenuItems.add(addAttibuteConditionBreakpointMenuBar);
		addAttibuteConditionBreakpointTreeMenu.setText("Add attribute condition breakpoint");
		addAttibuteConditionBreakpointMenuBar.setText("Add attribute condition breakpoint");
		selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				AttributeConditionBreakpoint attributeConditionBreakpoint = new AttributeConditionBreakpoint();
				handleAddingOfBreakpoint(attributeConditionBreakpoint);
			}
		};
		addAttibuteConditionBreakpointTreeMenu.addSelectionListener(selectionListener);
		addAttibuteConditionBreakpointMenuBar.addSelectionListener(selectionListener);
		
		MenuItem addCombinationBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		MenuItem addCombinationBreakpointMenuBar = new MenuItem(addMenu, SWT.PUSH);
		this.addBreakpointMenuItems.add(addCombinationBreakpointTreeMenu);
		this.addBreakpointMenuItems.add(addCombinationBreakpointMenuBar);
		addCombinationBreakpointTreeMenu.setText("Add combined breakpoint");
		addCombinationBreakpointMenuBar.setText("Add combined breakpoint");
		selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				CombinedBreakpoint breakpointToAdd = new CombinedBreakpoint(CombinationType.AND);
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		};
		addCombinationBreakpointTreeMenu.addSelectionListener(selectionListener);
		addCombinationBreakpointMenuBar.addSelectionListener(selectionListener);
		
		//TODO add other breakpoint types
		
		MenuItem removeMenuHeader = new MenuItem(menuBar, SWT.PUSH);
		removeMenuHeader.setText("Remove");
		removeMenuHeader.setEnabled(false);
		this.removeBreakpointMenuItems.add(removeMenuHeader);
		
		MenuItem removeBreakpointTreeMenu = new MenuItem(treeMenu, SWT.PUSH);
		this.removeBreakpointMenuItems.add(removeBreakpointTreeMenu);
		removeBreakpointTreeMenu.setText("Remove breakpoint");
		removeBreakpointTreeMenu.setEnabled(false);
		selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				if(treeViewer.getSelection() instanceof IStructuredSelection) {
					BreakpointNode selectedElement = (BreakpointNode) treeViewer.getStructuredSelection().getFirstElement();
					if(selectedElement != null) {
						handleRemovingOfBreakpoint(selectedElement);
					}
				}
			}
		};
		removeMenuHeader.addSelectionListener(selectionListener);
		removeBreakpointTreeMenu.addSelectionListener(selectionListener);
		
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent pEvent) {
				breakpointConfigurationComposite.dispose();
				breakpointConfigurationComposite = new Composite(menuShell, SWT.NORMAL);
				menuShell.pack();				
				
				if (pEvent.getSelection() instanceof IStructuredSelection) {
					BreakpointNode selectedElement = (BreakpointNode) pEvent.getStructuredSelection().getFirstElement();
					handleActivationOfMenuItems(selectedElement);
					if(selectedElement == null) {
						return;
					}
					breakpointConfigurationComposite.dispose();
					if(selectedElement.getBreakpoint() instanceof RulenameBreakpoint) {
						breakpointConfigurationComposite = new RuleNameBreakpointConfiguration(menuShell, SWT.NORMAL);
						((RuleNameBreakpointConfiguration) breakpointConfigurationComposite).build((RulenameBreakpoint) selectedElement.getBreakpoint(), selectedElement, dataProvider.getAllRules());
					} else if(selectedElement.getBreakpoint() instanceof CreatedTypeBreakpoint) {
						breakpointConfigurationComposite = new CreatedTypeBreakpointConfiguration(menuShell, SWT.NORMAL);
						((CreatedTypeBreakpointConfiguration) breakpointConfigurationComposite).build((CreatedTypeBreakpoint) selectedElement.getBreakpoint(), selectedElement, dataProvider.getAllRules());
					} else if(selectedElement.getBreakpoint() instanceof NumberOfMatchesBreakpoint) {
						breakpointConfigurationComposite = new NumberOfMatchesBreakpointConfiguration(menuShell, SWT.NORMAL);
						((NumberOfMatchesBreakpointConfiguration) breakpointConfigurationComposite).build((NumberOfMatchesBreakpoint) selectedElement.getBreakpoint(), selectedElement, dataProvider.getAllRules());
					} else if(selectedElement.getBreakpoint() instanceof CombinedBreakpoint) {
						breakpointConfigurationComposite = new CombinedBreakpointConfiguration(menuShell, SWT.NORMAL);
						((CombinedBreakpointConfiguration) breakpointConfigurationComposite).build((CombinedBreakpoint) selectedElement.getBreakpoint(), selectedElement);
					}  else if(selectedElement.getBreakpoint() instanceof AttributeConditionBreakpoint) {
						breakpointConfigurationComposite = new AttributeConditionBreakpointConfiguration(menuShell, SWT.NORMAL);
						((AttributeConditionBreakpointConfiguration) breakpointConfigurationComposite).build((AttributeConditionBreakpoint) selectedElement.getBreakpoint(), selectedElement, dataProvider.getAllRules());
					} 
					//TODO other breakpoint types need to be added here
					menuShell.pack(true);
				}
				
			}
		});
		
		
		breakpointConfigurationComposite = new Composite(this.menuShell, SWT.NORMAL);
		
		menuShell.pack();
		menuShell.open();
		menuShell.setVisible(false);
	}
	
	private void handleActivationOfMenuItems(BreakpointNode selectedNode) {
		boolean addingAllowed = false;
		boolean removingAllowed = false;
		if(selectedNode == null) {
			addingAllowed = true;
			removingAllowed = false;
		} else {
			removingAllowed = true;
			if(selectedNode.getParent() instanceof BreakpointNode) {
				addingAllowed = (selectedNode.getBreakpoint() instanceof CombinedBreakpoint);
			} else {
				//root breakpoint
				addingAllowed = true;
			}
		}
		
		for(MenuItem add : this.addBreakpointMenuItems) {
			add.setEnabled(addingAllowed);
		}
		for(MenuItem remove : this.removeBreakpointMenuItems) {
			remove.setEnabled(removingAllowed);
		}
	}
	
	
	
	private void handleAddingOfBreakpoint(Breakpoint breakpointToAdd) {
		if(treeViewer.getSelection() instanceof IStructuredSelection) {
			BreakpointNode selectedElement = (BreakpointNode) treeViewer.getStructuredSelection().getFirstElement();
			if(selectedElement != null && selectedElement.getBreakpoint() instanceof CombinedBreakpoint) {
				breakpointManager.addBreakpoint(breakpointToAdd, selectedElement.getBreakpoint());
				treeViewer.expandToLevel(selectedElement, 1);
				return;
			}
		}
		breakpointManager.addTopLevelBreakpoint(breakpointToAdd);
	}
	
	private void handleRemovingOfBreakpoint(BreakpointNode selected) {
		Breakpoint parent = null;
		Breakpoint breakpointToRemove = selected.getBreakpoint();
		if(selected.getParent() != null && selected.getParent() instanceof BreakpointNode) {
			parent = ((BreakpointNode) selected.getParent()).getBreakpoint();
		}
		breakpointManager.removeBreakpoint(breakpointToRemove, parent);
	}
	
	public void show() {
		treeViewer.refresh();
		menuShell.setVisible(true);
	}
	
	public void hide() {
		menuShell.setVisible(false);
	}
	
	private abstract class BreakpointConfigurationComposite extends Composite {

		private BreakpointConfigurationComposite(Composite parent, int style) {
			super(parent, style);
		}
		
		void build(Breakpoint breakpoint, BreakpointNode selectedElement) {
			this.setLayout(new GridLayout(1, false));
			
			Group evaluationTimeGroup = new Group(this, SWT.NONE);
			evaluationTimeGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			evaluationTimeGroup.setLayout(new GridLayout());
			evaluationTimeGroup.setText("Breakpoint evaluation time");
			
			if(selectedElement.getParent() instanceof BreakpointNode) {
				//this is a combined breakpoint; only on/off possible
				Button enabledButton = new Button(evaluationTimeGroup, SWT.CHECK);
				enabledButton.setText("Enabled");
				enabledButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
				enabledButton.setSelection(breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.ALWAYS);
				enabledButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent pSelectionEvent) {
						if (enabledButton.getSelection()) {
							breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.ALWAYS);
						} else {
							breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.OFF);
						}
						treeViewer.refresh(selectedElement, true);
					}
				});
			} else {
				Button foundMatchesButton = new Button(evaluationTimeGroup, SWT.CHECK);
				foundMatchesButton.setText("After pattern matcher found matches");
				foundMatchesButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
				foundMatchesButton.setSelection(breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.FOUND_MATCHES || breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.ALWAYS);
				
				Button selectedMatchButton = new Button(evaluationTimeGroup, SWT.CHECK);
				selectedMatchButton.setText("After automatic match selection");
				selectedMatchButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
				selectedMatchButton.setSelection(breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.MATCH_SELECTED || breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.ALWAYS);
				
				if(selectedElement.getBreakpoint() instanceof NumberOfMatchesBreakpoint) {
					selectedMatchButton.setEnabled(false);
				}
				
				SelectionListener selectionListener =
						new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent pSelectionEvent) {
						if (foundMatchesButton.getSelection()) {
							if(selectedMatchButton.getSelection()) {
								breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.ALWAYS);
							} else {
								breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.FOUND_MATCHES);
							}
							
						} else {
							if(selectedMatchButton.getSelection()) {
								breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.MATCH_SELECTED);
							} else {
								breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.OFF);
							}
						}
						foundMatchesButton.setSelection(breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.FOUND_MATCHES || breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.ALWAYS);
						selectedMatchButton.setSelection(breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.MATCH_SELECTED || breakpoint.getBreakpointEvaluationTime() == BreakpointEvaluationTime.ALWAYS);
						treeViewer.refresh(selectedElement, true);
					}
				};
				selectedMatchButton.addSelectionListener(selectionListener);
				foundMatchesButton.addSelectionListener(selectionListener);
				
			}
		}
	}
	
	private class RuleNameBreakpointConfiguration extends BreakpointConfigurationComposite {

		private RuleNameBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(RulenameBreakpoint breakpoint, BreakpointNode selectedElement, Collection<Rule> rules) {
			super.build(breakpoint, selectedElement);
			
			Group ruleGroup = new Group(this, SWT.NONE);
			ruleGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			ruleGroup.setLayout(new GridLayout());
			ruleGroup.setText("Rule");
			
			Combo ruleSelectionBox = new Combo(ruleGroup, SWT.READ_ONLY | SWT.DROP_DOWN);
			int index = 0;
			int selectedIndex = -1;
			for(Rule r: rules) {
				ruleSelectionBox.add(r.getName());
				if(r.getName().equals(breakpoint.getRuleName())) {
					selectedIndex = index;
				}
				index++;
			}
			if(selectedIndex >= 0) {
				ruleSelectionBox.select(selectedIndex);
			}
			
			ruleSelectionBox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = ruleSelectionBox.getSelectionIndex();
					String ruleName = ruleSelectionBox.getItem(index);
					breakpoint.setRuleName(ruleName);
					treeViewer.refresh(selectedElement, true);
				}
			});
		}
	}
	
	private class AttributeConditionBreakpointConfiguration extends BreakpointConfigurationComposite {

		private AttributeConditionBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(AttributeConditionBreakpoint breakpoint, BreakpointNode selectedElement, Collection<Rule> rules) {
			super.build(breakpoint, selectedElement);
			
			Group ruleGroup = new Group(this, SWT.NONE);
			ruleGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			ruleGroup.setLayout(new GridLayout());
			ruleGroup.setText("Rule");
			
			Combo ruleSelectionBox = new Combo(ruleGroup, SWT.READ_ONLY | SWT.DROP_DOWN);
			int index = 0;
			int selectedIndex = -1;
			for(Rule r: rules) {
				ruleSelectionBox.add(r.getName());
				if(breakpoint.getRule() != null && r.getName().equals(breakpoint.getRule().getName())) {
					selectedIndex = index;
				}
				index++;
			}
			if(selectedIndex >= 0) {
				ruleSelectionBox.select(selectedIndex);
			}
			
			Group attributeConditionGroup = new Group(this, SWT.NONE);
			attributeConditionGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			attributeConditionGroup.setLayout(new GridLayout());
			attributeConditionGroup.setText("Attribute condition");
			
			Text textbox = new Text(attributeConditionGroup, SWT.SINGLE);
			textbox.setText(breakpoint.getAttributeCondition());
			
			Text errorbox = new Text(attributeConditionGroup, SWT.MULTI);
			errorbox.setEditable(false);
			errorbox.setText(breakpoint.getLastError());
			
			textbox.addKeyListener(new KeyListener() {
				
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.character == '\n' || e.character == '\r') {
						breakpoint.setAttributeCondition(textbox.getText());
						errorbox.setText(breakpoint.getLastError());
						errorbox.pack(true);
						treeViewer.refresh(selectedElement, true);
						breakpointConfigurationComposite.pack(true);
						breakpointConfigurationComposite.getParent().pack(true);
					}
				}
				
				@Override
				public void keyPressed(KeyEvent e) {}
			});
			textbox.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					breakpoint.setAttributeCondition(textbox.getText());
					errorbox.setText(breakpoint.getLastError());
					errorbox.pack(true);
					treeViewer.refresh(selectedElement, true);
					breakpointConfigurationComposite.pack(true);
					breakpointConfigurationComposite.getParent().pack(true);
				}
				
				@Override
				public void focusGained(FocusEvent e) {}
			});
			
			ruleSelectionBox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = ruleSelectionBox.getSelectionIndex();
					String ruleName = ruleSelectionBox.getItem(index);
					for(Rule rule : rules) {
						if(rule.getName().equals(ruleName)) {
							breakpoint.setRule(rule);
						}
					}
					errorbox.setText(breakpoint.getLastError());
					errorbox.pack(true);
					treeViewer.refresh(selectedElement, true);
					breakpointConfigurationComposite.pack(true);
					breakpointConfigurationComposite.getParent().pack(true);
				}
			});
		}
	}
	
	private class NumberOfMatchesBreakpointConfiguration extends BreakpointConfigurationComposite {
		private NumberOfMatchesBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(NumberOfMatchesBreakpoint breakpoint, BreakpointNode selectedElement, Collection<Rule> rules) {
			super.build(breakpoint, selectedElement);
			
			Group limitGroup = new Group(this, SWT.NONE);
			limitGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			limitGroup.setLayout(new GridLayout());
			limitGroup.setText("Number of matches");
			
			Spinner spinner = new Spinner(limitGroup, SWT.NORMAL);
			spinner.setValues(breakpoint.getLimit(), 0, Integer.MAX_VALUE, 0, 1, 10);
			spinner.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					breakpoint.setLimit(spinner.getSelection());
					treeViewer.refresh(selectedElement, true);
				}
			});
			
			Group rulesGroup = new Group(this, SWT.NONE);
			rulesGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			rulesGroup.setLayout(new GridLayout());
			rulesGroup.setText("Rules to count matches of");			
			
			org.eclipse.swt.widgets.List rulesList = new org.eclipse.swt.widgets.List(rulesGroup, SWT.MULTI);
			
			for(Rule r: rules) {
				rulesList.add(r.getName());
			}
			rulesList.setSelection(breakpoint.getRules());
			
			rulesList.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					breakpoint.setRules(rulesList.getSelection());					
					treeViewer.refresh(selectedElement, true);
				}
			});
		}
	}
	
	private class CombinedBreakpointConfiguration extends BreakpointConfigurationComposite {
		private CombinedBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(CombinedBreakpoint breakpoint, BreakpointNode selectedElement) {
			super.build(breakpoint, selectedElement);
			
			Group combinationTypeGroup = new Group(this, SWT.NONE);
			combinationTypeGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			combinationTypeGroup.setLayout(new GridLayout());
			combinationTypeGroup.setText("Combination Type");
			
			Group evaluationTypeGroup = new Group(this, SWT.NONE);
			evaluationTypeGroup.setVisible(breakpoint.getCombinationType() == CombinationType.AND);
			evaluationTypeGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			evaluationTypeGroup.setLayout(new GridLayout());
			evaluationTypeGroup.setText("Evaluation Type");
			
			Button andButton = new Button(combinationTypeGroup, SWT.RADIO);
			andButton.setText("AND");
			andButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			andButton.setSelection(breakpoint.getCombinationType() == CombinationType.AND);
			andButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent pSelectionEvent) {
					if (andButton.getSelection()) {
						breakpoint.setCombinationType(CombinationType.AND);
						evaluationTypeGroup.setVisible(true);
						treeViewer.refresh(selectedElement, true);
					}
				}
			});
			
			Button orButton = new Button(combinationTypeGroup, SWT.RADIO);
			orButton.setText("OR");
			orButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			orButton.setSelection(breakpoint.getCombinationType() == CombinationType.OR);
			orButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent pSelectionEvent) {
					if (orButton.getSelection()) {
						breakpoint.setCombinationType(CombinationType.OR);
						evaluationTypeGroup.setVisible(false);
						treeViewer.refresh(selectedElement, true);
					}
				}
			});
			
			Button combined = new Button(evaluationTypeGroup, SWT.RADIO);
			combined.setText("Break, if for all breakpoints a match can be found.");
			combined.setToolTipText("Each breakpoint is evaluated on all matches, then the results are combined by AND/OR");
			combined.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			combined.setSelection(breakpoint.getEvaluationType() == EvaluationType.COMPLETE);
			combined.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent pSelectionEvent) {
					if (combined.getSelection()) {
						breakpoint.setEvaluationType(EvaluationType.COMPLETE);
						treeViewer.refresh(selectedElement, true);
					}
				}
			});
			
			Button per_Match = new Button(evaluationTypeGroup, SWT.RADIO);
			per_Match.setText("Break, if a single match satisfies all breakpoints.");
			per_Match.setToolTipText("For every match evaluate each breakpoint and combine the result by AND/OR");
			per_Match.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			per_Match.setSelection(breakpoint.getEvaluationType() == EvaluationType.PER_MATCH);
			per_Match.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent pSelectionEvent) {
					if (per_Match.getSelection()) {
						breakpoint.setEvaluationType(EvaluationType.PER_MATCH);
						treeViewer.refresh(selectedElement, true);
					}
				}
			});
		}
	}
	
	private class CreatedTypeBreakpointConfiguration extends BreakpointConfigurationComposite {

		private CreatedTypeBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(CreatedTypeBreakpoint breakpoint, BreakpointNode selectedElement, Collection<Rule> rules) {
			super.build(breakpoint, selectedElement);
			
			Group typeGroup = new Group(this, SWT.NONE);
			typeGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			typeGroup.setLayout(new GridLayout());
			typeGroup.setText("Type of created element");
			
			Combo typeSelectionBox = new Combo(typeGroup, SWT.READ_ONLY | SWT.DROP_DOWN);
			
			Set<String> types = new HashSet<String>();
			
			for(Rule r: rules) {
				for(Node n: r.getGraph().getNodes()) {
					types.add(n.getType());
				}
				for(Edge e: r.getGraph().getEdges()) {
					types.add(e.getType().name());
				}
			}
			
			List<String> sortedTypes = types.stream().collect(Collectors.toList());
			Collections.sort(sortedTypes);
			
			int index = 0;
			int selectedIndex = -1;
			for(String type : sortedTypes) {
				typeSelectionBox.add(type);
				if(type.equals(breakpoint.getType())) {
					selectedIndex = index;
				}
				index++;
			}
				
			if(selectedIndex >= 0) {
				typeSelectionBox.select(selectedIndex);
			}
			
			typeSelectionBox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = typeSelectionBox.getSelectionIndex();
					String type = typeSelectionBox.getItem(index);
					breakpoint.setType(type);
					treeViewer.refresh(selectedElement, true);
				}
			});
			this.pack();
		}
	}
}
