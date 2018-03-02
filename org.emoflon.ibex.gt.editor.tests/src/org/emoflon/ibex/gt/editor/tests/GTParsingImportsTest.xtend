package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for features on file/rule level.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingImportsTest extends GTParsingTest {
	@Test
	def void errorIfNoImport() {
		val file = parseHelper.parse('''
			rule a {
				object: EObject
			}
		''')
		this.assertValidResource(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.graphTransformationFile,
			GTValidator.IMPORT_MISSING_META_MODEL,
			GTValidator.IMPORT_MISSING_META_MODEL_MESSAGE
		)
	}

	@Test
	def void warningIfDuplicateImport() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			import "«ecoreImport»"
			
			rule a {
				object: EObject
			}
		''')
		this.assertValidResource(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.import,
			GTValidator.IMPORT_DUPLICATE,
			Severity.WARNING,
			String.format(GTValidator.IMPORT_DUPLICATE_MESSAGE, ecoreImport, 'twice')
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
			GTValidator.IMPORT_FILE_DOES_NOT_EXIST,
			String.format(GTValidator.IMPORT_FILE_DOES_NOT_EXIST_MESSAGE, importName)
		)
	}
}