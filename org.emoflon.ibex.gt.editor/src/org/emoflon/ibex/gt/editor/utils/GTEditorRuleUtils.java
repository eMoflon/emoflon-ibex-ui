package org.emoflon.ibex.gt.editor.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.xtext.linking.lazy.LazyLinkingResource.CyclicLinkingException;
import org.emoflon.ibex.gt.editor.gT.Node;
import org.emoflon.ibex.gt.editor.gT.Parameter;
import org.emoflon.ibex.gt.editor.gT.Rule;

/**
 * Utility methods for {@link Rule}s.
 */
public class GTEditorRuleUtils {

	/**
	 * Returns all transitive super rules of the given rule.
	 * 
	 * @param rule
	 *            the rule
	 * @return all super rules of the rule
	 */
	public static Set<Rule> getAllSuperRules(final Rule rule) {
		Set<Rule> rules = new HashSet<Rule>();
		rules.addAll(rule.getSuperRules());
		rule.getSuperRules().forEach(r -> rules.addAll(getAllSuperRules(r)));
		return rules;
	}

	/**
	 * Returns a set containing the rule and all its super rules.
	 * 
	 * @param rule
	 *            the rule
	 * @return the rule and all its super rules
	 */
	public static Set<Rule> getRuleAllWithSuperRules(final Rule rule) {
		Set<Rule> rules = getAllSuperRules(rule);
		rules.add(rule);
		return rules;
	}

	/**
	 * Returns all nodes which are valid in a rule (i. e. from the rule itself as
	 * well as from super rules).
	 * 
	 * @param rule
	 *            the rule
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes of the rule and its super rules after applying the filter
	 */
	public static Set<Node> getAllNodesOfRule(final Rule rule, final Predicate<Node> nodeFilter) {
		Set<Node> nodes = new HashSet<Node>();
		GTEditorRuleUtils.getRuleAllWithSuperRules(rule).forEach(r -> nodes.addAll(filterNodes(r, nodeFilter)));
		return nodes;
	}

	/**
	 * Returns all nodes which the inherited from super rules.
	 * 
	 * @param rule
	 *            the rule
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes from the super rules of the rule after applying the filter
	 */
	public static Set<Node> getAllNodesFromSuperRules(final Rule rule, final Predicate<Node> nodeFilter) {
		Set<Node> nodes = new HashSet<Node>();
		GTEditorRuleUtils.getAllSuperRules(rule).forEach(r -> nodes.addAll(filterNodes(r, nodeFilter)));
		return nodes;
	}

	/**
	 * Returns the nodes of the rule.
	 * 
	 * @param rule
	 *            the rule
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes of the rule after applying the given filter
	 */
	private static Set<Node> filterNodes(final Rule rule, final Predicate<Node> nodeFilter) {
		return rule.getNodes().stream().filter(nodeFilter).collect(Collectors.toSet());
	}

	/**
	 * Returns all parameters of the rule including parameters from super rules.
	 * 
	 * @param rule
	 *            the rule
	 * @return the parameters of the rule
	 */
	public static Set<Parameter> getAllParametersOfRule(final Rule rule) {
		Set<Parameter> parameters = new HashSet<Parameter>();
		GTEditorRuleUtils.getRuleAllWithSuperRules(rule).forEach(r -> {
			parameters.addAll(r.getParameters());
		});
		return parameters;
	}

	/**
	 * Checks whether the first rule is an refinement of the second.
	 * 
	 * @param a
	 *            the first rule
	 * @param b
	 *            the second rule
	 * @return true if a directly or indirectly refines b
	 */
	public static boolean isRefinementOf(Rule a, Rule b) {
		try {
			if (a.getSuperRules().contains(b)) {
				return true;
			}
		} catch (CyclicLinkingException e) {
			// Cycling linking detected: a refines b and b refines a.
			return true;
		}
		for (Rule superRule : a.getSuperRules()) {
			if (isRefinementOf(superRule, b)) {
				return true;
			}
		}
		return false;
	}
}