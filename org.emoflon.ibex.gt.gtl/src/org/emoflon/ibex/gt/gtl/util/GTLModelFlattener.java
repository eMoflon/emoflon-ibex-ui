package org.emoflon.ibex.gt.gtl.util;

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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanBracket;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanConjunction;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanDisjunction;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanExpression;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanImplication;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanNegation;
import org.emoflon.ibex.common.slimgt.slimGT.BracketExpression;
import org.emoflon.ibex.common.slimgt.slimGT.Constant;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.EnumExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ExpArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.MinMaxArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ProductArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.RelationalExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTFactory;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAnnotation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleCondition;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMapping;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeMappings;
import org.emoflon.ibex.common.slimgt.slimGT.StochasticArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SumArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.UnaryArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ValueExpression;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.validation.ValueExpressionDataType;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.ExpressionOperand;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorAttributeAssignment;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIteratorReference;
import org.emoflon.ibex.gt.gtl.gTL.GTLFactory;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleEdgeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleWatchDog;
import org.emoflon.ibex.gt.gtl.gTL.Import;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimParameter;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation;
import org.moflon.core.utilities.LogUtils;

public class GTLModelFlattener {
	private Logger logger = Logger.getLogger(GTLModelFlattener.class);
	final protected GTLResourceManager gtlManager;
	final protected SlimGTFactory superFactory = SlimGTPackage.eINSTANCE.getSlimGTFactory();
	final protected GTLFactory factory = GTLPackage.eINSTANCE.getGTLFactory();
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

	public GTLModelFlattener(final EditorFile file, boolean loadCompletePackage) throws Exception {
		this(new GTLResourceManager(), file, loadCompletePackage);
	}

	public GTLModelFlattener(final GTLResourceManager gtlManager, final EditorFile file, boolean loadCompletePackage)
			throws Exception {
		this.gtlManager = gtlManager;

		this.packageName = file.getPackage().getName();
		flattenedFile = factory.createEditorFile();
		flattenedFile.setPackage(factory.createPackageDeclaration());
		flattenedFile.getPackage().setName(packageName);

		if (loadCompletePackage) {
			Collection<EditorFile> files = gtlManager.loadAllEditorFilesInPackage(file);
			files.parallelStream().forEach(ef -> {
				try {
					flatten(ef);
				} catch (Exception e) {
					LogUtils.error(logger, e);
				}
			});
		} else {
			flatten(file);
		}

		postProcess();
	}

	public GTLModelFlattener(final Collection<EditorFile> files) throws Exception {
		this(new GTLResourceManager(), files);
	}

	public GTLModelFlattener(final GTLResourceManager gtlManager, final Collection<EditorFile> files) throws Exception {
		this.gtlManager = gtlManager;

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
		files.parallelStream().forEach(ef -> {
			try {
				flatten(ef);
			} catch (Exception e) {
				LogUtils.error(logger, e);
			}
		});

		postProcess();
	}

	public EditorFile getFlattenedModel() {
		return flattenedFile;
	}

	public SlimRule getFlattenedRule(String ruleName) {
		return name2rule.get(ruleName);
	}

	protected void postProcess() {
		for (String ruleName : name2rule.keySet()) {
			SlimRule flattenedRule = name2rule.get(ruleName);
			flattenedFile.getRules().add(flattenedRule);

			Map<String, SlimRuleNode> nodes = rule2nodes.get(flattenedRule);
			if (pendingRuleJobs.containsKey(ruleName)) {
				for (Consumer<SlimRule> pending : pendingRuleJobs.get(ruleName)) {
					pending.accept(flattenedRule);
				}

				for (String nodeName : nodes.keySet()) {
					SlimRuleNode flattenedNode = nodes.get(nodeName);
					if (rule2pendingNodeJobs.get(ruleName).containsKey(nodeName)) {
						for (Consumer<SlimRuleNode> pending : rule2pendingNodeJobs.get(ruleName).get(nodeName)) {
							pending.accept(flattenedNode);
						}
					}

				}
			}

		}
	}

