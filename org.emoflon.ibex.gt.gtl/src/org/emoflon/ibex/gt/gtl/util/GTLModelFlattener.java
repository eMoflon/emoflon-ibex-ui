package org.emoflon.ibex.gt.gtl.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.BracketExpression;
import org.emoflon.ibex.common.slimgt.slimGT.Constant;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.EnumExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ExpArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.MinMaxArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ProductArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTFactory;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAnnotation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMappings;
import org.emoflon.ibex.common.slimgt.slimGT.StochasticArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SumArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.UnaryArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ValueExpression;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.ExpressionOperand;
import org.emoflon.ibex.gt.gtl.gTL.GTLFactory;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleEdgeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimParameter;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation;

public class GTLModelFlattener {

	protected SlimGTFactory superFactory = SlimGTPackage.eINSTANCE.getSlimGTFactory();
	protected GTLFactory factory = GTLPackage.eINSTANCE.getGTLFactory();
	protected String packageName = null;
	protected EditorFile flattenedFile = null;
	protected Map<URI, Resource> resourceCache = Collections.synchronizedMap(new HashMap<>());
	protected Set<String> imports = Collections.synchronizedSet(new HashSet<>());
	protected Map<String, SlimRule> name2rule = Collections.synchronizedMap(new HashMap<>());
	protected Map<SlimRule, Map<String, SlimRuleNode>> rule2nodes = Collections.synchronizedMap(new HashMap<>());
	protected Map<SlimRule, Map<String, SlimParameter>> rule2parameters = Collections.synchronizedMap(new HashMap<>());
	protected Map<String, List<Consumer<SlimRule>>> pendingRuleJobs = Collections.synchronizedMap(new HashMap<>());
	protected Map<String, Map<String, List<Consumer<SlimRuleNode>>>> rule2pendingNodeJobs = Collections
			.synchronizedMap(new HashMap<>());

	public GTLModelFlattener(final EditorFile file, boolean loadCompletePackage) {
		this.packageName = file.getPackage().getName();
		flattenedFile = factory.createEditorFile();
		flattenedFile.setPackage(factory.createPackageDeclaration());
		flattenedFile.getPackage().setName(packageName);

		if (loadCompletePackage) {

		} else {
			flatten(file);
		}
	}

	public GTLModelFlattener(final Collection<EditorFile> files) throws Exception {
		for (EditorFile file : files) {
			if (packageName == null) {
				packageName = file.getPackage().getName();
			} else {
				if (!packageName.equals(file.getPackage().getName())) {
					throw new UnsupportedOperationException(
							"Multiple gtl packages can not be merged into one gtl model instance.");
				}
			}
		}

		flattenedFile = factory.createEditorFile();
		flattenedFile.setPackage(factory.createPackageDeclaration());
		flattenedFile.getPackage().setName(packageName);
		files.parallelStream().forEach(ef -> flatten(ef));
	}

	protected Resource loadResource(final Resource requester, final URI gtModelUri) {
		Resource other = resourceCache.get(gtModelUri);
		if (other == null) {
			XtextResourceSet rs = new XtextResourceSet();
			try {
				other = rs.getResource(gtModelUri, true);
			} catch (Exception e) {
				return other;
			}
			resourceCache.put(gtModelUri, other);

			if (other == null)
				return other;

			EcoreUtil2.resolveLazyCrossReferences(other, () -> false);
		}

		return other;
	}

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

	protected void flatten(EditorFile file) {
		// Add metamodel imports
		imports.addAll(file.getImports().stream().map(i -> i.getName()).collect(Collectors.toSet()));

		// Add non-package imports and flatten if necessary
		for (PatternImport pi : file.getImportedPatterns()) {
			if (!pi.isImportingAll()) {
				flatten(pi.getPattern());
			} else {
				Optional<EditorFile> wildcardImport = loadGTLModelByImport(pi);
				if (!wildcardImport.isPresent())
					continue;

				wildcardImport.get().getRules().parallelStream().forEach(other -> flatten(other));
			}
		}

		// Flatten rules
		file.getRules().parallelStream().forEach(rule -> flatten(rule));

	}

