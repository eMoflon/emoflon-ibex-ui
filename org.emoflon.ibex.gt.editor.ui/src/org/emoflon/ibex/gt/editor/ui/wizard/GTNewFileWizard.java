package org.emoflon.ibex.gt.editor.ui.wizard;

import com.google.inject.Inject;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.emoflon.ibex.common.editor.utils.IBeXWorkspaceHelper;
import org.emoflon.ibex.gt.editor.ui.builder.GTNature;
import org.moflon.core.ui.UiUtilities;
import org.moflon.core.utilities.LogUtils;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * The wizard for creating a new .gt file.
 */
public class GTNewFileWizard extends Wizard implements INewWizard {
	private static final Logger logger = Logger.getLogger(GTNewFileWizard.class);

	public static final String GT_FILE_WIZARD_ID = "org.emoflon.ibex.gt.editor.ui.wizard.GTNewFileWizard";
	private static final String GT_FILE_WIZARD_TITLE = "New eMoflon Graph Transformation File";
	private static final String GT_FILE_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation File.";

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
		mainPage = new WizardNewFileCreationPage(GT_FILE_WIZARD_TITLE, this.selection);
		mainPage.setTitle(GT_FILE_WIZARD_TITLE);
		mainPage.setDescription(GT_FILE_WIZARD_DESCRIPTION);
		mainPage.setFileExtension("gt");
		this.addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		try {
			IBeXWorkspaceHelper.addFirstProjectNature(file.getProject(), GTNature.NATURE_ID, null);
		} catch (CoreException e) {
			LogUtils.error(logger, String.format("Could not add nature %s to project %s.", GTNature.NATURE_ID,
					file.getProject().getName()));
		}
		initialContents.initFileContent(file);
		UiUtilities.openDefaultEditorForFile(file);
		return file != null;
	}
}
