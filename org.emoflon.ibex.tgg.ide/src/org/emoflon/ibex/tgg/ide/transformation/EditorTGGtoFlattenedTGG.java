package org.emoflon.ibex.tgg.ide.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.tgg.mosl.tgg.AttrCond;
import org.moflon.tgg.mosl.tgg.AttributeAssignment;
import org.moflon.tgg.mosl.tgg.AttributeConstraint;
import org.moflon.tgg.mosl.tgg.AttributeExpression;
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.CorrType;
import org.moflon.tgg.mosl.tgg.CorrVariablePattern;
import org.moflon.tgg.mosl.tgg.EnumExpression;
import org.moflon.tgg.mosl.tgg.Expression;
import org.moflon.tgg.mosl.tgg.LinkVariablePattern;
import org.moflon.tgg.mosl.tgg.LiteralExpression;
import org.moflon.tgg.mosl.tgg.Nac;
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.OperatorPattern;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.TggFactory;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;

/**
 *	Provides flattening of rule refinements for {@linkplain TripleGraphGrammarFile}s.
 */
public class EditorTGGtoFlattenedTGG {

	private static final Logger logger = Logger.getLogger(EditorTGGtoFlattenedTGG.class);
	
	private Map<Set<Rule>, Rule> superRuleMap;
	private Map<String, ObjectVariablePattern> sourcePatterns;
	private Map<String, ObjectVariablePattern> targetPatterns;
	private Map<String, CorrVariablePattern> corrPatterns;

	/**
	 * Produces a flattened {@linkplain TripleGraphGrammarFile} from a given non-flattened TripleGraphGrammarFile.
	 * 
	 * @param tgg The TripleGraphGrammarFile that shall be flattened.
	 * @return The flattened TripleGraphGrammarFile.
	 */
	public Optional<TripleGraphGrammarFile> flatten(TripleGraphGrammarFile tgg) {
		try {
			TripleGraphGrammarFile flattened = EcoreUtil.copy(tgg);
			EList<Rule> rules = flattened.getRules();

			superRuleMap = new HashMap<Set<Rule>, Rule>();
			rules.stream().forEach(r -> superRuleMap.put(this.findSuperRules(r), r));

			List<Rule> newRules = superRuleMap.keySet().stream().map(this::merge).collect(Collectors.toList());

			rules.clear();
			sort(newRules);
			rules.addAll(newRules);

			cleanUpNACsIfPossible(flattened);
			cleanUpDuplicateAttributeConditions(flattened);

			return Optional.of(flattened);
		} catch (Exception e) {
			logger.error("Unable to flatten " + tgg);
			return Optional.empty();
		}
	}
	
	private void cleanUpDuplicateAttributeConditions(TripleGraphGrammarFile tgg) {
		for (Rule rule : tgg.getRules()) {
			cleanUpDuplicateConditions(rule.getSourcePatterns());
			cleanUpDuplicateConditions(rule.getTargetPatterns());
		}
	}

	private void cleanUpDuplicateConditions(EList<ObjectVariablePattern> patterns) {
		for (ObjectVariablePattern pattern : patterns) {
			ArrayList<AttributeAssignment> duplicateAssigns = new ArrayList<>();
			ArrayList<AttributeConstraint> duplicateConstrs = new ArrayList<>();

			for (AttributeAssignment assign : pattern.getAttributeAssignments()) {
				if(!duplicateAssigns.contains(assign)) {
				duplicateAssigns.addAll(
						pattern.getAttributeAssignments()
							.stream()
							.filter(a -> !a.equals(assign) && identical(a, assign))
							.collect(Collectors.toList())
						);
				}
			}
			
			for (AttributeConstraint constr : pattern.getAttributeConstraints()) {
				if(!duplicateConstrs.contains(constr)) {
					duplicateConstrs.addAll(
						pattern.getAttributeConstraints()
							.stream()
							.filter(a -> !a.equals(constr) && identical(a, constr))
							.collect(Collectors.toList())
						);
				}
			}
			
			pattern.getAttributeAssignments().removeAll(duplicateAssigns);
			pattern.getAttributeConstraints().removeAll(duplicateConstrs);
		}
	}

	private boolean identical(AttributeConstraint c, AttributeConstraint constr) {
		if(!c.getOp().equals(constr.getOp())) return false;
		if(!c.getAttribute().equals(constr.getAttribute())) return false;
		return identical(c.getValueExp(), constr.getValueExp());
	}

