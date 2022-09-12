/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.gtl.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleAttributeAssignment;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeContext;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNodeCreation;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.common.slimgt.util.SlimGTWorkspaceUtils;
import org.emoflon.ibex.common.slimgt.validation.SlimGTValidatorUtils;
import org.emoflon.ibex.gt.gtl.gTL.EditorFile;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleNodeDeletion;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinement;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleRefinementAliased;
import org.emoflon.ibex.gt.gtl.gTL.GTLRuleType;
import org.emoflon.ibex.gt.gtl.gTL.PackageDeclaration;
import org.emoflon.ibex.gt.gtl.gTL.PatternImport;
import org.emoflon.ibex.gt.gtl.gTL.SlimParameter;
import org.emoflon.ibex.gt.gtl.gTL.SlimRule;
import org.emoflon.ibex.gt.gtl.gTL.SlimRuleNode;
import org.emoflon.ibex.gt.gtl.util.GTLModelUtil;

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
		IProject currentProject = SlimGTWorkspaceUtils.getCurrentProject(context.eResource());
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

		IProject currentProject = SlimGTWorkspaceUtils.getCurrentProject(ef.eResource());
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
			SlimGTWorkspaceUtils.gatherFilesWithEnding(gtFiles, projectFile, ".gtl", true);

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

		if (SlimGTValidatorUtils.RULE_NAME_BACKLIST.contains(rule.getName())) {
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

		if (!((SlimRuleNode) node.getCreation()).isRefining())
			return;

		SlimRuleNode superNode = ((SlimRuleNode) node.getCreation()).getRefinement().getRefinementNode();
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

		if (!((SlimRuleNode) node.getContext()).isRefining())
			return;

		if (((SlimRuleNode) node.getContext()).getRefinement() == null)
			return;

		if (((SlimRuleNode) node.getContext()).getRefinement().getRefinementNode() == null)
			return;

		SlimRuleNode superNode = ((SlimRuleNode) node.getContext()).getRefinement().getRefinementNode();
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

		if (!node.getDeletion().isRefining())
			return;

		SlimRuleNode superNode = node.getDeletion().getRefinement().getRefinementNode();
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
		long nodeCount = currentRule.getContextNodes().stream().map(n -> n.getContext())
				.filter(n -> n.getName() != null).filter(n -> n.getName().equals(node.getName())).count();
		nodeCount += currentRule.getDeletedNodes().stream().map(n -> n.getDeletion()).filter(n -> n.getName() != null)
				.filter(n -> n.getName().equals(node.getName())).count();
		nodeCount += currentRule.getCreatedNodes().stream().map(n -> n.getCreation()).filter(n -> n.getName() != null)
				.filter(n -> n.getName().equals(node.getName())).count();

		if (nodeCount > 1) {
			error(String.format("The node name '%s' may not be defined more than once within this pattern.",
					node.getName()), SlimGTPackage.Literals.SLIM_RULE_NODE__NAME);
		}
	}

	// Arithmetic Expession Checks

	@Check
	protected void parameterOnlyInAssignment(GTLParameterExpression paramExpression) {
		SlimRuleAttributeAssignment assignment = SlimGTModelUtil.getContainer(paramExpression,
				SlimRuleAttributeAssignment.class);
		if (assignment == null) {
			error("Parameter expressions may only be used in attribute assignments.",
					GTLPackage.Literals.GTL_PARAMETER_EXPRESSION__PARAMETER);
		}
	}
}
