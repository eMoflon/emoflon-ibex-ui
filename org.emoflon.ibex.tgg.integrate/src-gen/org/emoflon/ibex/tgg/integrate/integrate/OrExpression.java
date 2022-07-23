/**
 * generated by Xtext 2.26.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.OrExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.OrExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOrExpression()
 * @model
 * @generated
 */
public interface OrExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOrExpression_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.OrExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference list.
   * The list contents are of type {@link org.emoflon.ibex.tgg.integrate.integrate.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference list.
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getOrExpression_Right()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getRight();

} // OrExpression
