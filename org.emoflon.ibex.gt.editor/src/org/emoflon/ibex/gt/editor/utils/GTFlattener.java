package org.emoflon.ibex.gt.editor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.gt.editor.gT.AddExpression;
import org.emoflon.ibex.gt.editor.gT.ArithmeticCalculationExpression;
import org.emoflon.ibex.gt.editor.gT.ArithmeticExpression;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression;
import org.emoflon.ibex.gt.editor.gT.EditorExpression;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorParameter;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.ExpExpression;
import org.emoflon.ibex.gt.editor.gT.GTFactory;
import org.emoflon.ibex.gt.editor.gT.MinMaxExpression;
import org.emoflon.ibex.gt.editor.gT.MultExpression;
import org.emoflon.ibex.gt.editor.gT.OneParameterArithmetics;
import org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression;

/**
 * Provides flattening of refined patterns.
 */
public class GTFlattener {
	/**
	 * The flattened pattern.
	 */
	private EditorPattern flattenedPattern;

	/**
	 * The errors occurred during flattening.
	 */
	private final List<String> errors = new ArrayList<>();

	/**
	 * Creates a flattened version of the given pattern.
	 * 
	 * @param pattern the pattern
	 */
	public GTFlattener(final EditorPattern pattern) {
		// Early return if there's nothing to flatten.
		if (pattern.getSuperPatterns().isEmpty()) {
			flattenedPattern = pattern;
			return;
		}

		createFlattenedPattern(pattern);
	}

	/**
	 * Creates the flattened pattern.
	 * 
	 * @param pattern             the original pattern
	 * @param attributeConditions
	 */
	private void createFlattenedPattern(final EditorPattern pattern) {

		final Set<EditorPattern> superPatterns = GTEditorPatternUtils.getAllSuperPatterns(pattern);

		flattenedPattern = GTFactory.eINSTANCE.createEditorPattern();
		flattenedPattern.setAbstract(pattern.isAbstract());
		flattenedPattern.setType(pattern.getType());
		flattenedPattern.setName(pattern.getName());
		flattenedPattern.setProbability(pattern.getProbability());
		flattenedPattern.setStochastic(pattern.isStochastic());
		initializeParameters(pattern, superPatterns);
		initializeNodes(pattern, superPatterns);
		flattenedPattern.getConditions().addAll(pattern.getConditions());
		// fix attribute conditions pointing to the wrong editor node
		Map<String, EditorNode> name2Node = new HashMap<>();
		flattenedPattern.getNodes().forEach(node -> name2Node.put(node.getName(), node));
		flattenedPattern.getNodes().stream()
			.flatMap(node -> node.getAttributes().stream())
			.map(attribute -> attribute.getValue())
			.filter(editorExpression -> (editorExpression instanceof EditorAttributeExpression))
			.map(editorExpression -> (EditorAttributeExpression)editorExpression)
			.forEach(editorAttributeExpression -> {
				if(name2Node.containsKey(editorAttributeExpression.getNode().getName())) {
					editorAttributeExpression.setNode(name2Node.get(editorAttributeExpression.getNode().getName()));
				}
			});
		initializeAttributeConstraints(pattern, superPatterns, name2Node);
	}

	
	private void initializeParameters(final EditorPattern pattern, final Set<EditorPattern> superPatterns) {
		final List<EditorParameter> parameters = mergeParameters(pattern, superPatterns);
		flattenedPattern.getParameters().addAll(parameters);
	}

	private void initializeNodes(final EditorPattern pattern, final Set<EditorPattern> superPatterns) {
		final List<EditorNode> nodes = mergeNodes(pattern, superPatterns);
		flattenedPattern.getNodes().addAll(nodes);
	}
	
	private void initializeAttributeConstraints(EditorPattern pattern, Set<EditorPattern> superPatterns, Map<String, EditorNode> name2Node) {
		final List<EditorAttributeConstraint> constraints = mergeConstraints(pattern, superPatterns);
		constraints.forEach(constr -> fixConstraintNodes(constr, name2Node));
		flattenedPattern.getAttributeConstraints().addAll(constraints);
		
	}
	
