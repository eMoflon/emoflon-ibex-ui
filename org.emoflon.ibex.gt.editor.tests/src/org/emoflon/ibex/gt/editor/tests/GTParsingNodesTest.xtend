package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for simple constraints, adding and deleting nodes and references.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingNodesTest extends GTParsingTest {
	@Test
	def void validContextNodes() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				a: EPackage
				b: EClass
			}
		''')
		this.assertValid(file)
		this.assertNode(file, 0, null, "a", "EPackage")
		this.assertNode(file, 1, null, "b", "EClass")
	}

	@Test
	def void validCreateAndDeleteNodes() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a() {
				++ a: EClass
				-- b: EObject
			}
		''')
		this.assertValid(file)
		this.assertNode(file, 0, Operator.CREATE, "a", "EClass")
		this.assertNode(file, 1, Operator.DELETE, "b", "EObject")
	}

	@Test
	def void errorIfNodeNameStartsWithCapital() {
		val nodeName = "AnInvalidNodeName"
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.INVALID_NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_STARTS_WITH_LOWER_CASE, nodeName)
		)
	}

	@Test
	def void errorIfNodeNameBlacklisted() {
		val nodeName = 'class'
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.INVALID_NAME_BLACKLISTED,
			String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_FORBIDDEN, nodeName)
		)
	}

	@Test
	def void errorIfNodeNameContainsUndercores() {
		val nodeName = 'the_e_Object'
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationIssues(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.INVALID_NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_CONTAINS_UNDERSCORES, nodeName)
		)
	}

	@Test
	def void errorIfMultipleNodesWithTheSameName() {
		val nodeName = 'a'
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EAnnotation
			
				«nodeName»: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.INVALID_NAME_EXPECT_UNIQUE,
			String.format(GTValidator.ERROR_MESSAGE_NODE_NAME_MULTIPLE_DECLARATIONS, nodeName, "twice")
		)
	}

	@Test
	def void errorIfNoSuchNodeType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a() {
				o: Object
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EClass 'Object'."
		)
	}

	@Test
	def void validContextReference() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule findClass() {
				package: EPackage {
					-eClassifiers -> clazz
				}
			
				clazz: EClass
			}
		''')
		this.assertValid(file)
		this.assertReference(file, 0, null, "eClassifiers", 1)
	}

	@Test
	def void validCreateAndDeleteReferences() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule createAndDeleteClass() {
				package: EPackage {
					++ -eClassifiers -> createdClass
					-- -eClassifiers -> deletedClass
				}
			
				++ createdClass: EClass
				-- deletedClass: EClass
			}
		''')
		this.assertValid(file)
		this.assertReference(file, 0, Operator.CREATE, "eClassifiers", 1)
		this.assertReference(file, 1, Operator.DELETE, "eClassifiers", 2)
	}

	@Ignore("Needs Causes Exception, seems to be a scoping problem")
	@Test
	def void errorIfNoSuchReferenceTypeInMetaModel() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule deleteClass() {
				package: EObject {
					-eClassifiers -> class
				}
			
				class: EClass
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.reference,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EReference 'name'."
		)
	}

	@Test
	def void errorIfWrongTargetType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule deleteClass() {
				package: EPackage {
					-eClassifiers -> class
				}
			
				class: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.reference,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Node 'class'."
		)
	}
}
