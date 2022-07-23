package org.emoflon.ibex.tgg.editor.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.INewWizard;
import org.emoflon.ibex.tgg.editor.defaults.DefaultFilesHelper;
import org.moflon.core.ui.UiUtilities;
import org.moflon.core.utilities.WorkspaceHelper;

public class NewTGGRuleWizard extends AbstractMoflonWizard implements INewWizard {

	public static final String NEW_TGG_RULE_WIZARD_ID = "org.emoflon.ibex.tgg.editor.ui.newTGGRule";

	protected NewTGGRuleProjectInfoPage projectInfo;

	@Override
	public void addPages() {
		projectInfo = new NewTGGRuleProjectInfoPage();
		addPage(projectInfo);
	}

	@Override
	protected void doFinish(IProgressMonitor monitor) throws CoreException {
		IProject project = projectInfo.getRuleLocation().getProject();
		String ruleContent = DefaultFilesHelper.generateDefaultRule(projectInfo.getSchema(), projectInfo.getRuleName());
		IPath pathToFile = projectInfo.getRuleLocation().getProjectRelativePath().append(projectInfo.getRuleName())
				.addFileExtension("tgg");
		WorkspaceHelper.addAllFoldersAndFile(project, pathToFile, ruleContent, SubMonitor.convert(monitor).newChild(1));

		IFile file = project.getFile(pathToFile);

		UiUtilities.openDefaultEditorForFile(file);
	}

}
