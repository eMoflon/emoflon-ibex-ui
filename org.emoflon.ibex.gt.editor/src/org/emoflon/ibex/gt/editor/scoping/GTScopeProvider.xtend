package org.emoflon.ibex.gt.editor.scoping

import java.util.Optional
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.linking.lazy.LazyLinkingResource.CyclicLinkingException
import org.eclipse.xtext.scoping.Scopes

import org.emoflon.ibex.gt.editor.gT.AttributeAssignment
import org.emoflon.ibex.gt.editor.gT.AttributeCondition
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.gT.NAC
import org.emoflon.ibex.gt.editor.gT.Node
import org.emoflon.ibex.gt.editor.gT.Reference
import org.emoflon.ibex.gt.editor.gT.Rule

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
			return getScopeForAttributes(context, reference)
		}

		// Nodes
		if (isNodeType(context, reference)) {
			return getScopeForNodeTypes(context, reference)
		}

		// References
		if (isReferenceType(context, reference)) {
			return getScopeForReferenceTypes(context, reference)
		}
		if (isReferenceTarget(context, reference)) {
			return getScopeForReferenceTargets(context, reference)
		}

		// Rules
		if (isSuperRule(context, reference)) {
			return getScopeForSuperRules(context, reference)
		}

		return super.getScope(context, reference)
	}

	def isAttributeName(EObject context, EReference reference) {
		return (context instanceof AttributeAssignment &&
			reference == GTPackage.Literals.ATTRIBUTE_ASSIGNMENT__ATTRIBUTE) ||
			(context instanceof AttributeCondition && reference == GTPackage.Literals.ATTRIBUTE_CONDITION__ATTRIBUTE)
	}

	def isNodeType(EObject context, EReference reference) {
		return (context instanceof Node && reference == GTPackage.Literals.NODE__TYPE)
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
	def getScopeForSuperRules(EObject context, EReference reference) {
		val rootElement = EcoreUtil2.getRootContainer(context)
		val candidates = EcoreUtil2.getAllContentsOfType(rootElement, Rule)
		val validSuperRules = candidates.filter [
			it != context && !isRefinementOf(it as Rule, context as Rule)
		]
		return Scopes.scopeFor(validSuperRules)
	}

	/**
	 * The node type must be an EClass from the meta-model.
	 */
	def getScopeForNodeTypes(EObject context, EReference reference) {
		val container = context.eContainer
		if (container instanceof Rule) {
			return getClassesScope(container.eContainer as GraphTransformationFile)
		}
		if (container instanceof NAC) {
			return getClassesScope(container.eContainer.eContainer as GraphTransformationFile)
		}
		return Scopes.scopeFor([])
	}

	def static getClassesScope(GraphTransformationFile file) {
		val classes = newArrayList()
		file.imports.forEach [
			loadEcoreModel(it.name).ifPresent([
				classes.addAll(EcoreUtil2.getAllContentsOfType(it.contents.get(0), EClass))
			])
		]
		return Scopes.scopeFor(classes)
	}

	def static loadEcoreModel(String uri) {
		try {
			var resourceSet = new ResourceSetImpl()
			var resource = resourceSet.getResource(URI.createURI(uri), true)
			resource.load(null)
			return Optional.of(resource)
		} catch (Exception e) {
			return Optional.ofNullable(null)
		}
	}

	/**
	 * The type of a reference must be one of the EReferences from the EClass
	 * of the node containing the reference.
	 */
	def getScopeForReferenceTypes(EObject context, EReference reference) {
		val container = context.eContainer
		if (container instanceof Node) {
			val containingNode = container as Node
			if (containingNode.type !== null) {
				return Scopes.scopeFor(containingNode.type.EAllReferences)
			}
		}
		return Scopes.scopeFor([])
	}

	/**
	 * The target of the reference must be another node within the same rule 
	 * (or its super rules) of the correct type.
	 */
	def getScopeForReferenceTargets(EObject context, EReference reference) {
		if (context instanceof Reference) {
			val referenceType = (context as Reference).type
			if (referenceType !== null) {
				val targetNodeType = referenceType.EReferenceType
				if (targetNodeType !== null) {
					val container = context.eContainer.eContainer
					if (container instanceof Rule) {
						val rule = container as Rule
						if (rule !== null) {
							val nodes = newArrayList()
							nodes.addAll(filterNodesWithType(rule, targetNodeType))
							rule.superRules.forEach[nodes.addAll(filterNodesWithType(it, targetNodeType))]
							return Scopes.scopeFor(nodes)
						}
					}
					if (container instanceof NAC) {
						val nac = container as NAC
						if (nac !== null) {
							val nodes = newArrayList()
							nodes.addAll(nac.nodes.filter[isNodeOfType(it, targetNodeType)])
							return Scopes.scopeFor(nodes)
						}
					}
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
		if (node.type.name == expectedNodeType.name) {
			return true
		}

		// Alternatively the node type can be a (grand)parent of the expected node type.
		node.type.EAllSuperTypes.map[it.name].contains(expectedNodeType.name)
	}

	/**
	 * The attribute name must be one of the EAttribute from the EClass
	 * of the node containing the attribute assignment or condition.
	 */
	def getScopeForAttributes(EObject context, EReference reference) {
		val container = context.eContainer
		if (container instanceof Node) {
			val containingNode = container as Node
			return Scopes.scopeFor(containingNode.type.EAllAttributes)
		}
		return Scopes.scopeFor([])
	}

	/**
	 * Checks whether a is a refinement of b.
	 */
	def static boolean isRefinementOf(Rule a, Rule b) {
		try {
			if (a.superRules.contains(b)) {
				return true;
			}
		} catch (CyclicLinkingException e) {
			// Cycling linking detected: a refines b and b refines a (directly or indirectly)
			return true;
		}
		for (superRule : a.superRules) {
			if (isRefinementOf(superRule, b)) {
				return true;
			}
		}
		return false;
	}
}
