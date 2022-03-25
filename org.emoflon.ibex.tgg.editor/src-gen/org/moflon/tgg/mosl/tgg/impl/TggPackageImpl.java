/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.moflon.tgg.mosl.tgg.Adornment;
import org.moflon.tgg.mosl.tgg.AttrCond;
import org.moflon.tgg.mosl.tgg.AttrCondDef;
import org.moflon.tgg.mosl.tgg.AttrCondDefLibrary;
import org.moflon.tgg.mosl.tgg.AttributeAssignment;
import org.moflon.tgg.mosl.tgg.AttributeConstraint;
import org.moflon.tgg.mosl.tgg.AttributeExpression;
import org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern;
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.CorrType;
import org.moflon.tgg.mosl.tgg.CorrVariablePattern;
import org.moflon.tgg.mosl.tgg.EnumExpression;
import org.moflon.tgg.mosl.tgg.Expression;
import org.moflon.tgg.mosl.tgg.Import;
import org.moflon.tgg.mosl.tgg.LinkVariablePattern;
import org.moflon.tgg.mosl.tgg.LiteralExpression;
import org.moflon.tgg.mosl.tgg.LocalVariable;
import org.moflon.tgg.mosl.tgg.Nac;
import org.moflon.tgg.mosl.tgg.NamePattern;
import org.moflon.tgg.mosl.tgg.NamedElements;
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.Operator;
import org.moflon.tgg.mosl.tgg.OperatorPattern;
import org.moflon.tgg.mosl.tgg.Param;
import org.moflon.tgg.mosl.tgg.ParamValue;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.Schema;
import org.moflon.tgg.mosl.tgg.TggFactory;
import org.moflon.tgg.mosl.tgg.TggPackage;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;
import org.moflon.tgg.mosl.tgg.Using;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TggPackageImpl extends EPackageImpl implements TggPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tripleGraphGrammarFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass schemaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass corrTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrCondDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrCondEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrCondDefLibraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass adornmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass corrVariablePatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectVariablePatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextObjectVariablePatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkVariablePatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextLinkVariablePatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nacEClass = null;

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
  private EClass usingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operatorPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedElementsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namePatternEClass = null;

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
   * @see org.moflon.tgg.mosl.tgg.TggPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TggPackageImpl()
  {
    super(eNS_URI, TggFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TggPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TggPackage init()
  {
    if (isInited) return (TggPackage)EPackage.Registry.INSTANCE.getEPackage(TggPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredTggPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    TggPackageImpl theTggPackage = registeredTggPackage instanceof TggPackageImpl ? (TggPackageImpl)registeredTggPackage : new TggPackageImpl();

    isInited = true;

    // Create package meta-data objects
    theTggPackage.createPackageContents();

    // Initialize created meta-data
    theTggPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTggPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TggPackage.eNS_URI, theTggPackage);
    return theTggPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTripleGraphGrammarFile()
  {
    return tripleGraphGrammarFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTripleGraphGrammarFile_Imports()
  {
    return (EReference)tripleGraphGrammarFileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTripleGraphGrammarFile_Using()
  {
    return (EReference)tripleGraphGrammarFileEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTripleGraphGrammarFile_Schema()
  {
    return (EReference)tripleGraphGrammarFileEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTripleGraphGrammarFile_Rules()
  {
    return (EReference)tripleGraphGrammarFileEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTripleGraphGrammarFile_Library()
  {
    return (EReference)tripleGraphGrammarFileEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSchema()
  {
    return schemaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSchema_SourceTypes()
  {
    return (EReference)schemaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSchema_TargetTypes()
  {
    return (EReference)schemaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSchema_CorrespondenceTypes()
  {
    return (EReference)schemaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSchema_AttributeCondDefs()
  {
    return (EReference)schemaEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCorrType()
  {
    return corrTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrType_Super()
  {
    return (EReference)corrTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrType_Source()
  {
    return (EReference)corrTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrType_Target()
  {
    return (EReference)corrTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttrCondDef()
  {
    return attrCondDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttrCondDef_UserDefined()
  {
    return (EAttribute)attrCondDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCondDef_Params()
  {
    return (EReference)attrCondDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCondDef_AllowedSyncAdornments()
  {
    return (EReference)attrCondDefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCondDef_AllowedGenAdornments()
  {
    return (EReference)attrCondDefEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParam()
  {
    return paramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getParam_ParamName()
  {
    return (EAttribute)paramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getParam_Type()
  {
    return (EReference)paramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRule_AbstractRule()
  {
    return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_Supertypes()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_Schema()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_SourcePatterns()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_TargetPatterns()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_CorrespondencePatterns()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRule_AttrConditions()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttrCond()
  {
    return attrCondEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCond_Name()
  {
    return (EReference)attrCondEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCond_Values()
  {
    return (EReference)attrCondEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttrCondDefLibrary()
  {
    return attrCondDefLibraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttrCondDefLibrary_AttributeCondDefs()
  {
    return (EReference)attrCondDefLibraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAdornment()
  {
    return adornmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAdornment_Value()
  {
    return (EAttribute)adornmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParamValue()
  {
    return paramValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLocalVariable()
  {
    return localVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLocalVariable_Name()
  {
    return (EAttribute)localVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCorrVariablePattern()
  {
    return corrVariablePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrVariablePattern_Type()
  {
    return (EReference)corrVariablePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrVariablePattern_Source()
  {
    return (EReference)corrVariablePatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCorrVariablePattern_Target()
  {
    return (EReference)corrVariablePatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getObjectVariablePattern()
  {
    return objectVariablePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getObjectVariablePattern_Type()
  {
    return (EReference)objectVariablePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getObjectVariablePattern_AttributeAssignments()
  {
    return (EReference)objectVariablePatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getObjectVariablePattern_AttributeConstraints()
  {
    return (EReference)objectVariablePatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getObjectVariablePattern_LinkVariablePatterns()
  {
    return (EReference)objectVariablePatternEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContextObjectVariablePattern()
  {
    return contextObjectVariablePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContextObjectVariablePattern_Name()
  {
    return (EAttribute)contextObjectVariablePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextObjectVariablePattern_Type()
  {
    return (EReference)contextObjectVariablePatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextObjectVariablePattern_AttributeConstraints()
  {
    return (EReference)contextObjectVariablePatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextObjectVariablePattern_LinkVariablePatterns()
  {
    return (EReference)contextObjectVariablePatternEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttributeConstraint()
  {
    return attributeConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeConstraint_Attribute()
  {
    return (EReference)attributeConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttributeConstraint_Op()
  {
    return (EAttribute)attributeConstraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeConstraint_ValueExp()
  {
    return (EReference)attributeConstraintEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttributeAssignment()
  {
    return attributeAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeAssignment_Attribute()
  {
    return (EReference)attributeAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttributeAssignment_Op()
  {
    return (EAttribute)attributeAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeAssignment_ValueExp()
  {
    return (EReference)attributeAssignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEnumExpression()
  {
    return enumExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEnumExpression_Eenum()
  {
    return (EReference)enumExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEnumExpression_Literal()
  {
    return (EReference)enumExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttributeExpression()
  {
    return attributeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttributeExpression_Derived()
  {
    return (EAttribute)attributeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeExpression_ObjectVar()
  {
    return (EReference)attributeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttributeExpression_Attribute()
  {
    return (EReference)attributeExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLiteralExpression()
  {
    return literalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLiteralExpression_Value()
  {
    return (EAttribute)literalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLinkVariablePattern()
  {
    return linkVariablePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLinkVariablePattern_Type()
  {
    return (EReference)linkVariablePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLinkVariablePattern_Target()
  {
    return (EReference)linkVariablePatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContextLinkVariablePattern()
  {
    return contextLinkVariablePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextLinkVariablePattern_Type()
  {
    return (EReference)contextLinkVariablePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextLinkVariablePattern_Target()
  {
    return (EReference)contextLinkVariablePatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOperator()
  {
    return operatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperator_Value()
  {
    return (EAttribute)operatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNac()
  {
    return nacEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNac_Rule()
  {
    return (EReference)nacEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNac_SourcePatterns()
  {
    return (EReference)nacEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNac_TargetPatterns()
  {
    return (EReference)nacEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNac_AttrConditions()
  {
    return (EReference)nacEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getImport_Name()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUsing()
  {
    return usingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUsing_ImportedNamespace()
  {
    return (EAttribute)usingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOperatorPattern()
  {
    return operatorPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOperatorPattern_Op()
  {
    return (EReference)operatorPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNamedElements()
  {
    return namedElementsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNamedElements_Name()
  {
    return (EAttribute)namedElementsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNamePattern()
  {
    return namePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TggFactory getTggFactory()
  {
    return (TggFactory)getEFactoryInstance();
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
    tripleGraphGrammarFileEClass = createEClass(TRIPLE_GRAPH_GRAMMAR_FILE);
    createEReference(tripleGraphGrammarFileEClass, TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS);
    createEReference(tripleGraphGrammarFileEClass, TRIPLE_GRAPH_GRAMMAR_FILE__USING);
    createEReference(tripleGraphGrammarFileEClass, TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA);
    createEReference(tripleGraphGrammarFileEClass, TRIPLE_GRAPH_GRAMMAR_FILE__RULES);
    createEReference(tripleGraphGrammarFileEClass, TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY);

    schemaEClass = createEClass(SCHEMA);
    createEReference(schemaEClass, SCHEMA__SOURCE_TYPES);
    createEReference(schemaEClass, SCHEMA__TARGET_TYPES);
    createEReference(schemaEClass, SCHEMA__CORRESPONDENCE_TYPES);
    createEReference(schemaEClass, SCHEMA__ATTRIBUTE_COND_DEFS);

    corrTypeEClass = createEClass(CORR_TYPE);
    createEReference(corrTypeEClass, CORR_TYPE__SUPER);
    createEReference(corrTypeEClass, CORR_TYPE__SOURCE);
    createEReference(corrTypeEClass, CORR_TYPE__TARGET);

    attrCondDefEClass = createEClass(ATTR_COND_DEF);
    createEAttribute(attrCondDefEClass, ATTR_COND_DEF__USER_DEFINED);
    createEReference(attrCondDefEClass, ATTR_COND_DEF__PARAMS);
    createEReference(attrCondDefEClass, ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS);
    createEReference(attrCondDefEClass, ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS);

    paramEClass = createEClass(PARAM);
    createEAttribute(paramEClass, PARAM__PARAM_NAME);
    createEReference(paramEClass, PARAM__TYPE);

    ruleEClass = createEClass(RULE);
    createEAttribute(ruleEClass, RULE__ABSTRACT_RULE);
    createEReference(ruleEClass, RULE__SUPERTYPES);
    createEReference(ruleEClass, RULE__SCHEMA);
    createEReference(ruleEClass, RULE__SOURCE_PATTERNS);
    createEReference(ruleEClass, RULE__TARGET_PATTERNS);
    createEReference(ruleEClass, RULE__CORRESPONDENCE_PATTERNS);
    createEReference(ruleEClass, RULE__ATTR_CONDITIONS);

    attrCondEClass = createEClass(ATTR_COND);
    createEReference(attrCondEClass, ATTR_COND__NAME);
    createEReference(attrCondEClass, ATTR_COND__VALUES);

    attrCondDefLibraryEClass = createEClass(ATTR_COND_DEF_LIBRARY);
    createEReference(attrCondDefLibraryEClass, ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS);

    adornmentEClass = createEClass(ADORNMENT);
    createEAttribute(adornmentEClass, ADORNMENT__VALUE);

    paramValueEClass = createEClass(PARAM_VALUE);

    localVariableEClass = createEClass(LOCAL_VARIABLE);
    createEAttribute(localVariableEClass, LOCAL_VARIABLE__NAME);

    corrVariablePatternEClass = createEClass(CORR_VARIABLE_PATTERN);
    createEReference(corrVariablePatternEClass, CORR_VARIABLE_PATTERN__TYPE);
    createEReference(corrVariablePatternEClass, CORR_VARIABLE_PATTERN__SOURCE);
    createEReference(corrVariablePatternEClass, CORR_VARIABLE_PATTERN__TARGET);

    objectVariablePatternEClass = createEClass(OBJECT_VARIABLE_PATTERN);
    createEReference(objectVariablePatternEClass, OBJECT_VARIABLE_PATTERN__TYPE);
    createEReference(objectVariablePatternEClass, OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS);
    createEReference(objectVariablePatternEClass, OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS);
    createEReference(objectVariablePatternEClass, OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS);

    contextObjectVariablePatternEClass = createEClass(CONTEXT_OBJECT_VARIABLE_PATTERN);
    createEAttribute(contextObjectVariablePatternEClass, CONTEXT_OBJECT_VARIABLE_PATTERN__NAME);
    createEReference(contextObjectVariablePatternEClass, CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE);
    createEReference(contextObjectVariablePatternEClass, CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS);
    createEReference(contextObjectVariablePatternEClass, CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS);

    attributeConstraintEClass = createEClass(ATTRIBUTE_CONSTRAINT);
    createEReference(attributeConstraintEClass, ATTRIBUTE_CONSTRAINT__ATTRIBUTE);
    createEAttribute(attributeConstraintEClass, ATTRIBUTE_CONSTRAINT__OP);
    createEReference(attributeConstraintEClass, ATTRIBUTE_CONSTRAINT__VALUE_EXP);

    attributeAssignmentEClass = createEClass(ATTRIBUTE_ASSIGNMENT);
    createEReference(attributeAssignmentEClass, ATTRIBUTE_ASSIGNMENT__ATTRIBUTE);
    createEAttribute(attributeAssignmentEClass, ATTRIBUTE_ASSIGNMENT__OP);
    createEReference(attributeAssignmentEClass, ATTRIBUTE_ASSIGNMENT__VALUE_EXP);

    expressionEClass = createEClass(EXPRESSION);

    enumExpressionEClass = createEClass(ENUM_EXPRESSION);
    createEReference(enumExpressionEClass, ENUM_EXPRESSION__EENUM);
    createEReference(enumExpressionEClass, ENUM_EXPRESSION__LITERAL);

    attributeExpressionEClass = createEClass(ATTRIBUTE_EXPRESSION);
    createEAttribute(attributeExpressionEClass, ATTRIBUTE_EXPRESSION__DERIVED);
    createEReference(attributeExpressionEClass, ATTRIBUTE_EXPRESSION__OBJECT_VAR);
    createEReference(attributeExpressionEClass, ATTRIBUTE_EXPRESSION__ATTRIBUTE);

    literalExpressionEClass = createEClass(LITERAL_EXPRESSION);
    createEAttribute(literalExpressionEClass, LITERAL_EXPRESSION__VALUE);

    linkVariablePatternEClass = createEClass(LINK_VARIABLE_PATTERN);
    createEReference(linkVariablePatternEClass, LINK_VARIABLE_PATTERN__TYPE);
    createEReference(linkVariablePatternEClass, LINK_VARIABLE_PATTERN__TARGET);

    contextLinkVariablePatternEClass = createEClass(CONTEXT_LINK_VARIABLE_PATTERN);
    createEReference(contextLinkVariablePatternEClass, CONTEXT_LINK_VARIABLE_PATTERN__TYPE);
    createEReference(contextLinkVariablePatternEClass, CONTEXT_LINK_VARIABLE_PATTERN__TARGET);

    operatorEClass = createEClass(OPERATOR);
    createEAttribute(operatorEClass, OPERATOR__VALUE);

    nacEClass = createEClass(NAC);
    createEReference(nacEClass, NAC__RULE);
    createEReference(nacEClass, NAC__SOURCE_PATTERNS);
    createEReference(nacEClass, NAC__TARGET_PATTERNS);
    createEReference(nacEClass, NAC__ATTR_CONDITIONS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__NAME);

    usingEClass = createEClass(USING);
    createEAttribute(usingEClass, USING__IMPORTED_NAMESPACE);

    operatorPatternEClass = createEClass(OPERATOR_PATTERN);
    createEReference(operatorPatternEClass, OPERATOR_PATTERN__OP);

    namedElementsEClass = createEClass(NAMED_ELEMENTS);
    createEAttribute(namedElementsEClass, NAMED_ELEMENTS__NAME);

    namePatternEClass = createEClass(NAME_PATTERN);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    schemaEClass.getESuperTypes().add(this.getNamedElements());
    corrTypeEClass.getESuperTypes().add(this.getNamedElements());
    attrCondDefEClass.getESuperTypes().add(this.getNamedElements());
    ruleEClass.getESuperTypes().add(this.getNamedElements());
    attrCondDefLibraryEClass.getESuperTypes().add(this.getNamedElements());
    localVariableEClass.getESuperTypes().add(this.getParamValue());
    corrVariablePatternEClass.getESuperTypes().add(this.getNamePattern());
    objectVariablePatternEClass.getESuperTypes().add(this.getNamePattern());
    expressionEClass.getESuperTypes().add(this.getParamValue());
    enumExpressionEClass.getESuperTypes().add(this.getExpression());
    attributeExpressionEClass.getESuperTypes().add(this.getExpression());
    literalExpressionEClass.getESuperTypes().add(this.getExpression());
    linkVariablePatternEClass.getESuperTypes().add(this.getOperatorPattern());
    nacEClass.getESuperTypes().add(this.getNamedElements());
    namePatternEClass.getESuperTypes().add(this.getOperatorPattern());
    namePatternEClass.getESuperTypes().add(this.getNamedElements());

    // Initialize classes and features; add operations and parameters
    initEClass(tripleGraphGrammarFileEClass, TripleGraphGrammarFile.class, "TripleGraphGrammarFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTripleGraphGrammarFile_Imports(), this.getImport(), null, "imports", null, 0, -1, TripleGraphGrammarFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTripleGraphGrammarFile_Using(), this.getUsing(), null, "using", null, 0, -1, TripleGraphGrammarFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTripleGraphGrammarFile_Schema(), this.getSchema(), null, "schema", null, 0, 1, TripleGraphGrammarFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTripleGraphGrammarFile_Rules(), this.getRule(), null, "rules", null, 0, -1, TripleGraphGrammarFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTripleGraphGrammarFile_Library(), this.getAttrCondDefLibrary(), null, "library", null, 0, 1, TripleGraphGrammarFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(schemaEClass, Schema.class, "Schema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSchema_SourceTypes(), ecorePackage.getEPackage(), null, "sourceTypes", null, 0, -1, Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSchema_TargetTypes(), ecorePackage.getEPackage(), null, "targetTypes", null, 0, -1, Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSchema_CorrespondenceTypes(), this.getCorrType(), null, "correspondenceTypes", null, 0, -1, Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSchema_AttributeCondDefs(), this.getAttrCondDef(), null, "attributeCondDefs", null, 0, -1, Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(corrTypeEClass, CorrType.class, "CorrType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCorrType_Super(), this.getCorrType(), null, "super", null, 0, 1, CorrType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCorrType_Source(), ecorePackage.getEClass(), null, "source", null, 0, 1, CorrType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCorrType_Target(), ecorePackage.getEClass(), null, "target", null, 0, 1, CorrType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attrCondDefEClass, AttrCondDef.class, "AttrCondDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttrCondDef_UserDefined(), ecorePackage.getEBoolean(), "userDefined", null, 0, 1, AttrCondDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttrCondDef_Params(), this.getParam(), null, "params", null, 0, -1, AttrCondDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttrCondDef_AllowedSyncAdornments(), this.getAdornment(), null, "allowedSyncAdornments", null, 0, -1, AttrCondDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttrCondDef_AllowedGenAdornments(), this.getAdornment(), null, "allowedGenAdornments", null, 0, -1, AttrCondDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParam_ParamName(), ecorePackage.getEString(), "paramName", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParam_Type(), ecorePackage.getEDataType(), null, "type", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule_AbstractRule(), ecorePackage.getEBoolean(), "abstractRule", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Supertypes(), this.getRule(), null, "supertypes", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Schema(), this.getSchema(), null, "schema", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_SourcePatterns(), this.getObjectVariablePattern(), null, "sourcePatterns", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_TargetPatterns(), this.getObjectVariablePattern(), null, "targetPatterns", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_CorrespondencePatterns(), this.getCorrVariablePattern(), null, "correspondencePatterns", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_AttrConditions(), this.getAttrCond(), null, "attrConditions", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attrCondEClass, AttrCond.class, "AttrCond", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttrCond_Name(), this.getAttrCondDef(), null, "name", null, 0, 1, AttrCond.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttrCond_Values(), this.getParamValue(), null, "values", null, 0, -1, AttrCond.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attrCondDefLibraryEClass, AttrCondDefLibrary.class, "AttrCondDefLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttrCondDefLibrary_AttributeCondDefs(), this.getAttrCondDef(), null, "attributeCondDefs", null, 0, -1, AttrCondDefLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adornmentEClass, Adornment.class, "Adornment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdornment_Value(), ecorePackage.getEString(), "value", null, 0, -1, Adornment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramValueEClass, ParamValue.class, "ParamValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(localVariableEClass, LocalVariable.class, "LocalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, LocalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(corrVariablePatternEClass, CorrVariablePattern.class, "CorrVariablePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCorrVariablePattern_Type(), this.getCorrType(), null, "type", null, 0, 1, CorrVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCorrVariablePattern_Source(), this.getObjectVariablePattern(), null, "source", null, 0, 1, CorrVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCorrVariablePattern_Target(), this.getObjectVariablePattern(), null, "target", null, 0, 1, CorrVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectVariablePatternEClass, ObjectVariablePattern.class, "ObjectVariablePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectVariablePattern_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, ObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectVariablePattern_AttributeAssignments(), this.getAttributeAssignment(), null, "attributeAssignments", null, 0, -1, ObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectVariablePattern_AttributeConstraints(), this.getAttributeConstraint(), null, "attributeConstraints", null, 0, -1, ObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectVariablePattern_LinkVariablePatterns(), this.getLinkVariablePattern(), null, "linkVariablePatterns", null, 0, -1, ObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contextObjectVariablePatternEClass, ContextObjectVariablePattern.class, "ContextObjectVariablePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContextObjectVariablePattern_Name(), ecorePackage.getEString(), "name", null, 0, 1, ContextObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextObjectVariablePattern_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, ContextObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextObjectVariablePattern_AttributeConstraints(), this.getAttributeConstraint(), null, "attributeConstraints", null, 0, -1, ContextObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextObjectVariablePattern_LinkVariablePatterns(), this.getContextLinkVariablePattern(), null, "linkVariablePatterns", null, 0, -1, ContextObjectVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeConstraintEClass, AttributeConstraint.class, "AttributeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeConstraint_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, AttributeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeConstraint_Op(), ecorePackage.getEString(), "op", null, 0, 1, AttributeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeConstraint_ValueExp(), this.getExpression(), null, "valueExp", null, 0, 1, AttributeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeAssignmentEClass, AttributeAssignment.class, "AttributeAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeAssignment_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, AttributeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeAssignment_Op(), ecorePackage.getEString(), "op", null, 0, 1, AttributeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeAssignment_ValueExp(), this.getExpression(), null, "valueExp", null, 0, 1, AttributeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumExpressionEClass, EnumExpression.class, "EnumExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumExpression_Eenum(), ecorePackage.getEEnum(), null, "eenum", null, 0, 1, EnumExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumExpression_Literal(), ecorePackage.getEEnumLiteral(), null, "literal", null, 0, 1, EnumExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeExpressionEClass, AttributeExpression.class, "AttributeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttributeExpression_Derived(), ecorePackage.getEBoolean(), "derived", null, 0, 1, AttributeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeExpression_ObjectVar(), ecorePackage.getEObject(), null, "objectVar", null, 0, 1, AttributeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeExpression_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, AttributeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalExpressionEClass, LiteralExpression.class, "LiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, LiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkVariablePatternEClass, LinkVariablePattern.class, "LinkVariablePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLinkVariablePattern_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, LinkVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkVariablePattern_Target(), this.getObjectVariablePattern(), null, "target", null, 0, 1, LinkVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contextLinkVariablePatternEClass, ContextLinkVariablePattern.class, "ContextLinkVariablePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getContextLinkVariablePattern_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, ContextLinkVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextLinkVariablePattern_Target(), this.getContextObjectVariablePattern(), null, "target", null, 0, 1, ContextLinkVariablePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperator_Value(), ecorePackage.getEString(), "value", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nacEClass, Nac.class, "Nac", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNac_Rule(), this.getRule(), null, "rule", null, 0, 1, Nac.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNac_SourcePatterns(), this.getContextObjectVariablePattern(), null, "sourcePatterns", null, 0, -1, Nac.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNac_TargetPatterns(), this.getContextObjectVariablePattern(), null, "targetPatterns", null, 0, -1, Nac.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNac_AttrConditions(), this.getAttrCond(), null, "attrConditions", null, 0, -1, Nac.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_Name(), ecorePackage.getEString(), "name", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usingEClass, Using.class, "Using", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUsing_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Using.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operatorPatternEClass, OperatorPattern.class, "OperatorPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperatorPattern_Op(), this.getOperator(), null, "op", null, 0, 1, OperatorPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedElementsEClass, NamedElements.class, "NamedElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElements_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namePatternEClass, NamePattern.class, "NamePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //TggPackageImpl