	private boolean identical(Expression v1, Expression v2) {
		if(v1 instanceof LiteralExpression && v2 instanceof LiteralExpression) {
			LiteralExpression lv1 = (LiteralExpression) v1;
			LiteralExpression lv2 = (LiteralExpression) v2;
			return lv1.getValue().equals(lv2.getValue());
		}
		
		if(v1 instanceof EnumExpression && v2 instanceof EnumExpression) {
			EnumExpression ev1 = (EnumExpression) v1;
			EnumExpression ev2 = (EnumExpression) v2;
			return ev1.getLiteral().equals(ev2.getLiteral());
		}
		
		return false;
	}

	private boolean identical(AttributeAssignment a, AttributeAssignment assign) {
		if(!a.getOp().equals(assign.getOp())) return false;
		if(!a.getAttribute().equals(assign.getAttribute())) return false;
		return identical(a.getValueExp(), assign.getValueExp());
	}

	private void cleanUpNACsIfPossible(TripleGraphGrammarFile flattened) {
		for (Nac nac : flattened.getNacs()) {
			Rule oldRule = nac.getRule();
			Optional<Rule> newRule = flattened.getRules().stream()
											   .filter(r -> r.getName().equals(oldRule.getName()))
											   .findAny();
			newRule.ifPresent(r -> nac.setRule(r));
		}
	}

	public void sort(List<Rule> rules) {
		rules.sort(Comparator.comparing(rule -> ((Rule)rule).getName()));
		
		for (Rule rule : rules) {			
			List<ObjectVariablePattern> sourcePatterns = new ArrayList<ObjectVariablePattern>(rule.getSourcePatterns());
			List<ObjectVariablePattern> targetPatterns = new ArrayList<ObjectVariablePattern>(rule.getTargetPatterns());
			List<CorrVariablePattern> corrPatterns = new ArrayList<CorrVariablePattern>(rule.getCorrespondencePatterns());
			List<AttrCond> attrConditions = new ArrayList<AttrCond>(rule.getAttrConditions());
			
			sourcePatterns.sort(Comparator.comparing(pattern -> ((ObjectVariablePattern)pattern).getName()));
			targetPatterns.sort(Comparator.comparing(pattern -> ((ObjectVariablePattern)pattern).getName()));
			corrPatterns.sort(Comparator.comparing(pattern -> ((CorrVariablePattern)pattern).getName()));
			attrConditions.sort(Comparator.comparing(cond -> ((AttrCond)cond).getName().getName()));
			
			rule.getSourcePatterns().clear();
			rule.getTargetPatterns().clear();
			rule.getCorrespondencePatterns().clear();
			rule.getAttrConditions().clear();
			
			rule.getSourcePatterns().addAll(sourcePatterns);
			rule.getTargetPatterns().addAll(targetPatterns);
			rule.getCorrespondencePatterns().addAll(corrPatterns);
			rule.getAttrConditions().addAll(attrConditions);
		}
	}
	
	
	/**
	 * Produces a flattened version of a {@link Rule}.
	 * 
	 * @param r The Rule that shall be flattened.
	 * @param tgg The {@link TripleGraphGrammarFile} that contains this Rule.
	 * @return The flattened Rule.
	 */
	public Rule flattenRule(Rule r, TripleGraphGrammarFile tgg) {
		superRuleMap = new HashMap<Set<Rule>, Rule>();
		Set<Rule> superRules = this.findSuperRules(r);
		superRuleMap.put(superRules, r);
		return this.merge(superRules);
	}
	
	private Set<Rule> findSuperRules(Rule rule) {
		List<Rule> superRules = new ArrayList<Rule>();
		superRules.add(rule);
		
		for (int i = 0; i < superRules.size(); i++) {
			EList<Rule> newSuperTypes = superRules.get(i).getSupertypes();
			for (Rule r : newSuperTypes) {
				if (!superRules.contains(r)) {
					superRules.add(r);
				}
			}
		}
		
		return new HashSet<Rule>(superRules);
	}
	
