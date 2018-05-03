package org.emoflon.ibex.gt.editor.formatting2

import java.util.List

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorCondition
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference
import org.emoflon.ibex.gt.editor.gT.EditorEnforce
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorImport
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage

/**
 * Formatting
 * 
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 */
class GTFormatter extends AbstractFormatter2 {
	private static val MAX_LINE_WIDTH = 100

	def dispatch void format(EditorGTFile file, extension IFormattableDocument document) {
		// No space before first import.
		if (file.imports.size > 0) {
			file.imports.get(0).prepend[noSpace]
		}

		// Empty line after imports.
		formatList(file.imports, document, 0, 1, 2)

		val lastPattern = NodeModelUtils.getNode(file.patterns.last)
		val lastCondition = NodeModelUtils.getNode(file.conditions.last)
		val isLastElementACondition = //
			if (lastPattern === null || lastCondition === null)
				false
			else
				lastCondition.endLine > lastPattern.endLine

		// Empty line between each pattern.
		formatList(
			file.patterns,
			document,
			if(file.imports.size > 0) 2 else 0,
			2,
			if(!isLastElementACondition) 1 else 2
		)

		// Empty line between each condition.
		formatList(
			file.conditions,
			document,
			2,
			2,
			if(isLastElementACondition) 1 else 2
		)
	}

	def dispatch void format(EditorImport i, extension IFormattableDocument document) {
		// One space after the "import" keyword.
		i.regionFor.keyword("import").append[oneSpace]
	}

	def dispatch void format(EditorPattern pattern, extension IFormattableDocument document) {
		// One space between modifier and pattern keyword.
		if (pattern.abstract) {
			pattern.regionFor.keyword("abstract").append[oneSpace]
		}

		// One space between pattern keyword and name.
		pattern.regionFor.feature(GTPackage.Literals.EDITOR_PATTERN__TYPE).append[oneSpace]

		// New line before "refines", one space after "refines".
		pattern.regionFor.keyword("refines").prepend[newLine].append[oneSpace]

		// No space between pattern name, "(" and first parameter.
		pattern.regionFor.keyword("(").prepend[noSpace].append[noSpace]

		pattern.parameters.forEach [
			it.format
		]

		pattern.regionFor.keywords(",").forEach [
			it.prepend[noSpace].append[oneSpace]
		]

		// No space between last parameter and ")", but one space between ")" and "{"
		pattern.regionFor.keyword(")").prepend[noSpace].append[oneSpace]

		// One space before "{".
		pattern.regionFor.keyword("{").prepend[oneSpace]

		// Indent everything between "{" and "}".
		val body = pattern.regionFor.keywordPairs("{", "}")
		if (body.size > 0) {
			body.get(0).interior[indent]
		}

		// Empty line between nodes.
		formatList(pattern.nodes, document, 1, 2, 1)

		// New line before and one space after for keyword "when".
		pattern.regionFor.keyword("when").prepend[newLine].append[oneSpace]

		if (pattern.conditions.size > 0) {
			val alternatives = pattern.regionFor.keywords('||')
			var length = 5 + 4 * (pattern.conditions.size - 1) // length of "when " and " || "s 
			length += alternatives.get(0).previousSemanticRegion.length
			for (a : alternatives) {
				length += a.nextSemanticRegion.length
			}

			if (length < MAX_LINE_WIDTH) {
				// One space before and after "||".
				alternatives.forEach [
					it.surround[oneSpace]
				]
			} else {
				// One condition per line: line break and two spaces after "||".
				alternatives.forEach [
					it.prepend[space = System.lineSeparator + "  "].append[oneSpace]
				]
			}
		}
	}

	def dispatch void format(EditorParameter parameter, extension IFormattableDocument document) {
		// No space before ":", one space after ":".
		parameter.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
	}

	def dispatch void format(EditorNode node, extension IFormattableDocument document) {
		// One space before "{".
		node.regionFor.keyword("{").prepend[oneSpace]

		// No space before ":", but one space after ":".
		node.regionFor.keyword(":").prepend[noSpace].append[oneSpace]

		// Indent everything between "{" and "}".
		val nodeContent = node.regionFor.keywordPairs("{", "}")
		if (nodeContent.size > 0) {
			nodeContent.get(0).interior[indent]
		}

		// New line for each attribute.
		node.attributes.forEach [
			it.format.surround[newLine]
		]

		// New line for each reference.
		node.references.forEach [
			it.format.surround[newLine]
		]
	}

	def dispatch void format(EditorAttribute attribute, extension IFormattableDocument document) {
		// No space before and after ".".
		attribute.regionFor.keyword(".").surround[noSpace]

		// One space before and after the relation.
		attribute.regionFor.feature(GTPackage.Literals.EDITOR_ATTRIBUTE__RELATION).surround[oneSpace]
	}

	def dispatch void format(EditorReference reference, extension IFormattableDocument document) {
		if (reference.operator == EditorOperator.CONTEXT) {
			// No space before "-" and between "-" and the reference name.
			reference.regionFor.keyword("-").surround[noSpace]
		} else {
			// One space between operator and "-".
			reference.regionFor.feature(GTPackage.Literals.EDITOR_REFERENCE__OPERATOR).append[oneSpace]

			// One space before "-", but no space between "-" and the reference name.
			reference.regionFor.keyword("-").prepend[oneSpace].append[noSpace]
		}

		// One space before and after ->.
		reference.regionFor.keyword("->").surround[oneSpace]
	}

	def dispatch void format(EditorCondition condition, extension IFormattableDocument document) {
		// No space before and one space after 'condition'.
		condition.regionFor.keyword('condition').prepend[noSpace].append[oneSpace]

		// One space before and after "=".
		condition.regionFor.keyword('=').surround[oneSpace]

		// One space before and after "&&".
		val ands = condition.regionFor.keywords('&&')
		ands.forEach [
			it.surround[oneSpace]
		]

		condition.conditions.forEach [
			it.format
		]
	}

	def dispatch void format(EditorConditionReference condition, extension IFormattableDocument document) {
		condition.regionFor.keyword('check').append[oneSpace]
	}

	def dispatch void format(EditorEnforce condition, extension IFormattableDocument document) {
		condition.regionFor.keyword('enforce').append[oneSpace]
	}

	def dispatch void format(EditorForbid condition, extension IFormattableDocument document) {
		condition.regionFor.keyword('forbid').append[oneSpace]
	}

	/**
	 * Formats a list.
	 */
	private static def formatList(List<? extends EObject> items, extension IFormattableDocument document,
		int newLinesBeforeFirst, int newLinesAfterItem, int newLinesAfterLastItem) {
		if (items.size() == 0) {
			return;
		}

		if (newLinesBeforeFirst > 0) {
			items.get(0).prepend[newLines = newLinesBeforeFirst]
		}

		for (var index = 0; index < items.size() - 1; index++) {
			items.get(index).format.append[newLines = newLinesAfterItem]
		}

		items.get(items.size() - 1).format.append[newLines = newLinesAfterLastItem]
	}
}
