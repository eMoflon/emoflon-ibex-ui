package org.emoflon.ibex.gt.editor.tests

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.emoflon.ibex.gt.editor.gT.AttributeAssignment
import org.emoflon.ibex.gt.editor.gT.AttributeCondition
import org.emoflon.ibex.gt.editor.gT.BindingType
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.Reference
import org.junit.Assert
import org.junit.runner.RunWith

/**
 * Abstract test class for JUnit parsing tests of the editor.
 * Defines useful assertions uses within the JUnit tests.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
abstract class AbstractParsingTest {
	@Inject
	protected ParseHelper<GraphTransformationFile> parseHelper

	@Inject extension private ValidationTestHelper validationHelper

	def void assertValid(GraphTransformationFile file) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertBasics(file, 1)
	}

	def void assertValid(GraphTransformationFile file, int ruleCount) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertBasics(file, ruleCount)
	}

	def void assertValidationErrors(GraphTransformationFile file, EClass objectType, String code, String... messages) {
		messages.forEach[this.validationHelper.assertError(file, objectType, code, it)]
	}

	def void assertValidationIssues(GraphTransformationFile file, EClass objectType, String code, Severity severity,
		String... messages) {
		messages.forEach[this.validationHelper.assertIssue(file, objectType, code, severity, it)]
	}

	def void assertValidResource(GraphTransformationFile file) {
		Assert.assertNotNull(file)
		Assert.assertTrue(file.eResource.errors.isEmpty)
		Assert.assertTrue(file.eResource.warnings.isEmpty)
	}

	def void assertInvalidResource(GraphTransformationFile file, int issueCount) {
		Assert.assertTrue(issueCount > 0)
		Assert.assertNotNull(file)
		Assert.assertEquals(issueCount, file.eResource.errors.size + file.eResource.warnings.size)
	}

	def void assertBasics(GraphTransformationFile file) {
		this.assertBasics(file, 1)
	}

	def void assertBasics(GraphTransformationFile file, int ruleCount) {
		Assert.assertTrue(ruleCount > 0)
		this.assertValidResource(file)

		Assert.assertEquals(1, file.imports.size)
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", file.imports.get(0).name)

		Assert.assertEquals(ruleCount, file.rules.size)
	}

	def void assertAttributeAssignment(GraphTransformationFile file, int constraintIndex, String name, String value) {
		val attr = file.rules.get(0).nodes.get(0).constraints.get(constraintIndex) as AttributeAssignment
		Assert.assertEquals(name, attr.attribute.name)
		Assert.assertEquals(value, attr.value.value)
	}

	def void assertAttributeCondition(GraphTransformationFile file, int constraintIndex, String name, String value) {
		val attr = file.rules.get(0).nodes.get(0).constraints.get(constraintIndex) as AttributeCondition
		Assert.assertEquals(name, attr.attribute.name)
		Assert.assertEquals(value, attr.value.value)
	}

	def assertNode(GraphTransformationFile file, int nodeIndex, BindingType bindingType, String variableName,
		String variableType) {
		val node = file.rules.get(0).nodes.get(nodeIndex)
		Assert.assertEquals(bindingType, node.bindingType)
		Assert.assertEquals(variableName, node.name)
		Assert.assertEquals(variableType, node.type.name)
	}

	def void assertParameterNames(GraphTransformationFile file, String... names) {
		val parameters = file.rules.get(0).parameters
		Assert.assertEquals(names.size, parameters.size)
		for (i : 0 .. names.size - 1) {
			Assert.assertEquals(names.get(i), parameters.get(i).name)
		}
	}

	def void assertParameterTypes(GraphTransformationFile file, String... types) {
		val parameters = file.rules.get(0).parameters
		Assert.assertEquals(types.size, parameters.size)
		for (i : 0 .. types.size - 1) {
			Assert.assertEquals(types.get(i), parameters.get(i).type)
		}
	}

	def assertReference(GraphTransformationFile file, int constraintIndex, BindingType bindingType, String name,
		int targetNodeIndex) {
		val reference = file.rules.get(0).nodes.get(0).constraints.get(constraintIndex) as Reference
		Assert.assertEquals(bindingType, reference.bindingType)
		Assert.assertEquals(name, reference.type.name)
		Assert.assertEquals(file.rules.get(0).nodes.get(targetNodeIndex), reference.target)
	}
}