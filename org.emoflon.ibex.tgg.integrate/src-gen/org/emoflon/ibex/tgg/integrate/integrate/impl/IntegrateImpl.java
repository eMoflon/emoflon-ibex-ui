/**
 * generated by Xtext 2.25.0
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
import org.emoflon.ibex.tgg.integrate.integrate.Import;
import org.emoflon.ibex.tgg.integrate.integrate.Integrate;
import org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integrate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.IntegrateImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.IntegrateImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.impl.IntegrateImpl#getConflictResolutionSpecifications <em>Conflict Resolution Specifications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrateImpl extends MinimalEObjectImpl.Container implements Integrate
{
  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected org.emoflon.ibex.tgg.integrate.integrate.Package package_;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getConflictResolutionSpecifications() <em>Conflict Resolution Specifications</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConflictResolutionSpecifications()
   * @generated
   * @ordered
   */
  protected EList<ConflictResolutionSpecification> conflictResolutionSpecifications;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrateImpl()
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
    return IntegratePackage.Literals.INTEGRATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public org.emoflon.ibex.tgg.integrate.integrate.Package getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(org.emoflon.ibex.tgg.integrate.integrate.Package newPackage, NotificationChain msgs)
  {
    org.emoflon.ibex.tgg.integrate.integrate.Package oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntegratePackage.INTEGRATE__PACKAGE, oldPackage, newPackage);
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
  public void setPackage(org.emoflon.ibex.tgg.integrate.integrate.Package newPackage)
  {
    if (newPackage != package_)
    {
      NotificationChain msgs = null;
      if (package_ != null)
        msgs = ((InternalEObject)package_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.INTEGRATE__PACKAGE, null, msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntegratePackage.INTEGRATE__PACKAGE, null, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IntegratePackage.INTEGRATE__PACKAGE, newPackage, newPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, IntegratePackage.INTEGRATE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ConflictResolutionSpecification> getConflictResolutionSpecifications()
  {
    if (conflictResolutionSpecifications == null)
    {
      conflictResolutionSpecifications = new EObjectContainmentEList<ConflictResolutionSpecification>(ConflictResolutionSpecification.class, this, IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS);
    }
    return conflictResolutionSpecifications;
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
      case IntegratePackage.INTEGRATE__PACKAGE:
        return basicSetPackage(null, msgs);
      case IntegratePackage.INTEGRATE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS:
        return ((InternalEList<?>)getConflictResolutionSpecifications()).basicRemove(otherEnd, msgs);
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
      case IntegratePackage.INTEGRATE__PACKAGE:
        return getPackage();
      case IntegratePackage.INTEGRATE__IMPORTS:
        return getImports();
      case IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS:
        return getConflictResolutionSpecifications();
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
      case IntegratePackage.INTEGRATE__PACKAGE:
        setPackage((org.emoflon.ibex.tgg.integrate.integrate.Package)newValue);
        return;
      case IntegratePackage.INTEGRATE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS:
        getConflictResolutionSpecifications().clear();
        getConflictResolutionSpecifications().addAll((Collection<? extends ConflictResolutionSpecification>)newValue);
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
      case IntegratePackage.INTEGRATE__PACKAGE:
        setPackage((org.emoflon.ibex.tgg.integrate.integrate.Package)null);
        return;
      case IntegratePackage.INTEGRATE__IMPORTS:
        getImports().clear();
        return;
      case IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS:
        getConflictResolutionSpecifications().clear();
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
      case IntegratePackage.INTEGRATE__PACKAGE:
        return package_ != null;
      case IntegratePackage.INTEGRATE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case IntegratePackage.INTEGRATE__CONFLICT_RESOLUTION_SPECIFICATIONS:
        return conflictResolutionSpecifications != null && !conflictResolutionSpecifications.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IntegrateImpl