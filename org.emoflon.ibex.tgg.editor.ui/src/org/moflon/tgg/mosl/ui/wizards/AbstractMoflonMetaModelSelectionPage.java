package org.moflon.tgg.mosl.ui.wizards;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.ui.editor.outline.quickoutline.StringMatcher;

public abstract class AbstractMoflonMetaModelSelectionPage extends WizardPage {
	protected String message;
	protected Label label;
	protected Text textField;
	protected TableViewer tableViewer;
	protected ViewerFilter filter;
	protected String filterPattern;
	protected Object[] selectedMetaModels;

	public AbstractMoflonMetaModelSelectionPage(String name, String title, String desc, String message) {
		super(name);
		this.message = message;
		filterPattern = "*";
		// Set information on the page
		setTitle(title);
		setDescription(desc);
		setImageDescriptor(AbstractMoflonWizard.getImage("resources/icons/metamodelProjectWizard.gif"));
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout1 = new GridLayout();
		container.setLayout(layout1);
		label = new Label(container, SWT.NONE);
		textField = new Text(container, SWT.BORDER | SWT.SINGLE);
		final GridData gd1 = new GridData();
		gd1.verticalAlignment = GridData.FILL;
		gd1.heightHint = 300;
		gd1.horizontalAlignment = GridData.FILL;
		gd1.grabExcessHorizontalSpace = true;
		gd1.grabExcessVerticalSpace = true;
		final GridData gd2 = new GridData();
		gd2.verticalAlignment = GridData.FILL;
		gd2.horizontalAlignment = GridData.FILL;
		gd2.heightHint = 15;
		gd2.grabExcessHorizontalSpace = true;
		gd2.grabExcessVerticalSpace = false;
		label.setLayoutData(gd2);
		textField.setLayoutData(gd2);
		// Place cursor in textfield
		textField.setFocus();
		Composite listContainer = new Composite(container, SWT.NONE);
		FillLayout layout2 = new FillLayout(SWT.VERTICAL);
		listContainer.setLayout(layout2);
		listContainer.setLayoutData(gd1);
		label.setText(message);
		tableViewer = new TableViewer(listContainer);
		filter = new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element == null) {
					return false;
				}
				String modelUri = element.toString();
				StringMatcher filterMatcher = new StringMatcher(filterPattern, true);
				return filterMatcher.match(modelUri);
			}
		};

		initTextField();
		initTableViewer();

		// set control
		setControl(container);
		setPageComplete(false);
	}

	protected void initTableViewer() {
		tableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				return ExtendedImageRegistry.getInstance()
						.getImage(EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage"));
			}
		});

		tableViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return (Object[]) inputElement;
			}
		});

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				selectedMetaModels = selection.toArray();
				if (selectedMetaModels == null || selectedMetaModels.length < 1) {
					return;
				}

				setPageComplete(true);
			}
		});

		Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true);
		Object[] result = ePackageNsURItoGenModelLocationMap.keySet()
				.toArray(new Object[ePackageNsURItoGenModelLocationMap.size()]);
		Arrays.sort(result);

		tableViewer.setInput(result);
		tableViewer.addFilter(filter);
	}

	protected void initTextField() {
		textField.setText("*");
		textField.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text t = (Text) (e.widget);
				if (!t.isFocusControl()) {
					return;
				}

				else {
					String text = t.getText();
					if (text.length() > 0) {
						filterPattern = text;
						tableViewer.resetFilters();
						tableViewer.addFilter(filter);
					}
				}

			}
		});
	}

	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		// Place cursor in textfield
		textField.setFocus();

		// Reset selection and filter pattern
		if (selectedMetaModels == null) {
			textField.setText("*");
			tableViewer.resetFilters();
			tableViewer.getTable().deselectAll();
		}
	}

	public Object[] getSelectedMetaModels() {
		return selectedMetaModels;
	}

	public void setSelectedMetaModels(Object[] selectedMetaModels) {
		this.selectedMetaModels = selectedMetaModels;
	}
}