/**
 * generated by Xtext 2.20.0
 */
package org.emoflon.ibex.tgg.integrate.integrate.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emoflon.ibex.tgg.integrate.integrate.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage
 * @generated
 */
public class IntegrateAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static IntegratePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegrateAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = IntegratePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrateSwitch<Adapter> modelSwitch =
    new IntegrateSwitch<Adapter>()
    {
      @Override
      public Adapter caseIntegrate(Integrate object)
      {
        return createIntegrateAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseConflictResolutionStrategy(ConflictResolutionStrategy object)
      {
        return createConflictResolutionStrategyAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter casePipeline(Pipeline object)
      {
        return createPipelineAdapter();
      }
      @Override
      public Adapter casePipelineStageSrc(PipelineStageSrc object)
      {
        return createPipelineStageSrcAdapter();
      }
      @Override
      public Adapter casePipelineStageTrg(PipelineStageTrg object)
      {
        return createPipelineStageTrgAdapter();
      }
      @Override
      public Adapter casePipelineStage(PipelineStage object)
      {
        return createPipelineStageAdapter();
      }
      @Override
      public Adapter casePipelineFilterStage(PipelineFilterStage object)
      {
        return createPipelineFilterStageAdapter();
      }
      @Override
      public Adapter casePipelineCreatedFilterStage(PipelineCreatedFilterStage object)
      {
        return createPipelineCreatedFilterStageAdapter();
      }
      @Override
      public Adapter casePipelineDeletedFilterStage(PipelineDeletedFilterStage object)
      {
        return createPipelineDeletedFilterStageAdapter();
      }
      @Override
      public Adapter casePipelineTypeFilterStage(PipelineTypeFilterStage object)
      {
        return createPipelineTypeFilterStageAdapter();
      }
      @Override
      public Adapter casePipelineCountStage(PipelineCountStage object)
      {
        return createPipelineCountStageAdapter();
      }
      @Override
      public Adapter caseSatisfactionRule(SatisfactionRule object)
      {
        return createSatisfactionRuleAdapter();
      }
      @Override
      public Adapter caseAnd(And object)
      {
        return createAndAdapter();
      }
      @Override
      public Adapter caseOr(Or object)
      {
        return createOrAdapter();
      }
      @Override
      public Adapter caseComparison(Comparison object)
      {
        return createComparisonAdapter();
      }
      @Override
      public Adapter caseResolutionStrategy(ResolutionStrategy object)
      {
        return createResolutionStrategyAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Integrate <em>Integrate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Integrate
   * @generated
   */
  public Adapter createIntegrateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy <em>Conflict Resolution Strategy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionStrategy
   * @generated
   */
  public Adapter createConflictResolutionStrategyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Pipeline <em>Pipeline</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Pipeline
   * @generated
   */
  public Adapter createPipelineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc <em>Pipeline Stage Src</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc
   * @generated
   */
  public Adapter createPipelineStageSrcAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageTrg <em>Pipeline Stage Trg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineStageTrg
   * @generated
   */
  public Adapter createPipelineStageTrgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStage <em>Pipeline Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineStage
   * @generated
   */
  public Adapter createPipelineStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineFilterStage <em>Pipeline Filter Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineFilterStage
   * @generated
   */
  public Adapter createPipelineFilterStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineCreatedFilterStage <em>Pipeline Created Filter Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineCreatedFilterStage
   * @generated
   */
  public Adapter createPipelineCreatedFilterStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineDeletedFilterStage <em>Pipeline Deleted Filter Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineDeletedFilterStage
   * @generated
   */
  public Adapter createPipelineDeletedFilterStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineTypeFilterStage <em>Pipeline Type Filter Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineTypeFilterStage
   * @generated
   */
  public Adapter createPipelineTypeFilterStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineCountStage <em>Pipeline Count Stage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.PipelineCountStage
   * @generated
   */
  public Adapter createPipelineCountStageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule <em>Satisfaction Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule
   * @generated
   */
  public Adapter createSatisfactionRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.And
   * @generated
   */
  public Adapter createAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Or
   * @generated
   */
  public Adapter createOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.Comparison <em>Comparison</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.Comparison
   * @generated
   */
  public Adapter createComparisonAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategy <em>Resolution Strategy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategy
   * @generated
   */
  public Adapter createResolutionStrategyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //IntegrateAdapterFactory
