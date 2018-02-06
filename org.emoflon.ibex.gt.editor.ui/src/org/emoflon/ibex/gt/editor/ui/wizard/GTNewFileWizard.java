package org.emoflon.ibex.gt.editor.ui.wizard;

import com.google.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * The wizard for creating a new .gt file.
 */
public class GTNewFileWizard extends Wizard implements INewWizard {
	private static final String GT_FILE_WIZARD_TITLE = "New eMoflon Graph Transformation Project";
	private static final String GT_FILE_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation Project.";

	private WizardNewFileCreationPage mainPage;
	private IStructuredSelection selection;

	@Inject
	private GTNewFileInitialContents initialContents;

	@Inject
	public GTNewFileWizard() {
		super();
		this.setWindowTitle(GT_FILE_WIZARD_TITLE);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	@Override
	public void addPages() {
		mainPage = new WizardNewFileCreationPage(GT_FILE_WIZARD_TITLE, this.selection);
		mainPage.setTitle(GT_FILE_WIZARD_TITLE);
		mainPage.setDescription(GT_FILE_WIZARD_DESCRIPTION);
		mainPage.setFileExtension("gt");
		this.addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		initialContents.initFileContent(file);
		return file != null;
	}
}