	private Rule merge(Set<Rule> rules) {
		Rule ruleToMerge = superRuleMap.get(rules);
		Rule mergedRule = TggFactory.eINSTANCE.createRule();
		
		getFile(ruleToMerge).getRules().add(mergedRule);
		
		mergedRule.setAbstractRule(ruleToMerge.isAbstractRule());
		mergedRule.setName(ruleToMerge.getName());
		mergedRule.setSchema(ruleToMerge.getSchema());
		getFile(mergedRule).getImports().addAll(getFile(ruleToMerge).getImports());
		getFile(mergedRule).getUsing().addAll(getFile(ruleToMerge).getUsing());
		
		// create "co-product" of the rules in mergedRule
		for (Rule r : rules) {
			mergedRule.getSourcePatterns().addAll(EcoreUtil.copyAll(r.getSourcePatterns()));
			mergedRule.getTargetPatterns().addAll(EcoreUtil.copyAll(r.getTargetPatterns()));
			mergedRule.getCorrespondencePatterns().addAll(EcoreUtil.copyAll(r.getCorrespondencePatterns()));
			mergedRule.getAttrConditions().addAll(EcoreUtil.copyAll(r.getAttrConditions()));
		}
		
		// "glue" by finding equivalence classes of patterns and merging each class into one pattern
		mergeSourcePatterns(mergedRule.getSourcePatterns());
		mergedRule.getSourcePatterns().clear();
		mergedRule.getSourcePatterns().addAll(sourcePatterns.values());
		
		mergeTargetPatterns(mergedRule.getTargetPatterns());
		mergedRule.getTargetPatterns().clear();
		mergedRule.getTargetPatterns().addAll(targetPatterns.values());
		
		mergeCorrPatterns(mergedRule.getCorrespondencePatterns());
		mergedRule.getCorrespondencePatterns().clear();
		mergedRule.getCorrespondencePatterns().addAll(corrPatterns.values());
		
		// update all references to point to the correct copy in the flattened TGG
		cleanupReferences(mergedRule);
		
		return mergedRule;
	}

	private TripleGraphGrammarFile getFile(Rule rule) {
		return (TripleGraphGrammarFile) rule.eContainer();
	}

	private void mergeSourcePatterns(Collection<ObjectVariablePattern> patterns) {
		sourcePatterns = new HashMap<String, ObjectVariablePattern>();

		for (ObjectVariablePattern pattern : patterns) {
			if (!sourcePatterns.containsKey(pattern.getName())) {
				sourcePatterns.put(pattern.getName(), pattern);
			} else {
				mergeTwoObjectPatterns(pattern, sourcePatterns.get(pattern.getName()));
			}
		}
	}
	
	private void mergeTargetPatterns(Collection<ObjectVariablePattern> patterns) {
		targetPatterns = new HashMap<String, ObjectVariablePattern>();

		for (ObjectVariablePattern pattern : patterns) {
			if (!targetPatterns.containsKey(pattern.getName())) {
				targetPatterns.put(pattern.getName(), pattern);
			} else {
				mergeTwoObjectPatterns(pattern, targetPatterns.get(pattern.getName()));
			}
		}
	}
	
	private void mergeTwoObjectPatterns(ObjectVariablePattern from, ObjectVariablePattern to) {
		// Types
		if (to.getType().isSuperTypeOf(from.getType())) {
			to.setType(from.getType());
		}
		
		// Operator   
		mergeOperators(from, to);

		// Link Variable Pattern	
		for (LinkVariablePattern fromEdge : from.getLinkVariablePatterns()) {
			boolean matchingEdgeFound = false;
			for (LinkVariablePattern toEdge : to.getLinkVariablePatterns()) {
				if (fromEdge.getTarget().getName().equals(toEdge.getTarget().getName()) && fromEdge.getType() == toEdge.getType()) {
					matchingEdgeFound = true;
					// Operator 
					mergeOperators(fromEdge, toEdge);
					break;
				}
			}
			if (!matchingEdgeFound) {
				to.getLinkVariablePatterns().add(EcoreUtil.copy(fromEdge));
			}
		}
		
		to.getAttributeAssignments().addAll(EcoreUtil.copyAll(from.getAttributeAssignments()));
		to.getAttributeConstraints().addAll(EcoreUtil.copyAll(from.getAttributeConstraints()));
		
	}
	
	private void mergeCorrPatterns(Collection<CorrVariablePattern> patterns) {
		corrPatterns = new HashMap<String, CorrVariablePattern>();

		for (CorrVariablePattern pattern : patterns) {
			if (!corrPatterns.containsKey(pattern.getName())) {
				corrPatterns.put(pattern.getName(), pattern);
			} else {
				mergeTwoCorrPatterns(pattern, corrPatterns.get(pattern.getName()));
			}
		}
	}
	

