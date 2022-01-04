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

import org.moflon.tgg.mosl.tgg.AttrCond;
import org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.Nac;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nac</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.NacImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.NacImpl#getSourcePatterns <em>Source Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.NacImpl#getTargetPatterns <em>Target Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.NacImpl#getAttrConditions <em>Attr Conditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NacImpl extends NamedElementsImpl implements Nac
{
  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected Rule rule;

  /**
   * The cached value of the '{@link #getSourcePatterns() <em>Source Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourcePatterns()
   * @generated
   * @ordered
   */
  protected EList<ContextObjectVariablePattern> sourcePatterns;

  /**
   * The cached value of the '{@link #getTargetPatterns() <em>Target Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetPatterns()
   * @generated
   * @ordered
   */
  protected EList<ContextObjectVariablePattern> targetPatterns;

  /**
   * The cached value of the '{@link #getAttrConditions() <em>Attr Conditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrConditions()
   * @generated
   * @ordered
   */
  protected EList<AttrCond> attrConditions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NacImpl()
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
    return TggPackage.Literals.NAC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rule getRule()
  {
    if (rule != null && rule.eIsProxy())
    {
      InternalEObject oldRule = (InternalEObject)rule;
      rule = (Rule)eResolveProxy(oldRule);
      if (rule != oldRule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.NAC__RULE, oldRule, rule));
      }
    }
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule basicGetRule()
  {
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRule(Rule newRule)
  {
    Rule oldRule = rule;
    rule = newRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.NAC__RULE, oldRule, rule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ContextObjectVariablePattern> getSourcePatterns()
  {
    if (sourcePatterns == null)
    {
      sourcePatterns = new EObjectContainmentEList<ContextObjectVariablePattern>(ContextObjectVariablePattern.class, this, TggPackage.NAC__SOURCE_PATTERNS);
    }
    return sourcePatterns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ContextObjectVariablePattern> getTargetPatterns()
  {
    if (targetPatterns == null)
    {
      targetPatterns = new EObjectContainmentEList<ContextObjectVariablePattern>(ContextObjectVariablePattern.class, this, TggPackage.NAC__TARGET_PATTERNS);
    }
    return targetPatterns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttrCond> getAttrConditions()
  {
    if (attrConditions == null)
    {
      attrConditions = new EObjectContainmentEList<AttrCond>(AttrCond.class, this, TggPackage.NAC__ATTR_CONDITIONS);
    }
    return attrConditions;
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
      case TggPackage.NAC__SOURCE_PATTERNS:
        return ((InternalEList<?>)getSourcePatterns()).basicRemove(otherEnd, msgs);
      case TggPackage.NAC__TARGET_PATTERNS:
        return ((InternalEList<?>)getTargetPatterns()).basicRemove(otherEnd, msgs);
      case TggPackage.NAC__ATTR_CONDITIONS:
        return ((InternalEList<?>)getAttrConditions()).basicRemove(otherEnd, msgs);
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
      case TggPackage.NAC__RULE:
        if (resolve) return getRule();
        return basicGetRule();
      case TggPackage.NAC__SOURCE_PATTERNS:
        return getSourcePatterns();
      case TggPackage.NAC__TARGET_PATTERNS:
        return getTargetPatterns();
      case TggPackage.NAC__ATTR_CONDITIONS:
        return getAttrConditions();
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
      case TggPackage.NAC__RULE:
        setRule((Rule)newValue);
        return;
      case TggPackage.NAC__SOURCE_PATTERNS:
        getSourcePatterns().clear();
        getSourcePatterns().addAll((Collection<? extends ContextObjectVariablePattern>)newValue);
        return;
      case TggPackage.NAC__TARGET_PATTERNS:
        getTargetPatterns().clear();
        getTargetPatterns().addAll((Collection<? extends ContextObjectVariablePattern>)newValue);
        return;
      case TggPackage.NAC__ATTR_CONDITIONS:
        getAttrConditions().clear();
        getAttrConditions().addAll((Collection<? extends AttrCond>)newValue);
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
      case TggPackage.NAC__RULE:
        setRule((Rule)null);
        return;
      case TggPackage.NAC__SOURCE_PATTERNS:
        getSourcePatterns().clear();
        return;
      case TggPackage.NAC__TARGET_PATTERNS:
        getTargetPatterns().clear();
        return;
      case TggPackage.NAC__ATTR_CONDITIONS:
        getAttrConditions().clear();
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
      case TggPackage.NAC__RULE:
        return rule != null;
      case TggPackage.NAC__SOURCE_PATTERNS:
        return sourcePatterns != null && !sourcePatterns.isEmpty();
      case TggPackage.NAC__TARGET_PATTERNS:
        return targetPatterns != null && !targetPatterns.isEmpty();
      case TggPackage.NAC__ATTR_CONDITIONS:
        return attrConditions != null && !attrConditions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NacImpl
