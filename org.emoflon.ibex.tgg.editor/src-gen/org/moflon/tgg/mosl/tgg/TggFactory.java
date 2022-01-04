/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.moflon.tgg.mosl.tgg.TggPackage
 * @generated
 */
public interface TggFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TggFactory eINSTANCE = org.moflon.tgg.mosl.tgg.impl.TggFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Triple Graph Grammar File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Triple Graph Grammar File</em>'.
   * @generated
   */
  TripleGraphGrammarFile createTripleGraphGrammarFile();

  /**
   * Returns a new object of class '<em>Schema</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Schema</em>'.
   * @generated
   */
  Schema createSchema();

  /**
   * Returns a new object of class '<em>Corr Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Corr Type</em>'.
   * @generated
   */
  CorrType createCorrType();

  /**
   * Returns a new object of class '<em>Attr Cond Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Cond Def</em>'.
   * @generated
   */
  AttrCondDef createAttrCondDef();

  /**
   * Returns a new object of class '<em>Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Param</em>'.
   * @generated
   */
  Param createParam();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Attr Cond</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Cond</em>'.
   * @generated
   */
  AttrCond createAttrCond();

  /**
   * Returns a new object of class '<em>Attr Cond Def Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Cond Def Library</em>'.
   * @generated
   */
  AttrCondDefLibrary createAttrCondDefLibrary();

  /**
   * Returns a new object of class '<em>Adornment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Adornment</em>'.
   * @generated
   */
  Adornment createAdornment();

  /**
   * Returns a new object of class '<em>Param Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Param Value</em>'.
   * @generated
   */
  ParamValue createParamValue();

  /**
   * Returns a new object of class '<em>Local Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Variable</em>'.
   * @generated
   */
  LocalVariable createLocalVariable();

  /**
   * Returns a new object of class '<em>Corr Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Corr Variable Pattern</em>'.
   * @generated
   */
  CorrVariablePattern createCorrVariablePattern();

  /**
   * Returns a new object of class '<em>Object Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Variable Pattern</em>'.
   * @generated
   */
  ObjectVariablePattern createObjectVariablePattern();

  /**
   * Returns a new object of class '<em>Context Object Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Context Object Variable Pattern</em>'.
   * @generated
   */
  ContextObjectVariablePattern createContextObjectVariablePattern();

  /**
   * Returns a new object of class '<em>Attribute Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Constraint</em>'.
   * @generated
   */
  AttributeConstraint createAttributeConstraint();

  /**
   * Returns a new object of class '<em>Attribute Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Assignment</em>'.
   * @generated
   */
  AttributeAssignment createAttributeAssignment();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Enum Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Expression</em>'.
   * @generated
   */
  EnumExpression createEnumExpression();

  /**
   * Returns a new object of class '<em>Attribute Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Expression</em>'.
   * @generated
   */
  AttributeExpression createAttributeExpression();

  /**
   * Returns a new object of class '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expression</em>'.
   * @generated
   */
  LiteralExpression createLiteralExpression();

  /**
   * Returns a new object of class '<em>Link Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Variable Pattern</em>'.
   * @generated
   */
  LinkVariablePattern createLinkVariablePattern();

  /**
   * Returns a new object of class '<em>Context Link Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Context Link Variable Pattern</em>'.
   * @generated
   */
  ContextLinkVariablePattern createContextLinkVariablePattern();

  /**
   * Returns a new object of class '<em>Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operator</em>'.
   * @generated
   */
  Operator createOperator();

  /**
   * Returns a new object of class '<em>Nac</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nac</em>'.
   * @generated
   */
  Nac createNac();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Using</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Using</em>'.
   * @generated
   */
  Using createUsing();

  /**
   * Returns a new object of class '<em>Operator Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operator Pattern</em>'.
   * @generated
   */
  OperatorPattern createOperatorPattern();

  /**
   * Returns a new object of class '<em>Named Elements</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Elements</em>'.
   * @generated
   */
  NamedElements createNamedElements();

  /**
   * Returns a new object of class '<em>Name Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Pattern</em>'.
   * @generated
   */
  NamePattern createNamePattern();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TggPackage getTggPackage();

} //TggFactory
