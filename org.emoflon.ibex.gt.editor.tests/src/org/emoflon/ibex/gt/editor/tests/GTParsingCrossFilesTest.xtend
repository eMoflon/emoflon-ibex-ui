package org.emoflon.ibex.gt.editor.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * JUnit tests for cross file references for conditions and patterns.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
class GTParsingCrossFilesTest extends GTParsingTest {

	@Test
	def void resolvePatternsFromOtherFiles() {
		val files = parseTwoFilesFromSamePackage(
			'''
				import "«ecoreImport»"
				
				pattern p {
					object: EObject
				}
				
				pattern q {
					object: EObject
				}
			''',
			'''
				import "«ecoreImport»"
				
				pattern r
				refines p, q
			'''
		)

		val file1 = files.get(0)
		val file2 = files.get(1)

		assertValid(file1, 2)
		assertValid(file2, 1)

		// file2: resolve refences to patterns from file1
		Assert.assertEquals(#[file1.getRule(0), file1.getRule(1)], file2.getRule(0).superPatterns)
	}

	@Test
	def void resolveConditionsFromOtherFiles() {
		val files = parseTwoFilesFromSamePackage(
			'''
				import "«ecoreImport»"
				
				pattern p {
					object: EObject
				}
				
				pattern q {
					object: EObject
				}
				when c
			''',
			'''
				import "«ecoreImport»"
				
				condition c = forbid p
			'''
		)

		val file1 = files.get(0)
		val file2 = files.get(1)

		assertValid(file1, 2)
		assertValid(file2, 0)

		val p = file1.getRule(0)
		val q = file1.getRule(1)
		val c = file2.conditions.get(0)

		// file1.gt: resolve reference to condition c from file2.gt 
		Assert.assertEquals(1, q.conditions.size)
		Assert.assertEquals(c, q.conditions.get(0))

		// file2.gt: resolve reference to pattern p from file1.gt
		Assert.assertEquals(1, c.conditions.size)
		val c1 = c.conditions.get(0)
		Assert.assertTrue(c1 instanceof EditorForbid)
		Assert.assertEquals(p, (c1 as EditorForbid).pattern)
	}

	def parseTwoFilesFromSamePackage(CharSequence s1, CharSequence s2) {
		return parseTwoFiles(
			s1,
			URI.createPlatformResourceURI("/TestProject/src/myPackage/file1.gt", true),
			s2,
			URI.createPlatformResourceURI("/TestProject/src/myPackage/file2.gt", true)
		)
	}

	def parseTwoFiles(CharSequence s1, URI uri1, CharSequence s2, URI uri2) {
		val resourceSet = new XtextResourceSet
		val file1 = parseHelper.parse(s1, uri1, resourceSet)
		val file2 = parseHelper.parse(s2, uri2, resourceSet)
		return #[file1, file2]
	}
}
