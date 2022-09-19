/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdge;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleEdgeCreation;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleInvocation;
import org.emoflon.ibex.common.slimgt.slimGT.ValueExpression;
import org.emoflon.ibex.common.slimgt.util.SlimGTArithmeticUtil;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtil;
import org.emoflon.ibex.common.slimgt.validation.DataTypeParseResult;
import org.emoflon.ibex.common.slimgt.validation.SlimGTValidatorUtil;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.ExpressionOperand;
import org.emoflon.ibex.gt.gtl.gTL.GTLEdgeIterator;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleEdgeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementAliased;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleType;
import org.emoflon.ibex.gt.gtl.gTL.PackageDeclaration;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimParameter;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeContext;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNodeCreation;
import org.emoflon.ibex.gt.gtl.util.GTLModelUtil;
import org.emoflon.ibex.gt.gtl.util.RuleNodeHierarchy;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class GTLValidator extends AbstractGTLValidator {

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

	@Check
	public void packageValid(PackageDeclaration pkg) {
		if (pkg.getName() == null || pkg.getName().isBlank()) {
			error("Package name must not be empty!", GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
			return;
		}

		if (pkg.getName().contains(" ")) {
			error("Package name may not contain any white spaces.", GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
		}

		if (pkg.getName().contains("\\")) {
			error("Package name may not contain any slashes.", GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
		}

		if (pkg.getName().contains("/")) {
			error("Package name may not contain any slashes.", GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
		}

		StringBuilder sb = new StringBuilder();

		if (pkg.getName().chars().filter(c -> Character.isUpperCase(c)).map(c -> {
			sb.append((char) c + " ");
			return c;
		}).findAny().isPresent()) {
			error("Package name may not contain any upper case letters. The following illegal characters were found: "
					+ sb.toString(), GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
		}

		if (pkg.getName().chars().filter(c -> !(Character.isLetter(c) || Character.isDigit(c) || c == '.' || c == '"'))
				.map(c -> {
					sb.append((char) c + " ");
					return c;
				}).findAny().isPresent()) {
			error("Package name may not contain any characters other than lower case letters, digits or dots. The following illegal characters were found: "
					+ sb.toString(), GTLPackage.Literals.PACKAGE_DECLARATION__NAME);
		}
	}

	@Check
	public void checkImportUriExists(PatternImport imp) {
		if (imp.getFile() == null || imp.getFile().getValue() == null || imp.getFile().getValue().isBlank())
			return;

		Optional<EditorFile> optFile = loadGTLModelByImport(imp);
		if (!optFile.isPresent()) {
			error("Import path <" + imp.getFile().getValue() + "> is not valid.",
					GTLPackage.Literals.PATTERN_IMPORT__FILE);
		}

	}

	/**
	 * Pattern names must be unique.
	 */
	@Check
	public void checkImportNameUnique(PatternImport pImport) {
		if (!pImport.isImportingAll() && (pImport.getPattern() == null || pImport.getPattern().getName() == null))
			return;

		EditorFile ef = SlimGTModelUtil.getContainer(pImport, EditorFile.class);
		Collection<EditorFile> pkgScope = loadAllEditorFilesInPackage(ef);

		Set<String> presentNamesAndImports = ef.getRules().stream().filter(p -> p != null && p.getName() != null)
				.map(r -> r.getName()).collect(Collectors.toSet());
		presentNamesAndImports.addAll(ef.getImportedPatterns().stream().filter(p -> !pImport.equals(p)).filter(
				p -> p != null && !p.isImportingAll() && p.getPattern() != null && p.getPattern().getName() != null)
				.map(p -> p.getPattern().getName()).collect(Collectors.toSet()));
		presentNamesAndImports.addAll(pkgScope.stream().flatMap(file -> file.getRules().stream()).map(r -> r.getName())
				.collect(Collectors.toSet()));

		if (!pImport.isImportingAll()) {
			if (pImport.getPattern() == null)
				return;

			if (presentNamesAndImports.contains(pImport.getPattern().getName()))
				error(String.format("Pattern/rule '%s' must not be declared more than once.",
						pImport.getPattern().getName()), GTLPackage.Literals.PATTERN_IMPORT__PATTERN);
		} else {
			Optional<EditorFile> optFile = loadGTLModelByImport(pImport);
			if (!optFile.isPresent()) // This will be checked somewhere else.
				return;

			Set<String> importedNames = optFile.get().getRules().stream().map(r -> r.getName())
					.collect(Collectors.toSet());

			for (String importedRule : importedNames) {
				if (presentNamesAndImports.contains(importedRule))
					error(String.format("Pattern/rule '%s' must not be declared more than once.", importedRule),
							GTLPackage.Literals.PATTERN_IMPORT__PATTERN);
			}
		}
	}

	/**
	 * Pattern names must be unique.
	 */
	@Check
	public void checkNumbeOfImportedMetamodels(PatternImport pImport) {
//		if (!pImport.isImportingAll() && (pImport.getPattern() == null || pImport.getPattern().getName() == null))
//			return;

		// TODO: Fixme -> Make an exception for the EcorePackage metamodel

//		Set<EditorFile> importedGTLFiles = new HashSet<>();
//		importedGTLFiles.addAll(loadAllEditorFilesInPackage(ef));

	}

	@Check
	protected void checkOnlyOneMetamodelImport(Import imp) {
//		EditorFile ef = SlimGTModelUtil.getContainer(imp, EditorFile.class);
//		if(ef.getImports().size() > 1) {
//			error("Pattern/rule '%s' must not be declared more than once.", SlimGTPackage.Literals.IMPORT__NAME);
//		}
		// TODO: Fixme -> Make an exception for the EcorePackage metamodel
	}

	// Rulew Checks

	@Check
	protected void checkRuleNameForbidden(SlimRule rule) {
		if (rule.getName() == null)
			return;

		if (SlimGTValidatorUtil.RULE_NAME_BACKLIST.contains(rule.getName())) {
			error(String.format("Pattern/rule '%s' is a java keyword or an emf class and, hence, forbidden.",
					rule.getName()), GTLPackage.Literals.SLIM_RULE__NAME);
		}
	}

	@Check
	protected void checkRuleNameInvalidSymbols(SlimRule rule) {
		if (rule.getName() == null) {
			error("Pattern/rule name may not be null.", GTLPackage.Literals.SLIM_RULE__NAME);
			return;
		}

		if (rule.getName().isBlank()) {
			error("Pattern/rule name must not be empty!", GTLPackage.Literals.SLIM_RULE__NAME);
			return;
		}

		if (rule.getName().contains(" ")) {
			error("Pattern/rule name may not contain any white spaces.", GTLPackage.Literals.SLIM_RULE__NAME);
		}

		if (rule.getName().contains("\\")) {
			error("Pattern/rule name may not contain any slashes.", GTLPackage.Literals.SLIM_RULE__NAME);
		}

		if (rule.getName().contains("/")) {
			error("Pattern/rule name may not contain any slashes.", GTLPackage.Literals.SLIM_RULE__NAME);
		}

		StringBuilder sb = new StringBuilder();

		if (rule.getName().chars().filter(c -> !(Character.isLetter(c) || Character.isDigit(c))).map(c -> {
			sb.append((char) c + " ");
			return c;
		}).findAny().isPresent()) {
			error("Pattern/rule name may not contain any characters other than letters, digits. The following illegal characters were found: "
					+ sb.toString(), GTLPackage.Literals.SLIM_RULE__NAME);
		}
	}

	@Check
	protected void checkRuleNameUnique(SlimRule rule) {
		if (rule.getName() == null) // This will be checked somewhere else.
			return;

		EditorFile ef = SlimGTModelUtil.getContainer(rule, EditorFile.class);
		Collection<EditorFile> pkgScope = loadAllEditorFilesInPackage(ef);

		Set<String> presentNamesAndImports = ef.getRules().stream().filter(p -> p != null && p.getName() != null)
				.filter(p -> !rule.equals(p)).map(r -> r.getName()).collect(Collectors.toSet());
		presentNamesAndImports.addAll(ef.getImportedPatterns().stream().filter(
				p -> p != null && !p.isImportingAll() && p.getPattern() != null && p.getPattern().getName() != null)
				.map(p -> p.getPattern().getName()).collect(Collectors.toSet()));
		presentNamesAndImports.addAll(pkgScope.stream().flatMap(file -> file.getRules().stream()).map(r -> r.getName())
				.collect(Collectors.toSet()));

		if (presentNamesAndImports.contains(rule.getName()))
			error(String.format("Pattern/rule '%s' must not be declared more than once.", rule.getName()),
					GTLPackage.Literals.SLIM_RULE__NAME);
	}

	// Parameter Checks

	@Check
	protected void checkParameterUnique(SlimParameter parameter) {
		if (parameter.getName() == null)
			return;

		SlimRule currentRule = SlimGTModelUtil.getContainer(parameter, SlimRule.class);
		long paramCount = GTLModelUtil.getAllParameters(currentRule).stream()
				.filter(param -> param.getName().equals(parameter.getName())).count();

		if (paramCount > 1) {
			error(String.format("Parameter '%s' must not be declared more than once.", parameter.getName()),
					SlimGTPackage.Literals.SLIM_PARAMETER__NAME);
		}
	}

	// Refinement Checks

	@Check
	protected void checkRefinementsUnique(GTLRuleRefinement refinement) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(refinement, SlimRule.class);

		Optional<SlimRule> superRule = GTLModelUtil.refinementToRule(refinement);
		if (!superRule.isPresent())
			return;

		long refinementCount = GTLModelUtil.getAllSuperRules(currentRule).stream()
				.filter(rule -> rule.getName().equals(superRule.get().getName())).count();

		if (refinementCount > 1) {
			error(String.format("The rule/pattern '%s' may not be refined more than once.", superRule.get().getName()),
					GTLPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE);
		}
	}

	@Check
	protected void checkRefinementAliasesUnique(GTLRuleRefinementAliased refinement) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(refinement, SlimRule.class);

		if (refinement.getName() == null)
			return;

		long refinementCount = GTLModelUtil.getAllSuperRules(currentRule).stream()
				.filter(rule -> rule.getName().equals(refinement.getName())).count();

		if (refinementCount > 1) {
			error(String.format("The refinement alias '%s' collides with a super pattern/rule name.",
					refinement.getName()), GTLPackage.Literals.GTL_RULE_REFINEMENT_ALIASED__NAME);
		}

		refinementCount = currentRule.getRefinement().stream().filter(ref -> (ref instanceof GTLRuleRefinementAliased))
				.map(ref -> (GTLRuleRefinementAliased) ref).filter(ref -> ref.getName().equals(refinement.getName()))
				.count();

		if (refinementCount > 1) {
			error(String.format("The refinement alias '%s' collides with another refinement alias.",
					refinement.getName()), GTLPackage.Literals.GTL_RULE_REFINEMENT_ALIASED__NAME);
		}
	}

	@Check
	protected void checkRefinementFitsGTRuleType(GTLRuleRefinement refinement) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(refinement, SlimRule.class);

		Optional<SlimRule> superRule = GTLModelUtil.refinementToRule(refinement);
		if (!superRule.isPresent())
			return;

		if (currentRule.getType() == GTLRuleType.PATTERN && superRule.get().getType() == GTLRuleType.RULE) {
			error(String.format("The a pattern may not refine a rule ('%s').", superRule.get().getName()),
					GTLPackage.Literals.GTL_RULE_REFINEMENT__SUPER_RULE);
		}

	}

	// Rule node Checks

	@Check
	protected void checkRuleNodeOperationFitsGTRuleType(SlimRuleNodeCreation node) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(node, SlimRule.class);
		if (node.getCreation() == null)
			return;

		if (node.getCreation().getName() == null)
			return;

		if (currentRule.getType() == GTLRuleType.PATTERN) {
			error(String.format("A pattern may not define a node creation ('%s').", node.getCreation().getName()),
					SlimGTPackage.Literals.SLIM_RULE_NODE_CREATION__CREATION);
		}

	}

	@Check
	protected void checkRuleNodeOperationFitsGTRuleType(GTLRuleNodeDeletion node) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(node, SlimRule.class);
		if (node.getDeletion() == null)
			return;

		if (node.getDeletion().getName() == null)
			return;

		if (currentRule.getType() == GTLRuleType.PATTERN) {
			error(String.format("A pattern may not define a node deletion ('%s').", node.getDeletion().getName()),
					GTLPackage.Literals.GTL_RULE_NODE_DELETION__DELETION);
		}

	}

	@Check
	protected void checkRuleNodeOperationFitsGTRuleType(SlimRuleAttributeAssignment assignment) {
		SlimRule currentRule = SlimGTModelUtil.getContainer(assignment, SlimRule.class);

		if (currentRule.getType() == GTLRuleType.PATTERN) {
			error("A pattern may not define an attribute assignment.",
					SlimGTPackage.Literals.SLIM_RULE_NODE__ASSIGNMENTS);
		}

	}

	@Check
	protected void checkRuleNodeOperationFitsSuperNode(SlimRuleNodeCreation node) {
		if (node.getCreation() == null)
			return;

		if (!node.isRefining())
			return;

		SlimRuleNode superNode = node.getRefinement().getRefinementNode();
		SlimRuleNodeCreation superCreation = SlimGTModelUtil.getContainer(superNode, SlimRuleNodeCreation.class);

		if (superCreation == null) {
			error("A node creation may only refine another node creation.", superCreation,
					SlimGTPackage.Literals.SLIM_RULE__CREATED_NODES);
		}

	}

	@Check
	protected void checkRuleNodeOperationFitsSuperNode(SlimRuleNodeContext node) {
		if (node.getContext() == null)
			return;

		if (!node.isRefining())
			return;

		if (node.getRefinement() == null)
			return;

		if (node.getRefinement().getRefinementNode() == null)
			return;

		SlimRuleNode superNode = node.getRefinement().getRefinementNode();
		SlimRuleNodeContext superContext = SlimGTModelUtil.getContainer(superNode, SlimRuleNodeContext.class);

		if (superContext == null) {
			error("A context node may only refine another context node.", superContext,
					SlimGTPackage.Literals.SLIM_RULE_NODE__CONTEXT_EDGES);
		}

	}

	@Check
	protected void checkRuleNodeOperationFitsSuperNode(GTLRuleNodeDeletion node) {
		if (node.getDeletion() == null)
			return;

		if (!node.isRefining())
			return;

		SlimRuleNode superNode = node.getRefinement().getRefinementNode();
		GTLRuleNodeDeletion superDeletion = SlimGTModelUtil.getContainer(superNode, GTLRuleNodeDeletion.class);

		if (superDeletion == null) {
			error("A node deletion may only refine another node deletion.", superDeletion,
					GTLPackage.Literals.SLIM_RULE__DELETED_NODES);
		}

	}

	@Check
	protected void checkRuleNodeNameUnique(SlimRuleNode node) {
		if (node.getName() == null)
			return;

		SlimRule currentRule = SlimGTModelUtil.getContainer(node, SlimRule.class);
		long nodeCount = GTLModelUtil.getAllRuleNodes(currentRule).stream().filter(n -> n != null)
				.filter(n -> n.getName() != null).filter(n -> n.getName().equals(node.getName())).count();

		if (nodeCount > 1) {
			error(String.format("The node name '%s' may not be defined more than once within this pattern.",
					node.getName()), SlimGTPackage.Literals.SLIM_RULE_NODE__NAME);
		}
	}

	// Edge checks

	@Check
	protected void checkEdgeOperationUnique(SlimRuleEdgeContext edge) {
		SlimRuleEdge currentEdge = edge.getContext();
		if (isEdgeRedefined(currentEdge)) {
			error(String.format("The edge with type <%s> and and target <%s> may not be defined twice.",
					currentEdge.getType().getName(), currentEdge.getTarget().getName()),
					SlimGTPackage.Literals.SLIM_RULE_EDGE_CONTEXT__CONTEXT);
		}
	}

	@Check
	protected void checkEdgeOperationUnique(SlimRuleEdgeCreation edge) {
		SlimRuleEdge currentEdge = edge.getCreation();
		if (isEdgeRedefined(currentEdge)) {
			error(String.format("The edge with type <%s> and and target <%s> may not be defined twice.",
					currentEdge.getType().getName(), currentEdge.getTarget().getName()),
					SlimGTPackage.Literals.SLIM_RULE_EDGE_CREATION__CREATION);
		}
	}

	@Check
	protected void checkEdgeOperationUnique(GTLRuleEdgeDeletion edge) {
		SlimRuleEdge currentEdge = edge.getDeletion();
		if (isEdgeRedefined(currentEdge)) {
			error(String.format("The edge with type <%s> and and target <%s> may not be defined twice.",
					currentEdge.getType().getName(), currentEdge.getTarget().getName()),
					GTLPackage.Literals.GTL_RULE_EDGE_DELETION__DELETION);
		}
	}

	protected boolean isEdgeRedefined(SlimRuleEdge edge) {
		if (edge.getType() == null || edge.getTarget() == null)
			return false;

		SlimRuleNode currentRuleNode = SlimGTModelUtil.getContainer(edge, SlimRuleNode.class);
		SlimRule currentRule = SlimGTModelUtil.getContainer(edge, SlimRule.class);
		Map<SlimRuleNode, RuleNodeHierarchy> ruleNodeHierarchy = GTLModelUtil.getAllRuleNodeHierarchy(currentRule);
		Collection<SlimRuleEdge> allEdges = GTLModelUtil.getRuleNodeAllEdges(currentRuleNode, ruleNodeHierarchy);
		RuleNodeHierarchy targetHierarchy = ruleNodeHierarchy.get(edge.getTarget());
		if (targetHierarchy == null)
			return false;

		for (SlimRuleEdge other : allEdges) {
			if (edge.equals(other))
				continue;

			if (other.getType() == null || other.getTarget() == null)
				continue;

			if (other.getType().getName().equals(edge.getType().getName())
					&& (other.getTarget().equals(edge.getTarget())
							|| targetHierarchy.superNodes().contains(other.getTarget()))) {
				return true;
			}
		}

		return false;
	}

	// Assignment Checks

	@Check
	protected void checkAssignmentUnique(SlimRuleAttributeAssignment assignment) {
		if (assignment.getType() == null)
			return;

		if (assignment.getType().getName() == null)
			return;

		SlimRuleNode currentRuleNode = SlimGTModelUtil.getContainer(assignment, SlimRuleNode.class);
		Collection<SlimRuleAttributeAssignment> assignments = GTLModelUtil
				.getRuleNodeAllAttributeAssignments(currentRuleNode);
		for (SlimRuleAttributeAssignment other : assignments) {
			if (other.equals(assignment))
				continue;

			if (other.getType() == null)
				continue;

			if (other.getType().getName() == null)
				continue;

			if (other.getType().getName().equals(assignment.getType().getName())) {
				error(String.format("Assignment to attribute <%s> may only happen once per node.",
						assignment.getType().getName()), SlimGTPackage.Literals.SLIM_RULE_ATTRIBUTE_ASSIGNMENT__TYPE);
				return;
			}
		}
	}

	@Check
	protected void checkAssignmentNotInLocal(SlimRuleAttributeAssignment assignment) {
		SlimRuleNodeContext context = SlimGTModelUtil.getContainer(assignment, SlimRuleNodeContext.class);
		if (context != null && context.isLocal()) {
			error("Assignments may only be performed in a non-local node.", context,
					SlimGTPackage.Literals.SLIM_RULE_NODE_CONTEXT__LOCAL);
			return;
		}

	}

	// Invocation Checks

	@Check
	protected void checkSupportPatternNotAbstract(SlimRuleInvocation invocation) {
		if (invocation.getSupportPattern() == null)
			return;

		if (((SlimRule) invocation.getSupportPattern()).isAbstract()) {
			error("Invoked patterns or rules may not be abstract.",
					SlimGTPackage.Literals.SLIM_RULE_INVOCATION__SUPPORT_PATTERN);
		}
	}

	@Check
	protected void checkSupportPatternNoCycle(SlimRuleInvocation invocation) {
		if (invocation.getSupportPattern() == null)
			return;

		SlimRule currentRule = SlimGTModelUtil.getContainer(invocation, SlimRule.class);
		Set<SlimRule> traversedRules = new HashSet<>();
		traversedRules.add(currentRule);

		if (invocationHierarchyHasCycle(invocation, traversedRules)) {
			error("Invoked pattern <%s> leads to an invocation cycle, which is not allowed.",
					SlimGTPackage.Literals.SLIM_RULE_INVOCATION__SUPPORT_PATTERN);
		}
	}

	@Check
	protected void checkCountInvocationInLocal(CountExpression countExpression) {
		SlimRuleNodeContext context = SlimGTModelUtil.getContainer(countExpression, SlimRuleNodeContext.class);
		if (context != null && context.isLocal()) {
			warning("Count expressions in locals nodes will lead to errors when using the democles pattern matcher, since it does not support count expressions natively.",
					context, SlimGTPackage.Literals.SLIM_RULE_NODE_CONTEXT__LOCAL);
			return;
		}
	}

	@Check
	protected void checkCountInvocationNoCycle(CountExpression countExpression) {
		if (countExpression.getInvokedPatten() == null)
			return;

		SlimRule currentRule = SlimGTModelUtil.getContainer(countExpression, SlimRule.class);
		Set<SlimRule> traversedRules = new HashSet<>();
		traversedRules.add(currentRule);

		if (invocationHierarchyHasCycle(countExpression, traversedRules)) {
			error("Count expression: invoked pattern <%s> leads to an invocation cycle, which is not allowed.",
					SlimGTPackage.Literals.COUNT_EXPRESSION__INVOKED_PATTEN);
		}
	}

	@Check
	protected void checkCountInvocationNotInIterator(CountExpression countExpression) {
		GTLEdgeIterator itr = SlimGTModelUtil.getContainer(countExpression, GTLEdgeIterator.class);

		if (itr != null) {
			error("Count pattern <%s> invocations are not allowed within iterator constructs.", itr,
					GTLPackage.Literals.GTL_EDGE_ITERATOR__ITERATOR_ATTRIBUTES);
		}
	}

	protected boolean invocationHierarchyHasCycle(EObject someInvocation, Set<SlimRule> traversedRules) {
		SlimRule invokee = null;
		if (someInvocation instanceof CountExpression countExpression && countExpression.getInvokedPatten() != null) {
			invokee = (SlimRule) countExpression.getInvokedPatten();
		} else if (someInvocation instanceof SlimRuleInvocation ruleInvocation
				&& ruleInvocation.getSupportPattern() != null) {
			invokee = (SlimRule) ruleInvocation.getSupportPattern();
		} else {
			return false;
		}

		if (traversedRules.contains(invokee))
			return true;

		traversedRules.add(invokee);

		// Check for plain invocations
		if (invokee.getInvocations() == null)
			return false;

		for (SlimRuleInvocation other : invokee.getInvocations()) {
			if (invocationHierarchyHasCycle(other, traversedRules)) {
				return true;
			}
		}

		// Check for count invocations
		Collection<CountExpression> countInvocations = GTLModelUtil.getAllCountExpression(invokee);
		for (CountExpression other : countInvocations) {
			if (invocationHierarchyHasCycle(other, traversedRules)) {
				return true;
			}
		}

		return false;

	}

	// Arithmetic Expession Checks

	@Check
	protected void checkAttributeInAssignmentIsNotAssignedTo(NodeAttributeExpression attributeExpression) {
		SlimRuleNode node = (SlimRuleNode) attributeExpression.getNode();
		EAttribute attribute = attributeExpression.getFeature();

		if (node == null || attribute == null)
			return;

		SlimRuleNode ownNode = SlimGTModelUtil.getContainer(attributeExpression, SlimRuleNode.class);
		SlimRuleAttributeAssignment assignment = SlimGTModelUtil.getContainer(attributeExpression,
				SlimRuleAttributeAssignment.class);
		// If the attribute expression is not part of an assignment -> no problem
		if (assignment == null)
			return;

		// Attributes that get values assigned to themselves may not be part of other
		// assignments, except for their own assignments to allow for increments,
		// but only once.
		if (node.equals(ownNode) && attribute.getName().equals(assignment.getType().getName()))
			return;

		SlimRule currentRule = SlimGTModelUtil.getContainer(ownNode, SlimRule.class);
		Collection<SlimRuleAttributeAssignment> allAssignments = GTLModelUtil.getAllAttributeAssignments(currentRule);
		for (SlimRuleAttributeAssignment other : allAssignments) {
			if (other.equals(assignment))
				continue;

			SlimRuleNode otherNode = SlimGTModelUtil.getContainer(other, SlimRuleNode.class);
			if (otherNode.equals(node) && other.getType() != null && other.getType().getName() != null
					&& other.getType().getName().equals(attribute.getName())) {
				error(String.format(
						"References to attributes within attribute assignment calculations that are themselves subject to an assignment are not permitted.",
						assignment.getType().getName()), SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE);
				return;
			}

		}
	}

	@Check
	protected void checkParameterOnlyInAssignment(GTLParameterExpression paramExpression) {
		SlimRuleAttributeAssignment assignment = SlimGTModelUtil.getContainer(paramExpression,
				SlimRuleAttributeAssignment.class);
		if (assignment == null) {
			error("Parameter expressions may only be used in attribute assignments.",
					GTLPackage.Literals.GTL_PARAMETER_EXPRESSION__PARAMETER);
		}
	}

	@Check
	protected void checkValueExpressionInLocal(ValueExpression valueExpression) {
		SlimRuleNodeContext context = SlimGTModelUtil.getContainer(valueExpression, SlimRuleNodeContext.class);
		if (context != null && context.isLocal() && !(valueExpression instanceof ExpressionOperand)) {
			warning("Arithmetic expressions in locals nodes will lead to errors when using the democles pattern matcher, since it does not support arithmetic expressions natively.",
					context, SlimGTPackage.Literals.SLIM_RULE_NODE_CONTEXT__LOCAL);
			return;
		}
	}

	@Override
	protected DataTypeParseResult getDataTypeConflicts(ArithmeticExpression expr) throws Exception {
		return SlimGTArithmeticUtil.parseDominantDataType(expr);
	}
}
