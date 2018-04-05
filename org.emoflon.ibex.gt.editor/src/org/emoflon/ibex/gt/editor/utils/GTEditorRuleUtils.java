package org.emoflon.ibex.gt.editor.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.xtext.linking.lazy.LazyLinkingResource.CyclicLinkingException;
import org.emoflon.ibex.gt.editor.gT.EditorParameter;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
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
		Set<Rule> rules = new HashSet<Rule>();
		rules.add(rule);
		rules.addAll(getAllSuperRules(rule));
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
	public static Set<EditorNode> getAllNodesOfRule(final Rule rule, final Predicate<EditorNode> nodeFilter) {
		return getFilteredNodes(GTEditorRuleUtils.getRuleAllWithSuperRules(rule), nodeFilter);
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
	public static Set<EditorNode> getAllNodesFromSuperRules(final Rule rule, final Predicate<EditorNode> nodeFilter) {
		return getFilteredNodes(GTEditorRuleUtils.getAllSuperRules(rule), nodeFilter);
	}

	/**
	 * Returns the nodes of the rules.
	 * 
	 * @param rules
	 *            the rules
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes of the rules after applying the given filter
	 */
	private static Set<EditorNode> getFilteredNodes(final Set<Rule> rules, final Predicate<EditorNode> nodeFilter) {
		Set<EditorNode> nodes = new HashSet<EditorNode>();
		rules.forEach(rule -> nodes.addAll(rule.getNodes().stream().filter(nodeFilter).collect(Collectors.toSet())));
		return nodes;
	}

	/**
	 * Returns all parameters of the rule including parameters from super rules.
	 * 
	 * @param rule
	 *            the rule
	 * @return the parameters of the rule
	 */
	public static Set<EditorParameter> getAllParametersOfRule(final Rule rule) {
		Set<EditorParameter> parameters = new HashSet<EditorParameter>();
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