	protected void flatten(EditorFile file) throws Exception {
		// Add metamodel imports
		imports.addAll(file.getImports().stream().map(i -> i.getName()).collect(Collectors.toSet()));

		// Add non-package imports and flatten if necessary
		for (PatternImport pi : file.getImportedPatterns()) {
			if (!pi.isImportingAll()) {
				EditorFile otherFile = SlimGTModelUtil.getContainer(pi.getPattern(), EditorFile.class);
				// Resolve possible dependencies through refinements and invocations through
				// recursive flattening.
				GTLModelFlattener flattener = new GTLModelFlattener(gtlManager, otherFile, true);
				imports.addAll(flattener.imports);
				SlimRule flattenedRule = flattener.getFlattenedRule(pi.getPattern().getName());
				insertFlattenedRule(flattenedRule);
			} else {
				Optional<EditorFile> wildcardImport = gtlManager.loadGTLModelByImport(pi);
				if (!wildcardImport.isPresent())
					continue;

				EditorFile otherFile = wildcardImport.get();
				// Prevent the transitive import of other imported rules
				Set<String> otherRuleNames = otherFile.getRules().stream().map(r -> r.getName())
						.collect(Collectors.toSet());
				// Resolve possible dependencies through refinements and invocations through
				// recursive flattening.
				GTLModelFlattener flattener = new GTLModelFlattener(gtlManager, wildcardImport.get(), true);
				imports.addAll(flattener.imports);
				flattener.getFlattenedModel().getRules().stream()
						.filter(other -> otherRuleNames.contains(other.getName()))
						.forEach(other -> insertFlattenedRule(other));
			}
		}

		flattenedFile.getImports().addAll(imports.stream().map(imp -> {
			Import nImp = factory.createImport();
			nImp.setName(imp);
			return nImp;
		}).collect(Collectors.toList()));

		// Flatten rules
		file.getRules().parallelStream().forEach(rule -> {
			try {
				flatten(rule);
			} catch (Exception e) {
				LogUtils.error(logger, e);
			}
		});
	}

	protected void insertFlattenedRule(SlimRule flattenedRule) {
		if (name2rule.containsKey(flattenedRule.getName()))
			return;

		name2rule.put(flattenedRule.getName(), flattenedRule);
		flattenedRule.getContextNodes()
				.forEach(n -> insertFlattenedRuleNode(flattenedRule, (SlimRuleNode) n.getContext()));
		flattenedRule.getCreatedNodes()
				.forEach(n -> insertFlattenedRuleNode(flattenedRule, (SlimRuleNode) n.getCreation()));
		flattenedRule.getDeletedNodes().forEach(n -> insertFlattenedRuleNode(flattenedRule, n.getDeletion()));
	}

	protected void insertFlattenedRuleNode(SlimRule flattenedRule, SlimRuleNode flattenedRuleNode) {
		Map<String, SlimRuleNode> nodes = rule2nodes.get(flattenedRule);
		if (nodes == null) {
			nodes = Collections.synchronizedMap(new HashMap<>());
			rule2nodes.put(flattenedRule, nodes);
		}

		if (nodes.containsKey(flattenedRuleNode.getName()))
			return;

		nodes.put(flattenedRuleNode.getName(), flattenedRuleNode);
	}

	protected void flatten(SlimRule rule) throws Exception {
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

		// Flatten nodes
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
			for (GTLEdgeIterator iterator : GTLModelUtil.getRuleNodeAllEdgeIterators(node, hierarchies)) {
				GTLEdgeIterator flattenedIterator = factory.createGTLEdgeIterator();
				flattenedIterator.setName(iterator.getName());
				flattenedIterator.setType(iterator.getType());
				if (iterator.isCasting()) {
					flattenedIterator.setCasting(true);
					flattenedIterator.setSubType(iterator.getSubType());
				}

				for (GTLEdgeIteratorAttributeAssignment itrAssignment : iterator.getIteratorAttributes()) {
					GTLEdgeIteratorAttributeAssignment flattenedItrAssignment = factory
							.createGTLEdgeIteratorAttributeAssignment();
					if (itrAssignment.getAttribute() instanceof NodeAttributeExpression nae) {
						flattenedItrAssignment.setAttribute(flatten(nae, flattenedRule));
					} else {
						flattenedItrAssignment.setAttribute(EcoreUtil.copy(itrAssignment.getAttribute()));
					}
					flattenedItrAssignment.setValue(flatten(itrAssignment.getValue(), flattenedRule));
					flattenedIterator.getIteratorAttributes().add(flattenedItrAssignment);
				}

				for (GTLEdgeIteratorReference itrEdge : iterator.getReferences()) {
					Collection<SlimRuleNode> sources = GTLModelUtil.findItrEdgeSourceLeafNodes(itrEdge, hierarchies);
					for (SlimRuleNode source : sources) {
						GTLEdgeIteratorReference flattenedItrEdge = factory.createGTLEdgeIteratorReference();
						flattenedItrEdge.setOperator(itrEdge.getOperator());
						flattenedItrEdge.setType(itrEdge.getType());
						flattenedItrEdge.setTarget(flattenedIterator);

						if (name2Node.containsKey(source.getName())) {
							flattenedItrEdge.setSource(name2Node.get(source.getName()));
						} else {
							addPendingNodeConsumer(rule.getName(), source.getName(),
									(src) -> flattenedItrEdge.setSource(src));
						}
						flattenedIterator.getReferences().add(flattenedItrEdge);
					}
				}

				flattenedNode.getEdgeIterators().add(flattenedIterator);
			}
		}

