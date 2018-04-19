package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.scoping.GTLinkingDiagnosticMessageProvider
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
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a() {
				a: EObject
			}
		''')
		assertValid(file)
		Assert.assertTrue(file.patterns.get(0).parameters.isEmpty)
	}

	@Test
	def void validRuleWithOneParameter() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a(name: EString) {
				a: EObject
			}
		''')
		assertValid(file)
		assertParameters(file.getRule(0), #{'name' -> 'EString'})
	}

	@Test
	def void validRuleWithThreeParameters() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a(age: EDouble, name: EString, isMale: EBoolean) {
				a: EObject
			}
		''')
		assertValid(file)
		assertParameters(file.getRule(0), #{
			'age' -> 'EDouble',
			'name' -> 'EString',
			'isMale' -> 'EBoolean'
		})
	}

	@Test
	def void errorIfRuleWithInvalidParameterType() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a(age: EClass) {
				a: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameter,
			GTLinkingDiagnosticMessageProvider.PARAMETER_TYPE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.PARAMETER_TYPE_NOT_FOUND_MESSAGE, 'EClass')
		)
	}

	@Test
	def void errorIfParameterListEndsWithComma() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a(age: int,) {
				a: EObject
			}
		''')
		assertInvalidResource(file, 1)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"mismatched input ')' expecting RULE_ID"
		)
	}

	@Test
	def void errorIfParameterListWithNoColons() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern A(age EInt, name EString, isMale EBoolean) {
				a: EObject
			}
		''')
		assertInvalidResource(file, 3)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameter,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"missing ':' at 'EInt'",
			"missing ':' at 'EString'",
			"missing ':' at 'EBoolean'"
		)
	}

	@Test
	def void errorIfParameterListContainsSemicolons() {
		val file = parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			pattern a(age: EInt; name: EString; isMale: EBoolean) {
				a: EObject
			}
		''')
		assertInvalidResource(file, 1)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorPattern,
			Diagnostic::SYNTAX_DIAGNOSTIC,
			"mismatched input ';' expecting ')'"
		)
	}

	@Test
	def void errorIfParameterNameBlacklisted() {
		val file = parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(class: EString) {
				++ clazz: EClass {
					.name := param::class
				}
			}
		''')
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameter,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.PARAMETER_NAME_FORBIDDEN_MESSAGE, 'class')
		)
	}

	@Test
	def void warningIfParameterNameStartsWithCapital() {
		val file = parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			import "http://www.eclipse.org/emf/2002/Ecore"
						
			rule createClass(ClassName: EString) {
				++ clazz: EClass {
					.name := param::ClassName
				}
			}
		''')
		assertValidationIssues(
			file,
			GTPackage.eINSTANCE.editorParameter,
			GTValidator.NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.PARAMETER_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, 'ClassName')
		)
	}

	@Test
	def void warningIfParameterNameContainsUnderscores() {
		val file = parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(class_name: EString) {
				++ clazz: EClass {
					.name := param::class_name
				}
			}
		''')
		assertValidationIssues(
			file,
			GTPackage.eINSTANCE.editorParameter,
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.PARAMETER_NAME_CONTAINS_UNDERSCORES_MESSAGE, 'class_name')
		)
	}

	@Test
	def void errorIfMultipleParametersWithTheSameName() {
		val file = parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createClass(name: EString, name: EChar) {
				++ clazz: EClass {
					.name := param::name
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameter,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.PARAMETER_NAME_MULTIPLE_DECLARATIONS_MESSAGE, 'name', 'twice')
		)
	}
}
