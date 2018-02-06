package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.BindingType
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for simple constraints, adding and deleting nodes and references.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class NodeParsingTest extends AbstractParsingTest {
	@Test
	def void validContextNodes() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a {
				a: EPackage
				b: EClass
			}
		''')
		this.assertValid(file)
		this.assertNode(file, 0, BindingType.CONTEXT, "a", "EPackage")
		this.assertNode(file, 1, BindingType.CONTEXT, "b", "EClass")
	}

	@Test
	def void validCreateAndDeleteNodes() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule a() {
				++ a: EClass
				-- b: EObject
			}
		''')
		this.assertValid(file)
		this.assertNode(file, 0, BindingType.CREATE, "a", "EClass")
		this.assertNode(file, 1, BindingType.DELETE, "b", "EObject")
	}

	@Test
	def void errorIfNoSuchNodeType() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
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
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule findClass() {
				package: EPackage {
					eClassifiers -> class
				}
			
				class: EClass
			}
		''')
		this.assertValid(file)
		this.assertReference(file, 0, BindingType.CONTEXT, "eClassifiers", 1)
	}

	@Test
	def void validCreateAndDeleteReferences() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule createAndDeleteClass() {
				package: EPackage {
					++ eClassifiers -> createdClass
					-- eClassifiers -> deletedClass
				}
			
				++ createdClass: EClass
				-- deletedClass: EClass
			}
		''')
		this.assertValid(file)
		this.assertReference(file, 0, BindingType.CREATE, "eClassifiers", 1)
		this.assertReference(file, 1, BindingType.DELETE, "eClassifiers", 2)
	}

	@Ignore("Needs Causes Exception, seems to be a scoping problem")
	@Test
	def void errorIfNoSuchReferenceTypeInMetaModel() {
		val file = parseHelper.parse('''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule deleteClass() {
				package: EObject {
					eClassifiers -> class
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
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule deleteClass() {
				package: EPackage {
					eClassifiers -> class
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