		// Flatten attribute conditions
		Set<SlimRuleCondition> localConditions = Collections.synchronizedSet(new HashSet<>());
		localConditions.addAll(rule.getConditions());

		Collection<SlimRuleCondition> conditions = GTLModelUtil.getAllAttributeCondtions(rule);
		conditions = conditions.parallelStream().filter(condition -> {
			Set<ValueExpressionDataType> dataTypes = new HashSet<>();
			try {
				dataTypes.addAll(GTLArithmeticUtil.parseAllDataTypes(condition.getExpression()));
			} catch (Exception e) {
				LogUtils.error(logger, e);
				return false;
			}
			if (dataTypes.contains(ValueExpressionDataType.OBJECT)) {
				// Grab only node constraints that are part of this rule, ignore those of
				// refinements.
				if (localConditions.contains(condition)) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}).collect(Collectors.toList());

		for (SlimRuleCondition condition : conditions) {
			SlimRuleCondition flattenedCondition = superFactory.createSlimRuleCondition();
			flattenedCondition.setExpression(flatten(condition.getExpression(), flattenedRule));
			flattenedRule.getConditions().add(flattenedCondition);
		}

		// Flatten invocations
		for (SlimRuleInvocation invocation : rule.getInvocations()) {
			SlimRuleInvocation flattenedInvocation = superFactory.createSlimRuleInvocation();
			SlimRule invokee = (SlimRule) invocation.getSupportPattern();

			if (name2rule.containsKey(invokee.getName())) {
				flattenedInvocation.setSupportPattern(name2rule.get(invokee.getName()));
				flattenedInvocation.setMappings(
						flatten(flattenedRule, name2rule.get(invokee.getName()), flattenedInvocation.getMappings()));
			} else {
				addPendingRuleConsumer(invokee.getName(), (r) -> {
					flattenedInvocation.setSupportPattern(r);
					flattenedInvocation.setMappings(flatten(flattenedRule, r, flattenedInvocation.getMappings()));
				});
			}
			flattenedRule.getInvocations().add(flattenedInvocation);
		}

		// Flatten watch dogs
		for (GTLRuleWatchDog watchDog : rule.getWatchDogs()) {
			GTLRuleWatchDog flattenedWatchDog = factory.createGTLRuleWatchDog();
			flattenedWatchDog.setNodeAttribute(flatten(watchDog.getNodeAttribute(), flattenedRule));
			flattenedRule.getWatchDogs().add(flattenedWatchDog);
		}
	}

	protected SlimRuleNodeMappings flatten(SlimRule sourceRule, SlimRule targetRule, SlimRuleNodeMappings mappings) {
		SlimRuleNodeMappings flattenedMappings = superFactory.createSlimRuleNodeMappings();
		Map<String, SlimRuleNode> srcNodes = rule2nodes.get(sourceRule);
		Map<String, SlimRuleNode> trgNodes = rule2nodes.get(targetRule);
		for (SlimRuleNodeMapping mapping : mappings.getMappings()) {
			SlimRuleNodeMapping flattenedMapping = superFactory.createSlimRuleNodeMapping();
			if (srcNodes.containsKey(mapping.getSource().getName())) {
				flattenedMapping.setSource(srcNodes.get(mapping.getSource().getName()));
			} else {
				addPendingNodeConsumer(sourceRule.getName(), mapping.getSource().getName(), (node) -> {
					flattenedMapping.setSource(node);
				});
			}
			if (trgNodes.containsKey(mapping.getTarget().getName())) {
				flattenedMapping.setTarget(trgNodes.get(mapping.getTarget().getName()));
			} else {
				addPendingNodeConsumer(targetRule.getName(), mapping.getTarget().getName(), (node) -> {
					flattenedMapping.setTarget(node);
				});
			}
		}
		return flattenedMappings;
	}

