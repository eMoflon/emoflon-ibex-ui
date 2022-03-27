/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.VariableReference#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends ComparisonParameter
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Variable)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getVariableReference_Ref()
   * @model
   * @generated
   */
  Variable getRef();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.VariableReference#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Variable value);

} // VariableReference