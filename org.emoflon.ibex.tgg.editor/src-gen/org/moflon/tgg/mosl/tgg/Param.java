/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Param#getParamName <em>Param Name</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Param#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EObject
{
  /**
   * Returns the value of the '<em><b>Param Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Name</em>' attribute.
   * @see #setParamName(String)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getParam_ParamName()
   * @model
   * @generated
   */
  String getParamName();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.Param#getParamName <em>Param Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param Name</em>' attribute.
   * @see #getParamName()
   * @generated
   */
  void setParamName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EDataType)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getParam_Type()
   * @model
   * @generated
   */
  EDataType getType();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.Param#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EDataType value);

} // Param
