package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage
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
			return getScopeForAttributes(context as EditorAttribute)
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
			return getScopeForNodeTypes(context as EditorNode)
		}

		// Parameters
		if (isParameterType(context, reference)) {
			return getScopeForParameterDatatypes(context as EditorParameter)
		}

		// References
		if (isReferenceType(context, reference)) {
			return getScopeForReferenceTypes(context as EditorReference)
		}
		if (isReferenceTarget(context, reference)) {
			return getScopeForReferenceTargets(context as EditorReference)
		}

		// Rules
		if (isSuperRule(context, reference)) {
			return getScopeForSuperRules(context as Rule)
		}

		return super.getScope(context, reference)
	}

	def isAttributeName(EObject context, EReference reference) {
		return (context instanceof EditorAttribute && reference == GTPackage.Literals.EDITOR_ATTRIBUTE__ATTRIBUTE)
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
		return (context instanceof EditorNode && reference == GTPackage.Literals.EDITOR_NODE__TYPE)
	}

	def isParameterType(EObject context, EReference reference) {
		return (context instanceof EditorParameter && reference == GTPackage.Literals.EDITOR_PARAMETER__TYPE)
	}

	def isReferenceType(EObject context, EReference reference) {
		return (context instanceof EditorReference && reference == GTPackage.Literals.EDITOR_REFERENCE__TYPE)
	}

	def isReferenceTarget(EObject context, EReference reference) {
		return (context instanceof EditorReference && reference == GTPackage.Literals.EDITOR_REFERENCE__TARGET)
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
	def getScopeForNodeTypes(EditorNode node) {
		return Scopes.scopeFor(GTEditorModelUtils.getClasses(node.eContainer.eContainer as EditorGTFile))
	}

	/**
	 * The type of a reference must be one of the EReferences from the EClass
	 * of the node containing the reference.
	 */
	def getScopeForReferenceTypes(EditorReference context) {
		val containingNode = context.eContainer as EditorNode
		return Scopes.scopeFor(containingNode.type.EAllReferences)
	}

	/**
	 * The target of the reference must be another node within the same rule 
	 * (or its super rules) of the correct type.
	 */
	def getScopeForReferenceTargets(EditorReference reference) {
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
	def static isNodeOfType(EditorNode node, EClass expectedNodeType) {
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
	def getScopeForAttributes(EditorAttribute context) {
		val containingNode = context.eContainer as EditorNode
		return Scopes.scopeFor(containingNode.type.EAllAttributes)
	}

	/**
	 * The parameter type must be one of the EDatatypes from the meta-models.
	 */
	def getScopeForParameterDatatypes(EditorParameter parameter) {
		val file = parameter.eContainer.eContainer as EditorGTFile
		return Scopes.scopeFor(GTEditorModelUtils.getDatatypes(file))
	}

	/**
	 * The node of an attribute expression can be any context node which is valid within the same rule.
	 */
	def getScopeForAttributeExpressionNodes(EditorAttributeExpression attributeExpression) {
		val rule = attributeExpression.eContainer.eContainer.eContainer as Rule
		val nodes = GTEditorRuleUtils.getAllNodesOfRule(rule, [it.operator == EditorOperator.CONTEXT])
		return Scopes.scopeFor(nodes)
	}

	/**
	 * Any attributes of the node of the attribute expression are valid
	 * if their type fits to the one expected for the attribute value. 
	 */
	def getScopeForAttributeExpressionAttributes(EditorAttributeExpression attributeExpression) {
		val attributeConstraint = attributeExpression.eContainer as EditorAttribute
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
		val attributeConstraint = parameterExpression.eContainer as EditorAttribute
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
		val attributeConstraint = enumExpression.eContainer as EditorAttribute
		val type = attributeConstraint.attribute.EAttributeType
		if (type instanceof EEnum) {
			return Scopes.scopeFor(type.ELiterals)
		}
		return Scopes.scopeFor([])
	}
}
