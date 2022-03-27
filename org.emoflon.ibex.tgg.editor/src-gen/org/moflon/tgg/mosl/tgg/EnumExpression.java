/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.EnumExpression#getEenum <em>Eenum</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.EnumExpression#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getEnumExpression()
 * @model
 * @generated
 */
public interface EnumExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Eenum</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Eenum</em>' reference.
   * @see #setEenum(EEnum)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getEnumExpression_Eenum()
   * @model
   * @generated
   */
  EEnum getEenum();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.EnumExpression#getEenum <em>Eenum</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Eenum</em>' reference.
   * @see #getEenum()
   * @generated
   */
  void setEenum(EEnum value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' reference.
   * @see #setLiteral(EEnumLiteral)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getEnumExpression_Literal()
   * @model
   * @generated
   */
  EEnumLiteral getLiteral();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.EnumExpression#getLiteral <em>Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(EEnumLiteral value);

} // EnumExpression