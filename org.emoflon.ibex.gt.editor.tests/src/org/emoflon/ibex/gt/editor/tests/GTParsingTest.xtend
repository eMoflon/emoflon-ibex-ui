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
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Parameter
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

	def getParameter(Rule rule, int parameterIndex) {
		return rule.parameters.get(parameterIndex)
	}

	def void assertParameters(Rule rule, Map<String, String> parameterNameToType) {
		Assert.assertEquals(parameterNameToType.size, rule.parameters.size)
		for (parameter : rule.parameters) {
			Assert.assertTrue("Found unexpected parameter " + parameter.name,
				parameterNameToType.containsKey(parameter.name))
			Assert.assertEquals(parameterNameToType.get(parameter.name), parameter.type.name)
		}
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

	def getAttribute(Node node, int attributeIndex) {
		return node.attributes.get(attributeIndex)
	}

	def void assertAttribute(AttributeConstraint attributeConstraint, String name, Relation relation) {
		Assert.assertEquals(name, attributeConstraint.attribute.name)
		Assert.assertEquals(relation, attributeConstraint.relation)
	}

	def void assertAttributeWithAttributeExpression(AttributeConstraint attributeConstraint, String name,
		Relation relation, Node node, String attr) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorAttributeExpression)
		Assert.assertEquals(node, (attributeConstraint.value as EditorAttributeExpression).node)
		Assert.assertEquals(attr, (attributeConstraint.value as EditorAttributeExpression).attribute.name)
	}

	def void assertAttributeLiteral(AttributeConstraint attributeConstraint, String name, Relation relation,
		String value) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorLiteralExpression)
		Assert.assertEquals(value, (attributeConstraint.value as EditorLiteralExpression).value)
	}

	def void assertAttributeParameter(AttributeConstraint attributeConstraint, String name, Relation relation,
		Parameter parameter) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorParameterExpression)
		Assert.assertEquals(parameter, (attributeConstraint.value as EditorParameterExpression).parameter)
	}

	def getReference(Node node, int referenceIndex) {
		return node.references.get(referenceIndex)
	}

	def assertReference(Reference reference, Operator operator, String name, Node target) {
		Assert.assertEquals(operator, reference.operator)
		Assert.assertEquals(name, reference.type.name)
		Assert.assertEquals(target, reference.target)
	}
}