	protected BooleanExpression flatten(BooleanExpression expression, SlimRule container) throws Exception {
		if (expression instanceof BooleanImplication impl) {
			BooleanImplication flattenedImpl = superFactory.createBooleanImplication();
			flattenedImpl.setLeft(flatten(impl.getLeft(), container));
			flattenedImpl.setRight(flatten(impl.getRight(), container));
			return flattenedImpl;
		} else if (expression instanceof BooleanDisjunction disj) {
			BooleanDisjunction flattenedDisj = superFactory.createBooleanDisjunction();
			flattenedDisj.setOperator(disj.getOperator());
			flattenedDisj.setLeft(flatten(disj.getLeft(), container));
			flattenedDisj.setRight(flatten(disj.getRight(), container));
			return flattenedDisj;
		} else if (expression instanceof BooleanConjunction conj) {
			BooleanConjunction flattenedConj = superFactory.createBooleanConjunction();
			flattenedConj.setOperator(conj.getOperator());
			flattenedConj.setLeft(flatten(conj.getLeft(), container));
			flattenedConj.setRight(flatten(conj.getRight(), container));
			return flattenedConj;
		} else if (expression instanceof BooleanNegation neg) {
			BooleanNegation flattenedNeg = superFactory.createBooleanNegation();
			flattenedNeg.setOperand(flatten(neg.getOperand(), container));
			return flattenedNeg;
		} else if (expression instanceof BooleanBracket brack) {
			BooleanBracket flattenedBrack = superFactory.createBooleanBracket();
			flattenedBrack.setOperand(flatten(brack.getOperand(), container));
			return flattenedBrack;
		} else if (expression instanceof ValueExpression val) {
			return flatten(val, container);
		} else if (expression instanceof RelationalExpression rel) {
			RelationalExpression flattenedRel = superFactory.createRelationalExpression();
			flattenedRel.setRelation(rel.getRelation());
			flattenedRel.setLhs(flatten(rel.getLhs(), container));
			flattenedRel.setRhs(flatten(rel.getRhs(), container));
			return flattenedRel;
		} else {
			throw new UnsupportedOperationException("Unkown arithmetic operation type: " + expression);
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
				flattenedOperand.setOperand(flatten(nae, container));
			} else if (op.getOperand() instanceof GTLIteratorAttributeExpression nae) {
				flattenedOperand.setOperand(EcoreUtil.copy(nae));
			} else if (op.getOperand() instanceof GTLParameterExpression param) {
				GTLParameterExpression flattenedParam = factory.createGTLParameterExpression();
				Map<String, SlimParameter> name2Parameter = rule2parameters.get(container);
				flattenedParam.setParameter(name2Parameter.get(param.getParameter().getName()));
				flattenedOperand.setOperand(flattenedParam);
			} else if (op.getOperand() instanceof CountExpression count) {
				SlimRule invokee = (SlimRule) count.getSupportPattern();
				CountExpression flattenedCount = superFactory.createCountExpression();
				if (name2rule.containsKey(invokee.getName())) {
					flattenedCount.setSupportPattern(name2rule.get(invokee.getName()));
					flattenedCount
							.setMappings(flatten(container, name2rule.get(invokee.getName()), count.getMappings()));
					flattenedOperand.setOperand(flattenedCount);
				} else {
					addPendingRuleConsumer(invokee.getName(), (rule) -> {
						flattenedCount.setSupportPattern(rule);
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

	protected NodeAttributeExpression flatten(NodeAttributeExpression expression, SlimRule container) {
		NodeAttributeExpression flattenedNAE = superFactory.createNodeAttributeExpression();
		NodeExpression flattenedNode = superFactory.createNodeExpression();
		flattenedNAE.setNodeExpression(flattenedNode);
		flattenedNAE.setFeature(expression.getFeature());
		Map<String, SlimRuleNode> name2Node = rule2nodes.get(container);
		if (name2Node.containsKey(expression.getNodeExpression().getNode().getName())) {
			flattenedNode.setNode(name2Node.get(expression.getNodeExpression().getNode().getName()));
		} else {
			addPendingNodeConsumer(container.getName(), expression.getNodeExpression().getNode().getName(),
					(node) -> flattenedNode.setNode(node));
		}

		return flattenedNAE;
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
