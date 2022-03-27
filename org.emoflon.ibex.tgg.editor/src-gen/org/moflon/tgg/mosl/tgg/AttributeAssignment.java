/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getOp <em>Op</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getValueExp <em>Value Exp</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeAssignment()
 * @model
 * @generated
 */
public interface AttributeAssignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EAttribute)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeAssignment_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeAssignment_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Value Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Exp</em>' containment reference.
   * @see #setValueExp(Expression)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttributeAssignment_ValueExp()
   * @model containment="true"
   * @generated
   */
  Expression getValueExp();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getValueExp <em>Value Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Exp</em>' containment reference.
   * @see #getValueExp()
   * @generated
   */
  void setValueExp(Expression value);

} // AttributeAssignment