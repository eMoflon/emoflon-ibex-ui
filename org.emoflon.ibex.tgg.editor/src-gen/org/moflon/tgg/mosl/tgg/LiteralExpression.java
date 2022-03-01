/**
 */
package org.moflon.tgg.mosl.tgg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.LiteralExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getLiteralExpression()
 * @model
 * @generated
 */
public interface LiteralExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getLiteralExpression_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.LiteralExpression#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // LiteralExpression
