/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.moflon.tgg.mosl.tgg.AttributeConstraint;
import org.moflon.tgg.mosl.tgg.Expression;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl#getValueExp <em>Value Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeConstraintImpl extends MinimalEObjectImpl.Container implements AttributeConstraint
{
  /**
   * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute()
   * @generated
   * @ordered
   */
  protected EAttribute attribute;

  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueExp() <em>Value Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueExp()
   * @generated
   * @ordered
   */
  protected Expression valueExp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeConstraintImpl()
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
    return TggPackage.Literals.ATTRIBUTE_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttribute()
  {
    if (attribute != null && attribute.eIsProxy())
    {
      InternalEObject oldAttribute = (InternalEObject)attribute;
      attribute = (EAttribute)eResolveProxy(oldAttribute);
      if (attribute != oldAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE, oldAttribute, attribute));
      }
    }
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetAttribute()
  {
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttribute(EAttribute newAttribute)
  {
    EAttribute oldAttribute = attribute;
    attribute = newAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE, oldAttribute, attribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_CONSTRAINT__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValueExp()
  {
    return valueExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueExp(Expression newValueExp, NotificationChain msgs)
  {
    Expression oldValueExp = valueExp;
    valueExp = newValueExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP, oldValueExp, newValueExp);
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
  public void setValueExp(Expression newValueExp)
  {
    if (newValueExp != valueExp)
    {
      NotificationChain msgs = null;
      if (valueExp != null)
        msgs = ((InternalEObject)valueExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP, null, msgs);
      if (newValueExp != null)
        msgs = ((InternalEObject)newValueExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP, null, msgs);
      msgs = basicSetValueExp(newValueExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP, newValueExp, newValueExp));
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
      case TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP:
        return basicSetValueExp(null, msgs);
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
      case TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
      case TggPackage.ATTRIBUTE_CONSTRAINT__OP:
        return getOp();
      case TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP:
        return getValueExp();
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
      case TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE:
        setAttribute((EAttribute)newValue);
        return;
      case TggPackage.ATTRIBUTE_CONSTRAINT__OP:
        setOp((String)newValue);
        return;
      case TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP:
        setValueExp((Expression)newValue);
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
      case TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE:
        setAttribute((EAttribute)null);
        return;
      case TggPackage.ATTRIBUTE_CONSTRAINT__OP:
        setOp(OP_EDEFAULT);
        return;
      case TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP:
        setValueExp((Expression)null);
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
      case TggPackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE:
        return attribute != null;
      case TggPackage.ATTRIBUTE_CONSTRAINT__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case TggPackage.ATTRIBUTE_CONSTRAINT__VALUE_EXP:
        return valueExp != null;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //AttributeConstraintImpl
