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
			String.format(GTValidator.PATTERN_CONDITIONS_DUPLICATE_MESSAGE, 'b')
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
			GTPackage.eINSTANCE.editorEnforce,
			GTValidator.CONDITION_PATTERN_INVALID_RULE,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_RULE_MESSAGE, 'a')
		)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorForbid,
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
			GTPackage.eINSTANCE.editorEnforce,
			GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_PARAMETERS_MESSAGE, 'a')
		)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorForbid,
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
			GTPackage.eINSTANCE.editorEnforce,
			GTValidator.CONDITION_PATTERN_INVALID_CONDITIONS,
			String.format(GTValidator.CONDITION_PATTERN_INVALID_CONDITIONS_MESSAGE, 'p2')
		)
	}
}
