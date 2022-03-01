/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.gT.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emoflon.ibex.gt.editor.gT.EditorIteratorAttributeAssignmentItr;
import org.emoflon.ibex.gt.editor.gT.EditorIteratorAttributeExpression;
import org.emoflon.ibex.gt.editor.gT.GTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor Iterator Attribute Assignment Itr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorIteratorAttributeAssignmentItrImpl#getIteratorAttribute <em>Iterator Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditorIteratorAttributeAssignmentItrImpl extends EditorIteratorAttributeAssignmentImpl implements EditorIteratorAttributeAssignmentItr
{
  /**
   * The cached value of the '{@link #getIteratorAttribute() <em>Iterator Attribute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIteratorAttribute()
   * @generated
   * @ordered
   */
  protected EditorIteratorAttributeExpression iteratorAttribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EditorIteratorAttributeAssignmentItrImpl()
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
    return GTPackage.Literals.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EditorIteratorAttributeExpression getIteratorAttribute()
  {
    return iteratorAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIteratorAttribute(EditorIteratorAttributeExpression newIteratorAttribute, NotificationChain msgs)
  {
    EditorIteratorAttributeExpression oldIteratorAttribute = iteratorAttribute;
    iteratorAttribute = newIteratorAttribute;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE, oldIteratorAttribute, newIteratorAttribute);
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
  public void setIteratorAttribute(EditorIteratorAttributeExpression newIteratorAttribute)
  {
    if (newIteratorAttribute != iteratorAttribute)
    {
      NotificationChain msgs = null;
      if (iteratorAttribute != null)
        msgs = ((InternalEObject)iteratorAttribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE, null, msgs);
      if (newIteratorAttribute != null)
        msgs = ((InternalEObject)newIteratorAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE, null, msgs);
      msgs = basicSetIteratorAttribute(newIteratorAttribute, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE, newIteratorAttribute, newIteratorAttribute));
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
      case GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE:
        return basicSetIteratorAttribute(null, msgs);
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
      case GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE:
        return getIteratorAttribute();
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
      case GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE:
        setIteratorAttribute((EditorIteratorAttributeExpression)newValue);
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
      case GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE:
        setIteratorAttribute((EditorIteratorAttributeExpression)null);
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
      case GTPackage.EDITOR_ITERATOR_ATTRIBUTE_ASSIGNMENT_ITR__ITERATOR_ATTRIBUTE:
        return iteratorAttribute != null;
    }
    return super.eIsSet(featureID);
  }

} //EditorIteratorAttributeAssignmentItrImpl
