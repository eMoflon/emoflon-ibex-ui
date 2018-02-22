package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
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
	def void warningIfNoImport() {
		val file = parseHelper.parse('''
			rule a {
				object: EObject
			}
		''')
		this.assertValidResource(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.graphTransformationFile,
			GTValidator.MISSING_META_MODEL,
			GTValidator.ERROR_MESSAGE_NO_META_MODEL
		)
	}

	@Test
	def void errorIfInvalidImport() {
		val importName = 'test.ecore'
		val file = parseHelper.parse('''
			import "«importName»"
			
			rule a {
				object: EObject
			}
		''')
		this.assertValidResource(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.import,
			GTValidator.INVALID_IMPORT,
			String.format(GTValidator.ERROR_MESSAGE_FILE_DOES_NOT_EXIST, importName)
		)
	}

	@Test
	def void errorIfEmptyRuleBody() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a() {}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.EMPTY_RULE,
			GTValidator.ERROR_MESSAGE_RULE_NOT_EMPTY
		)
	}

	@Test
	def void validIfEmptyRuleBodyAndMultipleRefinement() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				object1: EObject
			}
			
			rule b {
				object2: EObject
			}
			
			rule c
			refines a, b
		''')
		this.assertValid(file, 3)
	}

	@Test
	def void validModifiers() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
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
	def void errorForSelfRefinement() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a
			refines a {
				object: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel1() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a
			refines b {
				object1: EObject
			}
			
			rule b
			refines a {
				object2: EObject
			}
		''')
		this.assertBasics(file, 2)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfLoopinRulesRefinementHierarchyLevel2() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
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
		this.assertBasics(file, 3)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Rule 'A'."
		)
	}

	@Test
	def void errorIfNoDistinctSuperRules() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				object: EObject
			}
			
			rule b
			refines a, a
		''')
		this.assertValidResource(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.INVALID_SUPER_RULES,
			GTValidator.ERROR_MESSAGE_RULE_DISTINCT_SUPER_RULES
		)
	}

	@Test
	def void errorIfRuleNameDuplicates() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
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
		this.assertBasics(file, 5)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.INVALID_NAME_EXPECT_UNIQUE,
			String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_MULTIPLE_DECLARATIONS, "a", "twice"),
			String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_MULTIPLE_DECLARATIONS, "b", "3 times")
		)
	}

	@Test
	def void errorIfRuleNameContainsUnderscores() {
		val ruleName = 'get_an_e_Object'
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.INVALID_NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_CONTAINS_UNDERSCORES, ruleName)
		)
	}

	@Test
	def void errorIfRuleNameInBlacklist() {
		val ruleName = "hashCode"
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.INVALID_NAME_BLACKLISTED,
			String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_FORBIDDEN, ruleName)
		)
	}

	@Test
	def void errorIfRuleNameStartsWithCapital() {
		val ruleName = "AnInvalidName"
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule «ruleName» {
				a: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.rule,
			GTValidator.INVALID_NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.ERROR_MESSAGE_RULE_NAME_STARTS_WITH_LOWER_CASE, ruleName)
		)
	}

	@Test
	def void validRuleWithNoParameters() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a() {
				a: EObject
			}
		''')
		this.assertValid(file)
		Assert.assertTrue(file.rules.get(0).parameters.isEmpty)
	}

	@Test
	def void validRuleWithOneParameter() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a(name: String) {
				a: EObject
			}
		''')
		this.assertValid(file)
		this.assertParameterNames(file, "name")
		this.assertParameterTypes(file, "String")
	}

	@Test
	def void validRuleWithThreeParameters() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a(age: int, name: String, isMale: boolean) {
				a: EObject
			}
		''')
		this.assertValid(file)
		this.assertParameterNames(file, "age", "name", "isMale")
		this.assertParameterTypes(file, "int", "String", "boolean")
	}

	@Test
	def void errorIfParameterListEndsWithComma() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a(age: int,) {
				a: Ebject
			}
		''')
		this.assertInvalidResource(file, 1)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"mismatched input ')' expecting RULE_ID"
		)
	}

	@Test
	def void errorIfParameterListWithNoColons() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule A(age int, name String, isMale boolean) {
				a: Object
			}
		''')
		this.assertInvalidResource(file, 3)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameter,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"missing ':' at 'int'",
			"missing ':' at 'String'",
			"missing ':' at 'boolean'"
		)
	}

	@Test
	def void errorIfParameterListContainsSemicolons() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a(age: int; name: String; isMale: boolean) {
				a: EObject
			}
		''')
		this.assertInvalidResource(file, 1)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.rule,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"mismatched input ';' expecting ')'"
		)
	}
}
