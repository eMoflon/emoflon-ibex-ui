package org.emoflon.ibex.gt.editor.ui.wizard;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;

import com.google.inject.Inject;

/**
 * The wizard for creating a new GT project.
 */
public class GTNewProjectWizard extends XtextNewProjectWizard {
	public static final String PROJECT_WIZARD_ID = "org.emoflon.ibex.gt.editor.ui.wizard.GTNewProjectWizard";
	public static final String PROJECT_WIZARD_TITLE = "New eMoflon Graph Transformation Project";
	public static final String PROJECT_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation Project.";

	protected WizardNewProjectCreationPage mainPage;

	@Inject
	public GTNewProjectWizard(final GTProjectCreator projectCreator) {
		super(projectCreator);
		this.setWindowTitle(PROJECT_WIZARD_TITLE);
	}

	@Override
	public void addPages() {
		// A page containing a form with project name and location.
		mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");
		mainPage.setTitle(PROJECT_WIZARD_TITLE);
		mainPage.setDescription(PROJECT_WIZARD_DESCRIPTION);
		this.addPage(mainPage);
	}

	@Override
	protected IExtendedProjectInfo getProjectInfo() {
		DefaultProjectInfo projectInfo = new DefaultProjectInfo();
		projectInfo.setProjectName(mainPage.getProjectName());
		if (!mainPage.useDefaults()) {
			projectInfo.setLocationPath(mainPage.getLocationPath());
		}
		return projectInfo;
	}
}
