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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.emoflon.ibex.tgg.ui.debug.api.DataProvider;
import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.Breakpoint.BreakpointEvaluationTime;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.BreakpointManager;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.impl.CombinedBreakpoint.CombinationType;
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
		menuShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.ON_TOP);
		menuShell.setText("Breakpoint Menu");
		menuShell.setLayout(new GridLayout(1, false));
		menuShell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent pEvent) {
				pEvent.doit = false;
				menuShell.setVisible(false);
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
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent pEvent) {
				breakpointConfigurationComposite.dispose();
				breakpointConfigurationComposite = new Composite(menuShell, SWT.NORMAL);
				menuShell.pack();				
				
				if (pEvent.getSelection() instanceof IStructuredSelection) {
					BreakpointNode selectedElement = (BreakpointNode) pEvent.getStructuredSelection().getFirstElement();
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
						((NumberOfMatchesBreakpointConfiguration) breakpointConfigurationComposite).build((NumberOfMatchesBreakpoint) selectedElement.getBreakpoint(), selectedElement);
					} else if(selectedElement.getBreakpoint() instanceof CombinedBreakpoint) {
						breakpointConfigurationComposite = new CombinedBreakpointConfiguration(menuShell, SWT.NORMAL);
						((CombinedBreakpointConfiguration) breakpointConfigurationComposite).build((CombinedBreakpoint) selectedElement.getBreakpoint(), selectedElement);
					}
					//TODO other breakpoint types need to be added here
					menuShell.pack(true);
				}
				
			}
		});
		
		final Menu treeMenu = new Menu(treeViewer.getTree());
		treeViewer.getTree().setMenu(treeMenu);
		//TODO menu items for tree menu
		MenuItem addRuleNameBreakpoint = new MenuItem(treeMenu, SWT.PUSH);
		addRuleNameBreakpoint.setText("Add rule name breakpoint");
		addRuleNameBreakpoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				RulenameBreakpoint breakpointToAdd = new RulenameBreakpoint("");
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		});
		
		MenuItem addNumberOfMatchesBreakpoint = new MenuItem(treeMenu, SWT.PUSH);
		addNumberOfMatchesBreakpoint.setText("Add number of matches breakpoint");
		addNumberOfMatchesBreakpoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				NumberOfMatchesBreakpoint breakpointToAdd = new NumberOfMatchesBreakpoint(1000);
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		});
		
		MenuItem addCreatedTypeBreakpoint = new MenuItem(treeMenu, SWT.PUSH);
		addCreatedTypeBreakpoint.setText("Add created type breakpoint");
		addCreatedTypeBreakpoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				CreatedTypeBreakpoint breakpointToAdd = new CreatedTypeBreakpoint("");
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		});
		
		MenuItem addCombinationBreakpoint = new MenuItem(treeMenu, SWT.PUSH);
		addCombinationBreakpoint.setText("Add combined breakpoint");
		addCombinationBreakpoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				CombinedBreakpoint breakpointToAdd = new CombinedBreakpoint(CombinationType.AND);
				handleAddingOfBreakpoint(breakpointToAdd);
			}
		});
		
		//TODO add other breakpoint types
		
		MenuItem removeBreakpoint = new MenuItem(treeMenu, SWT.PUSH);
		removeBreakpoint.setText("Remove breakpoint");
		removeBreakpoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent pSelectionEvent) {
				if(treeViewer.getSelection() instanceof IStructuredSelection) {
					BreakpointNode selectedElement = (BreakpointNode) treeViewer.getStructuredSelection().getFirstElement();
					if(selectedElement != null) {
						handleRemovingOfBreakpoint(selectedElement);
					}
				}
			}
		});
		
		breakpointConfigurationComposite = new Composite(this.menuShell, SWT.NORMAL);
		
		menuShell.pack();
		menuShell.open();
		menuShell.setVisible(false);
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
	
	private abstract class BreakpointConfigurationComposite extends Composite {

		private BreakpointConfigurationComposite(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(Breakpoint breakpoint, BreakpointNode selectedElement) {
			this.setLayout(new GridLayout(1, false));
			
			Group evaluationTimeGroup = new Group(this, SWT.NONE);
			evaluationTimeGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			evaluationTimeGroup.setLayout(new GridLayout());
			evaluationTimeGroup.setText("Breakpoint evaluation time");
			
			Combo evaluationTimeComboBox = new Combo(evaluationTimeGroup, SWT.READ_ONLY | SWT.DROP_DOWN);
			
			evaluationTimeComboBox.add("Always");
			evaluationTimeComboBox.add("Disabled");
			evaluationTimeComboBox.add("After automatic match selection");
			evaluationTimeComboBox.add("After pattern matcher found matches");
			
			switch(breakpoint.getBreakpointEvaluationTime()) {
				case ALWAYS : evaluationTimeComboBox.select(0); break;
				case OFF: evaluationTimeComboBox.select(1); break;
				case MATCH_SELECTED: evaluationTimeComboBox.select(2); break;
				case FOUND_MATCHES: evaluationTimeComboBox.select(3); break;
			}
			
			evaluationTimeComboBox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = evaluationTimeComboBox.getSelectionIndex();
					switch(index) {
						case 0: breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.ALWAYS); break;
						case 1: breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.OFF); break;
						case 2: breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.MATCH_SELECTED); break;
						case 3: breakpoint.setBreakpointEvaluationTime(BreakpointEvaluationTime.FOUND_MATCHES); break;
					}
					treeViewer.refresh(selectedElement, true);
				}
			});
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
	
	private class NumberOfMatchesBreakpointConfiguration extends BreakpointConfigurationComposite {
		private NumberOfMatchesBreakpointConfiguration(Composite parent, int style) {
			super(parent, style);
		}
		
		private void build(NumberOfMatchesBreakpoint breakpoint, BreakpointNode selectedElement) {
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
			//TODO selection of rules
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
			
			Button andButton = new Button(combinationTypeGroup, SWT.RADIO);
			andButton.setText("AND");
			andButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			andButton.setSelection(breakpoint.getCombinationType() == CombinationType.AND);
			andButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent pSelectionEvent) {
					if (andButton.getSelection()) {
						breakpoint.setCombinationType(CombinationType.AND);
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
			
			//TODO sort types
			
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
