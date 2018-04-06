package org.emoflon.ibex.gt.editor.ui.quickfix

import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorImport

/**
 * Quickfixes for imports.
 */
class GTImportQuickfixes {

	/**
	 * Remove a duplicate or invalid import.
	 */
	static def removeImport(Issue issue, IssueResolutionAcceptor acceptor) {
		val importName = issue.data.get(0)
		var label = '''Remove import '«importName»'.'''
		acceptor.accept(
			issue,
			label,
			label,
			null,
			[ element, context |
				if (element instanceof EditorImport) {
					val file = element.eContainer as EditorGTFile
					file.imports.remove(element)
				}
			]
		)
	}
}
