package org.emoflon.ibex.gt.editor.tests

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.emoflon.ibex.gt.editor.gT.AttributeConstraint
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Relation
import org.emoflon.ibex.gt.editor.gT.Rule
import org.junit.Assert
import org.junit.runner.RunWith

/**
 * Abstract test class for JUnit parsing tests of the editor.
 * Defines useful assertions uses within the JUnit tests.
 */
@RunWith(XtextRunner)
@InjectWith(GTInjectorProvider)
abstract class GTParsingTest {
	public static val ecoreImport = 'http://www.eclipse.org/emf/2002/Ecore'

	@Inject
	protected ParseHelper<GraphTransformationFile> parseHelper

	@Inject extension private ValidationTestHelper validationHelper

	def void assertValid(GraphTransformationFile file) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertFile(file, 1)
	}

	def void assertValid(GraphTransformationFile file, int ruleCount) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertFile(file, ruleCount)
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

	def void assertFile(GraphTransformationFile file) {
		this.assertFile(file, 1)
	}

	def void assertFile(GraphTransformationFile file, int ruleCount) {
		Assert.assertTrue(ruleCount > 0)
		this.assertValidResource(file)

		Assert.assertEquals(1, file.imports.size)
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", file.imports.get(0).name)

		Assert.assertEquals(ruleCount, file.rules.size)
	}

	def getRule(GraphTransformationFile file, int ruleIndex) {
		return file.rules.get(ruleIndex)
	}

	def getNode(Rule rule, int nodeIndex) {
		return rule.nodes.get(nodeIndex)
	}

	def assertNode(Node node, Operator operator, String variableName, String variableType) {
		assertNode(node, operator, variableName, variableType, 0, 0)
	}

	def assertNode(Node node, Operator operator, String name, String type, int attributesCount, int referencesCount) {
		Assert.assertEquals(operator, node.operator)
		Assert.assertEquals(name, node.name)
		Assert.assertEquals(type, node.type.name)
		Assert.assertEquals(attributesCount, node.attributes.size)
		Assert.assertEquals(referencesCount, node.references.size)
	}

	def void assertAttribute(AttributeConstraint attributeConstraint, String name, Relation relation) {
		Assert.assertEquals(name, attributeConstraint.attribute.name)
		Assert.assertEquals(relation, attributeConstraint.relation)
	}

	def void assertAttributeLiteral(GraphTransformationFile file, int index, String name, Relation relation,
		String value) {
		val attr = file.rules.get(0).nodes.get(0).attributes.get(index) as AttributeConstraint
		this.assertAttribute(attr, name, relation)

		Assert.assertTrue(attr.value instanceof EditorLiteralExpression)
		Assert.assertEquals(value, (attr.value as EditorLiteralExpression).value)
	}

	def void assertAttributeParameter(GraphTransformationFile file, int attributeIndex, String name, Relation relation,
		int parameterIndex) {
		val attr = file.rules.get(0).nodes.get(0).attributes.get(attributeIndex) as AttributeConstraint
		this.assertAttribute(attr, name, relation)

		Assert.assertTrue(attr.value instanceof EditorParameterExpression)
		val parameter = file.rules.get(0).parameters.get(parameterIndex)
		Assert.assertEquals(parameter, (attr.value as EditorParameterExpression).parameter)
	}

	def void assertParameters(Rule rule, Map<String, String> parameterNameToType) {
		Assert.assertEquals(parameterNameToType.size, rule.parameters.size)
		for (parameter : rule.parameters) {
			Assert.assertTrue("Found unexpected parameter " + parameter.name,
				parameterNameToType.containsKey(parameter.name))
			Assert.assertEquals(parameterNameToType.get(parameter.name), parameter.type.name)
		}
	}

	def assertReference(GraphTransformationFile file, int referenceIndex, Operator operator, String name,
		int targetNodeIndex) {
		val reference = file.rules.get(0).nodes.get(0).references.get(referenceIndex)
		Assert.assertEquals(operator, reference.operator)
		Assert.assertEquals(name, reference.type.name)
		Assert.assertEquals(file.rules.get(0).nodes.get(targetNodeIndex), reference.target)
	}

	def assertReference(Reference reference, Operator operator, String name, String targetNodeName) {
		Assert.assertEquals(operator, reference.operator)
		Assert.assertEquals(name, reference.type.name)
		Assert.assertEquals(targetNodeName, reference.target.name)
	}

}
