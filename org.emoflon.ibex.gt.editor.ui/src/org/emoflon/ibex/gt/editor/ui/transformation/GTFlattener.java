package org.emoflon.ibex.gt.editor.ui.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.gt.editor.gT.GTFactory;
import org.emoflon.ibex.gt.editor.gT.Node;
import org.emoflon.ibex.gt.editor.gT.Operator;
import org.emoflon.ibex.gt.editor.gT.Reference;
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
		List<Node> collectedNodes = new ArrayList<Node>();
		collectedNodes.addAll(EcoreUtil.copyAll(rule.getNodes()));
		getAllSuperRules(rule).forEach(r -> {
			collectedNodes.addAll(EcoreUtil.copyAll(r.getNodes()));
		});

		flattenedRule = GTFactory.eINSTANCE.createRule();
		flattenedRule.setAbstract(rule.isAbstract());
		flattenedRule.setName(rule.getName());
		flattenedRule.getNodes().addAll(mergeNodes(collectedNodes));
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
	 * Merged the given nodes based on the convention hat nodes with the same name
	 * are equal.
	 * 
	 * @param collectedNodes
	 *            the nodes
	 * @return the merged nodes
	 */
	private Collection<Node> mergeNodes(final List<Node> collectedNodes) {
		Map<String, Node> nodeNameToNode = new HashMap<String, Node>();
		for (Node node : collectedNodes) {
			if (nodeNameToNode.containsKey(node.getName())) {
				mergeTwoNodes(nodeNameToNode.get(node.getName()), node);
			} else {
				nodeNameToNode.put(node.getName(), node);
			}
		}

		// Cleanup reference targets.
		Collection<Node> nodes = nodeNameToNode.values();
		nodes.forEach(n -> {
			n.getReferences().forEach(r -> {
				r.setTarget(nodeNameToNode.get(r.getTarget().getName()));
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
		// TODO: node types may be incompatible.

		// Determine operator.
		try {
			Operator operator = getMergedOperator(node.getOperator(), mergedNode.getOperator());
			node.setOperator(operator);
		} catch (IllegalArgumentException e) {
			errors.add(String.format("Node %s: %s", node.getName(), e.getMessage()));
		}

		mergeReferencesOfNodes(node, mergedNode);
	}

	/**
	 * Merges the references of the second node into the references of the first
	 * node.
	 * 
	 * @param node
	 *            the node
	 * @param mergedNode
	 *            the node merged into the other node
	 */
	private void mergeReferencesOfNodes(final Node node, final Node mergedNode) {
		for (Reference mergedReference : mergedNode.getReferences()) {
			Optional<Reference> referenceInNode = node.getReferences().stream() //
					.filter(r -> r.getType().equals(mergedReference.getType()) // same type
							&& r.getTarget().getName().equals(mergedReference.getTarget().getName())) // same target
					.findAny();
			if (referenceInNode.isPresent()) {
				try {
					Operator operator = getMergedOperator(referenceInNode.get().getOperator(),
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
	private Operator getMergedOperator(final Operator a, final Operator b) {
		if (a == Operator.CONTEXT || b == Operator.CONTEXT) {
			return Operator.CONTEXT;
		}
		if (a.equals(b)) {
			return a;
		}

		String message = String.format("Cannot merge operators %s and %s.", a, b);
		throw new IllegalArgumentException(message);
	}

	/**
	 * Returns the list of all transitive super rules.
	 * 
	 * @param rule
	 *            the rule
	 * @return all super rules of the rule
	 */
	private static Set<Rule> getAllSuperRules(final Rule rule) {
		Set<Rule> rules = new HashSet<Rule>();
		rules.addAll(rule.getSuperRules());
		rule.getSuperRules().forEach(r -> rules.addAll(getAllSuperRules(r)));
		return rules;
	}
}
