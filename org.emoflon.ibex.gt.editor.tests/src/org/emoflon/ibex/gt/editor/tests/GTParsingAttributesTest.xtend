package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.scoping.GTLinkingDiagnosticMessageProvider
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
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				classifier: EClassifier {
					.name := "Test1"
					.instanceTypeName := "Test2"
				}
			}
		''')
		assertValid(file)
		val node = file.getRule(0).getNode(0)
		assertAttributeLiteral(node.getAttribute(0), "name", "Test1")
		assertAttributeLiteral(node.getAttribute(1), "instanceTypeName", "Test2")
	}

	@Test
	def void validAttributeWithLiteral() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				classifier: EClassifier {
					.name != "Test1"
					.instanceTypeName == "Test2"
				}
			}
		''')
		assertValid(file)
		val node = file.getRule(0)
		assertAttributeLiteral(node.attributeConstraints.get(0), "name", EditorRelation.UNEQUAL, "Test1")
		assertAttributeLiteral(node.attributeConstraints.get(0), "instanceTypeName", EditorRelation.EQUAL, "Test2")
	}

	@Test
	def void validAttributeWithAttributeExpression() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern findClassAndPackageOfTheSameName {
				package: EPackage
			
				clazz: EClass {
					.name == package.name
				}
			}
		''')
		assertValid(file)
		val node = file.getRule(0).getNode(1)
		val targetNode = file.getRule(0).getNode(0)
		assertAttributeWithAttributeExpression(file.getRule(0).attributeConstraints.get(0), "name", EditorRelation.EQUAL, targetNode, "name")
	}

	@Test
	def void errorIfAttributeWithAttributeExpressionReferencingInvalidNode() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule findClassAndPackageOfTheSameName {
				++ package: EPackage
			
				clazz: EClass {
					.name == package
				}
			}
		''')
		assertInvalidResource(file, 1)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeExpression,
			GTLinkingDiagnosticMessageProvider.ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.ATTRIBUTE_EXPRESSION_NODE_NOT_FOUND_MESSAGE, 'package')
		)
	}

	@Test
	def void errorIfAttributeWithAttributeExpressionReferencingInvalidAttribute() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern r {
				dataType: EDataType
				
				clazz: EClass {
					.name == dataType.x
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeExpression,
			GTLinkingDiagnosticMessageProvider.ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.ATTRIBUTE_EXPRESSION_ATTRIBUTE_NOT_FOUND_MESSAGE, 'x')
		)
	}

	@Test
	def void validAttributeWithParameter() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EString) {
				++ clazz: EClass {
					.name := param::name
				}
			}
		''')
		assertValid(file)
		val node = file.getRule(0).getNode(0)
		val parameter = file.getRule(0).getParameter(0)
		assertAttributeParameter(node.getAttribute(0), "name", parameter)
	}

	@Test
	def void validAttributeWithParameterFromSuperRule() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern s(name: EString) {
				object: EObject
			}
			
			rule createClass
			refines s {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		assertValid(file, 2)
		val node = file.getRule(1).getNode(0)
		val parameter = file.getRule(0).getParameter(0)
		assertAttributeParameter(node.getAttribute(0), "name", parameter)
	}

	@Test
	def void errorIfAttributeWithParameterOfInvalidType() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule createClass(name: EBoolean) {
				clazz: EClass {
					.name := param::name
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorParameterExpression,
			GTLinkingDiagnosticMessageProvider.PARAMETER_EXPRESSION_PARAMETER_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.PARAMETER_EXPRESSION_PARAMETER_NOT_FOUND_MESSAGE, 'name',
				'EString')
		)
	}

	@Test
	def void errorIfAttributeWithLiteralOfWrongType() {
		val file = parse('''
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
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeAssignment,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "abstract", "EBoolean"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "lowerBound", "EInt"),
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "upperBound", "EInt")
		)
	}

	@Test
	def void errorIfAttributeWithWrongStringConstant() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule createAbstractTestClass {
				++ clazz: EClass {
					.name := true        // Expecting EString here.
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeAssignment,
			GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE,
			String.format(GTValidator.ATTRIBUTE_LITERAL_VALUE_WRONG_TYPE_MESSAGE, "name", "EString")
		)
	}

	@Test
	def void errorIfComparisonForIncomparableType() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				clazz: EClass {
					.^abstract >= false
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeAssignment,
			GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE,
			String.format(GTValidator.ATTRIBUTE_RELATION_TYPE_NOT_COMPARABLE_MESSAGE, ">=", "abstract")
		)
	}

	@Test
	def void errorIfMultipleAttributeAssignmentsForSameAttribute() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				clazz: EClass {
					.name := "Test1"
					.name := "Test2"
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeAssignment,
			GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS,
			String.format(GTValidator.ATTRIBUTE_MULTIPLE_ASSIGNMENTS_MESSAGE, 2, 'name')
		)
	}

	@Test
	def void errorIfAttributeAssignmentInDeletedNode() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				-- clazz: EClass {
					.name := "Test"
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeAssignment,
			GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE,
			String.format(GTValidator.ATTRIBUTE_ASSIGNMENT_IN_DELETED_NODE_MESSAGE, 'name', 'clazz')
		)
	}

	@Test
	def void errorIfAttributeConditionInCreatedNode() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a {
				++ clazz: EClass {
					.name == "Test"
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeConstraint,
			GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE,
			String.format(GTValidator.ATTRIBUTE_CONDITION_IN_CREATED_NODE_MESSAGE, 'name', 'clazz')
		)
	}

	@Test
	def void warningIfDuplicateAttributeConditions() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				clazz: EClass {
					.name == "Test"
					.name == "Test"
				}
			}
		''')
		assertFile(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorAttributeConstraint,
			GTValidator.ATTRIBUTE_DUPLICATE_CONDITION,
			String.format(GTValidator.ATTRIBUTE_DUPLICATE_CONDITION_MESSAGE, 'name', 'clazz', 'twice')
		)
	}

	@Test
	def void errorIfNoSuchAttributeInMetaModel() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				classifier: EObject {
					.name == "Test"
				}
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorAttributeConstraint,
			GTLinkingDiagnosticMessageProvider.ATTRIBUTE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.ATTRIBUTE_NOT_FOUND_MESSAGE, 'name')
		)
	}
}
