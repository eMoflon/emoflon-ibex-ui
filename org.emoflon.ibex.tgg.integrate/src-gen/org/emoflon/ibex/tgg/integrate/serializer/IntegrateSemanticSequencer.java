/*
 * generated by Xtext 2.28.0
 */
package org.emoflon.ibex.tgg.integrate.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.emoflon.ibex.tgg.integrate.integrate.AndExpression;
import org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression;
import org.emoflon.ibex.tgg.integrate.integrate.ComparisonExpression;
import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionSpecification;
import org.emoflon.ibex.tgg.integrate.integrate.ContinueResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.DeleteCorrespondencesResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.Import;
import org.emoflon.ibex.tgg.integrate.integrate.Integrate;
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.LiteralValue;
import org.emoflon.ibex.tgg.integrate.integrate.MergeAndPreserveResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta;
import org.emoflon.ibex.tgg.integrate.integrate.OrExpression;
import org.emoflon.ibex.tgg.integrate.integrate.Pipeline;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageCount;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageCreated;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageDeleted;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageExists;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageTrg;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType;
import org.emoflon.ibex.tgg.integrate.integrate.PreferSourceResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.PreferTargetResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.Resolution;
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategyWithOperationalDelta;
import org.emoflon.ibex.tgg.integrate.integrate.RevokeAdditionResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.RevokeDeletionResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule;
import org.emoflon.ibex.tgg.integrate.integrate.Variable;
import org.emoflon.ibex.tgg.integrate.integrate.VariableReference;
import org.emoflon.ibex.tgg.integrate.integrate.WrappedOrExpression;
import org.emoflon.ibex.tgg.integrate.services.IntegrateGrammarAccess;

