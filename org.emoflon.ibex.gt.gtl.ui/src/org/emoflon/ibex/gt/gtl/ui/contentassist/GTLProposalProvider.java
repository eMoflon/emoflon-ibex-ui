/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.ui.contentassist;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.util.GTLResourceManager;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class GTLProposalProvider extends AbstractGTLProposalProvider {

	protected GTLResourceManager manager = new GTLResourceManager();

	@Override
	public void completePackageDeclaration_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completePackageDeclaration_Name(model, assignment, context, acceptor);

		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(model.eResource());

		String[] lines = context.getCurrentNode().getText().split("\n");
		lines = lines[0].split("\r");

		String currentSelection = lines[0];
		String rest = context.getCurrentNode().getText().replace(lines[0], "");

		File currentFile = null;
		String location = null;
		StringBuilder pkgBuilder = null;
		try {
			String fileUri = model.eResource().getURI().toString().replace("platform:/resource/", "")
					.replace(currentProject.getName(), "");
			fileUri = currentProject.getLocation().toPortableString() + fileUri;
			currentFile = new File(fileUri).getCanonicalFile();
			location = currentFile.getCanonicalPath().replace("\\", "/");

			String relativeLocation = location.replace(currentProject.getLocation().toPortableString(), "");
			String[] segments = relativeLocation.split("/");
			pkgBuilder = new StringBuilder();
			int idx = -1;
			for (String segment : segments) {
				idx++;
				if (segment == null || segment.isBlank() || segment.isEmpty())
					continue;

				if (segment.equals("src") || segment.equals("bin"))
					continue;

				if (idx <= segments.length - 2) {
					pkgBuilder.append(segment);
					pkgBuilder.append(".");
				} else {
					pkgBuilder.append(segment.replace(".gtl", ""));
				}

			}
		} catch (Exception e) {
			return;
		}

		String pkgName = pkgBuilder.toString();

		if (!currentSelection.isBlank() && !pkgName.contains(currentSelection))
			return;

		int start = (currentSelection.isBlank()) ? 0 : currentSelection.length() + 1;
		pkgName = pkgName.substring(start);
		int cursor = pkgName.length();
		pkgName = pkgName + rest;

		int replacementLength = (currentSelection.isBlank() && context.getCurrentNode().getText().length() > 1)
				? context.getCurrentNode().getText().length() - currentSelection.length() - 1
				: context.getCurrentNode().getText().length() - currentSelection.length();

		acceptor.accept(new CompletionProposal(pkgName.toLowerCase(), context.getOffset(), replacementLength, cursor));
	}

	@Override
	public void completePatternImport_File(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completePatternImport_File(model, assignment, context, acceptor);

		EditorFile currentEF = SlimGTModelUtil.getContainer(model, EditorFile.class);
		Collection<EditorFile> otherEFs = manager.loadAllEditorFilesInWorkspaceNotInPackage(currentEF);

		String[] lines = context.getCurrentNode().getText().split("\n");
		lines = lines[0].split("\r");

		String currentSelection = lines[0].replace("\"", "").replace("/", "\\").trim().replace("%20", " ");
		String rest = context.getCurrentNode().getText().replace(lines[0], "");

		for (EditorFile other : otherEFs) {
			String replacement = "\"" + other.eResource().getURI().toString() + "\"";
			int start = (currentSelection.isBlank()) ? 0 : currentSelection.length() + 1;
			replacement = replacement.substring(start);
			int cursor = replacement.length();
			replacement = replacement + rest;

			int replacementLength = (currentSelection.isBlank())
					? context.getCurrentNode().getText().length() - currentSelection.length() - 1
					: context.getCurrentNode().getText().length() - currentSelection.length();

			acceptor.accept(new CompletionProposal(replacement, context.getOffset(), replacementLength, cursor));
		}

	}

}
