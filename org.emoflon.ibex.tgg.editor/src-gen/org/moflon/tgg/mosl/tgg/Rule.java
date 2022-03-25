/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#isAbstractRule <em>Abstract Rule</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getSourcePatterns <em>Source Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getTargetPatterns <em>Target Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getCorrespondencePatterns <em>Correspondence Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Rule#getAttrConditions <em>Attr Conditions</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends NamedElements
{
  /**
   * Returns the value of the '<em><b>Abstract Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Rule</em>' attribute.
   * @see #setAbstractRule(boolean)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_AbstractRule()
   * @model
   * @generated
   */
  boolean isAbstractRule();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.Rule#isAbstractRule <em>Abstract Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract Rule</em>' attribute.
   * @see #isAbstractRule()
   * @generated
   */
  void setAbstractRule(boolean value);

  /**
   * Returns the value of the '<em><b>Supertypes</b></em>' reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Rule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supertypes</em>' reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_Supertypes()
   * @model
   * @generated
   */
  EList<Rule> getSupertypes();

  /**
   * Returns the value of the '<em><b>Schema</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema</em>' reference.
   * @see #setSchema(Schema)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_Schema()
   * @model
   * @generated
   */
  Schema getSchema();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.Rule#getSchema <em>Schema</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema</em>' reference.
   * @see #getSchema()
   * @generated
   */
  void setSchema(Schema value);

  /**
   * Returns the value of the '<em><b>Source Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_SourcePatterns()
   * @model containment="true"
   * @generated
   */
  EList<ObjectVariablePattern> getSourcePatterns();

  /**
   * Returns the value of the '<em><b>Target Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_TargetPatterns()
   * @model containment="true"
   * @generated
   */
  EList<ObjectVariablePattern> getTargetPatterns();

  /**
   * Returns the value of the '<em><b>Correspondence Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.CorrVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correspondence Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_CorrespondencePatterns()
   * @model containment="true"
   * @generated
   */
  EList<CorrVariablePattern> getCorrespondencePatterns();

  /**
   * Returns the value of the '<em><b>Attr Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttrCond}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr Conditions</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getRule_AttrConditions()
   * @model containment="true"
   * @generated
   */
  EList<AttrCond> getAttrConditions();

} // Rule
