package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.emoflon.ibex.gt.editor.utils.GTCommentExtractor

/**
 * JUnit tests for extracting comments from the Xtext model.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingCommentsTest extends GTParsingTest {
	static val testComment = "Finds an object."

	@Test
	def extractNoComment() {
		val file = parse('''
			import "«ecoreImport»"
			
			pattern a {
				object: EObject
			}
		''')
		assertValid(file)
		Assert.assertEquals("", GTCommentExtractor.getComment(file.getRule(0)))
	}

	@Test
	def extractSingleLineComment() {
		val file = parse('''
			import "«ecoreImport»"
			
			// «testComment»
			pattern a {
				object: EObject
			}
		''')
		assertValid(file)
		Assert.assertEquals(testComment, GTCommentExtractor.getComment(file.getRule(0)))
	}

	@Test
	def extractMultiLineComment() {
		val file = parse('''
			import "«ecoreImport»"
			
			/**
			 * «testComment»
			 */
			pattern a {
				object: EObject
			}
			
			/*
			 * «testComment»
			 */
			pattern b {
				object: EObject
			}
			
			/* «testComment» */
			pattern c {
				object: EObject
			}
		''')
		assertValid(file, 3)
		for (rule : file.patterns) {
			Assert.assertEquals(testComment, GTCommentExtractor.getComment(rule))
		}
	}
}
