package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
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
		this.assertParameterNames(file, "name")
		this.assertParameterTypes(file, "EString")
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
		this.assertParameterNames(file, "age", "name", "isMale")
		this.assertParameterTypes(file, "EDouble", "EString", "EBoolean")
	}

	@Test
	def void errorIfRuleWithInvalidParameterType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a(age: EClass) {
				a: EObject
			}
		''')
		this.assertBasics(file)
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
}
