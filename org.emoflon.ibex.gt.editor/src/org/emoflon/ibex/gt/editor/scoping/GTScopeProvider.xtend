package org.emoflon.ibex.gt.editor.scoping

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference
import org.emoflon.ibex.gt.editor.gT.EditorEnumExpression
import org.emoflon.ibex.gt.editor.gT.EditorGTFile
import org.emoflon.ibex.gt.editor.gT.EditorNode
import org.emoflon.ibex.gt.editor.gT.EditorParameter
import org.emoflon.ibex.gt.editor.gT.EditorParameterExpression
import org.emoflon.ibex.gt.editor.gT.EditorPattern
import org.emoflon.ibex.gt.editor.gT.EditorReference
import org.emoflon.ibex.gt.editor.gT.GTPackage
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils
import org.emoflon.ibex.gt.editor.utils.GTEnumExpressionHelper
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment
import org.emoflon.ibex.gt.editor.gT.EditorOperator
import org.emoflon.ibex.gt.editor.gT.impl.EditorPatternImpl
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint
import org.emoflon.ibex.gt.editor.gT.impl.EditorGTFileImpl
import java.util.LinkedList
import org.emoflon.ibex.gt.editor.gT.StochasticFunction
import org.emoflon.ibex.gt.editor.gT.ArithmeticExpression
import org.emoflon.ibex.gt.editor.gT.EditorCountExpression
import org.emoflon.ibex.gt.editor.gT.EditorReferenceIterator
import org.emoflon.ibex.gt.editor.gT.EditorIteratorReference
import org.emoflon.ibex.gt.editor.gT.EditorIteratorAttributeAssignment
import org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl
import org.emoflon.ibex.gt.editor.gT.EditorIteratorAttributeAssignmentItr
import org.emoflon.ibex.gt.editor.gT.EditorIteratorAttributeAssignmentNode
import org.emoflon.ibex.gt.editor.gT.impl.EditorReferenceIteratorImpl

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class GTScopeProvider extends AbstractGTScopeProvider {

	def scopeInternal(EObject context, EReference reference) {
		// Attributes
		if (isAttributeName(context, reference)) {
			return getScopeForAttributes(context as EditorAttributeAssignment)
		}

		if (isAttributeConstraint(context, reference)) {
			return getScopeForAttributes(context as EditorAttributeConstraint)
		}
		
		// Iterator Attributes
		if (isIteratorAttributeAssignmentItr(context, reference)) {
			return getScopeForIteratorAttributeAssignmentItr(context as EditorIteratorAttributeAssignmentItr)
		}
		if (isIteratorAttributeAssignmentNode(context, reference)) {
			return getScopeForIteratorAttributeAssignmentNode(context as EditorIteratorAttributeAssignmentNode)
		}
		if (isIteratorAttributeAssignmentAttribute(context, reference)) {
			return getScopeForIteratorAttributeAssignmentAttribute(context as EditorIteratorAttributeAssignment)
		}

		// Condition
		if (isConditionOfCondition(context, reference)) {
			return filterScopeForOtherObjectsFromSamePackage(context, reference)
		}
		if (isPatternOfCondition(context, reference)) {
			return filterScopeForOtherObjectsFromSamePackage(context, reference)
		}
		
		// Arithmetic Expressions
		if (isArithmeticExpression(context)) {
			return getScopeForArithmeticExpression(context as ArithmeticExpression)
		}

		// Stochastic functions
		if (isStochasticFunction(context)) {
			return getScopeForStochasticFunction(context as StochasticFunction)
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

		if (context instanceof EditorPattern && reference == GTPackage.Literals.EDITOR_OPERATOR) {
			val enums = new LinkedList
			enums.addAll(GTPackage.Literals.EDITOR_OPERATOR.ELiterals);
			enums.remove(GTPackage.Literals.EDITOR_OPERATOR.getEEnumLiteral(0))
			return Scopes.scopeFor(enums)
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
		
		// IteratorReferences

		if (isIteratorReferenceSource(context, reference)) {
			return getScopeForIteratorReferenceSources(context as EditorIteratorReference)
		}
		if (isIteratorReferenceType(context, reference)) {
			return getScopeForIteratorReferenceTypes(context as EditorIteratorReference)
		}
		if (isIteratorReferenceTarget(context, reference)) {
			return getScopeForIteratorReferenceTargets(context as EditorIteratorReference)
		}
		
		// ForEach
		if (isForEachType(context, reference)) {
			return getScopeForForEachTypes(context as EditorReferenceIterator)
		}


		// Patterns
		if (isSuperPattern(context, reference)) {
			return filterScopeForOtherObjectsFromSamePackage(context, reference)
		}
		if (isConditionOfPattern(context, reference)) {
			return filterScopeForOtherObjectsFromSamePackage(context, reference)
		}

		return super.getScope(context, reference)
	}

	override getScope(EObject context, EReference reference) {
		try {
			return scopeInternal(context, reference)
		} catch (Exception e) {
			e.printStackTrace
			return super.getScope(context, reference)
		}
	}

	def isIteratorAttributeAssignmentItr(EObject context, EReference reference) {
		return (context instanceof EditorIteratorAttributeAssignmentItr &&
			reference == GTPackage.Literals.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR)
	}
	
	def isIteratorAttributeAssignmentNode(EObject context, EReference reference) {
		return (context instanceof EditorIteratorAttributeAssignmentNode &&
			reference == GTPackage.Literals.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_NODE__NODE)
	}
	
	def isIteratorAttributeAssignmentAttribute(EObject context, EReference reference) {
		return (context instanceof EditorIteratorAttributeAssignment &&
			reference == GTPackage.Literals.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT__ATTRIBUTE)
	}

	def isAttributeConstraint(EObject context, EReference reference) {
		return (context instanceof EditorAttributeConstraint)
	}
	
	def isAttributeName(EObject context, EReference reference) {
		return (context instanceof EditorAttributeAssignment &&
			reference == GTPackage.Literals.EDITOR_ATTRIBUTE_ASSIGNMENT__ATTRIBUTE)
	}

	def isStochasticFunction(EObject context) {
		return context instanceof StochasticFunction 
		&& !(context instanceof EditorAttributeExpression)  
		&& !(context instanceof EditorCountExpression);
	}
	
	def isArithmeticExpression(EObject context) {
		return context instanceof ArithmeticExpression 
		&& !(context instanceof EditorAttributeExpression) 
		&& !(context instanceof EditorCountExpression);
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

	def isConditionOfCondition(EObject context, EReference reference) {
		return (context instanceof EditorConditionReference &&
			reference == GTPackage.Literals.EDITOR_CONDITION_REFERENCE__CONDITION)
	}

	def isPatternOfCondition(EObject context, EReference reference) {
		return (context instanceof EditorApplicationCondition &&
			reference == GTPackage.Literals.EDITOR_APPLICATION_CONDITION__PATTERN)
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
	
	def isIteratorReferenceSource(EObject context, EReference reference) {
		return (context instanceof EditorIteratorReference && reference == GTPackage.Literals.EDITOR_ITERATOR_REFERENCE__SOURCE)
	}
	
	def isIteratorReferenceType(EObject context, EReference reference) {
		return (context instanceof EditorIteratorReference && reference == GTPackage.Literals.EDITOR_ITERATOR_REFERENCE__TYPE)
	}

	def isIteratorReferenceTarget(EObject context, EReference reference) {
		return (context instanceof EditorIteratorReference && reference == GTPackage.Literals.EDITOR_ITERATOR_REFERENCE__TARGET)
	}
	
	def isForEachType(EObject context, EReference reference) {
		return (context instanceof EditorReferenceIterator && reference == GTPackage.Literals.EDITOR_REFERENCE_ITERATOR__TYPE)
	}

	def isSuperPattern(EObject context, EReference reference) {
		return (context instanceof EditorPattern && reference == GTPackage.Literals.EDITOR_PATTERN__SUPER_PATTERNS)
	}

	def isConditionOfPattern(EObject context, EReference reference) {
		return (context instanceof EditorPattern && reference == GTPackage.Literals.EDITOR_PATTERN__CONDITIONS)
	}

	/**
	 * Filters the scope of the super scope provider of the context for the objects
	 * which are defined in the same package as the file containing the context. 
	 */
	def filterScopeForOtherObjectsFromSamePackage(EObject context, EReference reference) {
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
		val pattern = GTEditorPatternUtils.getContainer(reference, typeof(EditorPatternImpl));

		if (referenceType !== null) {
			val targetNodeType = referenceType.EReferenceType
			if (targetNodeType !== null) {
				val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
					isNodeOfType(it, targetNodeType)
				])
				return Scopes.scopeFor(nodes)
			}
		}

		// If the type cannot be resolved return all nodes.
		return Scopes.scopeFor(GTEditorPatternUtils.getAllNodesOfPattern(pattern, [true]))
	}
	
	def getScopeForIteratorReferenceSources(EditorIteratorReference reference) {
		val pattern = GTEditorPatternUtils.getContainer(reference, typeof(EditorPatternImpl));
		if(reference.operator == EditorOperator.DELETE) {
			val node = GTEditorPatternUtils.getContainer(reference, typeof(EditorNodeImpl));
			val scope = new LinkedList
			scope.add(node)
			return Scopes.scopeFor(scope)
		} else {
			return Scopes.scopeFor(GTEditorPatternUtils.getAllNodesOfPattern(pattern, [true]))
		}
		
	}
	
	def getScopeForIteratorReferenceTypes(EditorIteratorReference reference) {
		val sourceNode = reference.source
		return Scopes.scopeFor(sourceNode.type.EAllReferences)
	}
	
	def getScopeForIteratorReferenceTargets(EditorIteratorReference reference) {
		val iterator = reference.eContainer as EditorReferenceIterator 
		val scope = new LinkedList
		scope.add(iterator) 
		return Scopes.scopeFor(scope)
	}
	
	/**
	 * The type of a reference must be one of the EReferences from the EClass
	 * of the node containing the reference.
	 */
	def getScopeForForEachTypes(EditorReferenceIterator context) {
		val containingNode = context.eContainer as EditorNode
		return Scopes.scopeFor(containingNode.type.EAllReferences)
	}

	/**
	 * Returns whether the node is of the given type.
	 */
	def static isNodeOfType(EditorNode node, EClass expectedNodeType) {
		if (node.type == expectedNodeType) {
			return true
		}

		// Alternatively the node type can be a (grand)parent of the expected node type.
		val allSuperTypes = node.type?.EAllSuperTypes
		if (allSuperTypes !== null)
			allSuperTypes.contains(expectedNodeType)
	}

	/**
	 * The attribute name must be one of the EAttribute from the EClass
	 * of the node containing the attribute assignment or condition.
	 */
	def getScopeForAttributes(EditorAttributeAssignment context) {
		val containingNode = GTEditorPatternUtils.getContainer(context, typeof(EditorNodeImpl))
		return Scopes.scopeFor(containingNode.type.EAllAttributes)
	}

	def getScopeForAttributes(EditorAttributeConstraint context) {
		val pattern = GTEditorPatternUtils.getContainer(context, typeof(EditorPatternImpl))
		return Scopes.scopeFor(pattern.nodes)
	}
	
	def getScopeForIteratorAttributeAssignmentItr(EditorIteratorAttributeAssignmentItr assignment) {
		val itr = GTEditorPatternUtils.getContainer(assignment, typeof(EditorReferenceIteratorImpl))
		val lst = new LinkedList
		lst.add(itr)
		return Scopes.scopeFor(lst)
	}
	
	def getScopeForIteratorAttributeAssignmentNode(EditorIteratorAttributeAssignment assignment) {
		val pattern = GTEditorPatternUtils.getContainer(assignment, typeof(EditorPatternImpl))
		return Scopes.scopeFor(pattern.nodes)
	}
	
	def getScopeForIteratorAttributeAssignmentAttribute(EditorIteratorAttributeAssignment assignment) {
		if(assignment instanceof EditorIteratorAttributeAssignmentItr) {
			val itr = GTEditorPatternUtils.getContainer(assignment, typeof(EditorReferenceIteratorImpl))
			return Scopes.scopeFor((itr.type.EType as EClass).EAllAttributes)
		} else {
			val asgn = assignment as EditorIteratorAttributeAssignmentNode
			return Scopes.scopeFor((asgn.node.type as EClass).EAllAttributes)
		}
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
		val pattern =GTEditorPatternUtils.getContainer(attributeExpression, typeof(EditorPatternImpl))
		if (attributeExpression.eContainer instanceof EditorAttributeAssignment) {
			val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
				it.operator == EditorOperator.CONTEXT
			])
			return Scopes.scopeFor(nodes)
		} else {
			val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
				it.operator == EditorOperator.CONTEXT
			])
			nodes.addAll(GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
				it.operator == EditorOperator.DELETE
			]))
			return Scopes.scopeFor(nodes)
		}

	}

	/**
	 * get all the possible nodes in the pattern
	 */
	def getScopeForArithmeticExpression(ArithmeticExpression expression) {
		var pattern = GTEditorPatternUtils.getContainer(expression, typeof(EditorPatternImpl))
		// searches for EditorPattern Container
		val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
			it.operator == EditorOperator.CONTEXT])
			
		nodes.addAll(GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
			it.operator == EditorOperator.DELETE]))
			
		return Scopes.scopeFor(nodes)
	}
	
	/**
	 * get all the possible nodes in the pattern
	 */
	def getScopeForStochasticFunction(StochasticFunction function) {
		var pattern = GTEditorPatternUtils.getContainer(function, typeof(EditorPatternImpl))
		// searches for EditorPattern Container
		val nodes = GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
			it.operator == EditorOperator.CONTEXT])
			
		nodes.addAll(GTEditorPatternUtils.getAllNodesOfPattern(pattern, [
			it.operator == EditorOperator.DELETE]))
			
		return Scopes.scopeFor(nodes)
	}

	/**
	 * Any attributes of the node of the attribute expression are valid
	 * if their type fits to the one expected for the attribute value. 
	 */
	def getScopeForAttributeExpressionAttributes(EditorAttributeExpression attributeExpression) {
		if (attributeExpression.eContainer instanceof EditorAttributeAssignment) {
			val attributeConstraint = attributeExpression.eContainer as EditorAttributeAssignment
			val node = attributeExpression.node
			if (node === null || node.type === null) {
				return Scopes.scopeFor([])
			}
			val attributes = node.type.EAllAttributes.filter [
				it.EAttributeType == attributeConstraint.attribute.EAttributeType
			]
			return Scopes.scopeFor(attributes)
		} else {
			val node = attributeExpression.node
			if (node === null || node.type === null) {
				return Scopes.scopeFor([])
			}
			return Scopes.scopeFor(attributeExpression.node.type.EAllAttributes)
		}
	}

	/**
	 * Parameter expressions must reference a parameter of the type expected for the attribute value.
	 */
	def getScopeForParameterExpressions(EditorParameterExpression parameterExpression) {
		if (parameterExpression.eContainer instanceof EditorAttributeAssignment) {
			val attributeConstraint = parameterExpression.eContainer as EditorAttributeAssignment
			val pattern = attributeConstraint.eContainer.eContainer as EditorPattern
			val parameters = newArrayList()
			GTEditorPatternUtils.getPatternWithAllSuperPatterns(pattern).forEach [
				parameters.addAll(it.parameters.filter [
					it.type == attributeConstraint.attribute.EAttributeType
				])
			]
			return Scopes.scopeFor(parameters)
		} else {
			val pattern = GTEditorPatternUtils.getContainer(parameterExpression, typeof(EditorPatternImpl))
			val parameters = newArrayList()
			GTEditorPatternUtils.getPatternWithAllSuperPatterns(pattern).forEach [
				parameters.addAll(it.parameters)
			]
			return Scopes.scopeFor(parameters)
		}
	}

	/**
	 * Any literal of the attribute's enum is valid.
	 */
	def getScopeForEnumLiterals(EditorEnumExpression enumExpression) {
		val type = GTEnumExpressionHelper.getEnumDataType(enumExpression) as EEnum
		if (type !== null && type instanceof EEnum) {
			return Scopes.scopeFor(type.ELiterals)
		} else {
			val gtFile = GTEditorPatternUtils.getContainer(enumExpression, typeof(EditorGTFileImpl))
			return Scopes.scopeFor(GTEditorModelUtils.getEnums(gtFile).flatMap[enum|enum.ELiterals])
		}

	}

}
