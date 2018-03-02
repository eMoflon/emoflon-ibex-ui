package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
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
					-eClassifiers -> clazz
				}
			
				clazz: EObject
			}
		''')
		this.assertBasics(file)
		this.assertValidationErrors(
			file,
			GTPackage.eINSTANCE.reference,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to Node 'clazz'."
		)
	}

	@Test
	def void errorIfCreatedNodeHasContextReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('++', '', ''),
			GTPackage.eINSTANCE.node,
			GTValidator.REFERENCE_EXPECT_CREATE,
			String.format(GTValidator.REFERENCE_EXPECT_CREATE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void validCreatedNodeHasCreatedReference() {
		this.assertValid(this.parseNodesWithReference('++', '++', ''))
	}

	@Test
	def void errorIfCreatedNodeHasDeletedReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('++', '--', ''),
			GTPackage.eINSTANCE.node,
			GTValidator.REFERENCE_EXPECT_CREATE,
			String.format(GTValidator.REFERENCE_EXPECT_CREATE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedNodeHasContextReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('--', '', ''),
			GTPackage.eINSTANCE.node,
			GTValidator.REFERENCE_EXPECT_DELETE,
			String.format(GTValidator.REFERENCE_EXPECT_DELETE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedNodeHasCreatedReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('--', '++', ''),
			GTPackage.eINSTANCE.node,
			GTValidator.REFERENCE_EXPECT_DELETE,
			String.format(GTValidator.REFERENCE_EXPECT_DELETE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void validDeletedNodeHasDeletedReference() {
		this.assertValid(this.parseNodesWithReference('', '--', '--'))
	}

	@Test
	def void validContextReferenceWithContextTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '', ''))
	}

	@Test
	def void errorIfContextReferenceWithCreatedTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '', '++'),
			GTPackage.eINSTANCE.contextReference,
			GTValidator.NODE_TARGET_EXPECT_CONTEXT,
			String.format(GTValidator.NODE_TARGET_EXPECT_CONTEXT_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfContextReferenceWithDeletedTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '', '--'),
			GTPackage.eINSTANCE.contextReference,
			GTValidator.NODE_TARGET_EXPECT_CONTEXT,
			String.format(GTValidator.NODE_TARGET_EXPECT_CONTEXT_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void validCreatedReferenceWithContextTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '++', ''))
	}

	@Test
	def void validCreatedReferenceWithCreateTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '++', '++'))
	}

	@Test
	def void errorIfCreatedReferenceWithDeletedTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '++', '--'),
			GTPackage.eINSTANCE.operatorReference,
			GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_CREATE,
			String.format(GTValidator.NODE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedReferenceWithContextNodeTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '--', ''),
			GTPackage.eINSTANCE.operatorReference,
			GTValidator.NODE_TARGET_EXPECT_DELETE,
			String.format(GTValidator.NODE_TARGET_EXPECT_DELETE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedReferenceWithCreatedNodeTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '--', '++'),
			GTPackage.eINSTANCE.operatorReference,
			GTValidator.NODE_TARGET_EXPECT_DELETE,
			String.format(GTValidator.NODE_TARGET_EXPECT_DELETE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedReferenceWithDeletedNodeTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '--', '--'))
	}

	def GraphTransformationFile parseNodesWithReference(String sourceNodeOperator, String referenceOperator,
		String targetNodeOperator) {
		parseHelper.parse('''
			import "«ecoreImport»"
			
			rule r1 {
				«sourceNodeOperator» package: EPackage {
					«referenceOperator» -eClassifiers -> clazz
				}
			
				«targetNodeOperator» clazz: EClass
			}
		''')
	}
}
