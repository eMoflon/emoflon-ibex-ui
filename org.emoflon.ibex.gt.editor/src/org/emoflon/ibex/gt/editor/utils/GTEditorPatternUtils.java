package org.emoflon.ibex.gt.editor.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.xtext.linking.lazy.LazyLinkingResource.CyclicLinkingException;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorParameter;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;

/**
 * Utility methods for editor patterns.
 */
public class GTEditorPatternUtils {

	/**
	 * Returns all transitive super patterns of the given pattern.
	 * 
	 * @param pattern
	 *            the pattern
	 * @return all super patterns of the patterns
	 */
	public static Set<EditorPattern> getAllSuperPatterns(final EditorPattern pattern) {
		Set<EditorPattern> patterns = new HashSet<EditorPattern>();
		patterns.addAll(pattern.getSuperPatterns());
		pattern.getSuperPatterns().forEach(p -> patterns.addAll(getAllSuperPatterns(p)));
		return patterns;
	}

	/**
	 * Returns a set containing the patterns and all its super patterns.
	 * 
	 * @param pattern
	 *            the pattern
	 * @return the pattern and all its super pattern
	 */
	public static Set<EditorPattern> getPatternWithAllSuperPatterns(final EditorPattern pattern) {
		Set<EditorPattern> patterns = new HashSet<EditorPattern>();
		patterns.add(pattern);
		patterns.addAll(getAllSuperPatterns(pattern));
		return patterns;
	}

	/**
	 * Returns all nodes which are valid in a pattern (i. e. from the pattern itself
	 * as well as from its super patterns).
	 * 
	 * @param pattern
	 *            the pattern
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes of the pattern and its super pattern after applying the
	 *         filter
	 */
	public static Set<EditorNode> getAllNodesOfPattern(final EditorPattern pattern,
			final Predicate<EditorNode> nodeFilter) {
		return getFilteredNodes(getPatternWithAllSuperPatterns(pattern), nodeFilter);
	}

	/**
	 * Returns all nodes which the inherited from super patterns.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes from the super patterns of the pattern after applying the
	 *         filter
	 */
	public static Set<EditorNode> getAllNodesFromSuperPatterns(final EditorPattern pattern,
			final Predicate<EditorNode> nodeFilter) {
		return getFilteredNodes(getAllSuperPatterns(pattern), nodeFilter);
	}

	/**
	 * Returns the nodes of the patterns.
	 * 
	 * @param patterns
	 *            the patterns
	 * @param nodeFilter
	 *            a filter for the nodes
	 * @return the nodes of the patterns after applying the given filter
	 */
	private static Set<EditorNode> getFilteredNodes(final Set<EditorPattern> patterns,
			final Predicate<EditorNode> nodeFilter) {
		Set<EditorNode> nodes = new HashSet<EditorNode>();
		patterns.forEach(p -> nodes.addAll(p.getNodes().stream().filter(nodeFilter).collect(Collectors.toSet())));
		return nodes;
	}

	/**
	 * Returns all parameters of the pattern including parameters from super
	 * patterns.
	 * 
	 * @param pattern
	 *            the pattern
	 * @return the parameters of the pattern
	 */
	public static Set<EditorParameter> getAllParametersOfPattern(final EditorPattern pattern) {
		Set<EditorParameter> parameters = new HashSet<EditorParameter>();
		getPatternWithAllSuperPatterns(pattern).forEach(p -> parameters.addAll(p.getParameters()));
		return parameters;
	}

	/**
	 * Checks whether the first pattern is an refinement of the second.
	 * 
	 * @param a
	 *            the first pattern
	 * @param b
	 *            the second pattern
	 * @return true if a directly or indirectly refines b
	 */
	public static boolean isRefinementOf(EditorPattern a, EditorPattern b) {
		try {
			if (a.getSuperPatterns().contains(b)) {
				return true;
			}
		} catch (CyclicLinkingException e) {
			// Cycling linking detected: a refines b and b refines a.
			return true;
		}
		for (EditorPattern superPattern : a.getSuperPatterns()) {
			if (isRefinementOf(superPattern, b)) {
				return true;
			}
		}
		return false;
	}
}
