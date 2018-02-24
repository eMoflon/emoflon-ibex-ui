package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for attribute assignments and conditions.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingAttributesTest extends GTParsingTest {
	@Test
	def void validAttributeAssignments() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				classifier: EClassifier {
					name = "Test1"
					instanceTypeName = "Test2"
				}
			}
		''')
		this.assertValid(file)
		this.assertAttributeAssignment(file, 0, "name", "Test1")
		this.assertAttributeAssignment(file, 1, "instanceTypeName", "Test2")
	}

	@Test
	def void validAttributeConditions() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				classifier: EClassifier {
					name == "Test1"
					instanceTypeName == "Test2"
				}
			}
		''')
		this.assertValid(file)
		this.assertAttributeCondition(file, 0, "name", "Test1")
		this.assertAttributeCondition(file, 1, "instanceTypeName", "Test2")
	}

	@Test
	def void errorIfNoSuchAttributeInMetaModel() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				classifier: EObject {
					name = "Test"
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeAssignment,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EAttribute 'name'."
		)
	}
}
