package org.emoflon.ibex.gt.gtl.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.moflon.core.ui.UiUtilities;

import com.google.inject.Inject;

/**
 * The wizard for creating a new .gtl file.
 */
public class GTLNewFileWizard extends Wizard implements INewWizard {
	public static final String GTL_FILE_WIZARD_ID = "org.emoflon.ibex.gt.gtl.ui.wizard.GTLNewFileWizard";
	private static final String GTL_FILE_WIZARD_TITLE = "New eMoflon Graph Transformation File";
	private static final String GTL_FILE_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation File.";

	private WizardNewFileCreationPage mainPage;
	private IStructuredSelection selection;

	@Inject
	private GTLNewFileInitialContents initialContents;

	@Inject
	FileExtensionProvider fileExtensionProvider;

	public GTLNewFileWizard() {
		super();
		this.setWindowTitle(GTL_FILE_WIZARD_TITLE);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		if (selection == null) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			ISelection sel = window.getSelectionService().getSelection();
			if (sel instanceof IStructuredSelection) {
				this.selection = (IStructuredSelection) window.getSelectionService().getSelection();
			}
		}
	}

	@Override
	public void addPages() {
		mainPage = new WizardNewFileCreationPage(GTL_FILE_WIZARD_TITLE, this.selection);
		mainPage.setTitle(GTL_FILE_WIZARD_TITLE);
		mainPage.setDescription(GTL_FILE_WIZARD_DESCRIPTION);
		mainPage.setFileExtension(fileExtensionProvider.getPrimaryFileExtension());
		this.addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		initialContents.initFileContent(file);
		UiUtilities.openDefaultEditorForFile(file);
		return file != null;
	}
}
