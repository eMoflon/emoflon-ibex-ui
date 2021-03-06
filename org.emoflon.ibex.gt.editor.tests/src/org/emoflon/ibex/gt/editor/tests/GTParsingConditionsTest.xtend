package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for conditions.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingConditionsTest extends GTParsingTest {

	@Test
	def void errorIfMultipleConditionsWithTheSameName() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object: EObject
			}
			
			condition b = enforce a
			condition b = forbid a
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorCondition,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.CONDITION_NAME_MULTIPLE_DECLARATIONS_MESSAGE, 'b', 'twice')
		)
	}

	@Test
	def void errorIfNoDistinctConditionsForPattern() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				anyObject: EObject
			}
			
			pattern b {
				object: EObject
			}
			when c || c
			
			condition c = forbid a
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_CONDITIONS_DUPLICATE,
			String.format(GTValidator.PATTERN_CONDITIONS_DUPLICATE_MESSAGE, "pattern 'b'")
		)
	}

	@Test
	def void errorIfConditionReferencesRule() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				++ object: EObject
			}
			
			condition enforceCond = enforce a
			
			condition forbidCond = forbid a
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorApplicationCondition,
			GTValidator.CONDITION_PATTERN_INVALID_RULE,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_RULE_MESSAGE, 'a')
		)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorApplicationCondition,
			GTValidator.CONDITION_PATTERN_INVALID_RULE,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_RULE_MESSAGE, 'a')
		)
	}

	@Test
	def void errorIfConditionReferencesParameterizedPattern() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a(i: EInt) {
				object: EObject
			}
			
			condition enforceCond = enforce a
			
			condition forbidCond = forbid a
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorApplicationCondition,
			GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE, 'a')
		)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorApplicationCondition,
			GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE, 'a')
		)
	}

	@Test
	def void errorIfConditionReferencesPatternWithMultipleConditions() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern p1 {
				object: EObject
			}
			
			condition c1 = enforce p1
			
			condition c2 = enforce p1
			
			pattern p2 {
				object: EObject
			}
			when c1 || c2
			
			condition c3 = enforce p2
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorApplicationCondition,
			GTValidator.CONDITION_PATTERN_INVALID_CONDITIONS,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE, 'p2')
		)
	}

	@Test
	def void warningIfAbstractPatternHasConditions() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object: EObject
			}
			
			condition c = enforce a
			
			abstract pattern p {
				object: EObject
			}
			when c
			
			abstract rule r {
				++ object: EObject
			}
			when c
		''')
		assertFile(file, 3)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT,
			String.format(GTValidator.PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT_MESSAGE, "pattern 'p'"),
			String.format(GTValidator.PATTERN_CONDITIONS_NOT_ALLOWED_ABSTRACT_MESSAGE, "rule 'r'")
		)
	}

	@Test
	def void errorIfSelfReferenceLevel1() {
		val file = parse('''
			import "«ecoreImport»"
			
			condition c = c
		''')
		assertFile(file, 0)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorCondition,
			GTValidator.CONDITION_SELF_REFERENCE,
			String.format(GTValidator.CONDITION_SELF_REFERENCE_MESSAGE, 'c')
		)
	}

	@Test
	def void errorIfSelfReferenceLevel2() {
		val file = parse('''
			import "«ecoreImport»"
			
			condition c1 = c2
			condition c2 = c1
		''')
		assertFile(file, 0)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorCondition,
			GTValidator.CONDITION_SELF_REFERENCE,
			String.format(GTValidator.CONDITION_SELF_REFERENCE_MESSAGE, 'c1'),
			String.format(GTValidator.CONDITION_SELF_REFERENCE_MESSAGE, 'c2')
		)
	}

	@Test
	def void errorIfPACandNACforTheSamePattern() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern p {
				object: EObject
			}
			
			condition c = enforce p && forbid p
		''')
		assertFile(file, 1)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorCondition,
			GTValidator.CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN,
			String.format(GTValidator.CONDITION_PAC_AND_NAC_FOR_SAME_PATTERN_MESSAGE, 'c', 'p')
		)
	}
}