	private void fixConstraintNodes(EditorAttributeConstraint constraint, Map<String, EditorNode> name2Node) {
		fixEditorExpression(constraint.getLhs(), name2Node);
		fixEditorExpression(constraint.getRhs(), name2Node);
	}
	
	private void fixEditorExpression(EditorExpression expr, Map<String, EditorNode> name2Node) {
		if(expr instanceof EditorAttributeExpression) {
			EditorAttributeExpression eae = (EditorAttributeExpression)expr;
			eae.setNode(name2Node.get(eae.getNode().getName()));
		} else if(expr instanceof StochasticFunctionExpression) {
			StochasticFunctionExpression sfe = (StochasticFunctionExpression)expr;
			fixArithmeticExpression(sfe.getMean(), name2Node);
			fixArithmeticExpression(sfe.getSd(), name2Node);
		} else if(expr instanceof ArithmeticCalculationExpression) {
			fixArithmeticExpression(((ArithmeticCalculationExpression)expr).getExpression(), name2Node);
		} else {
			return;
		}
	}
	
	private void fixArithmeticExpression(ArithmeticExpression expr, Map<String, EditorNode> name2Node) {
		if(expr instanceof AddExpression) {
			fixArithmeticExpression(((AddExpression)expr).getLeft(),name2Node);
			fixArithmeticExpression(((AddExpression)expr).getRight(),name2Node);
		} else if(expr instanceof MultExpression) {
			fixArithmeticExpression(((MultExpression)expr).getLeft(),name2Node);
			fixArithmeticExpression(((MultExpression)expr).getRight(),name2Node);
		} else if(expr instanceof ExpExpression) {
			fixArithmeticExpression(((ExpExpression)expr).getLeft(),name2Node);
			fixArithmeticExpression(((ExpExpression)expr).getRight(),name2Node);
		} else if(expr instanceof MinMaxExpression) {
			fixArithmeticExpression(((MinMaxExpression)expr).getLeft(),name2Node);
			fixArithmeticExpression(((MinMaxExpression)expr).getRight(),name2Node);
		}else if(expr instanceof OneParameterArithmetics) {
			fixArithmeticExpression(((OneParameterArithmetics)expr).getExpression(),name2Node);
		}else if(expr instanceof EditorAttributeExpression) {
			EditorAttributeExpression ana = (EditorAttributeExpression)expr;
			ana.setNode(name2Node.get(ana.getNode().getName()));
		}else {
			return;
		}
	}
	
	/**
	 * Returns the flattened pattern.
	 * 
	 * @return the flattened pattern
	 */
	public EditorPattern getFlattenedPattern() {
		return flattenedPattern;
	}

	/**
	 * Returns the errors occurred during flattening.
	 * 
	 * @return the error messages
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Returns whether errors occurred during the flattening.
	 * 
	 * @return
	 */
	public boolean hasErrors() {
		return errors.size() > 0;
	}

	/**
	 * Merges the given parameters based on the convention that parameters with the
	 * same name must be equal.
	 * 
	 * @param pattern       the pattern
	 * @param superPatterns the super patterns of the pattern
	 * @return the merged parameters
	 */
	private List<EditorParameter> mergeParameters(final EditorPattern pattern, final Set<EditorPattern> superPatterns) {
		final List<EditorParameter> parameters = new ArrayList<>();
		final Map<String, EditorParameter> parameterNameToParameter = new HashMap<>();
		addParametersFromPattern(pattern, parameters, parameterNameToParameter);
		superPatterns.forEach(r -> addParametersFromPattern(r, parameters, parameterNameToParameter));
		return parameters;
	}

