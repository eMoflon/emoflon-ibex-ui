package org.emoflon.ibex.gt.gtl.util;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;

/**
 * Represents the complete refinement hierarchy of a rule node, where the rule
 * node is the root and the final super nodes are the leafs.
 * 
 * @param node            The root node of this hierarchy
 * @param finalSuper2Path Map between final super nodes and the path starting
 *                        from the root node
 * @param superNodes      All super nodes above the root node
 */
public record RuleNodeHierarchy(SlimRuleNode node, Map<SlimRuleNode, LinkedList<SlimRuleNode>> finalSuper2Path,
		Set<SlimRuleNode> superNodes) {

	public RuleNodeHierarchy(SlimRuleNode node) {
		this(node, new HashMap<>(), new LinkedHashSet<>());
	}

	@Override
	public int hashCode() {
		return node.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RuleNodeHierarchy other) {
			return node.equals(other.node);
		}
		return false;
	}
}
