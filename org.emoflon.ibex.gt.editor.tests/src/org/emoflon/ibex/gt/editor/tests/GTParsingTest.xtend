package org.emoflon.ibex.gt.editor.tests

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.EditorLiteralExpression
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorRelation
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Parameter
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
	protected ParseHelper<EditorGTFile> parseHelper

	@Inject extension private ValidationTestHelper validationHelper

	def void assertValid(EditorGTFile file) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertFile(file, 1)
	}

	def void assertValid(EditorGTFile file, int ruleCount) {
		Assert.assertNotNull(file)
		this.validationHelper.assertNoIssues(file)
		this.assertFile(file, ruleCount)
	}

	def void assertValidationErrors(EditorGTFile file, EClass objectType, String code, String... messages) {
		messages.forEach[this.validationHelper.assertError(file, objectType, code, it)]
	}

	def void assertValidationIssues(EditorGTFile file, EClass objectType, String code, Severity severity,
		String... messages) {
		messages.forEach[this.validationHelper.assertIssue(file, objectType, code, severity, it)]
	}

	def void assertValidResource(EditorGTFile file) {
		Assert.assertNotNull(file)
		Assert.assertTrue(file.eResource.errors.isEmpty)
		Assert.assertTrue(file.eResource.warnings.isEmpty)
	}

	def void assertInvalidResource(EditorGTFile file, int issueCount) {
		Assert.assertTrue(issueCount > 0)
		Assert.assertNotNull(file)
		Assert.assertEquals(issueCount, file.eResource.errors.size + file.eResource.warnings.size)
	}

	def void assertFile(EditorGTFile file) {
		this.assertFile(file, 1)
	}

	def void assertFile(EditorGTFile file, int ruleCount) {
		Assert.assertTrue(ruleCount > 0)
		this.assertValidResource(file)

		Assert.assertEquals(1, file.imports.size)
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", file.imports.get(0).name)

		Assert.assertEquals(ruleCount, file.rules.size)
	}

	def getRule(EditorGTFile file, int ruleIndex) {
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

	def assertNode(Node node, EditorOperator operator, String variableName, String variableType) {
		assertNode(node, operator, variableName, variableType, 0, 0)
	}

	def assertNode(Node node, EditorOperator operator, String name, String type, int attributesCount,
		int referencesCount) {
		Assert.assertEquals(operator, node.operator)
		Assert.assertEquals(name, node.name)
		Assert.assertEquals(type, node.type.name)
		Assert.assertEquals(attributesCount, node.attributes.size)
		Assert.assertEquals(referencesCount, node.references.size)
	}

	def getAttribute(Node node, int attributeIndex) {
		return node.attributes.get(attributeIndex)
	}

	def void assertAttribute(EditorAttribute attributeConstraint, String name, EditorRelation relation) {
		Assert.assertEquals(name, attributeConstraint.attribute.name)
		Assert.assertEquals(relation, attributeConstraint.relation)
	}

	def void assertAttributeWithAttributeExpression(EditorAttribute attributeConstraint, String name,
		EditorRelation relation, Node node, String attr) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorAttributeExpression)
		Assert.assertEquals(node, (attributeConstraint.value as EditorAttributeExpression).node)
		Assert.assertEquals(attr, (attributeConstraint.value as EditorAttributeExpression).attribute.name)
	}

	def void assertAttributeLiteral(EditorAttribute attributeConstraint, String name, EditorRelation relation,
		String value) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorLiteralExpression)
		Assert.assertEquals(value, (attributeConstraint.value as EditorLiteralExpression).value)
	}

	def void assertAttributeParameter(EditorAttribute attributeConstraint, String name, EditorRelation relation,
		Parameter parameter) {
		this.assertAttribute(attributeConstraint, name, relation)
		Assert.assertTrue(attributeConstraint.value instanceof EditorParameterExpression)
		Assert.assertEquals(parameter, (attributeConstraint.value as EditorParameterExpression).parameter)
	}

	def getReference(Node node, int referenceIndex) {
		return node.references.get(referenceIndex)
	}

	def assertReference(EditorReference reference, EditorOperator operator, String name, Node target) {
		Assert.assertEquals(operator, reference.operator)
		Assert.assertEquals(name, reference.type.name)
		Assert.assertEquals(target, reference.target)
	}
}