	protected void flatten(SlimRule rule) {
		if (name2rule.containsKey(rule.getName()))
			return;

		SlimRule flattenedRule = factory.createSlimRule();
		flattenedRule.setName(rule.getName());
		name2rule.put(rule.getName(), flattenedRule);

		if (rule.isConfigured()) {
			SlimRuleAnnotation rAn = EcoreUtil.copy(rule.getConfiguration());
			flattenedRule.setConfiguration(rAn);
		}
		flattenedRule.setAbstract(rule.isAbstract());
		flattenedRule.setType(rule.getType());

		// Add and map parameters to name
		Map<String, SlimParameter> name2Parameter = new HashMap<>();
		for (SlimParameter param : GTLModelUtil.getAllParameters(rule)) {
			SlimParameter flattenedParam = factory.createSlimParameter();
			flattenedParam.setName(param.getName());
			flattenedParam.setType(param.getType());
			name2Parameter.put(param.getName(), flattenedParam);
			flattenedRule.getParameters().add(flattenedParam);
		}

		Map<SlimRuleNode, RuleNodeHierarchy> hierarchies = GTLModelUtil.getAllRuleNodeHierarchy(rule);
		Map<String, SlimRuleNode> name2Node = Collections.synchronizedMap(new HashMap<>());
		rule2nodes.put(flattenedRule, name2Node);
		Map<String, List<Consumer<SlimRuleNode>>> pendingMappingNodes = rule2pendingNodeJobs.get(rule.getName());
		if (pendingMappingNodes == null) {
			pendingMappingNodes = Collections.synchronizedMap(new HashMap<>());
			rule2pendingNodeJobs.put(rule.getName(), pendingMappingNodes);
		}

		for (SlimRuleNode node : hierarchies.keySet()) {
			SlimRuleNode flattenedNode = factory.createSlimRuleNode();

			if (node.eContainer() instanceof SlimRuleNodeContext context) {
				SlimRuleNodeContext flattenedContext = factory.createSlimRuleNodeContext();
				flattenedContext.setContext(flattenedNode);
				flattenedContext.setLocal(context.isLocal());
				flattenedRule.getContextNodes().add(flattenedContext);
			} else if (node.eContainer() instanceof SlimRuleNodeCreation creation) {
				SlimRuleNodeCreation flattenedCreation = factory.createSlimRuleNodeCreation();
				flattenedCreation.setCreation(flattenedNode);
				flattenedRule.getCreatedNodes().add(flattenedCreation);
			} else if (node.eContainer() instanceof GTLRuleNodeDeletion deletion) {
				GTLRuleNodeDeletion flattenedDeletion = factory.createGTLRuleNodeDeletion();
				flattenedDeletion.setDeletion(flattenedNode);
				flattenedRule.getDeletedNodes().add(flattenedDeletion);
			} else {
				continue;
			}

			flattenedNode.setName(node.getName());
			flattenedNode.setType(node.getType());
			name2Node.put(node.getName(), flattenedNode);

			// Flatten edge targets
			for (SlimRuleEdge edge : GTLModelUtil.getRuleNodeAllEdges(node, hierarchies)) {
				Collection<SlimRuleNode> targets = GTLModelUtil.findEdgeTargetLeafNodes(edge, hierarchies);
				for (SlimRuleNode target : targets) {
					SlimRuleEdge flattenedEdge = superFactory.createSlimRuleEdge();

					if (edge.eContainer() instanceof SlimRuleEdgeContext edgeContext) {
						SlimRuleEdgeContext flattenedEdgeContext = superFactory.createSlimRuleEdgeContext();
						flattenedEdgeContext.setContext(flattenedEdge);
						flattenedNode.getContextEdges().add(flattenedEdgeContext);
					} else if (edge.eContainer() instanceof SlimRuleEdgeCreation edgeCreation) {
						SlimRuleEdgeCreation flattenedEdgeCreation = superFactory.createSlimRuleEdgeCreation();
						flattenedEdgeCreation.setCreation(flattenedEdge);
						flattenedNode.getCreatedEdges().add(flattenedEdgeCreation);
					} else if (edge.eContainer() instanceof GTLRuleEdgeDeletion edgeDeletion) {
						GTLRuleEdgeDeletion flattenedEdgeDeletion = factory.createGTLRuleEdgeDeletion();
						flattenedEdgeDeletion.setDeletion(flattenedEdge);
						flattenedNode.getDeletedEdges().add(flattenedEdgeDeletion);
					} else {
						continue;
					}

					flattenedEdge.setType(edge.getType());
					if (name2Node.containsKey(target.getName())) {
						flattenedEdge.setTarget(name2Node.get(target.getName()));
					} else {
						addPendingNodeConsumer(rule.getName(), target.getName(), (trg) -> flattenedEdge.setTarget(trg));
					}
				}
			}

			// Flatten node attribute references within attribute assignments
			for (SlimRuleAttributeAssignment assignment : GTLModelUtil.getRuleNodeAllAttributeAssignments(flattenedNode,
					hierarchies)) {
				SlimRuleAttributeAssignment flattenedAssignment = superFactory.createSlimRuleAttributeAssignment();
				flattenedAssignment.setType(assignment.getType());
				flattenedAssignment.setValue(flatten(assignment.getValue(), flattenedRule));
				flattenedNode.getAssignments().add(flattenedAssignment);
			}

			// Flatten edge iterators and their assignments

		}
	}

