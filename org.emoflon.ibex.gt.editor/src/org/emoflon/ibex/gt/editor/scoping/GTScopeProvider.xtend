package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes

import org.emoflon.ibex.gt.editor.gT.AttributeConstraint
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Operator
import org.emoflon.ibex.gt.editor.gT.Parameter
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorRuleUtils

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class GTScopeProvider extends AbstractGTScopeProvider {

	override getScope(EObject context, EReference reference) {
		// Attributes
		if (isAttributeName(context, reference)) {
			return getScopeForAttributes(context as AttributeConstraint)
		}

		// Expressions
		if (isAttributeOfAttributeExpression(context, reference)) {
			return getScopeForAttributeExpressionAttributes(context as EditorAttributeExpression)
		}
		if (isNodeOfAttributeExpression(context, reference)) {
			return getScopeForAttributeExpressionNodes(context as EditorAttributeExpression)
		}
		if (isEnumExpression(context, reference)) {
			return getScopeForEnumLiterals(context as EditorEnumExpression)
		}
		if (isParameterExpression(context, reference)) {
			return getScopeForParameterExpressions(context as EditorParameterExpression)
		}

		// Nodes
		if (isNodeType(context, reference)) {
			return getScopeForNodeTypes(context as Node)
		}

		// Parameters
		if (isParameterType(context, reference)) {
			return getScopeForParameterDatatypes(context as Parameter)
		}

		// References
		if (isReferenceType(context, reference)) {
			return getScopeForReferenceTypes(context as Reference)
		}
		if (isReferenceTarget(context, reference)) {
			return getScopeForReferenceTargets(context as Reference)
		}

		// Rules
		if (isSuperRule(context, reference)) {
			return getScopeForSuperRules(context as Rule)
		}

		return super.getScope(context, reference)
	}

	def isAttributeName(EObject context, EReference reference) {
		return (context instanceof AttributeConstraint &&
			reference == GTPackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE)
	}

	def isNodeOfAttributeExpression(EObject context, EReference reference) {
		return (context instanceof EditorAttributeExpression &&
			reference == GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__NODE);
	}

	def isAttributeOfAttributeExpression(EObject context, EReference reference) {
		return (context instanceof EditorAttributeExpression &&
			reference == GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE);
	}

	def isEnumExpression(EObject context, EReference reference) {
		return (context instanceof EditorEnumExpression &&
			reference == GTPackage.Literals.EDITOR_ENUM_EXPRESSION__LITERAL)
	}

	def isParameterExpression(EObject context, EReference reference) {
		return (context instanceof EditorParameterExpression &&
			reference == GTPackage.Literals.EDITOR_PARAMETER_EXPRESSION__PARAMETER);
	}

	def isNodeType(EObject context, EReference reference) {
		return (context instanceof Node && reference == GTPackage.Literals.NODE__TYPE)
	}

	def isParameterType(EObject context, EReference reference) {
		return (context instanceof Parameter && reference == GTPackage.Literals.PARAMETER__TYPE)
	}

	def isReferenceType(EObject context, EReference reference) {
		return (context instanceof Reference && reference == GTPackage.Literals.REFERENCE__TYPE)
	}

	def isReferenceTarget(EObject context, EReference reference) {
		return (context instanceof Reference && reference == GTPackage.Literals.REFERENCE__TARGET)
	}

	def isSuperRule(EObject context, EReference reference) {
		return (context instanceof Rule && reference == GTPackage.Literals.RULE__SUPER_RULES)
	}

	/**
	 * A rule can refine any rule except itself and rules which refine itself.
	 * This avoids loops in the refinement hierarchy.
	 */
	def getScopeForSuperRules(Rule rule) {
		val rootElement = EcoreUtil2.getRootContainer(rule)
		val candidates = EcoreUtil2.getAllContentsOfType(rootElement, Rule)
		val validSuperRules = candidates.filter [
			it != rule && !GTEditorRuleUtils.isRefinementOf(it as Rule, rule)
		]
		return Scopes.scopeFor(validSuperRules)
	}

	/**
	 * The node type must be an EClass from the meta-model.
	 */
	def getScopeForNodeTypes(Node node) {
		return Scopes.scopeFor(GTEditorModelUtils.getClasses(node.eContainer.eContainer as GraphTransformationFile))
	}

	/**
	 * The type of a reference must be one of the EReferences from the EClass
	 * of the node containing the reference.
	 */
	def getScopeForReferenceTypes(Reference context) {
		val node = context.eContainer as Node
		if (node.type !== null) {
			return Scopes.scopeFor(node.type.EAllReferences)
		}
		return Scopes.scopeFor([])
	}

	/**
	 * The target of the reference must be another node within the same rule 
	 * (or its super rules) of the correct type.
	 */
	def getScopeForReferenceTargets(Reference reference) {
		val referenceType = reference.type
		if (referenceType !== null) {
			val targetNodeType = referenceType.EReferenceType
			if (targetNodeType !== null) {
				val rule = reference.eContainer.eContainer as Rule
				if (rule !== null) {
					val nodes = GTEditorRuleUtils.getAllNodesOfRule(rule, [isNodeOfType(it, targetNodeType)])
					return Scopes.scopeFor(nodes)
				}
			}
		}
		return Scopes.scopeFor([])
	}

	/**
	 * Filters the nodes of the given rule for the ones with the given type.
	 */
	def static filterNodesWithType(Rule rule, EClass nodeType) {
		rule.nodes.filter[isNodeOfType(it, nodeType)].toList
	}

	/**
	 * Returns whether the node is of the given type.
	 */
	def static isNodeOfType(Node node, EClass expectedNodeType) {
		if (node.type == expectedNodeType) {
			return true
		}

		// Alternatively the node type can be a (grand)parent of the expected node type.
		node.type.EAllSuperTypes.contains(expectedNodeType)
	}

	/**
	 * The attribute name must be one of the EAttribute from the EClass
	 * of the node containing the attribute assignment or condition.
	 */
	def getScopeForAttributes(AttributeConstraint context) {
		val containingNode = context.eContainer as Node
		return Scopes.scopeFor(containingNode.type.EAllAttributes)
	}

	/**
	 * The parameter type must be one of the EDatatypes from the meta-models.
	 */
	def getScopeForParameterDatatypes(Parameter parameter) {
		val file = parameter.eContainer.eContainer as GraphTransformationFile
		return Scopes.scopeFor(GTEditorModelUtils.getDatatypes(file))
	}

	/**
	 * The node of an attribute expression can be any context node which is valid within the same rule.
	 */
	def getScopeForAttributeExpressionNodes(EditorAttributeExpression attributeExpression) {
		val rule = attributeExpression.eContainer.eContainer.eContainer as Rule
		val nodes = GTEditorRuleUtils.getAllNodesOfRule(rule, [it.operator == Operator.CONTEXT])
		return Scopes.scopeFor(nodes)
	}

	/**
	 * Any attributes of the node of the attribute expression are valid
	 * if their type fits to the one expected for the attribute value. 
	 */
	def getScopeForAttributeExpressionAttributes(EditorAttributeExpression attributeExpression) {
		val attributeConstraint = attributeExpression.eContainer as AttributeConstraint
		val node = attributeExpression.node
		if (node === null || node.type === null) {
			return Scopes.scopeFor([])
		}
		val attributes = node.type.EAllAttributes.filter [
			it.EAttributeType == attributeConstraint.attribute.EAttributeType
		]
		return Scopes.scopeFor(attributes)
	}

	/**
	 * Parameter expressions must reference a parameter of the type expected for the attribute value.
	 */
	def getScopeForParameterExpressions(EditorParameterExpression parameterExpression) {
		val attributeConstraint = parameterExpression.eContainer as AttributeConstraint
		val rule = attributeConstraint.eContainer.eContainer as Rule
		val parameters = newArrayList()
		GTEditorRuleUtils.getRuleAllWithSuperRules(rule).forEach [
			parameters.addAll(it.parameters.filter[it.type == attributeConstraint.attribute.EAttributeType])
		]
		return Scopes.scopeFor(parameters)
	}

	/**
	 * Any literal of the attribute's enum is valid.
	 */
	def getScopeForEnumLiterals(EditorEnumExpression enumExpression) {
		val attributeConstraint = enumExpression.eContainer as AttributeConstraint
		val type = attributeConstraint.attribute.EAttributeType
		if (type instanceof EEnum) {
			return Scopes.scopeFor(type.ELiterals)
		}
		return Scopes.scopeFor([])
	}
}
