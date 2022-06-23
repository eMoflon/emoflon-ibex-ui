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

import org.emoflon.ibex.tgg.integrate.integrate.ConflictResolutionSpecification;
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;
import org.emoflon.ibex.tgg.integrate.integrate.Resolution;
import org.emoflon.ibex.tgg.integrate.integrate.SatisfactionRule;
import org.emoflon.ibex.tgg.integrate.integrate.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Resolution Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ConflictResolutionSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ConflictResolutionSpecificationImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ConflictResolutionSpecificationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.ConflictResolutionSpecificationImpl#getResolution <em>Resolution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictResolutionSpecificationImpl extends MinimalEObjectImpl.Container implements ConflictResolutionSpecification
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
   * The cached value of the '{@link #getResolution() <em>Resolution</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResolution()
   * @generated
   * @ordered
   */
  protected Resolution resolution;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConflictResolutionSpecificationImpl()
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
    return IntegratePackage.Literals.CONFLICT_RESOLUTION_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__NAME, oldName, name));
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
      variables = new EObjectContainmentEList<Variable>(Variable.class, this, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES);
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE, oldRule, newRule);
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
        msgs = ((InternalEObject)rule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE, null, msgs);
      if (newRule != null)
        msgs = ((InternalEObject)newRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE, null, msgs);
      msgs = basicSetRule(newRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE, newRule, newRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Resolution getResolution()
  {
    return resolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResolution(Resolution newResolution, NotificationChain msgs)
  {
    Resolution oldResolution = resolution;
    resolution = newResolution;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION, oldResolution, newResolution);
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
  public void setResolution(Resolution newResolution)
  {
    if (newResolution != resolution)
    {
      NotificationChain msgs = null;
      if (resolution != null)
        msgs = ((InternalEObject)resolution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION, null, msgs);
      if (newResolution != null)
        msgs = ((InternalEObject)newResolution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION, null, msgs);
      msgs = basicSetResolution(newResolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION, newResolution, newResolution));
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
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE:
        return basicSetRule(null, msgs);
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION:
        return basicSetResolution(null, msgs);
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
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__NAME:
        return getName();
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES:
        return getVariables();
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE:
        return getRule();
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION:
        return getResolution();
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
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__NAME:
        setName((String)newValue);
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends Variable>)newValue);
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE:
        setRule((SatisfactionRule)newValue);
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION:
        setResolution((Resolution)newValue);
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
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES:
        getVariables().clear();
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE:
        setRule((SatisfactionRule)null);
        return;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION:
        setResolution((Resolution)null);
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
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__VARIABLES:
        return variables != null && !variables.isEmpty();
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RULE:
        return rule != null;
      case IntegratePackage.CONFLICT_RESOLUTION_SPECIFICATION__RESOLUTION:
        return resolution != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ConflictResolutionSpecificationImpl
