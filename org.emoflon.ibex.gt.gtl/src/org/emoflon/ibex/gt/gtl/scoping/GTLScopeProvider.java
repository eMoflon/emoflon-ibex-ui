/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.scoping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.ibex.common.slimgt.scoping.SlimGTScopeUtil;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanExpression;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeCondition;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.gt.gtl.gTL.EdgeIteratorOperator;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeAssignment;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementAliased;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementNode;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementPlain;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleWatchDog;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.util.GTLModelUtil;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class GTLScopeProvider extends AbstractGTLScopeProvider {

	public Optional<EditorFile> loadGTLModelByFullPath(final EObject context, final String path) {
		Resource resource = null;
		URI gtModelUri = null;
		EditorFile file = null;

		File importFile = new File(path);
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			gtModelUri = URI.createFileURI(path);
			try {
				resource = loadResource(context.eResource(), gtModelUri);
				file = (EditorFile) resource.getContents().get(0);
			} catch (Exception e) {
				return Optional.empty();
			}
		}

		if (file == null) {
			return Optional.empty();
		} else {
			return Optional.of(file);
		}
	}

	public Optional<EditorFile> loadGTLModelByRelativePath(final EObject context, final String path) {
		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(context.eResource());
		Resource resource = null;
		URI gtModelUri = null;
		String absolutePath = null;
		EditorFile file = null;

		try {
			absolutePath = Paths.get(currentProject.getLocation().toPortableString()).resolve(Paths.get(path)).toFile()
					.getCanonicalPath();
		} catch (IOException e1) {
			return Optional.empty();
		}

		gtModelUri = URI.createFileURI(absolutePath);
		try {
			resource = loadResource(context.eResource(), gtModelUri);
			file = (EditorFile) resource.getContents().get(0);
		} catch (Exception e) {
			return Optional.empty();
		}

		if (file == null) {
			return Optional.empty();
		} else {
			return Optional.of(file);
		}
	}

	public Optional<EditorFile> loadGTLModelByImport(final PatternImport imp) {
		String currentImport = imp.getFile().getValue().replace("\"", "");
		File importFile = new File(currentImport);
		Optional<EditorFile> optFile = null;
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			optFile = loadGTLModelByFullPath(imp, currentImport);
		} else {
			optFile = loadGTLModelByRelativePath(imp, currentImport);
		}
		return optFile;
	}

	public Collection<EditorFile> loadAllEditorFilesInPackage(final EditorFile ef) {
		Collection<EditorFile> pkgScope = new LinkedList<>();

		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(ef.eResource());
		String currentFile = ef.eResource().getURI().toString().replace("platform:/resource/", "")
				.replace(currentProject.getName(), "");
		currentFile = currentProject.getLocation().toPortableString() + currentFile;
		currentFile = currentFile.replace("/", "\\");

		IWorkspace ws = ResourcesPlugin.getWorkspace();
		for (IProject project : ws.getRoot().getProjects()) {
			try {
				if (!project.hasNature("org.emoflon.ibex.gt.gtl.ui.nature"))
					continue;
			} catch (CoreException e) {
				continue;
			}

			File projectFile = new File(project.getLocation().toPortableString());
			List<File> gtFiles = new LinkedList<>();
			SlimGTWorkspaceUtil.gatherFilesWithEnding(gtFiles, projectFile, ".gtl", true);

			for (File gtFile : gtFiles) {
				URI gtModelUri;
				try {
					gtModelUri = URI.createFileURI(gtFile.getCanonicalPath());
				} catch (IOException e) {
					continue;
				}

				String fileString = gtModelUri.toFileString();

				if (fileString.equals(currentFile))
					continue;

				Resource resource = loadResource(ef.eResource(), gtModelUri);
				if (resource == null)
					continue;

				EObject gtlModel = resource.getContents().get(0);

				if (gtlModel == null)
					continue;

				if (gtlModel instanceof EditorFile otherEditorFile) {
					if (otherEditorFile.getPackage().getName().equals(ef.getPackage().getName())) {
						pkgScope.add(otherEditorFile);
					}
				}
			}
		}

		return pkgScope;
	}

	public Collection<SlimRule> getAllRulesInScope(EditorFile ef) {
		Set<SlimRule> ruleSet = new HashSet<>();

		// Add directly imported patterns
		ef.getImportedPatterns().stream().filter(pi -> !pi.isImportingAll())
				.forEach(pi -> ruleSet.add(pi.getPattern()));
		ruleSet.addAll(ef.getRules());

		// Add imported patterns by wildcard
		ef.getImportedPatterns().stream().filter(pi -> pi.isImportingAll()).forEach(pi -> {
			Optional<EditorFile> optEditorFile = loadGTLModelByImport(pi);
			if (optEditorFile.isPresent()) {
				ruleSet.addAll(optEditorFile.get().getRules());
			}
		});

		// Add patterns in package name
		Collection<EditorFile> scope = loadAllEditorFilesInPackage(ef);
		scope.forEach(other -> ruleSet.addAll(other.getRules()));

		return ruleSet;
	}

	@Override
	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		if (GTLScopeUtil.isPatternImportPattern(context, reference)) {
			return scopeForPatternImportPattern((PatternImport) context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementRule(context, reference)) {
			return scopeForRuleRefinementRule(context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementNodeRefinement(context, reference)) {
			return scopeForRuleRefinementNodeRefinement(context, reference);
		}
		if (GTLScopeUtil.isGTLRuleRefinementNodeNode(context, reference)) {
			return scopeForRuleRefinementNodeNode((GTLRuleRefinementNode) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeType(context, reference)) {
			return scopeForSlimRuleNodeType((SlimRuleNode) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleEdgeTarget(context, reference)) {
			return scopeForSlimEdgeTarget((SlimRuleEdge) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeMappingSrc(context, reference)) {
			return scopeForNodeMappingSrc((SlimRuleNodeMapping) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleNodeMappingTrg(context, reference)) {
			return scopeForNodeMappingTrg((SlimRuleNodeMapping) context, reference);
		}
		if (SlimGTScopeUtil.isSlimRuleInvocationPattern(context, reference)) {
			return scopeForInvocationSupportPattern((SlimRuleInvocation) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorType(context, reference)) {
			return scopeForGTLEdgeIteratorType((GTLEdgeIterator) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorSubType(context, reference)) {
			return scopeForGTLEdgeIteratorSubType((GTLEdgeIterator) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceSource(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceSource((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceType(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceType((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorReferenceTarget(context, reference)) {
			return scopeForGTLEdgeIteratorReferenceTarget((GTLEdgeIteratorReference) context, reference);
		}
		if (GTLScopeUtil.isGTLParameterExpressionParameter(context, reference)) {
			return scopeForParameterExpressionParameter((GTLParameterExpression) context, reference);
		}
		if (SlimGTScopeUtil.isCountExpressionPattern(context, reference)) {
			return scopeForCountExpressionPattern((CountExpression) context, reference);
		}
		if (GTLScopeUtil.isAttributeConditionExpressionNode(context, reference)) {
			return scopeForAttributeConditionExpressionNode((SlimRuleAttributeCondition) context, reference);
		}
		if (SlimGTScopeUtil.isNodeAttributeExpressionNode(context, reference)) {
			return scopeForAttributeExpressionNode(context, reference);
		}
		if (SlimGTScopeUtil.isNodeAttributeExpressionFeature(context, reference)) {
			return scopeForAttributeExpressionFeature((NodeAttributeExpression) context, reference);
		}
		if (GTLScopeUtil.isIteratorAttributeExpressionFeature(context, reference)) {
			return scopeForIteratorAttributeExpressionFeature((GTLIteratorAttributeExpression) context, reference);
		}
		if (GTLScopeUtil.isGTLEdgeIteratorAttributeAssignment(context)) {
			return scopeForGTLEdgeIteratorAttributeAssignment((GTLEdgeIteratorAttributeAssignment) context, reference);
		}
		if (GTLScopeUtil.isGTLRuleWatchDogNode(context, reference)) {
			return scopeForGTLRuleWatchDogNode((GTLRuleWatchDog) context, reference);
		}
		if (SlimGTScopeUtil.isValueOrArithmeticExpression(context)) {
			return scopeForValueOrArithmeticExpression(context, reference);
		}
		if (SlimGTScopeUtil.isBooleanExpression(context)) {
			return scopeForBooleanExpression((BooleanExpression) context, reference);
		}

		return super.getScopeInternal(context, reference);
	}

	protected IScope scopeForPatternImportPattern(PatternImport context, EReference reference) {
		if (context == null || context.getFile() == null || context.getFile().getValue() == null
				|| context.getFile().getValue().isBlank())
			return IScope.NULLSCOPE;

		Optional<EditorFile> optEditorFile = loadGTLModelByImport(context);
		if (optEditorFile.isPresent()) {
			return Scopes.scopeFor(optEditorFile.get().getRules());
		} else {
			return IScope.NULLSCOPE;
		}
	}

	protected IScope scopeForRuleRefinementRule(EObject context, EReference reference) {
		EditorFile currentFile = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		Collection<SlimRule> allRules = getAllRulesInScope(currentFile);
		allRules.remove(currentRule);
		return Scopes.scopeFor(allRules);
	}

	protected IScope scopeForRuleRefinementNodeRefinement(EObject context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		Collection<EObject> refinements = currentRule.getRefinement().stream()
				.filter(ref -> (ref instanceof GTLRuleRefinementPlain)).map(ref -> (GTLRuleRefinementPlain) ref)
				.map(ref -> ref.getSuperRule()).collect(Collectors.toSet());
		refinements.addAll(currentRule.getRefinement().stream().filter(ref -> (ref instanceof GTLRuleRefinementAliased))
				.map(ref -> (GTLRuleRefinementAliased) ref).collect(Collectors.toSet()));
		return Scopes.scopeFor(refinements);
	}

	protected IScope scopeForRuleRefinementNodeNode(GTLRuleRefinementNode context, EReference reference) {
		if (context.getSuperRule() == null)
			return IScope.NULLSCOPE;

		Optional<SlimRule> optRule = GTLModelUtil.refinementNodeToRule(context.getSuperRule());
		if (!optRule.isPresent())
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(GTLModelUtil.getAllRuleNodes(optRule.get()));
	}

	@Override
	protected IScope scopeForSlimRuleNodeType(org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode context,
			EReference reference) {
		SlimRuleNode ruleNode = (SlimRuleNode) context;
		if (!GTLModelUtil.ruleNodeIsRefining(ruleNode)) {
			return super.scopeForSlimRuleNodeType(context, reference);
		} else {
			if (GTLModelUtil.getRefinementNode(ruleNode) == null
					|| GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode() == null)
				return IScope.NULLSCOPE;

			EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);

			Collection<EClass> superTypes = SlimGTModelUtil.getClasses(ef).stream()
					.filter(cls -> cls.getEAllSuperTypes() != null && cls.getEAllSuperTypes().size() > 0)
					.filter(cls -> cls.getEAllSuperTypes().stream()
							.filter(superCls -> superCls.getName().equals(
									GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode().getType().getName()))
							.findAny().isPresent())
					.collect(Collectors.toSet());
			superTypes.add(GTLModelUtil.getRefinementNode(ruleNode).getRefinementNode().getType());

			return Scopes.scopeFor(superTypes);
		}

	}

	protected IScope scopeForSlimEdgeTarget(SlimRuleEdge context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		// Find nodes with correct type. Allowed: Exact type match or target type is a
		// subtype of the edge type.
		Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllRuleNodes(currentRule).stream()
				.filter(sn -> sn.getType().getName().equals(context.getType().getEType().getName())
						|| sn.getType().getEAllSuperTypes().stream()
								.filter(superCls -> superCls.getName().equals(context.getType().getEType().getName()))
								.findAny().isPresent())
				.collect(Collectors.toSet());
		// TODO: Prohibit self-edges?
//		allRuleNodes.remove(currentRuleNode);

		return Scopes.scopeFor(allRuleNodes);
	}

	protected IScope scopeForNodeMappingSrc(SlimRuleNodeMapping context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		EObject container = SlimGTModelUtil.getContainer(context, GTLRuleRefinement.class);
		if (container != null && container instanceof GTLRuleRefinement refinement) {
			Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllRuleNodes(currentRule);
			allRuleNodes.removeAll(currentRule.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
					.collect(Collectors.toSet()));
			allRuleNodes.removeAll(
					currentRule.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));
			return Scopes.scopeFor(allRuleNodes);
		}

		container = SlimGTModelUtil.getContainer(context, SlimRuleInvocation.class);
		if (container != null && container instanceof SlimRuleInvocation invocation) {
			Set<SlimRuleNode> allRuleNodes = new HashSet<>();
			allRuleNodes.addAll(currentRule.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
					.collect(Collectors.toSet()));
			allRuleNodes.addAll(
					currentRule.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));
			return Scopes.scopeFor(allRuleNodes);
		}

		container = SlimGTModelUtil.getContainer(context, CountExpression.class);
		if (container != null && container instanceof CountExpression count) {
			Set<SlimRuleNode> allRuleNodes = new HashSet<>();
			allRuleNodes.addAll(currentRule.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
					.collect(Collectors.toSet()));
			allRuleNodes.addAll(
					currentRule.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));
			return Scopes.scopeFor(allRuleNodes);
		}

		return IScope.NULLSCOPE;
	}

	protected IScope scopeForNodeMappingTrg(SlimRuleNodeMapping context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		EObject container = SlimGTModelUtil.getContainer(context, GTLRuleRefinement.class);
		if (container != null && container instanceof GTLRuleRefinement refinement) {
			Set<SlimRuleNode> allRuleNodes = new HashSet<>();
			allRuleNodes.addAll(currentRule.getContextNodes().stream().map(cn -> (SlimRuleNode) cn.getContext())
					.collect(Collectors.toSet()));
			allRuleNodes.addAll(
					currentRule.getDeletedNodes().stream().map(cn -> cn.getDeletion()).collect(Collectors.toSet()));
			allRuleNodes.addAll(currentRule.getCreatedNodes().stream().map(cn -> (SlimRuleNode) cn.getCreation())
					.collect(Collectors.toSet()));
			return Scopes.scopeFor(allRuleNodes);
		}

		container = SlimGTModelUtil.getContainer(context, SlimRuleInvocation.class);
		if (container != null && container instanceof SlimRuleInvocation invocation
				&& invocation.getSupportPattern() != null
				&& invocation.getSupportPattern() instanceof SlimRule trgRule) {
			Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllDeletedAndContextRuleNodes(trgRule);
			return Scopes.scopeFor(allRuleNodes);
		}

		container = SlimGTModelUtil.getContainer(context, CountExpression.class);
		if (container != null && container instanceof CountExpression count && count.getInvokedPatten() != null
				&& count.getInvokedPatten() instanceof SlimRule trgRule) {
			Collection<SlimRuleNode> allRuleNodes = GTLModelUtil.getAllDeletedAndContextRuleNodes(trgRule);
			return Scopes.scopeFor(allRuleNodes);
		}

		return IScope.NULLSCOPE;
	}

	private IScope scopeForInvocationSupportPattern(SlimRuleInvocation context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);

		return Scopes.scopeFor(getAllRulesInScope(ef).stream().filter(r -> !r.equals(rule))
				.filter(r -> r.getParameters() == null || r.getParameters().size() == 0).collect(Collectors.toList()));
	}

	protected IScope scopeForParameterExpressionParameter(GTLParameterExpression context, EReference reference) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllParameters(currentRule));
	}

	protected IScope scopeForCountExpressionPattern(CountExpression context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);

		return Scopes.scopeFor(getAllRulesInScope(ef).stream().filter(r -> !r.equals(rule))
				.filter(r -> r.getParameters() == null || r.getParameters().size() == 0).collect(Collectors.toList()));
	}

	protected IScope scopeForValueOrArithmeticExpression(EObject context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	private IScope scopeForBooleanExpression(BooleanExpression context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeConditionExpressionNode(SlimRuleAttributeCondition context,
			EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeExpressionNode(EObject context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllDeletedAndContextRuleNodes(rule));
	}

	protected IScope scopeForAttributeExpressionFeature(NodeAttributeExpression context, EReference reference) {
		if (context.getNodeExpression() == null)
			return IScope.NULLSCOPE;

		if (context.getNodeExpression().getNode() == null)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(context.getNodeExpression().getNode().getType().getEAllAttributes());
	}

	protected IScope scopeForIteratorAttributeExpressionFeature(GTLIteratorAttributeExpression context,
			EReference reference) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr.getType() == null)
			return IScope.NULLSCOPE;

		if (itr.isCasting() && itr.getSubType() != null) {
			return Scopes.scopeFor(itr.getSubType().getEAllAttributes());
		} else {
			return Scopes.scopeFor(((EClass) itr.getType().getEType()).getEAllAttributes());
		}

	}

	protected IScope scopeForGTLEdgeIteratorType(GTLEdgeIterator context, EReference reference) {
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		if (node.eContainer() instanceof SlimRuleNodeCreation)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(
				node.getType().getEAllReferences().stream().filter(ref -> ref.isMany()).collect(Collectors.toList()));
	}

	protected IScope scopeForGTLEdgeIteratorSubType(GTLEdgeIterator context, EReference reference) {
		EditorFile ef = SlimGTModelUtil.getContainer(context, EditorFile.class);
		return Scopes.scopeFor(SlimGTModelUtil.getClasses(ef).stream()
				.filter(cls -> cls.getEAllSuperTypes().contains(context.getType().getEType()))
				.collect(Collectors.toSet()));
	}

	protected IScope scopeForGTLEdgeIteratorAttributeAssignment(GTLEdgeIteratorAttributeAssignment context,
			EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllCreatedAndContextRuleNodes(rule));
	}

	protected IScope scopeForGTLEdgeIteratorReferenceSource(GTLEdgeIteratorReference context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		SlimRuleNode node = SlimGTModelUtil.getContainer(context, SlimRuleNode.class);
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr == null)
			return IScope.NULLSCOPE;

		if (context.getOperator() == EdgeIteratorOperator.DELETE) {
			return Scopes.scopeFor(List.of(node));
		} else {
			return Scopes.scopeFor(GTLModelUtil.getAllCreatedAndContextRuleNodes(rule));
		}
	}

	protected IScope scopeForGTLEdgeIteratorReferenceType(GTLEdgeIteratorReference context, EReference reference) {
		if (context.getSource() == null)
			return IScope.NULLSCOPE;

		if (context.getSource().getType() == null)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(context.getSource().getType().getEAllReferences());
	}

	protected IScope scopeForGTLEdgeIteratorReferenceTarget(GTLEdgeIteratorReference context, EReference reference) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(context, GTLEdgeIterator.class);
		if (itr == null)
			return IScope.NULLSCOPE;

		return Scopes.scopeFor(List.of(itr));
	}

	protected IScope scopeForGTLRuleWatchDogNode(GTLRuleWatchDog context, EReference reference) {
		SlimRule rule = SlimGTModelUtil.getContainer(context, SlimRule.class);
		return Scopes.scopeFor(GTLModelUtil.getAllContextRuleNodes(rule));
	}
}
