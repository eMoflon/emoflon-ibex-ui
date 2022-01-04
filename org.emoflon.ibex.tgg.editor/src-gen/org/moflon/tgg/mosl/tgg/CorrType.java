/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Corr Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrType#getSuper <em>Super</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrType#getSource <em>Source</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrType#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrType()
 * @model
 * @generated
 */
public interface CorrType extends NamedElements
{
  /**
   * Returns the value of the '<em><b>Super</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super</em>' reference.
   * @see #setSuper(CorrType)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrType_Super()
   * @model
   * @generated
   */
  CorrType getSuper();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrType#getSuper <em>Super</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super</em>' reference.
   * @see #getSuper()
   * @generated
   */
  void setSuper(CorrType value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(EClass)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrType_Source()
   * @model
   * @generated
   */
  EClass getSource();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrType#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(EClass value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(EClass)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrType_Target()
   * @model
   * @generated
   */
  EClass getTarget();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrType#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(EClass value);

} // CorrType
