/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.moflon.tgg.mosl.tgg.Adornment;
import org.moflon.tgg.mosl.tgg.AttrCondDef;
import org.moflon.tgg.mosl.tgg.Param;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Cond Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl#isUserDefined <em>User Defined</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl#getAllowedSyncAdornments <em>Allowed Sync Adornments</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl#getAllowedGenAdornments <em>Allowed Gen Adornments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttrCondDefImpl extends NamedElementsImpl implements AttrCondDef
{
  /**
   * The default value of the '{@link #isUserDefined() <em>User Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUserDefined()
   * @generated
   * @ordered
   */
  protected static final boolean USER_DEFINED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUserDefined() <em>User Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUserDefined()
   * @generated
   * @ordered
   */
  protected boolean userDefined = USER_DEFINED_EDEFAULT;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<Param> params;

  /**
   * The cached value of the '{@link #getAllowedSyncAdornments() <em>Allowed Sync Adornments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAllowedSyncAdornments()
   * @generated
   * @ordered
   */
  protected EList<Adornment> allowedSyncAdornments;

  /**
   * The cached value of the '{@link #getAllowedGenAdornments() <em>Allowed Gen Adornments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAllowedGenAdornments()
   * @generated
   * @ordered
   */
  protected EList<Adornment> allowedGenAdornments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrCondDefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TggPackage.Literals.ATTR_COND_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUserDefined()
  {
    return userDefined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUserDefined(boolean newUserDefined)
  {
    boolean oldUserDefined = userDefined;
    userDefined = newUserDefined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTR_COND_DEF__USER_DEFINED, oldUserDefined, userDefined));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Param> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<Param>(Param.class, this, TggPackage.ATTR_COND_DEF__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Adornment> getAllowedSyncAdornments()
  {
    if (allowedSyncAdornments == null)
    {
      allowedSyncAdornments = new EObjectContainmentEList<Adornment>(Adornment.class, this, TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS);
    }
    return allowedSyncAdornments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Adornment> getAllowedGenAdornments()
  {
    if (allowedGenAdornments == null)
    {
      allowedGenAdornments = new EObjectContainmentEList<Adornment>(Adornment.class, this, TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS);
    }
    return allowedGenAdornments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TggPackage.ATTR_COND_DEF__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
      case TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS:
        return ((InternalEList<?>)getAllowedSyncAdornments()).basicRemove(otherEnd, msgs);
      case TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS:
        return ((InternalEList<?>)getAllowedGenAdornments()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TggPackage.ATTR_COND_DEF__USER_DEFINED:
        return isUserDefined();
      case TggPackage.ATTR_COND_DEF__PARAMS:
        return getParams();
      case TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS:
        return getAllowedSyncAdornments();
      case TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS:
        return getAllowedGenAdornments();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TggPackage.ATTR_COND_DEF__USER_DEFINED:
        setUserDefined((Boolean)newValue);
        return;
      case TggPackage.ATTR_COND_DEF__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends Param>)newValue);
        return;
      case TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS:
        getAllowedSyncAdornments().clear();
        getAllowedSyncAdornments().addAll((Collection<? extends Adornment>)newValue);
        return;
      case TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS:
        getAllowedGenAdornments().clear();
        getAllowedGenAdornments().addAll((Collection<? extends Adornment>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TggPackage.ATTR_COND_DEF__USER_DEFINED:
        setUserDefined(USER_DEFINED_EDEFAULT);
        return;
      case TggPackage.ATTR_COND_DEF__PARAMS:
        getParams().clear();
        return;
      case TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS:
        getAllowedSyncAdornments().clear();
        return;
      case TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS:
        getAllowedGenAdornments().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TggPackage.ATTR_COND_DEF__USER_DEFINED:
        return userDefined != USER_DEFINED_EDEFAULT;
      case TggPackage.ATTR_COND_DEF__PARAMS:
        return params != null && !params.isEmpty();
      case TggPackage.ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS:
        return allowedSyncAdornments != null && !allowedSyncAdornments.isEmpty();
      case TggPackage.ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS:
        return allowedGenAdornments != null && !allowedGenAdornments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (userDefined: ");
    result.append(userDefined);
    result.append(')');
    return result.toString();
  }

} //AttrCondDefImpl