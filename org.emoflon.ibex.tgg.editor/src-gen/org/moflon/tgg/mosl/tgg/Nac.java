/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nac</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Nac#getRule <em>Rule</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Nac#getSourcePatterns <em>Source Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Nac#getTargetPatterns <em>Target Patterns</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Nac#getAttrConditions <em>Attr Conditions</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getNac()
 * @model
 * @generated
 */
public interface Nac extends NamedElements
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' reference.
   * @see #setRule(Rule)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getNac_Rule()
   * @model
   * @generated
   */
  Rule getRule();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.Nac#getRule <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' reference.
   * @see #getRule()
   * @generated
   */
  void setRule(Rule value);

  /**
   * Returns the value of the '<em><b>Source Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getNac_SourcePatterns()
   * @model containment="true"
   * @generated
   */
  EList<ContextObjectVariablePattern> getSourcePatterns();

  /**
   * Returns the value of the '<em><b>Target Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getNac_TargetPatterns()
   * @model containment="true"
   * @generated
   */
  EList<ContextObjectVariablePattern> getTargetPatterns();

  /**
   * Returns the value of the '<em><b>Attr Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttrCond}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr Conditions</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getNac_AttrConditions()
   * @model containment="true"
   * @generated
   */
  EList<AttrCond> getAttrConditions();

} // Nac
