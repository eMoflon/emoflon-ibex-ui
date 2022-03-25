/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.gT.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emoflon.ibex.gt.editor.gT.EditorCountExpression;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.GTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor Count Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorCountExpressionImpl#getInvokedPatten <em>Invoked Patten</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditorCountExpressionImpl extends ArithmeticExpressionImpl implements EditorCountExpression
{
  /**
   * The cached value of the '{@link #getInvokedPatten() <em>Invoked Patten</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvokedPatten()
   * @generated
   * @ordered
   */
  protected EditorPattern invokedPatten;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EditorCountExpressionImpl()
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
    return GTPackage.Literals.EDITOR_COUNT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EditorPattern getInvokedPatten()
  {
    if (invokedPatten != null && invokedPatten.eIsProxy())
    {
      InternalEObject oldInvokedPatten = (InternalEObject)invokedPatten;
      invokedPatten = (EditorPattern)eResolveProxy(oldInvokedPatten);
      if (invokedPatten != oldInvokedPatten)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN, oldInvokedPatten, invokedPatten));
      }
    }
    return invokedPatten;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EditorPattern basicGetInvokedPatten()
  {
    return invokedPatten;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInvokedPatten(EditorPattern newInvokedPatten)
  {
    EditorPattern oldInvokedPatten = invokedPatten;
    invokedPatten = newInvokedPatten;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN, oldInvokedPatten, invokedPatten));
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
      case GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN:
        if (resolve) return getInvokedPatten();
        return basicGetInvokedPatten();
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
      case GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN:
        setInvokedPatten((EditorPattern)newValue);
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
      case GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN:
        setInvokedPatten((EditorPattern)null);
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
      case GTPackage.EDITOR_COUNT_EXPRESSION__INVOKED_PATTEN:
        return invokedPatten != null;
    }
    return super.eIsSet(featureID);
  }

} //EditorCountExpressionImpl
