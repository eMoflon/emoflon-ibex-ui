package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.validation.GTValidator
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
		this.assertNode(file, 0, Operator.CONTEXT, "a", "EPackage")
		this.assertNode(file, 1, Operator.CONTEXT, "b", "EClass")
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
			GTValidator.NAME_EXPECT_LOWER_CASE,
			Severity.WARNING,
			String.format(GTValidator.NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, nodeName)
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
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.NODE_NAME_FORBIDDEN_MESSAGE, nodeName)
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
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			Severity.WARNING,
			String.format(GTValidator.NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE, nodeName)
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
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, nodeName, "twice")
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
	def void errorIfCreatedNodeHasAbstractType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a() {
				++ classifier: EClassifier
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.CREATE_NODE_TYPE_ABSTRACT,
			String.format(GTValidator.CREATE_NODE_TYPE_ABSTRACT_MESSAGE, 'classifier')
		)
	}
}
