package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.scoping.GTLinkingDiagnosticMessageProvider
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for nodes.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingNodesTest extends GTParsingTest {
	@Test
	def void validContextNodes() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
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
		val file = parse('''
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
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NAME_EXPECT_LOWER_CASE,
			String.format(GTValidator.NODE_NAME_STARTS_WITH_LOWER_CASE_MESSAGE, nodeName)
		)
	}

	@Test
	def void errorIfNodeNameBlacklisted() {
		val nodeName = 'class'
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NAME_BLACKLISTED,
			String.format(GTValidator.NODE_NAME_FORBIDDEN_MESSAGE, nodeName)
		)
	}

	@Test
	def void warningIfNodeNameContainsUndercores() {
		val nodeName = 'the_e_Object'
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationWarnings(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NAME_EXPECT_CAMEL_CASE,
			String.format(GTValidator.NODE_NAME_CONTAINS_UNDERSCORES_MESSAGE, nodeName)
		)
	}

	@Test
	def void errorIfMultipleNodesWithTheSameName() {
		val nodeName = 'a'
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				«nodeName»: EAnnotation
			
				«nodeName»: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NAME_EXPECT_UNIQUE,
			String.format(GTValidator.NODE_NAME_MULTIPLE_DECLARATIONS_MESSAGE, nodeName, "twice")
		)
	}

	@Test
	def void errorIfNoSuchNodeType() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a() {
				o: Object
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTLinkingDiagnosticMessageProvider.NODE_TYPE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.NODE_TYPE_NOT_FOUND_MESSAGE, 'Object')
		)
	}

	@Test
	def void errorIfCreatedNodeHasAbstractType() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a() {
				++ classifier: EClassifier
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.CREATE_NODE_TYPE_ABSTRACT,
			String.format(GTValidator.CREATE_NODE_TYPE_ABSTRACT_MESSAGE, 'classifier')
		)
	}

	@Test
	def void errorIfNodeOfSameNameAsParameter() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule a(clazz: EString) {
				++ clazz: EClass
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NODE_NAME_EQUALS_PARAMETER_NAME,
			String.format(GTValidator.NODE_NAME_EQUALS_PARAMETER_NAME_MESSAGE, 'clazz', 'clazz')
		)
	}

	@Test
	def void validNodeTypeChange() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern super {
				c: EClassifier
			}
			
			pattern findClass
			refines super {
				c: EClass
			}
		''')
		assertValid(file, 2)
	}

	@Test
	def void errorIfInvalidNodeTypeChange() {
		val file = parse('''
			import "«ecoreImport»"
			pattern super {
				c: EDataType
			}
			
			pattern findClass
			refines super {
				c: EClass
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE,
			String.format(GTValidator.NODE_TYPE_NOT_COMPATIBLE_WITH_DECLARATION_IN_SUPER_RULE_MESSAGE, 'c', 'EDataType',
				"pattern 'super'")
		)
	}

	@Test
	def void validNodeOperatorChange() {
		val file = parse('''
			import "«ecoreImport»"
			rule super {
				++ c: EClass
			}
			
			pattern findClass
			refines super {
				c: EClass
			}
		''')
		assertValid(file, 2)
	}

	@Test
	def void errorIfInvalidNodeOperatorChange() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern super {
				c: EClass
			}
			
			pattern findClass
			refines super {
				++ c: EClass
			}
		''')
		assertFile(file, 2)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorNode,
			GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE,
			String.format(GTValidator.NODE_OPERATOR_EXPECT_CONTEXT_DUE_TO_DECLARATION_IN_SUPER_RULE_MESSAGE, 'c',
				GTValidator.concatNames(#['super']))
		)
	}
}
