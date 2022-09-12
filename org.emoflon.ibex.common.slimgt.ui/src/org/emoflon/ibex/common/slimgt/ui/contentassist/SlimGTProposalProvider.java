/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.common.slimgt.ui.contentassist;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtils;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class SlimGTProposalProvider extends AbstractSlimGTProposalProvider {
	@Override
	public void completeImport_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeImport_Name(model, assignment, context, acceptor);

		String[] lines = context.getCurrentNode().getText().split("\n");
		lines = lines[0].split("\r");

		String currentSelection = lines[0];
		String rest = context.getCurrentNode().getText().replace(lines[0], "");

		// Search through workspace for ecore files, in case those are not in the global
		// registry.
		Map<String, EPackage> path2model = new HashMap<>();
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		for (IProject project : ws.getRoot().getProjects()) {

			try {
				if (!(project.hasNature("org.eclipse.sirius.nature.modelingproject")
						|| project.hasNature("org.moflon.emf.build.MoflonEmfNature")
						|| project.hasNature("org.eclipse.xtext.ui.shared.xtextNature")))
					continue;
			} catch (CoreException e) {
				continue;
			}

			File projectFile = new File(project.getLocation().toPortableString());
			List<File> ecoreFiles = new LinkedList<>();
			SlimGTWorkspaceUtils.gatherFilesWithEnding(ecoreFiles, projectFile, ".ecore", true);

			for (File ecoreFile : ecoreFiles) {

				ResourceSet rs = new ResourceSetImpl();
				rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
				EcorePackage.eINSTANCE.eClass();

				URI gtModelUri;
				try {
					gtModelUri = URI.createFileURI(ecoreFile.getCanonicalPath());
				} catch (IOException e) {
					continue;
				}

				String fileString = gtModelUri.toFileString();

				if (!currentSelection.isBlank() && !fileString.contains(currentSelection))
					continue;

				Resource resource = rs.getResource(gtModelUri, true);
				EPackage metaModel = (EPackage) resource.getContents().get(0);

				if (metaModel == null)
					continue;

				// Put absolute path
				path2model.put(metaModel.getNsURI(), metaModel);
			}
		}

		// Pull packages from the registry
		EPackage.Registry.INSTANCE.keySet().forEach(uri -> {
			path2model.putIfAbsent(uri, EPackage.Registry.INSTANCE.getEPackage(uri));
		});

		for (String path : path2model.keySet()) {
			String replacement = "\"" + path + "\"";
			int start = (currentSelection.isBlank()) ? 0 : currentSelection.length() + 1;
			replacement = replacement.substring(start);
			int cursor = replacement.length();
			replacement = replacement + rest;

			int replacementLength = (currentSelection.isBlank() && context.getCurrentNode().getText().length() > 1)
					? context.getCurrentNode().getText().length() - currentSelection.length() - 1
					: context.getCurrentNode().getText().length() - currentSelection.length();

			acceptor.accept(new CompletionProposal(replacement, context.getOffset(), replacementLength, cursor));
		}
	}

}
