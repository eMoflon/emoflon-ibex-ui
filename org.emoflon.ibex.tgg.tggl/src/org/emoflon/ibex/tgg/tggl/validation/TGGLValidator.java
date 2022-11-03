/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.tggl.validation;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.validation.Check;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeContext;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.validation.SlimGTValidatorUtil;
import org.emoflon.ibex.tgg.tggl.tGGL.EditorFile;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRule;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNode;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRuleNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeContext;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNodeCreation;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGDomainRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLPackage;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinement;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRuleRefinementNode;
import org.emoflon.ibex.tgg.tggl.util.TGGLWorkspaceUtil;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * This class contains custom validation rules.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class TGGLValidator extends AbstractTGGLValidator {

	@Check
	public void checkRuleNameForbidden(TGGRule rule) {
		if (rule.getName() == null)
			return;

		if (SlimGTValidatorUtil.RULE_NAME_BACKLIST.contains(rule.getName())) {
			error(String.format("Rule '%s' is a java keyword or an emf class and, hence, forbidden.", rule.getName()),
					TGGLPackage.Literals.TGG_RULE__NAME);
		}
	}

	@Check
	public void checkPatternNameForbidden(SlimRule pattern) {
		if (pattern.getName() == null)
			return;

		if (SlimGTValidatorUtil.RULE_NAME_BACKLIST.contains(pattern.getName())) {
			error(String.format("Pattern '%s' is a java keyword or an emf class and, hence, forbidden.", pattern.getName()),
					TGGLPackage.Literals.SLIM_RULE__NAME);
		}
	}

	@Check
	public void checkNodeNameForbidden(SlimRuleNode node) {
		if (node.getName() == null)
			return;

		if (SlimGTValidatorUtil.NODE_NAME_BACKLIST.contains(node.getName())) {
			error(String.format("Node '%s' is a java keyword or an emf class and, hence, forbidden.", node.getName()),
					SlimGTPackage.Literals.SLIM_RULE_NODE__NAME);
		}
	}

	@Check
	public void checkCorrNodeNameForbidden(TGGCorrespondenceNode corrNode) {
		if (corrNode.getName() == null)
			return;

		if (SlimGTValidatorUtil.NODE_NAME_BACKLIST.contains(corrNode.getName())) {
			error(String.format("Node '%s' is a java keyword or an emf class and, hence, forbidden.", corrNode.getName()),
					TGGLPackage.Literals.TGG_CORRESPONDENCE_NODE__NAME);
		}
	}

	@Check
	public void checkPatternContextEdgeOnly(SlimRuleNodeContext contextNode) {
		if (SlimGTModelUtil.getContainer(contextNode, SlimRule.class) == null)
			return;

		SlimRuleNode node = (SlimRuleNode) contextNode.getContext();
		if (node == null)
			return;

		for (int i = 0; i < node.getCreatedEdges().size(); i++) {
			error("Edges of binding type 'create' are forbidden in patterns.", node, SlimGTPackage.Literals.SLIM_RULE_NODE__CREATED_EDGES, i,
					IssueCodes.INCORRECT_BINDING_EDGE_CREATE);
		}
	}

	@Check
	public void checkContextEdgeWithCreateSrcForbidden(SlimRuleNodeCreation createNode) {
		SlimRuleNode node = (SlimRuleNode) createNode.getCreation();
		if (node == null)
			return;

		for (int i = 0; i < node.getContextEdges().size(); i++) {
			// FIXME wrong error highlighting
			error(String.format("Node '%s' of binding type 'create' cannot be connected via an edge of binding type 'context'.", node.getName()),
					node, SlimGTPackage.Literals.SLIM_RULE_NODE__CREATED_EDGES, i, IssueCodes.INCORRECT_BINDING_EDGE_CONTEXT);
		}
	}

	@Check
	public void checkContextEdgeWithCreateTrgForbidden(SlimRuleEdgeContext contextEdge) {
		SlimRuleEdge edge = contextEdge.getContext();
		if (edge == null)
			return;

		SlimRuleNode targetNode = (SlimRuleNode) edge.getTarget();
		if (targetNode == null)
			return;

		if (SlimGTModelUtil.getContainer(targetNode, SlimRuleNodeCreation.class) != null) {
			error("An edge of binding type 'context' cannot point to a node of binding type 'create'.", edge,
					SlimGTPackage.Literals.SLIM_RULE_EDGE__TARGET);
		}
	}

	@Check
	public void checkUniqueNodesNames(TGGRule rule) {
		Map<String, List<EObject>> name2nodes = new HashMap<>();
		fillNodeNameMap(rule, name2nodes);

		for (Entry<String, List<EObject>> entry : name2nodes.entrySet()) {
			if (entry.getValue().size() <= 1)
				continue;

			for (EObject duplNode : entry.getValue()) {
				error(String.format("A node with name '%s' does already exist in this rule.", entry.getKey()), duplNode,
						SlimGTPackage.Literals.SLIM_RULE_NODE__NAME);
			}
		}

		Map<String, List<EObject>> name2nodesRefined = new HashMap<>();

		for (TGGLRuleRefinement refinement : rule.getRefinements()) {
			TGGRule superRule = refinement.getSuperRule();
			if (superRule == null)
				continue;

			fillNodeNameMap(superRule, name2nodesRefined);
		}

		SetView<String> duplicates = Sets.intersection(name2nodes.keySet(), name2nodesRefined.keySet());
		for (String duplNodeName : duplicates) {
			List<EObject> duplRuleNodes = name2nodes.get(duplNodeName);
			for (EObject duplRuleNode : duplRuleNodes) {
				String refinementNodeName = extractRefinementNodeName(duplRuleNode.eContainer());
				if (duplNodeName.equals(refinementNodeName))
					continue;

				List<String> issueData = new LinkedList<>();
				issueData.add(duplNodeName);
				for (EObject refinedRuleNode : name2nodesRefined.get(duplNodeName)) {
					TGGRule refinedRule = SlimGTModelUtil.getContainer(refinedRuleNode, TGGRule.class);
					if (refinedRule == null)
						continue;
					issueData.add(refinedRule.getName());
				}
				error(String.format("A node with name '%s' does already exist in a refined rule.", duplNodeName), duplRuleNode,
						SlimGTPackage.Literals.SLIM_RULE_NODE__NAME, IssueCodes.MISSING_NODE_REFINEMENT, issueData.toArray(new String[] {}));
			}
		}
	}

	private String extractRefinementNodeName(EObject nodeContainer) {
		if (nodeContainer instanceof SlimRuleNodeContext duplRuleNodeCon) {
			TGGRuleRefinementNode refinement = duplRuleNodeCon.getRefinement();
			if (refinement != null)
				return refinement.getNode().getName();
		} else if (nodeContainer instanceof SlimRuleNodeCreation duplRuleNodeCre) {
			TGGRuleRefinementNode refinement = duplRuleNodeCre.getRefinement();
			if (refinement != null)
				return refinement.getNode().getName();
		} else if (nodeContainer instanceof TGGCorrespondenceNodeContext duplRuleCorrCon) {
			TGGLRuleRefinementCorrespondenceNode refinement = duplRuleCorrCon.getRefinement();
			if (refinement != null)
				return refinement.getNode().getName();
		} else if (nodeContainer instanceof TGGCorrespondenceNodeCreation duplRuleCorrCre) {
			TGGLRuleRefinementCorrespondenceNode refinement = duplRuleCorrCre.getRefinement();
			if (refinement != null)
				return refinement.getNode().getName();
		}
		return null;
	}

	private void fillNodeNameMap(TGGRule rule, Map<String, List<EObject>> name2nodes) {
		TGGDomainRule srcDomain = rule.getSourceRule();
		if (srcDomain != null)
			fillNodeNameMap(srcDomain, name2nodes);

		TGGDomainRule trgDomain = rule.getTargetRule();
		if (trgDomain != null)
			fillNodeNameMap(trgDomain, name2nodes);

		TGGCorrRule corrDomain = rule.getCorrRule();
		if (corrDomain != null)
			fillNodeNameMapCorr(corrDomain, name2nodes);
	}

	private void fillNodeNameMap(TGGDomainRule domain, Map<String, List<EObject>> name2nodes) {
		for (SlimRuleNodeContext contextNode : domain.getContextNodes()) {
			SlimRuleNode node = (SlimRuleNode) contextNode.getContext();
			if (node == null)
				continue;
			name2nodes.computeIfAbsent(node.getName(), k -> new LinkedList<>()).add(node);
		}
		for (SlimRuleNodeCreation createNode : domain.getCreatedNodes()) {
			SlimRuleNode node = (SlimRuleNode) createNode.getCreation();
			if (node == null)
				continue;
			name2nodes.computeIfAbsent(node.getName(), k -> new LinkedList<>()).add(node);
		}
	}

	private void fillNodeNameMapCorr(TGGCorrRule domain, Map<String, List<EObject>> name2nodes) {
		for (TGGCorrespondenceNodeContext contextCorr : domain.getContextCorrespondenceNodes()) {
			TGGCorrespondenceNode node = contextCorr.getContext();
			if (node == null)
				continue;
			name2nodes.computeIfAbsent(node.getName(), k -> new LinkedList<>()).add(node);
		}
		for (TGGCorrespondenceNodeCreation createCorr : domain.getCreatedCorrespondenceNodes()) {
			TGGCorrespondenceNode node = createCorr.getCreation();
			if (node == null)
				continue;
			name2nodes.computeIfAbsent(node.getName(), k -> new LinkedList<>()).add(node);
		}
	}

	@Check
	public void checkRefinedNodeBindingMatches(SlimRuleNodeContext contextNode) {
		TGGRuleRefinementNode refinement = contextNode.getRefinement();
		if (refinement == null)
			return;

		SlimRuleNode refinedNode = refinement.getNode();
		if (refinedNode == null)
			return;

		if (refinedNode.eContainer() instanceof SlimRuleNodeContext)
			return;

		TGGDomainRule domainRule = SlimGTModelUtil.getContainer(contextNode, TGGDomainRule.class);
		error("The refining node must be of the same binding type as the refined node.", domainRule,
				TGGLPackage.Literals.TGG_DOMAIN_RULE__CONTEXT_NODES, IssueCodes.INCORRECT_BINDING_NODE_REFINED_CONTEXT);
	}

	@Check
	public void checkRefinedNodeBindingMatches(SlimRuleNodeCreation createNode) {
		TGGRuleRefinementNode refinement = createNode.getRefinement();
		if (refinement == null)
			return;

		SlimRuleNode refinedNode = refinement.getNode();
		if (refinedNode == null)
			return;

		if (refinedNode.eContainer() instanceof SlimRuleNodeCreation)
			return;

		TGGDomainRule domainRule = SlimGTModelUtil.getContainer(createNode, TGGDomainRule.class);
		error("The refining node must be of the same binding type as the refined node.", domainRule,
				TGGLPackage.Literals.TGG_DOMAIN_RULE__CREATED_NODES, IssueCodes.INCORRECT_BINDING_NODE_REFINED_CREATE);
	}

	@Check
	public void checkRefinedNodeBindingMatches(TGGCorrespondenceNodeContext contextNode) {
		TGGLRuleRefinementCorrespondenceNode refinement = contextNode.getRefinement();
		if (refinement == null)
			return;

		TGGCorrespondenceNode refinedNode = refinement.getNode();
		if (refinedNode == null)
			return;

		if (refinedNode.eContainer() instanceof TGGCorrespondenceNodeContext)
			return;

		TGGCorrRule corrRule = SlimGTModelUtil.getContainer(contextNode, TGGCorrRule.class);
		error("The refining node must be of the same binding type as the refined node.", corrRule,
				TGGLPackage.Literals.TGG_CORR_RULE__CONTEXT_CORRESPONDENCE_NODES, IssueCodes.INCORRECT_BINDING_NODE_REFINED_CONTEXT);
	}

	@Check
	public void checkRefinedNodeBindingMatches(TGGCorrespondenceNodeCreation createNode) {
		TGGLRuleRefinementCorrespondenceNode refinement = createNode.getRefinement();
		if (refinement == null)
			return;

		TGGCorrespondenceNode refinedNode = refinement.getNode();
		if (refinedNode == null)
			return;

		if (refinedNode.eContainer() instanceof TGGCorrespondenceNodeCreation)
			return;

		TGGCorrRule corrRule = SlimGTModelUtil.getContainer(createNode, TGGCorrRule.class);
		error("The refining node must be of the same binding type as the refined node.", corrRule,
				TGGLPackage.Literals.TGG_CORR_RULE__CREATED_CORRESPONDENCE_NODES, IssueCodes.INCORRECT_BINDING_NODE_REFINED_CREATE);
	}

	@Check
	public void checkOnlyOneSingleEdge(SlimRuleNode node) {
		List<SlimRuleEdge> singleEdges = new LinkedList<>();

		singleEdges.addAll(node.getContextEdges().stream() //
				.filter(e -> e.getContext() != null) //
				.map(e -> e.getContext()) //
				.filter(e -> !e.getType().isMany()) //
				.toList());

		singleEdges.addAll(node.getCreatedEdges().stream() //
				.filter(e -> e.getCreation() != null) //
				.map(e -> e.getCreation()) //
				.filter(e -> !e.getType().isMany()) //
				.toList());

		Map<EReference, List<SlimRuleEdge>> ref2singleEdge = new HashMap<>();
		for (SlimRuleEdge singleEdge : singleEdges)
			ref2singleEdge.computeIfAbsent(singleEdge.getType(), k -> new LinkedList<>()).add(singleEdge);

		for (Entry<EReference, List<SlimRuleEdge>> entry : ref2singleEdge.entrySet()) {
			if (entry.getValue().size() > 1) {
				for (SlimRuleEdge edge : entry.getValue()) {
					error(String.format("Edge '%s' has a max. cardinality of 1 and, hence, cannot be set more than once.", entry.getKey().getName()),
							edge, SlimGTPackage.Literals.SLIM_RULE_EDGE__TYPE);
				}
			}
		}
	}

	@Check
	public void checkOnlyOneEdgeOfTypeBetweenTwoNodes(SlimRuleNode node) {
		List<SlimRuleEdge> edges = new LinkedList<>();

		edges.addAll(node.getContextEdges().stream() //
				.filter(e -> e.getContext() != null) //
				.map(e -> e.getContext()) //
				.filter(e -> e.getType().isMany()) //
				.toList());

		edges.addAll(node.getCreatedEdges().stream() //
				.filter(e -> e.getCreation() != null) //
				.map(e -> e.getCreation()) //
				.filter(e -> e.getType().isMany()) //
				.toList());

		Map<EReference, List<SlimRuleEdge>> ref2edge = new HashMap<>();
		for (SlimRuleEdge edge : edges)
			ref2edge.computeIfAbsent(edge.getType(), k -> new LinkedList<>()).add(edge);

		for (Entry<EReference, List<SlimRuleEdge>> entry : ref2edge.entrySet()) {
			if (entry.getValue().size() <= 1)
				continue;

			Map<SlimRuleNode, List<SlimRuleEdge>> target2edge = new HashMap<>();
			for (SlimRuleEdge edge : entry.getValue())
				target2edge.computeIfAbsent((SlimRuleNode) edge.getTarget(), k -> new LinkedList<>()).add(edge);

			for (Entry<SlimRuleNode, List<SlimRuleEdge>> e : target2edge.entrySet()) {
				if (e.getValue().size() > 1) {
					for (SlimRuleEdge edge : e.getValue()) {
						error(String.format("Edge '%s' is connected to the same node more than once.", edge.getType().getName()), edge,
								SlimGTPackage.Literals.SLIM_RULE_EDGE__TYPE);
					}
				}
			}
		}
	}

	@Check
	public void checkDoubleImportsForbidden(EditorFile editorFile) {
		EList<Import> imports = editorFile.getImports();

		if (imports == null || imports.size() <= 1)
			return;

		Map<String, List<Import>> name2imports = new HashMap<>();
		for (Import imp : imports)
			name2imports.computeIfAbsent(imp.getName(), k -> new LinkedList<>()).add(imp);

		for (Entry<String, List<Import>> entry : name2imports.entrySet()) {
			if (entry.getValue().size() <= 1)
				continue;

			for (Import imp : entry.getValue())
				error(String.format("Ecore file '%s' must not be imported more than once.", imp.getName()), imp, SlimGTPackage.Literals.IMPORT__NAME);
		}
	}

	@Check
	public void checkImportsOnlyInSchemaFile(EditorFile editorFile) {
		if (editorFile.getSchema() != null)
			return;

		for (int i = 0; i < editorFile.getImports().size(); i++) {
			error("Imports must only be located in schema file.", editorFile, SlimGTPackage.Literals.EDITOR_FILE__IMPORTS, i,
					IssueCodes.IMPORT_NOT_IN_SCHEMA_FILE);
		}
	}

	@Check
	public void checkOnlyOneSchemaInProject(EditorFile editorFile) {
		Collection<EditorFile> allFiles = TGGLWorkspaceUtil.getAllFilesInScope(editorFile);
		long numberOfSchemaFiles = allFiles.stream() //
				.filter(f -> f.getSchema() != null) //
				.count();

		if (numberOfSchemaFiles > 1) {
			error("There must be only one file with a schema in a project.", TGGLPackage.Literals.EDITOR_FILE__SCHEMA);
		}
	}

}
