/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.emoflon.ibex.gt.editor.ide.contentassist.antlr.internal.InternalGTParser;
import org.emoflon.ibex.gt.editor.services.GTGrammarAccess;

public class GTParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(GTGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, GTGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getEditorGTFileAccess().getAlternatives_1(), "rule__EditorGTFile__Alternatives_1");
			builder.put(grammarAccess.getEditorParameterOrNodeAccess().getAlternatives(), "rule__EditorParameterOrNode__Alternatives");
			builder.put(grammarAccess.getEditorPatternAccess().getAlternatives_5_1(), "rule__EditorPattern__Alternatives_5_1");
			builder.put(grammarAccess.getEditorNodeAccess().getAlternatives_5_1(), "rule__EditorNode__Alternatives_5_1");
			builder.put(grammarAccess.getEditorExpressionAccess().getAlternatives(), "rule__EditorExpression__Alternatives");
			builder.put(grammarAccess.getEditorLiteralExpressionAccess().getAlternatives(), "rule__EditorLiteralExpression__Alternatives");
			builder.put(grammarAccess.getEditorLiteralExpressionAccess().getValueAlternatives_0_0(), "rule__EditorLiteralExpression__ValueAlternatives_0_0");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getAlternatives_6(), "rule__EditorReferenceIterator__Alternatives_6");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getAlternatives(), "rule__EditorIteratorAttributeAssignment__Alternatives");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getAlternatives(), "rule__EditorSimpleCondition__Alternatives");
			builder.put(grammarAccess.getEditorProbabilityAccess().getAlternatives(), "rule__EditorProbability__Alternatives");
			builder.put(grammarAccess.getExpExpressionAccess().getAlternatives_0(), "rule__ExpExpression__Alternatives_0");
			builder.put(grammarAccess.getExpExpressionAccess().getRightAlternatives_1_2_0(), "rule__ExpExpression__RightAlternatives_1_2_0");
			builder.put(grammarAccess.getOneParameterArithmeticsAccess().getAlternatives(), "rule__OneParameterArithmetics__Alternatives");
			builder.put(grammarAccess.getArithmeticAttributeAccess().getAlternatives(), "rule__ArithmeticAttribute__Alternatives");
			builder.put(grammarAccess.getEditorPatternTypeAccess().getAlternatives(), "rule__EditorPatternType__Alternatives");
			builder.put(grammarAccess.getEditorOperatorAccess().getAlternatives(), "rule__EditorOperator__Alternatives");
			builder.put(grammarAccess.getEditorRelationAccess().getAlternatives(), "rule__EditorRelation__Alternatives");
			builder.put(grammarAccess.getEditorApplicationConditionTypeAccess().getAlternatives(), "rule__EditorApplicationConditionType__Alternatives");
			builder.put(grammarAccess.getPossibleStochasticRangesAccess().getAlternatives(), "rule__PossibleStochasticRanges__Alternatives");
			builder.put(grammarAccess.getStochasticRangeAccess().getAlternatives(), "rule__StochasticRange__Alternatives");
			builder.put(grammarAccess.getStochasticDistributionAccess().getAlternatives(), "rule__StochasticDistribution__Alternatives");
			builder.put(grammarAccess.getMultOperatorAccess().getAlternatives(), "rule__MultOperator__Alternatives");
			builder.put(grammarAccess.getMinMaxOperatorAccess().getAlternatives(), "rule__MinMaxOperator__Alternatives");
			builder.put(grammarAccess.getAddOperatorAccess().getAlternatives(), "rule__AddOperator__Alternatives");
			builder.put(grammarAccess.getAllOneParameterOperatorsAccess().getAlternatives(), "rule__AllOneParameterOperators__Alternatives");
			builder.put(grammarAccess.getOneParameterOperatorAccess().getAlternatives(), "rule__OneParameterOperator__Alternatives");
			builder.put(grammarAccess.getEditorGTFileAccess().getGroup(), "rule__EditorGTFile__Group__0");
			builder.put(grammarAccess.getEditorImportAccess().getGroup(), "rule__EditorImport__Group__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup(), "rule__EditorPattern__Group__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_3(), "rule__EditorPattern__Group_3__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_3_1(), "rule__EditorPattern__Group_3_1__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_3_1_1(), "rule__EditorPattern__Group_3_1_1__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_4(), "rule__EditorPattern__Group_4__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_4_2(), "rule__EditorPattern__Group_4_2__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_5(), "rule__EditorPattern__Group_5__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_6(), "rule__EditorPattern__Group_6__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_6_2(), "rule__EditorPattern__Group_6_2__0");
			builder.put(grammarAccess.getEditorPatternAccess().getGroup_7(), "rule__EditorPattern__Group_7__0");
			builder.put(grammarAccess.getEditorParameterAccess().getGroup(), "rule__EditorParameter__Group__0");
			builder.put(grammarAccess.getEditorNodeAccess().getGroup(), "rule__EditorNode__Group__0");
			builder.put(grammarAccess.getEditorNodeAccess().getGroup_5(), "rule__EditorNode__Group_5__0");
			builder.put(grammarAccess.getEditorAttributeConstraintAccess().getGroup(), "rule__EditorAttributeConstraint__Group__0");
			builder.put(grammarAccess.getEditorAttributeAssignmentAccess().getGroup(), "rule__EditorAttributeAssignment__Group__0");
			builder.put(grammarAccess.getEditorAttributeExpressionAccess().getGroup(), "rule__EditorAttributeExpression__Group__0");
			builder.put(grammarAccess.getEditorCountExpressionAccess().getGroup(), "rule__EditorCountExpression__Group__0");
			builder.put(grammarAccess.getEditorLiteralExpressionAccess().getGroup_1(), "rule__EditorLiteralExpression__Group_1__0");
			builder.put(grammarAccess.getNumberAccess().getGroup(), "rule__Number__Group__0");
			builder.put(grammarAccess.getNumberAccess().getGroup_2(), "rule__Number__Group_2__0");
			builder.put(grammarAccess.getEditorEnumExpressionAccess().getGroup(), "rule__EditorEnumExpression__Group__0");
			builder.put(grammarAccess.getEditorParameterExpressionAccess().getGroup(), "rule__EditorParameterExpression__Group__0");
			builder.put(grammarAccess.getEditorReferenceAccess().getGroup(), "rule__EditorReference__Group__0");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getGroup(), "rule__EditorReferenceIterator__Group__0");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getGroup_4(), "rule__EditorReferenceIterator__Group_4__0");
			builder.put(grammarAccess.getEditorIteratorAttributeExpressionAccess().getGroup(), "rule__EditorIteratorAttributeExpression__Group__0");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getGroup(), "rule__EditorIteratorAttributeAssignmentItr__Group__0");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getGroup(), "rule__EditorIteratorAttributeAssignmentNode__Group__0");
			builder.put(grammarAccess.getEditorIteratorReferenceAccess().getGroup(), "rule__EditorIteratorReference__Group__0");
			builder.put(grammarAccess.getEditorConditionAccess().getGroup(), "rule__EditorCondition__Group__0");
			builder.put(grammarAccess.getEditorConditionAccess().getGroup_4(), "rule__EditorCondition__Group_4__0");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getGroup_0(), "rule__EditorSimpleCondition__Group_0__0");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getGroup_1(), "rule__EditorSimpleCondition__Group_1__0");
			builder.put(grammarAccess.getStochasticFunctionAccess().getGroup(), "rule__StochasticFunction__Group__0");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getGroup(), "rule__StochasticFunctionExpression__Group__0");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getGroup_4(), "rule__StochasticFunctionExpression__Group_4__0");
			builder.put(grammarAccess.getAddExpressionAccess().getGroup(), "rule__AddExpression__Group__0");
			builder.put(grammarAccess.getAddExpressionAccess().getGroup_1(), "rule__AddExpression__Group_1__0");
			builder.put(grammarAccess.getMultExpressionAccess().getGroup(), "rule__MultExpression__Group__0");
			builder.put(grammarAccess.getMultExpressionAccess().getGroup_1(), "rule__MultExpression__Group_1__0");
			builder.put(grammarAccess.getExpExpressionAccess().getGroup(), "rule__ExpExpression__Group__0");
			builder.put(grammarAccess.getExpExpressionAccess().getGroup_1(), "rule__ExpExpression__Group_1__0");
			builder.put(grammarAccess.getMinMaxExpressionAccess().getGroup(), "rule__MinMaxExpression__Group__0");
			builder.put(grammarAccess.getOneParameterArithmeticsAccess().getGroup_0(), "rule__OneParameterArithmetics__Group_0__0");
			builder.put(grammarAccess.getEditorGTFileAccess().getImportsAssignment_0(), "rule__EditorGTFile__ImportsAssignment_0");
			builder.put(grammarAccess.getEditorGTFileAccess().getPatternsAssignment_1_0(), "rule__EditorGTFile__PatternsAssignment_1_0");
			builder.put(grammarAccess.getEditorGTFileAccess().getConditionsAssignment_1_1(), "rule__EditorGTFile__ConditionsAssignment_1_1");
			builder.put(grammarAccess.getEditorImportAccess().getNameAssignment_1(), "rule__EditorImport__NameAssignment_1");
			builder.put(grammarAccess.getEditorPatternAccess().getAbstractAssignment_0(), "rule__EditorPattern__AbstractAssignment_0");
			builder.put(grammarAccess.getEditorPatternAccess().getTypeAssignment_1(), "rule__EditorPattern__TypeAssignment_1");
			builder.put(grammarAccess.getEditorPatternAccess().getNameAssignment_2(), "rule__EditorPattern__NameAssignment_2");
			builder.put(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_0(), "rule__EditorPattern__ParametersAssignment_3_1_0");
			builder.put(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_1_1(), "rule__EditorPattern__ParametersAssignment_3_1_1_1");
			builder.put(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_1(), "rule__EditorPattern__SuperPatternsAssignment_4_1");
			builder.put(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_2_1(), "rule__EditorPattern__SuperPatternsAssignment_4_2_1");
			builder.put(grammarAccess.getEditorPatternAccess().getNodesAssignment_5_1_0(), "rule__EditorPattern__NodesAssignment_5_1_0");
			builder.put(grammarAccess.getEditorPatternAccess().getAttributeConstraintsAssignment_5_1_1(), "rule__EditorPattern__AttributeConstraintsAssignment_5_1_1");
			builder.put(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_1(), "rule__EditorPattern__ConditionsAssignment_6_1");
			builder.put(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_2_1(), "rule__EditorPattern__ConditionsAssignment_6_2_1");
			builder.put(grammarAccess.getEditorPatternAccess().getStochasticAssignment_7_0(), "rule__EditorPattern__StochasticAssignment_7_0");
			builder.put(grammarAccess.getEditorPatternAccess().getProbabilityAssignment_7_1(), "rule__EditorPattern__ProbabilityAssignment_7_1");
			builder.put(grammarAccess.getEditorParameterAccess().getNameAssignment_0(), "rule__EditorParameter__NameAssignment_0");
			builder.put(grammarAccess.getEditorParameterAccess().getTypeAssignment_2(), "rule__EditorParameter__TypeAssignment_2");
			builder.put(grammarAccess.getEditorNodeAccess().getOperatorAssignment_0(), "rule__EditorNode__OperatorAssignment_0");
			builder.put(grammarAccess.getEditorNodeAccess().getLocalAssignment_1(), "rule__EditorNode__LocalAssignment_1");
			builder.put(grammarAccess.getEditorNodeAccess().getNameAssignment_2(), "rule__EditorNode__NameAssignment_2");
			builder.put(grammarAccess.getEditorNodeAccess().getTypeAssignment_4(), "rule__EditorNode__TypeAssignment_4");
			builder.put(grammarAccess.getEditorNodeAccess().getAttributesAssignment_5_1_0(), "rule__EditorNode__AttributesAssignment_5_1_0");
			builder.put(grammarAccess.getEditorNodeAccess().getReferencesAssignment_5_1_1(), "rule__EditorNode__ReferencesAssignment_5_1_1");
			builder.put(grammarAccess.getEditorNodeAccess().getIteratorsAssignment_5_1_2(), "rule__EditorNode__IteratorsAssignment_5_1_2");
			builder.put(grammarAccess.getEditorAttributeConstraintAccess().getLhsAssignment_1(), "rule__EditorAttributeConstraint__LhsAssignment_1");
			builder.put(grammarAccess.getEditorAttributeConstraintAccess().getRelationAssignment_2(), "rule__EditorAttributeConstraint__RelationAssignment_2");
			builder.put(grammarAccess.getEditorAttributeConstraintAccess().getRhsAssignment_3(), "rule__EditorAttributeConstraint__RhsAssignment_3");
			builder.put(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeAssignment_1(), "rule__EditorAttributeAssignment__AttributeAssignment_1");
			builder.put(grammarAccess.getEditorAttributeAssignmentAccess().getValueAssignment_3(), "rule__EditorAttributeAssignment__ValueAssignment_3");
			builder.put(grammarAccess.getEditorAttributeExpressionAccess().getNodeAssignment_0(), "rule__EditorAttributeExpression__NodeAssignment_0");
			builder.put(grammarAccess.getEditorAttributeExpressionAccess().getAttributeAssignment_2(), "rule__EditorAttributeExpression__AttributeAssignment_2");
			builder.put(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenAssignment_2(), "rule__EditorCountExpression__InvokedPattenAssignment_2");
			builder.put(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_0(), "rule__EditorLiteralExpression__ValueAssignment_0");
			builder.put(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_1_1(), "rule__EditorLiteralExpression__ValueAssignment_1_1");
			builder.put(grammarAccess.getEditorEnumExpressionAccess().getLiteralAssignment_1(), "rule__EditorEnumExpression__LiteralAssignment_1");
			builder.put(grammarAccess.getEditorParameterExpressionAccess().getParameterAssignment_1(), "rule__EditorParameterExpression__ParameterAssignment_1");
			builder.put(grammarAccess.getEditorReferenceAccess().getOperatorAssignment_0(), "rule__EditorReference__OperatorAssignment_0");
			builder.put(grammarAccess.getEditorReferenceAccess().getTypeAssignment_2(), "rule__EditorReference__TypeAssignment_2");
			builder.put(grammarAccess.getEditorReferenceAccess().getTargetAssignment_4(), "rule__EditorReference__TargetAssignment_4");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getTypeAssignment_1(), "rule__EditorReferenceIterator__TypeAssignment_1");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getNameAssignment_3(), "rule__EditorReferenceIterator__NameAssignment_3");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeAssignment_4_1(), "rule__EditorReferenceIterator__SubTypeAssignment_4_1");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesAssignment_6_0(), "rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0");
			builder.put(grammarAccess.getEditorReferenceIteratorAccess().getReferencesAssignment_6_1(), "rule__EditorReferenceIterator__ReferencesAssignment_6_1");
			builder.put(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorAssignment_1(), "rule__EditorIteratorAttributeExpression__IteratorAssignment_1");
			builder.put(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeAssignment_3(), "rule__EditorIteratorAttributeExpression__AttributeAssignment_3");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeAssignment_0(), "rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueAssignment_2(), "rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeAssignment_0(), "rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0");
			builder.put(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueAssignment_2(), "rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2");
			builder.put(grammarAccess.getEditorIteratorReferenceAccess().getOperatorAssignment_0(), "rule__EditorIteratorReference__OperatorAssignment_0");
			builder.put(grammarAccess.getEditorIteratorReferenceAccess().getSourceAssignment_1(), "rule__EditorIteratorReference__SourceAssignment_1");
			builder.put(grammarAccess.getEditorIteratorReferenceAccess().getTypeAssignment_3(), "rule__EditorIteratorReference__TypeAssignment_3");
			builder.put(grammarAccess.getEditorIteratorReferenceAccess().getTargetAssignment_5(), "rule__EditorIteratorReference__TargetAssignment_5");
			builder.put(grammarAccess.getEditorConditionAccess().getNameAssignment_1(), "rule__EditorCondition__NameAssignment_1");
			builder.put(grammarAccess.getEditorConditionAccess().getConditionsAssignment_3(), "rule__EditorCondition__ConditionsAssignment_3");
			builder.put(grammarAccess.getEditorConditionAccess().getConditionsAssignment_4_1(), "rule__EditorCondition__ConditionsAssignment_4_1");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getConditionAssignment_0_1(), "rule__EditorSimpleCondition__ConditionAssignment_0_1");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getTypeAssignment_1_1(), "rule__EditorSimpleCondition__TypeAssignment_1_1");
			builder.put(grammarAccess.getEditorSimpleConditionAccess().getPatternAssignment_1_2(), "rule__EditorSimpleCondition__PatternAssignment_1_2");
			builder.put(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionAssignment_0(), "rule__StochasticFunction__FunctionExpressionAssignment_0");
			builder.put(grammarAccess.getStochasticFunctionAccess().getParameterAssignment_1(), "rule__StochasticFunction__ParameterAssignment_1");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeAssignment_0(), "rule__StochasticFunctionExpression__OperatorRangeAssignment_0");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionAssignment_1(), "rule__StochasticFunctionExpression__DistributionAssignment_1");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getMeanAssignment_3(), "rule__StochasticFunctionExpression__MeanAssignment_3");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdAssignment_4_0(), "rule__StochasticFunctionExpression__HasSdAssignment_4_0");
			builder.put(grammarAccess.getStochasticFunctionExpressionAccess().getSdAssignment_4_1(), "rule__StochasticFunctionExpression__SdAssignment_4_1");
			builder.put(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionAssignment(), "rule__ArithmeticCalculationExpression__ExpressionAssignment");
			builder.put(grammarAccess.getAddExpressionAccess().getAddOperatorAssignment_1_1(), "rule__AddExpression__AddOperatorAssignment_1_1");
			builder.put(grammarAccess.getAddExpressionAccess().getRightAssignment_1_2(), "rule__AddExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getMultExpressionAccess().getMultOperatorAssignment_1_1(), "rule__MultExpression__MultOperatorAssignment_1_1");
			builder.put(grammarAccess.getMultExpressionAccess().getRightAssignment_1_2(), "rule__MultExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getExpExpressionAccess().getRightAssignment_1_2(), "rule__ExpExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorAssignment_1(), "rule__MinMaxExpression__MinMaxOperatorAssignment_1");
			builder.put(grammarAccess.getMinMaxExpressionAccess().getLeftAssignment_3(), "rule__MinMaxExpression__LeftAssignment_3");
			builder.put(grammarAccess.getMinMaxExpressionAccess().getRightAssignment_5(), "rule__MinMaxExpression__RightAssignment_5");
			builder.put(grammarAccess.getOneParameterArithmeticsAccess().getNegativeAssignment_0_1(), "rule__OneParameterArithmetics__NegativeAssignment_0_1");
			builder.put(grammarAccess.getOneParameterArithmeticsAccess().getOperatorAssignment_0_2(), "rule__OneParameterArithmetics__OperatorAssignment_0_2");
			builder.put(grammarAccess.getOneParameterArithmeticsAccess().getExpressionAssignment_0_4(), "rule__OneParameterArithmetics__ExpressionAssignment_0_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private GTGrammarAccess grammarAccess;

	@Override
	protected InternalGTParser createParser() {
		InternalGTParser result = new InternalGTParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public GTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(GTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
