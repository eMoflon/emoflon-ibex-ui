/**
 */
package org.moflon.tgg.mosl.tgg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Corr Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getSource <em>Source</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrVariablePattern()
 * @model
 * @generated
 */
public interface CorrVariablePattern extends NamePattern
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(CorrType)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrVariablePattern_Type()
   * @model
   * @generated
   */
  CorrType getType();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(CorrType value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(ObjectVariablePattern)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrVariablePattern_Source()
   * @model
   * @generated
   */
  ObjectVariablePattern getSource();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(ObjectVariablePattern value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ObjectVariablePattern)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getCorrVariablePattern_Target()
   * @model
   * @generated
   */
  ObjectVariablePattern getTarget();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ObjectVariablePattern value);

} // CorrVariablePattern
