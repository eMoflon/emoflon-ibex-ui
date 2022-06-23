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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta;
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule;
import org.emoflon.ibex.tgg.integrate.integrate.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operational Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.OperationalDeltaImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.OperationalDeltaImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationalDeltaImpl extends MinimalEObjectImpl.Container implements OperationalDelta
{
  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<Variable> variables;

  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected SatisfactionRule rule;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationalDeltaImpl()
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
    return IntegratePackage.Literals.OPERATIONAL_DELTA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Variable> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<Variable>(Variable.class, this, IntegratePackage.OPERATIONAL_DELTA__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SatisfactionRule getRule()
  {
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRule(SatisfactionRule newRule, NotificationChain msgs)
  {
    SatisfactionRule oldRule = rule;
    rule = newRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.OPERATIONAL_DELTA__RULE, oldRule, newRule);
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
  public void setRule(SatisfactionRule newRule)
  {
    if (newRule != rule)
    {
      NotificationChain msgs = null;
      if (rule != null)
        msgs = ((InternalEObject)rule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.OPERATIONAL_DELTA__RULE, null, msgs);
      if (newRule != null)
        msgs = ((InternalEObject)newRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.OPERATIONAL_DELTA__RULE, null, msgs);
      msgs = basicSetRule(newRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.OPERATIONAL_DELTA__RULE, newRule, newRule));
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
      case IntegratePackage.OPERATIONAL_DELTA__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case IntegratePackage.OPERATIONAL_DELTA__RULE:
        return basicSetRule(null, msgs);
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
      case IntegratePackage.OPERATIONAL_DELTA__VARIABLES:
        return getVariables();
      case IntegratePackage.OPERATIONAL_DELTA__RULE:
        return getRule();
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
      case IntegratePackage.OPERATIONAL_DELTA__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends Variable>)newValue);
        return;
      case IntegratePackage.OPERATIONAL_DELTA__RULE:
        setRule((SatisfactionRule)newValue);
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
      case IntegratePackage.OPERATIONAL_DELTA__VARIABLES:
        getVariables().clear();
        return;
      case IntegratePackage.OPERATIONAL_DELTA__RULE:
        setRule((SatisfactionRule)null);
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
      case IntegratePackage.OPERATIONAL_DELTA__VARIABLES:
        return variables != null && !variables.isEmpty();
      case IntegratePackage.OPERATIONAL_DELTA__RULE:
        return rule != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationalDeltaImpl
