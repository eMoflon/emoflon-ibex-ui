/**
 * generated by Xtext 2.28.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.Pipeline#getStart <em>Start</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipeline()
 * @model
 * @generated
 */
public interface Pipeline extends EObject
{
  /**
   * Returns the value of the '<em><b>Start</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' containment reference.
   * @see #setStart(PipelineStageStart)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipeline_Start()
   * @model containment="true"
   * @generated
   */
  PipelineStageStart getStart();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.Pipeline#getStart <em>Start</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' containment reference.
   * @see #getStart()
   * @generated
   */
  void setStart(PipelineStageStart value);

} // Pipeline
