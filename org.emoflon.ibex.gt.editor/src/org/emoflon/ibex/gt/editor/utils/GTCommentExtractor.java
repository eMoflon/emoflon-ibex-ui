package org.emoflon.ibex.gt.editor.utils;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;

/**
 * Utility to extract comment from the Xtext model.
 */
public class GTCommentExtractor {

	/**
	 * Extracts the editor comment for the pattern if such a comment is available.
	 * 
	 * @param editorPattern
	 *            the editor pattern
	 * @return the text of the comment (can be the empty String)
	 */
	public static String getComment(final EditorPattern editorPattern) {
		ICompositeNode xtextNodeForPattern = NodeModelUtils.getNode(editorPattern);
		INode firstChild = xtextNodeForPattern.getFirstChild();
		if (firstChild instanceof ICompositeNode) {
			return extract((ICompositeNode) firstChild);
		}
		return "";
	}

	/**
	 * Extracts the editor comment from an Xtext node.
	 * 
	 * @param xtextNode
	 *            the Xtext node containing the comment
	 * @return the text of the comment (can be the empty String)
	 */
	private static String extract(final ICompositeNode xtextNode) {
		StringBuilder documentation = new StringBuilder();
		xtextNode.getChildren().forEach(i -> {
			if (i instanceof HiddenLeafNode) {
				documentation.append(extract(i.getText()));
			}
		});
		return documentation.toString() //
				.replaceAll("\r", "").replaceAll("\n", "") // remove line breaks
				.replace("  ", " ") // remove multiple consecutive spaces
				.trim();
	}

	/**
	 * Extracts the text from a comment.
	 * 
	 * @param comment
	 *            a comment
	 * @return the text of the comment (can be the empty String)
	 */
	private static String extract(final String comment) {
		if (comment == null) {
			return "";
		}

		return comment.replace("/**", "").replace("/*", "") // start of multi-line comment
				.replace("*/", "").replace("*", "") // end and continued line of multi-line comment
				.replace("//", "") // single line comment
				.replace("  ", " ").trim();
	}
}