	private void mergeTwoCorrPatterns(CorrVariablePattern from, CorrVariablePattern to) {
		// Types
		CorrType superType = from.getType().getSuper();
		while (superType != null) {
			if (superType == to.getType()) {
				to.setType(from.getType());
				break;
			}
			superType = superType.getSuper();
		}
				
		// Operator   
		mergeOperators(from, to);
		
		// Source
		if (to.getSource() == null) {
			to.setSource(from.getSource());
		}
		
		// Target
		if (to.getTarget() == null) {
			to.setTarget(from.getTarget());
		}
	}
	
	private void mergeOperators(OperatorPattern from, OperatorPattern to) {
		if (to.getOp() != null && from.getOp() == null) {
			to.setOp(null);
		}
	}
	
	private void cleanupReferences(Rule rule) {
		cleanupCorrespondenceVariablePatternReferences(rule);
		cleanupLinkVariablePatternReferences(rule);
		cleanupAttributeExpressionReferences(rule);
	}
	
	private void cleanupCorrespondenceVariablePatternReferences(Rule rule) {
		rule.getCorrespondencePatterns().stream()
								        .forEach(c -> {
								        	c.setSource(this.sourcePatterns.get(c.getSource().getName()));
								        	c.setTarget(this.targetPatterns.get(c.getTarget().getName()));
								        });
	}
	
	private void cleanupLinkVariablePatternReferences(Rule rule) {
		rule.getSourcePatterns().stream()
								.flatMap(s -> s.getLinkVariablePatterns().stream())
								.forEach(l -> l.setTarget(this.sourcePatterns.get(l.getTarget().getName())));

		rule.getTargetPatterns().stream()
								.flatMap(s -> s.getLinkVariablePatterns().stream())
								.forEach(l -> l.setTarget(this.targetPatterns.get(l.getTarget().getName())));
	}
	
	private void cleanupAttributeExpressionReferences(Rule rule) {
		Map<String, ObjectVariablePattern> objectPatterns = new HashMap<String, ObjectVariablePattern>();
		objectPatterns.putAll(this.sourcePatterns);
		objectPatterns.putAll(this.targetPatterns);
		
		rule.getAttrConditions().stream()
								.flatMap(a -> a.getValues().stream())
								.filter(v -> v instanceof AttributeExpression)
								.forEach(a -> ((AttributeExpression)a).setObjectVar(objectPatterns.get(getObjectVarName(((AttributeExpression)a)
																								  .getObjectVar()))));

		rule.getSourcePatterns().stream()
								.flatMap(s -> s.getAttributeAssignments().stream())
								.map(a -> a.getValueExp())
								.filter(v -> v instanceof AttributeExpression)
								.forEach(a -> ((AttributeExpression)a).setObjectVar(objectPatterns.get(getObjectVarName(((AttributeExpression)a)
																								  .getObjectVar()))));

		rule.getTargetPatterns().stream()
								.flatMap(s -> s.getAttributeAssignments().stream())
								.map(a -> a.getValueExp())
								.filter(v -> v instanceof AttributeExpression)
								.forEach(a -> ((AttributeExpression)a).setObjectVar(objectPatterns.get(getObjectVarName(((AttributeExpression)a)
																								  .getObjectVar()))));

		rule.getSourcePatterns().stream()
								.flatMap(s -> s.getAttributeConstraints().stream())
								.map(a -> a.getValueExp())
								.filter(v -> v instanceof AttributeExpression)
								.forEach(a -> ((AttributeExpression)a).setObjectVar(objectPatterns.get(getObjectVarName(((AttributeExpression)a)
																								  .getObjectVar()))));

		rule.getTargetPatterns().stream()
								.flatMap(s -> s.getAttributeConstraints().stream())
								.map(a -> a.getValueExp())
								.filter(v -> v instanceof AttributeExpression)
								.forEach(a -> ((AttributeExpression)a).setObjectVar(objectPatterns.get(getObjectVarName(((AttributeExpression)a)
																								  .getObjectVar()))));
	}
	
	private String getObjectVarName(EObject obj) {
		if(obj instanceof ObjectVariablePattern)
			return ((ObjectVariablePattern) obj).getName();
		if(obj instanceof ObjectVariablePattern)
			return ((ContextObjectVariablePattern) obj).getName();
		else 
			throw new IllegalStateException("obj is not an ObjectVariablepattern nor ContextObjectVariablePattern");
	}

}
