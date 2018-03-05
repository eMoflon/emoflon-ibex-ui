package org.emoflon.ibex.gt.editor.ui.wizard;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.moflon.core.ui.UiUtilities;

/**
 * Handler opening a GTNewProjectWizard.
 */
public class GTNewProjectHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		try {
			UiUtilities.openWizard(GTNewProjectWizard.PROJECT_WIZARD_ID, window);
		} catch (final Exception e) {
			Logger.getRootLogger().info("Cannot init New Graph Transformation Project Wizard");
		}
		return null;
	}
}
