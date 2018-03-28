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
class GTParsingParametersTest extends GTParsingTest {
	@Test
	def void validRuleWithNoParameters() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
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
			import "«ecoreImport»"
			
			rule a(name: EString) {
				a: EObject
			}
		''')
		this.assertValid(file)
		this.assertParameters(file.getRule(0), #{'name' -> 'EString'})
	}

	@Test
	def void validRuleWithThreeParameters() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a(age: EDouble, name: EString, isMale: EBoolean) {
				a: EObject
			}
		''')
		this.assertValid(file)
		this.assertParameters(file.getRule(0), #{
			'age' -> 'EDouble',
			'name' -> 'EString',
			'isMale' -> 'EBoolean'
		})
	}

	@Test
	def void errorIfRuleWithInvalidParameterType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a(age: EClass) {
				a: EObject
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameter,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EDataType 'EClass'."
		)
	}

	@Test
	def void errorIfParameterListEndsWithComma() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a(age: int,) {
				a: EObject
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
			import "«ecoreImport»"
			
			rule A(age EInt, name EString, isMale EBoolean) {
				a: EObject
			}
		''')
		this.assertInvalidResource(file, 3)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameter,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"missing ':' at 'EInt'",
			"missing ':' at 'EString'",
			"missing ':' at 'EBoolean'"
		)
	}

	@Test
	def void errorIfParameterListContainsSemicolons() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a(age: EInt; name: EString; isMale: EBoolean) {
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

	@Test
	def void errorIfParameterNameBlacklisted() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(class: EString) {
				++ clazz: EClass {
					.name := param::class
				}
			}
		''')
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameter,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.PARAMETER_NAME_FORBIDDEN_MESSAGE, 'class')
		)
	}

	@Test
	def void warningIfParameterNameStartsWithCapital() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			import "http://www.eclipse.org/emf/2002/Ecore"
						
			rule createClass(ClassName: EString) {
				++ clazz: EClass {
					.name := param::ClassName
				}
			}
		''')
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.parameter,
			GTValidator.NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.PARAMETER_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, 'ClassName')
		)
	}

	@Test
	def void warningIfParameterNameContainsUnderscores() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(class_name: EString) {
				++ clazz: EClass {
					.name := param::class_name
				}
			}
		''')
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.parameter,
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.PARAMETER_NAME_CONTAINS_UNDERSCORES_MESSAGE, 'class_name')
		)
	}

	@Test
	def void errorIfMultipleParametersWithTheSameName() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(name: EString, name: EChar) {
				++ clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameter,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.PARAMETER_NAME_MULTIPLE_DECLARATIONS_MESSAGE, 'name', 'twice')
		)
	}
}
