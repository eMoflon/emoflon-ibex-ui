package org.emoflon.ibex.gt.editor.tests

import com.google.inject.Inject

import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.junit.runner.RunWith
import org.junit.Test
import org.eclipse.xtext.resource.SaveOptions

import static org.junit.Assert.*

/**
 * JUnit tests for formatting.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTFormattingTest {
	@Inject
	protected ParseHelper<GraphTransformationFile> parseHelper

	@Inject extension ISerializer

	@Test
	def formatRules() {
		val expected = '''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule test {
				object: EObject
			}
			
			abstract rule test2 {
				name: EAnnotation
			}
		'''
		this.testFormatting(
			expected,
			'''
				import "http://www.eclipse.org/emf/2002/Ecore"rule 
				test{object: EObject}abstract 
				rule test2 {name: EAnnotation}
			'''
		)
		this.testFormatting(
			expected,
			'''
				
				import "http://www.eclipse.org/emf/2002/Ecore"
					
				rule 	test 	{
				object	: EObject
				}
					
				abstract
				rule  test2{
					name   :   
					EAnnotation}
			'''
		)
	}

	@Test
	def formatParameters() {
		val expected = '''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule test(a: EObject, b: EObject) {
				c: EObject
			}
		'''
		this.testFormatting(
			expected,
			'''
				import "http://www.eclipse.org/emf/2002/Ecore"
				rule test (	  a :  EObject ,  b :  EObject )
					{
				c: EObject
					}
			'''
		)
	}

	@Test
	def formatReferences() {
		val expected = '''
			import "http://www.eclipse.org/emf/2002/Ecore"
			
			rule test {
				a: EAnnotation {
					-eAnnotations -> b
					-- -eAnnotations -> c
				}
			
				b: EAnnotation {
					++ -eAnnotations -> c
				}
			
				c: EAnnotation
			}
		'''
		this.testFormatting(
			expected,
			'''
				import "http://www.eclipse.org/emf/2002/Ecore"
				rule test {
				a: EAnnotation {   -   eAnnotations   ->    b	
				-- -eAnnotations  ->  c}	
				
				b: EAnnotation  
				{
				++- eAnnotations->c
				}
				c: EAnnotation
				}
			'''
		)
	}

	def testFormatting(String expected, String code) {
		assertEquals(expected, parseHelper.parse(code).serialize(SaveOptions.newBuilder.format.options))
	}
}
