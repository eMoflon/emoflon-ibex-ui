/**
 * generated by Xtext 2.33.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression#isInvert <em>Invert</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getBooleanExpression()
 * @model
 * @generated
 */
public interface BooleanExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Invert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invert</em>' attribute.
   * @see #setInvert(boolean)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getBooleanExpression_Invert()
   * @model
   * @generated
   */
  boolean isInvert();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression#isInvert <em>Invert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invert</em>' attribute.
   * @see #isInvert()
   * @generated
   */
  void setInvert(boolean value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(EObject)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getBooleanExpression_Expression()
   * @model containment="true"
   * @generated
   */
  EObject getExpression();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.BooleanExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(EObject value);

} // BooleanExpression
