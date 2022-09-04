package org.emoflon.ibex.gt.gtl.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;

public final class GTLModelUtil {

	public static Collection<SlimRuleNode> getAllContextRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllContextRuleNodes(context, nodes);
		return nodes;
	}

	public static Collection<SlimRuleNode> getAllRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, nodes);
		return nodes;
	}

	private static void getAllContextRuleNodes(SlimRule root, Collection<SlimRuleNode> nodes) {
		nodes.addAll(
				root.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext()).collect(Collectors.toSet()));
		nodes.addAll(root.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));

		if (root.getRefinement() != null && root.getRefinement().getSuperRule() != null
				&& root.getRefinement().getMappings() == null
				&& root.getRefinement().getMappings().getMappings().size() > 0) {
			root.getRefinement().getMappings().getMappings().forEach(mapping -> {
				nodes.remove(mapping.getTrgNode());
				nodes.add((SlimRuleNode) mapping.getSrcNode());
			});
			getAllContextRuleNodes(root.getRefinement().getSuperRule(), nodes);
		}
	}

	private static void getAllRuleNodes(SlimRule root, Collection<SlimRuleNode> nodes) {
		nodes.addAll(
				root.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext()).collect(Collectors.toSet()));
		nodes.addAll(root.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));
		nodes.addAll(
				root.getCreatedNodes().stream().map(cn -> (SlimRuleNode) cn.getCreation()).collect(Collectors.toSet()));

		if (root.getRefinement() != null && root.getRefinement().getSuperRule() != null
				&& root.getRefinement().getMappings() == null
				&& root.getRefinement().getMappings().getMappings().size() > 0) {
			root.getRefinement().getMappings().getMappings().forEach(mapping -> {
				nodes.remove(mapping.getTrgNode());
				nodes.add((SlimRuleNode) mapping.getSrcNode());
			});
			getAllContextRuleNodes(root.getRefinement().getSuperRule(), nodes);
		}
	}

}
