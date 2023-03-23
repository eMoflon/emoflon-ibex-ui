/**
 * generated by Xtext 2.28.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operational Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOperationalDelta()
 * @model
 * @generated
 */
public interface OperationalDelta extends EObject
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.emoflon.ibex.tgg.integrate.integrate.Variable}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOperationalDelta_Variables()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getVariables();

  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(SatisfactionRule)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOperationalDelta_Rule()
   * @model containment="true"
   * @generated
   */
  SatisfactionRule getRule();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.OperationalDelta#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(SatisfactionRule value);

} // OperationalDelta
