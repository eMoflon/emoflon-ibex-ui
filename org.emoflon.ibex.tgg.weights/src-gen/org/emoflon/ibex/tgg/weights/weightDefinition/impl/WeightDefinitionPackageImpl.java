/**
 * generated by Xtext 2.14.0
 */
package org.emoflon.ibex.tgg.weights.weightDefinition.impl;

import language.LanguagePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.emoflon.ibex.tgg.weights.weightDefinition.DefaultCalculation;
import org.emoflon.ibex.tgg.weights.weightDefinition.HelperFuncParameter;
import org.emoflon.ibex.tgg.weights.weightDefinition.HelperFunction;
import org.emoflon.ibex.tgg.weights.weightDefinition.HelperFuntion;
import org.emoflon.ibex.tgg.weights.weightDefinition.Import;
import org.emoflon.ibex.tgg.weights.weightDefinition.RuleWeightDefinition;
import org.emoflon.ibex.tgg.weights.weightDefinition.VariableDeclaration;
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionFactory;
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionFile;
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WeightDefinitionPackageImpl extends EPackageImpl implements WeightDefinitionPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass weightDefinitionFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleWeightDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defaultCalculationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass helperFuntionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass helperFuncParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass helperFunctionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private WeightDefinitionPackageImpl()
  {
    super(eNS_URI, WeightDefinitionFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link WeightDefinitionPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static WeightDefinitionPackage init()
  {
    if (isInited) return (WeightDefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(WeightDefinitionPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredWeightDefinitionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    WeightDefinitionPackageImpl theWeightDefinitionPackage = registeredWeightDefinitionPackage instanceof WeightDefinitionPackageImpl ? (WeightDefinitionPackageImpl)registeredWeightDefinitionPackage : new WeightDefinitionPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    TypesPackage.eINSTANCE.eClass();
    XbasePackage.eINSTANCE.eClass();
    LanguagePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theWeightDefinitionPackage.createPackageContents();

    // Initialize created meta-data
    theWeightDefinitionPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theWeightDefinitionPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(WeightDefinitionPackage.eNS_URI, theWeightDefinitionPackage);
    return theWeightDefinitionPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWeightDefinitionFile()
  {
    return weightDefinitionFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWeightDefinitionFile_ImportedTgg()
  {
    return (EReference)weightDefinitionFileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWeightDefinitionFile_WeigthDefinitions()
  {
    return (EReference)weightDefinitionFileEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWeightDefinitionFile_DefaultCalc()
  {
    return (EReference)weightDefinitionFileEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWeightDefinitionFile_HelperFuntions()
  {
    return (EReference)weightDefinitionFileEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWeightDefinitionFile_Variables()
  {
    return (EReference)weightDefinitionFileEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclaration()
  {
    return variableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_ParameterType()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDeclaration_Name()
  {
    return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleWeightDefinition()
  {
    return ruleWeightDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleWeightDefinition_Rule()
  {
    return (EReference)ruleWeightDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleWeightDefinition_WeightCalc()
  {
    return (EReference)ruleWeightDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefaultCalculation()
  {
    return defaultCalculationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefaultCalculation_Calc()
  {
    return (EReference)defaultCalculationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHelperFuntion()
  {
    return helperFuntionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHelperFuncParameter()
  {
    return helperFuncParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHelperFuncParameter_ParameterType()
  {
    return (EReference)helperFuncParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHelperFuncParameter_Name()
  {
    return (EAttribute)helperFuncParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHelperFunction()
  {
    return helperFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHelperFunction_ReturnType()
  {
    return (EReference)helperFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHelperFunction_Name()
  {
    return (EAttribute)helperFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHelperFunction_Params()
  {
    return (EReference)helperFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHelperFunction_Body()
  {
    return (EReference)helperFunctionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightDefinitionFactory getWeightDefinitionFactory()
  {
    return (WeightDefinitionFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    weightDefinitionFileEClass = createEClass(WEIGHT_DEFINITION_FILE);
    createEReference(weightDefinitionFileEClass, WEIGHT_DEFINITION_FILE__IMPORTED_TGG);
    createEReference(weightDefinitionFileEClass, WEIGHT_DEFINITION_FILE__WEIGTH_DEFINITIONS);
    createEReference(weightDefinitionFileEClass, WEIGHT_DEFINITION_FILE__DEFAULT_CALC);
    createEReference(weightDefinitionFileEClass, WEIGHT_DEFINITION_FILE__HELPER_FUNTIONS);
    createEReference(weightDefinitionFileEClass, WEIGHT_DEFINITION_FILE__VARIABLES);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__PARAMETER_TYPE);
    createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);

    ruleWeightDefinitionEClass = createEClass(RULE_WEIGHT_DEFINITION);
    createEReference(ruleWeightDefinitionEClass, RULE_WEIGHT_DEFINITION__RULE);
    createEReference(ruleWeightDefinitionEClass, RULE_WEIGHT_DEFINITION__WEIGHT_CALC);

    defaultCalculationEClass = createEClass(DEFAULT_CALCULATION);
    createEReference(defaultCalculationEClass, DEFAULT_CALCULATION__CALC);

    helperFuntionEClass = createEClass(HELPER_FUNTION);

    helperFuncParameterEClass = createEClass(HELPER_FUNC_PARAMETER);
    createEReference(helperFuncParameterEClass, HELPER_FUNC_PARAMETER__PARAMETER_TYPE);
    createEAttribute(helperFuncParameterEClass, HELPER_FUNC_PARAMETER__NAME);

    helperFunctionEClass = createEClass(HELPER_FUNCTION);
    createEReference(helperFunctionEClass, HELPER_FUNCTION__RETURN_TYPE);
    createEAttribute(helperFunctionEClass, HELPER_FUNCTION__NAME);
    createEReference(helperFunctionEClass, HELPER_FUNCTION__PARAMS);
    createEReference(helperFunctionEClass, HELPER_FUNCTION__BODY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
    LanguagePackage theLanguagePackage = (LanguagePackage)EPackage.Registry.INSTANCE.getEPackage(LanguagePackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    helperFunctionEClass.getESuperTypes().add(this.getHelperFuntion());

    // Initialize classes and features; add operations and parameters
    initEClass(weightDefinitionFileEClass, WeightDefinitionFile.class, "WeightDefinitionFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWeightDefinitionFile_ImportedTgg(), this.getImport(), null, "importedTgg", null, 0, 1, WeightDefinitionFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWeightDefinitionFile_WeigthDefinitions(), this.getRuleWeightDefinition(), null, "weigthDefinitions", null, 0, -1, WeightDefinitionFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWeightDefinitionFile_DefaultCalc(), this.getDefaultCalculation(), null, "defaultCalc", null, 0, -1, WeightDefinitionFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWeightDefinitionFile_HelperFuntions(), this.getHelperFuntion(), null, "helperFuntions", null, 0, -1, WeightDefinitionFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWeightDefinitionFile_Variables(), this.getVariableDeclaration(), null, "variables", null, 0, -1, WeightDefinitionFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), theEcorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableDeclaration_ParameterType(), theTypesPackage.getJvmTypeReference(), null, "parameterType", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleWeightDefinitionEClass, RuleWeightDefinition.class, "RuleWeightDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleWeightDefinition_Rule(), theLanguagePackage.getTGGRule(), null, "rule", null, 0, 1, RuleWeightDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleWeightDefinition_WeightCalc(), theXbasePackage.getXExpression(), null, "weightCalc", null, 0, 1, RuleWeightDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defaultCalculationEClass, DefaultCalculation.class, "DefaultCalculation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefaultCalculation_Calc(), theXbasePackage.getXExpression(), null, "calc", null, 0, 1, DefaultCalculation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(helperFuntionEClass, HelperFuntion.class, "HelperFuntion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(helperFuncParameterEClass, HelperFuncParameter.class, "HelperFuncParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHelperFuncParameter_ParameterType(), theTypesPackage.getJvmTypeReference(), null, "parameterType", null, 0, 1, HelperFuncParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHelperFuncParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, HelperFuncParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(helperFunctionEClass, HelperFunction.class, "HelperFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHelperFunction_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, HelperFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHelperFunction_Name(), theEcorePackage.getEString(), "name", null, 0, 1, HelperFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHelperFunction_Params(), this.getHelperFuncParameter(), null, "params", null, 0, -1, HelperFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHelperFunction_Body(), theXbasePackage.getXExpression(), null, "body", null, 0, 1, HelperFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //WeightDefinitionPackageImpl