/**
 * generated by Xtext 2.14.0
 */
package org.emoflon.ibex.tgg.weights.weightDefinition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emoflon.ibex.tgg.weights.weightDefinition.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WeightDefinitionFactoryImpl extends EFactoryImpl implements WeightDefinitionFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WeightDefinitionFactory init()
  {
    try
    {
      WeightDefinitionFactory theWeightDefinitionFactory = (WeightDefinitionFactory)EPackage.Registry.INSTANCE.getEFactory(WeightDefinitionPackage.eNS_URI);
      if (theWeightDefinitionFactory != null)
      {
        return theWeightDefinitionFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new WeightDefinitionFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightDefinitionFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case WeightDefinitionPackage.WEIGHT_DEFINITION_FILE: return createWeightDefinitionFile();
      case WeightDefinitionPackage.IMPORT: return createImport();
      case WeightDefinitionPackage.HELPER_FUNC_PARAMETER: return createHelperFuncParameter();
      case WeightDefinitionPackage.RULE_WEIGHT_DEFINITION: return createRuleWeightDefinition();
      case WeightDefinitionPackage.WEIGHT_CALCULATION: return createWeightCalculation();
      case WeightDefinitionPackage.DEFAULT_CALCULATION: return createDefaultCalculation();
      case WeightDefinitionPackage.HELPER_FUNCTION: return createHelperFunction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightDefinitionFile createWeightDefinitionFile()
  {
    WeightDefinitionFileImpl weightDefinitionFile = new WeightDefinitionFileImpl();
    return weightDefinitionFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelperFuncParameter createHelperFuncParameter()
  {
    HelperFuncParameterImpl helperFuncParameter = new HelperFuncParameterImpl();
    return helperFuncParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleWeightDefinition createRuleWeightDefinition()
  {
    RuleWeightDefinitionImpl ruleWeightDefinition = new RuleWeightDefinitionImpl();
    return ruleWeightDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightCalculation createWeightCalculation()
  {
    WeightCalculationImpl weightCalculation = new WeightCalculationImpl();
    return weightCalculation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefaultCalculation createDefaultCalculation()
  {
    DefaultCalculationImpl defaultCalculation = new DefaultCalculationImpl();
    return defaultCalculation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelperFunction createHelperFunction()
  {
    HelperFunctionImpl helperFunction = new HelperFunctionImpl();
    return helperFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightDefinitionPackage getWeightDefinitionPackage()
  {
    return (WeightDefinitionPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static WeightDefinitionPackage getPackage()
  {
    return WeightDefinitionPackage.eINSTANCE;
  }

} //WeightDefinitionFactoryImpl
