package org.emoflon.ibex.gt.editor.utils;

import java.util.HashSet;
import java.util.Set;

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
}
