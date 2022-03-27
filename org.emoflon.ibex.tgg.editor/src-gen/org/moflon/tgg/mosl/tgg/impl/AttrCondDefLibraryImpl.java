/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.moflon.tgg.mosl.tgg.AttrCondDef;
import org.moflon.tgg.mosl.tgg.AttrCondDefLibrary;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Cond Def Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefLibraryImpl#getAttributeCondDefs <em>Attribute Cond Defs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttrCondDefLibraryImpl extends NamedElementsImpl implements AttrCondDefLibrary
{
  /**
   * The cached value of the '{@link #getAttributeCondDefs() <em>Attribute Cond Defs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeCondDefs()
   * @generated
   * @ordered
   */
  protected EList<AttrCondDef> attributeCondDefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrCondDefLibraryImpl()
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
    return TggPackage.Literals.ATTR_COND_DEF_LIBRARY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttrCondDef> getAttributeCondDefs()
  {
    if (attributeCondDefs == null)
    {
      attributeCondDefs = new EObjectContainmentEList<AttrCondDef>(AttrCondDef.class, this, TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS);
    }
    return attributeCondDefs;
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
      case TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS:
        return ((InternalEList<?>)getAttributeCondDefs()).basicRemove(otherEnd, msgs);
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
      case TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS:
        return getAttributeCondDefs();
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
      case TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS:
        getAttributeCondDefs().clear();
        getAttributeCondDefs().addAll((Collection<? extends AttrCondDef>)newValue);
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
      case TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS:
        getAttributeCondDefs().clear();
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
      case TggPackage.ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS:
        return attributeCondDefs != null && !attributeCondDefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AttrCondDefLibraryImpl