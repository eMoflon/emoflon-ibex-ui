/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.tgg.integrate.integrate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Stage Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType#getTypes <em>Types</em>}</li>
 *   <li>{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipelineStageType()
 * @model
 * @generated
 */
public interface PipelineStageType extends PipelineStageFilter
{
  /**
   * Returns the value of the '<em><b>Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' reference list.
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipelineStageType_Types()
   * @model
   * @generated
   */
  EList<EClass> getTypes();

  /**
   * Returns the value of the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next</em>' containment reference.
   * @see #setNext(PipelineStageEnd)
   * @see org.emoflon.ibex.tgg.integrate.integrate.IntegratePackage#getPipelineStageType_Next()
   * @model containment="true"
   * @generated
   */
  PipelineStageEnd getNext();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType#getNext <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next</em>' containment reference.
   * @see #getNext()
   * @generated
   */
  void setNext(PipelineStageEnd value);

} // PipelineStageType