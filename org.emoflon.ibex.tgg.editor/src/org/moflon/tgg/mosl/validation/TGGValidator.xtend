/*
 * generated by Xtext
 */
package org.moflon.tgg.mosl.validation

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import org.moflon.tgg.mosl.tgg.AttributeConstraint
import org.moflon.tgg.mosl.tgg.AttributeExpression
import org.moflon.tgg.mosl.tgg.EnumExpression
import org.moflon.tgg.mosl.tgg.Import
import org.moflon.tgg.mosl.tgg.LinkVariablePattern
import org.moflon.tgg.mosl.tgg.LiteralExpression
import org.moflon.tgg.mosl.tgg.NamedElements
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern
import org.moflon.tgg.mosl.tgg.ParamValue
import org.moflon.tgg.mosl.tgg.Rule
import org.moflon.tgg.mosl.tgg.TggPackage
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
import org.moflon.tgg.mosl.tgg.impl.LocalVariableImpl
import org.moflon.tgg.mosl.tgg.CorrVariablePattern
import org.eclipse.emf.ecore.EStructuralFeature
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TGGValidator extends AbstractTGGValidator {
	public static val INVALID_ADORNMENT = 'invalidAdornmentValue'
	public static val INVALID_ATTRIBUTE_VARIABLE = 'invalidAttributeVariableAttribute'
	public static val NOT_UNIQUE_NAME = 'notUniqueName'
	public static val TYPE_IS_ABSTRACT = 'typeIsAbstract'
	public static val RULE_REFINEMENT_CREATES_A_CYCLE = 'RuleRefinementCreatesACycle'
	public static val LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_OBJECT_VARIABLE_PATTERN = 'linkVariableDoesNotHaveSameOeratorLikeObjectVariablePattern'
	public static val LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_TARGET_OBJECT_VARIABLE_PATTERN = 'linkVariableDoesNotHaveSameOeratorLikeTargetObjectVariablePattern'
	public static val INVALID_NAME = 'invalidName'
	public static val INVALID_EXPRESSION_TYPE = 'invalidExpressionType'
	public static val FILE_DOES_NOT_EXIST = 'fileDoesNotExist'
	public static val INVALID_IMPORT = 'invalidImport'
	public static val INVALID_ASSIGNMENT_OPERATOR = 'invalidAssignmentOperator'
	public static val INVALID_CORRESPONDENCE_VARIABLE = 'invalidCorrespondence'
  
	@Check
	def checkAttributeExpression(AttributeExpression attrVar){
		var attrNames = new BasicEList()
		for (attr : getOPatternType(attrVar.objectVar).EAllAttributes) {
			attrNames.add(attr)
		}
		if (!attrNames.contains(attrVar.attribute)) {
			error("EClass " + getOPatternType(attrVar.objectVar).name + " does not contain EAttribute " + attrVar.attribute.name + ".", TggPackage.Literals.ATTRIBUTE_EXPRESSION__ATTRIBUTE, TGGValidator.INVALID_ATTRIBUTE_VARIABLE);
		}
	}
	
	Map<String, Map<EObject, Map<Class<? extends EObject>, EObject>>> names = new HashMap<String, Map<EObject, Map<Class<? extends EObject>, EObject>>>();
	
	@Check
	def checkForUniqueNames(TripleGraphGrammarFile tggFile){
		names.clear();
		for(NamedElements ne : EcoreUtil2.getAllContentsOfType(tggFile, NamedElements)){
			checkForUniqueNames(ne);
		}
	}

	def checkForUniqueNames(NamedElements ne){
		if(names.containsKey(ne.name)){
			var containers = names.get(ne.name);
			if(containers.containsKey(ne.eContainer)){
				var classes = containers.get(ne.eContainer);
				
				if(classes.containsKey(ne.class)){
					var object = classes.get(ne.class);
					if(!object.equals(ne)){
						error("Names must be unique. The name '" + ne.name + "' is already in use.", ne,  TggPackage.Literals.NAMED_ELEMENTS__NAME, TGGValidator.NOT_UNIQUE_NAME);
						error("Names must be unique. The name '" + ne.name + "' is already in use.", object,  TggPackage.Literals.NAMED_ELEMENTS__NAME, TGGValidator.NOT_UNIQUE_NAME);
						classes.remove(ne.class);
						containers.put(ne.eContainer, classes);
						names.put(ne.name, containers)
					}				
				}
				else{
					classes.put(ne.class, ne);
					containers.put(ne.eContainer, classes);
					names.put(ne.name, containers);
				}
			}
			else{
				var classes = new HashMap<Class<? extends EObject>, EObject>();
				classes.put(ne.class,ne);
				containers.put(ne.eContainer, classes);
				names.put(ne.name, containers);
			}			
		}
		else{
			var classes = new HashMap<Class<? extends EObject>, EObject>();
			classes.put(ne.class,ne);			
			var containers = new HashMap<EObject, Map<Class<? extends EObject>, EObject>>();
			containers.put(ne.eContainer, classes);
			names.put(ne.name, containers);
		}
	}
	
	@Check
	def checkIfTheTryingToGenerateObjectVariableIsAbstract(ObjectVariablePattern objectVariablePattern){
		val type = objectVariablePattern.type
		val eContainer = objectVariablePattern.eContainer;		
		if(eContainer instanceof Rule){
		  var rule = eContainer as Rule;
		  var operator = objectVariablePattern.op;
		  var ruleIsAbstract = rule.abstractRule;
		  var typeIsAbstract = type.abstract;
		  var isGeneration = operator != null && operator.value != null && operator.value.equalsIgnoreCase("++");
		  var isAnError = !ruleIsAbstract && typeIsAbstract && isGeneration;
		  if(isAnError){
		  	error("The type of the created object variable '" + objectVariablePattern.name + "' is abstract although the rule '" + Rule.name + "' is not.", TggPackage.Literals.OBJECT_VARIABLE_PATTERN__TYPE, TGGValidator.TYPE_IS_ABSTRACT);
		  }
		  
		}		
	} 
	
	def boolean findCycleInRule(Rule rule, List<Rule> visited){
		if(visited.contains(rule)){
			return true;
		}else {
			visited.add(rule);
			for(superType : rule.supertypes){
				if (findCycleInRule(superType, visited)){
					return true;
				}
			}
			visited.remove(rule)			
			return false;
		}
	}
	
	@Check
	def checkForCycleRefinments(Rule rule){
		var foundSuperTypes = new ArrayList<Rule>();
		if(findCycleInRule(rule, foundSuperTypes)){
			var refinementName = "<Placeholder>";
			if(foundSuperTypes.size() >= 2){
				refinementName = foundSuperTypes.get(1).name;
			}else{
				refinementName = rule.name
			}
			
			error("The rule '" + rule.name + "' creates a cycle with the refinement '" + refinementName +"'", TggPackage.Literals.RULE__SUPERTYPES, TGGValidator.RULE_REFINEMENT_CREATES_A_CYCLE);
		}
	}
	
	@Check
	def checkForMissingOperatorInPatternWithOperator(ObjectVariablePattern ov){
		if(ov.op != null && "++".equals(ov.op.value)){
			var ovOpValue = ov.op.value;
			for(LinkVariablePattern linkVar : ov.linkVariablePatterns){
				if(linkVar.op == null || !ovOpValue.equals(linkVar.op.value)){
					error("The operator of '" + linkVar.type.name + "' is incorrect.", linkVar, TggPackage.Literals.OPERATOR_PATTERN__OP, TGGValidator.LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_OBJECT_VARIABLE_PATTERN)
				}
			}
		}
		
		if (ov.op == null || ov.op.equals("")) {
			for (LinkVariablePattern linkVar : ov.linkVariablePatterns) {

				val target = linkVar.target;
				val trgOV = EcoreUtil2.resolve(target, ov.eContainer) as ObjectVariablePattern;
				var trgOVOp = trgOV.op;

				if (trgOVOp != null && trgOVOp.value.equals("++") &&
					((linkVar.op != null && !("++".equals(linkVar.op.value))) || linkVar.op == null)) {
					error("The operator of '" + linkVar.type.name + "' is incorrect.", linkVar,
						TggPackage.Literals.OPERATOR_PATTERN__OP,
						TGGValidator.LINK_VARIABLE_DOES_NOT_HAVE_SAME_OPERATOR_LIKE_TARGET_OBJECT_VARIABLE_PATTERN);
					}
				}
			}
	}
	
	@Check
	def checkForNameOfFileWithSingleTGGRule(TripleGraphGrammarFile file){
		if(file.rules.size + file.nacs.size + file.complementRules.size == 1){
			if(file.rules.size == 1)
				checkForNameOfFileWithSingleTGGRule(file.rules.get(0).name, file, file.rules.get(0))
			else if 	(file.nacs.size == 1)
				checkForNameOfFileWithSingleTGGRule(file.nacs.get(0).name, file, file.nacs.get(0))
			else
				checkForNameOfFileWithSingleTGGRule(file.complementRules.get(0).name, file, file.complementRules.get(0))
		}
	}
	
	def checkForNameOfFileWithSingleTGGRule(String name, TripleGraphGrammarFile file, EObject source){
		if(!file.eResource.URI.toPlatformString(false).endsWith(name + ".tgg")){			
			warning("As you have only one rule/NAC in your file, you might as well name the file accordingly.", source, 
						TggPackage.Literals.NAMED_ELEMENTS__NAME, 
						TGGValidator.INVALID_NAME
					)	
		}
	}
	
	@Check
 	def checkForInlineAttributeConditionsWithConstantOnRHS(AttributeConstraint attrConst){
 		if(attrConst.valueExp.eClass == TggPackage.eINSTANCE.attributeExpression ){
 				error("A constant is required. The expression '" + attrConst.valueExp + "' is an attribute expression.",  TggPackage.Literals.ATTRIBUTE_CONSTRAINT__VALUE_EXP, TGGValidator.INVALID_EXPRESSION_TYPE)
 		}
 			
 		try {
 			if(attrConst.valueExp.eClass == TggPackage.eINSTANCE.literalExpression){
 				EcoreUtil.createFromString(attrConst.attribute.EAttributeType, (attrConst.valueExp as LiteralExpression).getValue)
 			}
 		}
 			
 		catch(Exception e){
 				error("Type mismatch, '" + (attrConst.valueExp as LiteralExpression).getValue + "' is not of type '" + attrConst.attribute.EAttributeType + "'" ,TggPackage.Literals.ATTRIBUTE_CONSTRAINT__VALUE_EXP, TGGValidator.INVALID_EXPRESSION_TYPE)
 		}
 			
 		if(attrConst.valueExp.eClass == TggPackage.eINSTANCE.enumExpression){
 			if(!(attrConst.valueExp as EnumExpression).eenum.equals((attrConst.valueExp as EnumExpression).getLiteral().getEEnum())){
 				error("Type mismatch, '" + (attrConst.valueExp as EnumExpression).getLiteral().getEEnum() + "' is not of type '" + attrConst.valueExp.eClass  + "'" ,TggPackage.Literals.ATTRIBUTE_CONSTRAINT__VALUE_EXP, TGGValidator.INVALID_EXPRESSION_TYPE)
 			}
 		}
 	}
 	@Check
 	def checkAttributeConditionsForAttributeName(Rule rule){
 				val names = rule.patternNamesOfRule
 				for(value: rule.attributeConditionValues){
 					if(value.eClass == TggPackage.eINSTANCE.localVariable){
 						if(names.contains((value as LocalVariableImpl).getName)){
 							error("The name of the local variable '" + (value as LocalVariableImpl).getName +"' must not shadow the name of an object variable in the rule" ,TggPackage.Literals.RULE__ATTR_CONDITIONS, TGGValidator.INVALID_EXPRESSION_TYPE)
 						}
 					}
 				}
 			}
 		
 	def ArrayList<String> getPatternNamesOfRule(Rule rule){
		var patternNames = new ArrayList<String>();
		for(sourceOV: rule.sourcePatterns){
 			patternNames.add(sourceOV.name)
 		}
 		
 		for(targetOV: rule.targetPatterns){
 			patternNames.add(targetOV.name)
 		}
 		
 		for(corrOV:rule.correspondencePatterns){
 			patternNames.add(corrOV.name)
 		}
 		return patternNames;
 	}
 	
 	def ArrayList<ParamValue> getAttributeConditionValues(Rule rule){
 		var attributeConditionValue = new ArrayList<ParamValue>();
 		for(atrCond:rule.attrConditions){
 			for(value: atrCond.values){
 				attributeConditionValue.add(value)
 			}
 		}
 		return attributeConditionValue;
 	}
 	 
  @Check
 	def checkForInvalidImports(Import importEcore){
		try{
			var uri = URI.createURI(importEcore.name)
			var resourceSet =  new ResourceSetImpl()
			var resource = resourceSet.getResource(uri,true)
			resource.load(null)	
		}
		
		catch(Exception e){
			error("The ecore file '" + importEcore.name +"' does not exist" ,TggPackage.Literals.IMPORT__NAME, TGGValidator.INVALID_IMPORT)
		}
 	}
 	
 	
	def getOPatternType(EObject obj) {
		switch obj {
			ObjectVariablePattern : obj.type
			ContextObjectVariablePattern : obj.type
		}
	}
 	
 	@Check
 	def checkForAssignmentOperator(ObjectVariablePattern ov){
 		if(ov.op == null || ov.op.equals("")){
 			if(ov.attributeAssignments!=null){
 				for(value:ov.attributeAssignments){
 					if(value.op == ":=")
 					error("An assignment operation cannot be performed here." ,TggPackage.Literals.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS, TGGValidator.INVALID_ASSIGNMENT_OPERATOR)
 				}
 			}
 		}
 		
 		if(ov.op != null && "++".equals(ov.op.value)){
 			if(ov.attributeConstraints!= null){
 				for(value:ov.attributeConstraints){
 					if(value.op == "==")
 					error("An equality check cannot be performed here." ,TggPackage.Literals.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS, TGGValidator.INVALID_ASSIGNMENT_OPERATOR)
 				} 				
 			}
 		}
 	}

	@Check
	def validateContextCorrVariablePattern(CorrVariablePattern corr) {
		// A context CorrVariablePattern must not reference create ObjectVariablePatterns.
		if (corr.op == null) {
			this.noCreateObjectVariableInContextCorrespondence(
				corr.source,
				TggPackage.Literals.CORR_VARIABLE_PATTERN__SOURCE
			)
			this.noCreateObjectVariableInContextCorrespondence(
				corr.target,
				TggPackage.Literals.CORR_VARIABLE_PATTERN__TARGET
			)
		}
	}

	def noCreateObjectVariableInContextCorrespondence(ObjectVariablePattern ov, EStructuralFeature structuralFeature) {
		if (ov !== null && "++".equals(ov.op.value)) {
			error(
				"A context correspondence must not reference elements created by the rule!",
				structuralFeature,
				TGGValidator.INVALID_CORRESPONDENCE_VARIABLE
			)
		}
	}
}
