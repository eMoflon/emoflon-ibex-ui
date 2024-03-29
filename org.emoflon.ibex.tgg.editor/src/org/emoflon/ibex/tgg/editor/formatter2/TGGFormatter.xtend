package org.emoflon.ibex.tgg.editor.formatter2;

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.emoflon.ibex.tgg.editor.tgg.Adornment
import org.emoflon.ibex.tgg.editor.tgg.AttrCond
import org.emoflon.ibex.tgg.editor.tgg.AttrCondDef
import org.emoflon.ibex.tgg.editor.tgg.AttrCondDefLibrary
import org.emoflon.ibex.tgg.editor.tgg.AttributeAssignment
import org.emoflon.ibex.tgg.editor.tgg.AttributeConstraint
import org.emoflon.ibex.tgg.editor.tgg.CorrType
import org.emoflon.ibex.tgg.editor.tgg.CorrVariablePattern
import org.emoflon.ibex.tgg.editor.tgg.EnumExpression
import org.emoflon.ibex.tgg.editor.tgg.Expression
import org.emoflon.ibex.tgg.editor.tgg.Import
import org.emoflon.ibex.tgg.editor.tgg.LinkVariablePattern
import org.emoflon.ibex.tgg.editor.tgg.LocalVariable
import org.emoflon.ibex.tgg.editor.tgg.ObjectVariablePattern
import org.emoflon.ibex.tgg.editor.tgg.Param
import org.emoflon.ibex.tgg.editor.tgg.ParamValue
import org.emoflon.ibex.tgg.editor.tgg.Rule
import org.emoflon.ibex.tgg.editor.tgg.Schema
import org.emoflon.ibex.tgg.editor.tgg.TripleGraphGrammarFile
import org.emoflon.ibex.tgg.editor.tgg.Using

import static org.emoflon.ibex.tgg.editor.tgg.TggPackage.Literals.*

class TGGFormatter extends AbstractFormatter2 {

    val schemaKW 	= "#schema"
    val sourceKW 	= "#source"
    val targetKW 	= "#target"
    val corrKW   	= "#correspondence"
    val attrCondsKW = "#attributeConditions"
    val absKW 		= "#abstract"
    val srcArrowKW	= "#src->"
    val trgArrowKW 	= "#trg->"
    val ruleKW		= "#rule"
    val syncKW 		= "#sync:"
    val genKW 		= "#gen:"
    val arrowKW		= "->"
	
    // predefined Styles
	def private void lineSeparator(List<? extends EObject> items, extension IFormattableDocument document){
		if(items !== null && items.size() > 0){
			items.get(0).prepend[newLine]
			for(var index = 0; index < items.size()-1; index++){
				items.get(index).append[newLines = 2]
			}
			items.get(items.size()-1).append[newLine]
		}
	}

	def private void singleItemFormat(EObject item, extension IFormattableDocument document){
		item.surround[indent]
	}

	def private void singleItemFormatInterior(EObject item, extension IFormattableDocument document){
		singleItemFormat(item,document);
		item.interior[indent]
	}

	def private void attributeFormat(EObject attribute, extension IFormattableDocument document){
		attribute.surround[newLine];
		attribute.regionFor.feature(ATTRIBUTE_CONSTRAINT__OP).surround[noSpace]
	}

	def private void corrFormat(EObject corr, extension IFormattableDocument document){
		corr.regionFor.keyword(srcArrowKW).prepend[newLine].append[noSpace]
		corr.regionFor.keyword(trgArrowKW).prepend[newLine].append[noSpace]
		corr.regionFor.keyword("}").prepend[newLine]
	}
	
	
// formating
	def dispatch void format(TripleGraphGrammarFile triplegraphgrammarfile, extension IFormattableDocument document) {
		format(triplegraphgrammarfile.getSchema(), document);
		for (Rule rules : triplegraphgrammarfile.getRules()) {
			format(rules, document);
		}
		format(triplegraphgrammarfile.library, document);
	}
	def dispatch void format(AttrCondDefLibrary library, extension IFormattableDocument document) {
		for (AttrCondDef attrCondDef : library.attributeCondDefs) {
			format(attrCondDef, document);
		}
	}

	def dispatch void format(Schema schema, extension IFormattableDocument document) {
		schema.append[newLines = 3]
		schema.regionFor.keyword(schemaKW).prepend[setNewLines(2);highPriority]
		schema.regionFor.keyword(sourceKW).prepend[setNewLines(2)]
		schema.regionFor.keywordPairs(sourceKW, "}").get(0).interior[indent]
		schema.regionFor.keyword(targetKW).prepend[setNewLines(2)]
		schema.regionFor.keywordPairs(targetKW, "}").get(0).interior[indent]
		schema.regionFor.keyword(corrKW).prepend[setNewLines(2)]
		schema.regionFor.keyword(attrCondsKW).prepend[setNewLines(2)]
		
		schema.regionFor.feature(SCHEMA__SOURCE_TYPES).surround[newLine]
		schema.regionFor.feature(SCHEMA__TARGET_TYPES).surround[newLine]
		
		for (Import imports : schema.file.getImports()) {
			imports.append[newLine]
		}
		for (Using using : schema.file.getUsing()) {
			using.append[newLine]
		}
		
		lineSeparator(schema.correspondenceTypes, document)
		for (CorrType correspondenceTypes : schema.getCorrespondenceTypes()) {
			format(correspondenceTypes, document);
		}
		
		lineSeparator(schema.attributeCondDefs, document)
		for (AttrCondDef attributeCondDefs : schema.getAttributeCondDefs()) {
			format(attributeCondDefs, document);
		}
	}

