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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.moflon.tgg.mosl.tgg.AttrCond;
import org.moflon.tgg.mosl.tgg.CorrVariablePattern;
import org.moflon.tgg.mosl.tgg.ObjectVariablePattern;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.Schema;
import org.moflon.tgg.mosl.tgg.TggPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#isAbstractRule <em>Abstract Rule</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getSourcePatterns <em>Source Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getTargetPatterns <em>Target Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getCorrespondencePatterns <em>Correspondence Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl#getAttrConditions <em>Attr Conditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends NamedElementsImpl implements Rule
{
  /**
   * The default value of the '{@link #isAbstractRule() <em>Abstract Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstractRule()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_RULE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstractRule() <em>Abstract Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstractRule()
   * @generated
   * @ordered
   */
  protected boolean abstractRule = ABSTRACT_RULE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupertypes()
   * @generated
   * @ordered
   */
  protected EList<Rule> supertypes;

  /**
   * The cached value of the '{@link #getSchema() <em>Schema</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchema()
   * @generated
   * @ordered
   */
  protected Schema schema;

  /**
   * The cached value of the '{@link #getSourcePatterns() <em>Source Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourcePatterns()
   * @generated
   * @ordered
   */
  protected EList<ObjectVariablePattern> sourcePatterns;

  /**
   * The cached value of the '{@link #getTargetPatterns() <em>Target Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetPatterns()
   * @generated
   * @ordered
   */
  protected EList<ObjectVariablePattern> targetPatterns;

  /**
   * The cached value of the '{@link #getCorrespondencePatterns() <em>Correspondence Patterns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrespondencePatterns()
   * @generated
   * @ordered
   */
  protected EList<CorrVariablePattern> correspondencePatterns;

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
  protected RuleImpl()
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
    return TggPackage.Literals.RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAbstractRule()
  {
    return abstractRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAbstractRule(boolean newAbstractRule)
  {
    boolean oldAbstractRule = abstractRule;
    abstractRule = newAbstractRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.RULE__ABSTRACT_RULE, oldAbstractRule, abstractRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Rule> getSupertypes()
  {
    if (supertypes == null)
    {
      supertypes = new EObjectResolvingEList<Rule>(Rule.class, this, TggPackage.RULE__SUPERTYPES);
    }
    return supertypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Schema getSchema()
  {
    if (schema != null && schema.eIsProxy())
    {
      InternalEObject oldSchema = (InternalEObject)schema;
      schema = (Schema)eResolveProxy(oldSchema);
      if (schema != oldSchema)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TggPackage.RULE__SCHEMA, oldSchema, schema));
      }
    }
    return schema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Schema basicGetSchema()
  {
    return schema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSchema(Schema newSchema)
  {
    Schema oldSchema = schema;
    schema = newSchema;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.RULE__SCHEMA, oldSchema, schema));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ObjectVariablePattern> getSourcePatterns()
  {
    if (sourcePatterns == null)
    {
      sourcePatterns = new EObjectContainmentEList<ObjectVariablePattern>(ObjectVariablePattern.class, this, TggPackage.RULE__SOURCE_PATTERNS);
    }
    return sourcePatterns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ObjectVariablePattern> getTargetPatterns()
  {
    if (targetPatterns == null)
    {
      targetPatterns = new EObjectContainmentEList<ObjectVariablePattern>(ObjectVariablePattern.class, this, TggPackage.RULE__TARGET_PATTERNS);
    }
    return targetPatterns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<CorrVariablePattern> getCorrespondencePatterns()
  {
    if (correspondencePatterns == null)
    {
      correspondencePatterns = new EObjectContainmentEList<CorrVariablePattern>(CorrVariablePattern.class, this, TggPackage.RULE__CORRESPONDENCE_PATTERNS);
    }
    return correspondencePatterns;
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
      attrConditions = new EObjectContainmentEList<AttrCond>(AttrCond.class, this, TggPackage.RULE__ATTR_CONDITIONS);
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
      case TggPackage.RULE__SOURCE_PATTERNS:
        return ((InternalEList<?>)getSourcePatterns()).basicRemove(otherEnd, msgs);
      case TggPackage.RULE__TARGET_PATTERNS:
        return ((InternalEList<?>)getTargetPatterns()).basicRemove(otherEnd, msgs);
      case TggPackage.RULE__CORRESPONDENCE_PATTERNS:
        return ((InternalEList<?>)getCorrespondencePatterns()).basicRemove(otherEnd, msgs);
      case TggPackage.RULE__ATTR_CONDITIONS:
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
      case TggPackage.RULE__ABSTRACT_RULE:
        return isAbstractRule();
      case TggPackage.RULE__SUPERTYPES:
        return getSupertypes();
      case TggPackage.RULE__SCHEMA:
        if (resolve) return getSchema();
        return basicGetSchema();
      case TggPackage.RULE__SOURCE_PATTERNS:
        return getSourcePatterns();
      case TggPackage.RULE__TARGET_PATTERNS:
        return getTargetPatterns();
      case TggPackage.RULE__CORRESPONDENCE_PATTERNS:
        return getCorrespondencePatterns();
      case TggPackage.RULE__ATTR_CONDITIONS:
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
      case TggPackage.RULE__ABSTRACT_RULE:
        setAbstractRule((Boolean)newValue);
        return;
      case TggPackage.RULE__SUPERTYPES:
        getSupertypes().clear();
        getSupertypes().addAll((Collection<? extends Rule>)newValue);
        return;
      case TggPackage.RULE__SCHEMA:
        setSchema((Schema)newValue);
        return;
      case TggPackage.RULE__SOURCE_PATTERNS:
        getSourcePatterns().clear();
        getSourcePatterns().addAll((Collection<? extends ObjectVariablePattern>)newValue);
        return;
      case TggPackage.RULE__TARGET_PATTERNS:
        getTargetPatterns().clear();
        getTargetPatterns().addAll((Collection<? extends ObjectVariablePattern>)newValue);
        return;
      case TggPackage.RULE__CORRESPONDENCE_PATTERNS:
        getCorrespondencePatterns().clear();
        getCorrespondencePatterns().addAll((Collection<? extends CorrVariablePattern>)newValue);
        return;
      case TggPackage.RULE__ATTR_CONDITIONS:
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
      case TggPackage.RULE__ABSTRACT_RULE:
        setAbstractRule(ABSTRACT_RULE_EDEFAULT);
        return;
      case TggPackage.RULE__SUPERTYPES:
        getSupertypes().clear();
        return;
      case TggPackage.RULE__SCHEMA:
        setSchema((Schema)null);
        return;
      case TggPackage.RULE__SOURCE_PATTERNS:
        getSourcePatterns().clear();
        return;
      case TggPackage.RULE__TARGET_PATTERNS:
        getTargetPatterns().clear();
        return;
      case TggPackage.RULE__CORRESPONDENCE_PATTERNS:
        getCorrespondencePatterns().clear();
        return;
      case TggPackage.RULE__ATTR_CONDITIONS:
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
      case TggPackage.RULE__ABSTRACT_RULE:
        return abstractRule != ABSTRACT_RULE_EDEFAULT;
      case TggPackage.RULE__SUPERTYPES:
        return supertypes != null && !supertypes.isEmpty();
      case TggPackage.RULE__SCHEMA:
        return schema != null;
      case TggPackage.RULE__SOURCE_PATTERNS:
        return sourcePatterns != null && !sourcePatterns.isEmpty();
      case TggPackage.RULE__TARGET_PATTERNS:
        return targetPatterns != null && !targetPatterns.isEmpty();
      case TggPackage.RULE__CORRESPONDENCE_PATTERNS:
        return correspondencePatterns != null && !correspondencePatterns.isEmpty();
      case TggPackage.RULE__ATTR_CONDITIONS:
        return attrConditions != null && !attrConditions.isEmpty();
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
    result.append(" (abstractRule: ");
    result.append(abstractRule);
    result.append(')');
    return result.toString();
  }

} //RuleImpl