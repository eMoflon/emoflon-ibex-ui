package org.emoflon.ibex.gt.gtl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
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
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes;
	}

	public static Collection<SlimRuleNode> getAllContextRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes.stream().filter(n -> n.eContainer() instanceof SlimRuleNodeContext).collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllCreatedRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes.stream().filter(n -> n.eContainer() instanceof SlimRuleNodeCreation).collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllDeletedRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes.stream().filter(n -> n.eContainer() instanceof GTLRuleNodeDeletion).collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllDeletedAndContextRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes.stream().filter(
				n -> n.eContainer() instanceof GTLRuleNodeDeletion || n.eContainer() instanceof SlimRuleNodeContext)
				.collect(Collectors.toSet());
	}

	public static Collection<SlimRuleNode> getAllCreatedAndContextRuleNodes(SlimRule context) {
		Set<SlimRuleNode> nodes = new HashSet<>();
		getAllRuleNodes(context, new HashMap<>(), new HashMap<>(), nodes);
		return nodes.stream().filter(
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

	public static void getAllRuleNodes(SlimRule root, Map<SlimRuleNode, SlimRuleNode> super2Node,
			Map<SlimRuleNode, SlimRuleNode> node2Super, Set<SlimRuleNode> nodes) {
		if (root.isRefining()) {
			// Add nodes with no explicit refinements to super2Node
			root.getContextNodes().stream().map(n -> (SlimRuleNode) n.getContext()).filter(n -> !ruleNodeIsRefining(n))
					.filter(n -> !super2Node.containsKey(n)).forEach(n -> {
						nodes.add(n);
					});
			root.getCreatedNodes().stream().map(n -> (SlimRuleNode) n.getCreation()).filter(n -> !ruleNodeIsRefining(n))
					.filter(n -> !super2Node.containsKey(n)).forEach(n -> {
						nodes.add(n);
					});
			root.getDeletedNodes().stream().map(n -> n.getDeletion()).filter(n -> !ruleNodeIsRefining(n))
					.filter(n -> !super2Node.containsKey(n)).forEach(n -> {
						nodes.add(n);
					});

			for (GTLRuleRefinement refinement : root.getRefinement()) {
				Optional<SlimRule> ruleOpt = refinementToRule(refinement);
				if (ruleOpt.isEmpty())
					continue;

				SlimRule superRule = ruleOpt.get();

				// Handle nodes that refine nodes of the current super rule
				root.getContextNodes().stream().map(n -> (SlimRuleNode) n.getContext())
						.filter(n -> ruleNodeIsRefining(n)).filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).forEach(n -> {
							SlimRuleNode superNode = GTLModelUtil.getRefinementNode(n).getRefinementNode();
							// If this node is a super node to a node below -> flatten hierarchy and don't
							// add to allNodes
							if (super2Node.containsKey(n)) {
								super2Node.replace(superNode, super2Node.get(n));
								node2Super.replace(super2Node.get(superNode), superNode);
							} else { // If this node is not a super node itself -> add relation to maps and to
										// allNodes
								super2Node.put(superNode, n);
								node2Super.put(n, superNode);
								nodes.add(n);
							}
						});

				// Handle nodes that refine nodes of the current super rule
				root.getCreatedNodes().stream().map(n -> (SlimRuleNode) n.getCreation())
						.filter(n -> ruleNodeIsRefining(n)).filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).forEach(n -> {
							SlimRuleNode superNode = GTLModelUtil.getRefinementNode(n).getRefinementNode();
							// If this node is a super node to a node below -> flatten hierarchy and don't
							// add to allNodes
							if (super2Node.containsKey(n)) {
								super2Node.replace(superNode, super2Node.get(n));
								node2Super.replace(super2Node.get(superNode), superNode);
							} else { // If this node is not a super node itself -> add relation to maps and to
										// allNodes
								super2Node.put(superNode, n);
								node2Super.put(n, superNode);
								nodes.add(n);
							}
						});

				// Handle nodes that refine nodes of the current super rule
				root.getDeletedNodes().stream().map(n -> n.getDeletion()).filter(n -> ruleNodeIsRefining(n))
						.filter(n -> {
							Optional<SlimRule> otherRule = refinementNodeToRule(
									GTLModelUtil.getRefinementNode(n).getSuperRule());
							if (otherRule.isPresent()) {
								return otherRule.get().equals(superRule);
							} else {
								return false;
							}
						}).forEach(n -> {
							SlimRuleNode superNode = GTLModelUtil.getRefinementNode(n).getRefinementNode();
							// If this node is a super node to a node below -> flatten hierarchy and don't
							// add to allNodes
							if (super2Node.containsKey(n)) {
								super2Node.replace(superNode, super2Node.get(n));
								node2Super.replace(super2Node.get(superNode), superNode);
							} else { // If this node is not a super node itself -> add relation to maps and to
										// allNodes
								super2Node.put(superNode, n);
								node2Super.put(n, superNode);
								nodes.add(n);
							}
						});

				getAllRuleNodes(superRule, super2Node, node2Super, nodes);
			}
		} else {
			// No refinements or root node of refinement hierarchy
			root.getContextNodes().stream().map(n -> n.getContext()).filter(n -> !super2Node.containsKey(n))
					.forEach(n -> {
						nodes.add((SlimRuleNode) n);
					});
			root.getCreatedNodes().stream().map(n -> n.getCreation()).filter(n -> !super2Node.containsKey(n))
					.forEach(n -> {
						nodes.add((SlimRuleNode) n);

					});
			root.getDeletedNodes().stream().map(n -> n.getDeletion()).filter(n -> !super2Node.containsKey(n))
					.forEach(n -> {
						nodes.add(n);
					});
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

}
