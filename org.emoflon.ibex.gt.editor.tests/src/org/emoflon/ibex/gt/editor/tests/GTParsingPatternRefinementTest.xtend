package org.emoflon.ibex.gt.editor.tests

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
class GTParsingPatternRefinementTest extends GTParsingTest {
	@Test
	def void validIfEmptyRuleBodyAndMultipleRefinement() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object1: EObject
			}
			
			pattern b {
				object2: EObject
			}
			
			pattern c
			refines a, b
		''')
		assertValid(file, 3)
	}

	@Test
	def void validIfEmptyRuleBodyAndRefinementAndCondition() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object1: EObject
			}
			
			pattern b
			refines a
			when c
			
			condition c = enforce a
		''')
		assertValid(file, 2)
	}

	@Test
	def void errorForSelfRefinement() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a
			refines a {
				object: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_MESSAGE, 'a', 'a')
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel1() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a
			refines b {
				object1: EObject
			}
			
			pattern b
			refines a {
				object2: EObject
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_MESSAGE, 'a', 'b')
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel2() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a
			refines b {
				object: EObject
			}
			
			pattern b
			refines c {
				object: EObject
			}
			
			pattern c
			refines a {
				object: EObject
			}
		''')
		assertFile(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_MESSAGE, 'a', 'b')
		)
	}

	@Test
	def void errorIfNoDistinctSuperRules() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object: EObject
			}
			
			pattern b
			refines a, a
		''')
		assertValidResource(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_DUPLICATE,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_DUPLICATE_MESSAGE, 'b')
		)
	}

	@Test
	def void errorIfConflictingParameterDeclarationsBetweenSuperRules() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern s1(name: EString) {
				object: EObject
			}
			
			pattern s2(name: EBoolean) {
				object: EObject
			}
			
			pattern r
			refines s1, s2 {
				object: EObject
			}
		''')
		assertFile(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID_PARAMETER,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_PARAMETER_MESSAGE, "pattern 'r'", 'name',
				GTValidator.concatNames(#['EBoolean', 'EString']))
		)
	}

	@Test
	def void errorIfConflictingParameterDeclarationsRuleAndSuperRule() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern s(name: EString) {
				object: EObject
			}
			
			pattern r(name: EBoolean)
			refines s {
				object: EObject
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID_PARAMETER,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_PARAMETER_MESSAGE, "pattern 'r'", 'name',
				GTValidator.concatNames(#['EBoolean', 'EString']))
		)
	}

	@Test
	def void errorIfConflictingAttributeAssignments() {
		val file = parse('''
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
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_ATTRIBUTE_ASSIGNMENT_MESSAGE, "rule 'renameClass'",
				'clazz')
		)
	}

	@Test
	def void validIfNoConflictBetweenNodeTypes() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				n: EClass
			}
			
			pattern b {
				n: EAnnotation
			}
			
			pattern c {
				n: EClassifier
			}
			
			pattern d
			refines a, b
		''')
		assertFile(file, 4)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE,
			String.format(GTValidator.PATTERN_SUPER_PATTERNS_INVALID_NODE_TYPE_MESSAGE, "pattern 'd'", 'n',
				"'EAnnotation' and 'EClass'")
		)
	}

	@Test
	def void validIfNoConflictBetweenAttributeAssignments() {
		val file = parse('''
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