@SuppressWarnings("all")
public class IntegrateSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IntegrateGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == IntegratePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IntegratePackage.AND_EXPRESSION:
				sequence_AndExpression(context, (AndExpression) semanticObject); 
				return; 
			case IntegratePackage.BOOLEAN_EXPRESSION:
				sequence_BooleanExpression(context, (BooleanExpression) semanticObject); 
				return; 
			case IntegratePackage.COMPARISON_EXPRESSION:
				sequence_ComparisonExpression(context, (ComparisonExpression) semanticObject); 
				return; 
			case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION:
				sequence_ConflictResolutionSpecification(context, (ConflictResolutionSpecification) semanticObject); 
				return; 
			case IntegratePackage.CONTINUE_RESOLUTION_STRATEGY:
				sequence_ContinueResolutionStrategy(context, (ContinueResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.DELETE_CORRESPONDENCES_RESOLUTION_STRATEGY:
				sequence_DeleteCorrespondencesResolutionStrategy(context, (DeleteCorrespondencesResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case IntegratePackage.INTEGRATE:
				sequence_Integrate(context, (Integrate) semanticObject); 
				return; 
			case IntegratePackage.LITERAL_VALUE:
				sequence_LiteralValue(context, (LiteralValue) semanticObject); 
				return; 
			case IntegratePackage.MERGE_AND_PRESERVE_RESOLUTION_STRATEGY:
				sequence_MergeAndPreserveResolutionStrategy(context, (MergeAndPreserveResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.OPERATIONAL_DELTA:
				sequence_OperationalDelta(context, (OperationalDelta) semanticObject); 
				return; 
			case IntegratePackage.OR_EXPRESSION:
				sequence_OrExpression(context, (OrExpression) semanticObject); 
				return; 
			case IntegratePackage.PACKAGE:
				sequence_Package(context, (org.emoflon.ibex.tgg.integrate.integrate.Package) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE:
				sequence_Pipeline(context, (Pipeline) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_COUNT:
				sequence_PipelineStageCount(context, (PipelineStageCount) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_CREATED:
				sequence_PipelineStageCreated(context, (PipelineStageCreated) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_DELETED:
				sequence_PipelineStageDeleted(context, (PipelineStageDeleted) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_EXISTS:
				sequence_PipelineStageExists(context, (PipelineStageExists) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_SRC:
				sequence_PipelineStageSrc(context, (PipelineStageSrc) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_TRG:
				sequence_PipelineStageTrg(context, (PipelineStageTrg) semanticObject); 
				return; 
			case IntegratePackage.PIPELINE_STAGE_TYPE:
				sequence_PipelineStageType(context, (PipelineStageType) semanticObject); 
				return; 
			case IntegratePackage.PREFER_SOURCE_RESOLUTION_STRATEGY:
				sequence_PreferSourceResolutionStrategy(context, (PreferSourceResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.PREFER_TARGET_RESOLUTION_STRATEGY:
				sequence_PreferTargetResolutionStrategy(context, (PreferTargetResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.RESOLUTION:
				sequence_Resolution(context, (Resolution) semanticObject); 
				return; 
			case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA:
				sequence_ResolutionStrategyWithOperationalDelta(context, (ResolutionStrategyWithOperationalDelta) semanticObject); 
				return; 
			case IntegratePackage.REVOKE_ADDITION_RESOLUTION_STRATEGY:
				sequence_RevokeAdditionResolutionStrategy(context, (RevokeAdditionResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.REVOKE_DELETION_RESOLUTION_STRATEGY:
				sequence_RevokeDeletionResolutionStrategy(context, (RevokeDeletionResolutionStrategy) semanticObject); 
				return; 
			case IntegratePackage.SATISFACTION_RULE:
				sequence_SatisfactionRule(context, (SatisfactionRule) semanticObject); 
				return; 
			case IntegratePackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			case IntegratePackage.VARIABLE_REFERENCE:
				sequence_VariableReference(context, (VariableReference) semanticObject); 
				return; 
			case IntegratePackage.WRAPPED_OR_EXPRESSION:
				sequence_WrappedOrExpression(context, (WrappedOrExpression) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     OrExpression returns AndExpression
	 *     OrExpression.OrExpression_1_0 returns AndExpression
	 *     AndExpression returns AndExpression
	 *     AndExpression.AndExpression_1_0 returns AndExpression
	 *
	 * Constraint:
	 *     (left=AndExpression_AndExpression_1_0 right+=BooleanExpression)
	 * </pre>
	 */
	protected void sequence_AndExpression(ISerializationContext context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OrExpression returns BooleanExpression
	 *     OrExpression.OrExpression_1_0 returns BooleanExpression
	 *     AndExpression returns BooleanExpression
	 *     AndExpression.AndExpression_1_0 returns BooleanExpression
	 *     BooleanExpression returns BooleanExpression
	 *
	 * Constraint:
	 *     (invert?='not'? (expression=ComparisonExpression | expression=VariableReference | expression=WrappedOrExpression))
	 * </pre>
	 */
	protected void sequence_BooleanExpression(ISerializationContext context, BooleanExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ComparisonExpression returns ComparisonExpression
	 *
	 * Constraint:
	 *     (
	 *         lhs=ComparisonParameter 
	 *         (
	 *             op='&gt;' | 
	 *             op='&gt;=' | 
	 *             op='&lt;' | 
	 *             op='&lt;=' | 
	 *             op='==' | 
	 *             op='!='
	 *         ) 
	 *         rhs=ComparisonParameter
	 *     )
	 * </pre>
	 */
	protected void sequence_ComparisonExpression(ISerializationContext context, ComparisonExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ConflictResolutionSpecification returns ConflictResolutionSpecification
	 *
	 * Constraint:
	 *     (name=ID variables+=Variable+ rule=SatisfactionRule resolution=Resolution)
	 * </pre>
	 */
	protected void sequence_ConflictResolutionSpecification(ISerializationContext context, ConflictResolutionSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns ContinueResolutionStrategy
	 *     FallbackResolutionStrategy returns ContinueResolutionStrategy
	 *     ContinueResolutionStrategy returns ContinueResolutionStrategy
	 *
	 * Constraint:
	 *     name='continue'
	 * </pre>
	 */
	protected void sequence_ContinueResolutionStrategy(ISerializationContext context, ContinueResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns DeleteCorrespondencesResolutionStrategy
	 *     FallbackResolutionStrategy returns DeleteCorrespondencesResolutionStrategy
	 *     DeleteCorrespondencesResolutionStrategy returns DeleteCorrespondencesResolutionStrategy
	 *
	 * Constraint:
	 *     name='deleteCorrespondences'
	 * </pre>
	 */
	protected void sequence_DeleteCorrespondencesResolutionStrategy(ISerializationContext context, DeleteCorrespondencesResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     schema=[Schema|ID]
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.IMPORT__SCHEMA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.IMPORT__SCHEMA));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getSchemaSchemaIDTerminalRuleCall_1_0_1(), semanticObject.eGet(IntegratePackage.Literals.IMPORT__SCHEMA, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Integrate returns Integrate
	 *
	 * Constraint:
	 *     (package=Package? imports+=Import conflictResolutionSpecifications+=ConflictResolutionSpecification*)
	 * </pre>
	 */
	protected void sequence_Integrate(ISerializationContext context, Integrate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ComparisonParameter returns LiteralValue
	 *     LiteralValue returns LiteralValue
	 *
	 * Constraint:
	 *     value=INT
	 * </pre>
	 */
	protected void sequence_LiteralValue(ISerializationContext context, LiteralValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.LITERAL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.LITERAL_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralValueAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns MergeAndPreserveResolutionStrategy
	 *     MergeAndPreserveResolutionStrategy returns MergeAndPreserveResolutionStrategy
	 *
	 * Constraint:
	 *     name='mergeAndPreserve'
	 * </pre>
	 */
	protected void sequence_MergeAndPreserveResolutionStrategy(ISerializationContext context, MergeAndPreserveResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OperationalDelta returns OperationalDelta
	 *
	 * Constraint:
	 *     (variables+=Variable+ rule=SatisfactionRule)
	 * </pre>
	 */
	protected void sequence_OperationalDelta(ISerializationContext context, OperationalDelta semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OrExpression returns OrExpression
	 *     OrExpression.OrExpression_1_0 returns OrExpression
	 *
	 * Constraint:
	 *     (left=OrExpression_OrExpression_1_0 right+=AndExpression)
	 * </pre>
	 */
	protected void sequence_OrExpression(ISerializationContext context, OrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Package returns Package
	 *
	 * Constraint:
	 *     name=QualifiedName
	 * </pre>
	 */
	protected void sequence_Package(ISerializationContext context, org.emoflon.ibex.tgg.integrate.integrate.Package semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.PACKAGE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.PACKAGE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPackageAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageEnd returns PipelineStageCount
	 *     PipelineStageCount returns PipelineStageCount
	 *
	 * Constraint:
	 *     name='count'
	 * </pre>
	 */
	protected void sequence_PipelineStageCount(ISerializationContext context, PipelineStageCount semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.PIPELINE_STAGE_END__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.PIPELINE_STAGE_END__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageFilter returns PipelineStageCreated
	 *     PipelineStageModification returns PipelineStageCreated
	 *     PipelineStageCreated returns PipelineStageCreated
	 *
	 * Constraint:
	 *     (name='created' (next=PipelineStageType | next=PipelineStageEnd))
	 * </pre>
	 */
	protected void sequence_PipelineStageCreated(ISerializationContext context, PipelineStageCreated semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageFilter returns PipelineStageDeleted
	 *     PipelineStageModification returns PipelineStageDeleted
	 *     PipelineStageDeleted returns PipelineStageDeleted
	 *
	 * Constraint:
	 *     (name='deleted' (next=PipelineStageType | next=PipelineStageEnd))
	 * </pre>
	 */
	protected void sequence_PipelineStageDeleted(ISerializationContext context, PipelineStageDeleted semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageEnd returns PipelineStageExists
	 *     PipelineStageExists returns PipelineStageExists
	 *
	 * Constraint:
	 *     name='exists'
	 * </pre>
	 */
	protected void sequence_PipelineStageExists(ISerializationContext context, PipelineStageExists semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.PIPELINE_STAGE_END__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.PIPELINE_STAGE_END__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageStart returns PipelineStageSrc
	 *     PipelineStageSrc returns PipelineStageSrc
	 *
	 * Constraint:
	 *     (name='src' (next=PipelineStageFilter | next=PipelineStageEnd))
	 * </pre>
	 */
	protected void sequence_PipelineStageSrc(ISerializationContext context, PipelineStageSrc semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageStart returns PipelineStageTrg
	 *     PipelineStageTrg returns PipelineStageTrg
	 *
	 * Constraint:
	 *     (name='trg' (next=PipelineStageFilter | next=PipelineStageEnd))
	 * </pre>
	 */
	protected void sequence_PipelineStageTrg(ISerializationContext context, PipelineStageTrg semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PipelineStageFilter returns PipelineStageType
	 *     PipelineStageType returns PipelineStageType
	 *
	 * Constraint:
	 *     (name='type' types+=[EClass|ID] types+=[EClass|ID]* next=PipelineStageEnd)
	 * </pre>
	 */
	protected void sequence_PipelineStageType(ISerializationContext context, PipelineStageType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Pipeline returns Pipeline
	 *
	 * Constraint:
	 *     start=PipelineStageStart
	 * </pre>
	 */
	protected void sequence_Pipeline(ISerializationContext context, Pipeline semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.PIPELINE__START) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.PIPELINE__START));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPipelineAccess().getStartPipelineStageStartParserRuleCall_0(), semanticObject.getStart());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns PreferSourceResolutionStrategy
	 *     FallbackResolutionStrategy returns PreferSourceResolutionStrategy
	 *     PreferSourceResolutionStrategy returns PreferSourceResolutionStrategy
	 *
	 * Constraint:
	 *     name='preferSource'
	 * </pre>
	 */
	protected void sequence_PreferSourceResolutionStrategy(ISerializationContext context, PreferSourceResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns PreferTargetResolutionStrategy
	 *     FallbackResolutionStrategy returns PreferTargetResolutionStrategy
	 *     PreferTargetResolutionStrategy returns PreferTargetResolutionStrategy
	 *
	 * Constraint:
	 *     name='preferTarget'
	 * </pre>
	 */
	protected void sequence_PreferTargetResolutionStrategy(ISerializationContext context, PreferTargetResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategyWithOperationalDelta returns ResolutionStrategyWithOperationalDelta
	 *
	 * Constraint:
	 *     (strategy=ResolutionStrategy operationalDelta=OperationalDelta?)
	 * </pre>
	 */
	protected void sequence_ResolutionStrategyWithOperationalDelta(ISerializationContext context, ResolutionStrategyWithOperationalDelta semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Resolution returns Resolution
	 *
	 * Constraint:
	 *     (strategies+=ResolutionStrategyWithOperationalDelta strategies+=ResolutionStrategyWithOperationalDelta* fallback=FallbackResolutionStrategy?)
	 * </pre>
	 */
	protected void sequence_Resolution(ISerializationContext context, Resolution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns RevokeAdditionResolutionStrategy
	 *     RevokeAdditionResolutionStrategy returns RevokeAdditionResolutionStrategy
	 *
	 * Constraint:
	 *     name='revokeAddition'
	 * </pre>
	 */
	protected void sequence_RevokeAdditionResolutionStrategy(ISerializationContext context, RevokeAdditionResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ResolutionStrategy returns RevokeDeletionResolutionStrategy
	 *     RevokeDeletionResolutionStrategy returns RevokeDeletionResolutionStrategy
	 *
	 * Constraint:
	 *     name='revokeDeletion'
	 * </pre>
	 */
	protected void sequence_RevokeDeletionResolutionStrategy(ISerializationContext context, RevokeDeletionResolutionStrategy semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.RESOLUTION_STRATEGY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SatisfactionRule returns SatisfactionRule
	 *
	 * Constraint:
	 *     expression=OrExpression
	 * </pre>
	 */
	protected void sequence_SatisfactionRule(ISerializationContext context, SatisfactionRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.SATISFACTION_RULE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.SATISFACTION_RULE__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSatisfactionRuleAccess().getExpressionOrExpressionParserRuleCall_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VariableReference returns VariableReference
	 *     ComparisonParameter returns VariableReference
	 *
	 * Constraint:
	 *     ref=[Variable|ID]
	 * </pre>
	 */
	protected void sequence_VariableReference(ISerializationContext context, VariableReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.VARIABLE_REFERENCE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.VARIABLE_REFERENCE__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableReferenceAccess().getRefVariableIDTerminalRuleCall_0_1(), semanticObject.eGet(IntegratePackage.Literals.VARIABLE_REFERENCE__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (name=ID pipeline=Pipeline)
	 * </pre>
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.VARIABLE__NAME));
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.VARIABLE__PIPELINE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.VARIABLE__PIPELINE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getVariableAccess().getPipelinePipelineParserRuleCall_3_0(), semanticObject.getPipeline());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     WrappedOrExpression returns WrappedOrExpression
	 *
	 * Constraint:
	 *     expression=OrExpression
	 * </pre>
	 */
	protected void sequence_WrappedOrExpression(ISerializationContext context, WrappedOrExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IntegratePackage.Literals.WRAPPED_OR_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IntegratePackage.Literals.WRAPPED_OR_EXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWrappedOrExpressionAccess().getExpressionOrExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
}
