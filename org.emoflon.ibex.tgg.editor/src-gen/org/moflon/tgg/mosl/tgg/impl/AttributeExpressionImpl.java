/**
 */
package org.moflon.tgg.mosl.tgg.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.moflon.tgg.mosl.tgg.AttributeExpression;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl#getObjectVar <em>Object Var</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeExpressionImpl extends ExpressionImpl implements AttributeExpression
{
  /**
   * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final boolean DERIVED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected boolean derived = DERIVED_EDEFAULT;

  /**
   * The cached value of the '{@link #getObjectVar() <em>Object Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectVar()
   * @generated
   * @ordered
   */
  protected EObject objectVar;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeExpressionImpl()
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
    return TggPackage.Literals.ATTRIBUTE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDerived()
  {
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDerived(boolean newDerived)
  {
    boolean oldDerived = derived;
    derived = newDerived;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_EXPRESSION__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getObjectVar()
  {
    if (objectVar != null && objectVar.eIsProxy())
    {
      InternalEObject oldObjectVar = (InternalEObject)objectVar;
      objectVar = eResolveProxy(oldObjectVar);
      if (objectVar != oldObjectVar)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR, oldObjectVar, objectVar));
      }
    }
    return objectVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetObjectVar()
  {
    return objectVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setObjectVar(EObject newObjectVar)
  {
    EObject oldObjectVar = objectVar;
    objectVar = newObjectVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR, oldObjectVar, objectVar));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE, oldAttribute, attribute));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE, oldAttribute, attribute));
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
      case TggPackage.ATTRIBUTE_EXPRESSION__DERIVED:
        return isDerived();
      case TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR:
        if (resolve) return getObjectVar();
        return basicGetObjectVar();
      case TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
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
      case TggPackage.ATTRIBUTE_EXPRESSION__DERIVED:
        setDerived((Boolean)newValue);
        return;
      case TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR:
        setObjectVar((EObject)newValue);
        return;
      case TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE:
        setAttribute((EAttribute)newValue);
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
      case TggPackage.ATTRIBUTE_EXPRESSION__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR:
        setObjectVar((EObject)null);
        return;
      case TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE:
        setAttribute((EAttribute)null);
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
      case TggPackage.ATTRIBUTE_EXPRESSION__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case TggPackage.ATTRIBUTE_EXPRESSION__OBJECT_VAR:
        return objectVar != null;
      case TggPackage.ATTRIBUTE_EXPRESSION__ATTRIBUTE:
        return attribute != null;
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
    result.append(" (derived: ");
    result.append(derived);
    result.append(')');
    return result.toString();
  }

} //AttributeExpressionImpl
