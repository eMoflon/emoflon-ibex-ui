package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for features on file/rule level.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingRulesTest extends GTParsingTest {
	@Test
	def void errorIfEmptyRuleBody() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a() {}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.RULE_EMPTY,
			String.format(GTValidator.RULE_EMPTY_MESSAGE, 'a')
		)
	}

	@Test
	def void validModifiers() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			abstract rule a() {
				object1: EObject
			}
			
			rule b {
				object2: EObject
			}
		''')
		this.assertValid(file, 2)
		Assert.assertTrue(file.rules.get(0).abstract)
		Assert.assertFalse(file.rules.get(1).abstract)
	}

	@Test
	def void errorIfRuleNameDuplicates() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a() {
				object: EObject
			}
			
			rule a {
				object: EObject
			}
			
			rule b {
				object: EObject
			}
			
			rule b() {
				object: EObject
			}
			
			rule b {
				object: EObject
			}
		''')
		this.assertFile(file, 5)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, "a", "twice"),
			String.format(GTValidator.RULE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, "b", "3 times")
		)
	}

	@Test
	def void warningIfRuleNameContainsUnderscores() {
		val ruleName = 'get_an_e_Object'
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertFile(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.RULE_NAME_CONTAINS_UNDERSCORES_MESSAGE, ruleName)
		)
	}

	@Test
	def void errorIfRuleNameInBlacklist() {
		val ruleName = "hashCode"
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.RULE_NAME_FORBIDDEN_MESSAGE, ruleName)
		)
	}

	@Test
	def void warningIfRuleNameStartsWithCapital() {
		val ruleName = "AnInvalidName"
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertFile(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.RULE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, ruleName)
		)
	}
}
