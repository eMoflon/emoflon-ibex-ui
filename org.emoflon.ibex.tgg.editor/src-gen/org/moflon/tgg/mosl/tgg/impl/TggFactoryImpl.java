/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.moflon.tgg.mosl.tgg.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TggFactoryImpl extends EFactoryImpl implements TggFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TggFactory init()
  {
    try
    {
      TggFactory theTggFactory = (TggFactory)EPackage.Registry.INSTANCE.getEFactory(TggPackage.eNS_URI);
      if (theTggFactory != null)
      {
        return theTggFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TggFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TggFactoryImpl()
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE: return createTripleGraphGrammarFile();
      case TggPackage.SCHEMA: return createSchema();
      case TggPackage.CORR_TYPE: return createCorrType();
      case TggPackage.ATTR_COND_DEF: return createAttrCondDef();
      case TggPackage.PARAM: return createParam();
      case TggPackage.RULE: return createRule();
      case TggPackage.ATTR_COND: return createAttrCond();
      case TggPackage.ATTR_COND_DEF_LIBRARY: return createAttrCondDefLibrary();
      case TggPackage.ADORNMENT: return createAdornment();
      case TggPackage.PARAM_VALUE: return createParamValue();
      case TggPackage.LOCAL_VARIABLE: return createLocalVariable();
      case TggPackage.CORR_VARIABLE_PATTERN: return createCorrVariablePattern();
      case TggPackage.OBJECT_VARIABLE_PATTERN: return createObjectVariablePattern();
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN: return createContextObjectVariablePattern();
      case TggPackage.ATTRIBUTE_CONSTRAINT: return createAttributeConstraint();
      case TggPackage.ATTRIBUTE_ASSIGNMENT: return createAttributeAssignment();
      case TggPackage.EXPRESSION: return createExpression();
      case TggPackage.ENUM_EXPRESSION: return createEnumExpression();
      case TggPackage.ATTRIBUTE_EXPRESSION: return createAttributeExpression();
      case TggPackage.LITERAL_EXPRESSION: return createLiteralExpression();
      case TggPackage.LINK_VARIABLE_PATTERN: return createLinkVariablePattern();
      case TggPackage.CONTEXT_LINK_VARIABLE_PATTERN: return createContextLinkVariablePattern();
      case TggPackage.OPERATOR: return createOperator();
      case TggPackage.NAC: return createNac();
      case TggPackage.IMPORT: return createImport();
      case TggPackage.USING: return createUsing();
      case TggPackage.OPERATOR_PATTERN: return createOperatorPattern();
      case TggPackage.NAMED_ELEMENTS: return createNamedElements();
      case TggPackage.NAME_PATTERN: return createNamePattern();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TripleGraphGrammarFile createTripleGraphGrammarFile()
  {
    TripleGraphGrammarFileImpl tripleGraphGrammarFile = new TripleGraphGrammarFileImpl();
    return tripleGraphGrammarFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Schema createSchema()
  {
    SchemaImpl schema = new SchemaImpl();
    return schema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CorrType createCorrType()
  {
    CorrTypeImpl corrType = new CorrTypeImpl();
    return corrType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrCondDef createAttrCondDef()
  {
    AttrCondDefImpl attrCondDef = new AttrCondDefImpl();
    return attrCondDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Param createParam()
  {
    ParamImpl param = new ParamImpl();
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrCond createAttrCond()
  {
    AttrCondImpl attrCond = new AttrCondImpl();
    return attrCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrCondDefLibrary createAttrCondDefLibrary()
  {
    AttrCondDefLibraryImpl attrCondDefLibrary = new AttrCondDefLibraryImpl();
    return attrCondDefLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adornment createAdornment()
  {
    AdornmentImpl adornment = new AdornmentImpl();
    return adornment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParamValue createParamValue()
  {
    ParamValueImpl paramValue = new ParamValueImpl();
    return paramValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LocalVariable createLocalVariable()
  {
    LocalVariableImpl localVariable = new LocalVariableImpl();
    return localVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CorrVariablePattern createCorrVariablePattern()
  {
    CorrVariablePatternImpl corrVariablePattern = new CorrVariablePatternImpl();
    return corrVariablePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ObjectVariablePattern createObjectVariablePattern()
  {
    ObjectVariablePatternImpl objectVariablePattern = new ObjectVariablePatternImpl();
    return objectVariablePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextObjectVariablePattern createContextObjectVariablePattern()
  {
    ContextObjectVariablePatternImpl contextObjectVariablePattern = new ContextObjectVariablePatternImpl();
    return contextObjectVariablePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeConstraint createAttributeConstraint()
  {
    AttributeConstraintImpl attributeConstraint = new AttributeConstraintImpl();
    return attributeConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeAssignment createAttributeAssignment()
  {
    AttributeAssignmentImpl attributeAssignment = new AttributeAssignmentImpl();
    return attributeAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumExpression createEnumExpression()
  {
    EnumExpressionImpl enumExpression = new EnumExpressionImpl();
    return enumExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeExpression createAttributeExpression()
  {
    AttributeExpressionImpl attributeExpression = new AttributeExpressionImpl();
    return attributeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LiteralExpression createLiteralExpression()
  {
    LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
    return literalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LinkVariablePattern createLinkVariablePattern()
  {
    LinkVariablePatternImpl linkVariablePattern = new LinkVariablePatternImpl();
    return linkVariablePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextLinkVariablePattern createContextLinkVariablePattern()
  {
    ContextLinkVariablePatternImpl contextLinkVariablePattern = new ContextLinkVariablePatternImpl();
    return contextLinkVariablePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operator createOperator()
  {
    OperatorImpl operator = new OperatorImpl();
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Nac createNac()
  {
    NacImpl nac = new NacImpl();
    return nac;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public Using createUsing()
  {
    UsingImpl using = new UsingImpl();
    return using;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperatorPattern createOperatorPattern()
  {
    OperatorPatternImpl operatorPattern = new OperatorPatternImpl();
    return operatorPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElements createNamedElements()
  {
    NamedElementsImpl namedElements = new NamedElementsImpl();
    return namedElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamePattern createNamePattern()
  {
    NamePatternImpl namePattern = new NamePatternImpl();
    return namePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TggPackage getTggPackage()
  {
    return (TggPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TggPackage getPackage()
  {
    return TggPackage.eINSTANCE;
  }

} //TggFactoryImpl
