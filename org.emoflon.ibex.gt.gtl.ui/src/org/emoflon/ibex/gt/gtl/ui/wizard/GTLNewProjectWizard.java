package org.emoflon.ibex.gt.gtl.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.util.FileOpener;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The wizard for creating a new GT project.
 */
public class GTLNewProjectWizard extends XtextNewProjectWizard {
	public static final String PROJECT_WIZARD_ID = "org.emoflon.ibex.gt.gtl.ui.GTLProjectWizard";
	public static final String PROJECT_WIZARD_TITLE = "New eMoflon Graph Transformation Project";
	public static final String PROJECT_WIZARD_DESCRIPTION = "Create a new eMoflon Graph Transformation Project.";

	protected WizardNewProjectCreationPage mainPage;

	protected static final Logger logger = Logger.getLogger(GTLNewProjectWizard.class);
	protected IProjectCreator creator;

	public GTLNewProjectWizard() {
		super(new GTLProjectCreator());
		this.creator = super.getCreator();
		this.setWindowTitle(PROJECT_WIZARD_TITLE);
	}

	@Override
	protected void doFinish(final IProjectInfo projectInfo, final IProgressMonitor monitor) {
		try {
			creator.setProjectInfo(projectInfo);
			creator.run(monitor);
			Injector injector = Guice.createInjector(new AbstractModule() {
				@Override
				protected void configure() {
					bind(IWorkbench.class).toProvider(() -> PlatformUI.getWorkbench());
				}
			});
			FileOpener fileOpener = injector.getInstance(FileOpener.class);
			fileOpener.selectAndReveal(creator.getResult());
			fileOpener.openFileToEdit(getShell(), creator.getResult());
		} catch (final InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		} catch (final InterruptedException e) {
			// cancelled by user, ok
			return;
		}
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
