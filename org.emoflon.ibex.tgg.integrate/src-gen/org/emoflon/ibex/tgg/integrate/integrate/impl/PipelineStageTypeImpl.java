/**
 * generated by Xtext 2.26.0
 */
package org.emoflon.ibex.tgg.integrate.integrate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageEnd;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Stage Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.PipelineStageTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.PipelineStageTypeImpl#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineStageTypeImpl extends PipelineStageFilterImpl implements PipelineStageType
{
  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<EClass> types;

  /**
   * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNext()
   * @generated
   * @ordered
   */
  protected PipelineStageEnd next;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PipelineStageTypeImpl()
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
    return IntegratePackage.Literals.PIPELINE_STAGE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EClass> getTypes()
  {
    if (types == null)
    {
      types = new EObjectResolvingEList<EClass>(EClass.class, this, IntegratePackage.PIPELINE_STAGE_TYPE__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PipelineStageEnd getNext()
  {
    return next;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNext(PipelineStageEnd newNext, NotificationChain msgs)
  {
    PipelineStageEnd oldNext = next;
    next = newNext;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.PIPELINE_STAGE_TYPE__NEXT, oldNext, newNext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNext(PipelineStageEnd newNext)
  {
    if (newNext != next)
    {
      NotificationChain msgs = null;
      if (next != null)
        msgs = ((InternalEObject)next).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.PIPELINE_STAGE_TYPE__NEXT, null, msgs);
      if (newNext != null)
        msgs = ((InternalEObject)newNext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.PIPELINE_STAGE_TYPE__NEXT, null, msgs);
      msgs = basicSetNext(newNext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.PIPELINE_STAGE_TYPE__NEXT, newNext, newNext));
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
      case IntegratePackage.PIPELINE_STAGE_TYPE__NEXT:
        return basicSetNext(null, msgs);
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
      case IntegratePackage.PIPELINE_STAGE_TYPE__TYPES:
        return getTypes();
      case IntegratePackage.PIPELINE_STAGE_TYPE__NEXT:
        return getNext();
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
      case IntegratePackage.PIPELINE_STAGE_TYPE__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends EClass>)newValue);
        return;
      case IntegratePackage.PIPELINE_STAGE_TYPE__NEXT:
        setNext((PipelineStageEnd)newValue);
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
      case IntegratePackage.PIPELINE_STAGE_TYPE__TYPES:
        getTypes().clear();
        return;
      case IntegratePackage.PIPELINE_STAGE_TYPE__NEXT:
        setNext((PipelineStageEnd)null);
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
      case IntegratePackage.PIPELINE_STAGE_TYPE__TYPES:
        return types != null && !types.isEmpty();
      case IntegratePackage.PIPELINE_STAGE_TYPE__NEXT:
        return next != null;
    }
    return super.eIsSet(featureID);
  }

} //PipelineStageTypeImpl
