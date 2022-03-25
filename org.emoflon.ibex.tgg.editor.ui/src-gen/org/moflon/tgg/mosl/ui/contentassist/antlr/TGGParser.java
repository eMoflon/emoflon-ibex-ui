/*
 * generated by Xtext
 */
package org.moflon.tgg.mosl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.moflon.tgg.mosl.services.TGGGrammarAccess;

public class TGGParser extends AbstractContentAssistParser {
	
	@Inject
	private TGGGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.moflon.tgg.mosl.ui.contentassist.antlr.internal.InternalTGGParser createParser() {
		org.moflon.tgg.mosl.ui.contentassist.antlr.internal.InternalTGGParser result = new org.moflon.tgg.mosl.ui.contentassist.antlr.internal.InternalTGGParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getCorrTypeAccess().getAlternatives_1(), "rule__CorrType__Alternatives_1");
					put(grammarAccess.getAdornmentAccess().getValueAlternatives_1_0(), "rule__Adornment__ValueAlternatives_1_0");
					put(grammarAccess.getParamValueAccess().getAlternatives(), "rule__ParamValue__Alternatives");
					put(grammarAccess.getAttributeConstraintAccess().getOpAlternatives_1_0(), "rule__AttributeConstraint__OpAlternatives_1_0");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getNacAccess().getAlternatives_4(), "rule__Nac__Alternatives_4");
					put(grammarAccess.getLiteralValueAccess().getAlternatives(), "rule__LiteralValue__Alternatives");
					put(grammarAccess.getOperatorPatternAccess().getAlternatives(), "rule__OperatorPattern__Alternatives");
					put(grammarAccess.getNamedElementsAccess().getAlternatives(), "rule__NamedElements__Alternatives");
					put(grammarAccess.getNamePatternAccess().getAlternatives(), "rule__NamePattern__Alternatives");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getGroup(), "rule__TripleGraphGrammarFile__Group__0");
					put(grammarAccess.getSchemaAccess().getGroup(), "rule__Schema__Group__0");
					put(grammarAccess.getSchemaAccess().getGroup_2(), "rule__Schema__Group_2__0");
					put(grammarAccess.getSchemaAccess().getGroup_3(), "rule__Schema__Group_3__0");
					put(grammarAccess.getSchemaAccess().getGroup_4(), "rule__Schema__Group_4__0");
					put(grammarAccess.getSchemaAccess().getGroup_5(), "rule__Schema__Group_5__0");
					put(grammarAccess.getCorrTypeAccess().getGroup(), "rule__CorrType__Group__0");
					put(grammarAccess.getCorrTypeAccess().getGroup_1_0(), "rule__CorrType__Group_1_0__0");
					put(grammarAccess.getCorrTypeAccess().getGroup_1_1(), "rule__CorrType__Group_1_1__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup(), "rule__AttrCondDef__Group__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_3(), "rule__AttrCondDef__Group_3__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_3_1(), "rule__AttrCondDef__Group_3_1__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_8(), "rule__AttrCondDef__Group_8__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_9(), "rule__AttrCondDef__Group_9__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_9_1(), "rule__AttrCondDef__Group_9_1__0");
					put(grammarAccess.getAttrCondDefAccess().getGroup_9_1_1(), "rule__AttrCondDef__Group_9_1_1__0");
					put(grammarAccess.getParamAccess().getGroup(), "rule__Param__Group__0");
					put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
					put(grammarAccess.getRuleAccess().getGroup_3(), "rule__Rule__Group_3__0");
					put(grammarAccess.getRuleAccess().getGroup_3_2(), "rule__Rule__Group_3_2__0");
					put(grammarAccess.getRuleAccess().getGroup_6(), "rule__Rule__Group_6__0");
					put(grammarAccess.getRuleAccess().getGroup_7(), "rule__Rule__Group_7__0");
					put(grammarAccess.getRuleAccess().getGroup_8(), "rule__Rule__Group_8__0");
					put(grammarAccess.getRuleAccess().getGroup_9(), "rule__Rule__Group_9__0");
					put(grammarAccess.getAttrCondAccess().getGroup(), "rule__AttrCond__Group__0");
					put(grammarAccess.getAttrCondAccess().getGroup_2(), "rule__AttrCond__Group_2__0");
					put(grammarAccess.getAttrCondAccess().getGroup_2_1(), "rule__AttrCond__Group_2_1__0");
					put(grammarAccess.getAttrCondDefLibraryAccess().getGroup(), "rule__AttrCondDefLibrary__Group__0");
					put(grammarAccess.getAttrCondDefLibraryAccess().getGroup_2(), "rule__AttrCondDefLibrary__Group_2__0");
					put(grammarAccess.getAdornmentAccess().getGroup(), "rule__Adornment__Group__0");
					put(grammarAccess.getCorrVariablePatternAccess().getGroup(), "rule__CorrVariablePattern__Group__0");
					put(grammarAccess.getObjectVariablePatternAccess().getGroup(), "rule__ObjectVariablePattern__Group__0");
					put(grammarAccess.getObjectVariablePatternAccess().getGroup_4(), "rule__ObjectVariablePattern__Group_4__0");
					put(grammarAccess.getContextObjectVariablePatternAccess().getGroup(), "rule__ContextObjectVariablePattern__Group__0");
					put(grammarAccess.getContextObjectVariablePatternAccess().getGroup_3(), "rule__ContextObjectVariablePattern__Group_3__0");
					put(grammarAccess.getAttributeConstraintAccess().getGroup(), "rule__AttributeConstraint__Group__0");
					put(grammarAccess.getAttributeAssignmentAccess().getGroup(), "rule__AttributeAssignment__Group__0");
					put(grammarAccess.getEnumExpressionAccess().getGroup(), "rule__EnumExpression__Group__0");
					put(grammarAccess.getAttributeExpressionAccess().getGroup(), "rule__AttributeExpression__Group__0");
					put(grammarAccess.getLinkVariablePatternAccess().getGroup(), "rule__LinkVariablePattern__Group__0");
					put(grammarAccess.getContextLinkVariablePatternAccess().getGroup(), "rule__ContextLinkVariablePattern__Group__0");
					put(grammarAccess.getNacAccess().getGroup(), "rule__Nac__Group__0");
					put(grammarAccess.getNacAccess().getGroup_4_0(), "rule__Nac__Group_4_0__0");
					put(grammarAccess.getNacAccess().getGroup_4_1(), "rule__Nac__Group_4_1__0");
					put(grammarAccess.getNacAccess().getGroup_5(), "rule__Nac__Group_5__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getUsingAccess().getGroup(), "rule__Using__Group__0");
					put(grammarAccess.getLiteralValueAccess().getGroup_1(), "rule__LiteralValue__Group_1__0");
					put(grammarAccess.getLiteralValueAccess().getGroup_2(), "rule__LiteralValue__Group_2__0");
					put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getImportsAssignment_0(), "rule__TripleGraphGrammarFile__ImportsAssignment_0");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getUsingAssignment_1(), "rule__TripleGraphGrammarFile__UsingAssignment_1");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaAssignment_2(), "rule__TripleGraphGrammarFile__SchemaAssignment_2");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getRulesAssignment_3(), "rule__TripleGraphGrammarFile__RulesAssignment_3");
					put(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAssignment_4(), "rule__TripleGraphGrammarFile__LibraryAssignment_4");
					put(grammarAccess.getSchemaAccess().getNameAssignment_1(), "rule__Schema__NameAssignment_1");
					put(grammarAccess.getSchemaAccess().getSourceTypesAssignment_2_2(), "rule__Schema__SourceTypesAssignment_2_2");
					put(grammarAccess.getSchemaAccess().getTargetTypesAssignment_3_2(), "rule__Schema__TargetTypesAssignment_3_2");
					put(grammarAccess.getSchemaAccess().getCorrespondenceTypesAssignment_4_2(), "rule__Schema__CorrespondenceTypesAssignment_4_2");
					put(grammarAccess.getSchemaAccess().getAttributeCondDefsAssignment_5_2(), "rule__Schema__AttributeCondDefsAssignment_5_2");
					put(grammarAccess.getCorrTypeAccess().getNameAssignment_0(), "rule__CorrType__NameAssignment_0");
					put(grammarAccess.getCorrTypeAccess().getSuperAssignment_1_0_1(), "rule__CorrType__SuperAssignment_1_0_1");
					put(grammarAccess.getCorrTypeAccess().getSourceAssignment_1_1_2(), "rule__CorrType__SourceAssignment_1_1_2");
					put(grammarAccess.getCorrTypeAccess().getTargetAssignment_1_1_4(), "rule__CorrType__TargetAssignment_1_1_4");
					put(grammarAccess.getAttrCondDefAccess().getUserDefinedAssignment_0(), "rule__AttrCondDef__UserDefinedAssignment_0");
					put(grammarAccess.getAttrCondDefAccess().getNameAssignment_1(), "rule__AttrCondDef__NameAssignment_1");
					put(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_0(), "rule__AttrCondDef__ParamsAssignment_3_0");
					put(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_1_1(), "rule__AttrCondDef__ParamsAssignment_3_1_1");
					put(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_7(), "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7");
					put(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_8_1(), "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1");
					put(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_0(), "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0");
					put(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_1_1(), "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1");
					put(grammarAccess.getParamAccess().getParamNameAssignment_0(), "rule__Param__ParamNameAssignment_0");
					put(grammarAccess.getParamAccess().getTypeAssignment_2(), "rule__Param__TypeAssignment_2");
					put(grammarAccess.getRuleAccess().getAbstractRuleAssignment_0(), "rule__Rule__AbstractRuleAssignment_0");
					put(grammarAccess.getRuleAccess().getNameAssignment_2(), "rule__Rule__NameAssignment_2");
					put(grammarAccess.getRuleAccess().getSupertypesAssignment_3_1(), "rule__Rule__SupertypesAssignment_3_1");
					put(grammarAccess.getRuleAccess().getSupertypesAssignment_3_2_1(), "rule__Rule__SupertypesAssignment_3_2_1");
					put(grammarAccess.getRuleAccess().getSchemaAssignment_5(), "rule__Rule__SchemaAssignment_5");
					put(grammarAccess.getRuleAccess().getSourcePatternsAssignment_6_2(), "rule__Rule__SourcePatternsAssignment_6_2");
					put(grammarAccess.getRuleAccess().getTargetPatternsAssignment_7_2(), "rule__Rule__TargetPatternsAssignment_7_2");
					put(grammarAccess.getRuleAccess().getCorrespondencePatternsAssignment_8_2(), "rule__Rule__CorrespondencePatternsAssignment_8_2");
					put(grammarAccess.getRuleAccess().getAttrConditionsAssignment_9_2(), "rule__Rule__AttrConditionsAssignment_9_2");
					put(grammarAccess.getAttrCondAccess().getNameAssignment_0(), "rule__AttrCond__NameAssignment_0");
					put(grammarAccess.getAttrCondAccess().getValuesAssignment_2_0(), "rule__AttrCond__ValuesAssignment_2_0");
					put(grammarAccess.getAttrCondAccess().getValuesAssignment_2_1_1(), "rule__AttrCond__ValuesAssignment_2_1_1");
					put(grammarAccess.getAttrCondDefLibraryAccess().getNameAssignment_1(), "rule__AttrCondDefLibrary__NameAssignment_1");
					put(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAssignment_2_1(), "rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1");
					put(grammarAccess.getAdornmentAccess().getValueAssignment_1(), "rule__Adornment__ValueAssignment_1");
					put(grammarAccess.getLocalVariableAccess().getNameAssignment(), "rule__LocalVariable__NameAssignment");
					put(grammarAccess.getCorrVariablePatternAccess().getOpAssignment_0(), "rule__CorrVariablePattern__OpAssignment_0");
					put(grammarAccess.getCorrVariablePatternAccess().getNameAssignment_1(), "rule__CorrVariablePattern__NameAssignment_1");
					put(grammarAccess.getCorrVariablePatternAccess().getTypeAssignment_3(), "rule__CorrVariablePattern__TypeAssignment_3");
					put(grammarAccess.getCorrVariablePatternAccess().getSourceAssignment_6(), "rule__CorrVariablePattern__SourceAssignment_6");
					put(grammarAccess.getCorrVariablePatternAccess().getTargetAssignment_8(), "rule__CorrVariablePattern__TargetAssignment_8");
					put(grammarAccess.getObjectVariablePatternAccess().getOpAssignment_0(), "rule__ObjectVariablePattern__OpAssignment_0");
					put(grammarAccess.getObjectVariablePatternAccess().getNameAssignment_1(), "rule__ObjectVariablePattern__NameAssignment_1");
					put(grammarAccess.getObjectVariablePatternAccess().getTypeAssignment_3(), "rule__ObjectVariablePattern__TypeAssignment_3");
					put(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAssignment_4_1(), "rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1");
					put(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAssignment_4_2(), "rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2");
					put(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsAssignment_4_3(), "rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3");
					put(grammarAccess.getContextObjectVariablePatternAccess().getNameAssignment_0(), "rule__ContextObjectVariablePattern__NameAssignment_0");
					put(grammarAccess.getContextObjectVariablePatternAccess().getTypeAssignment_2(), "rule__ContextObjectVariablePattern__TypeAssignment_2");
					put(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAssignment_3_1(), "rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1");
					put(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsAssignment_3_2(), "rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2");
					put(grammarAccess.getAttributeConstraintAccess().getAttributeAssignment_0(), "rule__AttributeConstraint__AttributeAssignment_0");
					put(grammarAccess.getAttributeConstraintAccess().getOpAssignment_1(), "rule__AttributeConstraint__OpAssignment_1");
					put(grammarAccess.getAttributeConstraintAccess().getValueExpAssignment_2(), "rule__AttributeConstraint__ValueExpAssignment_2");
					put(grammarAccess.getAttributeAssignmentAccess().getAttributeAssignment_0(), "rule__AttributeAssignment__AttributeAssignment_0");
					put(grammarAccess.getAttributeAssignmentAccess().getOpAssignment_1(), "rule__AttributeAssignment__OpAssignment_1");
					put(grammarAccess.getAttributeAssignmentAccess().getValueExpAssignment_2(), "rule__AttributeAssignment__ValueExpAssignment_2");
					put(grammarAccess.getEnumExpressionAccess().getEenumAssignment_1(), "rule__EnumExpression__EenumAssignment_1");
					put(grammarAccess.getEnumExpressionAccess().getLiteralAssignment_3(), "rule__EnumExpression__LiteralAssignment_3");
					put(grammarAccess.getAttributeExpressionAccess().getDerivedAssignment_0(), "rule__AttributeExpression__DerivedAssignment_0");
					put(grammarAccess.getAttributeExpressionAccess().getObjectVarAssignment_1(), "rule__AttributeExpression__ObjectVarAssignment_1");
					put(grammarAccess.getAttributeExpressionAccess().getAttributeAssignment_3(), "rule__AttributeExpression__AttributeAssignment_3");
					put(grammarAccess.getLiteralExpressionAccess().getValueAssignment(), "rule__LiteralExpression__ValueAssignment");
					put(grammarAccess.getLinkVariablePatternAccess().getOpAssignment_0(), "rule__LinkVariablePattern__OpAssignment_0");
					put(grammarAccess.getLinkVariablePatternAccess().getTypeAssignment_2(), "rule__LinkVariablePattern__TypeAssignment_2");
					put(grammarAccess.getLinkVariablePatternAccess().getTargetAssignment_4(), "rule__LinkVariablePattern__TargetAssignment_4");
					put(grammarAccess.getContextLinkVariablePatternAccess().getTypeAssignment_1(), "rule__ContextLinkVariablePattern__TypeAssignment_1");
					put(grammarAccess.getContextLinkVariablePatternAccess().getTargetAssignment_3(), "rule__ContextLinkVariablePattern__TargetAssignment_3");
					put(grammarAccess.getOperatorAccess().getValueAssignment(), "rule__Operator__ValueAssignment");
					put(grammarAccess.getNacAccess().getNameAssignment_1(), "rule__Nac__NameAssignment_1");
					put(grammarAccess.getNacAccess().getRuleAssignment_3(), "rule__Nac__RuleAssignment_3");
					put(grammarAccess.getNacAccess().getSourcePatternsAssignment_4_0_2(), "rule__Nac__SourcePatternsAssignment_4_0_2");
					put(grammarAccess.getNacAccess().getTargetPatternsAssignment_4_1_2(), "rule__Nac__TargetPatternsAssignment_4_1_2");
					put(grammarAccess.getNacAccess().getAttrConditionsAssignment_5_2(), "rule__Nac__AttrConditionsAssignment_5_2");
					put(grammarAccess.getImportAccess().getNameAssignment_1(), "rule__Import__NameAssignment_1");
					put(grammarAccess.getUsingAccess().getImportedNamespaceAssignment_1(), "rule__Using__ImportedNamespaceAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.moflon.tgg.mosl.ui.contentassist.antlr.internal.InternalTGGParser typedParser = (org.moflon.tgg.mosl.ui.contentassist.antlr.internal.InternalTGGParser) parser;
			typedParser.entryRuleTripleGraphGrammarFile();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public TGGGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(TGGGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
