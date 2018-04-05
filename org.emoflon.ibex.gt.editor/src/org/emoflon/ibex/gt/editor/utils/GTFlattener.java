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
import org.emoflon.ibex.gt.editor.gT.EditorParameter;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.GTFactory;
import org.emoflon.ibex.gt.editor.gT.Node;
import org.emoflon.ibex.gt.editor.gT.Rule;

/**
 * Provides flattening of refined rules.
 */
public class GTFlattener {
	/**
	 * The flattened rule.
	 */
	private Rule flattenedRule;

	/**
	 * The errors occurred during flattening.
	 */
	private List<String> errors = new ArrayList<String>();

	/**
	 * Creates a flattened version of the given rule.
	 * 
	 * @param rule
	 *            the rule
	 */
	public GTFlattener(final Rule rule) {
		Set<Rule> superRules = GTEditorRuleUtils.getAllSuperRules(rule);

		List<EditorParameter> parameters = mergeParameters(rule, superRules);

		List<Node> nodes = mergeNodes(rule, superRules, parameters);
		nodes.sort((a, b) -> a.getName().compareTo(b.getName()));

		createFlattenedRule(rule, parameters, nodes);
	}

	/**
	 * Creates the flattened rule
	 * 
	 * @param rule
	 *            the original rule
	 * @param parameters
	 *            the parameters
	 * @param nodes
	 *            the nodes
	 */
	private void createFlattenedRule(final Rule rule, final List<EditorParameter> parameters, final List<Node> nodes) {
		flattenedRule = GTFactory.eINSTANCE.createRule();
		flattenedRule.setAbstract(rule.isAbstract());
		flattenedRule.setName(rule.getName());
		flattenedRule.getParameters().addAll(parameters);
		flattenedRule.getNodes().addAll(nodes);
	}

	/**
	 * Returns the flattened rule.
	 * 
	 * @return the flattened rule
	 */
	public Rule getFlattenedRule() {
		return flattenedRule;
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
	 * Merged the given parameters based on the convention that parameters with the
	 * same name must be equal.
	 * 
	 * @param rule
	 *            the rule the rule
	 * @param superRules
	 *            the super rules of the rule
	 * @return the merged parameters
	 */
	private List<EditorParameter> mergeParameters(final Rule rule, final Set<Rule> superRules) {
		List<EditorParameter> parameters = new ArrayList<EditorParameter>();
		Map<String, EditorParameter> parameterNameToParameter = new HashMap<String, EditorParameter>();
		addParametersFromRule(rule, parameters, parameterNameToParameter);
		superRules.forEach(r -> addParametersFromRule(r, parameters, parameterNameToParameter));
		return parameters;
	}

	/**
	 * Adds the parameters of the given rule.
	 * 
	 * @param rule
	 *            the rule whose parameters to add
	 * @param parameters
	 *            the parameters (in order of adding to the list)
	 * @param parameterNameToParameter
	 *            the mapping between names and parameters
	 */
	private void addParametersFromRule(final Rule rule, final List<EditorParameter> parameters,
			final Map<String, EditorParameter> parameterNameToParameter) {
		for (final EditorParameter parameter : rule.getParameters()) {
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
	 * @param rule
	 *            the rule the rule
	 * @param superRules
	 *            the super rules of the rule
	 * @param parameters
	 *            the parameters of the flattened rule
	 * @return the merged nodes
	 */
	private List<Node> mergeNodes(final Rule rule, final Set<Rule> superRules, final List<EditorParameter> parameters) {
		// Collect nodes.
		List<Node> collectedNodes = new ArrayList<Node>();
		collectedNodes.addAll(EcoreUtil.copyAll(rule.getNodes()));
		superRules.forEach(r -> collectedNodes.addAll(EcoreUtil.copyAll(r.getNodes())));

		// Merge nodes with the same name.
		Map<String, Node> nodeNameToNode = new HashMap<String, Node>();
		for (final Node node : collectedNodes) {
			if (nodeNameToNode.containsKey(node.getName())) {
				mergeTwoNodes(nodeNameToNode.get(node.getName()), node);
			} else {
				nodeNameToNode.put(node.getName(), node);
			}
		}

		// Cleanup reference targets.
		List<Node> nodes = new ArrayList<Node>(nodeNameToNode.values());
		cleanupNodes(nodes, nodeNameToNode);
		return nodes;
	}

	/**
	 * Sets the reference targets of all nodes to the correct node from the map.
	 * 
	 * @param nodes
	 *            the nodes
	 * @param nodeNameToNode
	 *            the mapping between node names and nodes
	 */
	private void cleanupNodes(final List<Node> nodes, final Map<String, Node> nodeNameToNode) {
		nodes.forEach(node -> {
			node.getReferences().forEach(r -> {
				if (r.getTarget() != null) {
					r.setTarget(nodeNameToNode.get(r.getTarget().getName()));
				}
			});
		});
	}

	/**
	 * Merged the given nodes.
	 * 
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the other node
	 */
	private void mergeTwoNodes(final Node node, final Node mergedNode) {
		// Determine type: Choose more concrete one.
		if (node.getType().isSuperTypeOf(mergedNode.getType())) {
			node.setType(mergedNode.getType());
		}

		mergeOperatorsOfNodes(node, mergedNode);
		mergeAttributesOfNodes(node, mergedNode);
		mergeReferencesOfNodes(node, mergedNode);
	}

	/**
	 * Merges the operators of the given nodes if possible.
	 * 
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the first one
	 */
	private void mergeOperatorsOfNodes(final Node node, final Node mergedNode) {
		Optional<EditorOperator> operator = GTFlatteningUtils.getMergedOperator(node.getOperator(),
				mergedNode.getOperator());
		if (operator.isPresent()) {
			node.setOperator(operator.get());
		} else {
			errors.add(String.format("Node %s: Cannot merge operators %s and %s", //
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
	private void mergeAttributesOfNodes(final Node node, final Node mergedNode) {
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
	private void mergeAttribute(final Node node, final EditorAttribute mergedAttribute) {
		Optional<EditorAttribute> attribute = node.getAttributes().stream()
				.filter(a -> GTEditorComparator.areAttributeConstraintsEqual(a, mergedAttribute)).findAny();
		if (!attribute.isPresent()) {
			boolean canAdd = true;
			if (GTFlatteningUtils.hasConflictingAssignment(node, mergedAttribute)) {
				errors.add(String.format("Node %s has multiple assignments for attribute %s.", node.getName(),
						mergedAttribute.getAttribute().getName()));
				canAdd = false;
			}
			if (canAdd) {
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
	private void mergeReferencesOfNodes(final Node node, final Node mergedNode) {
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
	private void mergeReference(final Node node, final EditorReference mergedReference) {
		Optional<EditorReference> referenceInNode = node.getReferences().stream()
				.filter(r -> GTEditorComparator.areReferencesEqual(r, mergedReference)).findAny();
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
