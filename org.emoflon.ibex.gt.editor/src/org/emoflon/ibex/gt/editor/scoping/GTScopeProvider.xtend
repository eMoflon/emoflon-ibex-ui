package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope

import org.emoflon.ibex.gt.editor.gT.EditorAttribute
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorConstraint
import org.emoflon.ibex.gt.editor.gT.EditorEnforce
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorForbid
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils

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

		// Patterns
		if (isSuperPattern(context, reference) || isPatternOfGraphCondition(context, reference)) {
			return getScopeForPatternsInSamePackage(context, reference)
		}

		return super.getScope(context, reference)
	}

	def isAttributeName(EObject context, EReference reference) {
		return (context instanceof EditorAttribute && reference == GTPackage.Literals.EDITOR_ATTRIBUTE__ATTRIBUTE)
	}

	def isNodeOfAttributeExpression(EObject context, EReference reference) {
		return (context instanceof EditorAttributeExpression &&
			reference == GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__NODE)
	}

	def isAttributeOfAttributeExpression(EObject context, EReference reference) {
		return (context instanceof EditorAttributeExpression &&
			reference == GTPackage.Literals.EDITOR_ATTRIBUTE_EXPRESSION__ATTRIBUTE)
	}

	def isEnumExpression(EObject context, EReference reference) {
		return (context instanceof EditorEnumExpression &&
			reference == GTPackage.Literals.EDITOR_ENUM_EXPRESSION__LITERAL)
	}

	def isParameterExpression(EObject context, EReference reference) {
		return (context instanceof EditorParameterExpression &&
			reference == GTPackage.Literals.EDITOR_PARAMETER_EXPRESSION__PARAMETER);
	}

	def isPatternOfGraphCondition(EObject context, EReference reference) {
		return (context instanceof EditorEnforce && reference == GTPackage.Literals.EDITOR_ENFORCE__PATTERN) ||
			(context instanceof EditorForbid && reference == GTPackage.Literals.EDITOR_FORBID__PATTERN) ||
			(context instanceof EditorConstraint &&
				(reference == GTPackage.Literals.EDITOR_CONSTRAINT__PREMISE || reference == GTPackage.Literals.EDITOR_CONSTRAINT__CONCLUSIONS)
			)
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

	def isSuperPattern(EObject context, EReference reference) {
		return (context instanceof EditorPattern && reference == GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS)
	}

	/**
	 * Filters the scope of the super scope provider for the patterns
	 * which are in the same package as the file containing the context. 
	 */
	def getScopeForPatternsInSamePackage(EObject context, EReference reference) {
		val contextURI = context.eResource.URI.appendFragment(context.eResource.getURIFragment(context))
		return new FilteringScope(super.getScope(context, reference), [
			context.eResource.URI.trimFragment.trimSegments(1).equals(it.EObjectURI.trimFragment.trimSegments(1)) &&
				it.EObjectURI !== contextURI
		])
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
	 * The target of the reference must be another node within the same pattern 
	 * or its super patterns of the correct type.
	 */
	def getScopeForReferenceTargets(EditorReference reference) {
		val referenceType = reference.type
		if (referenceType !== null) {
			val targetNodeType = referenceType.EReferenceType
			if (targetNodeType !== null) {
				val pattern = reference.eContainer.eContainer as EditorPattern
				if (pattern !== null) {
					val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
						isNodeOfType(it, targetNodeType)
					])
					return Scopes.scopeFor(nodes)
				}
			}
		}
		return Scopes.scopeFor([])
	}

	/**
	 * Filters the nodes of the given pattern for the ones with the given type.
	 */
	def static filterNodesWithType(EditorPattern pattern, EClass nodeType) {
		pattern.nodes.filter[isNodeOfType(it, nodeType)].toList
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
		val pattern = attributeExpression.eContainer.eContainer.eContainer as EditorPattern
		val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
			it.operator == EditorOperator.CONTEXT
		])
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
		val pattern = attributeConstraint.eContainer.eContainer as EditorPattern
		val parameters = newArrayList()
		GTEditorPatternUtils.getPatternWithAllSuperPatterns(pattern).forEach [
			parameters.addAll(it.parameters.filter [
				it.type == attributeConstraint.attribute.EAttributeType
			])
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