	/**
	 * Adds the parameters of the given pattern.
	 * 
	 * @param pattern                  the pattern whose parameters to add
	 * @param parameters               the parameters (in order of adding to the
	 *                                 list)
	 * @param parameterNameToParameter the mapping between names and parameters
	 */
	private void addParametersFromPattern(final EditorPattern pattern, final List<EditorParameter> parameters,
			final Map<String, EditorParameter> parameterNameToParameter) {
		for (final EditorParameter parameter : pattern.getParameters()) {
			if (parameterNameToParameter.containsKey(parameter.getName())) {
				final EDataType typeOfExistingParameter = parameterNameToParameter.get(parameter.getName()).getType();
				if (!typeOfExistingParameter.equals(parameter.getType())) {
					errors.add(String.format("Inconsistent type declarations for parameter %s: %s and %s.",
							parameter.getName(), typeOfExistingParameter.getName(), parameter.getType().getName()));
				}
			} else {
				final EditorParameter copy = EcoreUtil.copy(parameter);
				parameterNameToParameter.put(parameter.getName(), copy);
				parameters.add(copy);
			}
		}
	}

	/**
	 * Merged the given nodes based on the convention that nodes with the same name
	 * are equal.
	 * 
	 * @param pattern       the pattern
	 * @param superPatterns the super patterns of the pattern
	 * @return the merged nodes
	 */
	private List<EditorNode> mergeNodes(final EditorPattern pattern, final Set<EditorPattern> superPatterns) {
		// Collect nodes.
		final List<EditorNode> collectedNodes = new ArrayList<>();
		collectedNodes.addAll(EcoreUtil.copyAll(pattern.getNodes()));
		superPatterns.forEach(r -> collectedNodes.addAll(EcoreUtil.copyAll(r.getNodes())));

		// Merge nodes with the same name.
		final Map<String, EditorNode> nodeNameToNode = mergeNodesOfTheSameName(collectedNodes);

		// Cleanup reference targets.
		final List<EditorNode> nodes = new ArrayList<>(nodeNameToNode.values());
		cleanupNodes(nodes, nodeNameToNode);
		return nodes;
	}

	/**
	 * Merges nodes of the same name.
	 * 
	 * @param collectedNodes the nodes to merge
	 * @return a map node name -> node
	 */
	private Map<String, EditorNode> mergeNodesOfTheSameName(final List<EditorNode> collectedNodes) {
		final Map<String, EditorNode> nodeNameToNode = new HashMap<>();
		for (final EditorNode node : collectedNodes) {
			if (nodeNameToNode.containsKey(node.getName())) {
				mergeTwoNodes(nodeNameToNode.get(node.getName()), node);
			} else {
				nodeNameToNode.put(node.getName(), node);
			}
		}
		return nodeNameToNode;
	}

	/**
	 * Sets the reference targets of all nodes to the correct node from the map.
	 * 
	 * @param nodes          the nodes
	 * @param nodeNameToNode the mapping between node names and nodes
	 */
	private void cleanupNodes(final List<EditorNode> nodes, final Map<String, EditorNode> nodeNameToNode) {
		nodes.stream().flatMap(node -> node.getReferences().stream()) //
				.filter(r -> r.getTarget() != null) //
				.forEach(r -> r.setTarget(nodeNameToNode.get(r.getTarget().getName())));
		nodes.sort((a, b) -> a.getName().compareTo(b.getName()));
	}

	/**
	 * Merged the given nodes.
	 * 
	 * @param node       the node
	 * @param mergedNode the node merged into the other node
	 */
	private void mergeTwoNodes(final EditorNode node, final EditorNode mergedNode) {
		mergeTypesOfNodes(node, mergedNode);
		mergeOperatorsOfNodes(node, mergedNode);
		mergeAttributesOfNodes(node, mergedNode);
		mergeReferencesOfNodes(node, mergedNode);
	}

	/**
	 * Merges the type of the second node with the one of the first one.
	 * 
	 * @param node       the node
	 * @param mergedNode the node merged into the other node
	 */
	private void mergeTypesOfNodes(final EditorNode node, final EditorNode mergedNode) {
		if (node.getType() == null && mergedNode.getType() == null) {
			errors.add(String.format("No type can be determined for node %s", node.getName()));
		}

		// Determine type: Choose more concrete one.
		if (node.getType() == null || node.getType().isSuperTypeOf(mergedNode.getType())) {
			node.setType(mergedNode.getType());
		}
	}

