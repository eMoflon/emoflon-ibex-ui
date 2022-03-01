/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Cond</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCond#getName <em>Name</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCond#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCond()
 * @model
 * @generated
 */
public interface AttrCond extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(AttrCondDef)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCond_Name()
   * @model
   * @generated
   */
  AttrCondDef getName();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttrCond#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(AttrCondDef value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ParamValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCond_Values()
   * @model containment="true"
   * @generated
   */
  EList<ParamValue> getValues();

} // AttrCond
