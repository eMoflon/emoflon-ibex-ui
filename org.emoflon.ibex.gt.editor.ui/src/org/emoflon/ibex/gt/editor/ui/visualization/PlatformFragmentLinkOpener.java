package org.emoflon.ibex.gt.editor.ui.visualization;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;

import net.sourceforge.plantuml.eclipse.utils.ILinkOpener;
import net.sourceforge.plantuml.eclipse.utils.LinkData;
import net.sourceforge.plantuml.eclipse.utils.PlatformLinkOpener;

/**
 * An {@link ILinkOpener} with support for opening the editor on the line of the
 * fragment in a platform link.
 */
public class PlatformFragmentLinkOpener extends PlatformLinkOpener {

	@Override
	public int supportsLink(final LinkData link) {
		URI uri = URI.createURI(link.href);
		if (uri.fileExtension().equals("gt") && uri.hasFragment()) {
			return CUSTOM_SUPPORT;
		}
		return super.supportsLink(link);
	}

	@Override
	protected IPath getPath(final LinkData link) {
		URI uri = URI.createURI(link.href);
		if (!uri.hasFragment()) {
			return super.getPath(link);
		}
		LinkData linkWithoutFragment = new LinkData();
		linkWithoutFragment.href = uri.trimFragment().toString();
		return super.getPath(linkWithoutFragment);
	}

	@Override
	public void openLink(final LinkData link) {
		URI uri = URI.createURI(link.href);

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(getPath(link));
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());

		try {
			IEditorPart editorPart = page.openEditor(new FileEditorInput(file), desc.getId());
			if (editorPart instanceof XtextEditor) {
				goToFragmentLine((XtextEditor) editorPart, file, uri.fragment());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Goes to the line of the given URI's fragment in the opened editor
	 * 
	 * @param xtextEditor
	 *            the editor for the line
	 * @param file
	 *            the file
	 * @param fragment
	 *            the URI fragment
	 * @throws CoreException
	 *             if an error occurs during setting the marker for the target
	 */
	private static void goToFragmentLine(final XtextEditor xtextEditor, final IFile file, final String fragment)
			throws CoreException {
		EObject fragmentObject = xtextEditor.getDocument().readOnly(res -> res.getEObject(fragment));
		if (fragmentObject == null) {
			return;
		}

		IMarker marker = file.createMarker(IMarker.TEXT);
		marker.setAttribute(IMarker.LINE_NUMBER, NodeModelUtils.getNode(fragmentObject).getStartLine());

		IGotoMarker goToMarker = (IGotoMarker) xtextEditor.getAdapter(IGotoMarker.class);
		goToMarker.gotoMarker(marker);

		marker.delete();
	}
}
