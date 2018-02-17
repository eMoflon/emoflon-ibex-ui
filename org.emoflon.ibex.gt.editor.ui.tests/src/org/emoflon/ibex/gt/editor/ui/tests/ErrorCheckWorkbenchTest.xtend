package org.emoflon.ibex.gt.editor.ui.tests

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.XtextProjectHelper
import org.junit.Before
import org.junit.Test

class ErrorCheckWorkbenchTest extends AbstractWorkbenchTest {
	val TEST_PROJECT = "gt-test-project"

	@Before
	override void setUp() {
		super.setUp
		val project = IResourcesSetupUtil.createProject(TEST_PROJECT)
		IResourcesSetupUtil.addNature(project, "org.eclipse.jdt.core.javanature")
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID)
	}

	@Test
	def void correctErrorCount() {
		this.checkMarkerCountForFile('''
			import "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"
			
			rule a {
				a: EObject
			}
			
			rule b {
				b: EObject
			}
			
			rule c
			refines a, b
		''', 0)
		this.checkMarkerCountForFile('''
			import "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"
			
			rule a {
			}
			
			rule c
			refines a, a
		''', 2)
	}

	def void checkMarkerCountForFile(String fileContents, int expectedErrors) {
		val hash = fileContents.hashCode
		val file = IResourcesSetupUtil.createFile(TEST_PROJECT + '/src/Rules' + hash + '.gt', fileContents)
		file.assertNotNull
		IResourcesSetupUtil.reallyWaitForAutoBuild
		val markers = IResourcesSetupUtil.root.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		assertEquals('Markers: ' + IResourcesSetupUtil.printMarker(markers), expectedErrors, markers.size)
	}
}
