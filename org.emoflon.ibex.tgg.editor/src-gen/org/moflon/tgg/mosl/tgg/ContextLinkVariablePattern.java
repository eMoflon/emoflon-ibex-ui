/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Link Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextLinkVariablePattern()
 * @model
 * @generated
 */
public interface ContextLinkVariablePattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EReference)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextLinkVariablePattern_Type()
   * @model
   * @generated
   */
  EReference getType();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EReference value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ContextObjectVariablePattern)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextLinkVariablePattern_Target()
   * @model
   * @generated
   */
  ContextObjectVariablePattern getTarget();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ContextObjectVariablePattern value);

} // ContextLinkVariablePattern
