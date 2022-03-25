/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.OperatorPattern#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getOperatorPattern()
 * @model
 * @generated
 */
public interface OperatorPattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference.
   * @see #setOp(Operator)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getOperatorPattern_Op()
   * @model containment="true"
   * @generated
   */
  Operator getOp();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.OperatorPattern#getOp <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' containment reference.
   * @see #getOp()
   * @generated
   */
  void setOp(Operator value);

} // OperatorPattern
