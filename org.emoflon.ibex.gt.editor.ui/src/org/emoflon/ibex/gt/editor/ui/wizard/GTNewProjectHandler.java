package org.emoflon.ibex.gt.editor.ui.wizard;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler opening a GTNewProjectWizard.
 */
public class GTNewProjectHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		try {
			IWorkbenchWizard wizard = window.getWorkbench().getNewWizardRegistry()
					.findWizard(GTNewProjectWizard.PROJECT_WIZARD_ID).createWizard();
			wizard.init(window.getWorkbench(), null);
			WizardDialog dialog = new WizardDialog(window.getShell(), wizard);
			dialog.open();
		} catch (final Exception e) {
			Logger.getRootLogger().info("Cannot init New Graph Transformation Project Wizard");
		}
		return null;
	}
}
