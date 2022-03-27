/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Cond Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCondDef#isUserDefined <em>User Defined</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getParams <em>Params</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedSyncAdornments <em>Allowed Sync Adornments</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedGenAdornments <em>Allowed Gen Adornments</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDef()
 * @model
 * @generated
 */
public interface AttrCondDef extends NamedElements
{
  /**
   * Returns the value of the '<em><b>User Defined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Defined</em>' attribute.
   * @see #setUserDefined(boolean)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDef_UserDefined()
   * @model
   * @generated
   */
  boolean isUserDefined();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.AttrCondDef#isUserDefined <em>User Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Defined</em>' attribute.
   * @see #isUserDefined()
   * @generated
   */
  void setUserDefined(boolean value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Param}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDef_Params()
   * @model containment="true"
   * @generated
   */
  EList<Param> getParams();

  /**
   * Returns the value of the '<em><b>Allowed Sync Adornments</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Adornment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Allowed Sync Adornments</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDef_AllowedSyncAdornments()
   * @model containment="true"
   * @generated
   */
  EList<Adornment> getAllowedSyncAdornments();

  /**
   * Returns the value of the '<em><b>Allowed Gen Adornments</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Adornment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Allowed Gen Adornments</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDef_AllowedGenAdornments()
   * @model containment="true"
   * @generated
   */
  EList<Adornment> getAllowedGenAdornments();

} // AttrCondDef