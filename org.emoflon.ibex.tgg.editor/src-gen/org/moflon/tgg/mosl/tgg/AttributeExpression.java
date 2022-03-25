/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeExpression#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getObjectVar <em>Object Var</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeExpression()
 * @model
 * @generated
 */
public interface AttributeExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derived</em>' attribute.
   * @see #setDerived(boolean)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeExpression_Derived()
   * @model
   * @generated
   */
  boolean isDerived();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#isDerived <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived</em>' attribute.
   * @see #isDerived()
   * @generated
   */
  void setDerived(boolean value);

  /**
   * Returns the value of the '<em><b>Object Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Var</em>' reference.
   * @see #setObjectVar(EObject)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeExpression_ObjectVar()
   * @model
   * @generated
   */
  EObject getObjectVar();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getObjectVar <em>Object Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Var</em>' reference.
   * @see #getObjectVar()
   * @generated
   */
  void setObjectVar(EObject value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EAttribute)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeExpression_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

} // AttributeExpression
