package org.emoflon.ibex.gt.editor.tests

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
		val file = parse('''
			pattern a {
				object: EObject
			}
		''')
		assertValidResource(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorGTFile,
			GTValidator.IMPORT_MISSING_META_MODEL,
			GTValidator.IMPORT_MISSING_META_MODEL_MESSAGE
		)
	}

	@Test
	def void warningIfDuplicateImport() {
		val file = parse('''
			import "«ecoreImport»"
			import "«ecoreImport»"
			
			pattern a {
				object: EObject
			}
		''')
		assertValidResource(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorImport,
			GTValidator.IMPORT_DUPLICATE,
			String.format(GTValidator.IMPORT_DUPLICATE_MESSAGE, ecoreImport, 'twice')
		)
	}

	@Test
	def void errorIfInvalidImport() {
		val importName = 'test.ecore'
		val file = parse('''
			import "«importName»"
			
			pattern a {
				object: EObject
			}
		''')
		assertValidResource(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorImport,
			GTValidator.IMPORT_FILE_DOES_NOT_EXIST,
			String.format(GTValidator.IMPORT_FILE_DOES_NOT_EXIST_MESSAGE, importName)
		)
	}
}