	/**
	 * Merges the operators of the given nodes if possible.
	 * 
	 * @param node       the node
	 * @param mergedNode the node merged into the first one
	 */
	private void mergeOperatorsOfNodes(final EditorNode node, final EditorNode mergedNode) {
		final Optional<EditorOperator> operator = GTFlatteningUtils.mergedOperators(node.getOperator(),
				mergedNode.getOperator());
		if (operator.isPresent()) {
			node.setOperator(operator.get());
		} else {
			errors.add(String.format("Node %s: Cannot merge operators %s and %s.", //
					node.getName(), node.getOperator(), mergedNode.getOperator()));
		}
	}

	/**
	 * Merges the attribute constraints of the second node into the attributes of
	 * the first node.
	 * 
	 * @param node       the node
	 * @param mergedNode the node merged into the first one
	 */
	private void mergeAttributesOfNodes(final EditorNode node, final EditorNode mergedNode) {
		for (final EditorAttributeAssignment mergedAttribute : mergedNode.getAttributes()) {
			mergeAttribute(node, mergedAttribute);
		}
	}

	/**
	 * Merges the attribute into the attributes of the node.
	 * 
	 * @param node            the node
	 * @param mergedAttribute the attribute to merge
	 */
	private void mergeAttribute(final EditorNode node, final EditorAttributeAssignment mergedAttribute) {
		final Optional<EditorAttributeAssignment> attribute = node.getAttributes().stream()
				.filter(a -> GTEditorAttributeComparator.areAttributeAssignmentsEqual(a, mergedAttribute)).findAny();
		if (!attribute.isPresent()) {
			if (GTFlatteningUtils.hasConflictingAssignment(node, mergedAttribute)) {
				errors.add(String.format("Node %s has multiple assignments for attribute %s.", node.getName(),
						mergedAttribute.getAttribute().getName()));
			} else {
				node.getAttributes().add(EcoreUtil.copy(mergedAttribute));
			}
		}
	}

	/**
	 * Merges the references of the second node into the references of the first
	 * node.
	 * 
	 * @param node       the node
	 * @param mergedNode the node merged into the first one
	 */
	private void mergeReferencesOfNodes(final EditorNode node, final EditorNode mergedNode) {
		for (final EditorReference mergedReference : mergedNode.getReferences()) {
			mergeReference(node, mergedReference);
		}
	}

	/**
	 * Merges the reference into the references of the node.
	 * 
	 * @param node            the node
	 * @param mergedReference the reference to merge
	 */
	private void mergeReference(final EditorNode node, final EditorReference mergedReference) {
		final Optional<EditorReference> referenceInNode = node.getReferences().stream()
				.filter(r -> GTEditorAttributeComparator.areReferencesEqual(r, mergedReference)).findAny();
		if (referenceInNode.isPresent()) {
			final Optional<EditorOperator> operator = GTFlatteningUtils
					.mergedOperators(referenceInNode.get().getOperator(), mergedReference.getOperator());
			if (operator.isPresent()) {
				referenceInNode.get().setOperator(operator.get());
			} else {
				errors.add(String.format("Reference between %s and %s: Cannot merge operators %s and %s.",
						node.getName(), mergedReference.getTarget().getName(), referenceInNode.get().getOperator(),
						mergedReference.getOperator()));
			}
		} else {
			node.getReferences().add(EcoreUtil.copy(mergedReference));
		}
	}
	
	private List<EditorAttributeConstraint> mergeConstraints(EditorPattern pattern, Set<EditorPattern> superPatterns) {
		// Collect nodes.
		final List<EditorAttributeConstraint> collectedConstraints = new LinkedList<>();
		collectedConstraints.addAll(EcoreUtil.copyAll(pattern.getAttributeConstraints()));
		superPatterns.forEach(r -> collectedConstraints.addAll(EcoreUtil.copyAll(r.getAttributeConstraints())));
		//TODO: Filter duplicates
		return collectedConstraints;
	}
}
