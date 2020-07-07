/*
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.emoflon.ibex.tgg.integrate.ide.contentassist.antlr.internal.InternalIntegrateParser;
import org.emoflon.ibex.tgg.integrate.services.IntegrateGrammarAccess;

public class IntegrateParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(IntegrateGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, IntegrateGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPipelineAccess().getFirstAlternatives_0_0(), "rule__Pipeline__FirstAlternatives_0_0");
			builder.put(grammarAccess.getPipelineStageAccess().getAlternatives(), "rule__PipelineStage__Alternatives");
			builder.put(grammarAccess.getPipelineFilterStageAccess().getAlternatives(), "rule__PipelineFilterStage__Alternatives");
			builder.put(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAlternatives_1_0(), "rule__SatisfactionRule__OtherRulesAlternatives_1_0");
			builder.put(grammarAccess.getComparisonAccess().getAlternatives_0(), "rule__Comparison__Alternatives_0");
			builder.put(grammarAccess.getComparisonAccess().getC1Alternatives_1_0(), "rule__Comparison__C1Alternatives_1_0");
			builder.put(grammarAccess.getComparisonAccess().getAlternatives_2(), "rule__Comparison__Alternatives_2");
			builder.put(grammarAccess.getIntegrateAccess().getGroup(), "rule__Integrate__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getConflictResolutionStrategyAccess().getGroup(), "rule__ConflictResolutionStrategy__Group__0");
			builder.put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
			builder.put(grammarAccess.getPipelineAccess().getGroup(), "rule__Pipeline__Group__0");
			builder.put(grammarAccess.getPipelineAccess().getGroup_1(), "rule__Pipeline__Group_1__0");
			builder.put(grammarAccess.getPipelineStageAccess().getGroup_1(), "rule__PipelineStage__Group_1__0");
			builder.put(grammarAccess.getPipelineFilterStageAccess().getGroup_0(), "rule__PipelineFilterStage__Group_0__0");
			builder.put(grammarAccess.getPipelineFilterStageAccess().getGroup_1(), "rule__PipelineFilterStage__Group_1__0");
			builder.put(grammarAccess.getPipelineTypeFilterStageAccess().getGroup(), "rule__PipelineTypeFilterStage__Group__0");
			builder.put(grammarAccess.getSatisfactionRuleAccess().getGroup(), "rule__SatisfactionRule__Group__0");
			builder.put(grammarAccess.getAndAccess().getGroup(), "rule__And__Group__0");
			builder.put(grammarAccess.getOrAccess().getGroup(), "rule__Or__Group__0");
			builder.put(grammarAccess.getComparisonAccess().getGroup(), "rule__Comparison__Group__0");
			builder.put(grammarAccess.getIntegrateAccess().getImportsAssignment_0(), "rule__Integrate__ImportsAssignment_0");
			builder.put(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesAssignment_1(), "rule__Integrate__ConflictResolutionStrategiesAssignment_1");
			builder.put(grammarAccess.getImportAccess().getNameAssignment_1(), "rule__Import__NameAssignment_1");
			builder.put(grammarAccess.getConflictResolutionStrategyAccess().getVariablesAssignment_6(), "rule__ConflictResolutionStrategy__VariablesAssignment_6");
			builder.put(grammarAccess.getConflictResolutionStrategyAccess().getRuleAssignment_9(), "rule__ConflictResolutionStrategy__RuleAssignment_9");
			builder.put(grammarAccess.getVariableAccess().getNameAssignment_1(), "rule__Variable__NameAssignment_1");
			builder.put(grammarAccess.getVariableAccess().getPipelineAssignment_3(), "rule__Variable__PipelineAssignment_3");
			builder.put(grammarAccess.getPipelineAccess().getFirstAssignment_0(), "rule__Pipeline__FirstAssignment_0");
			builder.put(grammarAccess.getPipelineAccess().getNextAssignment_1_1(), "rule__Pipeline__NextAssignment_1_1");
			builder.put(grammarAccess.getPipelineTypeFilterStageAccess().getTypesAssignment_1(), "rule__PipelineTypeFilterStage__TypesAssignment_1");
			builder.put(grammarAccess.getSatisfactionRuleAccess().getFirstRuleAssignment_0(), "rule__SatisfactionRule__FirstRuleAssignment_0");
			builder.put(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAssignment_1(), "rule__SatisfactionRule__OtherRulesAssignment_1");
			builder.put(grammarAccess.getComparisonAccess().getV1Assignment_0_0(), "rule__Comparison__V1Assignment_0_0");
			builder.put(grammarAccess.getComparisonAccess().getN1Assignment_0_1(), "rule__Comparison__N1Assignment_0_1");
			builder.put(grammarAccess.getComparisonAccess().getC1Assignment_1(), "rule__Comparison__C1Assignment_1");
			builder.put(grammarAccess.getComparisonAccess().getV2Assignment_2_0(), "rule__Comparison__V2Assignment_2_0");
			builder.put(grammarAccess.getComparisonAccess().getN2Assignment_2_1(), "rule__Comparison__N2Assignment_2_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private IntegrateGrammarAccess grammarAccess;

	@Override
	protected InternalIntegrateParser createParser() {
		InternalIntegrateParser result = new InternalIntegrateParser(null);
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

	public IntegrateGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(IntegrateGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
