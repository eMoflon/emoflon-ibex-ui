package org.emoflon.ibex.gt.gtl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;

public final class GTLModelUtil {

	public static Collection<SlimRuleNode> getAllContextRuleNodes(SlimRule context) {
		Map<String, SlimRuleNode> nodes = new HashMap<>();
		getAllContextRuleNodes(context, nodes);
		return nodes.values();
	}

	public static Collection<SlimRuleNode> getAllRuleNodes(SlimRule context) {
		Map<String, SlimRuleNode> nodes = new HashMap<>();
		getAllRuleNodes(context, nodes);
		return nodes.values();
	}

	private static void getAllContextRuleNodes(SlimRule root, Map<String, SlimRuleNode> nodes) {
		root.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
				.forEach(cn -> nodes.put(cn.getName(), cn));
		root.getDeletedNodes().stream().map(cn -> cn.getDeletion()).forEach(dn -> nodes.put(dn.getName(), dn));

		if (root.getRefinement() != null && root.getRefinement().getSuperRule() != null
				&& root.getRefinement().getMappings() == null
				&& root.getRefinement().getMappings().getMappings().size() > 0) {
			root.getRefinement().getMappings().getMappings().forEach(mapping -> {
				nodes.remove(mapping.getTrgNode().getName());
				nodes.put(mapping.getTrgNode().getName(), (SlimRuleNode) mapping.getSrcNode());
			});
			getAllContextRuleNodes(root.getRefinement().getSuperRule(), nodes);
		}
	}

	private static void getAllRuleNodes(SlimRule root, Map<String, SlimRuleNode> nodes) {
		root.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
				.forEach(cn -> nodes.put(cn.getName(), cn));
		root.getDeletedNodes().stream().map(cn -> cn.getDeletion()).forEach(dn -> nodes.put(dn.getName(), dn));
		root.getCreatedNodes().stream().map(cn -> (SlimRuleNode) cn.getCreation())
				.forEach(crN -> nodes.put(crN.getName(), crN));

		if (root.getRefinement() != null && root.getRefinement().getSuperRule() != null
				&& root.getRefinement().getMappings() == null
				&& root.getRefinement().getMappings().getMappings().size() > 0) {
			root.getRefinement().getMappings().getMappings().forEach(mapping -> {
				nodes.remove(mapping.getTrgNode().getName());
				nodes.put(mapping.getTrgNode().getName(), (SlimRuleNode) mapping.getSrcNode());
			});
			getAllContextRuleNodes(root.getRefinement().getSuperRule(), nodes);
		}
	}

}
