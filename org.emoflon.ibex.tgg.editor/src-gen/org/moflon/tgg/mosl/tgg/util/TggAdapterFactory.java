/**
 */
package org.moflon.tgg.mosl.tgg.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.moflon.tgg.mosl.tgg.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.moflon.tgg.mosl.tgg.TggPackage
 * @generated
 */
public class TggAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TggPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TggAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TggPackage.eINSTANCE;
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
  protected TggSwitch<Adapter> modelSwitch =
    new TggSwitch<Adapter>()
    {
      @Override
      public Adapter caseTripleGraphGrammarFile(TripleGraphGrammarFile object)
      {
        return createTripleGraphGrammarFileAdapter();
      }
      @Override
      public Adapter caseSchema(Schema object)
      {
        return createSchemaAdapter();
      }
      @Override
      public Adapter caseCorrType(CorrType object)
      {
        return createCorrTypeAdapter();
      }
      @Override
      public Adapter caseAttrCondDef(AttrCondDef object)
      {
        return createAttrCondDefAdapter();
      }
      @Override
      public Adapter caseParam(Param object)
      {
        return createParamAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseAttrCond(AttrCond object)
      {
        return createAttrCondAdapter();
      }
      @Override
      public Adapter caseAttrCondDefLibrary(AttrCondDefLibrary object)
      {
        return createAttrCondDefLibraryAdapter();
      }
      @Override
      public Adapter caseAdornment(Adornment object)
      {
        return createAdornmentAdapter();
      }
      @Override
      public Adapter caseParamValue(ParamValue object)
      {
        return createParamValueAdapter();
      }
      @Override
      public Adapter caseLocalVariable(LocalVariable object)
      {
        return createLocalVariableAdapter();
      }
      @Override
      public Adapter caseCorrVariablePattern(CorrVariablePattern object)
      {
        return createCorrVariablePatternAdapter();
      }
      @Override
      public Adapter caseObjectVariablePattern(ObjectVariablePattern object)
      {
        return createObjectVariablePatternAdapter();
      }
      @Override
      public Adapter caseContextObjectVariablePattern(ContextObjectVariablePattern object)
      {
        return createContextObjectVariablePatternAdapter();
      }
      @Override
      public Adapter caseAttributeConstraint(AttributeConstraint object)
      {
        return createAttributeConstraintAdapter();
      }
      @Override
      public Adapter caseAttributeAssignment(AttributeAssignment object)
      {
        return createAttributeAssignmentAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseEnumExpression(EnumExpression object)
      {
        return createEnumExpressionAdapter();
      }
      @Override
      public Adapter caseAttributeExpression(AttributeExpression object)
      {
        return createAttributeExpressionAdapter();
      }
      @Override
      public Adapter caseLiteralExpression(LiteralExpression object)
      {
        return createLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseLinkVariablePattern(LinkVariablePattern object)
      {
        return createLinkVariablePatternAdapter();
      }
      @Override
      public Adapter caseContextLinkVariablePattern(ContextLinkVariablePattern object)
      {
        return createContextLinkVariablePatternAdapter();
      }
      @Override
      public Adapter caseOperator(Operator object)
      {
        return createOperatorAdapter();
      }
      @Override
      public Adapter caseNac(Nac object)
      {
        return createNacAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseUsing(Using object)
      {
        return createUsingAdapter();
      }
      @Override
      public Adapter caseOperatorPattern(OperatorPattern object)
      {
        return createOperatorPatternAdapter();
      }
      @Override
      public Adapter caseNamedElements(NamedElements object)
      {
        return createNamedElementsAdapter();
      }
      @Override
      public Adapter caseNamePattern(NamePattern object)
      {
        return createNamePatternAdapter();
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
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile <em>Triple Graph Grammar File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
   * @generated
   */
  public Adapter createTripleGraphGrammarFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Schema <em>Schema</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Schema
   * @generated
   */
  public Adapter createSchemaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.CorrType <em>Corr Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.CorrType
   * @generated
   */
  public Adapter createCorrTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttrCondDef <em>Attr Cond Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef
   * @generated
   */
  public Adapter createAttrCondDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Param
   * @generated
   */
  public Adapter createParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttrCond <em>Attr Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttrCond
   * @generated
   */
  public Adapter createAttrCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttrCondDefLibrary <em>Attr Cond Def Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDefLibrary
   * @generated
   */
  public Adapter createAttrCondDefLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Adornment <em>Adornment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Adornment
   * @generated
   */
  public Adapter createAdornmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.ParamValue <em>Param Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.ParamValue
   * @generated
   */
  public Adapter createParamValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.LocalVariable <em>Local Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.LocalVariable
   * @generated
   */
  public Adapter createLocalVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern <em>Corr Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.CorrVariablePattern
   * @generated
   */
  public Adapter createCorrVariablePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern <em>Object Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern
   * @generated
   */
  public Adapter createObjectVariablePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern <em>Context Object Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern
   * @generated
   */
  public Adapter createContextObjectVariablePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttributeConstraint <em>Attribute Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttributeConstraint
   * @generated
   */
  public Adapter createAttributeConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment <em>Attribute Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttributeAssignment
   * @generated
   */
  public Adapter createAttributeAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.EnumExpression <em>Enum Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.EnumExpression
   * @generated
   */
  public Adapter createEnumExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.AttributeExpression <em>Attribute Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.AttributeExpression
   * @generated
   */
  public Adapter createAttributeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.LiteralExpression
   * @generated
   */
  public Adapter createLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.LinkVariablePattern <em>Link Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.LinkVariablePattern
   * @generated
   */
  public Adapter createLinkVariablePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern <em>Context Link Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern
   * @generated
   */
  public Adapter createContextLinkVariablePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Operator
   * @generated
   */
  public Adapter createOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Nac <em>Nac</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Nac
   * @generated
   */
  public Adapter createNacAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.Using <em>Using</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.Using
   * @generated
   */
  public Adapter createUsingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.OperatorPattern <em>Operator Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.OperatorPattern
   * @generated
   */
  public Adapter createOperatorPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.NamedElements <em>Named Elements</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.NamedElements
   * @generated
   */
  public Adapter createNamedElementsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.moflon.tgg.mosl.tgg.NamePattern <em>Name Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.moflon.tgg.mosl.tgg.NamePattern
   * @generated
   */
  public Adapter createNamePatternAdapter()
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

} //TggAdapterFactory
