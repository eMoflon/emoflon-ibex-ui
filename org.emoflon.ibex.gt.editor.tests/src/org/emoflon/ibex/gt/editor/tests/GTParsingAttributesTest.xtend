package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Relation
import org.emoflon.ibex.gt.editor.validation.GTValidator
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
			import "«ecoreImport»"
			
			rule a {
				classifier: EClassifier {
					.name := "Test1"
					.instanceTypeName := "Test2"
				}
			}
		''')
		this.assertValid(file)
		this.assertAttributeLiteral(file, 0, "name", Relation.ASSIGNMENT, "Test1")
		this.assertAttributeLiteral(file, 1, "instanceTypeName", Relation.ASSIGNMENT, "Test2")
	}

	@Test
	def void validAttributeConditions() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				classifier: EClassifier {
					.name != "Test1"
					.instanceTypeName == "Test2"
				}
			}
		''')
		this.assertValid(file)
		this.assertAttributeLiteral(file, 0, "name", Relation.UNEQUAL, "Test1")
		this.assertAttributeLiteral(file, 1, "instanceTypeName", Relation.EQUAL, "Test2")
	}

	@Test
	def void validAttributeConditionReferencingParameter() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EString) {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertValid(file)
		this.assertAttributeParameter(file, 0, "name", Relation.ASSIGNMENT, 0)
	}

	@Test
	def void errorIfAttributeConditionReferencesParameterOfInvalidType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EBoolean) {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.parameterValue,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Parameter 'name'."
		)
	}

	@Test
	def void errorIfAttributeConstraintWithConstantOfWrongType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createAbstractTestClass {
				++ clazz: EClass {
					.^abstract := "Test" // Expecting EBoolean here.
				}
				
				reference: EReference {
					.ordered == true
					.lowerBound == 2.5   // Expecting EInt here.
					.upperBound == false // Expecting EInt here.
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "abstract", "EBoolean"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "lowerBound", "EInt"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "upperBound", "EInt")
		)
	}
	
	@Test
	def void errorIfAttributeConstraintWithWrongStringConstant() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createAbstractTestClass {
				++ clazz: EClass {
					.name := true        // Expecting EString here.
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "name", "EString")
		)
	}

	@Test
	def void errorIfMultipleAttributeAssignmentsForSameAttribute() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				clazz: EClass {
					.name := "Test1"
					.name := "Test2"
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS,
			String.format(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS_MESSAGE, 2, 'name')
		)
	}

	@Test
	def void errorIfAttributeAssignmentInDeletedNode() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				-- clazz: EClass {
					.name := "Test"
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE,
			String.format(GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE_MESSAGE, 'name', 'clazz')
		)
	}

	@Test
	def void errorIfAttributeConditionInCreatedNode() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				++ clazz: EClass {
					.name == "Test"
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE,
			String.format(GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE_MESSAGE, 'name', 'clazz')
		)
	}

	@Test
	def void errorIfNoSuchAttributeInMetaModel() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				classifier: EObject {
					.name == "Test"
				}
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.attributeConstraint,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EAttribute 'name'."
		)
	}
}
