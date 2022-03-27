/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.moflon.tgg.mosl.tgg.AttrCondDef;
import org.moflon.tgg.mosl.tgg.CorrType;
import org.moflon.tgg.mosl.tgg.Schema;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl#getSourceTypes <em>Source Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl#getTargetTypes <em>Target Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl#getCorrespondenceTypes <em>Correspondence Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl#getAttributeCondDefs <em>Attribute Cond Defs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchemaImpl extends NamedElementsImpl implements Schema
{
  /**
   * The cached value of the '{@link #getSourceTypes() <em>Source Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceTypes()
   * @generated
   * @ordered
   */
  protected EList<EPackage> sourceTypes;

  /**
   * The cached value of the '{@link #getTargetTypes() <em>Target Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetTypes()
   * @generated
   * @ordered
   */
  protected EList<EPackage> targetTypes;

  /**
   * The cached value of the '{@link #getCorrespondenceTypes() <em>Correspondence Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrespondenceTypes()
   * @generated
   * @ordered
   */
  protected EList<CorrType> correspondenceTypes;

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
  protected SchemaImpl()
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
    return TggPackage.Literals.SCHEMA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EPackage> getSourceTypes()
  {
    if (sourceTypes == null)
    {
      sourceTypes = new EObjectResolvingEList<EPackage>(EPackage.class, this, TggPackage.SCHEMA__SOURCE_TYPES);
    }
    return sourceTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EPackage> getTargetTypes()
  {
    if (targetTypes == null)
    {
      targetTypes = new EObjectResolvingEList<EPackage>(EPackage.class, this, TggPackage.SCHEMA__TARGET_TYPES);
    }
    return targetTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<CorrType> getCorrespondenceTypes()
  {
    if (correspondenceTypes == null)
    {
      correspondenceTypes = new EObjectContainmentEList<CorrType>(CorrType.class, this, TggPackage.SCHEMA__CORRESPONDENCE_TYPES);
    }
    return correspondenceTypes;
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
      attributeCondDefs = new EObjectContainmentEList<AttrCondDef>(AttrCondDef.class, this, TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS);
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
      case TggPackage.SCHEMA__CORRESPONDENCE_TYPES:
        return ((InternalEList<?>)getCorrespondenceTypes()).basicRemove(otherEnd, msgs);
      case TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS:
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
      case TggPackage.SCHEMA__SOURCE_TYPES:
        return getSourceTypes();
      case TggPackage.SCHEMA__TARGET_TYPES:
        return getTargetTypes();
      case TggPackage.SCHEMA__CORRESPONDENCE_TYPES:
        return getCorrespondenceTypes();
      case TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS:
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
      case TggPackage.SCHEMA__SOURCE_TYPES:
        getSourceTypes().clear();
        getSourceTypes().addAll((Collection<? extends EPackage>)newValue);
        return;
      case TggPackage.SCHEMA__TARGET_TYPES:
        getTargetTypes().clear();
        getTargetTypes().addAll((Collection<? extends EPackage>)newValue);
        return;
      case TggPackage.SCHEMA__CORRESPONDENCE_TYPES:
        getCorrespondenceTypes().clear();
        getCorrespondenceTypes().addAll((Collection<? extends CorrType>)newValue);
        return;
      case TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS:
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
      case TggPackage.SCHEMA__SOURCE_TYPES:
        getSourceTypes().clear();
        return;
      case TggPackage.SCHEMA__TARGET_TYPES:
        getTargetTypes().clear();
        return;
      case TggPackage.SCHEMA__CORRESPONDENCE_TYPES:
        getCorrespondenceTypes().clear();
        return;
      case TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS:
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
      case TggPackage.SCHEMA__SOURCE_TYPES:
        return sourceTypes != null && !sourceTypes.isEmpty();
      case TggPackage.SCHEMA__TARGET_TYPES:
        return targetTypes != null && !targetTypes.isEmpty();
      case TggPackage.SCHEMA__CORRESPONDENCE_TYPES:
        return correspondenceTypes != null && !correspondenceTypes.isEmpty();
      case TggPackage.SCHEMA__ATTRIBUTE_COND_DEFS:
        return attributeCondDefs != null && !attributeCondDefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SchemaImpl