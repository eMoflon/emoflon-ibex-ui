/**
 */
package org.moflon.tgg.mosl.tgg.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.moflon.tgg.mosl.tgg.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.moflon.tgg.mosl.tgg.TggPackage
 * @generated
 */
public class TggSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TggPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TggSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TggPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE:
      {
        TripleGraphGrammarFile tripleGraphGrammarFile = (TripleGraphGrammarFile)theEObject;
        T result = caseTripleGraphGrammarFile(tripleGraphGrammarFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.SCHEMA:
      {
        Schema schema = (Schema)theEObject;
        T result = caseSchema(schema);
        if (result == null) result = caseNamedElements(schema);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.CORR_TYPE:
      {
        CorrType corrType = (CorrType)theEObject;
        T result = caseCorrType(corrType);
        if (result == null) result = caseNamedElements(corrType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTR_COND_DEF:
      {
        AttrCondDef attrCondDef = (AttrCondDef)theEObject;
        T result = caseAttrCondDef(attrCondDef);
        if (result == null) result = caseNamedElements(attrCondDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.PARAM:
      {
        Param param = (Param)theEObject;
        T result = caseParam(param);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = caseNamedElements(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTR_COND:
      {
        AttrCond attrCond = (AttrCond)theEObject;
        T result = caseAttrCond(attrCond);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTR_COND_DEF_LIBRARY:
      {
        AttrCondDefLibrary attrCondDefLibrary = (AttrCondDefLibrary)theEObject;
        T result = caseAttrCondDefLibrary(attrCondDefLibrary);
        if (result == null) result = caseNamedElements(attrCondDefLibrary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ADORNMENT:
      {
        Adornment adornment = (Adornment)theEObject;
        T result = caseAdornment(adornment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.PARAM_VALUE:
      {
        ParamValue paramValue = (ParamValue)theEObject;
        T result = caseParamValue(paramValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.LOCAL_VARIABLE:
      {
        LocalVariable localVariable = (LocalVariable)theEObject;
        T result = caseLocalVariable(localVariable);
        if (result == null) result = caseParamValue(localVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.CORR_VARIABLE_PATTERN:
      {
        CorrVariablePattern corrVariablePattern = (CorrVariablePattern)theEObject;
        T result = caseCorrVariablePattern(corrVariablePattern);
        if (result == null) result = caseNamePattern(corrVariablePattern);
        if (result == null) result = caseOperatorPattern(corrVariablePattern);
        if (result == null) result = caseNamedElements(corrVariablePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.OBJECT_VARIABLE_PATTERN:
      {
        ObjectVariablePattern objectVariablePattern = (ObjectVariablePattern)theEObject;
        T result = caseObjectVariablePattern(objectVariablePattern);
        if (result == null) result = caseNamePattern(objectVariablePattern);
        if (result == null) result = caseOperatorPattern(objectVariablePattern);
        if (result == null) result = caseNamedElements(objectVariablePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN:
      {
        ContextObjectVariablePattern contextObjectVariablePattern = (ContextObjectVariablePattern)theEObject;
        T result = caseContextObjectVariablePattern(contextObjectVariablePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTRIBUTE_CONSTRAINT:
      {
        AttributeConstraint attributeConstraint = (AttributeConstraint)theEObject;
        T result = caseAttributeConstraint(attributeConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTRIBUTE_ASSIGNMENT:
      {
        AttributeAssignment attributeAssignment = (AttributeAssignment)theEObject;
        T result = caseAttributeAssignment(attributeAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseParamValue(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ENUM_EXPRESSION:
      {
        EnumExpression enumExpression = (EnumExpression)theEObject;
        T result = caseEnumExpression(enumExpression);
        if (result == null) result = caseExpression(enumExpression);
        if (result == null) result = caseParamValue(enumExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.ATTRIBUTE_EXPRESSION:
      {
        AttributeExpression attributeExpression = (AttributeExpression)theEObject;
        T result = caseAttributeExpression(attributeExpression);
        if (result == null) result = caseExpression(attributeExpression);
        if (result == null) result = caseParamValue(attributeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.LITERAL_EXPRESSION:
      {
        LiteralExpression literalExpression = (LiteralExpression)theEObject;
        T result = caseLiteralExpression(literalExpression);
        if (result == null) result = caseExpression(literalExpression);
        if (result == null) result = caseParamValue(literalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.LINK_VARIABLE_PATTERN:
      {
        LinkVariablePattern linkVariablePattern = (LinkVariablePattern)theEObject;
        T result = caseLinkVariablePattern(linkVariablePattern);
        if (result == null) result = caseOperatorPattern(linkVariablePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.CONTEXT_LINK_VARIABLE_PATTERN:
      {
        ContextLinkVariablePattern contextLinkVariablePattern = (ContextLinkVariablePattern)theEObject;
        T result = caseContextLinkVariablePattern(contextLinkVariablePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.OPERATOR:
      {
        Operator operator = (Operator)theEObject;
        T result = caseOperator(operator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.NAC:
      {
        Nac nac = (Nac)theEObject;
        T result = caseNac(nac);
        if (result == null) result = caseNamedElements(nac);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.USING:
      {
        Using using = (Using)theEObject;
        T result = caseUsing(using);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.OPERATOR_PATTERN:
      {
        OperatorPattern operatorPattern = (OperatorPattern)theEObject;
        T result = caseOperatorPattern(operatorPattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.NAMED_ELEMENTS:
      {
        NamedElements namedElements = (NamedElements)theEObject;
        T result = caseNamedElements(namedElements);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TggPackage.NAME_PATTERN:
      {
        NamePattern namePattern = (NamePattern)theEObject;
        T result = caseNamePattern(namePattern);
        if (result == null) result = caseOperatorPattern(namePattern);
        if (result == null) result = caseNamedElements(namePattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Triple Graph Grammar File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Triple Graph Grammar File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTripleGraphGrammarFile(TripleGraphGrammarFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Schema</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Schema</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSchema(Schema object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Corr Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Corr Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCorrType(CorrType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Cond Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Cond Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrCondDef(AttrCondDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Param</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Param</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParam(Param object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Cond</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Cond</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrCond(AttrCond object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Cond Def Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Cond Def Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrCondDefLibrary(AttrCondDefLibrary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adornment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adornment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdornment(Adornment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Param Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Param Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParamValue(ParamValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalVariable(LocalVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Corr Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Corr Variable Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCorrVariablePattern(CorrVariablePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Variable Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectVariablePattern(ObjectVariablePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Object Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Object Variable Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextObjectVariablePattern(ContextObjectVariablePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeConstraint(AttributeConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeAssignment(AttributeAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumExpression(EnumExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeExpression(AttributeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralExpression(LiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Variable Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkVariablePattern(LinkVariablePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Link Variable Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Link Variable Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextLinkVariablePattern(ContextLinkVariablePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperator(Operator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nac</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nac</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNac(Nac object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Using</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Using</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUsing(Using object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operator Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperatorPattern(OperatorPattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Elements</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Elements</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElements(NamedElements object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamePattern(NamePattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TggSwitch