	protected ValueExpression flatten(ValueExpression expression, SlimRule container) {
		return flatten(expression, container);
	}

	protected ArithmeticExpression flatten(ArithmeticExpression expression, SlimRule container) {
		if (expression instanceof SumArithmeticExpression sum) {
			SumArithmeticExpression flattenedSum = superFactory.createSumArithmeticExpression();
			flattenedSum.setOperator(sum.getOperator());
			flattenedSum.setLeft(flatten(sum.getLeft(), container));
			flattenedSum.setRight(flatten(sum.getRight(), container));
			return flattenedSum;
		} else if (expression instanceof ProductArithmeticExpression prod) {
			ProductArithmeticExpression flattenedProduct = superFactory.createProductArithmeticExpression();
			flattenedProduct.setOperator(prod.getOperator());
			flattenedProduct.setLeft(flatten(prod.getLeft(), container));
			flattenedProduct.setRight(flatten(prod.getRight(), container));
			return flattenedProduct;
		} else if (expression instanceof ExpArithmeticExpression exp) {
			ExpArithmeticExpression flattenedExponential = superFactory.createExpArithmeticExpression();
			flattenedExponential.setOperator(exp.getOperator());
			flattenedExponential.setLeft(flatten(exp.getLeft(), container));
			flattenedExponential.setRight(flatten(exp.getRight(), container));
			return flattenedExponential;
		} else if (expression instanceof StochasticArithmeticExpression stoc) {
			StochasticArithmeticExpression flattenedStochastic = superFactory.createStochasticArithmeticExpression();
			flattenedStochastic.setDistribution(stoc.getDistribution());
			flattenedStochastic.setMean(flatten(stoc.getMean(), container));
			if (stoc.isHasSd()) {
				flattenedStochastic.setHasSd(true);
				flattenedStochastic.setSd(flatten(stoc.getSd(), container));
			}
			return flattenedStochastic;
		} else if (expression instanceof MinMaxArithmeticExpression minMax) {
			MinMaxArithmeticExpression flattenedMinMax = superFactory.createMinMaxArithmeticExpression();
			flattenedMinMax.setMinMaxOperator(minMax.getMinMaxOperator());
			flattenedMinMax.setLeft(flatten(minMax.getLeft(), container));
			flattenedMinMax.setRight(flatten(minMax.getRight(), container));
			return flattenedMinMax;
		} else if (expression instanceof UnaryArithmeticExpression un) {
			UnaryArithmeticExpression flattenedUnary = superFactory.createUnaryArithmeticExpression();
			flattenedUnary.setOperator(un.getOperator());
			flattenedUnary.setOperand(flatten(un.getOperand(), container));
			return flattenedUnary;
		} else if (expression instanceof BracketExpression brack) {
			BracketExpression flattenedBracket = superFactory.createBracketExpression();
			flattenedBracket.setOperand(flatten(brack.getOperand(), container));
			return flattenedBracket;
		} else if (expression instanceof ExpressionOperand op) {
			ExpressionOperand flattenedOperand = factory.createExpressionOperand();
			if (op.getOperand() instanceof NodeExpression ne) {
				NodeExpression flattenedNode = superFactory.createNodeExpression();
				Map<String, SlimRuleNode> name2Node = rule2nodes.get(container);
				if (name2Node.containsKey(ne.getNode().getName())) {
					flattenedNode.setNode(name2Node.get(ne.getNode().getName()));
				} else {
					addPendingNodeConsumer(container.getName(), ne.getNode().getName(),
							(node) -> flattenedNode.setNode(node));
				}

				flattenedOperand.setOperand(flattenedNode);
			} else if (op.getOperand() instanceof NodeAttributeExpression nae) {
				NodeAttributeExpression flattenedNAE = superFactory.createNodeAttributeExpression();
				NodeExpression flattenedNode = superFactory.createNodeExpression();
				flattenedNAE.setNodeExpression(flattenedNode);
				flattenedNAE.setFeature(nae.getFeature());
				Map<String, SlimRuleNode> name2Node = rule2nodes.get(container);
				if (name2Node.containsKey(nae.getNodeExpression().getNode().getName())) {
					flattenedNode.setNode(name2Node.get(nae.getNodeExpression().getNode().getName()));
				} else {
					addPendingNodeConsumer(container.getName(), nae.getNodeExpression().getNode().getName(),
							(node) -> flattenedNode.setNode(node));
				}

				flattenedOperand.setOperand(flattenedNAE);
			} else if (op.getOperand() instanceof GTLIteratorAttributeExpression nae) {
				flattenedOperand.setOperand(EcoreUtil.copy(nae));
			} else if (op.getOperand() instanceof GTLParameterExpression param) {
				GTLParameterExpression flattenedParam = factory.createGTLParameterExpression();
				Map<String, SlimParameter> name2Parameter = rule2parameters.get(container);
				flattenedParam.setParameter(name2Parameter.get(param.getParameter().getName()));
				flattenedOperand.setOperand(flattenedParam);
			} else if (op.getOperand() instanceof CountExpression count) {
				SlimRule invokee = (SlimRule) count.getInvokedPatten();
				CountExpression flattenedCount = superFactory.createCountExpression();
				if (name2rule.containsKey(invokee.getName())) {
					flattenedCount.setInvokedPatten(name2rule.get(invokee.getName()));
					flattenedCount
							.setMappings(flatten(container, name2rule.get(invokee.getName()), count.getMappings()));
					flattenedOperand.setOperand(flattenedCount);
				} else {
					addPendingRuleConsumer(invokee.getName(), (rule) -> {
						flattenedCount.setInvokedPatten(rule);
						flattenedCount.setMappings(flatten(container, rule, count.getMappings()));
						flattenedOperand.setOperand(flattenedCount);
					});
				}
			} else if (op.getOperand() instanceof ArithmeticLiteral lit) {
				flattenedOperand.setOperand(EcoreUtil.copy(lit));
			} else if (op.getOperand() instanceof EnumExpression en) {
				flattenedOperand.setOperand(EcoreUtil.copy(en));
			} else if (op.getOperand() instanceof Constant con) {
				flattenedOperand.setOperand(EcoreUtil.copy(con));
			} else {
				throw new UnsupportedOperationException("Unkown arithmetic operand type: " + op.getOperand());
			}
			return flattenedOperand;
		} else {
			throw new UnsupportedOperationException("Unkown arithmetic operation type: " + expression);
		}
	}

