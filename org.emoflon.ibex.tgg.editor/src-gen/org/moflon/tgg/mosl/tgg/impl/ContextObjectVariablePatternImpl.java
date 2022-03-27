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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.moflon.tgg.mosl.tgg.AttributeConstraint;
import org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern;
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Object Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl#getAttributeConstraints <em>Attribute Constraints</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl#getLinkVariablePatterns <em>Link Variable Patterns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContextObjectVariablePatternImpl extends MinimalEObjectImpl.Container implements ContextObjectVariablePattern
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
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClass type;

  /**
   * The cached value of the '{@link #getAttributeConstraints() <em>Attribute Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeConstraints()
   * @generated
   * @ordered
   */
  protected EList<AttributeConstraint> attributeConstraints;

  /**
   * The cached value of the '{@link #getLinkVariablePatterns() <em>Link Variable Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkVariablePatterns()
   * @generated
   * @ordered
   */
  protected EList<ContextLinkVariablePattern> linkVariablePatterns;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextObjectVariablePatternImpl()
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
    return TggPackage.Literals.CONTEXT_OBJECT_VARIABLE_PATTERN;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EClass)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(EClass newType)
  {
    EClass oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeConstraint> getAttributeConstraints()
  {
    if (attributeConstraints == null)
    {
      attributeConstraints = new EObjectContainmentEList<AttributeConstraint>(AttributeConstraint.class, this, TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS);
    }
    return attributeConstraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ContextLinkVariablePattern> getLinkVariablePatterns()
  {
    if (linkVariablePatterns == null)
    {
      linkVariablePatterns = new EObjectContainmentEList<ContextLinkVariablePattern>(ContextLinkVariablePattern.class, this, TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS);
    }
    return linkVariablePatterns;
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
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return ((InternalEList<?>)getAttributeConstraints()).basicRemove(otherEnd, msgs);
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        return ((InternalEList<?>)getLinkVariablePatterns()).basicRemove(otherEnd, msgs);
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
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__NAME:
        return getName();
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return getAttributeConstraints();
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        return getLinkVariablePatterns();
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
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__NAME:
        setName((String)newValue);
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE:
        setType((EClass)newValue);
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        getAttributeConstraints().clear();
        getAttributeConstraints().addAll((Collection<? extends AttributeConstraint>)newValue);
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        getLinkVariablePatterns().clear();
        getLinkVariablePatterns().addAll((Collection<? extends ContextLinkVariablePattern>)newValue);
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
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE:
        setType((EClass)null);
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        getAttributeConstraints().clear();
        return;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        getLinkVariablePatterns().clear();
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
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE:
        return type != null;
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return attributeConstraints != null && !attributeConstraints.isEmpty();
      case TggPackage.CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        return linkVariablePatterns != null && !linkVariablePatterns.isEmpty();
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

} //ContextObjectVariablePatternImpl