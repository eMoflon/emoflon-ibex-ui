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

import org.moflon.tgg.mosl.tgg.AttrCondDefLibrary;
import org.moflon.tgg.mosl.tgg.Import;
import org.moflon.tgg.mosl.tgg.Rule;
import org.moflon.tgg.mosl.tgg.Schema;
import org.moflon.tgg.mosl.tgg.TggPackage;
import org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile;
import org.moflon.tgg.mosl.tgg.Using;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Triple Graph Grammar File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl#getUsing <em>Using</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl#getLibrary <em>Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TripleGraphGrammarFileImpl extends MinimalEObjectImpl.Container implements TripleGraphGrammarFile
{
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
   * The cached value of the '{@link #getUsing() <em>Using</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsing()
   * @generated
   * @ordered
   */
  protected EList<Using> using;

  /**
   * The cached value of the '{@link #getSchema() <em>Schema</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSchema()
   * @generated
   * @ordered
   */
  protected Schema schema;

  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<Rule> rules;

  /**
   * The cached value of the '{@link #getLibrary() <em>Library</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLibrary()
   * @generated
   * @ordered
   */
  protected AttrCondDefLibrary library;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TripleGraphGrammarFileImpl()
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
    return TggPackage.Literals.TRIPLE_GRAPH_GRAMMAR_FILE;
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
      imports = new EObjectContainmentEList<Import>(Import.class, this, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Using> getUsing()
  {
    if (using == null)
    {
      using = new EObjectContainmentEList<Using>(Using.class, this, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING);
    }
    return using;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Schema getSchema()
  {
    return schema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSchema(Schema newSchema, NotificationChain msgs)
  {
    Schema oldSchema = schema;
    schema = newSchema;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA, oldSchema, newSchema);
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
  public void setSchema(Schema newSchema)
  {
    if (newSchema != schema)
    {
      NotificationChain msgs = null;
      if (schema != null)
        msgs = ((InternalEObject)schema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA, null, msgs);
      if (newSchema != null)
        msgs = ((InternalEObject)newSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA, null, msgs);
      msgs = basicSetSchema(newSchema, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA, newSchema, newSchema));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Rule> getRules()
  {
    if (rules == null)
    {
      rules = new EObjectContainmentEList<Rule>(Rule.class, this, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES);
    }
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrCondDefLibrary getLibrary()
  {
    return library;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLibrary(AttrCondDefLibrary newLibrary, NotificationChain msgs)
  {
    AttrCondDefLibrary oldLibrary = library;
    library = newLibrary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY, oldLibrary, newLibrary);
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
  public void setLibrary(AttrCondDefLibrary newLibrary)
  {
    if (newLibrary != library)
    {
      NotificationChain msgs = null;
      if (library != null)
        msgs = ((InternalEObject)library).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY, null, msgs);
      if (newLibrary != null)
        msgs = ((InternalEObject)newLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY, null, msgs);
      msgs = basicSetLibrary(newLibrary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY, newLibrary, newLibrary));
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING:
        return ((InternalEList<?>)getUsing()).basicRemove(otherEnd, msgs);
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA:
        return basicSetSchema(null, msgs);
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY:
        return basicSetLibrary(null, msgs);
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS:
        return getImports();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING:
        return getUsing();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA:
        return getSchema();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES:
        return getRules();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY:
        return getLibrary();
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING:
        getUsing().clear();
        getUsing().addAll((Collection<? extends Using>)newValue);
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA:
        setSchema((Schema)newValue);
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends Rule>)newValue);
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY:
        setLibrary((AttrCondDefLibrary)newValue);
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS:
        getImports().clear();
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING:
        getUsing().clear();
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA:
        setSchema((Schema)null);
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES:
        getRules().clear();
        return;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY:
        setLibrary((AttrCondDefLibrary)null);
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
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__USING:
        return using != null && !using.isEmpty();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA:
        return schema != null;
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__RULES:
        return rules != null && !rules.isEmpty();
      case TggPackage.TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY:
        return library != null;
    }
    return super.eIsSet(featureID);
  }

} //TripleGraphGrammarFileImpl
