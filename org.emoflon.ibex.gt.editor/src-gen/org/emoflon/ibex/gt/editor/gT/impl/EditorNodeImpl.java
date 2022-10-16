/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.EditorReferenceIterator;
import org.emoflon.ibex.gt.editor.gT.GTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.impl.EditorNodeImpl#getIterators <em>Iterators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditorNodeImpl extends EditorParameterOrNodeImpl implements EditorNode
{
  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final EditorOperator OPERATOR_EDEFAULT = EditorOperator.CONTEXT;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected EditorOperator operator = OPERATOR_EDEFAULT;

  /**
   * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected static final boolean LOCAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected boolean local = LOCAL_EDEFAULT;

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
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<EditorAttributeAssignment> attributes;

  /**
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected EList<EditorReference> references;

  /**
   * The cached value of the '{@link #getIterators() <em>Iterators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIterators()
   * @generated
   * @ordered
   */
  protected EList<EditorReferenceIterator> iterators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EditorNodeImpl()
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
    return GTPackage.Literals.EDITOR_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EditorOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOperator(EditorOperator newOperator)
  {
    EditorOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_NODE__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isLocal()
  {
    return local;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLocal(boolean newLocal)
  {
    boolean oldLocal = local;
    local = newLocal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_NODE__LOCAL, oldLocal, local));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GTPackage.EDITOR_NODE__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GTPackage.EDITOR_NODE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EditorAttributeAssignment> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<EditorAttributeAssignment>(EditorAttributeAssignment.class, this, GTPackage.EDITOR_NODE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EditorReference> getReferences()
  {
    if (references == null)
    {
      references = new EObjectContainmentEList<EditorReference>(EditorReference.class, this, GTPackage.EDITOR_NODE__REFERENCES);
    }
    return references;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EditorReferenceIterator> getIterators()
  {
    if (iterators == null)
    {
      iterators = new EObjectContainmentEList<EditorReferenceIterator>(EditorReferenceIterator.class, this, GTPackage.EDITOR_NODE__ITERATORS);
    }
    return iterators;
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
      case GTPackage.EDITOR_NODE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case GTPackage.EDITOR_NODE__REFERENCES:
        return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
      case GTPackage.EDITOR_NODE__ITERATORS:
        return ((InternalEList<?>)getIterators()).basicRemove(otherEnd, msgs);
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
      case GTPackage.EDITOR_NODE__OPERATOR:
        return getOperator();
      case GTPackage.EDITOR_NODE__LOCAL:
        return isLocal();
      case GTPackage.EDITOR_NODE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case GTPackage.EDITOR_NODE__ATTRIBUTES:
        return getAttributes();
      case GTPackage.EDITOR_NODE__REFERENCES:
        return getReferences();
      case GTPackage.EDITOR_NODE__ITERATORS:
        return getIterators();
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
      case GTPackage.EDITOR_NODE__OPERATOR:
        setOperator((EditorOperator)newValue);
        return;
      case GTPackage.EDITOR_NODE__LOCAL:
        setLocal((Boolean)newValue);
        return;
      case GTPackage.EDITOR_NODE__TYPE:
        setType((EClass)newValue);
        return;
      case GTPackage.EDITOR_NODE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends EditorAttributeAssignment>)newValue);
        return;
      case GTPackage.EDITOR_NODE__REFERENCES:
        getReferences().clear();
        getReferences().addAll((Collection<? extends EditorReference>)newValue);
        return;
      case GTPackage.EDITOR_NODE__ITERATORS:
        getIterators().clear();
        getIterators().addAll((Collection<? extends EditorReferenceIterator>)newValue);
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
      case GTPackage.EDITOR_NODE__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case GTPackage.EDITOR_NODE__LOCAL:
        setLocal(LOCAL_EDEFAULT);
        return;
      case GTPackage.EDITOR_NODE__TYPE:
        setType((EClass)null);
        return;
      case GTPackage.EDITOR_NODE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case GTPackage.EDITOR_NODE__REFERENCES:
        getReferences().clear();
        return;
      case GTPackage.EDITOR_NODE__ITERATORS:
        getIterators().clear();
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
      case GTPackage.EDITOR_NODE__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case GTPackage.EDITOR_NODE__LOCAL:
        return local != LOCAL_EDEFAULT;
      case GTPackage.EDITOR_NODE__TYPE:
        return type != null;
      case GTPackage.EDITOR_NODE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case GTPackage.EDITOR_NODE__REFERENCES:
        return references != null && !references.isEmpty();
      case GTPackage.EDITOR_NODE__ITERATORS:
        return iterators != null && !iterators.isEmpty();
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(", local: ");
    result.append(local);
    result.append(')');
    return result.toString();
  }

} //EditorNodeImpl
