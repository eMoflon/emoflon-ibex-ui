/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.tgg.integrate.integrate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta;
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategy;
import org.emoflon.ibex.tgg.integrate.integrate.ResolutionStrategyWithOperationalDelta;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolution Strategy With Operational Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ResolutionStrategyWithOperationalDeltaImpl#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ResolutionStrategyWithOperationalDeltaImpl#getOperationalDelta <em>Operational Delta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResolutionStrategyWithOperationalDeltaImpl extends MinimalEObjectImpl.Container implements ResolutionStrategyWithOperationalDelta
{
  /**
   * The cached value of the '{@link #getStrategy() <em>Strategy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrategy()
   * @generated
   * @ordered
   */
  protected ResolutionStrategy strategy;

  /**
   * The cached value of the '{@link #getOperationalDelta() <em>Operational Delta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationalDelta()
   * @generated
   * @ordered
   */
  protected OperationalDelta operationalDelta;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResolutionStrategyWithOperationalDeltaImpl()
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
    return IntegratePackage.Literals.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResolutionStrategy getStrategy()
  {
    return strategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStrategy(ResolutionStrategy newStrategy, NotificationChain msgs)
  {
    ResolutionStrategy oldStrategy = strategy;
    strategy = newStrategy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY, oldStrategy, newStrategy);
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
  public void setStrategy(ResolutionStrategy newStrategy)
  {
    if (newStrategy != strategy)
    {
      NotificationChain msgs = null;
      if (strategy != null)
        msgs = ((InternalEObject)strategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY, null, msgs);
      if (newStrategy != null)
        msgs = ((InternalEObject)newStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY, null, msgs);
      msgs = basicSetStrategy(newStrategy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY, newStrategy, newStrategy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperationalDelta getOperationalDelta()
  {
    return operationalDelta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationalDelta(OperationalDelta newOperationalDelta, NotificationChain msgs)
  {
    OperationalDelta oldOperationalDelta = operationalDelta;
    operationalDelta = newOperationalDelta;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA, oldOperationalDelta, newOperationalDelta);
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
  public void setOperationalDelta(OperationalDelta newOperationalDelta)
  {
    if (newOperationalDelta != operationalDelta)
    {
      NotificationChain msgs = null;
      if (operationalDelta != null)
        msgs = ((InternalEObject)operationalDelta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA, null, msgs);
      if (newOperationalDelta != null)
        msgs = ((InternalEObject)newOperationalDelta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA, null, msgs);
      msgs = basicSetOperationalDelta(newOperationalDelta, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA, newOperationalDelta, newOperationalDelta));
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
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY:
        return basicSetStrategy(null, msgs);
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA:
        return basicSetOperationalDelta(null, msgs);
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
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY:
        return getStrategy();
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA:
        return getOperationalDelta();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY:
        setStrategy((ResolutionStrategy)newValue);
        return;
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA:
        setOperationalDelta((OperationalDelta)newValue);
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
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY:
        setStrategy((ResolutionStrategy)null);
        return;
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA:
        setOperationalDelta((OperationalDelta)null);
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
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__STRATEGY:
        return strategy != null;
      case IntegratePackage.RESOLUTION_STRATEGY_WITH_OPERATIONAL_DELTA__OPERATIONAL_DELTA:
        return operationalDelta != null;
    }
    return super.eIsSet(featureID);
  }

} //ResolutionStrategyWithOperationalDeltaImpl
