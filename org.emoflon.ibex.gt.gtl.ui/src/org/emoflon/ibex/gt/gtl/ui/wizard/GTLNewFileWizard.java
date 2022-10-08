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
import org.moflon.core.ui.UiUtilities;

/**
 * The wizard for creating a new .gtl file.
 */
public class GTLNewFileWizard extends Wizard implements INewWizard {
	public static final String GTL_FILE_WIZARD_ID = "org.emoflon.ibex.gt.gtl.ui.wizard.GTLNewFileWizard";
	private static final String GTL_FILE_WIZARD_TITLE = "New eMoflon Graph Transformation File";
	private static final String GTL_FILE_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation File.";

	private WizardNewFileCreationPage mainPage;
	private IStructuredSelection selection;

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
		mainPage.setFileExtension(".gtl");
		this.addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		String pkg = "";
		StringBuilder sb = new StringBuilder();
		String[] fqn = file.getLocation().toPortableString().toString().split("src/");
		if (fqn.length != 2) {
			pkg = "replace me!";
		} else {
			String[] segments = fqn[1].split("/");
			for (String seg : segments) {
				if (seg.contains(".gtl"))
					break;

				sb.append(seg + ".");
			}
		}

		pkg = sb.toString();
		if (pkg.length() < 1) {
			pkg = "replace me!";
		} else if (pkg.length() > 0 && pkg.endsWith(".")) {
			pkg = pkg.substring(0, pkg.length() - 1);
		}

		GTLNewFileInitialContents.initFileContent(file, pkg);
		UiUtilities.openDefaultEditorForFile(file);
		return file != null;
	}
}
