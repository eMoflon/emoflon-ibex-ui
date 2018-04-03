package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.GTPackage
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
		assertValid(file)
		val rule = file.getRule(0)
		assertNode(rule.getNode(0), EditorOperator.CONTEXT, "a", "EPackage")
		assertNode(rule.getNode(1), EditorOperator.CONTEXT, "b", "EClass")
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
		assertValid(file)
		val rule = file.getRule(0)
		assertNode(rule.getNode(0), EditorOperator.CREATE, "a", "EClass")
		assertNode(rule.getNode(1), EditorOperator.DELETE, "b", "EObject")
	}

	@Test
	def void warningIfNodeNameStartsWithCapital() {
		val nodeName = "AnInvalidNodeName"
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationIssues(
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
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.NODE_NAME_FORBIDDEN_MESSAGE, nodeName)
		)
	}

	@Test
	def void warningIfNodeNameContainsUndercores() {
		val nodeName = 'the_e_Object'
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a {
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationIssues(
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
		assertFile(file)
		assertValidationErrors(
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
		assertFile(file)
		assertValidationErrors(
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
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.CREATE_NODE_TYPE_ABSTRACT,
			String.format(GTValidator.CREATE_NODE_TYPE_ABSTRACT_MESSAGE, 'classifier')
		)
	}

	@Test
	def void errorIfNodeOfSameNameAsParameter() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule a(clazz: EString) {
				++ clazz: EClass
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.NODE_NAME_EQUALS_PARAMETER_NAME,
			String.format(GTValidator.NODE_NAME_EQUALS_PARAMETER_NAME_MESSAGE, 'clazz', 'clazz')
		)
	}

	@Test
	def void validNodeTypeChange() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule super {
				c: EClassifier
			}
			
			rule findClass
			refines super {
				c: EClass
			}
		''')
		assertValid(file, 2)
	}

	@Test
	def void errorIfInvalidNodeTypeChange() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			rule super {
				c: EDataType
			}
			
			rule findClass
			refines super {
				c: EClass
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE,
			String.format(GTValidator.NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE, 'c', 'EDataType',
				'super')
		)
	}

	@Test
	def void validNodeOperatorChange() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			rule super {
				++ c: EClass
			}
			
			rule findClass
			refines super {
				c: EClass
			}
		''')
		assertValid(file, 2)
	}

	@Test
	def void errorIfInvalidNodeOperatorChange() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule super {
				c: EClass
			}
			
			rule findClass
			refines super {
				++ c: EClass
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.node,
			GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE,
			String.format(GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE_MESSAGE, 'c',
				GTValidator.concatNames(#['super']))
		)
	}
}
