package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for rule refinement.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingRuleRefinementTest extends GTParsingTest {
	@Test
	def void validIfEmptyRuleBodyAndMultipleRefinement() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				object1: EObject
			}
			
			rule b {
				object2: EObject
			}
			
			rule c
			refines a, b
		''')
		assertValid(file, 3)
	}

	@Test
	def void errorForSelfRefinement() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a
			refines a {
				object: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel1() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a
			refines b {
				object1: EObject
			}
			
			rule b
			refines a {
				object2: EObject
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel2() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a
			refines b {
				object: EObject
			}
			
			rule b
			refines c {
				object: EObject
			}
			
			rule c
			refines a {
				object: EObject
			}
		''')
		assertFile(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfNoDistinctSuperRules() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				object: EObject
			}
			
			rule b
			refines a, a
		''')
		assertValidResource(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.RULE_SUPER_RULES_DUPLICATE,
			String.format(GTValidator.RULE_SUPER_RULES_DUPLICATE_MESSAGE, 'b')
		)
	}

	@Test
	def void errorIfConclictingParameterDeclarationsBetweenSuperRules() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule s1(name: EString) {
				object: EObject
			}
			
			rule s2(name: EBoolean) {
				object: EObject
			}
			
			rule r
			refines s1, s2 {
				object: EObject
			}
		''')
		assertFile(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.RULE_REFINEMENT_INVALID_PARAMETER,
			String.format(GTValidator.RULE_REFINEMENT_INVALID_PARAMETER_MESSAGE, 'r', 'name',
				GTValidator.concatNames(#['EBoolean', 'EString']))
		)
	}

	@Test
	def void errorIfConclictingParameterDeclarationsRuleAndSuperRule() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule s(name: EString) {
				object: EObject
			}
			
			rule r(name: EBoolean)
			refines s {
				object: EObject
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.RULE_REFINEMENT_INVALID_PARAMETER,
			String.format(GTValidator.RULE_REFINEMENT_INVALID_PARAMETER_MESSAGE, 'r', 'name',
				GTValidator.concatNames(#['EBoolean', 'EString']))
		)
	}

	@Test
	def void errorIfConflictingAttributeAssignments() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule renameClassToTest1 {
				clazz: EClass {
					.name := "Test1"
				}
			}
			
			rule renameClassToTest2 {
				clazz: EClass {
					.name := "Test2"
				}
			}
			
			rule renameClass
			refines renameClassToTest1, renameClassToTest2
		''')
		assertFile(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT,
			String.format(GTValidator.RULE_REFINEMENT_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE, 'renameClass', 'clazz')
		)
	}

	@Test
	def void validIfNoConflictBetweenAttributeAssignments() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule renameClassToTest1 {
				clazz: EClass {
					.name := "Test"
				}
			}
			
			rule renameClassToTest2 {
				clazz: EClass {
					.name := "Test"
				}
			}
			
			rule renameClass
			refines renameClassToTest1, renameClassToTest2
		''')
		assertValid(file, 3)
	}
}
