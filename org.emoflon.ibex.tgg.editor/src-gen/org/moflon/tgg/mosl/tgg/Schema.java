/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Schema#getSourceTypes <em>Source Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Schema#getTargetTypes <em>Target Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Schema#getCorrespondenceTypes <em>Correspondence Types</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.Schema#getAttributeCondDefs <em>Attribute Cond Defs</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends NamedElements
{
  /**
   * Returns the value of the '<em><b>Source Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Types</em>' reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getSchema_SourceTypes()
   * @model
   * @generated
   */
  EList<EPackage> getSourceTypes();

  /**
   * Returns the value of the '<em><b>Target Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Types</em>' reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getSchema_TargetTypes()
   * @model
   * @generated
   */
  EList<EPackage> getTargetTypes();

  /**
   * Returns the value of the '<em><b>Correspondence Types</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.CorrType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correspondence Types</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getSchema_CorrespondenceTypes()
   * @model containment="true"
   * @generated
   */
  EList<CorrType> getCorrespondenceTypes();

  /**
   * Returns the value of the '<em><b>Attribute Cond Defs</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttrCondDef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Cond Defs</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getSchema_AttributeCondDefs()
   * @model containment="true"
   * @generated
   */
  EList<AttrCondDef> getAttributeCondDefs();

} // Schema
