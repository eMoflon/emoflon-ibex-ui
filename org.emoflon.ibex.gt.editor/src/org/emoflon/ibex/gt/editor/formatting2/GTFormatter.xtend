package org.emoflon.ibex.gt.editor.formatting2

import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.emoflon.ibex.gt.editor.gT.AttributeCondition
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule
import org.eclipse.emf.ecore.EObject
import java.util.List

/**
 * Formatting
 * 
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 */
class GTFormatter extends AbstractFormatter2 {

	def dispatch void format(GraphTransformationFile file, extension IFormattableDocument document) {
		// Empty line after imports
		this.emptyLineAfterList(file.imports, document)

		// Empty line between each rule.
		this.emptyLineBetweenItems(file.rules, document)
	}

	def dispatch void format(Rule rule, extension IFormattableDocument document) {
		// One space between modifier and rule keyword.
		if (rule.abstract) {
			rule.regionFor.keyword("abstract").append[oneSpace]
		}

		// Check: One space between rule keyword and name.
		rule.regionFor.keyword("rule").append[oneSpace]

		// No space between rule name, "(" and first parameter.
		rule.regionFor.keyword("(").prepend[noSpace]
		rule.regionFor.keyword("(").append[noSpace]

		// No space between last parameter and ")", but one space between ")" and "{"
		rule.regionFor.keyword(")").prepend[noSpace]
		rule.regionFor.keyword(")").append[oneSpace]

		// Indent everything between {}.
		rule.regionFor.keywordPairs("{", "}").get(0).interior[indent]

		// Empty line between nodes.
		this.emptyLineBetweenItems(rule.nodes, document)
	}

	def dispatch void format(Parameter parameter, extension IFormattableDocument document) {
		// TODO: No space before ",", one space after ",".
	}

	def dispatch void format(Node node, extension IFormattableDocument document) {
		// Indent everything between {}.
		node.regionFor.keywordPairs("{", "}").get(0).interior[indent]

		// One space before "{".
		node.regionFor.keyword("{").prepend[oneSpace]

		// No space before ":", but one space after ":".
		node.regionFor.keyword(":").prepend[noSpace]
		node.regionFor.keyword(":").append[oneSpace]

		// New line for each constraint.
		node.constraints.forEach [
			it.format
			it.surround[newLine]
		]
	}
	
	def dispatch void format(Reference reference, extension IFormattableDocument document) {
		// One space before and after ->.
		reference.regionFor.keyword("->").surround[oneSpace]
	}

	def dispatch void format(AttributeCondition attributeCondition, extension IFormattableDocument document) {
		// TODO: One space before and after the operator.
	}

	/**
	 * Formats a list such that
	 * <ul>
	 * <li>there is no empty space before the list,</li>
	 * <li>each item starts on a new line</li>
	 * <li>and there is exactly one empty line after the list</li>
	 * </ul>
	 */
	def private void emptyLineAfterList(List<? extends EObject> items, extension IFormattableDocument document) {
		if (items !== null && items.size() > 0) {
			items.get(0).prepend[noSpace]
			for (var index = 0; index < items.size() - 1; index++) {
				items.get(index).format
				items.get(index).append[newLine]
			}
			items.get(items.size() - 1).append[newLines = 2]
		}
	}

	/**
	 * Formats a list such that
	 * <ul>
	 * <li>each item starts on a new line</li>
	 * <li>there is exactly one empty line between items</li>
	 * </ul>
	 */
	def private void emptyLineBetweenItems(List<? extends EObject> items, extension IFormattableDocument document) {
		if (items !== null && items.size() > 0) {
			items.get(0).prepend[newLine]
			for (var index = 0; index < items.size() - 1; index++) {
				items.get(index).format
				items.get(index).append[newLines = 2]
			}
			items.get(items.size() - 1).append[newLine]
		}
	}
}
