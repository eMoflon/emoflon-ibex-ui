package org.emoflon.ibex.gt.gtl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementAliased;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementPlain;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinmentNode;
import org.emoflon.ibex.gt.gtl.gTL.SlimParameter;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;

public final class GTLModelUtil {

	public static Collection<SlimRuleNode> getAllRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet();
	}

	public static Collection<SlimRuleNode> getAllContextRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet().stream().filter(n -> n.eContainer() instanceof SlimRuleNodeContext)
				.collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllCreatedRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet().stream().filter(n -> n.eContainer() instanceof SlimRuleNodeCreation)
				.collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllDeletedRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet().stream().filter(n -> n.eContainer() instanceof GTLRuleNodeDeletion)
				.collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllDeletedAndContextRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet().stream().filter(
				n -> n.eContainer() instanceof GTLRuleNodeDeletion || n.eContainer() instanceof SlimRuleNodeContext)
				.collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllCreatedAndContextRuleNodes(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes.keySet().stream().filter(
				n -> n.eContainer() instanceof SlimRuleNodeCreation || n.eContainer() instanceof SlimRuleNodeContext)
				.collect(Collectors.toSet());
	}

	public static Optional<SlimRule> refinementToRule(final GTLRuleRefinement refinement) {
		SlimRule rule = null;
		if (refinement instanceof GTLRuleRefinementPlain plainRefinement) {
			rule = plainRefinement.getSuperRule();
		} else if (refinement instanceof GTLRuleRefinementAliased aliasedRefinement) {
			rule = aliasedRefinement.getSuperRule();
		} else {
			return Optional.empty();
		}

		return Optional.of(rule);
	}

	public static Optional<SlimRule> refinementNodeToRule(final EObject refinement) {
		SlimRule rule = null;
		if (refinement instanceof SlimRule plainRefinement) {
			rule = plainRefinement;
		} else if (refinement instanceof GTLRuleRefinementAliased aliasedRefinement) {
			rule = aliasedRefinement.getSuperRule();
		} else {
			return Optional.empty();
		}

		return Optional.of(rule);
	}

	public static boolean ruleNodeIsRefining(final SlimRuleNode ruleNode) {
		if (ruleNode.eContainer() instanceof org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext context) {
			return context.isRefining();
		} else if (ruleNode.eContainer() instanceof org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation creation) {
			return creation.isRefining();
		} else if (ruleNode.eContainer() instanceof GTLRuleNodeDeletion deletion) {
			return deletion.isRefining();
		} else {
			return false;
		}
	}

	public static GTLRuleRefinmentNode getRefinementNode(final SlimRuleNode ruleNode) {
		if (ruleNode.eContainer() instanceof org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext context) {
			return context.getRefinement();
		} else if (ruleNode.eContainer() instanceof org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation creation) {
			return creation.getRefinement();
		} else if (ruleNode.eContainer() instanceof GTLRuleNodeDeletion deletion) {
			return deletion.getRefinement();
		} else {
			return null;
		}
	}

	public static void getAllRuleNodes(SlimRule root, Map<SlimRuleNode, RuleNodeHierarchy> super2Node,
			Map<SlimRuleNode, RuleNodeHierarchy> nodes) {
		if (root.isRefining()) {
			// Add nodes with no explicit refinements to node
			List<SlimRuleNode> unrefinedNodes = root.getContextNodes().stream().map(n -> (SlimRuleNode) n.getContext())
					.filter(n -> !ruleNodeIsRefining(n)).filter(n -> !super2Node.containsKey(n))
					.collect(Collectors.toList());
			unrefinedNodes.addAll(root.getCreatedNodes().stream().map(n -> (SlimRuleNode) n.getCreation())
					.filter(n -> !ruleNodeIsRefining(n)).filter(n -> !super2Node.containsKey(n))
					.collect(Collectors.toList()));
			unrefinedNodes.addAll(
					root.getDeletedNodes().stream().map(n -> n.getDeletion()).filter(n -> !ruleNodeIsRefining(n))
							.filter(n -> !super2Node.containsKey(n)).collect(Collectors.toList()));
			unrefinedNodes.forEach(n -> nodes.put(n, new RuleNodeHierarchy(n)));

			for (GTLRuleRefinement refinement : root.getRefinement()) {
				Optional<SlimRule> ruleOpt = refinementToRule(refinement);
				if (ruleOpt.isEmpty())
					continue;

				SlimRule superRule = ruleOpt.get();

				// Handle nodes that refine nodes of the current super rule
				List<SlimRuleNode> refinedNodes = root.getContextNodes().stream()
						.map(n -> (SlimRuleNode) n.getContext()).filter(n -> ruleNodeIsRefining(n)).filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).collect(Collectors.toList());
				refinedNodes.addAll(root.getCreatedNodes().stream().map(n -> (SlimRuleNode) n.getCreation())
						.filter(n -> ruleNodeIsRefining(n)).filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).collect(Collectors.toList()));
				refinedNodes.addAll(root.getDeletedNodes().stream().map(n -> n.getDeletion())
						.filter(n -> ruleNodeIsRefining(n)).filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).collect(Collectors.toList()));

				refinedNodes.forEach(n -> {
					SlimRuleNode superNode = GTLModelUtil.getRefinementNode(n).getRefinementNode();
					// If this node is a super node to a node below -> flatten hierarchy and don't
					// add to allNodes
					if (super2Node.containsKey(n)) {
						// Update the nodes hierarchy model
						RuleNodeHierarchy subNode = super2Node.get(n);
						subNode.superNodes().add(superNode);
						LinkedList<SlimRuleNode> path = subNode.finalSuper2Path().get(n);
						path.add(superNode);
						subNode.finalSuper2Path().put(superNode, path);
						subNode.finalSuper2Path().remove(n);

						// Update and flatten crawled hierarchy
						super2Node.put(superNode, subNode);
						super2Node.remove(n);
					} else { // If this node is not a super node itself -> add relation to maps and to
								// allNodes
						RuleNodeHierarchy subNode = new RuleNodeHierarchy(n);
						LinkedList<SlimRuleNode> path = new LinkedList<>();
						path.add(n);
						path.add(superNode);
						subNode.finalSuper2Path().put(superNode, path);
						subNode.superNodes().add(superNode);

						super2Node.put(superNode, subNode);
						nodes.put(n, subNode);
					}
				});

				getAllRuleNodes(superRule, super2Node, nodes);
			}
		} else {
			// No refinements or root node of refinement hierarchy
			List<SlimRuleNode> rootNodes = root.getContextNodes().stream().map(n -> n.getContext())
					.filter(n -> !super2Node.containsKey(n)).map(n -> (SlimRuleNode) n).collect(Collectors.toList());
			rootNodes.addAll(root.getCreatedNodes().stream().map(n -> n.getCreation())
					.filter(n -> !super2Node.containsKey(n)).map(n -> (SlimRuleNode) n).collect(Collectors.toList()));
			rootNodes.addAll(root.getDeletedNodes().stream().map(n -> n.getDeletion())
					.filter(n -> !super2Node.containsKey(n)).collect(Collectors.toList()));
			rootNodes.forEach(n -> nodes.put(n, new RuleNodeHierarchy(n)));
		}
	}

	public static Collection<SlimParameter> getAllParameters(SlimRule context) {
		List<SlimParameter> params = new LinkedList<>();
		getAllParameters(context, params);
		return params;
	}

	public static void getAllParameters(SlimRule root, Collection<SlimParameter> params) {
		if (root.getParameters() != null)
			params.addAll(root.getParameters());

		if (root.isRefining()) {
			for (GTLRuleRefinement refinement : root.getRefinement()) {
				Optional<SlimRule> ruleOpt = refinementToRule(refinement);
				if (ruleOpt.isEmpty())
					continue;

				SlimRule superRule = ruleOpt.get();
				getAllParameters(superRule, params);
			}
		}
	}

	public static Collection<SlimRule> getAllSuperRules(SlimRule context) {
		List<SlimRule> rules = new LinkedList<>();
		getAllSuperRules(context, rules);
		return rules;
	}

	public static void getAllSuperRules(SlimRule root, List<SlimRule> rules) {
		if (root.isRefining()) {
			for (GTLRuleRefinement refinement : root.getRefinement()) {
				Optional<SlimRule> ruleOpt = refinementToRule(refinement);
				if (ruleOpt.isEmpty())
					continue;

				SlimRule superRule = ruleOpt.get();
				rules.add(superRule);
				getAllSuperRules(superRule, rules);
			}
		}
	}

	public static Map<SlimRuleNode, RuleNodeHierarchy> getAllRuleNodeHierarchy(SlimRule context) {
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(context, new HashMap<>(), nodes);
		return nodes;
	}

	public static Collection<SlimRuleNode> getRuleNodeAllSuperNodes(SlimRuleNode context) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		Map<SlimRuleNode, RuleNodeHierarchy> nodes = new LinkedHashMap<>();
		getAllRuleNodes(currentRule, new HashMap<>(), nodes);

		if (nodes.containsKey(context)) {
			return nodes.get(context).superNodes();
		} else {
			return new HashSet<>();
		}
	}

	public static Collection<SlimRuleNode> getRuleNodeAllSuperNodes(SlimRuleNode context,
			Map<SlimRuleNode, RuleNodeHierarchy> ruleNodeHierarchy) {
		if (ruleNodeHierarchy.containsKey(context)) {
			return ruleNodeHierarchy.get(context).superNodes();
		} else {
			return new HashSet<>();
		}
	}

	public static Collection<SlimRuleEdge> getRuleNodeAllEdges(SlimRuleNode context) {
		List<SlimRuleEdge> edges = new LinkedList<>();
		List<SlimRuleNode> nodes = List.of(context);
		nodes.addAll(getRuleNodeAllSuperNodes(context));
		for (SlimRuleNode node : nodes) {
			node.getContextEdges().stream().map(e -> e.getContext()).forEach(e -> edges.add(e));
			node.getCreatedEdges().stream().map(e -> e.getCreation()).forEach(e -> edges.add(e));
			node.getDeletedEdges().stream().map(e -> e.getDeletion()).forEach(e -> edges.add(e));
		}
		return edges;
	}

	public static Collection<SlimRuleEdge> getRuleNodeAllEdges(SlimRuleNode context,
			Map<SlimRuleNode, RuleNodeHierarchy> ruleNodeHierarchy) {
		List<SlimRuleEdge> edges = new LinkedList<>();
		List<SlimRuleNode> nodes = List.of(context);
		nodes.addAll(getRuleNodeAllSuperNodes(context, ruleNodeHierarchy));
		for (SlimRuleNode node : nodes) {
			node.getContextEdges().stream().map(e -> e.getContext()).forEach(e -> edges.add(e));
			node.getCreatedEdges().stream().map(e -> e.getCreation()).forEach(e -> edges.add(e));
			node.getDeletedEdges().stream().map(e -> e.getDeletion()).forEach(e -> edges.add(e));
		}
		return edges;
	}

}