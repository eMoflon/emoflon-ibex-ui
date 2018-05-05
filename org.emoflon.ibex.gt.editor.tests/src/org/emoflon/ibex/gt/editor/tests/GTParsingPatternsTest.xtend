package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for validation of patterns.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingPatternsTest extends GTParsingTest {
	@Test
	def void errorIfEmptyRuleBody() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a() {}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_EMPTY,
			String.format(GTValidator.PATTERN_EMPTY_MESSAGE, "pattern 'a'")
		)
	}

	@Test
	def void validModifiers() {
		val file = parse('''
			import "«ecoreImport»"
			
			abstract pattern a() {
				object1: EObject
			}
			
			pattern b {
				object2: EObject
			}
		''')
		assertValid(file, 2)
		Assert.assertTrue(file.patterns.get(0).abstract)
		Assert.assertFalse(file.patterns.get(1).abstract)
	}

	@Test
	def void errorIfRuleNameDuplicates() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a() {
				object: EObject
			}
			
			pattern a {
				object: EObject
			}
			
			pattern b {
				object: EObject
			}
			
			pattern b() {
				object: EObject
			}
			
			pattern b {
				object: EObject
			}
		''')
		assertFile(file, 5)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.PATTERN_NAME_MULTIPLE_DECLARATIONS_MESSAGE, "a", "twice"),
			String.format(GTValidator.PATTERN_NAME_MULTIPLE_DECLARATIONS_MESSAGE, "b", "3 times")
		)
	}

	@Test
	def void warningIfRuleNameContainsUnderscores() {
		val ruleName = 'get_an_e_Object'
		val file = parse('''
			import "«ecoreImport»"
			
			pattern «ruleName» {
				a: EObject
			}
		''')
		assertFile(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			String.format(GTValidator.PATTERN_NAME_CONTAINS_UNDERSCORES_MESSAGE, ruleName)
		)
	}

	@Test
	def void errorIfRuleNameInBlacklist() {
		val ruleName = "hashCode"
		val file = parse('''
			import "«ecoreImport»"
			
			pattern «ruleName» {
				a: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.PATTERN_NAME_FORBIDDEN_MESSAGE, ruleName)
		)
	}

	@Test
	def void warningIfRuleNameStartsWithCapital() {
		val ruleName = "AnInvalidName"
		val file = parse('''
			import "«ecoreImport»"
			
			pattern «ruleName» {
				a: EObject
			}
		''')
		assertFile(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.NAME_EXPECT_LOWER_CASE,
			String.format(GTValidator.PATTERN_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, ruleName)
		)
	}

	@Test
	def void errorIfPatternContainsCreatedElement() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern test {
				++ a: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_TYPE_INVALID_PATTERN,
			String.format(GTValidator.PATTERN_TYPE_INVALID_PATTERN_MESSAGE, 'test')
		)
	}

	@Test
	def void errorIfRuleContainsNoCreatedOrDeletedElement() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule test {
				a: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			GTValidator.PATTERN_TYPE_INVALID_RULE,
			String.format(GTValidator.PATTERN_TYPE_INVALID_RULE_MESSAGE, 'test')
		)
	}
}
