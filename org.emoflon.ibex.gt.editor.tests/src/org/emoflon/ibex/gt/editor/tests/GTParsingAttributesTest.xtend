package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
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
	def void validAttributeAssignmentsWithLiteral() {
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
		val node = file.getRule(0).getNode(0)
		this.assertAttributeLiteral(node.getAttribute(0), "name", EditorRelation.ASSIGNMENT, "Test1")
		this.assertAttributeLiteral(node.getAttribute(1), "instanceTypeName", EditorRelation.ASSIGNMENT, "Test2")
	}

	@Test
	def void validAttributeWithLiteral() {
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
		val node = file.getRule(0).getNode(0)
		this.assertAttributeLiteral(node.getAttribute(0), "name", EditorRelation.UNEQUAL, "Test1")
		this.assertAttributeLiteral(node.getAttribute(1), "instanceTypeName", EditorRelation.EQUAL, "Test2")
	}

	@Test
	def void validAttributeWithAttributeExpression() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule findClassAndPackageOfTheSameName {
				package: EPackage
			
				clazz: EClass {
					.name == package.name
				}
			}
		''')
		this.assertValid(file)
		val node = file.getRule(0).getNode(1)
		val targetNode = file.getRule(0).getNode(0)
		this.assertAttributeWithAttributeExpression(node.getAttribute(0), "name", EditorRelation.EQUAL, targetNode, "name")
	}

	@Test
	def void errorIfAttributeWithAttributeExpressionReferencingInvalidNode() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule findClassAndPackageOfTheSameName {
				++ package: EPackage
			
				clazz: EClass {
					.name == package
				}
			}
		''')
		this.assertInvalidResource(file, 1)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeExpression,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Node 'package'."
		)
	}

	@Test
	def void errorIfAttributeWithAttributeExpressionReferencingInvalidAttribute() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule r {
				dataType: EDataType
				
				clazz: EClass {
					.name == dataType.serializable
				}
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeExpression,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EAttribute 'serializable'."
		)
	}

	@Test
	def void validAttributeWithParameter() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EString) {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertValid(file)
		val node = file.getRule(0).getNode(0)
		val parameter = file.getRule(0).getParameter(0)
		this.assertAttributeParameter(node.getAttribute(0), "name", EditorRelation.ASSIGNMENT, parameter)
	}

	@Test
	def void validAttributeWithParameterFromSuperRule() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule s(name: EString) {
				object: EObject
			}
			
			rule createClass
			refines s {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertValid(file, 2)
		val node = file.getRule(1).getNode(0)
		val parameter = file.getRule(0).getParameter(0)
		this.assertAttributeParameter(node.getAttribute(0), "name", EditorRelation.ASSIGNMENT, parameter)
	}

	@Test
	def void errorIfAttributeWithParameterOfInvalidType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EBoolean) {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameterExpression,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Parameter 'name'."
		)
	}

	@Test
	def void errorIfAttributeWithLiteralOfWrongType() {
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
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "abstract", "EBoolean"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "lowerBound", "EInt"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "upperBound", "EInt")
		)
	}

	@Test
	def void errorIfAttributeWithWrongStringConstant() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createAbstractTestClass {
				++ clazz: EClass {
					.name := true        // Expecting EString here.
				}
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "name", "EString")
		)
	}

	@Test
	def void errorIfComparisonForIncomparableType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				clazz: EClass {
					.^abstract >= false
				}
			}
		''')
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
			GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE,
			String.format(GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE_MESSAGE, ">=", "abstract")
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
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
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
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
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
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
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
		this.assertFile(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttribute,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EAttribute 'name'."
		)
	}
}