	def dispatch void format(Rule rule, extension IFormattableDocument document) {
		rule.append[newLines = 3]
		rule.regionFor.keyword(absKW).prepend[setNewLines(2);highPriority]
		if (!rule.abstractRule) {
			rule.regionFor.keyword(ruleKW).prepend[setNewLines(2);highPriority]
		}
		rule.regionFor.keyword(sourceKW).prepend[setNewLines(2)]
		rule.regionFor.keyword(targetKW).prepend[setNewLines(2)]
		rule.regionFor.keyword(corrKW).prepend[setNewLines(2)]
		rule.regionFor.keyword(attrCondsKW).prepend[setNewLines(2)]
		rule.regionFor.keyword(",").prepend[noSpace]
	
		
		for (Import imports : rule.file.getImports()) {
			imports.append[newLine]
		}
		for (Using using : rule.file.getUsing()) {
			using.append[newLine]
		}
		
		lineSeparator(rule.sourcePatterns, document)
		for (ObjectVariablePattern sourcePatterns : rule.getSourcePatterns()) {
			format(sourcePatterns, document);
		}
		
		lineSeparator(rule.targetPatterns, document)
		for (ObjectVariablePattern targetPatterns : rule.getTargetPatterns()) {
			format(targetPatterns, document);
		}
		
		lineSeparator(rule.correspondencePatterns,document)
		for (CorrVariablePattern correspondencePatterns : rule.getCorrespondencePatterns()) {
			format(correspondencePatterns, document);
		}
		
		lineSeparator(rule.attrConditions,document)
		for (AttrCond attrConditions : rule.getAttrConditions()) {
			format(attrConditions, document);
		}
		
	}
	
	def TripleGraphGrammarFile file(Rule rule){
		rule.eContainer as TripleGraphGrammarFile
	}
	
	def TripleGraphGrammarFile file(Schema schema){
		schema.eContainer as TripleGraphGrammarFile
	}
	
	def dispatch void format(CorrType correspondenceType, extension IFormattableDocument document) {
		singleItemFormatInterior(correspondenceType,document);
		if(correspondenceType instanceof CorrType){
			corrFormat(correspondenceType, document)
		}
	}

	def dispatch void format(AttrCond attrcond, extension IFormattableDocument document) {
		singleItemFormat(attrcond,document)
		attrcond.regionFor.feature(ATTR_COND__NAME).prepend[newLine]
		var values = attrcond.getValues()
		for (ParamValue value : values) {
			if (values.indexOf(value) != 0) {
				if (value instanceof LocalVariable) {
					value.prepend[space = " ^"]
				} else {
					value.prepend[oneSpace]
				}
			} else {
				if (value instanceof LocalVariable) {
					value.prepend[space = "^"]
				} else {
					value.prepend[noSpace]
				}
			}
			value.append[noSpace]
			value.regionFor.keyword(".").surround[noSpace]
		}
	}

	def dispatch void format(AttrCondDef attrconddef, extension IFormattableDocument document) {
		singleItemFormatInterior(attrconddef,document)		
		attrconddef.regionFor.keyword("(").surround[noSpace]
		attrconddef.regionFor.keyword(syncKW).prepend[newLine]
		attrconddef.regionFor.keyword(genKW).prepend[newLine]
		for (Param params : attrconddef.getParams()) {
			params.regionFor.feature(PARAM__PARAM_NAME).append[noSpace]
			params.regionFor.feature(PARAM__TYPE).surround[noSpace]
		}
		for (Adornment adornment : attrconddef.getAllowedSyncAdornments()) {
			adornment.regionFor.feature(ADORNMENT__VALUE).append[noSpace]
		}
		for (Adornment adornment : attrconddef.getAllowedGenAdornments()) {
			adornment.regionFor.feature(ADORNMENT__VALUE).append[noSpace]
		}
	}

	def dispatch void format(CorrVariablePattern corrvariablepattern, extension IFormattableDocument document) {
		singleItemFormatInterior(corrvariablepattern,document)
		corrvariablepattern.regionFor.feature(CORR_VARIABLE_PATTERN__TYPE).prepend[noSpace]
		corrFormat(corrvariablepattern, document)
	}



	def dispatch void format(ObjectVariablePattern objectvariablepattern, extension IFormattableDocument document) {
		singleItemFormatInterior(objectvariablepattern,document)
		objectvariablepattern.regionFor.feature(NAMED_ELEMENTS__NAME).surround[noSpace]
		objectvariablepattern.regionFor.feature(OBJECT_VARIABLE_PATTERN__TYPE).prepend[noSpace]
		
		for (AttributeAssignment assignment : objectvariablepattern.getAttributeAssignments()) {
			attributeFormat(assignment,document)
			format(assignment.valueExp, document)
		}
		for (AttributeConstraint constraint : objectvariablepattern.getAttributeConstraints()) {
			attributeFormat(constraint, document)
			format(constraint.valueExp, document)
		}
		for (LinkVariablePattern linkVariablePatterns : objectvariablepattern.getLinkVariablePatterns()) {
			format(linkVariablePatterns, document);
		}
	}

	def dispatch void format(LinkVariablePattern linkvariablepattern, extension IFormattableDocument document) {
		linkvariablepattern.surround[newLine]		
		linkvariablepattern.regionFor.keyword(arrowKW).surround[oneSpace]
	}
	
	def dispatch void format(Expression exp, extension IFormattableDocument document){
		if(exp instanceof EnumExpression){
			exp.regionFor.keyword("enum::").surround[noSpace]
			exp.regionFor.keyword("::").surround[noSpace]		
		}
	}
}
