package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.utils.GTFlattener
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit tests for rule refinement.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingPatternRefinementFlatteningTest extends GTParsingTest {

	@Test
	def void validFlattening() {
		val file = parse('''
			import "«ecoreImport»"
			
			abstract pattern findClassifierWithAnnotation(name: EString) {
				classifier: EClassifier {
					.name == param::name
					-eAnnotations -> annotation
				}
			
				annotation: EAnnotation
			}
			
			pattern findClassWithAnnotation(attributeName: EString)
			refines findClassifierWithAnnotation {
				classifier: EClass {
					.interface == true
					-eAnnotations -> annotation
					-eAttributes -> attribute
				}
			
				attribute: EAttribute {
					.name == param::attributeName
				}
			}
		''')
		assertValid(file, 2)
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertFalse(flattener.hasErrors)
		Assert.assertEquals(#[], flattener.errors)

		val flattenedRule = flattener.getFlattenedPattern
		assertParameters(flattenedRule, #{'attributeName' -> 'EString', 'name' -> 'EString'})
		Assert.assertArrayEquals(#['attributeName', 'name'], flattenedRule.parameters.map[it.name].toArray)

		Assert.assertEquals(3, flattenedRule.nodes.size);
		assertNode(flattenedRule.getNode(0), EditorOperator.CONTEXT, "annotation", "EAnnotation", 0, 0)
		assertNode(flattenedRule.getNode(1), EditorOperator.CONTEXT, "attribute", "EAttribute", 1, 0)
		assertNode(flattenedRule.getNode(2), EditorOperator.CONTEXT, "classifier", "EClass", 2, 2)
	}

	@Test
	def void validFlatteningWithAttributes() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern findClass(name: EString) {
				clazz: EClass {
					.^abstract == false
					.name == param::name
				}
			}
			
			rule renameClass(name: EString, newName: EString, interface: EBoolean)
			refines findClass {
				clazz: EClass {
					.^abstract == false
					.^abstract != true
					.name := param::newName
					.interface := param::interface
				}
			}
		''')
		assertValid(file, 2)
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertFalse(flattener.hasErrors)
		Assert.assertEquals(#[], flattener.errors)

		val flattenedRule = flattener.getFlattenedPattern
		assertParameters(flattenedRule, #{'name' -> 'EString', 'newName' -> 'EString', 'interface' -> 'EBoolean'})
		Assert.assertArrayEquals(#['name', 'newName', 'interface'], flattenedRule.parameters.map[it.name].toArray)

		assertNode(flattenedRule.getNode(0), EditorOperator.CONTEXT, "clazz", "EClass", 5, 0)
		Assert.assertEquals(2,
			flattenedRule.getNode(0).attributes.size)
	}

	@Test
	def void validFlatteningOfReferences() {
		val file = parse('''
			import "«ecoreImport»"
			
			abstract rule findClassifierWithAnnotation {
				package: EPackage
			
				classifier: EClassifier {
					-ePackage -> package
					++ -eAnnotations -> annotation
				}
			
				++ annotation: EAnnotation
			}
			
			pattern findClassWithAnnotation
			refines findClassifierWithAnnotation {
				classifier: EClass {
					-eAnnotations -> annotation
					-eAnnotations -> annotation2
				}
			
				annotation: EAnnotation
			
				annotation2: EAnnotation
			}
		''')
		assertValid(file, 2)
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertFalse(flattener.hasErrors)
		Assert.assertEquals(#[], flattener.errors)

		val flattenedRule = flattener.getFlattenedPattern

		Assert.assertEquals(4, flattenedRule.nodes.size);
		assertNode(flattenedRule.getNode(0), EditorOperator.CONTEXT, "annotation", "EAnnotation", 0, 0)
		assertNode(flattenedRule.getNode(1), EditorOperator.CONTEXT, "annotation2", "EAnnotation", 0, 0)
		assertNode(flattenedRule.getNode(2), EditorOperator.CONTEXT, "classifier", "EClass", 0, 3)
		assertNode(flattenedRule.getNode(3), EditorOperator.CONTEXT, "package", "EPackage", 0, 0)
	}

	@Test
	def void errorForFlatteningRuleWithConflictingAttributeAssignments() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule renameClass(oldName: EString) {
				clazz: EClass {
					.name == param::oldName
					.instanceClassName := "Test"
					.instanceTypeName := "TestType"
				}
			}
			
			rule renameClass2(oldName: EString, newName: EString)
			refines renameClass {
				clazz: EClass {
					.name == param::oldName
					.instanceClassName := param::newName
					.instanceTypeName == "TestType"
				}
			}
		''')
		assertFile(file, 2)
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertTrue(flattener.hasErrors)
		val errors = #['Node clazz has multiple assignments for attribute instanceClassName.']
		Assert.assertEquals(errors, flattener.errors)
	}

	@Test
	def void errorForFlatteningRuleWithInconsistentParameterDeclarations() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern findClass(interface: EBoolean, name: EString) {
				clazz: EClass {
					.interface == param::interface
					.name == param::name
				}
			}
			
			pattern findClassDuplicate(interface: EBoolean, name: EBoolean)
			refines findClass {
				clazz2: EClass {
					.interface == param::interface
				}
			}
		''')
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertTrue(flattener.hasErrors)
		val errors = #['Inconsistent type declarations for parameter name: EBoolean and EString.']
		Assert.assertEquals(errors, flattener.errors)
	}

	@Test
	def void errorForInvalidOperators() {
		val file = parse('''
			import "«ecoreImport»"
			
			rule createAnnotation {
				package: EPackage
			
				classifier: EClassifier {
					-ePackage -> package
					++ -eAnnotations -> annotation
				}
			
				++ annotation: EAnnotation
			}
			
			rule deleteAnnotation
			refines createAnnotation {
				classifier: EClass {
					-- -eAnnotations -> annotation
				}
			
				-- annotation: EAnnotation
			}
		''')
		assertValid(file, 2)
		val flattener = new GTFlattener(file.getRule(1))
		Assert.assertTrue(flattener.hasErrors)
		val errors = #[
			'Reference between classifier and annotation: Cannot merge operators DELETE and CREATE.',
			'Node annotation: Cannot merge operators DELETE and CREATE.'
		]
		Assert.assertEquals(errors, flattener.errors)
	}
}
