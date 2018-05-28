package org.emoflon.ibex.gt.editor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorParameter;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.GTFactory;

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
	private List<String> errors = new ArrayList<String>();

	/**
	 * Creates a flattened version of the given pattern.
	 * 
	 * @param pattern
	 *            the pattern
	 */
	public GTFlattener(final EditorPattern pattern) {
		// Early return if there's nothing to flatten.
		if (pattern.getSuperPatterns().isEmpty()) {
			flattenedPattern = pattern;
			return;
		}

		Set<EditorPattern> superPatterns = GTEditorPatternUtils.getAllSuperPatterns(pattern);
		List<EditorParameter> parameters = mergeParameters(pattern, superPatterns);
		List<EditorNode> nodes = mergeNodes(pattern, superPatterns, parameters);
		createFlattenedPattern(pattern, parameters, nodes);
	}

	/**
	 * Creates the flattened pattern.
	 * 
	 * @param pattern
	 *            the original pattern
	 * @param parameters
	 *            the parameters
	 * @param nodes
	 *            the nodes
	 */
	private void createFlattenedPattern(final EditorPattern pattern, final List<EditorParameter> parameters,
			final List<EditorNode> nodes) {
		flattenedPattern = GTFactory.eINSTANCE.createEditorPattern();
		flattenedPattern.setAbstract(pattern.isAbstract());
		flattenedPattern.setType(pattern.getType());
		flattenedPattern.setName(pattern.getName());
		flattenedPattern.getParameters().addAll(parameters);
		flattenedPattern.getNodes().addAll(nodes);
		flattenedPattern.getConditions().addAll(pattern.getConditions());
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
	 * @param pattern
	 *            the pattern
	 * @param superPatterns
	 *            the super patterns of the pattern
	 * @return the merged parameters
	 */
	private List<EditorParameter> mergeParameters(final EditorPattern pattern, final Set<EditorPattern> superPatterns) {
		List<EditorParameter> parameters = new ArrayList<EditorParameter>();
		Map<String, EditorParameter> parameterNameToParameter = new HashMap<String, EditorParameter>();
		addParametersFromPattern(pattern, parameters, parameterNameToParameter);
		superPatterns.forEach(r -> addParametersFromPattern(r, parameters, parameterNameToParameter));
		return parameters;
	}

	/**
	 * Adds the parameters of the given pattern.
	 * 
	 * @param pattern
	 *            the pattern whose parameters to add
	 * @param parameters
	 *            the parameters (in order of adding to the list)
	 * @param parameterNameToParameter
	 *            the mapping between names and parameters
	 */
	private void addParametersFromPattern(final EditorPattern pattern, final List<EditorParameter> parameters,
			final Map<String, EditorParameter> parameterNameToParameter) {
		for (final EditorParameter parameter : pattern.getParameters()) {
			if (parameterNameToParameter.containsKey(parameter.getName())) {
				EDataType typeOfExistingParameter = parameterNameToParameter.get(parameter.getName()).getType();
				if (!typeOfExistingParameter.equals(parameter.getType())) {
					errors.add(String.format("Inconsistent type declarations for parameter %s: %s and %s.",
							parameter.getName(), typeOfExistingParameter.getName(), parameter.getType().getName()));
				}
			} else {
				EditorParameter copy = EcoreUtil.copy(parameter);
				parameterNameToParameter.put(parameter.getName(), copy);
				parameters.add(copy);
			}
		}
	}

	/**
	 * Merged the given nodes based on the convention that nodes with the same name
	 * are equal.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param superPatterns
	 *            the super patterns of the pattern
	 * @param parameters
	 *            the parameters of the flattened pattern
	 * @return the merged nodes
	 */
	private List<EditorNode> mergeNodes(final EditorPattern pattern, final Set<EditorPattern> superPatterns,
			final List<EditorParameter> parameters) {
		// Collect nodes.
		List<EditorNode> collectedNodes = new ArrayList<EditorNode>();
		collectedNodes.addAll(EcoreUtil.copyAll(pattern.getNodes()));
		superPatterns.forEach(r -> collectedNodes.addAll(EcoreUtil.copyAll(r.getNodes())));

		// Merge nodes with the same name.
		Map<String, EditorNode> nodeNameToNode = mergeNodesOfTheSameName(collectedNodes);

		// Cleanup reference targets.
		List<EditorNode> nodes = new ArrayList<EditorNode>(nodeNameToNode.values());
		cleanupNodes(nodes, nodeNameToNode);
		return nodes;
	}

	/**
	 * Merges nodes of the same name.
	 * 
	 * @param collectedNodes
	 *            the nodes to merge
	 * @return a map node name -> node
	 */
	private Map<String, EditorNode> mergeNodesOfTheSameName(final List<EditorNode> collectedNodes) {
		Map<String, EditorNode> nodeNameToNode = new HashMap<String, EditorNode>();
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
	 * @param nodes
	 *            the nodes
	 * @param nodeNameToNode
	 *            the mapping between node names and nodes
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
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the other node
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
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the other node
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
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the first one
	 */
	private void mergeOperatorsOfNodes(final EditorNode node, final EditorNode mergedNode) {
		Optional<EditorOperator> operator = GTFlatteningUtils.getMergedOperator(node.getOperator(),
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
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the first one
	 */
	private void mergeAttributesOfNodes(final EditorNode node, final EditorNode mergedNode) {
		for (EditorAttribute mergedAttribute : mergedNode.getAttributes()) {
			mergeAttribute(node, mergedAttribute);
		}
	}

	/**
	 * Merges the attribute into the attributes of the node.
	 * 
	 * @param node
	 *            the node
	 * @param mergedAttribute
	 *            the attribute to merge
	 */
	private void mergeAttribute(final EditorNode node, final EditorAttribute mergedAttribute) {
		Optional<EditorAttribute> attribute = node.getAttributes().stream()
				.filter(a -> GTEditorAttributeComparator.areAttributeConstraintsEqual(a, mergedAttribute)).findAny();
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
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the first one
	 */
	private void mergeReferencesOfNodes(final EditorNode node, final EditorNode mergedNode) {
		for (EditorReference mergedReference : mergedNode.getReferences()) {
			mergeReference(node, mergedReference);
		}
	}

	/**
	 * Merges the reference into the references of the node.
	 * 
	 * @param node
	 *            the node
	 * @param mergedReference
	 *            the reference to merge
	 */
	private void mergeReference(final EditorNode node, final EditorReference mergedReference) {
		Optional<EditorReference> referenceInNode = node.getReferences().stream()
				.filter(r -> GTEditorAttributeComparator.areReferencesEqual(r, mergedReference)).findAny();
		if (referenceInNode.isPresent()) {
			Optional<EditorOperator> operator = GTFlatteningUtils.getMergedOperator(referenceInNode.get().getOperator(),
					mergedReference.getOperator());
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
}
