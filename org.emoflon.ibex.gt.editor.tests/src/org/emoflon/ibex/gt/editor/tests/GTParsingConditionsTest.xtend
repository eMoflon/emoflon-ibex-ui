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
	def void errorIfConditionReferencesRule() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				++ object: EObject
			}
			
			rule b {
				++ object: EObject
			}
			
			condition enforceCond = enforce a
			condition forbidCond = forbid a
		''')
		assertFile(file, 2)
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
			
			pattern b(i: EInt) {
				object: EObject
			}
			
			condition enforceCond = enforce a
			condition forbidCond = forbid a
		''')
		assertFile(file, 2)
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
}
