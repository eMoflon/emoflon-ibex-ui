package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.scoping.GTLinkingDiagnosticMessageProvider
import org.emoflon.ibex.gt.editor.validation.GTValidator
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for simple constraints, adding and deleting nodes and references.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingReferencesTest extends GTParsingTest {
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
		val rule = file.getRule(0)
		assertReference(rule.getNode(0).getReference(0), EditorOperator.CONTEXT, "eClassifiers", rule.getNode(1))
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
		val rule = file.getRule(0)
		assertReference(rule.getNode(0).getReference(0), EditorOperator.CREATE, "eClassifiers", rule.getNode(1))
		assertReference(rule.getNode(0).getReference(1), EditorOperator.DELETE, "eClassifiers", rule.getNode(2))
	}

	@Test
	def void validUseOfNodesFromSuperRules() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule s {
				++ createdClass: EClass
				-- deletedClass: EClass
			}
			
			rule r
			refines s {
				package: EPackage {
					++ -eClassifiers -> createdClass
					-- -eClassifiers -> deletedClass
				}
			}
		''')
		this.assertValid(file, 2)
		val ruleS = file.getRule(0)
		val ruleR = file.getRule(1)
		assertReference(ruleR.getNode(0).getReference(0), EditorOperator.CREATE, "eClassifiers", ruleS.getNode(0))
		assertReference(ruleR.getNode(0).getReference(1), EditorOperator.DELETE, "eClassifiers", ruleS.getNode(1))
	}

	@Ignore("Needs Causes Exception, seems to be a scoping problem")
	@Test
	def void errorIfNoSuchReferenceTypeInMetaModel() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule deleteClass() {
				package: EObject {
					-eClassifiers -> clazz
				}
			
				clazz: EClass
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorReference,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to EReference 'name'."
		)
	}

	@Test
	def void errorIfReferenceHasWrongTargetType() {
		val file = parseHelper.parse('''
			import "«ecoreImport»"
			
			rule deleteClass() {
				package: EPackage {
					-eClassifiers -> clazz
				}
			
				clazz: EObject
			}
		''')
		assertFile(file)
		assertValidationErrors(
			file,
			GTPackage.eINSTANCE.editorReference,
			GTLinkingDiagnosticMessageProvider.REFERENCE_TARGET_NODE_NOT_FOUND,
			String.format(GTLinkingDiagnosticMessageProvider.REFERENCE_TARGET_NODE_NOT_FOUND_MESSAGE, 'clazz', 'EClassifier')
		)
	}

	@Test
	def void errorIfCreatedNodeHasContextReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('++', '', ''),
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_CONTEXT,
			String.format(GTValidator.REFERENCE_EXPECT_CREATED_MESSAGE, 'eClassifiers', 'clazz')
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
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_EXPECT_CREATED_BUT_IS_DELETED,
			String.format(GTValidator.REFERENCE_EXPECT_CREATED_MESSAGE, 'eClassifiers', 'clazz')
		)
	}

	@Test
	def void errorIfDeletedNodeHasContextReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('--', '', ''),
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CONTEXT,
			String.format(GTValidator.REFERENCE_EXPECT_DELETED_MESSAGE, 'eClassifiers', 'clazz')
		)
	}

	@Test
	def void errorIfDeletedNodeHasCreatedReference() {
		this.assertValidationErrors(
			this.parseNodesWithReference('--', '++', ''),
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_EXPECT_DELETED_BUT_IS_CREATED,
			String.format(GTValidator.REFERENCE_EXPECT_DELETED_MESSAGE, 'eClassifiers', 'clazz')
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
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT,
			String.format(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfContextReferenceWithDeletedTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '', '--'),
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT,
			String.format(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_MESSAGE, 'eClassifiers')
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
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE,
			String.format(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_CREATE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedReferenceWithContextNodeTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '--', ''))
	}

	@Test
	def void errorIfDeletedReferenceWithCreatedNodeTargetNode() {
		this.assertValidationErrors(
			this.parseNodesWithReference('', '--', '++'),
			GTPackage.eINSTANCE.editorReference,
			GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE,
			String.format(GTValidator.REFERENCE_TARGET_EXPECT_CONTEXT_OR_DELETE_MESSAGE, 'eClassifiers')
		)
	}

	@Test
	def void errorIfDeletedReferenceWithDeletedNodeTargetNode() {
		this.assertValid(this.parseNodesWithReference('', '--', '--'))
	}

	def EditorGTFile parseNodesWithReference(String sourceNodeOperator, String referenceOperator,
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
