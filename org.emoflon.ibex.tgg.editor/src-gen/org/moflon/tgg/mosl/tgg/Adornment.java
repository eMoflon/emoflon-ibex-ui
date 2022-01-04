/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adornment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Adornment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAdornment()
 * @model
 * @generated
 */
public interface Adornment extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAdornment_Value()
   * @model unique="false"
   * @generated
   */
  EList<String> getValue();

} // Adornment
