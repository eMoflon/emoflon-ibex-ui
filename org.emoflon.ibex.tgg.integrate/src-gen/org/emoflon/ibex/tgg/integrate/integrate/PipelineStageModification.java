/**
 * generated by Xtext 2.28.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Stage Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageModification#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipelineStageModification()
 * @model
 * @generated
 */
public interface PipelineStageModification extends PipelineStageFilter
{
  /**
   * Returns the value of the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next</em>' containment reference.
   * @see #setNext(EObject)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipelineStageModification_Next()
   * @model containment="true"
   * @generated
   */
  EObject getNext();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageModification#getNext <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next</em>' containment reference.
   * @see #getNext()
   * @generated
   */
  void setNext(EObject value);

} // PipelineStageModification