	protected SlimRuleNodeMappings flatten(SlimRule sourceRule, SlimRule targetRule, SlimRuleNodeMappings mappings) {
		SlimRuleNodeMappings flattenedMappings = superFactory.createSlimRuleNodeMappings();
		Map<String, SlimRuleNode> srcNodes = rule2nodes.get(sourceRule);
		Map<String, SlimRuleNode> trgNodes = rule2nodes.get(targetRule);
		for (SlimRuleNodeMapping mapping : mappings.getMappings()) {
			SlimRuleNodeMapping flattenedMapping = superFactory.createSlimRuleNodeMapping();
			if (srcNodes.containsKey(mapping.getSrcNode().getName())) {
				flattenedMapping.setSrcNode(srcNodes.get(mapping.getSrcNode().getName()));
			} else {
				addPendingNodeConsumer(sourceRule.getName(), mapping.getSrcNode().getName(), (node) -> {
					flattenedMapping.setSrcNode(node);
				});
			}
			if (trgNodes.containsKey(mapping.getTrgNode().getName())) {
				flattenedMapping.setTrgNode(trgNodes.get(mapping.getTrgNode().getName()));
			} else {
				addPendingNodeConsumer(targetRule.getName(), mapping.getTrgNode().getName(), (node) -> {
					flattenedMapping.setTrgNode(node);
				});
			}
		}
		return flattenedMappings;
	}

	protected void addPendingRuleConsumer(final String rule, final Consumer<SlimRule> consumer) {
		List<Consumer<SlimRule>> consumers = pendingRuleJobs.get(rule);
		if (consumer == null) {
			consumers = Collections.synchronizedList(new LinkedList<>());
			pendingRuleJobs.put(rule, consumers);
		}
		consumers.add(consumer);
	}

	protected void addPendingNodeConsumer(final String rule, final String node, final Consumer<SlimRuleNode> consumer) {
		Map<String, List<Consumer<SlimRuleNode>>> pendingMappingNodes = rule2pendingNodeJobs.get(rule);
		if (pendingMappingNodes == null) {
			pendingMappingNodes = Collections.synchronizedMap(new HashMap<>());
			rule2pendingNodeJobs.put(rule, pendingMappingNodes);
		}

		List<Consumer<SlimRuleNode>> consumers = pendingMappingNodes.get(node);
		if (consumer == null) {
			consumers = Collections.synchronizedList(new LinkedList<>());
			pendingMappingNodes.put(node, consumers);
		}
		consumers.add(consumer);
	}
}
