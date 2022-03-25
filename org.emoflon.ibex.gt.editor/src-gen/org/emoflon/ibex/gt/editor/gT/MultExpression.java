/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.gT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mult Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getMultOperator <em>Mult Operator</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getMultExpression()
 * @model
 * @generated
 */
public interface MultExpression extends ArithmeticExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ArithmeticExpression)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getMultExpression_Left()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getLeft();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArithmeticExpression value);

  /**
   * Returns the value of the '<em><b>Mult Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.emoflon.ibex.gt.editor.gT.MultOperator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mult Operator</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.MultOperator
   * @see #setMultOperator(MultOperator)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getMultExpression_MultOperator()
   * @model
   * @generated
   */
  MultOperator getMultOperator();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getMultOperator <em>Mult Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mult Operator</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.MultOperator
   * @see #getMultOperator()
   * @generated
   */
  void setMultOperator(MultOperator value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(ArithmeticExpression)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getMultExpression_Right()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getRight();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.MultExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(ArithmeticExpression value);

} // MultExpression
