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
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.EditorRelation;
import org.emoflon.ibex.gt.editor.gT.GTFactory;
import org.emoflon.ibex.gt.editor.gT.Node;
import org.emoflon.ibex.gt.editor.gT.Parameter;
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

		flattenedRule = GTFactory.eINSTANCE.createRule();
		flattenedRule.setAbstract(rule.isAbstract());
		flattenedRule.setName(rule.getName());

		List<Parameter> parameters = mergeParameters(rule, superRules);
		flattenedRule.getParameters().addAll(parameters);

		List<Node> nodes = mergeNodes(rule, superRules, parameters);
		nodes.sort((a, b) -> a.getName().compareTo(b.getName()));
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
	private List<Parameter> mergeParameters(final Rule rule, final Set<Rule> superRules) {
		List<Parameter> parameters = new ArrayList<Parameter>();
		Map<String, Parameter> parameterNameToParameter = new HashMap<String, Parameter>();
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
	private void addParametersFromRule(final Rule rule, final List<Parameter> parameters,
			final Map<String, Parameter> parameterNameToParameter) {
		for (final Parameter parameter : rule.getParameters()) {
			if (parameterNameToParameter.containsKey(parameter.getName())) {
				EDataType typeOfExistingParameter = parameterNameToParameter.get(parameter.getName()).getType();
				if (!typeOfExistingParameter.equals(parameter.getType())) {
					errors.add(String.format("Inconsistent type declarations for parameter %s: %s and %s.",
							parameter.getName(), typeOfExistingParameter.getName(), parameter.getType().getName()));
				}
			} else {
				Parameter copy = EcoreUtil.copy(parameter);
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
	private List<Node> mergeNodes(final Rule rule, final Set<Rule> superRules, final List<Parameter> parameters) {
		// Collect nodes.
		List<Node> collectedNodes = new ArrayList<Node>();
		collectedNodes.addAll(EcoreUtil.copyAll(rule.getNodes()));
		superRules.forEach(r -> {
			collectedNodes.addAll(EcoreUtil.copyAll(r.getNodes()));
		});

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
		nodes.forEach(n -> {
			n.getReferences().forEach(r -> {
				if (r.getTarget() != null) {
					r.setTarget(nodeNameToNode.get(r.getTarget().getName()));
				}
			});
		});
		return nodes;
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

		// Determine operator.
		try {
			EditorOperator operator = getMergedOperator(node.getOperator(), mergedNode.getOperator());
			node.setOperator(operator);
		} catch (IllegalArgumentException e) {
			errors.add(String.format("Node %s: %s", node.getName(), e.getMessage()));
		}

		mergeAttributesOfNodes(node, mergedNode);
		mergeReferencesOfNodes(node, mergedNode);
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
			Optional<EditorAttribute> attribute = node.getAttributes().stream()
					.filter(a -> GTEditorComparator.areAttributeConstraintsEqual(a, mergedAttribute)).findAny();
			if (!attribute.isPresent()) {
				boolean canAdd = true;
				if (mergedAttribute.getRelation() == EditorRelation.ASSIGNMENT) {
					if (hasConflictingAssignment(node, mergedAttribute)) {
						errors.add(String.format("Node %s has multiple assignments for attribute %s.", node.getName(),
								mergedAttribute.getAttribute().getName()));
						canAdd = false;
					}
				}
				if (canAdd) {
					node.getAttributes().add(EcoreUtil.copy(mergedAttribute));
				}
			}
		}
	}

	/**
	 * Checks whether the node has any attribute assignment for the same attribute,
	 * but another value.
	 * 
	 * @param node
	 *            the node to check
	 * @param b
	 *            the attribute assignment to check
	 * @return <code>true</code> if and only if the node has another assignment for
	 *         the same attribute
	 */
	private static boolean hasConflictingAssignment(final Node node, final EditorAttribute b) {
		return !node.getAttributes().stream()
				.filter(a -> a.getRelation() == EditorRelation.ASSIGNMENT && a.getAttribute().equals(b.getAttribute()))
				.allMatch(a -> GTEditorComparator.areExpressionsEqual(a.getValue(), b.getValue()));
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
			Optional<EditorReference> referenceInNode = node.getReferences().stream()
					.filter(r -> GTEditorComparator.areReferencesEqual(r, mergedReference)).findAny();
			if (referenceInNode.isPresent()) {
				try {
					EditorOperator operator = getMergedOperator(referenceInNode.get().getOperator(),
							mergedReference.getOperator());
					referenceInNode.get().setOperator(operator);
				} catch (IllegalArgumentException e) {
					errors.add(String.format("Reference between %s and %s: %s", node.getName(), mergedNode.getName(),
							e.getMessage()));
				}
			} else {
				node.getReferences().add(EcoreUtil.copy(mergedReference));
			}
		}
	}

	/**
	 * Returns the operator if elements with the two given elements are merged.
	 * 
	 * @param a
	 *            the operator of the first element
	 * @param b
	 *            the operator of the second element
	 * @return the operator of the merged element
	 */
	private EditorOperator getMergedOperator(final EditorOperator a, final EditorOperator b) {
		if (a.equals(b)) {
			return a;
		}

		// Context overwrites create/delete.
		if (a == EditorOperator.CONTEXT || b == EditorOperator.CONTEXT) {
			return EditorOperator.CONTEXT;
		}

		String message = String.format("Cannot merge operators %s and %s.", a, b);
		throw new IllegalArgumentException(message);
	}
}
