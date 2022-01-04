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

import org.moflon.tgg.mosl.tgg.AttributeAssignment;
import org.moflon.tgg.mosl.tgg.AttributeConstraint;
import org.moflon.tgg.mosl.tgg.LinkVariablePattern;
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl#getAttributeAssignments <em>Attribute Assignments</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl#getAttributeConstraints <em>Attribute Constraints</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl#getLinkVariablePatterns <em>Link Variable Patterns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectVariablePatternImpl extends NamePatternImpl implements ObjectVariablePattern
{
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
   * The cached value of the '{@link #getAttributeAssignments() <em>Attribute Assignments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeAssignments()
   * @generated
   * @ordered
   */
  protected EList<AttributeAssignment> attributeAssignments;

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
  protected EList<LinkVariablePattern> linkVariablePatterns;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectVariablePatternImpl()
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
    return TggPackage.Literals.OBJECT_VARIABLE_PATTERN;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.OBJECT_VARIABLE_PATTERN__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.OBJECT_VARIABLE_PATTERN__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeAssignment> getAttributeAssignments()
  {
    if (attributeAssignments == null)
    {
      attributeAssignments = new EObjectContainmentEList<AttributeAssignment>(AttributeAssignment.class, this, TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS);
    }
    return attributeAssignments;
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
      attributeConstraints = new EObjectContainmentEList<AttributeConstraint>(AttributeConstraint.class, this, TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS);
    }
    return attributeConstraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LinkVariablePattern> getLinkVariablePatterns()
  {
    if (linkVariablePatterns == null)
    {
      linkVariablePatterns = new EObjectContainmentEList<LinkVariablePattern>(LinkVariablePattern.class, this, TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS);
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
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS:
        return ((InternalEList<?>)getAttributeAssignments()).basicRemove(otherEnd, msgs);
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return ((InternalEList<?>)getAttributeConstraints()).basicRemove(otherEnd, msgs);
      case TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
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
      case TggPackage.OBJECT_VARIABLE_PATTERN__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS:
        return getAttributeAssignments();
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return getAttributeConstraints();
      case TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
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
      case TggPackage.OBJECT_VARIABLE_PATTERN__TYPE:
        setType((EClass)newValue);
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS:
        getAttributeAssignments().clear();
        getAttributeAssignments().addAll((Collection<? extends AttributeAssignment>)newValue);
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        getAttributeConstraints().clear();
        getAttributeConstraints().addAll((Collection<? extends AttributeConstraint>)newValue);
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        getLinkVariablePatterns().clear();
        getLinkVariablePatterns().addAll((Collection<? extends LinkVariablePattern>)newValue);
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
      case TggPackage.OBJECT_VARIABLE_PATTERN__TYPE:
        setType((EClass)null);
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS:
        getAttributeAssignments().clear();
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        getAttributeConstraints().clear();
        return;
      case TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
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
      case TggPackage.OBJECT_VARIABLE_PATTERN__TYPE:
        return type != null;
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS:
        return attributeAssignments != null && !attributeAssignments.isEmpty();
      case TggPackage.OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS:
        return attributeConstraints != null && !attributeConstraints.isEmpty();
      case TggPackage.OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS:
        return linkVariablePatterns != null && !linkVariablePatterns.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ObjectVariablePatternImpl
