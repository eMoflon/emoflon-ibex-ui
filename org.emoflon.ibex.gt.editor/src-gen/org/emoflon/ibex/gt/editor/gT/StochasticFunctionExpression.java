/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stochastic Function Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getOperatorRange <em>Operator Range</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getMean <em>Mean</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#isHasSd <em>Has Sd</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getSd <em>Sd</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression()
 * @model
 * @generated
 */
public interface StochasticFunctionExpression extends EditorExpression
{
  /**
   * Returns the value of the '<em><b>Operator Range</b></em>' attribute.
   * The literals are from the enumeration {@link org.emoflon.ibex.gt.editor.gT.PossibleStochasticRanges}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator Range</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.PossibleStochasticRanges
   * @see #setOperatorRange(PossibleStochasticRanges)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression_OperatorRange()
   * @model
   * @generated
   */
  PossibleStochasticRanges getOperatorRange();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getOperatorRange <em>Operator Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator Range</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.PossibleStochasticRanges
   * @see #getOperatorRange()
   * @generated
   */
  void setOperatorRange(PossibleStochasticRanges value);

  /**
   * Returns the value of the '<em><b>Distribution</b></em>' attribute.
   * The literals are from the enumeration {@link org.emoflon.ibex.gt.editor.gT.StochasticDistribution}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Distribution</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.StochasticDistribution
   * @see #setDistribution(StochasticDistribution)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression_Distribution()
   * @model
   * @generated
   */
  StochasticDistribution getDistribution();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getDistribution <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Distribution</em>' attribute.
   * @see org.emoflon.ibex.gt.editor.gT.StochasticDistribution
   * @see #getDistribution()
   * @generated
   */
  void setDistribution(StochasticDistribution value);

  /**
   * Returns the value of the '<em><b>Mean</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mean</em>' containment reference.
   * @see #setMean(ArithmeticExpression)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression_Mean()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getMean();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getMean <em>Mean</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mean</em>' containment reference.
   * @see #getMean()
   * @generated
   */
  void setMean(ArithmeticExpression value);

  /**
   * Returns the value of the '<em><b>Has Sd</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Sd</em>' attribute.
   * @see #setHasSd(boolean)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression_HasSd()
   * @model
   * @generated
   */
  boolean isHasSd();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#isHasSd <em>Has Sd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Sd</em>' attribute.
   * @see #isHasSd()
   * @generated
   */
  void setHasSd(boolean value);

  /**
   * Returns the value of the '<em><b>Sd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sd</em>' containment reference.
   * @see #setSd(ArithmeticExpression)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getStochasticFunctionExpression_Sd()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getSd();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.StochasticFunctionExpression#getSd <em>Sd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sd</em>' containment reference.
   * @see #getSd()
   * @generated
   */
  void setSd(ArithmeticExpression value);

} // StochasticFunctionExpression
