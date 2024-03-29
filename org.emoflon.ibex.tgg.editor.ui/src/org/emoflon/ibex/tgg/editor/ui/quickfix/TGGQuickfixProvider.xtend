/*
 * generated by Xtext 2.26.0
 */
package org.emoflon.ibex.tgg.editor.ui.quickfix

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.emoflon.ibex.tgg.editor.tgg.LinkVariablePattern
import org.emoflon.ibex.tgg.editor.tgg.NamedElements
import org.emoflon.ibex.tgg.editor.tgg.ObjectVariablePattern
import org.emoflon.ibex.tgg.editor.tgg.Rule
import org.emoflon.ibex.tgg.editor.tgg.TggFactory
import org.emoflon.ibex.tgg.editor.validation.TGGValidator

/** 
 * Custom quickfixes.
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class TGGQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(TGGValidator::NOT_UNIQUE_NAME)
	def fixDuplicateNames(Issue issue, IssueResolutionAcceptor acceptor) {
		var messageParts = issue.message.split("'");
		var name = "";
		if (messageParts.size() == 3)
			name = messageParts.get(1);

		acceptor.accept(
			issue,
			"change name", // label
			"change name '" + name + "' to '" + name + "1'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					val ovPattern = element as NamedElements;
					ovPattern.name = ovPattern.name + '1';
				}
			}
		)
	}

	@Fix(TGGValidator::TYPE_IS_ABSTRACT)
	def changeRuleToAbstract(Issue issue, IssueResolutionAcceptor acceptor) {
		var messageParts = issue.message.split("'");
		var name = "";
		if (messageParts.size() == 5)
			name = messageParts.get(1);

		acceptor.accept(
			issue,
			"make rule abstract", // label
			"make rule abstract '" + name + "'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					val ovPattern = element as ObjectVariablePattern;
					if (ovPattern.eContainer instanceof Rule) {
						var rule = ovPattern.eContainer as Rule;
						rule.abstractRule = true;
					}
				}
			}
		)
	}

	@Fix(TGGValidator::RULE_REFINEMENT_CREATES_A_CYCLE)
	def deleteRefinements(Issue issue, IssueResolutionAcceptor acceptor) {
		var messageParts = issue.message.split("'");
		var name = "";
		if (messageParts.size() >= 4) {
			name = messageParts.get(1);

		}

		acceptor.accept(
			issue,
			"delete all refinements", // label
			"delete all refinements from '" + name + "'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					val rule = element as Rule;
					rule.supertypes.clear();
				}
			}
		)
	}

	@Fix(TGGValidator::RULE_REFINEMENT_CREATES_A_CYCLE)
	def deleteRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		var messageParts = issue.message.split("'");
		var name = "";
		var refinement = "";
		if (messageParts.size() >= 4) {
			name = messageParts.get(1);
			refinement = messageParts.get(3);
		}
		val refinementName = refinement;
		acceptor.accept(
			issue,
			"delete the refinement", // label
			"delete the refinements '" + refinement + "' from '" + name + "'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					var rule = element as Rule;
					var allSuperTypes = new ArrayList<Rule>(rule.supertypes);
					for (superRule : allSuperTypes) {
						if (refinementName.compareTo(superRule.name) == 0) {
							rule.supertypes.remove(superRule);
						}
					}
				}
			}
		)
	}

	@Fix(TGGValidator.LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_OBJECT_VARIABLE_PATTERN)
	def addCorrectOperator(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"add correct operator", // label
			"adds the operator from the object variable'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					var linkVar = element as LinkVariablePattern;
					var ov = linkVar.eContainer as ObjectVariablePattern
					var newOp = TggFactory.eINSTANCE.createOperator();
					newOp.value = ov.op.value;
					linkVar.op = newOp;
				}
			}
		)
	}

	@Fix(TGGValidator.LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_TARGET_OBJECT_VARIABLE_PATTERN)
	def addCorrectTargetOperator(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"add correct operator", // label
			"adds the operator from the target object variable'", // description
			null, // icon 
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) {
					var linkVar = element as LinkVariablePattern;
					var ov = linkVar.target
					var newOp = TggFactory.eINSTANCE.createOperator();
					newOp.value = ov.op.value;
					linkVar.op = newOp;
				}
			}
		)
	}

}
